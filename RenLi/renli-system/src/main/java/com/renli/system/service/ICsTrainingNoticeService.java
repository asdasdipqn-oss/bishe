package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsTrainingNotice;

/**
 * 通知Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsTrainingNoticeService 
{
    /**
     * 查询通知
     * 
     * @param id 通知主键
     * @return 通知
     */
    public CsTrainingNotice selectCsTrainingNoticeById(Long id);

    /**
     * 查询通知列表
     * 
     * @param csTrainingNotice 通知
     * @return 通知集合
     */
    public List<CsTrainingNotice> selectCsTrainingNoticeList(CsTrainingNotice csTrainingNotice);

    /**
     * 新增通知
     * 
     * @param csTrainingNotice 通知
     * @return 结果
     */
    public int insertCsTrainingNotice(CsTrainingNotice csTrainingNotice);

    /**
     * 修改通知
     * 
     * @param csTrainingNotice 通知
     * @return 结果
     */
    public int updateCsTrainingNotice(CsTrainingNotice csTrainingNotice);

    /**
     * 批量删除通知
     * 
     * @param ids 需要删除的通知主键集合
     * @return 结果
     */
    public int deleteCsTrainingNoticeByIds(String ids);

    /**
     * 删除通知信息
     * 
     * @param id 通知主键
     * @return 结果
     */
    public int deleteCsTrainingNoticeById(Long id);
}
