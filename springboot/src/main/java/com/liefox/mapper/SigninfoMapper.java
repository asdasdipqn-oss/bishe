package com.liefox.mapper;

import com.liefox.entity.Signinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LIEFox
 * @since 2021-06-19
 */
@Mapper
@Repository
public interface SigninfoMapper extends BaseMapper<Signinfo> {

}
