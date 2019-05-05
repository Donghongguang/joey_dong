package com.dancer.service.xml;

import com.dancer.dao.mapper.TLessontypeMapper;
import com.dancer.entity.TLessontype;
import com.dancer.service.LessonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonTypeServiceImpl implements LessonTypeService {

    @Autowired
    private TLessontypeMapper lessontypeMapper;
    @Override
    public List<TLessontype> getAllLessonType() {
        return lessontypeMapper.selectAll();
    }
}
