package com.zht.service.impl;

import com.zht.common.ServerResponse;
import com.zht.pojo.User;
import com.zht.mapper.UserDao;
import com.zht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.zht.logback.common.ServerResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ServerResponse<List<User>> findByUsername() {
        List<User> users;
//        if (username.isEmpty() || username == "") {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(), "没有输入查找条件！");
//        } else {

            users = userDao.selectAll();
//        }
        return ServerResponse.createBySuccess("查询成功",users);
    }

}