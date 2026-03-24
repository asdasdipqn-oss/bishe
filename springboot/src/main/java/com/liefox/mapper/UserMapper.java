package com.liefox.mapper;

import com.liefox.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LIEFox
 * @since 2021-06-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
