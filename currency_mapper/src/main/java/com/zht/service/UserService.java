package com.zht.service;

import com.zht.common.ServerResponse;
import com.zht.pojo.User;

import java.util.List;

public interface UserService {
    ServerResponse<List<User>> findByUsername();

}
