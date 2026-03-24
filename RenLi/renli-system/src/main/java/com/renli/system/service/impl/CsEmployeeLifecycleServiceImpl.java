package com.renli.system.service.impl;

import java.util.List;
import com.renli.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsEmployeeLifecycleMapper;
import com.renli.system.domain.CsEmployeeLifecycle;
import com.renli.system.service.ICsEmployeeLifecycleService;
import com.renli.common.core.text.Convert;

/**
 * 员工全生命周期Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsEmployeeLifecycleServiceImpl implements ICsEmployeeLifecycleService 
{
    @Autowired
    private CsEmployeeLifecycleMapper csEmployeeLifecycleMapper;

    /**
     * 查询员工全生命周期
     * 
     * @param id 员工全生命周期主键
     * @return 员工全生命周期
     */
    @Override
    public CsEmployeeLifecycle selectCsEmployeeLifecycleById(Long id)
    {
        return csEmployeeLifecycleMapper.selectCsEmployeeLifecycleById(id);
    }

    /**
     * 查询员工全生命周期列表
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 员工全生命周期
     */
    @Override
    public List<CsEmployeeLifecycle> selectCsEmployeeLifecycleList(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        return csEmployeeLifecycleMapper.selectCsEmployeeLifecycleList(csEmployeeLifecycle);
    }

    /**
     * 新增员工全生命周期
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 结果
     */
    @Override
    public int insertCsEmployeeLifecycle(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        csEmployeeLifecycle.setCreateTime(DateUtils.getNowDate());
        return csEmployeeLifecycleMapper.insertCsEmployeeLifecycle(csEmployeeLifecycle);
    }

    /**
     * 修改员工全生命周期
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 结果
     */
    @Override
    public int updateCsEmployeeLifecycle(CsEmployeeLifecycle csEmployeeLifecycle)
    {
        return csEmployeeLifecycleMapper.updateCsEmployeeLifecycle(csEmployeeLifecycle);
    }

    /**
     * 批量删除员工全生命周期
     * 
     * @param ids 需要删除的员工全生命周期主键
     * @return 结果
     */
    @Override
    public int deleteCsEmployeeLifecycleByIds(String ids)
    {
        return csEmployeeLifecycleMapper.deleteCsEmployeeLifecycleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工全生命周期信息
     * 
     * @param id 员工全生命周期主键
     * @return 结果
     */
    @Override
    public int deleteCsEmployeeLifecycleById(Long id)
    {
        return csEmployeeLifecycleMapper.deleteCsEmployeeLifecycleById(id);
    }
}
