package com.ruoyi.alert_log.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 心电数据对象 alert_log
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
public class AlertLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志id */
    @Excel(name = "日志id")
    private String logId;

    /** 发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logTime;

    /** 预警类型 */
    @Excel(name = "预警类型")
    private String logType;

    /** 事件名称 */
    @Excel(name = "事件名称")
    private String eventName;

    /** 事件说明 */
    @Excel(name = "事件说明")
    private String eventDescription;

    /** 患者管理id */
    @Excel(name = "患者管理id")
    private String pId;

    /** 标注状态 */
    @Excel(name = "标注状态")
    private Long anoStatus;

    /** 标注数据 */
    @Excel(name = "标注数据")
    private String waveLabel;

    public void setLogId(String logId) 
    {
        this.logId = logId;
    }

    public String getLogId() 
    {
        return logId;
    }
    public void setLogTime(Date logTime) 
    {
        this.logTime = logTime;
    }

    public Date getLogTime() 
    {
        return logTime;
    }
    public void setLogType(String logType) 
    {
        this.logType = logType;
    }

    public String getLogType() 
    {
        return logType;
    }
    public void setEventName(String eventName) 
    {
        this.eventName = eventName;
    }

    public String getEventName() 
    {
        return eventName;
    }
    public void setEventDescription(String eventDescription) 
    {
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() 
    {
        return eventDescription;
    }
    public void setpId(String pId) 
    {
        this.pId = pId;
    }

    public String getpId() 
    {
        return pId;
    }
    public void setAnoStatus(Long anoStatus) 
    {
        this.anoStatus = anoStatus;
    }

    public Long getAnoStatus() 
    {
        return anoStatus;
    }
    public void setWaveLabel(String waveLabel) 
    {
        this.waveLabel = waveLabel;
    }

    public String getWaveLabel() 
    {
        return waveLabel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logTime", getLogTime())
            .append("logType", getLogType())
            .append("eventName", getEventName())
            .append("eventDescription", getEventDescription())
            .append("pId", getpId())
            .append("anoStatus", getAnoStatus())
            .append("waveLabel", getWaveLabel())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
