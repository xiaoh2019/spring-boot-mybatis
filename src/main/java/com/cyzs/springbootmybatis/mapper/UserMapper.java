package com.cyzs.springbootmybatis.mapper;

import com.cyzs.springbootmybatis.bean.User;

import java.util.List;

/**
 * @description:
 * @author: xh
 * @create: 2020-04-08 15:35
 */
public interface UserMapper {

    User findUserById(Integer id);

    List<User> findPage();
}
