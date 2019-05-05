package com.dancer.controller;

import com.dancer.entity.TLessontype;
import com.dancer.service.LessonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private LessonTypeService lessonTypeService;

    @RequestMapping(value="/getAllType",method = RequestMethod.GET)
    @ResponseBody
    public List<TLessontype> getAllType(){
        return lessonTypeService.getAllLessonType();
    }
}
