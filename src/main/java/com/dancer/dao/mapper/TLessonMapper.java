package com.dancer.dao.mapper;

import com.dancer.entity.TLesson;

import java.util.List;

public interface TLessonMapper {
    int deleteByPrimaryKey(String lessonid);

    int insert(TLesson record);

    int insertSelective(TLesson record);

    TLesson selectByPrimaryKey(String lessonid);

    int updateByPrimaryKeySelective(TLesson record);

    int updateByPrimaryKey(TLesson record);

    /**
     * 获取所有的视频信息
     * 董红广
     * 2019-04-25
     */
    List<TLesson> selectAllLesson();
}