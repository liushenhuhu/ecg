package com.ruoyi.Jecg12.mapper;

import java.util.List;
import com.ruoyi.Jecg12.domain.Jecg12;

/**
 * 静态12导心电数据Mapper接口
 * 
 * @author yangliu
 * @date 2024-11-27
 */
public interface Jecg12Mapper 
{
    /**
     * 查询静态12导心电数据
     * 
     * @param pId 静态12导心电数据主键
     * @return 静态12导心电数据
     */
    public Jecg12 selectJecg12ByPId(String pId);

    /**
     * 查询静态12导心电数据列表
     * 
     * @param jecg12 静态12导心电数据
     * @return 静态12导心电数据集合
     */
    public List<Jecg12> selectJecg12List(Jecg12 jecg12);

    /**
     * 新增静态12导心电数据
     * 
     * @param jecg12 静态12导心电数据
     * @return 结果
     */
    public int insertJecg12(Jecg12 jecg12);

    /**
     * 修改静态12导心电数据
     * 
     * @param jecg12 静态12导心电数据
     * @return 结果
     */
    public int updateJecg12(Jecg12 jecg12);

    /**
     * 删除静态12导心电数据
     * 
     * @param pId 静态12导心电数据主键
     * @return 结果
     */
    public int deleteJecg12ByPId(String pId);

    /**
     * 批量删除静态12导心电数据
     * 
     * @param pIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJecg12ByPIds(String[] pIds);
}
