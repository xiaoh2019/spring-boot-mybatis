package com.cyzs.springbootmybatis.bean;

import lombok.Data;

/**
 * @description:
 * @author: xh
 * @create: 2020-04-08 15:34
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private String gender;

    private String department;

}
