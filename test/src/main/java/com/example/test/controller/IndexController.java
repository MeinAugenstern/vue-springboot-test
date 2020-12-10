package com.example.test.controller;

import com.example.test.dao.UserDao;
import com.example.test.pojo.entity.User;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    UserDao userDao;
    @RequestMapping("/index")
    String index(){
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user.getAccount());
        return "index";
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public User findUser(@PathVariable("id") int id){
        return userDao.selectByPrimaryKey(id);
    }

    @RequestMapping("/Alluser")
    @ResponseBody
    public List<User> findAllUser(){return userDao.selectAll();}

    @PostMapping("/save")
    @ResponseBody
    public String saveUser(@RequestBody User user){
        int i = userDao.insert(user);
        if(i==1){
            return "success";
        }else {
            return "false";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateUser(@RequestBody User user){
        int i = userDao.updateByPrimaryKeySelective(user);
        if(i==1){
            return "success";
        }else {
            return "false";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id){
        int i = userDao.deleteByPrimaryKey(id);
        if(i==1){
            return "success";
        }else {
            return "false";
        }
    }

    @RequestMapping("/page/{start}/{limit}")
    @ResponseBody
    public PageInfo<User> findUserByPage(@PathVariable("start") int start, @PathVariable("limit") int limit){
        PageHelper.startPage(start,limit);
        Page<User> users = userDao.selectByPage();
        PageInfo<User> result = new PageInfo<>(users);
        return result;
    }

}

