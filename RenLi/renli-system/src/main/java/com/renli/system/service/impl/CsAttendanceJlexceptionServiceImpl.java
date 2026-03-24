package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsAttendanceJlexceptionMapper;
import com.renli.system.domain.CsAttendanceJlexception;
import com.renli.system.service.ICsAttendanceJlexceptionService;
import com.renli.common.core.text.Convert;

/**
 * 考勤异常审批Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsAttendanceJlexceptionServiceImpl implements ICsAttendanceJlexceptionService 
{
    @Autowired
    private CsAttendanceJlexceptionMapper csAttendanceJlexceptionMapper;

    /**
     * 查询考勤异常审批
     * 
     * @param id 考勤异常审批主键
     * @return 考勤异常审批
     */
    @Override
    public CsAttendanceJlexception selectCsAttendanceJlexceptionById(Long id)
    {
        return csAttendanceJlexceptionMapper.selectCsAttendanceJlexceptionById(id);
    }

    /**
     * 查询考勤异常审批列表
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 考勤异常审批
     */
    @Override
    public List<CsAttendanceJlexception> selectCsAttendanceJlexceptionList(CsAttendanceJlexception csAttendanceJlexception)
    {
        return csAttendanceJlexceptionMapper.selectCsAttendanceJlexceptionList(csAttendanceJlexception);
    }

    /**
     * 新增考勤异常审批
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 结果
     */
    @Override
    public int insertCsAttendanceJlexception(CsAttendanceJlexception csAttendanceJlexception)
    {
        return csAttendanceJlexceptionMapper.insertCsAttendanceJlexception(csAttendanceJlexception);
    }

    /**
     * 修改考勤异常审批
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 结果
     */
    @Override
    public int updateCsAttendanceJlexception(CsAttendanceJlexception csAttendanceJlexception)
    {
        return csAttendanceJlexceptionMapper.updateCsAttendanceJlexception(csAttendanceJlexception);
    }

    /**
     * 批量删除考勤异常审批
     * 
     * @param ids 需要删除的考勤异常审批主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceJlexceptionByIds(String ids)
    {
        return csAttendanceJlexceptionMapper.deleteCsAttendanceJlexceptionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤异常审批信息
     * 
     * @param id 考勤异常审批主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceJlexceptionById(Long id)
    {
        return csAttendanceJlexceptionMapper.deleteCsAttendanceJlexceptionById(id);
    }
}
