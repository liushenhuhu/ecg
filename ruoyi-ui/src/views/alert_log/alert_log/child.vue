<!--图片标记-->
<template>
  <div>

    <el-tabs
      ref="tab"
      v-model="activeName"
      class="container"
      type="border-card"
      @tab-click="handleClick"
      v-show="drawShow"
      style="z-index: 2"
    >
      <el-tab-pane label="心搏标注" name="first">
        <span slot="label" class="tab_label">心搏标注</span>
        <div
          style="height: 80vh"
          v-loading="isLoading"
          element-loading-text="数据加载中..."
          element-loading-background="rgba(0, 0, 0, 0.8)"
          @contextmenu.prevent
        >
          <!--顶部工具栏-->
          <div class="top-tool">
            <!--左上角盒子-->
            <div class="top-left-div" v-show="lead1">
              <el-radio-group style="margin: auto" v-model="radio1">
                <el-radio-button
                  @click.native.prevent="clickitem1('Normal')"
                  label="Normal"
                >正常
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem1('FangZao')"
                  label="FangZao"
                >房早
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem1('ShiZao')"
                  label="ShiZao"
                >室早
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem1('FangYi')"
                  label="FangYi"
                >房逸
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem1('GanRao')"
                  label="GanRao"
                >干扰
                </el-radio-button
                >
              </el-radio-group>
              <el-popover
                style="margin: auto"
                placement="bottom-start"
                title="提示"
                width="220"
                trigger="hover"
              >
                <p class="tipck">1. 左上角按钮可以选择类型</p>
                <!--          <p class="tipck">2. 左键按下,可以拖拽心电图;</p>-->
                <p class="tipck">2. 左键单击，进行标点</p>
                <p class="tipck">3. 右键单击，进行删除</p>
                <p class="tipck">4. 也可点击右上角清空所有点</p>
                <p class="tipck">5. 标点完成后，点击右上角提交</p>
                <el-button slot="reference"
                ><i class="el-icon-info icon"></i
                ></el-button>
              </el-popover>
            </div>
            <!--右上角盒子-->
            <div class="top-right-div">
              <!--清空画布-->
              <el-tooltip
                class="item"
                effect="dark"
                content="清空标记"
                placement="bottom"
                v-show="lead1"
              >
                <el-button type="primary" class="clear-btn" @click="clickClear">
                  <i class="el-icon-delete"></i>
                </el-button>
              </el-tooltip>

              <!-- 提交数据 -->
              <el-tooltip
                class="item"
                effect="dark"
                content="提交标记信息"
                placement="bottom"
                v-show="lead1"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="submit()"
                >
                  <i class="el-icon-finished"></i>
                </el-button>
              </el-tooltip>
              <!--关闭标注窗口-->
              <el-tooltip
                class="item"
                effect="dark"
                content="关闭窗口"
                placement="bottom"
                v-show="lead1"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="clickClose"
                >
                  <i class="el-icon-close"></i>
                </el-button>
              </el-tooltip>
            </div>
          </div>
          <!--画布盒子-->
          <div class="middle-div">
            <!-- 图1 -->
            <div class="canvas-div" id="chart"></div>
            <div id="rightMenu1" class="menu" style="display: none;">
              <el-button class="button" @click="del">删除</el-button>
            </div>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="波段标注" name="second">
        <!--        <div class="loading-container" v-if="true">-->
        <!--          <div class="spinner"></div>-->
        <!--        </div>-->
        <span slot="label" class="tab_label">波段标注</span>


        <div
          id="waveLabelLoading"
          style="height: 80vh"
          v-loading="isLoading"
          :element-loading-text="isLoadingText"
          element-loading-background="rgba(0, 0, 0, 0.8)"
          @contextmenu.prevent
        >
          <!--顶部工具栏-->
          <div class="top-tool">
            <!--左上角盒子-->
            <div class="top-left-div" v-show="lead2">
              <el-radio-group style="margin: auto" v-model="radio2">
                <el-radio-button
                  @click.native.prevent="clickitem('P1')"
                  label="P1"
                >P1
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('P2')"
                  label="P2"
                >P2
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('P3')"
                  label="P3"
                >P3
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('R1')"
                  label="R1"
                >R1
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('R2')"
                  label="R2"
                >R2
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('R3')"
                  label="R3"
                >R3
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('T1')"
                  label="T1"
                >T1
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('T2')"
                  label="T2"
                >T2
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem('T3')"
                  label="T3"
                >T3
                </el-radio-button
                >
                <el-radio-button
                  @click.native.prevent="clickitem2('rec')"
                  label="rec"
                >画框
                </el-radio-button
                >
              </el-radio-group>
              <el-popover
                style="margin: auto"
                placement="bottom-start"
                title="提示"
                width="220"
                trigger="hover"
              >
                <p class="tipck">1. 左上角按钮可以选择类型</p>
                <p class="tipck">2. 左键单击，进行标点</p>
                <p class="tipck">3. 右键单击，进行删除</p>
                <p class="tipck">4. 也可点击右上角清空所有点</p>
                <p class="tipck">5. 标点完成后，点击右上角提交</p>
                <el-button slot="reference"
                ><i class="el-icon-info icon"></i
                ></el-button>
              </el-popover>
            </div>
            <!--右上角盒子-->
            <div class="top-right-div">
              <el-tooltip
                class="item"
                effect="dark"
                content="AI标注"
                placement="bottom"
                v-show="lead2"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="AILabel()"
                >
                  <i class="el-icon-monitor"></i>
                </el-button>
              </el-tooltip>
              <!--清空画布-->
              <el-tooltip
                class="item"
                effect="dark"
                content="清空标记"
                placement="bottom"
                v-show="lead2"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="clearData()"
                >
                  <i class="el-icon-delete"></i>
                </el-button>
              </el-tooltip>

              <!-- 提交数据 -->
              <el-tooltip
                class="item"
                effect="dark"
                content="提交标记信息"
                placement="bottom"
                v-show="lead2"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="submit()"
                >
                  <i class="el-icon-finished"></i>
                </el-button>
              </el-tooltip>
              <!--关闭标注窗口-->
              <el-tooltip
                class="item"
                effect="dark"
                content="关闭窗口"
                placement="bottom"
                v-show="lead2"
              >
                <el-button
                  type="primary"
                  class="clear-btn"
                  @click="clickClose"
                >
                  <i class="el-icon-close"></i>
                </el-button>
              </el-tooltip>
            </div>
          </div>
          <!--画布盒子-->
          <div class="middle-div">
            <div class="canvas-div" id="chart2"></div>
            <div id="rightMenu2" class="menu" style="display: none">
              <el-button class="button" @click="del2">删除</el-button>
            </div>
          </div>

        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>

