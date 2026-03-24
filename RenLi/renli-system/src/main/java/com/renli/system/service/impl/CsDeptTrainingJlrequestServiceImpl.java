package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsDeptTrainingJlrequestMapper;
import com.renli.system.domain.CsDeptTrainingJlrequest;
import com.renli.system.service.ICsDeptTrainingJlrequestService;
import com.renli.common.core.text.Convert;

/**
 * 培训需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsDeptTrainingJlrequestServiceImpl implements ICsDeptTrainingJlrequestService 
{
    @Autowired
    private CsDeptTrainingJlrequestMapper csDeptTrainingJlrequestMapper;

    /**
     * 查询培训需求
     * 
     * @param id 培训需求主键
     * @return 培训需求
     */
    @Override
    public CsDeptTrainingJlrequest selectCsDeptTrainingJlrequestById(Long id)
    {
        return csDeptTrainingJlrequestMapper.selectCsDeptTrainingJlrequestById(id);
    }

    /**
     * 查询培训需求列表
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 培训需求
     */
    @Override
    public List<CsDeptTrainingJlrequest> selectCsDeptTrainingJlrequestList(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
    {
        return csDeptTrainingJlrequestMapper.selectCsDeptTrainingJlrequestList(csDeptTrainingJlrequest);
    }

    /**
     * 新增培训需求
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 结果
     */
    @Override
    public int insertCsDeptTrainingJlrequest(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
    {
        return csDeptTrainingJlrequestMapper.insertCsDeptTrainingJlrequest(csDeptTrainingJlrequest);
    }

    /**
     * 修改培训需求
     * 
     * @param csDeptTrainingJlrequest 培训需求
     * @return 结果
     */
    @Override
    public int updateCsDeptTrainingJlrequest(CsDeptTrainingJlrequest csDeptTrainingJlrequest)
    {
        return csDeptTrainingJlrequestMapper.updateCsDeptTrainingJlrequest(csDeptTrainingJlrequest);
    }

    /**
     * 批量删除培训需求
     * 
     * @param ids 需要删除的培训需求主键
     * @return 结果
     */
    @Override
    public int deleteCsDeptTrainingJlrequestByIds(String ids)
    {
        return csDeptTrainingJlrequestMapper.deleteCsDeptTrainingJlrequestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除培训需求信息
     * 
     * @param id 培训需求主键
     * @return 结果
     */
    @Override
    public int deleteCsDeptTrainingJlrequestById(Long id)
    {
        return csDeptTrainingJlrequestMapper.deleteCsDeptTrainingJlrequestById(id);
    }
}
