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
          id = "waveLabelLoading"
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
    <!--    <div class="container" v-show="!drawShow">-->
    <!--      <div class="middle-div">-->
    <!--        <div class="canvas-div" id="chart3"></div>-->
    <!--        <button class="btn" style="right: 0;top: 0;" @click="Off">关闭</button>-->
    <!--      </div>-->
    <!--    </div>-->
  </div>
</template>
<script>
// import {
//   ecgBeatLabelAdd,
//   ecgWaveLabelPut,
//   put12BeatLabel,
//   put12WaveLabel,
// } from "@/api/staticECG/staticECG";
import * as echarts from "@/api/tool/echarts.min.js";
import $ from "jquery";
import {updateJecg12} from "@/api/Jecg12/Jecg12";

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
      arrList1: {}, //心博标注 每一段
      arrList2: {},
      arrList3: {},
      arrList4: {},
      // arrList5: {},
      // arrList6: {},
      // arrList7: {},
      arrList: {
        //心博标注 提交数据
        pId: null,
        beatLabel: null,
      },
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
      pointdata: [], //显示的 点
      graphic: [], //显示的 文本
      data: [], //导联数据
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
      rectangles: [], // 矩形框
      isselected: false,  //是否选中矩形框
      selectrectangleIndex: -1,  //选中的矩形框的下标

      lead1: true, //是否可以标注
      lead2: true, //是否可以标注
      flag: null, //1：静态单导  12.静态12导
      closeStyle: {position: "absolute", right: "1px", top: "20px"},
      query: {
        //波段标注 提交数据
        pId: "",
        beatLabel: "",
        waveLabel: "",
      },
      datalabel: {
        //进来页面时读取的标注数据
        waveLabel: "",
        beatLabel: "",
        rectangles: "",
      },
      title: "", //几导联
      userFavor: {
        Normal: "q",
        FangZao: "w",
        ShiZao: "e",
        FangYi: "r",
        GanRao: "t",
      }//用户偏好
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
    this.chart = echarts.init(document.getElementById("chart"));
    this.chart2 = echarts.init(document.getElementById("chart2"));

    //添加快捷键
    window.addEventListener('keydown', this.handleGlobalkeydown);
  },
  beforeDestroy() {
    window.removeEventListener('keydown', this.handleGlobalkeydown);
  },
  // 数据格式
  // this.datalabel=
  //   {
  //     beatLabel: {
  //       "0":
  //         {
  //         "FangZao": [],
  //         "Normal": []
  //       }
  //       "1":
  //         {
  //           "FangZao": [],
  //           "Normal": []
  //         }
  //     },
  //     waveLabel: {
  //       "0": {
  //         "P1": []
  //       }
  //     }
  //     },

  methods: {
    //心博标注 初始化
    async getchart(data, pIds, level, title, flag, datalabel, is) {
      this.title = title;
      this.lead1 = true;
      if (flag != null) {
        this.flag = flag;
      }
      if (datalabel != null) {
        this.datalabel = datalabel;
      }
      this.drawShow = true;
      this.data = data;
      this.pId = pIds;
      this.level = level;
      this.x.length = 0;
      this.arrList.pId = pIds;
      for (var i = 0; i <= data.length; i++) {
        this.x.push(i);
      }


      // if (level == 4) {
      //   for (var i = 0; i <= 1000; i++) {
      //     this.x.push(i);
      //   }
      // }
      for (let i = 0; i < 1000; i += 20) {
        this.seriesdata.push({xAxis: i});
      }
      //标线
      var seriesdata = this.seriesdata;
      if (data.length > 1500) {
        seriesdata = [
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
        ];
        for (let i = 0; i < data.length; i += 20) {
          seriesdata.push({xAxis: i});
        }
      }
      let titleStr = title;
      if (titleStr == "IA") {
        titleStr = "II";
      }
      if (is == "NO") {
        titleStr = "";
      }
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
        // this[`${"arrList" + level}`] = {
        //   Normal: [],
        //   FangZao: [],
        //   ShiZao: [],
        //   FangYi: [],
        //   GanRao: [],
        // };
        // if (this.arrList.beatLabel) {
        //   if (this.flag == 1) {
        //     //单导
        //     this[`${"arrList" + level}`] = this.arrList.beatLabel[level - 1];
        //     // console.log("单导")
        //   } else {
        //     //12导
        //     // console.log("12导")
        //     var each = {
        //       Normal: [],
        //       FangZao: [],
        //       ShiZao: [],
        //       FangYi: [],
        //       GanRao: [],
        //     };
        //     for (let key1 in this.arrList.beatLabel) {
        //       for (let key2 in this.arrList.beatLabel[key1]) {
        //         var arr = this.arrList.beatLabel[key1][key2].map(
        //           (item) => item + key1 * 1000
        //         );
        //         each[key2] = each[key2].concat(arr);
        //       }
        //     }
        //     this[`${"arrList" + level}`] = each;
        //   }
        // }
        // //为空
        // if (
        //   this[`${"arrList" + level}`] == null ||
        //   this[`${"arrList" + level}`] == {}
        // ) {
        //   this[`${"arrList" + level}`] = {
        //     Normal: [],
        //     FangZao: [],
        //     ShiZao: [],
        //     FangYi: [],
        //     GanRao: [],
        //   };
        // }
        //
        // //添加所有点
        // this.pointdata.length = 0;
        // var colorList = {
        //   // Normal: "#fe0101",
        //   // FangZao: "#ff7000",
        //   // ShiZao: "#17b09a",
        //   // FangYi: "#070000",
        //   // GanRao: "#0021da",
        //
        //
        //   Normal: "green",
        //   FangZao: "blue",
        //   ShiZao: "red",
        //   FangYi: "brown",
        //   GanRao: "#000",
        // };

        // for (const key in this.datalabel.beatLabel[String(level - 1)]) {
        //   this.datalabel.beatLabel[String(level - 1)][key].forEach((i) => {
        //     var formatter = key;
        //     switch (formatter) {
        //       case "Normal":
        //         formatter = "N";
        //         break;
        //       case "FangZao":
        //         formatter = "S";
        //         break;
        //       case "ShiZao":
        //         formatter = "V";
        //         break;
        //       case "FangYi":
        //         formatter = "A";
        //         break;
        //       case "GanRao":
        //         formatter = "X";
        //         break;
        //     }
        //     var pointdata = {
        //       name: key,
        //       xAxis: i,
        //       yAxis: data[i] + 0.3,
        //       itemStyle: {
        //         color: colorList[key],
        //       },
        //       label: {
        //         color: "#ffffff",
        //         show: true,
        //         formatter: formatter,
        //         fontSize: 13,
        //       },
        //     };
        //     this.pointdata.push(pointdata);
        //   });
        // }


        // for (const key in this[`${"arrList" + level}`]) {
        //   this[`${"arrList" + level}`][key].forEach((i) => {
        //     var formatter = key;
        //     switch (formatter) {
        //       case "Normal":
        //         formatter = "N";
        //         break;
        //       case "FangZao":
        //         formatter = "S";
        //         break;
        //       case "ShiZao":
        //         formatter = "V";
        //         break;
        //       case "FangYi":
        //         formatter = "A";
        //         break;
        //       case "GanRao":
        //         formatter = "X";
        //         break;
        //     }
        //     var pointdata = {
        //       name: key,
        //       xAxis: i,
        //       yAxis: data[i] + 0.3,
        //       itemStyle: {
        //         color: colorList[key],
        //       },
        //       label: {
        //         color: "#ffffff",
        //         show: true,
        //         formatter: formatter,
        //         fontSize: 13,
        //       },
        //     };
        //     this.pointdata.push(pointdata);
        //   });
        // }
        // setTimeout(() => {
        //   //添加文本
        //   this.addtext();
        //   //重绘
        //   this.redraw();
        // });
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
        //console.log(pointInPixel)

        if (this.chart.containPixel("grid", pointInPixel)) {
          this.xIndex = this.chart.convertFromPixel({seriesIndex: 0}, [
            params.offsetX,
            params.offsetY,
          ])[0];

          if (this.radio1 == "") return;
          this.datalabel.beatLabel[String(this.level - 1)][this.radio1].push(this.xIndex)
          this.chart1_redraw()

          // let i = this.addValue({x: this.xIndex, type: this.radio1});
          // if (i == 1) {
          //   return;
          // }
          // //添加点
          // this.addpoint();
          // //添加文本
          // this.graphic = [];
          // console.log(this.graphic);
          // this.addtext();
          //
          // setTimeout(() => {
          //   //重绘
          //   this.redraw();
          // });
        }
      });
      //滑动条事件
      // 防抖函数，减少事件触发频率
      // function debounce(func, wait) {
      //   let timeout;
      //   return function () {
      //     clearTimeout(timeout);
      //     timeout = setTimeout(() => {
      //       func.apply(this, arguments);
      //     }, wait);
      //   };
      // }

      // 创建防抖版本的datazoom事件处理函数
      // var debouncedDataZoomHandler = debounce((params) => {
      //   // 处理datazoom事件的逻辑
      //   this.addtext();
      //   var chartOption = this.chart.getOption();
      //   chartOption.graphic = this.graphic;
      //   this.chart.setOption(chartOption, true);
      //   console.log("DataZoom Event:", params);
      // }, 50); // 设置防抖延迟时间
      // this.chart.off("datazoom");
      // this.chart.on("datazoom", debouncedDataZoomHandler);
    },
    //波段标注 初始化
    showchart(title, data) {
      this.lead2 = true;
      for (let i = 0; i < 1000; i += 20) {
        this.seriesdata.push({xAxis: i});
      }
      //标线
      var seriesdata = this.seriesdata;
      if (data.length > 1500) {
        seriesdata = [
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
        ];
        for (let i = 0; i < data.length; i += 20) {
          seriesdata.push({xAxis: i});
        }
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
      this.pointdata.length = 0;
      // var colorList = {
      //   P1: "#fe0101",
      //   P2: "#fe0101",
      //   P3: "#fe0101",
      //   R1: "#ff00cf",
      //   R2: "#ff00cf",
      //   R3: "#ff00cf",
      //   T1: "#0021da",
      //   T2: "#0021da",
      //   T3: "#0021da",
      // };
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
        // this.subData = {
        //   P1: [],
        //   P2: [],
        //   P3: [],
        //   R1: [],
        //   R2: [],
        //   R3: [],
        //   T1: [],
        //   T2: [],
        //   T3: [],
        // };

        // if (this.flag == 1) {
        //   //单导
        //   this.subData = JSON.parse(this.datalabel.waveLabel)[this.level - 1];
        // } else {
        //   //12导
        //   let wave = JSON.parse(this.datalabel.waveLabel);
        //   for (let key1 in wave) {
        //     for (let key2 in wave[key1]) {
        //       var arr = wave[key1][key2].map((item) => item + key1 * 1000);
        //       this.subData[key2] = this.subData[key2].concat(arr);
        //     }
        //   }
        // }

        // if (this.subData == null || this.subData.length == 0) {
        //   this.subData = {
        //     P1: [],
        //     P2: [],
        //     P3: [],
        //     R1: [],
        //     R2: [],
        //     R3: [],
        //     T1: [],
        //     T2: [],
        //     T3: [],
        //   };
        // }
        this.chart2_redraw()

        //添加点
        // var pointdata = []
        // for (const key in this.datalabel.waveLabel[String(this.level - 1)]) {
        //   this.datalabel.waveLabel[String(this.level - 1)][key].forEach((i) => {
        //     var text = {
        //       name: key,
        //       xAxis: i,
        //       yAxis: data[i],
        //       itemStyle: {
        //         color: colorList[key],
        //       },
        //       label: {
        //         color: "#ffffff",
        //         show: true,
        //         formatter: key,
        //         fontSize: 9,
        //       },
        //     }
        //     pointdata.push(text)
        //   })
        // }

        //   for (let j = 0; j < this.subData[key].length; j++) {
        //   let pointdata = {
        //     name: key,
        //     xAxis: this.subData[key][j],
        //     yAxis: data[this.subData[key][j]],
        //     itemStyle: {
        //       color: colorList[key],
        //     },
        //     label: {
        //       color: "#ffffff",
        //       show: true,
        //       formatter: key,
        //       fontSize: 9,
        //     },
        //   };
        //   this.pointdata.push(pointdata);


        //console.log(this.pointdata)
        //   this.chart2.setOption({
        //     series: {
        //       markPoint: {
        //         symbol: "pin",
        //         symbolSize: 24,
        //         animation: false,
        //         data: pointdata,
        //       },
        //     },
        //   });
        //
        // } else {
        //   this.pointdata = [];
        //   this.chart2.setOption({
        //     series: {
        //       markPoint: {
        //         symbol: "pin",
        //         symbolSize: 24,
        //         animation: false,
        //         data: this.pointdata,
        //       },
        //     },
        //   });
        // }

        // 绘制矩形框
        const zr = this.chart2.getZr();
        let startPoint = []; // 鼠标按下的起始位置
        let endPoint = [] // 鼠标抬起的位置
        let isDrawing = false; // 是否正在绘制
        // 鼠标按下事件
        zr.on("mousedown", (event) => {
          if (event.event.button !== 0) {
            return;
          }// 如果不是左键点击，则不执行后续逻辑
          if (!this.isDrawRec) return; //未开启画框按钮，则不执行
          startPoint = [event.offsetX, event.offsetY];
          isDrawing = true;
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
          if (!isDrawing) return;
          startPoint = this.chart2.convertFromPixel({xAxisIndex: 0, yAxisIndex: 0}, [startPoint[0], startPoint[1]]);
          endPoint = this.chart2.convertFromPixel({xAxisIndex: 0, yAxisIndex: 0}, [endPoint[0], endPoint[1]]);
          // 根据数据自动调整矩形框的上下边界
          var silce = startPoint[0] < endPoint[0] ?
            this.data.slice(Math.floor(startPoint[0]), Math.floor(endPoint[0])) :
            this.data.slice(Math.floor(endPoint[0]), Math.floor(startPoint[0]));
          startPoint[1] = Math.max(...silce);
          endPoint[1] = Math.min(...silce);

          // const rect = [
          //   {xAxis: startPoint[0], yAxis: startPoint[1]},
          //   {xAxis: endPoint[0], yAxis: endPoint[1]}
          // ]

          //清空临时框
          var chartOption = this.chart2.getOption();
          // chartOption.series[0].markArea.data.push(rect);
          chartOption.graphic = [{shape: {x: 0, y: 0, width: 0, height: 0,},}];
          this.chart2.setOption(chartOption);

          //判断矩形框是否过小
          if (Math.abs(startPoint[0] - endPoint[0]) < 5) {
            console.log("矩形框过小")
            return;
          }
          //绘制矩形框
          this.datalabel.rectangles[String(this.level - 1)].push([startPoint, endPoint])
          this.chart2_redraw()
          isDrawing = false;
          startPoint = [];
          endPoint = []
        });

        //监听鼠标位置,配合快捷删除操作
        const tolerance = 0.02; // 矩形框可供选择的范围
        this.chart2.getZr().on("mousemove", (event) => {
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
        });

        this.chart2.off("contextmenu");
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

        this.chart2.getZr().off("click");
        //左击标点
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

            // //存在不添加
            // let temp = false;
            // this.pointdata.forEach((i) => {
            //   if (this.xIndex == i.xAxis) {
            //     console.log("已存在");
            //     temp = true;
            //     return;
            //   }
            // });
            // if (this.radio2 == "" || temp) {
            //   return;
            // }
            // //添加点数据
            // this.subData[this.radio2].push(this.xIndex);
            // let pointdata = {
            //   name: this.radio2,
            //   xAxis: this.xIndex,
            //   yAxis: data[this.xIndex],
            //   itemStyle: {
            //     color: colorList[this.radio2],
            //   },
            //   label: {
            //     color: "#ffffff",
            //     show: true,
            //     formatter: this.radio2,
            //     fontSize: 9,
            //   },
            // };
            // this.pointdata.push(pointdata);
            // //重绘
            // this.chart2.setOption({
            //   series: {
            //     markPoint: {
            //       symbol: "pin",
            //       symbolSize: 24,
            //       animation: false,
            //       data: this.pointdata,
            //     },
            //   },
            // });
          }
        });
        this.show = true;
      }

    },
    chart1_redraw() {
      var colorList = {
        Normal: "green",
        FangZao: "blue",
        ShiZao: "red",
        FangYi: "brown",
        GanRao: "#000",
      };
      var pointdata = []

      for (const key in this.datalabel.beatLabel[String(this.level - 1)]) {
        this.datalabel.beatLabel[String(this.level - 1)][key].forEach((i) => {
          var formatter = key;
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
          var text = {
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
      var colorList = {
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
      var pointdata = [];
      for (const key in this.datalabel.waveLabel[String(this.level - 1)]) {
        this.datalabel.waveLabel[String(this.level - 1)][key].forEach((i) => {
          var text = {
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
      var rectangles = []
      this.datalabel.rectangles[String(this.level - 1)].forEach(item => {
        var rec = [
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
      // var length1 = this.pointdata.length;
      // //删除点data
      // for (let i = 0; i < length1; i++) {
      //   if (this.pointdata[i].xAxis === this.delX.value) {
      //     this.pointdata.splice(i, 1);
      //     break;
      //   }
      // }
      // for (let key in this[`${"arrList" + this.level}`]) {
      //   if (key == this.delX.key) {
      //     this[`${"arrList" + this.level}`][key].forEach((i, index) => {
      //       if (i === this.delX.value) {
      //         this[`${"arrList" + this.level}`][key].splice(index, 1);
      //         return;
      //       }
      //     });
      //   }
      // }
      // setTimeout(() => {
      //   this.addtext();
      //   this.redraw();
      // });
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
      // this.waveLabel[String(this.level - 1)] pointdata.some((item, index) => {
      //   if (item.xAxis == this.delX.value) {
      //     this.pointdata.splice(index, 1);
      //     return true;
      //   }
      // });
      // this.subData[this.delX.key].some((item, index) => {
      //   if (item == this.delX.value) {
      //     this.subData[this.delX.key].splice(index, 1);
      //     console.log("删除成功");
      //     return true;
      //   }
      // });
      // this.delX = {key: null, value: null};
      // this.chart2.setOption({
      //   series: {
      //     markPoint: {
      //       symbol: "pin",
      //       symbolSize: 24,
      //       animation: false,
      //       data: this.pointdata,
      //     },
      //   },
      // });
      $("#rightMenu2").css({
        display: "none",
      });
    },
    // 清空心搏标注数据
    clickClear() {
      this.initBeatLabel()
      this.chart1_redraw()
      // this.$confirm("确定清空当前标记数据", {
      //   confirmButtonText: "确定",
      //   cancelButtonText: "取消",
      //   type: "warning",
      // })
      //   .then(() => {
      //     this.clearCanvas(); //清空画布
      //     this.$message({
      //       type: "success",
      //       message: "清空成功!",
      //     });
      //   })
      //   .catch(() => {
      //     this.$message({
      //       type: "info",
      //       message: "取消清空",
      //     });
      //   });
    },
    // 清空波段标注数据
    clearData() {
      this.initWaveLabel()
      this.initRectangles()
      this.chart2_redraw()
      // this.pointdata = [];
      // this.rectangles = [];
      // this.subData = {
      //   P1: [],
      //   P2: [],
      //   P3: [],
      //   R1: [],
      //   R2: [],
      //   R3: [],
      //   T1: [],
      //   T2: [],
      //   T3: [],
      // };
      // this.chart2.setOption({
      //   series: {
      //     markPoint: {
      //       symbol: "pin",
      //       symbolSize: 24,
      //       animation: false,
      //       data: [],
      //     },
      //     markArea: {
      //       silent: true,
      //       itemStyle: {
      //         color: 'transparent',  // 无填充
      //         borderColor: 'black',  // 黑色边框
      //         borderWidth: 1,        // 边框宽度
      //       },
      //       data: [],
      //     },
      //   },
      // });
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
    // 提交心搏标注数据
    // clickSubmit() {
    //   console.log(this.arrList1);
    //   if (this.flag == 1) {
    //     //单导 分段提交
    //     var obj = {
    //       0: {...this.arrList1},
    //       1: {...this.arrList2},
    //       2: {...this.arrList3},
    //       3: {...this.arrList4},
    //     };
    //     for (let key in obj) {
    //       console.log(obj[key]);
    //       if (Object.keys(obj[key]).length === 0) {
    //         delete obj[key];
    //       }
    //     }
    //     this.arrList = {
    //       pId: this.pId,
    //       beatLabel: JSON.stringify(obj),
    //     };
    //   } else {
    //     //12导全部提交
    //     var obj = {...this.arrList1};
    //     var newObj1 = {};
    //     var newObj2 = {};
    //     for (var key in obj) {
    //       if (obj.hasOwnProperty(key)) {
    //         // 对每个属性的数组进行分类
    //         newObj1[key] = obj[key].filter((num) => num < 1000); // 1000是分类的阈值
    //         newObj2[key] = obj[key]
    //           .filter((num) => num >= 1000)
    //           .map((num) => num - 1000);
    //       }
    //     }
    //     this.arrList = {
    //       pId: this.pId,
    //       beatLabel: JSON.stringify({0: newObj1, 1: newObj2}),
    //     };
    //   }
    //   var beatLabel = JSON.parse(this.datalabel.beatLabel);
    //   var beatLabel2 = JSON.parse(this.arrList.beatLabel);
    //   if (beatLabel == null) {
    //     beatLabel = {};
    //   }
    //   for (let key in beatLabel2) {
    //     beatLabel[key] = beatLabel2[key];
    //   }
    //   this.datalabel.beatLabel = JSON.stringify(beatLabel);
    //   this.isLoading = true;
    //   if (this.arrList.beatLabel != null) {
    //     if (this.flag == 1) {
    //       ecgBeatLabelAdd(this.arrList).then((response) => {
    //         this.$modal.msgSuccess("坐标提交成功!");
    //         this.isLoading = false;
    //         this.$emit("closeMain", this.arrList.beatLabel);
    //       });
    //     } else {
    //       put12BeatLabel(this.arrList).then((response) => {
    //         this.$modal.msgSuccess("坐标提交成功!");
    //         this.isLoading = false;
    //
    //         this.$emit("closeMain", this.arrList.beatLabel);
    //         console.log(111);
    //       });
    //     }
    //     console.log(JSON.parse(this.arrList.beatLabel));
    //     this.isLoading = false;
    //   } else {
    //     this.$modal.msgWarning("请标记后提交！");
    //     this.isLoading = false;
    //   }
    // },
    // 提交心搏标注数据
    // submitData() {
    //   this.query.pId = this.pId;
    //   if (this.datalabel.waveLabel != null && this.datalabel.waveLabel != "") {
    //     var waveLabel = JSON.parse(this.datalabel.waveLabel);
    //     console.log(waveLabel);
    //     if (this.flag == 1) {
    //       //单导  每一段 全部提交
    //       waveLabel[this.level - 1] = this.suecbData;
    //       this.query.waveLabel = JSON.stringify(waveLabel);
    //     } else {
    //       //12导 分段 全部提交
    //       var obj = {...this.subData};
    //       var newObj1 = {};
    //       var newObj2 = {};
    //       for (var key in obj) {
    //         if (obj.hasOwnProperty(key)) {
    //           // 对每个属性的数组进行分类
    //           newObj1[key] = obj[key].filter((num) => num < 1000); // 1000是分类的阈值
    //           newObj2[key] = obj[key]
    //             .filter((num) => num >= 1000)
    //             .map((num) => num - 1000);
    //         }
    //       }
    //
    //       this.query = {
    //         pId: this.pId,
    //         waveLabel: JSON.stringify({0: newObj1, 1: newObj2}),
    //       };
    //       waveLabel = {0: newObj1, 1: newObj2};
    //       console.log(obj, newObj1, newObj2, waveLabel);
    //     }
    //     this.datalabel.waveLabel = JSON.stringify(waveLabel);
    //   } else {
    //     this.datalabel.waveLabel = JSON.stringify(this.subData);
    //   }
    //   console.log(this.subData);
    //   console.log(JSON.parse(this.query.waveLabel));
    //
    //   if (this.flag == 1) {
    //     ecgWaveLabelPut(this.query)
    //       .then((res) => {
    //         this.$modal.msgSuccess("标注提交成功");
    //       })
    //       .catch((err) => {
    //       });
    //   } else {
    //     put12WaveLabel(this.query)
    //       .then((res) => {
    //         this.$modal.msgSuccess("标注提交成功");
    //       })
    //       .catch((err) => {
    //       });
    //   }
    // },


    //添加标点
    // addpoint() {
    //   // let i=this.pointdata.findIndex(it=>it.x==this.xIndex)
    //   var colorList = {
    //     // Normal: "#fe0101",
    //     // FangZao: "#ff7000",
    //     // ShiZao: "#17b09a",
    //     // FangYi: "#070000",
    //     // GanRao: "#0021da",
    //
    //     // TODO:
    //     Normal: "green",
    //     FangZao: "blue",
    //     ShiZao: "red",
    //     FangYi: "brown",
    //     GanRao: "#000",
    //   };
    //   var formatter = this.radio1;
    //   switch (formatter) {
    //     case "Normal":
    //       formatter = "N";
    //       break;
    //     case "FangZao":
    //       formatter = "S";
    //       break;
    //     case "ShiZao":
    //       formatter = "V";
    //       break;
    //     case "FangYi":
    //       formatter = "A";
    //       break;
    //     case "GanRao":
    //       formatter = "X";
    //       break;
    //   }
    //   let pointdata = {
    //     name: this.radio1,
    //     xAxis: this.xIndex,
    //     yAxis: this.data[this.xIndex],
    //     itemStyle: {
    //       color: colorList[this.radio1],
    //     },
    //     label: {
    //       color: "#ffffff",
    //       show: true,
    //       formatter: formatter,
    //       fontSize: 13,
    //     },
    //   };
    //   this.pointdata.push(pointdata);
    // },
    //重绘所有点之间的文本
    // addtext() {
    //   this.graphic.length = 0;
    //   let graphic = [];
    //   //console.log(this[`${'arrList' + this.level}`])
    //   for (let key in this[`${"arrList" + this.level}`]) {
    //     var length = this[`${"arrList" + this.level}`][key].length;
    //     for (let i = 0; i < length; i++) {
    //       graphic.push(this[`${"arrList" + this.level}`][key][i]);
    //     }
    //   }
    //
    //   graphic.sort(function (a, b) {
    //     return a - b;
    //   });
    //   var length = graphic.length;
    //   for (let i = 0; i < length - 1; i++) {
    //     var x1, x2;
    //     x1 = graphic[i];
    //     x2 = graphic[i + 1];
    //     // console.log(x1,x2)
    //     var time = ((x2 - x1) / 25) * 0.25; //时间 s
    //     var heart = (60 / time).toFixed(1); //心率
    //     time = (time * 1000).toFixed(0);
    //     //文本值
    //     var x = this.chart.convertToPixel({seriesIndex: 0}, [
    //       (x2 - x1) / 2 + x1,
    //       3,
    //     ]);
    //     // console.log(x)
    //     let text = {
    //       type: "text",
    //       x: x[0] - 15,
    //       y: 20,
    //       z: 999,
    //       top: "2.5%",
    //       style: {
    //         text: time + `\n${heart}`,
    //         fill: "#000000",
    //         fontWeight: 400,
    //         fontSize: 15,
    //       },
    //     };
    //     this.graphic.push(text);
    //   }
    //   //刻度线
    //   for (let i = 0; i < length; i++) {
    //     var x1 = this.chart.convertToPixel({seriesIndex: 0}, [graphic[i], 3]);
    //     let text = {
    //       type: "line",
    //       top: "1.8%",
    //       style: {
    //         stroke: "#333",
    //         lineWidth: 2,
    //         lineDash: [],
    //       },
    //       shape: {
    //         x1: x1[0],
    //         y1: 0,
    //         x2: x1[0],
    //         y2: 10,
    //       },
    //       z: 100,
    //     };
    //     this.graphic.push(text);
    //   }
    //   //console.log("绘制文本============",this.graphic)
    // },

    //按x从小到大插入值
    // addValue(params) {
    //   console.log(this[`${"arrList" + this.level}`]);
    //   let i = this[`${"arrList" + this.level}`][params.type].findIndex(
    //     (it) => it == params.x
    //   );
    //   if (i != -1) {
    //     console.log("存在该点");
    //     return 1;
    //   }
    //   let idx = this[`${"arrList" + this.level}`][params.type].findIndex(
    //     (it) => it > params.x
    //   );
    //   this[`${"arrList" + this.level}`][params.type].splice(
    //     idx === -1
    //       ? this[`${"arrList" + this.level}`][params.type].length
    //       : idx,
    //     0,
    //     params.x
    //   );
    //   console.log(this[`${"arrList" + this.level}`]);
    // },

    // clearCanvas() {  //清空心搏标注数据
    //   this.initBeatLabel()
    //   this.chart2_redraw()
    //   // this.pointdata.length = 0;
    //   // this[`${"arrList" + this.level}`] = {
    //   //   Normal: [],
    //   //   FangZao: [],
    //   //   ShiZao: [],
    //   //   FangYi: [],
    //   //   GanRao: [],
    //   // };
    //   // this.graphic.length = 0;
    //   // this.graphic = [];
    //   // this.graphic2 = [];
    //   // console.log(this.graphic);
    //   // setTimeout(() => {
    //   //   this.redraw();
    //   // });
    // },

    //重绘
    // redraw() {
    //   var chartOption = this.chart.getOption();
    //   chartOption.graphic = this.graphic;
    //   console.log(":::", this.graphic)
    //   this.chart.setOption(chartOption, true);
    //   this.chart.setOption({});
    //   this.chart.setOption({
    //     series: {
    //       markPoint: {
    //         symbol: "pin",
    //         symbolSize: 25,
    //         animation: false,
    //         data: this.pointdata,
    //       },
    //     },
    //   });
    //
    // },
    //删除点

    //关闭窗口
    clickClose() {
      this.lead1 = false;
      this.lead2 = false;
      this.radio1 = "";
      this.radio2 = "";
      this.activeName = "first";
      this.drawShow = false;
      // this.arrList1 = [];
      // this.arrList2 = [];
      // this.arrList3 = [];
      // this.arrList4 = [];
      // this.subData = this.subData = {
      //   P1: [],
      //   P2: [],
      //   P3: [],
      //   R1: [],
      //   R2: [],
      //   R3: [],
      //   T1: [],
      //   T2: [],
      //   T3: [],
      // };
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


    //关闭
    // Off() {
    //   this.lead1 = false;
    //   this.lead2 = false;
    //   this.radio1 = "";
    //   this.radio2 = "";
    //   this.activeName = "first";
    //   this.show = false;
    // },
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
      //判断数据是否为空


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

      })
      this.chart2_redraw()
      this.isLoading = false
    },
    //处理全局键盘点击
    handleGlobalkeydown(event) {
      if (!this.drawShow) return

      if (this.activeName == "first") {
        switch (event.key) {
          case '1':
            this.activeName = "first"; // 切换到目标 Tab
            tabButton[0].click();
            break;
          case '2':
            this.activeName = "second"; // 切换到目标 Tab
            tabButton[1].click();
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
            q
          case 'r':
            this.clickitem1('FangYi');
            break;
          case 't':
            this.clickitem1('GanRao');
            break;
          default:
            break;
        }
      } else if (this.activeName == "second") {
        switch (event.key) {
          case '1':
            this.activeName = "first"; // 切换到目标 Tab
            this.handleClick({index: "0"});
            break;
          case '2':
            this.activeName = "second"; // 切换到目标 Tab
            this.handleClick({index: "1"});
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
          case 'Delete':
            this.quickDelete();
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