import * as echarts from "@/api/tool/echarts.min.js";
import $ from "jquery";
import {updateJecg12} from "@/api/Jecg12/Jecg12";
import {throttle} from "echarts";

let ctx = ""; //画布上下文
export default {
  props: {},
  data() {
    return {
      activeName: "first", //tab切换
      drawShow: false, //弹框开关
      isLoading: false, //加载状态
      isLoadingText: "",
      radio1: "", //选中类型 Normal FangZao
      radio2: "", //选中类型 P1 P2
      isDrawRec: false, //是否画框

      pId: null, //报告pid
      level: null, //第几段
      chart: null, //心博标注 echarts
      chart2: null, //波段标注 echarts
      delX: {key: null, value: null}, //想要删除的点
      seriesdata: [
        {yAxis: -2},
        {yAxis: -1.5},
        {yAxis: -1},
        {yAxis: -0.5},
        {yAxis: 0},
        {yAxis: 0.5},
        {yAxis: 1},
        {yAxis: 1.5},
        {yAxis: 2},
        {yAxis: -3},
        {yAxis: -2.5},
        {yAxis: 3},
        {yAxis: 2.5},
      ], //标线
      x: [], //x轴值
      data: [], //导联数据
      dataLength: 0,
      subData: {
        //波段标注 某一段的数据
        P1: [],
        P2: [],
        P3: [],
        R1: [],
        R2: [],
        R3: [],
        T1: [],
        T2: [],
        T3: [],
      }, //提交标注信息
      isselected: false,  //是否选中矩形框
      selectrectangleIndex: -1,  //选中的矩形框的下标

      lead1: true, //是否可以标注
      lead2: true, //是否可以标注
      closeStyle: {position: "absolute", right: "1px", top: "20px"},
      datalabel: {
        //进来页面时读取的标注数据
        waveLabel: "",
        beatLabel: "",
        rectangles: "",
      },
      title: "", //几导联
      userFavor: {//用户偏好

        Normal: "q",
        FangZao: "w",
        ShiZao: "e",
        FangYi: "r",
        GanRao: "t",
        P1: "q",
        P2: "w",
        P3: "e",
        R1: "a",
        R2: "s",
        R3: "d",
        T1: "z",
        T2: "x",
        T3: "c",
        rectangles: "r",
        tab_beatlabel: "1",
        tab_wavelabel: "2",
        beat_autolabel: true,
        wave_autolabel: true,
        rectangles_autolabel: true,
        noise_autolabel: true,
      }
    };
  },
  watch: {
    lead1: {
      handler(item1, item2) {
        // item1为新值，item2为旧值
        if (!item1) {
          this.closeStyle = {position: "absolute", right: "1px", top: "20px"};
        } else {
          this.closeStyle = {position: "static", right: "1px", top: "20px"};
        }
      },
    },
    lead2: {
      handler(item1, item2) {
        // item1为新值，item2为旧值
        if (!item1) {
          this.closeStyle = {position: "absolute", right: "1px", top: "20px"};
        } else {
          this.closeStyle = {position: "static", right: "1px", top: "20px"};
        }
      },
    },
  },
  created() {
  },
  mounted() {
    //添加快捷键
    window.addEventListener('keydown', this.handleGlobalkeydown);
  },
  beforeDestroy() {
    window.removeEventListener('keydown', this.handleGlobalkeydown);

  },

  methods: {
    initData() {
      this.isLoading = false
      this.isLoadingText = ""
      this.radio1 = ""
      this.radio2 = ""
      this.isDrawRec = false
      if (this.chart) {
        this.chart.dispose();
      }
      if (this.chart2) {
        this.chart2.dispose();
      }
      this.delX = {key: null, value: null}
      this.seriesdata = [
        {yAxis: -2},
        {yAxis: -1.5},
        {yAxis: -1},
        {yAxis: -0.5},
        {yAxis: 0},
        {yAxis: 0.5},
        {yAxis: 1},
        {yAxis: 1.5},
        {yAxis: 2},
        {yAxis: -3},
        {yAxis: -2.5},
        {yAxis: 3},
        {yAxis: 2.5},
      ]
      this.x =[]
      this.data = []
      this.isselected = false
      this.selectrectangleIndex = -1
      this.lead1 = true
      this.lead2 = true
      this.closeStyle = {position: "absolute", right: "1px", top: "20px"}
    },
    //心博标注 初始化
    async getchart(data, pIds, level, title, datalabel) {
      this.initData()
      this.chart = echarts.init(document.getElementById("chart"));
      this.dataLength = data.length;
      // data = data.slice(0, this.dataLength);
      this.title = title;

      if (datalabel != null) {
        this.datalabel = datalabel;
      }
      this.drawShow = true;
      this.data = data;
      this.pId = pIds;
      this.level = level;
      for (var i = 0; i <= data.length; i++) {
        this.x.push(i);
      }

      for (let i = 0; i < this.dataLength; i += 20) {
        this.seriesdata.push({xAxis: i});
      }
      //标线
      const seriesdata = this.seriesdata;

      let titleStr = title;

      //绘图
      let detailoption = {
        title: {
          text: titleStr || "",
          top: 10,
          left: 50,
        },
        animation: false,
        backgroundColor: "#ffffff",
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
          },
        },
        toolbox: {
          show: false,
        },
        dataZoom: [
          {
            show: true, // 滑动条组件
            type: "slider",
            brushSelect: false,
            // y: '90%',
            startValue: 0,
            endValue: 638,
            maxValueSpan: 638,
          },
          {
            show: true, // 滑动条组件
            type: "slider",
            orient: "vertical",
            brushSelect: false,
            start: 0,
            end: 100,
          },
          {
            type: "inside",
            orient: "vertical", // 鼠标滚轮缩放
            start: 0,
            end: 100,
          },
          {
            type: "inside", // 鼠标滚轮缩放
            y: "90%",
            start: 0,
            end: 100,
          },
        ],
        grid: {
          left: "3%",
          right: "3%",
          top: "5%",
          bottom: "13%",
        },
        legend: {
          show: false,
          data: ["当前电位"],
          textStyle: {color: "#000000"} /*图例(legend)说明文字的颜色*/,
          left: "right",
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: this.x,
          axisTick: {
            show: false,
          },
          axisLabel: {
            //修改坐标系字体颜色
            interval: 3,
            show: false,
            textStyle: {
              color: "#000000",
            },
          },
          splitLine: {
            show: true,
            lineStyle: {
              color: "pink",
              width: 1, //网格的宽度
              type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
            },
          } /*网格线*/,
        },
        yAxis: {
          min: -3,
          max: 3,
          boundaryGap: false,
          splitNumber: 51,
          minInterval: 0.1,
          axisLabel: {
            //修改坐标系字体颜色
            show: false,
            textStyle: {
              color: "#000000",
            },
          },
          splitLine: {
            show: true,
            lineStyle: {
              color: "pink",
              width: 1, //网格的宽度
              type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
            },
          } /*网格线*/,
        },
        series: {
          id: "series1",
          markLine: {
            animation: false,
            symbol: "none",
            silent: true,
            lineStyle: {
              type: "solid",
              color: "#b33939",
              width: 0.5,
            },
            label: {
              show: true,
              position: "start", // 表现内容展示的位置
              color: "#b33939", // 展示内容颜色
            },
            data: seriesdata,
          },
          itemStyle: {
            normal: {
              lineStyle: {
                width: 1.5,
                color: "#000000" /*折线的颜色*/,
              },
              color: "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
            },
          },
          symbol: "none",
          name: "当前电位",
          type: "line",
          data: data,
          zlevel: 99,
          smooth: true, //显示为平滑的曲线*/
        },

      };
      this.chart.clear();
      this.chart.setOption(detailoption, true);

      setTimeout(() => {
        this.chart.resize();
      });

      if (this.lead1) {
        this.chart1_redraw()

      }
      $(window).resize(() => {
        this.chart.resize();
      });
      var width = window.screen.width;
      var height = window.screen.height;

      this.chart.off("contextmenu");

      //右击显示删除
      this.chart.on("contextmenu", (params) => {
        console.log("begin");
        $("#rightMenu1").css({
          display: "block",
          // left: 500,
          // top: 500,
          left: (params.event.offsetX / width) * 100 + "vw",
          top: (params.event.offsetY / height) * 100 + 11 + "vh",
        });

        if (params.componentType === "markPoint") {
          this.delX.value = params.data.xAxis;
          this.delX.key = params.data.name;
        }
      });
      this.chart.getZr().off("click");
      //点击左键标点
      this.chart.getZr().on("click", (params) => {

        $("#rightMenu1").css({
          display: "none",
        });
        const pointInPixel = [params.offsetX, params.offsetY];

        if (this.chart.containPixel("grid", pointInPixel)) {
          this.xIndex = this.chart.convertFromPixel({seriesIndex: 0}, [
            params.offsetX,
            params.offsetY,
          ])[0];

          if (this.radio1 == "") return;
          this.datalabel.beatLabel[String(this.level - 1)][this.radio1].push(this.xIndex)
          this.chart1_redraw()

        }
      });

    },
    //波段标注 初始化
    showchart(title, data) {
      this.initData()
      this.data=data
      this.chart2 = echarts.init(document.getElementById("chart2"));
      this.lead2 = true;
      for (let i = 0; i < 1000; i += 20) {
        this.seriesdata.push({xAxis: i});
      }
      //标线
      const seriesdata = this.seriesdata;

      for (var i = 0; i <= data.length; i++) {
        this.x.push(i);
      }
      //绘图
      let detailoption = {
        animation: false,
        backgroundColor: "#ffffff",
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
          },
        },
        toolbox: {
          show: false,
        },
        dataZoom: [
          {
            show: true, // 滑动条组件
            type: "slider",
            brushSelect: false,
            startValue: 0,
            endValue: 266,
            minValueSpan: 266,
            maxValueSpan: 727,
            disabled: false, // 默认支持拖动
          },
          {
            show: true, // 滑动条组件
            type: "slider",
            orient: "vertical",
            brushSelect: false,
            startValue: -1,
            endValue: 1,
            minValueSpan: 2.13,
            maxValueSpan: 6,
            disabled: false, // 默认支持拖动

          },
          {
            type: "inside",
            orient: "vertical", // 鼠标滚轮缩放
            start: 0,
            end: 100,
            disabled: false, // 默认支持拖动

          },
          {
            type: "inside", // 鼠标滚轮缩放
            start: 0,
            end: 100,
            disabled: false, // 默认支持拖动

          },
        ],
        grid: {
          left: "3%",
          right: "3%",
          top: "5%",
          bottom: "13%",
        },
        legend: {
          show: false,
          data: ["当前电位"],
          textStyle: {color: "#000000"} /*图例(legend)说明文字的颜色*/,
          left: "right",
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: this.x,
          axisTick: {
            show: false,
          },
          axisLabel: {
            //修改坐标系字体颜色
            interval: 3,
            show: false,
            textStyle: {
              color: "#000000",
            },
          },
          splitLine: {
            show: true,
            lineStyle: {
              color: "pink",
              width: 1, //网格的宽度
              type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
            },
          } /*网格线*/,
        },
        yAxis: {
          min: -3,
          max: 3,
          boundaryGap: false,
          splitNumber: 51,
          minInterval: 0.1,
          axisLabel: {
            //修改坐标系字体颜色
            show: false,
            textStyle: {
              color: "#000000",
            },
          },
          splitLine: {
            show: true,
            lineStyle: {
              color: "pink",
              width: 1, //网格的宽度
              type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
            },
          } /*网格线*/,
        },
        series: [
          {
            id: "series1",
            markLine: {
              animation: false,
              symbol: "none",
              silent: true,
              lineStyle: {
                type: "solid",
                color: "#b33939",
                width: 0.5,
              },
              label: {
                show: true,
                position: "start", // 表现内容展示的位置
                color: "#b33939", // 展示内容颜色
              },
              data: seriesdata,
            },
            itemStyle: {
              normal: {
                lineStyle: {
                  width: 1.5,
                  color: "#000000" /*折线的颜色*/,
                },
                color: "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
              },
            },
            symbol: "none",
            name: "当前电位",
            type: "line",
            data: data,
            zlevel: 99,
            smooth: true, //显示为平滑的曲线*/
            markArea: {
              silent: true,
              itemStyle: {
                color: 'transparent',  // 无填充
                borderColor: 'black',  // 黑色边框
                borderWidth: 1,        // 边框宽度
              },
              data: [],
            },
          }],
      };
      this.chart2.clear();
      this.chart2.setOption(detailoption);
      setTimeout(() => {
        this.chart2.resize();
      });

      if (this.datalabel.waveLabel == null || this.datalabel.waveLabel == "") {
        this.datalabel.waveLabel = JSON.stringify({
          0: {
            P1: [],
            P2: [],
            P3: [],
            R1: [],
            R2: [],
            R3: [],
            T1: [],
            T2: [],
            T3: [],
          },
        });
      }

      //回显
      if (this.lead2) {
        this.chart2_redraw()

        // 绘制矩形框
        const zr = this.chart2.getZr();
        let startPoint = []; // 鼠标按下的起始位置
        let endPoint = [] // 鼠标抬起的位置
        let isDrawing = false; // 是否正在绘制
        this.chart2.getZr().off

        // 鼠标按下事件
        zr.on("mousedown", (event) => {
          if (event.event.button !== 0) return;
          // 如果不是左键点击，则不执行后续逻辑
          if (!this.isDrawRec) return; //未开启画框按钮，则不执行
          isDrawing = true;
          startPoint = [event.offsetX, event.offsetY];
          // 初始化矩形框
          this.chart2.setOption({
            graphic: [{
              type: "rect",
              shape: {
                x: startPoint[0],
                y: startPoint[1],
                width: 0,
                height: 0,
              },
              style: {
                fill: "transparent", // 半透明绿色
                stroke: "black", // 边框颜色
                lineWidth: 1, // 边框宽度
              },
            }],
          });
        });
        // 鼠标移动事件


        zr.on("mousemove", (event) => {
          if (!this.isDrawRec) return;
          if (!isDrawing) return; // 如果没有在绘制，直接返回
          endPoint = [event.offsetX, event.offsetY];

          // 动态更新矩形框的尺寸
          this.chart2.setOption({
            graphic: [{
              shape: {
                x: Math.min(startPoint[0], endPoint[0]), // 确定矩形框的左上角坐标
                y: Math.min(startPoint[1], endPoint[1]),
                width: Math.abs(endPoint[0] - startPoint[0]), // 计算矩形的宽度
                height: Math.abs(endPoint[1] - startPoint[1]), // 计算矩形的高度
              },
            }],
          });
        });
        // 鼠标抬起事件

        zr.on("mouseup", () => {
          if (!this.isDrawRec) return;
          if (!isDrawing) return;
          startPoint = this.chart2.convertFromPixel({xAxisIndex: 0, yAxisIndex: 0}, [startPoint[0], startPoint[1]]);
          endPoint = this.chart2.convertFromPixel({xAxisIndex: 0, yAxisIndex: 0}, [endPoint[0], endPoint[1]]);
          //判断矩形框y是否超出界限
          if (!startPoint[0] || !endPoint[0] || !startPoint[1] || !endPoint[1]) return;
          if (Math.abs(startPoint[1]) > 3 || Math.abs(endPoint[1] > 3)) {
            isDrawing = false;
            startPoint = [];
            endPoint = []
            console.log("矩形框超出界限")
            return;
          }
          //判断矩形框是否过大过小
          if (Math.abs(startPoint[0] - endPoint[0]) < 5 || Math.abs(startPoint[0] - endPoint[0]) > 150) {
            isDrawing = false;
            startPoint = [];
            endPoint = []
            console.log("矩形框过大或过小")
            return;
          }

          // 根据数据自动调整矩形框的上下边界
          const silce = startPoint[0] < endPoint[0] ?
            this.data.slice(Math.floor(startPoint[0]), Math.floor(endPoint[0])) :
            this.data.slice(Math.floor(endPoint[0]), Math.floor(startPoint[0]));
          startPoint[1] = Math.max(...silce);
          endPoint[1] = Math.min(...silce);

          //清空临时框
          const chartOption = this.chart2.getOption();
          chartOption.graphic = [{shape: {x: 0, y: 0, width: 0, height: 0,},}];
          this.chart2.setOption(chartOption);

          //绘制矩形框
          this.datalabel.rectangles[String(this.level - 1)].push([startPoint, endPoint])
          this.chart2_redraw()
          isDrawing = false;
          startPoint = [];
          endPoint = []
        });


        //监听鼠标位置,配合快捷删除操作
        const tolerance = 0.02; // 矩形框可供选择的范围
        this.chart2.getZr().on("mousemove", throttle((event) => {
          if (!this.isDrawRec) return; //未开启画框按钮，则不执行


          const [x, y] = this.chart2.convertFromPixel({seriesIndex: 0}, [event.offsetX, event.offsetY]);

          this.isselected = false;

          this.datalabel.rectangles[String(this.level - 1)].forEach((item, index) => {  //卡顿地方
            if ( // 判断是否选中框
              x === item[0][0] && Math.min(item[0][0], item[1][1]) <= y && y <= Math.max(item[0][1], item[1][1]) ||
              x === item[1][0] && Math.min(item[0][0], item[1][1]) <= y && y <= Math.max(item[0][1], item[1][1]) ||
              Math.abs(y - item[0][1]) <= tolerance && Math.min(item[0][0], item[1][0]) <= x && x <= Math.max(item[0][0], item[1][0]) ||
              Math.abs(y - item[1][1]) <= tolerance && Math.min(item[0][0], item[1][0]) <= x && x <= Math.max(item[0][0], item[1][0])) {
              this.isselected = true
              this.selectrectangleIndex = index
            }
          })
          if (this.isselected) {
            //设置变色效果
            let option = this.chart2.getOption();
            option.series[0].markArea.data[this.selectrectangleIndex][0].itemStyle = {
              borderColor: 'red',
              borderWidth: 1,
            }
            this.chart2.setOption(option);
          } else {
            //清除效果
            let option = this.chart2.getOption();
            option.series[0].markArea.data[this.selectrectangleIndex][0].itemStyle = {
              borderColor: 'black',
              borderWidth: 1,
            }
            this.chart2.setOption(option);
          }
        }, 30));


        //右击显示删除
        this.chart2.on("contextmenu", (params) => {
          $("#rightMenu2").css({
            display: "block",
            left: (params.event.offsetX / window.screen.width) * 100 + "vw",
            top: (params.event.offsetY / window.screen.height) * 100 + 11 + "vh",
          });
          if (params.componentType === "markPoint") {
            this.delX.value = params.data.xAxis;
            this.delX.key = params.data.name;
          }
        });


        //左击标点
        this.chart2.getZr().off("click");
        this.chart2.getZr().on("click", (params) => {
          $("#rightMenu2").css({
            display: "none",
          });
          const pointInPixel = [params.offsetX, params.offsetY];
          // console.log(pointInPixel)
          if (this.chart2.containPixel("grid", pointInPixel)) {
            var xIndex = this.chart2.convertFromPixel({seriesIndex: 0}, [params.offsetX, params.offsetY,])[0];
            if (this.radio2 == "") return; //没选中按钮，不添加点
            this.datalabel.waveLabel[String(this.level - 1)][this.radio2].push(xIndex)
            this.chart2_redraw()
          }
        });
        this.show = true;
      }

    },
    chart1_redraw() {
      let colorList = {
        Normal: "green",
        FangZao: "blue",
        ShiZao: "red",
        FangYi: "brown",
        GanRao: "#000",
      };
      let pointdata = []

      for (const key in this.datalabel.beatLabel[String(this.level - 1)]) {
        this.datalabel.beatLabel[String(this.level - 1)][key].forEach((i) => {
          let formatter = key;
          switch (formatter) {
            case "Normal":
              formatter = "N";
              break;
            case "FangZao":
              formatter = "S";
              break;
            case "ShiZao":
              formatter = "V";
              break;
            case "FangYi":
              formatter = "A";
              break;
            case "GanRao":
              formatter = "X";
              break;
          }
          let text = {
            name: key,
            xAxis: i,
            yAxis: this.data[i] + 0.3,
            itemStyle: {
              color: colorList[key],
            },
            label: {
              color: "#ffffff",
              show: true,
              formatter: formatter,
              fontSize: 13,
            },
          };
          pointdata.push(text);
        });
      }
      this.chart.setOption({
        series: {
          markPoint: {
            symbol: "pin",
            symbolSize: 25,
            animation: false,
            data: pointdata,
          },
        },
      });
    },
    chart2_redraw() {
      let colorList = {
        P1: "#fe0101",
        P2: "#fe0101",
        P3: "#fe0101",
        R1: "#ff00cf",
        R2: "#ff00cf",
        R3: "#ff00cf",
        T1: "#0021da",
        T2: "#0021da",
        T3: "#0021da",
      };
      // 重绘点
      let pointdata = [];
      for (const key in this.datalabel.waveLabel[String(this.level - 1)]) {
        this.datalabel.waveLabel[String(this.level - 1)][key].forEach((i) => {
          let text = {
            name: key,
            xAxis: i,
            yAxis: this.data[i],
            itemStyle: {
              color: colorList[key],
            },
            label: {
              color: "#ffffff",
              show: true,
              formatter: key,
              fontSize: 9,
            },
          }
          pointdata.push(text)
        })
      }
      // 重绘矩形框
      let rectangles = []
      this.datalabel.rectangles[String(this.level - 1)].forEach(item => {
        let rec = [
          {xAxis: item[0][0], yAxis: item[0][1]},
          {xAxis: item[1][0], yAxis: item[1][1]}
        ]
        rectangles.push(rec)
      })
      this.chart2.setOption({
        series: {
          markPoint: {
            symbol: "pin",
            symbolSize: 24,
            animation: false,
            data: pointdata,
          },
          markArea: {
            silent: true,
            itemStyle: {
              color: 'transparent',  // 无填充
              borderColor: 'black',  // 黑色边框
              borderWidth: 1,        // 边框宽度
            },
            data: rectangles,
          },
        },
      });
    },
    initBeatLabel() {
      this.datalabel.beatLabel[String(this.level - 1)] = {
        Normal: [],
        FangZao: [],
        ShiZao: [],
        FangYi: [],
        GanRao: [],
      };
    },
    initWaveLabel() {
      this.datalabel.waveLabel[String(this.level - 1)] = {
        P1: [],
        P2: [],
        P3: [],
        R1: [],
        R2: [],
        R3: [],
        T1: [],
        T2: [],
        T3: [],
      };
    },
    initRectangles() {
      this.datalabel.rectangles[String(this.level - 1)] = []
    },
    //心搏 删除点
    del() {
      for (const key in this.datalabel.beatLabel[String(this.level - 1)]) {
        this.datalabel.beatLabel[String(this.level - 1)][key].forEach((item, index) => {
          if (item === this.delX.value) {
            this.datalabel.beatLabel[String(this.level - 1)][key].splice(index, 1)
          }
        })
      }
      this.chart1_redraw()
      $("#rightMenu1").css({
        display: "none",
      });
    },
    //波段 删除点
    del2() {
      for (const key in this.datalabel.waveLabel[String(this.level - 1)]) {
        this.datalabel.waveLabel[String(this.level - 1)][key].forEach((item, index) => {
          if (item == this.delX.value) {
            this.datalabel.waveLabel[String(this.level - 1)][key].splice(index, 1);
          }
        })
      }
      this.chart2_redraw()
      $("#rightMenu2").css({
        display: "none",
      });
    },
    // 清空心搏标注数据
    clickClear() {
      this.$modal.confirm('是否清空数据?').then(function () {
        //处理
      }).then(() => {
        this.initBeatLabel()
        this.chart1_redraw()
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    // 清空波段标注数据
    clearData() {
      this.$modal.confirm('是否清空数据?').then(function () {
        //处理
      }).then(() => {
        this.initWaveLabel()
        this.initRectangles()
        this.chart2_redraw()
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });


    },
    // 提交数据
    submit() {
      console.log("提交数据 pId=", this.pId)
      updateJecg12({
        pId: this.pId,
        waveLabel: JSON.stringify(this.datalabel.waveLabel),
        beatLabel: JSON.stringify(this.datalabel.beatLabel),
        rectangles: JSON.stringify(this.datalabel.rectangles),
        updateTime: new Date().getDate(),
        updateBy: this.$store.state.user.id,
      });
      this.$modal.msgSuccess("提交成功!");
      //提交数据
    },

    //关闭窗口
    clickClose() {
      this.lead1 = false;
      this.lead2 = false;
      this.radio1 = "";
      this.radio2 = "";
      this.activeName = "first";
      this.drawShow = false;
      this.isDrawRec = false;
      this.$emit('dataChanged', null); //更新12导标签显示
    },

    //切换tab
    handleClick(tab, event) {

      if (tab.index == "0") {
        this.getchart(this.data, this.pId, this.level, this.title, null, null);
      }
      // console.log(tab.index,this.chart2)
      if (tab.index == "1") {
        this.showchart(this.title, this.data, this.level);
      }
    },


    //切换标注类型
    clickitem(e) {
      e === this.radio2 ? (this.radio2 = "") : (this.radio2 = e);
      this.Chart2ZoomControl(false)
    },
    clickitem1(e) {
      e === this.radio1 ? (this.radio1 = "") : (this.radio1 = e);
      this.Chart2ZoomControl(false)
    },
    //控制画框功能选择
    clickitem2(e) {
      if (e === this.radio2) {
        this.radio2 = ""
        this.Chart2ZoomControl(false)
      } else {
        this.radio2 = e
        this.Chart2ZoomControl(true)
      }
    },
    Chart2ZoomControl(e) {
      this.isDrawRec = e
      const option = this.chart2.getOption();
      option.dataZoom.forEach(dz => {
        dz.disabled = e;
      });
      this.chart2.setOption(option);
    },
    //delete键快捷删除
    quickDelete() {
      if (!this.isselected) return // 查看是否选中矩形框
      //删除矩形框
      this.datalabel.rectangles[String(this.level - 1)].splice(this.selectrectangleIndex, 1)
      this.chart2_redraw()
    },
    async AILabel() {
      this.isLoading = true;
      this.isLoadingText = 'AI标注中...';
      const url = 'https://screen.mindyard.cn/test/api/getP_QRS_T'; // 请确保这是正确的POST请求URL
      const headers = new Headers({
        'Content-Type': 'application/json',
        'user': 'zzu',
        'password': 'zzu_api'
      });
      const data = {
        "signal": this.data,
        "sample_rate": "100",
        "isFilter": "0"
      };
      await fetch(url, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(data)
      }).then(res => {
        return res.json()
      }).then(resData => {
        resData.data.forEach(item => {
          for (const key in item) {
            this.datalabel.waveLabel[String(this.level - 1)][key].push(item[key])
          }
        })
        this.$modal.msgSuccess("AI标注成功");
      }).catch(error => {
        this.$modal.msgError("AI标注失败");
        this.isLoading = false
        return
      })
      this.chart2_redraw()
      this.isLoading = false

    },
    //处理全局键盘点击

    handleGlobalkeydown(event) {
      if (!this.drawShow) return
      // let beatFavor = {Normal: "q",FangZao: "w", ShiZao: "e", FangYi: "r", GanRao: "t",tab_beatlabel: "1", tab_wavelabel: "2",}
      // let waveFavor = {P1: "q", P2: "w", P3: "e", R1: "a", R2: "s", R3: "d", T1: "z", T2: "x", T3: "c", rectangles: "r", tab_beatlabel: "1", tab_wavelabel: "2",}
      // for(const key in this.userFavor){
      //   if(beatFavor[key]){
      //     beatFavor[key] = this.userFavor[key]
      //   }
      //   if(waveFavor[key]){
      //     waveFavor[key] = this.userFavor[key]
      //   }
      // }
      // beatFavor = Object.entries(beatFavor).reduce((acc, [key, value]) => {
      //   acc[value] = key;
      //   return acc;
      // }, {}); //对换位置
      // waveFavor = Object.entries(waveFavor).reduce((acc, [key, value]) => {
      //   acc[value] = key;
      //   return acc;
      // }, {}); //对换位置
      // console.log(beatFavor,waveFavor)
      if (this.activeName == "first") {
        switch (event.key) {
          case '1':
            this.activeName = "first"; // 切换到目标 Tab
            this.getchart(this.data, this.pId, this.level, this.title, null, null);
            break;
          case '2':
            this.activeName = "second"; // 切换到目标 Tab
            this.showchart(this.title, this.data, this.level);
            break;
          case 'q':
            this.clickitem1('Normal');
            break;
          case 'w':
            this.clickitem1('FangZao');
            break;
          case 'e':
            this.clickitem1('ShiZao');
            break;
          case 'r':
            this.clickitem1('FangYi');
            break;
          case 't':
            this.clickitem1('GanRao');
            break;
          case 'Escape':
            this.clickClose();
            break;
          default:
            break;
        }
      } else if (this.activeName == "second") {
        switch (event.key) {
          case '1':
            this.activeName = "first"; // 切换到目标 Tab
            this.getchart(this.data, this.pId, this.level, this.title, null, null);
            break;
          case '2':
            this.activeName = "second"; // 切换到目标 Tab
            this.showchart(this.title, this.data, this.level);
            break;
          case 'q':
            this.clickitem('P1');
            break;
          case 'w':
            this.clickitem('P2');
            break;
          case 'e':
            this.clickitem('P3');
            break;
          case 'a':
            this.clickitem('R1');
            break;
          case 's':
            this.clickitem('R2');
            break;
          case 'd':
            this.clickitem('R3');
            break;
          case 'z':
            this.clickitem('T1');
            break;
          case 'x':
            this.clickitem('T2');
            break;
          case 'c':
            this.clickitem('T3');
            break;
          case 'r':
            this.clickitem2('rec');
            break;
          case '3':
            this.quickDelete();
            break;
          case 'Escape':
            this.clickClose();
            break;
          default:
            break;
        }
      } else {
        console.log("activeNameError")
      }
    }
  },
};
</script>
<style scoped lang="scss">
::v-deep .el-tabs__header {
  margin: 0;
}

