package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsAttendanceYgexceptionMapper;
import com.renli.system.domain.CsAttendanceYgexception;
import com.renli.system.service.ICsAttendanceYgexceptionService;
import com.renli.common.core.text.Convert;

/**
 * 考勤异常申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsAttendanceYgexceptionServiceImpl implements ICsAttendanceYgexceptionService 
{
    @Autowired
    private CsAttendanceYgexceptionMapper csAttendanceYgexceptionMapper;

    /**
     * 查询考勤异常申请
     * 
     * @param id 考勤异常申请主键
     * @return 考勤异常申请
     */
    @Override
    public CsAttendanceYgexception selectCsAttendanceYgexceptionById(Long id)
    {
        return csAttendanceYgexceptionMapper.selectCsAttendanceYgexceptionById(id);
    }

    /**
     * 查询考勤异常申请列表
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 考勤异常申请
     */
    @Override
    public List<CsAttendanceYgexception> selectCsAttendanceYgexceptionList(CsAttendanceYgexception csAttendanceYgexception)
    {
        return csAttendanceYgexceptionMapper.selectCsAttendanceYgexceptionList(csAttendanceYgexception);
    }

    /**
     * 新增考勤异常申请
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 结果
     */
    @Override
    public int insertCsAttendanceYgexception(CsAttendanceYgexception csAttendanceYgexception)
    {
        return csAttendanceYgexceptionMapper.insertCsAttendanceYgexception(csAttendanceYgexception);
    }

    /**
     * 修改考勤异常申请
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 结果
     */
    @Override
    public int updateCsAttendanceYgexception(CsAttendanceYgexception csAttendanceYgexception)
    {
        return csAttendanceYgexceptionMapper.updateCsAttendanceYgexception(csAttendanceYgexception);
    }

    /**
     * 批量删除考勤异常申请
     * 
     * @param ids 需要删除的考勤异常申请主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceYgexceptionByIds(String ids)
    {
        return csAttendanceYgexceptionMapper.deleteCsAttendanceYgexceptionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤异常申请信息
     * 
     * @param id 考勤异常申请主键
     * @return 结果
     */
    @Override
    public int deleteCsAttendanceYgexceptionById(Long id)
    {
        return csAttendanceYgexceptionMapper.deleteCsAttendanceYgexceptionById(id);
    }
}
