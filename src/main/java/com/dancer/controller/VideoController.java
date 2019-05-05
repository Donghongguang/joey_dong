package com.dancer.controller;

import com.dancer.entity.TAdminLesson;
import com.dancer.entity.TLesson;
import com.dancer.entity.TUserLesson;
import com.dancer.entity.TUserinfo;
import com.dancer.service.LessonService;


import com.dancer.service.TAdminLessonService;
import com.dancer.service.TUserLessonService;
import com.dancer.service.UserInfoService;
import com.dancer.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 上传视频
 * 董红广
 * 2019-03-27
 */
@Controller
public class VideoController {

    @Autowired
    LessonService lessonService;
    @Autowired
    TAdminLessonService tAdminLessonService;
    @Autowired
    TUserLessonService userLessonService;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public int getFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] file) throws IOException {
        if (file != null && file.length > 0) {

            String typeid = request.getSession().getAttribute("typeid").toString();
            System.out.print(typeid);
            String userID = request.getSession().getAttribute("userId").toString();
            System.out.println(userID);
            String roleId = (String) request.getSession().getAttribute("roleId");
            System.out.println(roleId);

            List<String> fileName = new ArrayList<String>();
            for (int i = 0; i < file.length; i++) {

                fileName.add(file[i].getOriginalFilename());
            }


            for (int i = 0; i < file.length; i++) {
                String filesrc = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/uploadvideo/" + file[i].getOriginalFilename();
                System.out.println(filesrc);
                String lessonId = GenerateID.getID();
                System.out.println(lessonId);
//                File newfile = new File(path, file[i].getOriginalFilename());
//                if (!newfile.exists()) {
//                    newfile.mkdirs();
//                }

                file[i].transferTo(new File("C:\\Users\\董红广\\Desktop\\SweetDancer\\src\\main\\webapp\\uploadvideo", file[i].getOriginalFilename()));
                TLesson lesson = new TLesson();
                lesson.setLessonname(file[i].getOriginalFilename());
                lesson.setLessontypeid(Integer.valueOf(typeid));
                lesson.setLessontime(new Date());
                lesson.setLessonurl(filesrc);
                lesson.setLessonstatus(0);
                lesson.setLessonprice((float) 10);
                lesson.setLessonid(lessonId);
                lessonService.addLesson(lesson);

                if (Integer.valueOf(roleId) == 2) {
                    TAdminLesson adminLesson = new TAdminLesson();
                    adminLesson.setAdminid(Integer.valueOf(userID));
                    adminLesson.setAdminaction(0);
                    adminLesson.setLessonid(lessonId);
                    tAdminLessonService.addAdminLesson(adminLesson);
                }
                if (Integer.valueOf(roleId) == 1) {
                    TUserLesson userLesson = new TUserLesson();
                    userLesson.setLessonid(lessonId);
                    userLesson.setUseraction(0);
                    userLesson.setUserid(Integer.valueOf(userID));
                    userLessonService.addTUserLesson(userLesson);
                }


            }


        }

        return 0;
    }

    /*
     *获取视频类型
     * 董红广
     * 2019-04-15
     */
    @RequestMapping(value = "/getTypeId", method = RequestMethod.GET)
    @ResponseBody
    public int getAudioId(HttpServletRequest request) {
        System.out.println(request.getParameter("lessonTypeId"));
        if (request.getParameter("lessonTypeId") != null) {
            request.getSession().setAttribute("typeid", request.getParameter("lessonTypeId"));
            return 0;//表示成功
        } else {
            return 1;
        }
    }

    /**
     * 分页显示vedio
     * 董红广
     * 2019-04-25
     */
    @RequestMapping(value = "/getAllvideo", method = RequestMethod.GET)
    @ResponseBody
    public List<TLesson> getAllLesson() {
        List<TLesson> lessonList = lessonService.getAllLesson();
       List<TLesson> agreeList=new ArrayList<TLesson>();
       for(TLesson lesson:lessonList){
           if(lesson.getLessonstatus()==1){
               agreeList.add(lesson);
           }
       }
        return agreeList;
    }

    /**
     * 购买视频
     * 董红广
     * 2019-05-04
     */
    @RequestMapping(value = "/buyAudio", method = RequestMethod.GET)
    @ResponseBody
    public int buyAudio(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        TUserinfo userinfo = userInfoService.getUserInfoById(userId);
        if (userinfo.getAccountmoney() > 10) {
            Float monney = userinfo.getAccountmoney() - 10;
            userinfo.setAccountmoney(monney);//每个视频十块钱
            Float score = userinfo.getScore() + 10;
            userinfo.setScore(score);//每购买一个视频增加十积分
            userInfoService.updateUserInfo(userinfo);
            String lessonId = request.getParameter("lessonId");
            TUserLesson userLesson = new TUserLesson();
            userLesson.setLessonid(lessonId);
            userLesson.setUserid(userId);
            userLesson.setUseraction(1);
            return userLessonService.addTUserLesson(userLesson);
        } else {
            return 0;
        }


    }

    /**
     * 我的视频显示
     * 董红广
     * 2019-05-04
     */
    @RequestMapping(value = "/getMyAudio", method = RequestMethod.GET)
    @ResponseBody
    public List<TLesson> getMyAudio(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        String roleId = (String) request.getSession().getAttribute("roleId");
        List<TLesson> lessonList = new ArrayList<TLesson>();
        if ("1".equals(roleId)) {
            lessonList.clear();
            List<TUserLesson> userLessonList = userLessonService.getUSerLesson(userId);
            for (TUserLesson tuserlesson : userLessonList) {
                TLesson lesson = lessonService.getLessonById(tuserlesson.getLessonid());
                lessonList.add(lesson);
            }

        } else {
            lessonList.clear();
            List<TAdminLesson> adminLessonList = tAdminLessonService.getAdminLesson(userId);
            for (TAdminLesson adminLesson : adminLessonList) {
                TLesson lesson = lessonService.getLessonById(adminLesson.getLessonid());
                lessonList.add(lesson);
            }
        }
        System.out.println(lessonList.size());
        return lessonList;
    }
    /**
     * 返回待审核的视频
     * 董红广
     * 2019-05-04
     */
    @RequestMapping(value = "/needCheck", method = RequestMethod.GET)
    @ResponseBody
    public List<TLesson> needCheck(HttpServletRequest request){
       List<TLesson> lessonList=lessonService.getAllLesson();
       List<TLesson> needCheckList=new ArrayList<TLesson>();
       for(TLesson lesson:lessonList){
           if(lesson.getLessonstatus()==0){
               needCheckList.add(lesson);
           }
       }
       return  needCheckList;
    }
    /**
     * 审核视频
     * 董红广
     * 2019-05-04
     */
    @RequestMapping(value = "/agree",method = RequestMethod.GET)
    @ResponseBody
    public int agree(HttpServletRequest request){
        String lessonId=request.getParameter("lessonId");
        TLesson lesson=lessonService.getLessonById(lessonId);
        lesson.setLessonstatus(1);
        return lessonService.updateLesson(lesson);
    }
    /**
     * 审核视频不通过
     * 董红广
     * 2019-05-04
     */
    @RequestMapping(value = "/disagree",method = RequestMethod.GET)
    @ResponseBody
    public int disagree(HttpServletRequest request){
        String lessonId=request.getParameter("lessonId");
        TLesson lesson=lessonService.getLessonById(lessonId);
        lesson.setLessonstatus(2);
        return lessonService.updateLesson(lesson);
    }
}