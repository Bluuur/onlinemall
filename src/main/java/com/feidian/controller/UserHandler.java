package com.feidian.controller;

import com.feidian.mapper.UserMapper;
import com.feidian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     * 用户注册
     *
     * @param user 传入用户对象
     * @return 结果提示
     */
    @PostMapping("/register")
    public int register(@RequestBody User user){
        user.setUid( (long) (userMapper.count() + 1));
        return  userMapper.save(user);
    }

    /**
     * 获取用户信息
     *
     * @param uid 用户uid
     * @return  当前用户User对象
     */
    @GetMapping("/userInfo/{uid}")
    public User userInfo(@PathVariable("uid") Long uid) {
        return userMapper.getUserByUid(uid);
    }

    /**
     * 更改用户信息
     *
     * @param user 传入当前用户
     * @return 结果提示
     */
    @PostMapping("/changeInfo/{uid}")
    public int changeInfo(@PathVariable("uid") Long uid,@RequestBody User user){
        User srcUser = userMapper.getUserByUid(uid);
        srcUser.setUserName(user.getUserName());
        srcUser.setGender(user.getGender());
        if(!"".equals(user.getPassword())){
            srcUser.setPassword(user.getPassword());
        }
        if(!"".equals(user.getConsignee())){
            srcUser.setConsignee(user.getConsignee());
        }
        srcUser.setPhoneNumber(user.getPhoneNumber());
        srcUser.setAddress(user.getAddress());

        return userMapper.save(srcUser);

    }

    /**
     * 登录
     *
     * @param user 传入用户信息(用户名,密码)
     * @return 执行结果
     */
    @PostMapping("login")
    public String login(@RequestBody User user){
        User target = userMapper.getUserByUserName(user.getUserName());
        if(target != null){//用户存在
            if(user.getPassword().equals(target.getPassword())){//密码正确
                return target.getUid().toString();
            }else {//密码错误
                return "error:1";
            }
        }else {//用户不存在
            return "error:2";
        }
    }
}
