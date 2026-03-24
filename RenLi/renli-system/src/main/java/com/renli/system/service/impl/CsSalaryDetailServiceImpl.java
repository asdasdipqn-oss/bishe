package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsSalaryDetailMapper;
import com.renli.system.domain.CsSalaryDetail;
import com.renli.system.service.ICsSalaryDetailService;
import com.renli.common.core.text.Convert;

/**
 * 薪资明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsSalaryDetailServiceImpl implements ICsSalaryDetailService 
{
    @Autowired
    private CsSalaryDetailMapper csSalaryDetailMapper;

    /**
     * 查询薪资明细
     * 
     * @param id 薪资明细主键
     * @return 薪资明细
     */
    @Override
    public CsSalaryDetail selectCsSalaryDetailById(Long id)
    {
        return csSalaryDetailMapper.selectCsSalaryDetailById(id);
    }

    /**
     * 查询薪资明细列表
     * 
     * @param csSalaryDetail 薪资明细
     * @return 薪资明细
     */
    @Override
    public List<CsSalaryDetail> selectCsSalaryDetailList(CsSalaryDetail csSalaryDetail)
    {
        return csSalaryDetailMapper.selectCsSalaryDetailList(csSalaryDetail);
    }

    /**
     * 新增薪资明细
     * 
     * @param csSalaryDetail 薪资明细
     * @return 结果
     */
    @Override
    public int insertCsSalaryDetail(CsSalaryDetail csSalaryDetail)
    {
        return csSalaryDetailMapper.insertCsSalaryDetail(csSalaryDetail);
    }

    /**
     * 修改薪资明细
     * 
     * @param csSalaryDetail 薪资明细
     * @return 结果
     */
    @Override
    public int updateCsSalaryDetail(CsSalaryDetail csSalaryDetail)
    {
        return csSalaryDetailMapper.updateCsSalaryDetail(csSalaryDetail);
    }

    /**
     * 批量删除薪资明细
     * 
     * @param ids 需要删除的薪资明细主键
     * @return 结果
     */
    @Override
    public int deleteCsSalaryDetailByIds(String ids)
    {
        return csSalaryDetailMapper.deleteCsSalaryDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除薪资明细信息
     * 
     * @param id 薪资明细主键
     * @return 结果
     */
    @Override
    public int deleteCsSalaryDetailById(Long id)
    {
        return csSalaryDetailMapper.deleteCsSalaryDetailById(id);
    }
}
