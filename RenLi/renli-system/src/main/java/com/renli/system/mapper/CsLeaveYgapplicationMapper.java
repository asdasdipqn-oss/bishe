package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsLeaveYgapplication;

/**
 * 假期申请Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsLeaveYgapplicationMapper 
{
    /**
     * 查询假期申请
     * 
     * @param id 假期申请主键
     * @return 假期申请
     */
    public CsLeaveYgapplication selectCsLeaveYgapplicationById(Long id);

    /**
     * 查询假期申请列表
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 假期申请集合
     */
    public List<CsLeaveYgapplication> selectCsLeaveYgapplicationList(CsLeaveYgapplication csLeaveYgapplication);

    /**
     * 新增假期申请
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 结果
     */
    public int insertCsLeaveYgapplication(CsLeaveYgapplication csLeaveYgapplication);

    /**
     * 修改假期申请
     * 
     * @param csLeaveYgapplication 假期申请
     * @return 结果
     */
    public int updateCsLeaveYgapplication(CsLeaveYgapplication csLeaveYgapplication);

    /**
     * 删除假期申请
     * 
     * @param id 假期申请主键
     * @return 结果
     */
    public int deleteCsLeaveYgapplicationById(Long id);

    /**
     * 批量删除假期申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsLeaveYgapplicationByIds(String[] ids);
}
