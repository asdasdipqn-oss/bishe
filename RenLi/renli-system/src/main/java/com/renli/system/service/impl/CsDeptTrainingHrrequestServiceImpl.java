package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsDeptTrainingHrrequestMapper;
import com.renli.system.domain.CsDeptTrainingHrrequest;
import com.renli.system.service.ICsDeptTrainingHrrequestService;
import com.renli.common.core.text.Convert;

/**
 * 培训需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsDeptTrainingHrrequestServiceImpl implements ICsDeptTrainingHrrequestService 
{
    @Autowired
    private CsDeptTrainingHrrequestMapper csDeptTrainingHrrequestMapper;

    /**
     * 查询培训需求
     * 
     * @param id 培训需求主键
     * @return 培训需求
     */
    @Override
    public CsDeptTrainingHrrequest selectCsDeptTrainingHrrequestById(Long id)
    {
        return csDeptTrainingHrrequestMapper.selectCsDeptTrainingHrrequestById(id);
    }

    /**
     * 查询培训需求列表
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 培训需求
     */
    @Override
    public List<CsDeptTrainingHrrequest> selectCsDeptTrainingHrrequestList(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
    {
        return csDeptTrainingHrrequestMapper.selectCsDeptTrainingHrrequestList(csDeptTrainingHrrequest);
    }

    /**
     * 新增培训需求
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 结果
     */
    @Override
    public int insertCsDeptTrainingHrrequest(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
    {
        return csDeptTrainingHrrequestMapper.insertCsDeptTrainingHrrequest(csDeptTrainingHrrequest);
    }

    /**
     * 修改培训需求
     * 
     * @param csDeptTrainingHrrequest 培训需求
     * @return 结果
     */
    @Override
    public int updateCsDeptTrainingHrrequest(CsDeptTrainingHrrequest csDeptTrainingHrrequest)
    {
        return csDeptTrainingHrrequestMapper.updateCsDeptTrainingHrrequest(csDeptTrainingHrrequest);
    }

    /**
     * 批量删除培训需求
     * 
     * @param ids 需要删除的培训需求主键
     * @return 结果
     */
    @Override
    public int deleteCsDeptTrainingHrrequestByIds(String ids)
    {
        return csDeptTrainingHrrequestMapper.deleteCsDeptTrainingHrrequestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除培训需求信息
     * 
     * @param id 培训需求主键
     * @return 结果
     */
    @Override
    public int deleteCsDeptTrainingHrrequestById(Long id)
    {
        return csDeptTrainingHrrequestMapper.deleteCsDeptTrainingHrrequestById(id);
    }
}
