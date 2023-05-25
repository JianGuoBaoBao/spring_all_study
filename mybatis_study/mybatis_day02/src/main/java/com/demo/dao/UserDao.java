package com.demo.dao;

import com.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


}
