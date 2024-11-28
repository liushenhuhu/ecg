package com.ruoyi.Jecg12.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Jecg12.domain.Jecg12;
import com.ruoyi.Jecg12.service.IJecg12Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 静态12导心电数据Controller
 * 
 * @author yangliu
 * @date 2024-11-27
 */
@RestController
@RequestMapping("/Jecg12/Jecg12")
public class Jecg12Controller extends BaseController
{
    @Autowired
    private IJecg12Service jecg12Service;

    /**
     * 查询静态12导心电数据列表
     */
    @PreAuthorize("@ss.hasPermi('Jecg12:Jecg12:list')")
    @GetMapping("/list")
    public TableDataInfo list(Jecg12 jecg12)
    {
        startPage();
        List<Jecg12> list = jecg12Service.selectJecg12List(jecg12);
        return getDataTable(list);
    }

    /**
     * 导出静态12导心电数据列表
     */
      @Log(title = "静态12导心电数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Jecg12 jecg12)
    {
        List<Jecg12> list = jecg12Service.selectJecg12List(jecg12);
        ExcelUtil<Jecg12> util = new ExcelUtil<Jecg12>(Jecg12.class);
        util.exportExcel(response, list, "静态12导心电数据数据");
    }

    /**
     * 获取静态12导心电数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('Jecg12:Jecg12:query')")
    @GetMapping(value = "/{pId}")
    public AjaxResult getInfo(@PathVariable("pId") String pId)
    {
        return success(jecg12Service.selectJecg12ByPId(pId));
    }

    /**
     * 新增静态12导心电数据
     */
    @PreAuthorize("@ss.hasPermi('Jecg12:Jecg12:add')")
    @Log(title = "静态12导心电数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Jecg12 jecg12)
    {
        return toAjax(jecg12Service.insertJecg12(jecg12));
    }

    /**
     * 修改静态12导心电数据
     */
    @PreAuthorize("@ss.hasPermi('Jecg12:Jecg12:edit')")
    @Log(title = "静态12导心电数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Jecg12 jecg12)
    {
        return toAjax(jecg12Service.updateJecg12(jecg12));
    }

    /**
     * 删除静态12导心电数据
     */
    @PreAuthorize("@ss.hasPermi('Jecg12:Jecg12:remove')")
    @Log(title = "静态12导心电数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pIds}")
    public AjaxResult remove(@PathVariable String[] pIds)
    {
        return toAjax(jecg12Service.deleteJecg12ByPIds(pIds));
    }
}
