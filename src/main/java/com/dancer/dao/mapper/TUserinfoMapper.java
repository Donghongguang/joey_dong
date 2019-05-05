package com.dancer.dao.mapper;

import com.dancer.entity.TUserinfo;


import java.util.List;

public interface TUserinfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert( TUserinfo record);

    int insertSelective(TUserinfo record);

    TUserinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TUserinfo record);

    int updateByPrimaryKey(TUserinfo record);

    List<TUserinfo> selectAll();

    /**
     * 根据名字搜素userInfo
     * 董红广
     * 2019-03-25
     */
    TUserinfo selectByName(String username);
}