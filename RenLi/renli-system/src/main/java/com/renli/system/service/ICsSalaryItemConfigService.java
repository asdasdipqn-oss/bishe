package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsSalaryItemConfig;

/**
 * 薪资项目配置Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsSalaryItemConfigService 
{
    /**
     * 查询薪资项目配置
     * 
     * @param id 薪资项目配置主键
     * @return 薪资项目配置
     */
    public CsSalaryItemConfig selectCsSalaryItemConfigById(Long id);

    /**
     * 查询薪资项目配置列表
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 薪资项目配置集合
     */
    public List<CsSalaryItemConfig> selectCsSalaryItemConfigList(CsSalaryItemConfig csSalaryItemConfig);

    /**
     * 新增薪资项目配置
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 结果
     */
    public int insertCsSalaryItemConfig(CsSalaryItemConfig csSalaryItemConfig);

    /**
     * 修改薪资项目配置
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 结果
     */
    public int updateCsSalaryItemConfig(CsSalaryItemConfig csSalaryItemConfig);

    /**
     * 批量删除薪资项目配置
     * 
     * @param ids 需要删除的薪资项目配置主键集合
     * @return 结果
     */
    public int deleteCsSalaryItemConfigByIds(String ids);

    /**
     * 删除薪资项目配置信息
     * 
     * @param id 薪资项目配置主键
     * @return 结果
     */
    public int deleteCsSalaryItemConfigById(Long id);
}
