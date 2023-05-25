package com.demo.dao;

import com.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUserList();

    User getUserById(int id);

    User getUserByIdWithMap(Map<String, Object> map);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    int addUserWithMap(Map<String, Object> map);

    List<User> getUserLike(String name);

}
