package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsLeaveJlapplication;

/**
 * 假期审批Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsLeaveJlapplicationMapper 
{
    /**
     * 查询假期审批
     * 
     * @param id 假期审批主键
     * @return 假期审批
     */
    public CsLeaveJlapplication selectCsLeaveJlapplicationById(Long id);

    /**
     * 查询假期审批列表
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 假期审批集合
     */
    public List<CsLeaveJlapplication> selectCsLeaveJlapplicationList(CsLeaveJlapplication csLeaveJlapplication);

    /**
     * 新增假期审批
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 结果
     */
    public int insertCsLeaveJlapplication(CsLeaveJlapplication csLeaveJlapplication);

    /**
     * 修改假期审批
     * 
     * @param csLeaveJlapplication 假期审批
     * @return 结果
     */
    public int updateCsLeaveJlapplication(CsLeaveJlapplication csLeaveJlapplication);

    /**
     * 删除假期审批
     * 
     * @param id 假期审批主键
     * @return 结果
     */
    public int deleteCsLeaveJlapplicationById(Long id);

    /**
     * 批量删除假期审批
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsLeaveJlapplicationByIds(String[] ids);
}
