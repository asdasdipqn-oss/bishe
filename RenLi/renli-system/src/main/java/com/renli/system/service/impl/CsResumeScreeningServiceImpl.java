package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsResumeScreeningMapper;
import com.renli.system.domain.CsResumeScreening;
import com.renli.system.service.ICsResumeScreeningService;
import com.renli.common.core.text.Convert;

/**
 * 简历筛选Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsResumeScreeningServiceImpl implements ICsResumeScreeningService 
{
    @Autowired
    private CsResumeScreeningMapper csResumeScreeningMapper;

    /**
     * 查询简历筛选
     * 
     * @param id 简历筛选主键
     * @return 简历筛选
     */
    @Override
    public CsResumeScreening selectCsResumeScreeningById(Long id)
    {
        return csResumeScreeningMapper.selectCsResumeScreeningById(id);
    }

    /**
     * 查询简历筛选列表
     * 
     * @param csResumeScreening 简历筛选
     * @return 简历筛选
     */
    @Override
    public List<CsResumeScreening> selectCsResumeScreeningList(CsResumeScreening csResumeScreening)
    {
        return csResumeScreeningMapper.selectCsResumeScreeningList(csResumeScreening);
    }

    /**
     * 新增简历筛选
     * 
     * @param csResumeScreening 简历筛选
     * @return 结果
     */
    @Override
    public int insertCsResumeScreening(CsResumeScreening csResumeScreening)
    {
        return csResumeScreeningMapper.insertCsResumeScreening(csResumeScreening);
    }

    /**
     * 修改简历筛选
     * 
     * @param csResumeScreening 简历筛选
     * @return 结果
     */
    @Override
    public int updateCsResumeScreening(CsResumeScreening csResumeScreening)
    {
        return csResumeScreeningMapper.updateCsResumeScreening(csResumeScreening);
    }

    /**
     * 批量删除简历筛选
     * 
     * @param ids 需要删除的简历筛选主键
     * @return 结果
     */
    @Override
    public int deleteCsResumeScreeningByIds(String ids)
    {
        return csResumeScreeningMapper.deleteCsResumeScreeningByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除简历筛选信息
     * 
     * @param id 简历筛选主键
     * @return 结果
     */
    @Override
    public int deleteCsResumeScreeningById(Long id)
    {
        return csResumeScreeningMapper.deleteCsResumeScreeningById(id);
    }
}
