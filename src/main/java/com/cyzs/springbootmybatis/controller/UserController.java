package com.cyzs.springbootmybatis.controller;

import com.cyzs.springbootmybatis.bean.User;
import com.cyzs.springbootmybatis.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 分页查询
     * @param pageNum 页号
     * @param pageSize 每页大小
     * @return
     */
    @GetMapping(value = "/findPage")
    public PageInfo<User> findPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> page = userMapper.findPage();
        PageInfo<User> userPageInfo = new PageInfo<>(page);
        return userPageInfo;
    }
}
