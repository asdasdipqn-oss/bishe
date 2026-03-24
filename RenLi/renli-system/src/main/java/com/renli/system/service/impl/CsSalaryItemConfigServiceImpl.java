package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsSalaryItemConfigMapper;
import com.renli.system.domain.CsSalaryItemConfig;
import com.renli.system.service.ICsSalaryItemConfigService;
import com.renli.common.core.text.Convert;

/**
 * 薪资项目配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsSalaryItemConfigServiceImpl implements ICsSalaryItemConfigService 
{
    @Autowired
    private CsSalaryItemConfigMapper csSalaryItemConfigMapper;

    /**
     * 查询薪资项目配置
     * 
     * @param id 薪资项目配置主键
     * @return 薪资项目配置
     */
    @Override
    public CsSalaryItemConfig selectCsSalaryItemConfigById(Long id)
    {
        return csSalaryItemConfigMapper.selectCsSalaryItemConfigById(id);
    }

    /**
     * 查询薪资项目配置列表
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 薪资项目配置
     */
    @Override
    public List<CsSalaryItemConfig> selectCsSalaryItemConfigList(CsSalaryItemConfig csSalaryItemConfig)
    {
        return csSalaryItemConfigMapper.selectCsSalaryItemConfigList(csSalaryItemConfig);
    }

    /**
     * 新增薪资项目配置
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 结果
     */
    @Override
    public int insertCsSalaryItemConfig(CsSalaryItemConfig csSalaryItemConfig)
    {
        return csSalaryItemConfigMapper.insertCsSalaryItemConfig(csSalaryItemConfig);
    }

    /**
     * 修改薪资项目配置
     * 
     * @param csSalaryItemConfig 薪资项目配置
     * @return 结果
     */
    @Override
    public int updateCsSalaryItemConfig(CsSalaryItemConfig csSalaryItemConfig)
    {
        return csSalaryItemConfigMapper.updateCsSalaryItemConfig(csSalaryItemConfig);
    }

    /**
     * 批量删除薪资项目配置
     * 
     * @param ids 需要删除的薪资项目配置主键
     * @return 结果
     */
    @Override
    public int deleteCsSalaryItemConfigByIds(String ids)
    {
        return csSalaryItemConfigMapper.deleteCsSalaryItemConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除薪资项目配置信息
     * 
     * @param id 薪资项目配置主键
     * @return 结果
     */
    @Override
    public int deleteCsSalaryItemConfigById(Long id)
    {
        return csSalaryItemConfigMapper.deleteCsSalaryItemConfigById(id);
    }
}