::v-deep .el-tabs__content {
  overflow: visible;
}

.container {
  user-select: none;
  width: 88vw;
  position: fixed;
  top: 11%;
  left: 12%;
  //margin-left: 50%;
  //transform: translate(-50%,-80%);
  background: #ffffff;
  z-index: 1;

  .tab_label {
    color: black;
  }

  .top-tool {
    height: 50px;
    display: flex;
    justify-content: space-between;
    background-color: rgba(39, 55, 70, 1);

    .top-left-div {
      display: flex;

      .icon {
        font-size: 30px;
        color: white;
      }

      .el-button {
        padding: 0;
        border: 0;
        background-color: rgba(207, 218, 238, 0);
      }

      .color-div-a,
      .color-div {
        border-radius: 50%;
        height: 40px;
        width: 40px;
        margin: 5px 10px;

        &:hover {
          cursor: pointer;
          box-shadow: 0px 0px 10px lightgray;
        }
      }

      .color-div-a {
        box-shadow: 0px 0px 10px #fff;
      }

      .getcolor-div {
        position: relative;
        margin: 5px 10px;

        img {
          position: absolute;
          top: 0;
          height: 40px;
          width: 40px;
          border-radius: 50%;
        }

        input {
          z-index: 10;
          border-radius: 50%;
          position: absolute;
          top: 0;
          background-color: transparent;
          height: 40px;
          width: 40px;
          opacity: 0;
          border: 0px;
          cursor: pointer;
        }
      }
    }

    .top-right-div {
      margin: 0px;
      display: flex;

      .model-btn,
      .model-btn-a {
        background-color: #455769;
        border: 0px;
        padding: 9px 15px;
        margin: auto 10px;

        img {
          height: 20px;
          width: 20px;
        }
      }

      .model-btn-a {
        border: 0px;
        background-color: rgba(255, 255, 255, 0.5);
      }

      .download-btn,
      .clear-btn {
        margin: auto 10px;
      }

      .upload-btn {
        margin: auto 10px;
        height: 40px;
        width: 50px;
        padding: 0px;
        position: relative;

        input {
          position: absolute;
          left: 0;
          top: 0;
          z-index: 10;
          width: 100%;
          height: 100%;
          opacity: 0;
          border: 0px;
        }
      }
    }
  }

  .middle-div {
    width: 100%;
    height: calc(100% - 50px);
    display: flex;
    justify-content: center;
    align-items: center;

    .canvas-div {
      width: 100%;
      height: 100%;

      overflow: hidden;
    }
  }

  .msg-div {
    position: absolute;
    z-index: 10;
    background-color: rgba(255, 255, 255, 0.5);
    color: #ffffff;
    padding: 5px 20px;
  }

  .menu {
    /*这个样式不写，右键弹框会一直显示在画布的左下角*/
    position: absolute;
    background: rgba(255, 255, 255);
    left: -99999px;
    top: -999999px;
    padding: 0.1vw;
    border-radius: 0.5vw;

    .button {
      height: 3vh;
      width: 2.5vw;
      display: inline-flex;
      text-align: center;
      border-radius: 0.5vw;
      border: 1px solid #000000;
      font-size: 0.5vw;
      font-weight: 700;
      justify-content: center;
      align-items: center;
    }

    .button:hover {
      color: #ffffff;
      background-color: #df0202;
    }
  }
}

.el-radio-button:focus:not(.is-focus):not(:active):not(.is-disabled) {
  -webkit-box-shadow: 0 0px 0px #ccc;
  box-shadow: 0 0px 0px #ccc;
}
</style>

