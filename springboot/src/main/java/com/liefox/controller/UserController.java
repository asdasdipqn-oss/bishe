package com.liefox.controller;


import com.liefox.entity.User;
import com.liefox.mapper.UserMapper;
import com.liefox.service.UserService;
import com.liefox.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LIEFox
 * @since 2021-06-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 用户登录接口
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String Login(@RequestBody User user) {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        final List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
        if (users.size() == 1) {
            return "success";
        } else {
            return "fail";
        }

    }


    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @PostMapping("/sign")
    public String Sign(@RequestBody User user) {
        try {
            final boolean save = userServiceImpl.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    /**
     * 修改用户密码
     *
     * @param user
     * @return
     */
    @PostMapping("/changepw")
    public String ChangePassWord(@RequestBody User user) {
        final boolean b = userServiceImpl.updateById(user);
        if (b == true) {
            return "success";
        } else {
            return "fail";
        }
    }


}
