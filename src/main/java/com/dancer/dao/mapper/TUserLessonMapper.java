package com.dancer.dao.mapper;

import com.dancer.entity.TUserLesson;

import java.util.List;

public interface TUserLessonMapper {
    int deleteByPrimaryKey(Integer tulid);

    int insert(TUserLesson record);

    int insertSelective(TUserLesson record);

    TUserLesson selectByPrimaryKey(Integer tulid);

    int updateByPrimaryKeySelective(TUserLesson record);

    int updateByPrimaryKey(TUserLesson record);
    /**
     * 获取所有的上传视频信息
     * 董红广
     * 2019-04-24
     */
    List<TUserLesson> selectAllUserLesson();
    /**
     * 根据userID返回所有的视频信息
     * 董红广
     * 2019-05-04
     */
    List<TUserLesson> selectUserLesson(Integer userid);
}