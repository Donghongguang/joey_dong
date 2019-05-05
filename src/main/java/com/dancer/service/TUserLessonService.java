package com.dancer.service;

import com.dancer.entity.TUserLesson;

import java.util.List;

/**
 * 对TUserLesson表进行操作
 * 董红广
 * 2019-04-24
 */

public interface TUserLessonService {
    int addTUserLesson(TUserLesson userLesson);
    List<TUserLesson> getAllTUserLesson();
    int deleteTUserLesson(int tUserLessonId);
    List<TUserLesson> getUSerLesson(Integer userId);


}
