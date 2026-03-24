package com.renli.system.mapper;

import java.util.List;
import com.renli.system.domain.CsDeptTrainingHrrequest;

/**
 * 培训需求Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface CsDeptTrainingHrrequestMapper 
{
    /**
     * 查询培训需求
     * 
     * @param id 培训需求主键
     * @return 培训需求
     */
    public CsDeptTrainingHrrequest selectCsDeptTrainingHrrequestById(Long id);

    /**
     * 查询培训需求列表
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 培训需求集合
     */
    public List<CsDeptTrainingHrrequest> selectCsDeptTrainingHrrequestList(CsDeptTrainingHrrequest csDeptTrainingHrrequest);

    /**
     * 新增培训需求
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 结果
     */
    public int insertCsDeptTrainingHrrequest(CsDeptTrainingHrrequest csDeptTrainingHrrequest);

    /**
     * 修改培训需求
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 结果
     */
    public int updateCsDeptTrainingHrrequest(CsDeptTrainingHrrequest csDeptTrainingHrrequest);

    /**
     * 删除培训需求
     * 
     * @param id 培训需求主键
     * @return 结果
     */
    public int deleteCsDeptTrainingHrrequestById(Long id);

    /**
     * 批量删除培训需求
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCsDeptTrainingHrrequestByIds(String[] ids);
}
