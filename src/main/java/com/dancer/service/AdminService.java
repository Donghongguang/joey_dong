package com.dancer.service;

import com.dancer.entity.TAdmin;

import java.util.List;

public interface AdminService {
    int insertAdmin(TAdmin admin);//插入
    int deleteAdmin(int adminId);//删除
    int updateAdmin(TAdmin admin);//修改
    TAdmin getAdminById(int adminId);//根据id查找admin

    List<TAdmin> getAllAdmin();//返回所有的AdminInfo

    TAdmin getByName(String name);//根据名字搜素信息
}
