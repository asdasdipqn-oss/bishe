package com.liefox;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liefox.entity.Signinfo;
import com.liefox.entity.User;
import com.liefox.mapper.SigninfoMapper;
import com.liefox.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class HealthPunchSystemApplicationTests {

    @Autowired
    private SigninfoMapper signinfoMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {
        List<Signinfo> signinfos = signinfoMapper.selectList(null);
        signinfos.forEach(System.out::println);
    }

    @Test
    void update() {
        User user = new User();
        user.setUsername("098");
        user.setPassword("091118");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    void seletByUn() {
        final User user = userMapper.selectById(4317);
        System.out.println(user);
    }

    @Test
    void seletByUnList() {
        final List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 4317, 8888));
        users.forEach(System.out::println);
    }

    @Test
    void seletWhere() {
        final HashMap<String, Object> map = new HashMap<>();
        map.put("username", "李玮峰");
        List<Signinfo> users = signinfoMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    void Page() {
        /*final Page<Signinfo> page = new Page<>(1, 5);
        signinfoMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);*/
    }
}
