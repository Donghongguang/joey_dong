package com.dancer.service;

import com.dancer.entity.TLesson;

import java.util.List;

public interface LessonService {
    TLesson addLesson (TLesson lesson);
    int deleteLesson(String lessonId);
    List<TLesson> getAllLesson();
    TLesson getLessonById(String lessonId);
    int updateLesson(TLesson lesson);

}
