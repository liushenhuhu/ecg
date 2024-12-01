package com.ruoyi.alert_type.controller;

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
import com.ruoyi.alert_type.domain.AlertType;
import com.ruoyi.alert_type.service.IAlertTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * alert_typeController
 * 
 * @author ruoyi
 * @date 2024-11-30
 */
@RestController
@RequestMapping("/alert_type/alert_type")
public class AlertTypeController extends BaseController
{
    @Autowired
    private IAlertTypeService alertTypeService;

    /**
     * 查询alert_type列表
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(AlertType alertType)
    {
        startPage();
        List<AlertType> list = alertTypeService.selectAlertTypeList(alertType);
        return getDataTable(list);
    }

    /**
     * 导出alert_type列表
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:export')")
    @Log(title = "alert_type", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AlertType alertType)
    {
        List<AlertType> list = alertTypeService.selectAlertTypeList(alertType);
        ExcelUtil<AlertType> util = new ExcelUtil<AlertType>(AlertType.class);
        util.exportExcel(response, list, "alert_type数据");
    }

    /**
     * 获取alert_type详细信息
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(alertTypeService.selectAlertTypeById(id));
    }

    /**
     * 新增alert_type
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:add')")
    @Log(title = "alert_type", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AlertType alertType)
    {
        return toAjax(alertTypeService.insertAlertType(alertType));
    }

    /**
     * 修改alert_type
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:edit')")
    @Log(title = "alert_type", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AlertType alertType)
    {
        return toAjax(alertTypeService.updateAlertType(alertType));
    }

    /**
     * 删除alert_type
     */
    @PreAuthorize("@ss.hasPermi('alert_type:alert_type:remove')")
    @Log(title = "alert_type", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(alertTypeService.deleteAlertTypeByIds(ids));
    }
}
