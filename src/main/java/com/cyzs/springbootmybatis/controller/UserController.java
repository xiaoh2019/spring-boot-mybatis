package com.cyzs.springbootmybatis.controller;

import com.cyzs.springbootmybatis.bean.User;
import com.cyzs.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xh
 * @create: 2020-04-08 15:37
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/fingUserById")
    public User fingUserById(Integer id){
        User user = userMapper.findUserById(id);
        return user;
    }
}
