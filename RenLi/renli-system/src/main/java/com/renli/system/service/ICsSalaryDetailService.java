package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsSalaryDetail;

/**
 * 薪资明细Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsSalaryDetailService 
{
    /**
     * 查询薪资明细
     * 
     * @param id 薪资明细主键
     * @return 薪资明细
     */
    public CsSalaryDetail selectCsSalaryDetailById(Long id);

    /**
     * 查询薪资明细列表
     * 
     * @param csSalaryDetail 薪资明细
     * @return 薪资明细集合
     */
    public List<CsSalaryDetail> selectCsSalaryDetailList(CsSalaryDetail csSalaryDetail);

    /**
     * 新增薪资明细
     * 
     * @param csSalaryDetail 薪资明细
     * @return 结果
     */
    public int insertCsSalaryDetail(CsSalaryDetail csSalaryDetail);

    /**
     * 修改薪资明细
     * 
     * @param csSalaryDetail 薪资明细
     * @return 结果
     */
    public int updateCsSalaryDetail(CsSalaryDetail csSalaryDetail);

    /**
     * 批量删除薪资明细
     * 
     * @param ids 需要删除的薪资明细主键集合
     * @return 结果
     */
    public int deleteCsSalaryDetailByIds(String ids);

    /**
     * 删除薪资明细信息
     * 
     * @param id 薪资明细主键
     * @return 结果
     */
    public int deleteCsSalaryDetailById(Long id);
}
