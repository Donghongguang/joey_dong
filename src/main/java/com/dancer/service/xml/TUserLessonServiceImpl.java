package com.dancer.service.xml;

import com.dancer.dao.mapper.TUserLessonMapper;
import com.dancer.entity.TUserLesson;
import com.dancer.service.TUserLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserLessonServiceImpl implements TUserLessonService {

    @Autowired
    private TUserLessonMapper userLessonMapper;
    @Override
    public int addTUserLesson(TUserLesson userLesson) {
        return userLessonMapper.insert(userLesson);
    }

    @Override
    public List<TUserLesson> getAllTUserLesson() {
        return userLessonMapper.selectAllUserLesson();
    }

    @Override
    public int deleteTUserLesson(int tUserLessonId) {
        return userLessonMapper.deleteByPrimaryKey(tUserLessonId);
    }

    @Override
    public List<TUserLesson> getUSerLesson(Integer userId) {
        return userLessonMapper.selectUserLesson(userId);
    }
}
