package com.dancer.service.xml;

import com.dancer.dao.mapper.TLessonMapper;
import com.dancer.entity.TLesson;
import com.dancer.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private TLessonMapper lessonMapper;



    @Override
    public TLesson addLesson(TLesson lesson) {
         lessonMapper.insert(lesson);
         return lesson;
    }



    @Override
    public int deleteLesson(String lessonId) {
        return lessonMapper.deleteByPrimaryKey(lessonId);
    }

    @Override
    public List<TLesson> getAllLesson() {
        return lessonMapper.selectAllLesson();
    }

    @Override
    public TLesson getLessonById(String lessonId) {
        return lessonMapper.selectByPrimaryKey(lessonId);
    }

    @Override
    public int updateLesson(TLesson lesson) {
        return lessonMapper.updateByPrimaryKey(lesson);
    }
}
