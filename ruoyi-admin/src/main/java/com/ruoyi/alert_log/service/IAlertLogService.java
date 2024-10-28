package com.ruoyi.alert_log.service;

import java.util.List;
import com.ruoyi.alert_log.domain.AlertLog;

/**
 * 心电数据Service接口
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public interface IAlertLogService 
{
    /**
     * 查询心电数据
     * 
     * @param logId 心电数据主键
     * @return 心电数据
     */
    public AlertLog selectAlertLogByLogId(String logId);

    /**
     * 查询心电数据列表
     * 
     * @param alertLog 心电数据
     * @return 心电数据集合
     */
    public List<AlertLog> selectAlertLogList(AlertLog alertLog);

    /**
     * 新增心电数据
     * 
     * @param alertLog 心电数据
     * @return 结果
     */
    public int insertAlertLog(AlertLog alertLog);

    /**
     * 修改心电数据
     * 
     * @param alertLog 心电数据
     * @return 结果
     */
    public int updateAlertLog(AlertLog alertLog);

    /**
     * 批量删除心电数据
     * 
     * @param logIds 需要删除的心电数据主键集合
     * @return 结果
     */
    public int deleteAlertLogByLogIds(String[] logIds);

    /**
     * 删除心电数据信息
     * 
     * @param logId 心电数据主键
     * @return 结果
     */
    public int deleteAlertLogByLogId(String logId);
}
