package com.dancer.dao.mapper;

import com.dancer.entity.TAdminLesson;

import java.util.List;

public interface TAdminLessonMapper {
    int deleteByPrimaryKey(Integer talid);

    int insert(TAdminLesson record);

    int insertSelective(TAdminLesson record);

    TAdminLesson selectByPrimaryKey(Integer talid);

    int updateByPrimaryKeySelective(TAdminLesson record);

    int updateByPrimaryKey(TAdminLesson record);
    /**
     * 获取所有上传视频信息
     * 董红广
     * 2019-04-24
     */
    List<TAdminLesson> selecAllAdminLesson();
    /**
     * 获取所有的管理员的个人视频
     * 董红广
     * 2019-05-04
     */
    List<TAdminLesson> selectAdminLesson(Integer adminId);
}