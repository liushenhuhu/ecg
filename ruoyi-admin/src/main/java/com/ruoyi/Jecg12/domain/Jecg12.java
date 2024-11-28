package com.ruoyi.Jecg12.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 静态12导心电数据对象 jecg_12
 * 
 * @author yangliu
 * @date 2024-11-27
 */
public class Jecg12 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** p_id */
    @Excel(name = "p_id")
    private String pId;

    /** 心电数据 */
    @Excel(name = "心电数据")
    private String ecgData;

    /** 波段标签 */
    @Excel(name = "波段标签")
    private String waveLabel;

    /** 心搏标签 */
    @Excel(name = "心搏标签")
    private String beatLabel;

    /** 矩形框 */
    @Excel(name = "矩形框")
    private String rectangles;

    public void setpId(String pId) 
    {
        this.pId = pId;
    }

    public String getpId() 
    {
        return pId;
    }
    public void setEcgData(String ecgData) 
    {
        this.ecgData = ecgData;
    }

    public String getEcgData() 
    {
        return ecgData;
    }
    public void setWaveLabel(String waveLabel) 
    {
        this.waveLabel = waveLabel;
    }

    public String getWaveLabel() 
    {
        return waveLabel;
    }
    public void setBeatLabel(String beatLabel) 
    {
        this.beatLabel = beatLabel;
    }

    public String getBeatLabel() 
    {
        return beatLabel;
    }
    public void setRectangles(String rectangles) 
    {
        this.rectangles = rectangles;
    }

    public String getRectangles() 
    {
        return rectangles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("ecgData", getEcgData())
            .append("waveLabel", getWaveLabel())
            .append("beatLabel", getBeatLabel())
            .append("rectangles", getRectangles())
            .toString();
    }
}
