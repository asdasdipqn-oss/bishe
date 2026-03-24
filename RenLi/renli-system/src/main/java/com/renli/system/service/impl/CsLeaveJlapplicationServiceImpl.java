package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsLeaveJlapplicationMapper;
import com.renli.system.domain.CsLeaveJlapplication;
import com.renli.system.service.ICsLeaveJlapplicationService;
import com.renli.common.core.text.Convert;

/**
 * 假期审批Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsLeaveJlapplicationServiceImpl implements ICsLeaveJlapplicationService 
{
    @Autowired
    private CsLeaveJlapplicationMapper csLeaveJlapplicationMapper;

    /**
     * 查询假期审批
     * 
     * @param id 假期审批主键
     * @return 假期审批
     */
    @Override
    public CsLeaveJlapplication selectCsLeaveJlapplicationById(Long id)
    {
        return csLeaveJlapplicationMapper.selectCsLeaveJlapplicationById(id);
    }

    /**
     * 查询假期审批列表
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 假期审批
     */
    @Override
    public List<CsLeaveJlapplication> selectCsLeaveJlapplicationList(CsLeaveJlapplication csLeaveJlapplication)
    {
        return csLeaveJlapplicationMapper.selectCsLeaveJlapplicationList(csLeaveJlapplication);
    }

    /**
     * 新增假期审批
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 结果
     */
    @Override
    public int insertCsLeaveJlapplication(CsLeaveJlapplication csLeaveJlapplication)
    {
        return csLeaveJlapplicationMapper.insertCsLeaveJlapplication(csLeaveJlapplication);
    }

    /**
     * 修改假期审批
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 结果
     */
    @Override
    public int updateCsLeaveJlapplication(CsLeaveJlapplication csLeaveJlapplication)
    {
        return csLeaveJlapplicationMapper.updateCsLeaveJlapplication(csLeaveJlapplication);
    }

    /**
     * 批量删除假期审批
     * 
     * @param ids 需要删除的假期审批主键
     * @return 结果
     */
    @Override
    public int deleteCsLeaveJlapplicationByIds(String ids)
    {
        return csLeaveJlapplicationMapper.deleteCsLeaveJlapplicationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除假期审批信息
     * 
     * @param id 假期审批主键
     * @return 结果
     */
    @Override
    public int deleteCsLeaveJlapplicationById(Long id)
    {
        return csLeaveJlapplicationMapper.deleteCsLeaveJlapplicationById(id);
    }
}
