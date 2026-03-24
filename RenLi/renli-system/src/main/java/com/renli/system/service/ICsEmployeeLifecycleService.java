package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsEmployeeLifecycle;

/**
 * 员工全生命周期Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsEmployeeLifecycleService 
{
    /**
     * 查询员工全生命周期
     * 
     * @param id 员工全生命周期主键
     * @return 员工全生命周期
     */
    public CsEmployeeLifecycle selectCsEmployeeLifecycleById(Long id);

    /**
     * 查询员工全生命周期列表
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 员工全生命周期集合
     */
    public List<CsEmployeeLifecycle> selectCsEmployeeLifecycleList(CsEmployeeLifecycle csEmployeeLifecycle);

    /**
     * 新增员工全生命周期
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 结果
     */
    public int insertCsEmployeeLifecycle(CsEmployeeLifecycle csEmployeeLifecycle);

    /**
     * 修改员工全生命周期
     * 
     * @param csEmployeeLifecycle 员工全生命周期
     * @return 结果
     */
    public int updateCsEmployeeLifecycle(CsEmployeeLifecycle csEmployeeLifecycle);

    /**
     * 批量删除员工全生命周期
     * 
     * @param ids 需要删除的员工全生命周期主键集合
     * @return 结果
     */
    public int deleteCsEmployeeLifecycleByIds(String ids);

    /**
     * 删除员工全生命周期信息
     * 
     * @param id 员工全生命周期主键
     * @return 结果
     */
    public int deleteCsEmployeeLifecycleById(Long id);
}
