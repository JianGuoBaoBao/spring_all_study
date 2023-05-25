package com.demo.dao;

import com.demo.entity.Parent;
import com.demo.entity.User;

import java.util.List;

public interface ParentDao {

    List<Parent> getParentByUserId();

    List<Parent> getParentByUserId2();
}
