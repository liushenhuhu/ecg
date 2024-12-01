package com.ruoyi.alert_type.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.alert_type.mapper.AlertTypeMapper;
import com.ruoyi.alert_type.domain.AlertType;
import com.ruoyi.alert_type.service.IAlertTypeService;

/**
 * alert_typeService业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-30
 */
@Service
public class AlertTypeServiceImpl implements IAlertTypeService 
{
    @Autowired
    private AlertTypeMapper alertTypeMapper;

    /**
     * 查询alert_type
     * 
     * @param id alert_type主键
     * @return alert_type
     */
    @Override
    public AlertType selectAlertTypeById(Long id)
    {
        return alertTypeMapper.selectAlertTypeById(id);
    }

    /**
     * 查询alert_type列表
     * 
     * @param alertType alert_type
     * @return alert_type
     */
    @Override
    public List<AlertType> selectAlertTypeList(AlertType alertType)
    {
        return alertTypeMapper.selectAlertTypeList(alertType);
    }

    /**
     * 新增alert_type
     * 
     * @param alertType alert_type
     * @return 结果
     */
    @Override
    public int insertAlertType(AlertType alertType)
    {
        return alertTypeMapper.insertAlertType(alertType);
    }

    /**
     * 修改alert_type
     * 
     * @param alertType alert_type
     * @return 结果
     */
    @Override
    public int updateAlertType(AlertType alertType)
    {
        return alertTypeMapper.updateAlertType(alertType);
    }

    /**
     * 批量删除alert_type
     * 
     * @param ids 需要删除的alert_type主键
     * @return 结果
     */
    @Override
    public int deleteAlertTypeByIds(Long[] ids)
    {
        return alertTypeMapper.deleteAlertTypeByIds(ids);
    }

    /**
     * 删除alert_type信息
     * 
     * @param id alert_type主键
     * @return 结果
     */
    @Override
    public int deleteAlertTypeById(Long id)
    {
        return alertTypeMapper.deleteAlertTypeById(id);
    }
}
