package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsTrainingNoticeMapper;
import com.renli.system.domain.CsTrainingNotice;
import com.renli.system.service.ICsTrainingNoticeService;
import com.renli.common.core.text.Convert;

/**
 * 通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsTrainingNoticeServiceImpl implements ICsTrainingNoticeService 
{
    @Autowired
    private CsTrainingNoticeMapper csTrainingNoticeMapper;

    /**
     * 查询通知
     * 
     * @param id 通知主键
     * @return 通知
     */
    @Override
    public CsTrainingNotice selectCsTrainingNoticeById(Long id)
    {
        return csTrainingNoticeMapper.selectCsTrainingNoticeById(id);
    }

    /**
     * 查询通知列表
     * 
     * @param csTrainingNotice 通知
     * @return 通知
     */
    @Override
    public List<CsTrainingNotice> selectCsTrainingNoticeList(CsTrainingNotice csTrainingNotice)
    {
        return csTrainingNoticeMapper.selectCsTrainingNoticeList(csTrainingNotice);
    }

    /**
     * 新增通知
     * 
     * @param csTrainingNotice 通知
     * @return 结果
     */
    @Override
    public int insertCsTrainingNotice(CsTrainingNotice csTrainingNotice)
    {
        return csTrainingNoticeMapper.insertCsTrainingNotice(csTrainingNotice);
    }

    /**
     * 修改通知
     * 
     * @param csTrainingNotice 通知
     * @return 结果
     */
    @Override
    public int updateCsTrainingNotice(CsTrainingNotice csTrainingNotice)
    {
        return csTrainingNoticeMapper.updateCsTrainingNotice(csTrainingNotice);
    }

    /**
     * 批量删除通知
     * 
     * @param ids 需要删除的通知主键
     * @return 结果
     */
    @Override
    public int deleteCsTrainingNoticeByIds(String ids)
    {
        return csTrainingNoticeMapper.deleteCsTrainingNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除通知信息
     * 
     * @param id 通知主键
     * @return 结果
     */
    @Override
    public int deleteCsTrainingNoticeById(Long id)
    {
        return csTrainingNoticeMapper.deleteCsTrainingNoticeById(id);
    }
}
