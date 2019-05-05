package com.dancer.service;

import com.dancer.entity.TUserinfo;

import java.util.List;

/**
 * user info表的增删查改
 * 董红广
 * 2019/02/27
 */
public interface UserInfoService {
    int insertUserInfo(TUserinfo userinfo);//插入
    int deleteUserInfo(int userId);//删除
    int updateUserInfo(TUserinfo userinfo);//修改
    TUserinfo getUserInfoById(int userId);//根据id查找user

    List<TUserinfo> getAllUserInfo();//返回所有的user INfo

    TUserinfo getByName(String name);//根据名字搜素userinfo
}
