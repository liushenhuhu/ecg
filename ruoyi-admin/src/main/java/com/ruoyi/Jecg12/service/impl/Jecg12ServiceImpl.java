package com.ruoyi.Jecg12.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Jecg12.mapper.Jecg12Mapper;
import com.ruoyi.Jecg12.domain.Jecg12;
import com.ruoyi.Jecg12.service.IJecg12Service;

/**
 * 静态12导心电数据Service业务层处理
 * 
 * @author yangliu
 * @date 2024-11-27
 */
@Service
public class Jecg12ServiceImpl implements IJecg12Service 
{
    @Autowired
    private Jecg12Mapper jecg12Mapper;

    /**
     * 查询静态12导心电数据
     * 
     * @param pId 静态12导心电数据主键
     * @return 静态12导心电数据
     */
    @Override
    public Jecg12 selectJecg12ByPId(String pId)
    {
        return jecg12Mapper.selectJecg12ByPId(pId);
    }

    /**
     * 查询静态12导心电数据列表
     * 
     * @param jecg12 静态12导心电数据
     * @return 静态12导心电数据
     */
    @Override
    public List<Jecg12> selectJecg12List(Jecg12 jecg12)
    {
        return jecg12Mapper.selectJecg12List(jecg12);
    }

    /**
     * 新增静态12导心电数据
     * 
     * @param jecg12 静态12导心电数据
     * @return 结果
     */
    @Override
    public int insertJecg12(Jecg12 jecg12)
    {
        return jecg12Mapper.insertJecg12(jecg12);
    }

    /**
     * 修改静态12导心电数据
     * 
     * @param jecg12 静态12导心电数据
     * @return 结果
     */
    @Override
    public int updateJecg12(Jecg12 jecg12)
    {
        return jecg12Mapper.updateJecg12(jecg12);
    }

    /**
     * 批量删除静态12导心电数据
     * 
     * @param pIds 需要删除的静态12导心电数据主键
     * @return 结果
     */
    @Override
    public int deleteJecg12ByPIds(String[] pIds)
    {
        return jecg12Mapper.deleteJecg12ByPIds(pIds);
    }

    /**
     * 删除静态12导心电数据信息
     * 
     * @param pId 静态12导心电数据主键
     * @return 结果
     */
    @Override
    public int deleteJecg12ByPId(String pId)
    {
        return jecg12Mapper.deleteJecg12ByPId(pId);
    }
}
