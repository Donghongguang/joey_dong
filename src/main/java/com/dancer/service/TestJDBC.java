package com.dancer.service;

import com.dancer.entity.TUserinfo;

public interface TestJDBC {
    TUserinfo selectById(Integer userId);
}
