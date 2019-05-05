package com.dancer.service.xml;

import com.dancer.dao.mapper.TUserinfoMapper;
import com.dancer.entity.TUserinfo;
import com.dancer.service.TestJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestJDBCImpl implements TestJDBC {
    @Autowired
    private TUserinfoMapper userinfoMapper;
    @Override
    public TUserinfo selectById(Integer userId) {
        return userinfoMapper.selectByPrimaryKey(userId);
    }
}
