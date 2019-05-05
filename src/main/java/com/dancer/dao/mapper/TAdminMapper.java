package com.dancer.dao.mapper;

import com.dancer.entity.TAdmin;

import java.util.List;

public interface TAdminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);

    List<TAdmin> selectAllAdmin();//获取所有的adiminInfo

    TAdmin selectByName(String name);//根据名字查询信息
}