package com.dancer.controller;

import com.dancer.entity.TAdmin;
import com.dancer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/AllAdmin",method = RequestMethod.GET)
    @ResponseBody
    public List<TAdmin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    /**
     * 编辑admin的基本信息
     * 董红广
     * 2019-03-25
     */
    @RequestMapping(value = "/editAdmin",method = RequestMethod.GET)
    @ResponseBody
    public int editAdmin(HttpServletRequest request, HttpSession session){
        TAdmin admin=adminService.getAdminById((Integer) session.getAttribute("adminId"));
        admin.setAdminname(request.getParameter("adminname"));
        admin.setPassword(request.getParameter("password"));
        admin.setRealname(request.getParameter("realname"));
        admin.setAddress(request.getParameter("address"));
        admin.setTelephone(request.getParameter("telephone"));
        admin.setSex(request.getParameter("sex"));
        admin.setAge(Integer.valueOf(request.getParameter("age")));
        System.out.println(admin.getPassword());

        return adminService.updateAdmin(admin);
    }
    /**
     * 添加一条管理员的基本信息
     * 董红广
     * 2019-04-11
     */
    @RequestMapping(value = "/insertAdmin",method = RequestMethod.GET)
    @ResponseBody
    public int insertAdminUserInfo(HttpServletRequest request){
        TAdmin admin=new TAdmin();
        admin.setAdminname(request.getParameter("adminname"));
        admin.setPassword(request.getParameter("password"));
        admin.setRealname(request.getParameter("realname"));
        admin.setRoleid(2);//管理员
        admin.setAge(Integer.valueOf(request.getParameter("age")));
        admin.setSex(request.getParameter("sex"));
        admin.setTelephone(request.getParameter("telephone"));
        admin.setAddress(request.getParameter("address"));
        return adminService.insertAdmin(admin);
    }
}
