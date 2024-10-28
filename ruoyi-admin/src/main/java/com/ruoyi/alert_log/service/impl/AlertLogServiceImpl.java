package com.ruoyi.alert_log.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.alert_log.mapper.AlertLogMapper;
import com.ruoyi.alert_log.domain.AlertLog;
import com.ruoyi.alert_log.service.IAlertLogService;

/**
 * 心电数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@Service
public class AlertLogServiceImpl implements IAlertLogService 
{
    @Autowired
    private AlertLogMapper alertLogMapper;

    /**
     * 查询心电数据
     * 
     * @param logId 心电数据主键
     * @return 心电数据
     */
    @Override
    public AlertLog selectAlertLogByLogId(String logId)
    {
        return alertLogMapper.selectAlertLogByLogId(logId);
    }

    /**
     * 查询心电数据列表
     * 
     * @param alertLog 心电数据
     * @return 心电数据
     */
    @Override
    public List<AlertLog> selectAlertLogList(AlertLog alertLog)
    {
        return alertLogMapper.selectAlertLogList(alertLog);
    }

    /**
     * 新增心电数据
     * 
     * @param alertLog 心电数据
     * @return 结果
     */
    @Override
    public int insertAlertLog(AlertLog alertLog)
    {
        return alertLogMapper.insertAlertLog(alertLog);
    }

    /**
     * 修改心电数据
     * 
     * @param alertLog 心电数据
     * @return 结果
     */
    @Override
    public int updateAlertLog(AlertLog alertLog)
    {
        alertLog.setUpdateTime(DateUtils.getNowDate());
        return alertLogMapper.updateAlertLog(alertLog);
    }

    /**
     * 批量删除心电数据
     * 
     * @param logIds 需要删除的心电数据主键
     * @return 结果
     */
    @Override
    public int deleteAlertLogByLogIds(String[] logIds)
    {
        return alertLogMapper.deleteAlertLogByLogIds(logIds);
    }

    /**
     * 删除心电数据信息
     * 
     * @param logId 心电数据主键
     * @return 结果
     */
    @Override
    public int deleteAlertLogByLogId(String logId)
    {
        return alertLogMapper.deleteAlertLogByLogId(logId);
    }
}
