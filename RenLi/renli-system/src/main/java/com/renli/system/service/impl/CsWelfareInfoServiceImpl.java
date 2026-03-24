package com.renli.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renli.system.mapper.CsWelfareInfoMapper;
import com.renli.system.domain.CsWelfareInfo;
import com.renli.system.service.ICsWelfareInfoService;
import com.renli.common.core.text.Convert;

/**
 * 员工福利信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
@Service
public class CsWelfareInfoServiceImpl implements ICsWelfareInfoService 
{
    @Autowired
    private CsWelfareInfoMapper csWelfareInfoMapper;

    /**
     * 查询员工福利信息
     * 
     * @param id 员工福利信息主键
     * @return 员工福利信息
     */
    @Override
    public CsWelfareInfo selectCsWelfareInfoById(Long id)
    {
        return csWelfareInfoMapper.selectCsWelfareInfoById(id);
    }

    /**
     * 查询员工福利信息列表
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 员工福利信息
     */
    @Override
    public List<CsWelfareInfo> selectCsWelfareInfoList(CsWelfareInfo csWelfareInfo)
    {
        return csWelfareInfoMapper.selectCsWelfareInfoList(csWelfareInfo);
    }

    /**
     * 新增员工福利信息
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 结果
     */
    @Override
    public int insertCsWelfareInfo(CsWelfareInfo csWelfareInfo)
    {
        return csWelfareInfoMapper.insertCsWelfareInfo(csWelfareInfo);
    }

    /**
     * 修改员工福利信息
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 结果
     */
    @Override
    public int updateCsWelfareInfo(CsWelfareInfo csWelfareInfo)
    {
        return csWelfareInfoMapper.updateCsWelfareInfo(csWelfareInfo);
    }

    /**
     * 批量删除员工福利信息
     * 
     * @param ids 需要删除的员工福利信息主键
     * @return 结果
     */
    @Override
    public int deleteCsWelfareInfoByIds(String ids)
    {
        return csWelfareInfoMapper.deleteCsWelfareInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工福利信息信息
     * 
     * @param id 员工福利信息主键
     * @return 结果
     */
    @Override
    public int deleteCsWelfareInfoById(Long id)
    {
        return csWelfareInfoMapper.deleteCsWelfareInfoById(id);
    }
}
