package com.example.test.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String realname;

    private static final long serialVersionUID = 1L;

    public String toString(){
        return id+account+password+realname;
    }
}

