package com.dancer.service.xml;

import com.dancer.dao.mapper.TUserinfoMapper;
import com.dancer.entity.TUserinfo;
import com.dancer.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private TUserinfoMapper userinfoMapper;
    @Override
    public int insertUserInfo(TUserinfo userinfo) {
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public int deleteUserInfo(int userId) {
        return userinfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(TUserinfo userinfo) {
        return userinfoMapper.updateByPrimaryKey(userinfo);
    }

    @Override
    public TUserinfo getUserInfoById(int userId) {
        return userinfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<TUserinfo> getAllUserInfo() {
        return userinfoMapper.selectAll();
    }

    @Override
    public TUserinfo getByName(String name) {
        return userinfoMapper.selectByName(name);
    }
}
