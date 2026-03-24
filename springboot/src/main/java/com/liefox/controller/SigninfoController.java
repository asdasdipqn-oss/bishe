package com.liefox.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liefox.entity.Signinfo;
import com.liefox.entity.vo.PageInfoVo;
import com.liefox.service.impl.SigninfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/signinfo")
public class SigninfoController {

    @Autowired
    private SigninfoServiceImpl signinfoService;

    /**
     * 获取全部打卡记录
     *
     * @param pageInfoVo
     * @return
     */
    @PostMapping("/findAll1")
    public Page<Signinfo> findAll1(@RequestBody PageInfoVo pageInfoVo) {
        final Page<Signinfo> page1 = new Page<>(
                pageInfoVo.getPage(),
                pageInfoVo.getSize());
        final QueryWrapper<Signinfo> wrapper = new QueryWrapper<>();
        wrapper.like("username", pageInfoVo.getUsername());
        wrapper.like("address", pageInfoVo.getAddress());
        if (pageInfoVo.getStartTime() != null && pageInfoVo.getEndTime() != null) {
            wrapper.between("date", pageInfoVo.getStartTime(), pageInfoVo.getEndTime());
        }
        return (Page<Signinfo>) signinfoService.page(page1, wrapper);
    }

    /**
     * 用户打卡
     *
     * @param signinfo
     * @return
     */
    @PostMapping("/punch")
    public String Punch(@RequestBody Signinfo signinfo) {
        try {
            final boolean save = signinfoService.save(signinfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/data")
    public List<Signinfo> Data(@RequestParam String username) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        final QueryWrapper<Signinfo> Wrapper = new QueryWrapper<>();
        Wrapper.like("username",username);
        final List<Signinfo> list = signinfoService.list(Wrapper);
        return list;
    }
}
