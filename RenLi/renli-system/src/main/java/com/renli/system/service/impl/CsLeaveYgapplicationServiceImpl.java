package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsLeaveYgapplicationMapper;
import com.renli.system.domain.CsLeaveYgapplication;
import com.renli.system.service.ICsLeaveYgapplicationService;
import com.renli.common.core.text.Convert;

/**
 * 假期申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsLeaveYgapplicationServiceImpl implements ICsLeaveYgapplicationService 
{
    @Autowired
    private CsLeaveYgapplicationMapper csLeaveYgapplicationMapper;

    /**
     * 查询假期申请
     * 
     * @param id 假期申请主键
     * @return 假期申请
     */
    @Override
    public CsLeaveYgapplication selectCsLeaveYgapplicationById(Long id)
    {
        return csLeaveYgapplicationMapper.selectCsLeaveYgapplicationById(id);
    }

    /**
     * 查询假期申请列表
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 假期申请
     */
    @Override
    public List<CsLeaveYgapplication> selectCsLeaveYgapplicationList(CsLeaveYgapplication csLeaveYgapplication)
    {
        return csLeaveYgapplicationMapper.selectCsLeaveYgapplicationList(csLeaveYgapplication);
    }

    /**
     * 新增假期申请
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 结果
     */
    @Override
    public int insertCsLeaveYgapplication(CsLeaveYgapplication csLeaveYgapplication)
    {
        return csLeaveYgapplicationMapper.insertCsLeaveYgapplication(csLeaveYgapplication);
    }

    /**
     * 修改假期申请
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 结果
     */
    @Override
    public int updateCsLeaveYgapplication(CsLeaveYgapplication csLeaveYgapplication)
    {
        return csLeaveYgapplicationMapper.updateCsLeaveYgapplication(csLeaveYgapplication);
    }

    /**
     * 批量删除假期申请
     * 
     * @param ids 需要删除的假期申请主键
     * @return 结果
     */
    @Override
    public int deleteCsLeaveYgapplicationByIds(String ids)
    {
        return csLeaveYgapplicationMapper.deleteCsLeaveYgapplicationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除假期申请信息
     * 
     * @param id 假期申请主键
     * @return 结果
     */
    @Override
    public int deleteCsLeaveYgapplicationById(Long id)
    {
        return csLeaveYgapplicationMapper.deleteCsLeaveYgapplicationById(id);
    }
}
