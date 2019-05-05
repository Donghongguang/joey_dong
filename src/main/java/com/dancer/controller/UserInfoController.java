package com.dancer.controller;

import com.dancer.entity.TAdmin;
import com.dancer.entity.TUserinfo;
import com.dancer.service.AdminService;
import com.dancer.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    @ResponseBody
    public int addUser(HttpServletRequest request) {
        int b = 0;//用来表示登陆的状态，0表示登陆成功，1表示没有此人，2表示密码错误。
        List<TUserinfo> userinfoList = userInfoService.getAllUserInfo();
        List<TAdmin> adminList = adminService.getAllAdmin();
        String roleId = request.getParameter("type");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (Integer.valueOf(roleId) == 1) {
            for (TUserinfo userinfo : userinfoList) {
                if (userinfo.getUsername().equals(userName)) {
                    if (userinfo.getPassword().equals(password)) {
                        b = 1;
                       request.getSession().setAttribute("userId", userinfo.getUserid());
                        System.out.println(userinfo.getUserid());
                    } else {
                        b = 2;
                    }
                }
            }

        } else if (Integer.valueOf(roleId) == 2) {
            for (TAdmin admin : adminList) {
                if (admin.getAdminname().equals(userName)) {
                    if (admin.getPassword().equals(password)) {
                        b = 1;
                        request.getSession().setAttribute("userId", admin.getAdminid());
                    } else {
                        b = 2;
                    }
                }
            }
        }
        if (b == 1) {
            request.getSession().setAttribute("roleId", roleId);

            request.getSession().setAttribute("username", userName);
        }
        return b;
    }

    /**
     * 返回所有的user info信息
     * 董红广
     * 2019-03-21
     *
     * @return
     */
    @RequestMapping(value = "/allUSer", method = RequestMethod.GET)
    @ResponseBody
    public List<TUserinfo> returnAllUser() {
        return userInfoService.getAllUserInfo();
    }

    /**
     * 添加用户基本信息
     * 董红广
     * 2019-03-22
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public int insertUserInfo(HttpServletRequest request) {
        TUserinfo userinfo = new TUserinfo();
        userinfo.setUsername(request.getParameter("username"));
        userinfo.setPassword(request.getParameter("password"));
        userinfo.setRealname(request.getParameter("realname"));
        userinfo.setAge(request.getParameter("age"));
        userinfo.setSex(request.getParameter("sex"));
        userinfo.setRoleid(1);
        userinfo.setAddress(request.getParameter("address"));
        userinfo.setTelephone(request.getParameter("telephone"));
        return userInfoService.insertUserInfo(userinfo);
    }

    /**
     * 谁删除用户基本信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public int deleteUserInfo(HttpServletRequest request) {
        int userid = Integer.valueOf(request.getParameter("userid"));
        return userInfoService.deleteUserInfo(userid);
    }

    /**
     * 编辑用户基本信息
     * 董红广
     * 2019-03-25
     */
    @RequestMapping(value = "/editUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public int editUserInfo(HttpServletRequest request) {
        TUserinfo userinfo = userInfoService.getUserInfoById((Integer) request.getSession().getAttribute("userId"));


        userinfo.setUsername(request.getParameter("username"));
        userinfo.setPassword(request.getParameter("password"));
        userinfo.setRealname(request.getParameter("realname"));
        userinfo.setAge(request.getParameter("age"));
        userinfo.setSex(request.getParameter("sex"));
        userinfo.setAddress(request.getParameter("address"));
        userinfo.setTelephone(request.getParameter("telephone"));
        System.out.println(userinfo.getUsername());
        return userInfoService.updateUserInfo(userinfo);
    }

    /**
     * 返回要编辑的userIfo
     * 董红广
     * 2019-03-25
     */
    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<Integer, Object> modifyUserInfo(HttpServletRequest request) {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        String username = (String) request.getSession().getAttribute("username");
        String roleId = (String) request.getSession().getAttribute("roleId");
        if ("1".equals(roleId))
            map.put(Integer.valueOf(roleId), userInfoService.getByName(username));
        else {
            map.clear();
            map.put(Integer.valueOf(roleId), adminService.getByName(username));
        }

        return map;
    }

    /**
     * 返回roleID
     * 董红广
     * 2019-03-25
     */
    @RequestMapping(value = "/returnRoleId", method = RequestMethod.GET)
    @ResponseBody
    public String getRoleId(HttpSession session) {
        return (String) session.getAttribute("roleId");
    }

    /**
     * 账户充值
     * 董红广
     * 2019-04-08
     */
    @RequestMapping(value = "/rechargeMoney",method = RequestMethod.GET)
    @ResponseBody
    public int chargeMoney(HttpServletRequest request){

        Integer userid=Integer.valueOf(request.getParameter("userid"));
        Float money=Float.valueOf(request.getParameter("money"));
        TUserinfo userinfo=userInfoService.getUserInfoById(userid);
        Float accountMoney=userinfo.getAccountmoney()+money;
        userinfo.setAccountmoney(accountMoney);

        return userInfoService.updateUserInfo(userinfo);
    }
}
