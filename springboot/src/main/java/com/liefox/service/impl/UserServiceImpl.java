package com.liefox.service.impl;

import com.liefox.entity.User;
import com.liefox.mapper.UserMapper;
import com.liefox.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIEFox
 * @since 2021-06-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
