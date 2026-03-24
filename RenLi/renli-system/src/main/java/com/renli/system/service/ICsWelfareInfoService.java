package com.renli.system.service;

import java.util.List;
import com.renli.system.domain.CsWelfareInfo;

/**
 * 员工福利信息Service接口
 * 
 * @author ruoyi
 * @date 2026-03-02
 */
public interface ICsWelfareInfoService 
{
    /**
     * 查询员工福利信息
     * 
     * @param id 员工福利信息主键
     * @return 员工福利信息
     */
    public CsWelfareInfo selectCsWelfareInfoById(Long id);

    /**
     * 查询员工福利信息列表
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 员工福利信息集合
     */
    public List<CsWelfareInfo> selectCsWelfareInfoList(CsWelfareInfo csWelfareInfo);

    /**
     * 新增员工福利信息
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 结果
     */
    public int insertCsWelfareInfo(CsWelfareInfo csWelfareInfo);

    /**
     * 修改员工福利信息
     * 
     * @param csWelfareInfo 员工福利信息
     * @return 结果
     */
    public int updateCsWelfareInfo(CsWelfareInfo csWelfareInfo);

    /**
     * 批量删除员工福利信息
     * 
     * @param ids 需要删除的员工福利信息主键集合
     * @return 结果
     */
    public int deleteCsWelfareInfoByIds(String ids);

    /**
     * 删除员工福利信息信息
     * 
     * @param id 员工福利信息主键
     * @return 结果
     */
    public int deleteCsWelfareInfoById(Long id);
}
