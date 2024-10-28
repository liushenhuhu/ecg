package com.ruoyi.alert_log.controller;

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
import com.ruoyi.alert_log.domain.AlertLog;
import com.ruoyi.alert_log.service.IAlertLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 心电数据Controller
 * 
 * @author ruoyi
 * @date 2024-10-28
 */
@RestController
@RequestMapping("/alert_log/alert_log")
public class AlertLogController extends BaseController
{
    @Autowired
    private IAlertLogService alertLogService;

    /**
     * 查询心电数据列表
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:list')")
    @GetMapping("/list")
    public TableDataInfo list(AlertLog alertLog)
    {
        startPage();
        List<AlertLog> list = alertLogService.selectAlertLogList(alertLog);
        return getDataTable(list);
    }

    /**
     * 导出心电数据列表
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:export')")
    @Log(title = "心电数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AlertLog alertLog)
    {
        List<AlertLog> list = alertLogService.selectAlertLogList(alertLog);
        ExcelUtil<AlertLog> util = new ExcelUtil<AlertLog>(AlertLog.class);
        util.exportExcel(response, list, "心电数据数据");
    }

    /**
     * 获取心电数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") String logId)
    {
        return success(alertLogService.selectAlertLogByLogId(logId));
    }

    /**
     * 新增心电数据
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:add')")
    @Log(title = "心电数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AlertLog alertLog)
    {
        return toAjax(alertLogService.insertAlertLog(alertLog));
    }

    /**
     * 修改心电数据
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:edit')")
    @Log(title = "心电数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AlertLog alertLog)
    {
        return toAjax(alertLogService.updateAlertLog(alertLog));
    }

    /**
     * 删除心电数据
     */
    @PreAuthorize("@ss.hasPermi('alert_log:alert_log:remove')")
    @Log(title = "心电数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable String[] logIds)
    {
        return toAjax(alertLogService.deleteAlertLogByLogIds(logIds));
    }
}
