package com.dancer.service;

import com.dancer.entity.TAdminLesson;

import java.util.List;

/**
 * 管理员对视频的操作
 * 董红广
 * 2019-04-24
 */

public interface TAdminLessonService {


    int addAdminLesson(TAdminLesson adminLesson);
    int deleteAdminLesson(int adminLessonId);
    List<TAdminLesson> getAllAdminLesson();
    List<TAdminLesson> getAdminLesson(Integer userId);
}
