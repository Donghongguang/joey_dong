package com.dancer.dao.mapper;

import com.dancer.entity.TLessontype;

import java.util.List;

public interface TLessontypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(TLessontype record);

    int insertSelective(TLessontype record);

    TLessontype selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(TLessontype record);

    int updateByPrimaryKey(TLessontype record);

    /**
     * 获取所有的视频类型
     * 董红广
     * 2019-04-17
     */
    List<TLessontype> selectAll();
}