package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsDeptTrainingJlrequest;

/**
 * 培训需求Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsDeptTrainingJlrequestMapper 
{
    /**
     * 查询培训需求
     * 
     * @param id 培训需求主键
     * @return 培训需求
     */
    public CsDeptTrainingJlrequest selectCsDeptTrainingJlrequestById(Long id);

    /**
     * 查询培训需求列表
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 培训需求集合
     */
    public List<CsDeptTrainingJlrequest> selectCsDeptTrainingJlrequestList(CsDeptTrainingJlrequest csDeptTrainingJlrequest);

    /**
     * 新增培训需求
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 结果
     */
    public int insertCsDeptTrainingJlrequest(CsDeptTrainingJlrequest csDeptTrainingJlrequest);

    /**
     * 修改培训需求
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 结果
     */
    public int updateCsDeptTrainingJlrequest(CsDeptTrainingJlrequest csDeptTrainingJlrequest);

    /**
     * 删除培训需求
     * 
     * @param id 培训需求主键
     * @return 结果
     */
    public int deleteCsDeptTrainingJlrequestById(Long id);

    /**
     * 批量删除培训需求
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsDeptTrainingJlrequestByIds(String[] ids);
}
