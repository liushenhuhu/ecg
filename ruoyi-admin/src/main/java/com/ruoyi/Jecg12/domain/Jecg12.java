package com.ruoyi.Jecg12.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 静态12导心电数据对象 jecg_12
 * 
 * @author yangliu
 * @date 2024-12-01
 */
public class Jecg12 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 心电日志id */
    @Excel(name = "心电日志id")
    private String pId;

    /** 心电数据 */
    @Excel(name = "心电数据")
    private String ecgData;

    /** 波段标注标签 */
    @Excel(name = "波段标注标签")
    private String waveLabel;

    /** 心搏标注标签 */
    @Excel(name = "心搏标注标签")
    private String beatLabel;

    /** 波段标注中的矩形框标签 */
    @Excel(name = "波段标注中的矩形框标签")
    private String rectangles;

    /** 噪声等级标签 */
    @Excel(name = "噪声等级标签")
    private String noiseLevel;

    /** 预警类型的选择 */
    @Excel(name = "预警类型的选择")
    private String options1;

    /** 心肌炎的选择 */
    @Excel(name = "心肌炎的选择")
    private String options2;

    /** 是否疑似病例 */
    @Excel(name = "是否疑似病例")
    private Long isSuspected;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String others;

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
    public void setNoiseLevel(String noiseLevel) 
    {
        this.noiseLevel = noiseLevel;
    }

    public String getNoiseLevel() 
    {
        return noiseLevel;
    }
    public void setOptions1(String options1) 
    {
        this.options1 = options1;
    }

    public String getOptions1() 
    {
        return options1;
    }
    public void setOptions2(String options2) 
    {
        this.options2 = options2;
    }

    public String getOptions2() 
    {
        return options2;
    }
    public void setIsSuspected(Long isSuspected) 
    {
        this.isSuspected = isSuspected;
    }

    public Long getIsSuspected() 
    {
        return isSuspected;
    }
    public void setOthers(String others) 
    {
        this.others = others;
    }

    public String getOthers() 
    {
        return others;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("ecgData", getEcgData())
            .append("waveLabel", getWaveLabel())
            .append("beatLabel", getBeatLabel())
            .append("rectangles", getRectangles())
            .append("noiseLevel", getNoiseLevel())
            .append("options1", getOptions1())
            .append("options2", getOptions2())
            .append("isSuspected", getIsSuspected())
            .append("others", getOthers())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
