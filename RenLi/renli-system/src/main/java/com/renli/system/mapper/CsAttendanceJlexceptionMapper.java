package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsAttendanceJlexception;

/**
 * 考勤异常审批Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsAttendanceJlexceptionMapper 
{
    /**
     * 查询考勤异常审批
     * 
     * @param id 考勤异常审批主键
     * @return 考勤异常审批
     */
    public CsAttendanceJlexception selectCsAttendanceJlexceptionById(Long id);

    /**
     * 查询考勤异常审批列表
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 考勤异常审批集合
     */
    public List<CsAttendanceJlexception> selectCsAttendanceJlexceptionList(CsAttendanceJlexception csAttendanceJlexception);

    /**
     * 新增考勤异常审批
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 结果
     */
    public int insertCsAttendanceJlexception(CsAttendanceJlexception csAttendanceJlexception);

    /**
     * 修改考勤异常审批
     * 
     * @param csAttendanceJlexception 考勤异常审批
     * @return 结果
     */
    public int updateCsAttendanceJlexception(CsAttendanceJlexception csAttendanceJlexception);

    /**
     * 删除考勤异常审批
     * 
     * @param id 考勤异常审批主键
     * @return 结果
     */
    public int deleteCsAttendanceJlexceptionById(Long id);

    /**
     * 批量删除考勤异常审批
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsAttendanceJlexceptionByIds(String[] ids);
}
