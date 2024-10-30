<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日志id" prop="logId">
        <el-input
          v-model="queryParams.logId"
          placeholder="请输入日志id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发生时间" prop="logTime">
        <el-date-picker clearable
          v-model="queryParams.logTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发生时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="事件名称" prop="eventName">
        <el-input
          v-model="queryParams.eventName"
          placeholder="请输入事件名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="事件说明" prop="eventDescription">
        <el-input
          v-model="queryParams.eventDescription"
          placeholder="请输入事件说明"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者管理id" prop="pId">
        <el-input
          v-model="queryParams.pId"
          placeholder="请输入患者管理id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['alert_log:alert_log:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['alert_log:alert_log:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['alert_log:alert_log:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['alert_log:alert_log:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="alert_logList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日志id" align="center" prop="logId" />
      <el-table-column label="发生时间" align="center" prop="logTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.logTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预警类型" align="center" prop="logType" />
      <el-table-column label="事件名称" align="center" prop="eventName" />
      <el-table-column label="事件说明" align="center" prop="eventDescription" />
      <el-table-column label="患者管理id" align="center" prop="pId" />
      <el-table-column label="标注状态" align="center" prop="anoStatus" />
      <el-table-column label="标注数据" align="center" prop="waveLabel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleLabel(scope.row)"
            v-hasPermi="['alert_log:alert_log:edit']"
          >标注</el-button>
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['alert_log:alert_log:edit']"-->
<!--          >修改</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['alert_log:alert_log:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改心电数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日志id" prop="logId">
          <el-input v-model="form.logId" placeholder="请输入日志id" />
        </el-form-item>
        <el-form-item label="发生时间" prop="logTime">
          <el-date-picker clearable
            v-model="form.logTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发生时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="事件名称" prop="eventName">
          <el-input v-model="form.eventName" placeholder="请输入事件名称" />
        </el-form-item>
        <el-form-item label="事件说明" prop="eventDescription">
          <el-input v-model="form.eventDescription" placeholder="请输入事件说明" />
        </el-form-item>
        <el-form-item label="患者管理id" prop="pId">
          <el-input v-model="form.pId" placeholder="请输入患者管理id" />
        </el-form-item>
        <el-form-item label="标注数据" prop="waveLabel">
          <el-input v-model="form.waveLabel" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAlert_log, getAlert_log, delAlert_log, addAlert_log, updateAlert_log } from "@/api/alert_log/alert_log";

export default {
  name: "Alert_log",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 心电数据表格数据
      alert_logList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        logId: null,
        logTime: null,
        logType: null,
        eventName: null,
        eventDescription: null,
        pId: null,
        anoStatus: null,
        waveLabel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        logId: [
          { required: true, message: "日志id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询心电数据列表 */
    getList() {
      this.loading = true;
      listAlert_log(this.queryParams).then(response => {
        this.alert_logList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        logId: null,
        logTime: null,
        logType: null,
        eventName: null,
        eventDescription: null,
        anoStatus: null,
        waveLabel: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.logId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加心电数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const logId = row.logId || this.ids
      getAlert_log(logId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改心电数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.logId != null) {
            updateAlert_log(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAlert_log(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const logIds = row.logId || this.ids;
      this.$modal.confirm('是否确认删除心电数据编号为"' + logIds + '"的数据项？').then(function() {
        return delAlert_log(logIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('alert_log/alert_log/export', {
        ...this.queryParams
      }, `alert_log_${new Date().getTime()}.xlsx`)
    },
    /** 查看标注*/
    handleLabel(row) {
      // console.log(row.logId);
      // this.$router.push({
      //   name: "lookLog",
      //   params: {logId: row.logId, logType: row.logType, userId: 0}
      // });
      this.$router.push({
        path: "/LabelEcg12",// name: "lookLog"

        query: {
          logId: row.logId,

          //当前查询参数
          pageNum: this.queryParams.pageNum,
          pageSize: this.queryParams.pageSize,
          anoStatus: this.queryParams.anoStatus,
          logTime: this.queryParams.logTime,

        },
      });
    },
  }
};
</script>
