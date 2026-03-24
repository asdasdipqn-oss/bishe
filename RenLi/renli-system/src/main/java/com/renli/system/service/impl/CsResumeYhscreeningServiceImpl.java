package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsResumeYhscreeningMapper;
import com.renli.system.domain.CsResumeYhscreening;
import com.renli.system.service.ICsResumeYhscreeningService;
import com.renli.common.core.text.Convert;

/**
 * 简历筛选Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsResumeYhscreeningServiceImpl implements ICsResumeYhscreeningService 
{
    @Autowired
    private CsResumeYhscreeningMapper csResumeYhscreeningMapper;

    /**
     * 查询简历筛选
     * 
     * @param id 简历筛选主键
     * @return 简历筛选
     */
    @Override
    public CsResumeYhscreening selectCsResumeYhscreeningById(Long id)
    {
        return csResumeYhscreeningMapper.selectCsResumeYhscreeningById(id);
    }

    /**
     * 查询简历筛选列表
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 简历筛选
     */
    @Override
    public List<CsResumeYhscreening> selectCsResumeYhscreeningList(CsResumeYhscreening csResumeYhscreening)
    {
        return csResumeYhscreeningMapper.selectCsResumeYhscreeningList(csResumeYhscreening);
    }

    /**
     * 新增简历筛选
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 结果
     */
    @Override
    public int insertCsResumeYhscreening(CsResumeYhscreening csResumeYhscreening)
    {
        return csResumeYhscreeningMapper.insertCsResumeYhscreening(csResumeYhscreening);
    }

    /**
     * 修改简历筛选
     * 
     * @param csResumeYhscreening 简历筛选
     * @return 结果
     */
    @Override
    public int updateCsResumeYhscreening(CsResumeYhscreening csResumeYhscreening)
    {
        return csResumeYhscreeningMapper.updateCsResumeYhscreening(csResumeYhscreening);
    }

    /**
     * 批量删除简历筛选
     * 
     * @param ids 需要删除的简历筛选主键
     * @return 结果
     */
    @Override
    public int deleteCsResumeYhscreeningByIds(String ids)
    {
        return csResumeYhscreeningMapper.deleteCsResumeYhscreeningByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除简历筛选信息
     * 
     * @param id 简历筛选主键
     * @return 结果
     */
    @Override
    public int deleteCsResumeYhscreeningById(Long id)
    {
        return csResumeYhscreeningMapper.deleteCsResumeYhscreeningById(id);
    }
}
