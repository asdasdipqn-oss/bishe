package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsAttendanceYgexception;

/**
 * 考勤异常申请Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsAttendanceYgexceptionMapper 
{
    /**
     * 查询考勤异常申请
     * 
     * @param id 考勤异常申请主键
     * @return 考勤异常申请
     */
    public CsAttendanceYgexception selectCsAttendanceYgexceptionById(Long id);

    /**
     * 查询考勤异常申请列表
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 考勤异常申请集合
     */
    public List<CsAttendanceYgexception> selectCsAttendanceYgexceptionList(CsAttendanceYgexception csAttendanceYgexception);

    /**
     * 新增考勤异常申请
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 结果
     */
    public int insertCsAttendanceYgexception(CsAttendanceYgexception csAttendanceYgexception);

    /**
     * 修改考勤异常申请
     * 
     * @param csAttendanceYgexception 考勤异常申请
     * @return 结果
     */
    public int updateCsAttendanceYgexception(CsAttendanceYgexception csAttendanceYgexception);

    /**
     * 删除考勤异常申请
     * 
     * @param id 考勤异常申请主键
     * @return 结果
     */
    public int deleteCsAttendanceYgexceptionById(Long id);

    /**
     * 批量删除考勤异常申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsAttendanceYgexceptionByIds(String[] ids);
}
