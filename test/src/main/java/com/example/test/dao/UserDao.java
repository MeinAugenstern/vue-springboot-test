package com.example.test.dao;

import com.example.test.pojo.entity.User;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    Page<User> selectByPage();
}
