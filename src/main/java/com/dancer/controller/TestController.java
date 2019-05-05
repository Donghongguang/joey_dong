package com.dancer.controller;

import com.dancer.entity.TUserinfo;
import com.dancer.service.TestJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {
    @Autowired
    private TestJDBC testJDBC;



    @RequestMapping(value = "/test")
    @ResponseBody
    public TUserinfo getUserById(Integer userId){
        System.out.println("sssssssssssssssssssssssssssss");
        return testJDBC.selectById(userId);
    }
}
