package com.ruoyi.alert_type.service;

import java.util.List;
import com.ruoyi.alert_type.domain.AlertType;

/**
 * alert_typeService接口
 * 
 * @author ruoyi
 * @date 2024-11-30
 */
public interface IAlertTypeService 
{
    /**
     * 查询alert_type
     * 
     * @param id alert_type主键
     * @return alert_type
     */
    public AlertType selectAlertTypeById(Long id);

    /**
     * 查询alert_type列表
     * 
     * @param alertType alert_type
     * @return alert_type集合
     */
    public List<AlertType> selectAlertTypeList(AlertType alertType);

    /**
     * 新增alert_type
     * 
     * @param alertType alert_type
     * @return 结果
     */
    public int insertAlertType(AlertType alertType);

    /**
     * 修改alert_type
     * 
     * @param alertType alert_type
     * @return 结果
     */
    public int updateAlertType(AlertType alertType);

    /**
     * 批量删除alert_type
     * 
     * @param ids 需要删除的alert_type主键集合
     * @return 结果
     */
    public int deleteAlertTypeByIds(Long[] ids);

    /**
     * 删除alert_type信息
     * 
     * @param id alert_type主键
     * @return 结果
     */
    public int deleteAlertTypeById(Long id);
}
