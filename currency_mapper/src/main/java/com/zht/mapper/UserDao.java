package com.zht.mapper;

import com.zht.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao extends BaseDao<User> {

//    List<User> findByName();
}
