<template>
  <div class="main">
    <div class="patientInformation">
      <div class="patientInformation-biaoti">用户信息</div>
      <div class="patientInformation-xiangxi">
        <!--        <span id="">用户ID：{{ message.pid }}</span>-->
        <span>性别：{{ message.sex }}</span>
        <span>年龄：{{ message.age }}</span>
        <span>时间：{{ message.time }}</span>

        <span style="margin-left: 500px">上次标注时间：{{ updateTime }}</span>
        <span>上次标注人id：{{ updateBy }}</span>
      </div>

      <div class="tijiao">
        <div>
          <el-button type="success" @click="AILabel()">
            AI标注
          </el-button>
          <el-button type="success" id="btn1" class="btn1" @click="submit()">
            提交
          </el-button>
          <el-button class="btn2" id="btn2" @click="suspected()"
          >是否疑似病理
          </el-button
          >
          <el-button
            class="next"
            v-if="state"
            @click="prev()"
            type="primary"
            :loading="loading"
          >上一个
          </el-button
          >
          <el-button class="next" v-if="state" @click="next()" :loading="loading"
          >下一个
          </el-button
          >
        </div>

      </div>

    </div>

    <!--    <div class="showbox" id="jump" v-show="show" @contextmenu.prevent>-->
    <!--      <div class="noName" v-show="lead">-->
    <!--        <el-radio-group v-model="radio">-->
    <!--          <el-radio-button @click.native.prevent="clickitem('P1')" label="P1"-->
    <!--          >P1-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('P2')" label="P2"-->
    <!--          >P2-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('P3')" label="P3"-->
    <!--          >P3-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('R1')" label="R1"-->
    <!--          >R1-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('R2')" label="R2"-->
    <!--          >R2-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('R3')" label="R3"-->
    <!--          >R3-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('T1')" label="T1"-->
    <!--          >T1-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('T2')" label="T2"-->
    <!--          >T2-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--          <el-radio-button @click.native.prevent="clickitem('T3')" label="T3"-->
    <!--          >T3-->
    <!--          </el-radio-button-->
    <!--          >-->
    <!--        </el-radio-group>-->

    <!--        <el-button class="btn3" @click="clearData()">清空</el-button>-->
    <!--        <el-button class="btn3" @click="submitData()">提交</el-button>-->
    <!--        <el-popover-->
    <!--          placement="bottom-start"-->
    <!--          title="提示"-->
    <!--          width="220"-->
    <!--          class="popo"-->
    <!--          trigger="hover"-->
    <!--        >-->
    <!--          <p class="tipck">1. 选择标点类型，在框内单击左键标点</p>-->
    <!--          <p class="tipck">2. 右键单击点可以进行删除</p>-->
    <!--          <p class="tipck">3. 标点完成后点击提交</p>-->
    <!--          <p class="tipck">也可选择清空所有数据</p>-->
    <!--          <div slot="reference"><i class="el-icon-info icon"></i></div>-->
    <!--        </el-popover>-->
    <!--      </div>-->
    <!--      <div id="chartjump"></div>-->
    <!--      <div id="rightMenu" class="menu" style="display: none">-->
    <!--        <el-button class="button" @click="del">删除</el-button>-->
    <!--      </div>-->
    <!--      <button class="btn" style="right: 0; top: 0" @click="Off">关闭</button>-->
    <!--    </div>-->


    <div class="bottom">
      <div class="bottomLeft">
        <div class="xinDian">心电图</div>
        <div class="echarts">
          <div class="container">
            <div
              class="chart"
              id="I"
              @dblclick="showchart('I', data.I)"
            ></div>
            <span
              class="light"
              id="Ilight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="II"
              @dblclick="showchart('II', data.II)"
            ></div>
            <span
              class="light"
              id="IIlight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="III"
              @dblclick="showchart('III', data.III)"
            ></div>
            <span
              class="light"
              id="IIIlight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="aVR"
              @dblclick="showchart('aVR', data.aVR)"
            ></div>
            <span
              class="light"
              id="aVRlight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="aVL"
              @dblclick="showchart('aVL', data.aVL)"
            ></div>
            <span
              class="light"
              id="aVLlight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="aVF"
              @dblclick="showchart('aVF', data.aVF)"
            ></div>
            <span
              class="light"
              id="aVFlight"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V1"
              @dblclick="showchart('V1', data.V1)"
            ></div>
            <span
              class="light"
              id="V1light"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V2"
              @dblclick="showchart('V2', data.V2)"
            ></div>
            <span
              class="light"
              id="V2light"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V3"
              @dblclick="showchart('V3', data.V3)"
            ></div>
            <span
              class="light"
              id="V3light"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V4"
              @dblclick="showchart('V4', data.V4)"
            ></div>
            <span
              class="light"
              id="V4light"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V5"
              @dblclick="showchart('V5', data.V5)"
            ></div>
            <span
              class="light"
              id="V5light"
            ></span>
          </div>
          <div class="container">
            <div
              class="chart"
              id="V6"
              @dblclick="showchart('V6', data.V6)"
            ></div>
            <span
              class="light"
              id="V6light"
            ></span>
          </div>
        </div>
      </div>


      <div class="bottomRight">
        <div class="xinDian">质量评估</div>
        <div class="quality">
          <div class="lights">
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.Ilevel"
                @change="changeRadios(noise_level.Ilevel, 'Ilevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.IIlevel"
                @change="changeRadios(noise_level.IIlevel, 'IIlevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.IIIlevel"
                @change="changeRadios(noise_level.IIIlevel, 'IIIlevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.aVRlevel"
                @change="changeRadios(noise_level.aVRlevel, 'aVRlevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.aVLlevel"
                @change="changeRadios(noise_level.aVLlevel, 'aVLlevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.aVFlevel"
                @change="changeRadios(noise_level.aVFlevel, 'aVFlevel')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V1level"
                @change="changeRadios(noise_level.V1level, 'V1level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V2level"
                @change="changeRadios(noise_level.V2level, 'V2level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V3level"
                @change="changeRadios(noise_level.V3level, 'V3level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V4level"
                @change="changeRadios(noise_level.V4level, 'V4level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V5level"
                @change="changeRadios(noise_level.V5level, 'V5level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
            <div class="abcd">
              <el-radio-group
                v-model="noise_level.V6level"
                @change="changeRadios(noise_level.V6level, 'V6level')"
              >
                <el-radio label="A" border size="mini" class="radios"
                >A
                </el-radio
                >
                <el-radio label="B" border size="mini" class="radios"
                >B
                </el-radio
                >
                <el-radio label="C" border size="mini" class="radios"
                >C
                </el-radio
                >
                <el-radio label="D" border size="mini" class="radios"
                >D
                </el-radio
                >
              </el-radio-group>
            </div>
          </div>
          <div class="allin">
            <button class="green" @click="allA">全A</button>
            <button class="red" @click="allB">全B</button>
            <button class="red" @click="allC">全C</button>
            <button class="red" @click="allD">全D</button>
          </div>
        </div>
      </div>

      <!-- 要修改的部分 -->
      <div class="topLeft">
        <div class="topMiddle">
          <div class="warning">
            <!-- 预警类型 -->
            <!-- <div>预警类型</div>
            <div>心肌炎</div> -->
            <template>
              <el-tabs v-model="activeName" @tab-click="handleClick" style="z-index: 1">
                <el-tab-pane label="预警类型" name="yujingleixing">
                  <div class="warningDetail">
                    <form id="loginForm" name="loginForm" class="biaodan">
                      <div class="duoxuan">
                        <el-checkbox-group v-model="trueValues">
                          <div v-for="(group,index) in options" :key="index">
                            <div class="fenzuzhuti">
                              {{ group.label }}
                            </div>
                            <div class="fenzuzhutizi">
                              <ul class="xiaoul">
                                <li
                                  v-for="(item,i) in group.options"
                                  class="xiaoli"
                                  :key="i"
                                >
                                  <el-checkbox
                                    :checked="item.leixing"
                                    :label="item.value"
                                    border
                                    size="mini"
                                  >
                                    {{ item.value }}
                                  </el-checkbox>
                                </li>
                              </ul>
                            </div>
                            <div class="xian"></div>
                          </div>
                        </el-checkbox-group>
                      </div>
                    </form>
                  </div>
                </el-tab-pane>


                <el-tab-pane label="心肌炎" name="xinjiyan">
                  <div class="warningDetail">
                    <form id="loginForm" name="loginForm" class="biaodan">
                      <div class="duoxuan">
                        <el-checkbox-group v-model="myocarditiszhi" @change="zhong">
                          <div v-for="(group,index) in myocarditis" :key="index">
                            <div class="fenzuzhuti">
                              {{ group.label }}
                            </div>
                            <div class="fenzuzhutizi">
                              <ul class="xiaoul">
                                <li
                                  v-for="(item,i) in group.options"
                                  class="xiaoli"
                                  :key="i"
                                >
                                  <el-checkbox
                                    :checked="item.leixing"
                                    :label="item.value"
                                    border
                                    size="mini"
                                  >
                                    {{ item.value }}
                                  </el-checkbox>
                                </li>
                              </ul>
                            </div>
                            <div class="xian"></div>
                          </div>
                        </el-checkbox-group>
                        <div class="others">
                          <div class="others-word ">其他：</div>
                          <div class="others-inputbox">
                            <el-input v-model="others" placeholder="请输入内容" clearable @change="qitazhi"></el-input>
                          </div>
                        </div>
                        <div class="xian"></div>
                      </div>
                    </form>
                  </div>
                </el-tab-pane>
              </el-tabs>
            </template>
          </div>
        </div>
      </div>
      <child ref="drawShow"></child>
    </div>

  </div>
</template>

<script>
//单导预警页面数据
import {getAlert_log, listAlert_log} from "@/api/alert_log/alert_log";
import $ from "jquery";
import * as echarts from "@/api/tool/echarts.min";
import de from "element-ui/src/locale/lang/de";
import child from "@/views/alert_log/alert_log/child.vue";
import {getJecg12, addJecg12, updateJecg12} from "@/api/Jecg12/Jecg12";
import {listAlert_type} from "@/api/alert_type/alert_type";

export default {
  name: "LabelEcg12",
  components: {child},
  computed: {
    de() {
      return de;
    },
  },
  data() {
    return {
      log_id: null,
      user_id: null,

      myocarditis: [
        {
          label: 'ST-T',
          options: [{value: 'ST-T显著改变', label: 'ST-Txzgb'}, {value: 'ST-T轻微改变', label: 'ST-Tqwgb'}]
        },
        {
          label: '期前收缩',
          options: [{value: '无联律', label: 'wll'}, {value: '二联律', label: 'ell'}, {
            value: '三联律',
            label: 'sll'
          }, {value: '成对', label: 'cd'}]
        },
        {
          label: '其他',
          options: [{value: '异常Q波', label: 'ycQb'}, {value: '窦性心律不齐', label: 'dxxlbq'}]
        }
      ],
      activeName: 'yujingleixing',
      luyou: '',
      testArray: [],

      lead: false,
      tap: {
        P1: false,
        P2: false,
        P3: false,
        R1: false,
        R2: false,
        R3: false,
        T1: false,
        T2: false,
        T3: false,
      },
      radio: "",
      //通过字典将radio和light一一对应
      levellight: {
        V1level: "V1light",
        V2level: "V2light",
        V3level: "V3light",
        V4level: "V4light",
        V5level: "V5light",
        V6level: "V6light",
        aVLlevel: "aVLlight",
        aVFlevel: "aVFlight",
        aVRlevel: "aVRlight",
        Ilevel: "Ilight",
        IIlevel: "IIlight",
        IIIlevel: "IIIlight",
      },
      lightlevel: {
        V1light: "V1level",
        V2light: "V2level",
        V3light: "V3level",
        V4light: "V4level",
        V5light: "V5level",
        V6light: "V6level",
        aVLlight: "aVLlevel",
        aVFlight: "aVFlevel",
        aVRlight: "aVRlevel",
        Ilight: "Ilevel",
        IIlight: "IIlevel",
        IIIlight: "IIIlevel",
      },
      //判断红绿颜色
      noise_list: {
        Ilight: "",
        IIlight: "",
        IIIlight: "",
        aVLlight: "",
        aVFlight: "",
        aVRlight: "",
        V1light: "",
        V2light: "",
        V3light: "",
        V4light: "",
        V5light: "",
        V6light: "",
      },

      levelList: ["I", "II", "III", "aVR", "aVL", "aVF", "V1", "V2", "V3", "V4", "V5", "V6"],
      beatList: ["Normal", "FangZao", "ShiZao", "FangYi", "GanRao"],
      waveList: ["P1", "P2", "P3", "R1", "R2", "R3", "T1", "T2", "T3"],
      message: {
        devicesn: "",
        user_id: "",
        pid: "",
        logid: "",
        sex: "",
        age: "",
        time: "",
        logType: "",
      },
      query: {
        userId: "",
        logId: "",
        waveLabel: "",
      },
      value: "正常心电图",
      options: [],
      // timex: [],
      state: true,
      show: false,
      seriesdata: [{yAxis: -3}, {yAxis: -2.5}, {yAxis: -2}, {yAxis: -1.5}, {yAxis: -1}, {yAxis: -0.5}, {yAxis: 0}, {yAxis: 0.5}, {yAxis: 1}, {yAxis: 1.5}, {yAxis: 2}, {yAxis: 2.5}, {yAxis: 3},],
      seriesdata1: [{yAxis: -1}, {yAxis: -0.5}, {yAxis: 0}, {yAxis: 0.5}, {yAxis: 1},],
      data: {},
      chartjump: null,
      // xIndex: null,
      // delX: {key: null, value: null}, //想要删除的点
      // area: [], //想要删除的区间
      // markArea: [],
      // title: "",

      //噪声等级标签
      noise_level: {
        Ilevel: "A",
        IIlevel: "A",
        IIIlevel: "A",
        aVRlevel: "A",
        aVLlevel: "A",
        aVFlevel: "A",
        V1level: "A",
        V2level: "A",
        V3level: "A",
        V4level: "A",
        V5level: "A",
        V6level: "A",
      },

      //标签相关数据
      trueValues: [],// 预警类型标签
      myocarditiszhi: [],// 心机炎标签
      subData: null, //波段标注标签
      pointdata: null, //心搏标注标签
      rectangles: null, //矩形框标签
      isSuspected: false,
      others: "",//其他原因
      updateTime: "",
      updateBy: "",

      // 初始化查询参数
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


      index: 0,//当前数据在page中的索引，初始化为0
      anoStatus: null,//当前数据标注状态

      logList: [],

      loading: false,
      logListTotal: 0,

      typeObj: {},
      obj: {},
      pId: '',
    };
  },
  watch: {
    isSuspected(val) {
      document.getElementById("btn2").style.backgroundColor = this.isSuspected ? "#4cc9f0" : "";
    },
  },
  beforeRouteLeave(to, from, next) {
    // 离开页面直接关闭窗口
    this.$store.dispatch("tagsView/delView", this.$route);
    next()
  },
  created() {
    //获取页面路由参数
    if (this.$route.query.logId) {
      // 获取原页面请求
      this.log_id = this.$route.query.logId

      this.queryParams.pageNum = this.$route.query.pageNum;
      this.queryParams.pageSize = this.$route.query.pageSize;
      this.queryParams.anoStatus = this.$route.query.anoStatus;
      this.queryParams.logTime = this.$route.query.logTime;
      this.queryParams.pId = this.$route.query.pId;
    }
  },
  mounted() {
    this.getLogId();
    this.getMessage();
    this.getIndex();
    this.getLabel();
    this.chartjump = echarts.init(document.getElementById("chartjump"));

  },
  methods: {
    qitazhi(data) {
    },
    zhong(data) {
    },

    handleClick(tab, event) {
    },
    // 1获取预警类型表
    // getSelectList() {
    //   selectList().then((res) => {
    //     this.options = res.data;
    //     // console.log(res.data);
    //   });
    // },

    // 获取当前数据在page中的index
    async getIndex() {
      await listAlert_log(this.queryParams).then((response) => {
        this.logList = response.rows;
        this.logListTotal = response.total;
        this.logList.forEach((item, index) => {
          if (this.log_id == item.logId) {
            this.index = index;
          }
        });
      })
    },
    //根据index获取logid
    async getLogId() {
      await listAlert_log(this.queryParams).then((response) => {
        this.logList = response.rows;
        this.logListTotal = response.total;
        this.logList.forEach((item, index) => {
          if (this.index == index) {
            this.log_id = item.logId;
          }
        });
      })
    },
    // 2获取数据标注页面数据
    // async getLogUserList() {
    //   let queryParams = {}
    //   if (this.typeObj) {
    //     queryParams = this.typeObj;
    //   } else {
    //     queryParams = this.$route.query
    //   }
    //
    //   this.obj = {
    //     logId: queryParams.logId ? queryParams.logId : "",
    //     userId: this.$route.query.userId ? this.$route.query.userId : "",
    //     ecgType: this.$route.query.ecgType,
    //     pageNum: this.pageNum,
    //     pageSize: this.pageSize,
    //     anoStatus: this.anoStatus,
    //     logTime: queryParams.logTime ? queryParams.logTime : "",
    //     eventDescription: queryParams.eventDescription ? queryParams.eventDescription : "",
    //     eventName: queryParams.eventName ? queryParams.eventName : "",
    //     pId: queryParams.pId ? queryParams.pId : "",
    //     isSuspected: queryParams.isSuspected ? queryParams.isSuspected : "",
    //   };
    //   // console.log("查看标注页获取用户信息所需要的值");
    //   // console.log(this.obj);
    //   await listAlert_log(this.obj).then((response) => {
    //     // console.log("12导预警");
    //     // console.log(response)
    //     this.logUserList = response.rows;
    //
    //     this.logUserListTotal = response.total;
    //     this.logUserList.forEach((item, index) => {
    //       console.log(item.logId, index)
    //       if (this.message.logid == item.logId) {
    //         this.index = index;
    //       }
    //     });
    //     // console.log(this.logUserList);
    //   })
    //   if (this.index === this.logUserList.length) {
    //     this.index = 0
    //   }
    //   // console.log("这是this.index的值："+this.index);
    //
    //   // console.log(this.logUserList[this.index].eventDescription);
    //   // 假设 this.index 是你要访问的 logUserList 数组中的索引
    //   if (this.logUserList[this.index].eventDescription) {
    //     // 拆分 logType 字符串为一个数组
    //     let logTypesArray = this.logUserList[this.index].eventDescription.split(',');
    //
    //     // 将拆分后的数组中的每个值添加到 trueValues 数组中
    //     this.trueValues = logTypesArray
    //   }
    //   if (this.logUserList[this.index].myocardiumType) {
    //     let xinjiyan = JSON.parse(this.logUserList[this.index].myocardiumType)
    //     this.myocarditiszhi = xinjiyan.myocarditiszhi.split(',')
    //     this.others = xinjiyan.others
    //   }
    //
    // },

    //获取心电数据
    getMessage() {
      console.log("id:", this.log_id)
      var Iy = [];
      var IIy = [];
      var IIIy = [];
      var aVLy = [];
      var aVFy = [];
      var aVRy = [];
      var V1y = [];
      var V2y = [];
      var V3y = [];
      var V4y = [];
      var V5y = [];
      var V6y = [];
      var timex = [];
      var chartI = echarts.init(document.getElementById("I"));
      var chartII = echarts.init(document.getElementById("II"));
      var chartIII = echarts.init(document.getElementById("III"));
      var chartV1 = echarts.init(document.getElementById("V1"));
      var chartV2 = echarts.init(document.getElementById("V2"));
      var chartV3 = echarts.init(document.getElementById("V3"));
      var chartV4 = echarts.init(document.getElementById("V4"));
      var chartV5 = echarts.init(document.getElementById("V5"));
      var chartV6 = echarts.init(document.getElementById("V6"));
      var chartaVR = echarts.init(document.getElementById("aVR"));
      var chartaVL = echarts.init(document.getElementById("aVL"));
      var chartaVF = echarts.init(document.getElementById("aVF"));
      var _th = this;
      $.ajax({
        type: "POST",
        url: "https://screen.mindyard.cn:84/getId",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
          log_id: this.log_id,
          user_id: 0,  // userid得是0才有权限
        }),
        success: jsonResult => {
          _th.data = jsonResult.result;
          // console.log(jsonResult);
          _th.message.pid = jsonResult.result.patientid;
          _th.message.age = Number(jsonResult.result.age).toFixed(0);
          _th.message.sex = jsonResult.result.sex;
          _th.message.time = jsonResult.result.clockTime;
          _th.value = jsonResult.result.logType;
          _th.loading = false;
          if (_th.message.devicesn != null) {
            (function () {
              var i;
              for (var k = 0; k < 1001; k++) {
                timex.push(k / 100 + "秒");
              }
              for (i = 0; i < 1000; i++) {
                Iy.push(jsonResult.result.I[i]);
                IIy.push(jsonResult.result.II[i]);
                IIIy.push(jsonResult.result.III[i]);
                aVLy.push(jsonResult.result.aVL[i]);
                aVRy.push(jsonResult.result.aVR[i]);
                aVFy.push(jsonResult.result.aVF[i]);
                V1y.push(jsonResult.result.V1[i]);
                V2y.push(jsonResult.result.V2[i]);
                V3y.push(jsonResult.result.V3[i]);
                V4y.push(jsonResult.result.V4[i]);
                V5y.push(jsonResult.result.V5[i]);
                V6y.push(jsonResult.result.V6[i]);
              }
              for (var i = 0; i < 2500; i += 20) {
                _th.seriesdata.push({xAxis: i});
              }
              var seriesdata = _th.seriesdata;
              if (jsonResult.result.II.length === 1000) {
                for (var i = 0; i < 1000; i += 20) {
                  _th.seriesdata1.push({xAxis: i});
                }
                seriesdata = _th.seriesdata1;
              }
              chartI.clear();
              chartI.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "I导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,

                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  // splitNumber: 20,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
                  markLine: {
                    animation: false,
                    symbol: "none",
                    silent: true,
                    lineStyle: {
                      type: "solid",
                      color: "#b33939",
                      width: 0.5,
                      // opacity: 0.5,
                    },
                    label: {
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "I导联",
                  type: "line",
                  data: Iy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartI.resize();
              });
              chartII.clear();
              chartII.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "II导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },

                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,

                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "II导联",
                  type: "line",
                  data: IIy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartII.resize();
              });
              chartV1.clear();
              chartV1.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V1导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  // splitNumber: 20,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
                  markLine: {
                    animation: false,
                    symbol: "none",
                    silent: true,
                    lineStyle: {
                      type: "solid",
                      color: "#b33939",
                      width: 0.5,
                      // opacity: 0.5,
                    },
                    label: {
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "V1导联",
                  type: "line",
                  data: V1y,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartV1.resize();
              });
              chartV2.clear();
              chartV2.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V2导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "V2导联",
                  type: "line",
                  data: V2y,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartV2.resize();
              });
              chartV3.clear();
              chartV3.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V3导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "V3导联",
                  type: "line",
                  data: V3y,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartV3.resize();
              });
              chartV4.clear();
              chartV4.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V4导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },

                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  // splitNumber: 20,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "V4导联",
                  type: "line",
                  data: V4y,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartV4.resize();
              });
              chartV5.clear();
              chartV5.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V5导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "V5导联",
                  type: "line",
                  data: V5y,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartV5.resize();
              });
              chartV6.clear();
              chartV6.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "V6导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: true,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: [
                  {
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
                        position: "start", // 表现内容展示的位置
                        color: "#b33939", // 展示内容颜色
                      },
                      data: seriesdata,
                    },
                    /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                    itemStyle: {
                      normal: {
                        lineStyle: {
                          width: 1.5,
                          color: "#000000" /*折线的颜色*/,
                        },
                        color:
                          "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                      },
                    },
                    symbol: "none",
                    /*去掉小圆点*/
                    name: "当前电位",
                    type: "line",
                    data: V6y,
                    smooth: 0, //显示为平滑的曲线*/
                  },
                ],
              });
              $(window).resize(function () {
                chartV6.resize();
              });
              chartIII.clear();
              chartIII.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "III导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },

                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  // splitNumber: 20,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "III导联",
                  type: "line",
                  data: IIIy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartIII.resize();
              });
              chartaVL.clear();
              chartaVL.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "aVL导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "aVL导联",
                  type: "line",
                  data: aVLy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartaVL.resize();
              });
              chartaVF.clear();
              chartaVF.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "aVF导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "aVF导联",
                  type: "line",
                  data: aVFy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartaVF.resize();
              });
              chartaVR.clear();
              chartaVR.setOption({
                animation: false,
                animationDuration: 9900,
                animationEasing: "linear",
                animationEasingUpdate: "linear",
                animationDurationUpdate: 10000,
                animationDelayUpdate: 0,
                animationThreshold: 10000,
                backgroundColor: "#ffffff",
                title: {
                  text: "aVR导联",
                  textStyle: {
                    fontSize: 12,
                    color: "#000000",
                  },
                  left: 30,
                },
                tooltip: {
                  trigger: "axis",
                  axisPointer: {
                    type: "cross",
                  },
                },
                grid: {
                  left: 20,
                  right: 0,
                  top: 2,
                  bottom: 2,
                },
                xAxis: {
                  type: "category",
                  boundaryGap: false,
                  data: timex,
                  axisTick: {
                    show: false,
                  },
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    interval: 3,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    show: true,
                    lineStyle: {
                      color: "pink",
                      width: 0.5, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                  } /*网格线*/,
                },
                yAxis: {
                  min: -1,
                  max: 1,
                  boundaryGap: true,
                  interval: 0.1,
                  // splitNumber: 20,
                  axisLabel: {
                    //修改坐标系字体颜色
                    show: false,
                    textStyle: {
                      color: "#000000",
                    },
                  },
                  splitLine: {
                    lineStyle: {
                      color: "pink",
                      width: 1, //网格的宽度
                      type: "solid", //网格是实实线，可以修改成虚线以及其他的类型
                    },
                    show: true,
                  } /*网格线*/,
                },
                series: {
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
                      position: "start", // 表现内容展示的位置
                      color: "#b33939", // 展示内容颜色
                    },
                    data: seriesdata,
                  },
                  /*itemStyle: {normal: {areaStyle: {type: 'default'}}},*/
                  itemStyle: {
                    normal: {
                      lineStyle: {
                        width: 1.5,
                        color: "#000000" /*折线的颜色*/,
                      },
                      color:
                        "#000000" /*图例(legend)的颜色,不是图例说明文字的颜色*/,
                    },
                  },
                  symbol: "none",
                  /*去掉小圆点*/
                  name: "aVR导联",
                  type: "line",
                  data: aVRy,
                  smooth: 0, //显示为平滑的曲线*/
                },
              });
              $(window).resize(function () {
                chartaVR.resize();
              });
            })();
          } else {
            _th.$modal.msgError("设备未连接");
          }
          // this.AILabel();
        },
        error: function (data) {
          console.log("获取数据失败")
          console.log(data);
          _th.$modal.msgError("数据获取失败");
        },
      });
      this.options = [] //初始化
      //获取预警类型
      listAlert_type({
        pageNum: 1,
        pageSize: 10000,
      }).then(res => {
        res.rows.forEach(item => {
          var labelExist = false

          this.options.forEach((child, index) => {
            //判断数组中有没有这个label
            if (child.label == item.type) {
              labelExist = true
            }
          })
          if (labelExist == false) {
            this.options.push({label: item.type, options: []})
          }
          this.options.forEach((child, index) => {
            //插入options
            if (child.label == item.type) {
              this.options[index]["options"].push({value: item.value, label: item.label,});
            }
          })
        })
      })

    },
    // 获取标注数据
    getLabel() {
      // 标签数据初始化
      this.noise_level = {
        Ilevel: "A",
        IIlevel: "A",
        IIIlevel: "A",
        aVRlevel: "A",
        aVLlevel: "A",
        aVFlevel: "A",
        V1level: "A",
        V2level: "A",
        V3level: "A",
        V4level: "A",
        V5level: "A",
        V6level: "A",
      }
      this.myocarditiszhi = []
      this.trueValues = []
      this.subData = null //波段标注标签
      this.pointdata = null //心搏标注标签
      this.rectangles = null //矩形框标签
      this.isSuspected = false
      this.others = ""
      this.updateTime = ""
      this.updateBy = ""
      getJecg12(this.log_id) //固定第一条数据pId以测试 00cab968-3b9b-5cc4-8f58-57be9dd88b09
        .then((res) => {
          // 对返回的标签进行处理，
          // 1 未找到对应id的标签，插入一条初始化空数据
          if (!res.data) {
            addJecg12({
              pId: this.log_id,
              updateTime: new Date().getDate(),
              updateBy: this.$store.state.user.id,
            })
            return
          }
          //查询到标签，做赋值处理
          this.subData = JSON.parse(res.data.waveLabel);
          this.pointdata = JSON.parse(res.data.beatLabel);
          this.rectangles = JSON.parse(res.data.rectangles);
          this.noise_level = res.data.noiseLevel == null ? this.noise_level : JSON.parse(res.data.noiseLevel)
          this.isSuspected = res.data.isSuspected == null ? this.isSuspected : Boolean(res.data.isSuspected)
          this.trueValues = res.data.options1 == null ? this.trueValues : JSON.parse(res.data.options1)
          this.myocarditiszhi = res.data.options2 == null ? this.myocarditiszhi : JSON.parse(res.data.options2)
          this.others = res.data.others == null ? this.others : JSON.parse(res.data.others)
          this.updateTime = res.data.updateTime == null ? this.updateTime : res.data.updateTime
          this.updateBy = res.data.updateBy == null ? this.updateBy : res.data.updateBy
          //手动渲染红绿按钮显示
          this.light(this.noise_level);
          // 监听事件还没有触发，手动重新渲染button
          document.getElementById("btn2").style.backgroundColor = this.isSuspected ? "#4cc9f0" : "";
        })
      // 2 无论查没查到，对几个复杂格式数据格式化
      if (this.subData == null) {
        var waveLabel = {};
        for (var i = 0; i < this.levelList.length; i++) {
          if (!waveLabel[String(i)]) waveLabel[String(i)] = {}
          this.waveList.forEach(item => {
            waveLabel[String(i)][item] = []
          })
        }
        this.subData = waveLabel
      }
      if (this.pointdata == null) {
        var beatLabel = {};
        for (var i = 0; i < this.levelList.length; i++) {
          if (!beatLabel[String(i)]) beatLabel[String(i)] = {}
          this.beatList.forEach(item => {
            beatLabel[String(i)][item] = []
          })
        }
        this.pointdata = beatLabel
      }
      if (this.rectangles == null) {
        var rectangles = {};
        for (var i = 0; i < length(this.levelList); i++) {
          rectangles[String(i)] = []
        }
        this.rectangles = rectangles
      }

      // 3 标签不全（暂时不考虑，如果需要与之前未标全的标签融合再考虑）
    },
    //判断红绿颜色
    light(noise) {

      for (var key in noise) {
        if (noise[key] == "A") {
          let temp = document.getElementById(this.levellight[key]);
          temp.style.backgroundColor = "greenyellow";
        } else {
          let temp = document.getElementById(this.levellight[key]);
          temp.style.backgroundColor = "red";
        }
      }
    },
    //ABCD等级的判断
    // level(data) {
    //   this.noise_level = data.result.noise_level;
    //   // console.log("传的ABCD的等级", this.noise_level)
    // },

    //全为A
    allA() {
      for (var k in this.noise_level) {
        console.log(this.noise_level[k]);
        this.noise_level[k] = "A";
        this.noise_list[this.levellight[k]] = 0;
        let temp = document.getElementById(this.levellight[k]);
        temp.style.backgroundColor = "greenyellow";
      }
    },
    //全为B
    allB() {
      for (var k in this.noise_level) {
        this.noise_level[k] = "B";
        this.noise_list[this.levellight[k]] = 1;
        let temp = document.getElementById(this.levellight[k]);
        temp.style.backgroundColor = "red";
      }
    },
    //全为C
    allC() {
      for (var k in this.noise_level) {
        this.noise_level[k] = "C";
        this.noise_list[this.levellight[k]] = 1;
        let temp = document.getElementById(this.levellight[k]);
        temp.style.backgroundColor = "red";
      }
    },
    //全为D
    allD() {
      for (var k in this.noise_level) {
        this.noise_level[k] = "D";
        this.noise_list[this.levellight[k]] = 1;
        let temp = document.getElementById(this.levellight[k]);
        temp.style.backgroundColor = "red";
      }
    },
    //修改等级的程度
    changeRadios(value, lab) {
      // console.log(value)
      // console.log(lab)
      let dom = document.getElementById(this.levellight[lab]);
      if (value === "A") {
        dom.style.backgroundColor = "greenyellow";
        this.noise_list[this.levellight[lab]] = 0;
      } else {
        dom.style.backgroundColor = "red";
        this.noise_list[this.levellight[lab]] = 1;
      }

      console.log("修改之后的等级：", this.noise_level);
      console.log("修改之后的等级：", this.noise_list);
    },

    clearData() {
      this.pointdata = [];
      this.subData = {
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
      this.chartjump.setOption({
        series: {
          markPoint: {
            symbol: "pin",
            symbolSize: 24,
            animation: false,
            data: [],
          },
        },
      });
    },
    suspected() {
      this.isSuspected = !this.isSuspected;
      console.log(this.isSuspected)
    },
    async prev() {
      this.loading = true; //转圈动画效果

      //判断pagenum值和index是否为第一页第一个
      if (this.queryParams.pageNum == 1 && this.index == 0) {
        this.$message.warning("已经是第一页！！！");
        this.loading = false;
        return;
      }

      //如果index为0，则请求上一个页面
      if (this.index <= 0) {
        this.queryParams.pageNum = this.queryParams.pageNum - 1;
        this.index = this.queryParams.pageSize - 1;
      } else {
        this.index = this.index - 1;
      }
      //根据index获取log_id
      await this.getLogId();
      this.getMessage();
      this.getLabel();
      this.loading = false;
      var newUrl =
        this.$route.path +
        `?logId=${this.log_id}` +
        `&pageNum=${this.queryParams.pageNum}` +
        `&pageSize=${this.queryParams.pageSize}` +
        `&anoStatus=${this.queryParams.anoStatus}` +
        `&logTime=${this.queryParams.logTime}`;
      window.history.replaceState("", "", newUrl);
    },
    // 点击下一页触发事件
    async next() {
      this.loading = true; //转圈动画效果

      //是否为最后一页最后一个
      if ((this.queryParams.pageNum - 1) * this.queryParams.pageSize + this.index + 1 >= this.logListTotal) {
        this.$message.warning("已经是最后一个！！！");
        this.loading = false;
        return;
      }

      if (this.index >= this.queryParams.pageSize - 1) {
        this.queryParams.pageNum = 1 + parseInt(this.queryParams.pageNum, 10)
        this.index = 0;
      } else {
        this.index = this.index + 1;
      }
      //根据index获取log_id
      await this.getLogId();
      this.getMessage();
      this.getLabel();
      this.loading = false;
      var newUrl =
        this.$route.path +
        `?logId=${this.log_id}` +
        `&pageNum=${this.queryParams.pageNum}` +
        `&pageSize=${this.queryParams.pageSize}` +
        `&anoStatus=${this.queryParams.anoStatus}` +
        `&logTime=${this.queryParams.logTime}`;
      window.history.replaceState("", "", newUrl);
    },

    // 点击提交
    async submit() {
      console.log(this.others)
      //提交字段:质量评估，预警类型，心肌炎，疑似病例，其他原因
      updateJecg12({
        pId: this.log_id,
        noiseLevel: JSON.stringify(this.noise_level),
        options1: JSON.stringify(this.trueValues),
        options2: JSON.stringify(this.myocarditiszhi),
        isSuspected: this.isSuspected == true ? 1 : 0,
        others: JSON.stringify(this.others),
        updateTime: new Date().getDate(),
        updateBy: this.$store.state.user.id
      }).then(
        this.$modal.msgSuccess("数据提交成功")
      )

      // this.value = this.trueValues.join();
      // var that = this;
      // // return;
      // $.ajax({
      //   cache: true,
      //   type: "POST",
      //   dataType: "json",
      //   contentType: "application/json",
      //   url: "https://screen.mindyard.cn:84/write_logType",
      //   data: JSON.stringify({
      //     id: this.message.logid,
      //     Type: this.value,//中文
      //     list: this.noise_list,
      //     lists: this.noise_level,
      //     user_id: this.message.user_id,
      //   }),
      //   async: false,
      //   success: function (data) {
      //     console.log("success:", data);
      //     that.$modal.msgSuccess("数据提交成功");
      //   },
      //   error: function (data) {
      //     console.log("error:", data);
      //     //            cocoMessage.error("提交失败", 3000);
      //   },
      // });
      //
      //
      // //标注成功
      // let myocarditiszhiString = this.myocarditiszhi.length > 0 ? this.myocarditiszhi.toString() : '';
      // let myocardiumTypezhi = {
      //   myocarditiszhi: myocarditiszhiString,
      //   others: this.others
      // }
      // // console.log(JSON.stringify(myocardiumTypezhi));
      // islabel({
      //   logType: this.value, //预警类型
      //   logId: this.message.logid,//日志id
      //   userId: this.message.user_id,
      //   isSuspected: this.isSuspected ? 1 : 0, //是否是疑似病例 1
      //   myocardiumType: JSON.stringify(myocardiumTypezhi)
      // });
      //
      // let selectedValues = [];
      //
      // // 遍历trueValues数组
      // this.trueValues.forEach((trueValue) => {
      //   // 遍历options数组
      //   this.options.forEach((option) => {
      //     // 遍历当前option对象中的zhong数组
      //     option.options.forEach((options) => {
      //       // 如果当前zhongItem对象的label等于trueValue，则将其value添加到selectedValues数组中
      //       if (options.value === trueValue) {
      //         selectedValues.push(options.label + "Ecg");
      //       }
      //     });
      //   });
      // });
      // let dataObject = {
      //   pId: this.message.pid,
      //   logId: this.message.logid,
      //   leadCount: this.$route.query.state
      // };
      // for (let i = 0; i < selectedValues.length; i++) {
      //   // 将数组中的每个字符串作为对象的键，值为1，并放入dataObject对象中
      //   dataObject[selectedValues[i]] = 1;
      // }
      // // 接口
      // // console.log(dataObject);
      // addCount(dataObject)

    },

    // submitData() {
    //   this.query.waveLabel = JSON.stringify(this.subData);
    //   console.log(this.subData);
    //   // addLabel(this.query).then(res=>{
    //   //   this.$modal.msgSuccess("标注提交成功");
    //   // }).catch(err=>{})
    // },
    showchart(title, data) {  //显示child页面
      var level = 1
      this.levelList.forEach((item, index) => {
        if (item == title) {
          level = index + 1
        }
      })
      this.$refs.drawShow.getchart(data, this.log_id, level, title, 12,
        {"beatLabel": this.pointdata, "waveLabel": this.subData, "rectangles": this.rectangles});
      // this.$refs.drawShow.getchart2();
    },


    //区间合并
    // getMerge(arr) {
    //   arr.sort((a, b) => {
    //     if (a[0] !== b[0]) {
    //       return a[0] - b[0];
    //     }
    //     return a[1] - b[1];
    //   });
    //   let len = arr.length,
    //     ans = [],
    //     start,
    //     end; // 遍历当前区间的最小值与最大值
    //   for (let i = 0; i < len; i++) {
    //     let s = arr[i][0];
    //     let e = arr[i][1];
    //     if (start === undefined) {
    //       start = s;
    //       end = e;
    //     } else if (s <= end) {
    //       end = Math.max(e, end);
    //     } else {
    //       let part = [start, end];
    //       ans.push(part);
    //       start = s;
    //       end = e;
    //     }
    //   }
    //
    //   if (start !== undefined) {
    //     let part = [start, end];
    //     ans.push(part);
    //   }
    //   return ans;
    // },
    // Off() {
    //   for (let tapKey in this.tap) {
    //     this.tap[tapKey] = false;
    //   }
    //   this.lead = false;
    //   this.show = false;
    // },
    // del() {
    //   console.log(this.delX.key, this.delX.value);
    //   this.pointdata.some((item, index) => {
    //     if (item.xAxis == this.delX.value) {
    //       this.pointdata.splice(index, 1);
    //       return true;
    //     }
    //   });
    //   this.subData[this.delX.key].some((item, index) => {
    //     if (item == this.delX.value) {
    //       this.subData[this.delX.key].splice(index, 1);
    //       console.log("删除成功");
    //       return true;
    //     }
    //   });
    //   this.delX = {key: null, value: null};
    //   this.chartjump.setOption({
    //     series: {
    //       markPoint: {
    //         symbol: "pin",
    //         symbolSize: 24,
    //         animation: false,
    //         data: this.pointdata,
    //       },
    //     },
    //   });
    //   $("#rightMenu").css({
    //     display: "none",
    //   });
    // },
    //判断是一维数组还是二维
    // isArray(a) {
    //   for (let i of a) {
    //     if (Array.isArray(i)) return 2;
    //   }
    //   return 1;
    // },
    // clickitem(e) {
    //   e === this.radio ? (this.radio = "") : (this.radio = e);
    // },
    async AILabel() {
      const url = 'https://screen.mindyard.cn/test/api/getP_QRS_T'; // 请确保这是正确的POST请求URL

      const headers = new Headers({
        'Content-Type': 'application/json',
        'user': 'zzu',
        'password': 'zzu_api'
      });

      // 注意：在客户端代码中直接包含用户名和密码是不安全的。
      // 在实际应用中，应该避免在客户端代码中暴露敏感信息。
      var ecgData = [];
      var i;
      for (i = 0; i < 1000; i++) {
        ecgData.push(this.data.I[i])
      }
      const data = {
        "signal":ecgData, //15360
        "sample_rate": "100",
        "isFilter": "0"
      };
      const response = await fetch(url, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(data)
      });
      console.log("标注数据",response.json())
    },
  },
};
</script>


<style scoped lang="scss">
body,
html {
  color: #00afff;
  box-sizing: border-box;
}

.main {
  width: 100%;
  background: #f1faff;
}

.top {
  height: 9vw;
  width: 100%;
  //border: 4px solid #62be38;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: flex-start;
}

// 用户信息
.patientInformation {
  // border: 1px solid red;
  font-size: 1vw;
  color: #136d87;
  width: 98.5%;
  margin: 1vw 1vw 0 1vw;
}

.patientInformation-biaoti {
  padding-bottom: 0.5vw;
  font-weight: 700;
}

.patientInformation-xiangxi {
  display: flex;
  justify-content: space-between;
  // border: 1px solid red;
}

.topLeft {
  width: 29.5%;
  //height: 100%;
  border-left: 1px solid #136d87;
  display: flex;
  flex-direction: column;
}

.topMiddle {
  width: 100%;
  height: 100%;
  // background-color: #00afff;
}

.topRight {
  width: 100%;
  height: 100%;
}

.showbox {
  //display: none;
  user-select: none;
  position: absolute;
  width: 100%;
  height: 80%;
  border: 1px solid #6eddf1;
  top: 45%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2000;
  background-color: rgb(255, 255, 255);

  span {
    display: inline-block;
  }
}

.icon {
  font-size: 2vw;
}

.menu {
  /*这个样式不写，右键弹框会一直显示在画布的左下角*/
  position: absolute;
  background: rgba(255, 255, 255);
  left: -99999px;
  top: -999999px;
  padding: 0.1vw;
  border-radius: 0.5vw;
  border: 1px solid #000000;

  .button {
    height: 0.5vh;
    width: 0.5vw;
    display: inline-flex;
    text-align: center;
    border: none;
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

#chartjump {
  /*position: absolute;*/
  width: 100%;
  height: 78%;
  //top: 50%;
  //left: 50%;
  //transform: translate(-50%, -50%);
  border: 1px solid #000000;
  /*background-color: #06732b;*/
}

.message {
  width: 100%;
  height: 20%;
  font-size: 1vw;
  font-weight: 700;
  color: #136d87;
  text-align: center;
  padding: 0.8vw 0;
}

.messageDetail {
  //border-right: 1px solid #ffffff;
  width: 100%;
  height: 75%;
  font-size: 1vw;
  font-weight: 700;
  color: #136d87;
  //text-align: center;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: space-around;
}

.messageDetail span {
  padding-left: 2vw;
}

.warning {
  width: 100%;
  // height: 18%;
  font-size: 1vw;
  font-weight: 700;
  color: #136d87;
  // text-align: center;
  padding: 4px 0;
  border-bottom: 1px solid #000000;
  //border-top: 1px solid #000000;
  // display: flex;
  // justify-content:space-around;
}

.warningDetail {
  display: flex;
  flex-direction: column;
  justify-content: center;
  // align-items: center;
  margin: 0 auto;
  //border: 1px solid #ff5a00;
  width: 100%;
  // height: 35%;
  font-size: 1vw;

  ::v-deep .btn2 {
    background-color: rgba(255, 255, 255, 0);
    color: #136d87;
    border: 1px solid #136d87;
    width: 30%;
    margin: 0;
    margin-left: 0;
    padding: 10px 0;
  }
}

.page {
  display: flex;
  justify-content: center;
}

::v-deep .next {
  background-color: rgba(255, 255, 255, 0);
  color: #136d87;
  border: 1px solid #136d87;
  width: 5vw;
  margin: 0;
  padding: 10px 0;
}

.btn1 {
  color: #136d87;
  background-color: rgba(255, 255, 255, 0);
  width: 5vw;
  margin: 0;
  padding: 10px 0;
}

.btn1:hover {
  color: white;
  background-color: #4cc9f0;
}

form input {
  width: 3vw;
  height: 2vw;
  margin: 1vw;
}

.bottom {
  height: 100%;
  width: 98.5%;
  border: 1px solid #136d87;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  margin: 1vw;
  //padding: 1vw;
  justify-content: flex-start;
}

.bottomLeft {
  width: 50.5%;
  height: 100%;
  border-top: none;
}

.xinDian {
  width: 100%;
  height: 5%;
  font-size: 1vw;
  font-weight: 700;
  color: #136d87;
  text-align: center;
  padding: 0.8vw 0;
  //border-top: 1px solid #136d87;
}

.xinDian:first-child {
  border-right: 1px solid #136d87;
}

.echarts {
  width: 100%;
  height: 95%;
  border-top: 1px solid #136d87;
  border-right: 1px solid #136d87;
}

.bottomLeft .echarts .container {
  width: 100%;
  height: 100%;
  //border: 1px solid rgba(25, 186, 139, 0.17);
  position: relative;

  .btn {
    background-color: #91dff8;
  }

  .btn:hover {
    background-color: #3ec9f7;
  }
}

.bottomLeft .echarts .container .chart {
  height: 9vh;
  width: 99%;
  //background-color: #ffffff;
}

.btn {
  height: 4vh;
  width: 4vw;
  color: #136d87;
  border: 1px solid #136d87;
  border-radius: 1vw;
  background-color: transparent;
  text-transform: uppercase;
  font-weight: 500;
  position: absolute;
  top: 0;
  right: 2%;
}

.btn3 {
  color: #b33939;
  border: 1px solid #b33939;
  border-radius: 0.5em;
  background-color: transparent;
  text-transform: uppercase;
  font-weight: 500;
  //flex: 1;
  height: 4vh;
  font-size: 1vw;
  text-align: center;
  padding: 0;
  margin: 0.5vw;
  width: 4vw;
}

.noName {
  //display: inline-flex;

  //width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

::v-deep .noName .el-radio-group {
  display: block;
  //width: 98%;
}

.popo {
  height: 100%;
}

::v-deep .el-radio-button .el-radio-button__inner {
  display: inline-block;
  width: 4vw;
  height: 4vh;
  padding: 0;
  line-height: 4vh;
  font-size: 1vw;
  text-align: center;
  color: #b33939;
  border: 1px solid #b33939;
  border-radius: 0.5em;
  margin: 0.5vw;
}

.btn3:hover {
  cursor: pointer;
  /*color: white;*/
  /*border: 0;*/
  //background-color: #4cc9f0;
}

.btn:hover {
  cursor: pointer;
  color: #136d87;
  //border: 0 ;
  background-color: #4cc9f0;
}

.istap {
  background-color: #4cc9f0;
}

.nottap {
  background-color: transparent;
}

.light {
  display: inline-block;
  width: 1%;
  height: 95%;
  position: absolute;
  top: 0;
  right: 0;
  background-color: greenyellow;
}

.light:hover {
  cursor: pointer;
  border: 1px solid #136d87;
}

.bottomRight {
  width: 20%;
  height: 100%;
  //border: 1px solid #000000;
}

.quality {
  width: 100%;
  height: 95%;
  //background-color: #fff;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: flex-start;
}

.lights {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  flex-grow: 1;
  height: 96%;
  width: 80%;
}

.radios {
  //border: 0.5px solid rgb(0, 0, 0);
  box-sizing: border-box;
  color: rgb(96, 98, 102);
  cursor: pointer;
  display: block;
  font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB,
  Microsoft YaHei, Arial, sans-serif;
  //font-size: 1.5vw;
  font-weight: 500;
  height: 9vh;
  width: 3vw;
  line-height: 9vh;
  margin: 0;
  padding: 0;
  position: relative;
  text-rendering: optimizelegibility;
  user-select: none;
  white-space: nowrap;
  border: none;
}

::v-deep .el-radio--medium.is-bordered .el-radio__inner {
  height: 1vw;
  width: 1vw;
}

::v-deep .el-radio__inner::after {
  height: 0.3vw;
  width: 0.3vw;
}

::v-deep .el-radio--medium.is-bordered .el-radio__label {
  font-size: 1vw;
  padding: 5px;
}

::v-deep .el-input--medium .el-input__inner {
  color: #136d87;
  background-color: rgba(255, 255, 255, 0);
  border-radius: 0.8vw;
  border-color: #136d87;
}

::v-deep .el-select-dropdown__list {
  color: #136d87;
  background-color: rgba(255, 255, 255, 0);
}

.abcd {
  display: flex;
  justify-content: space-between;
  flex-grow: 1;
  width: 100%;
  //padding: 1.5vw;
  //margin-top: 0.3vw;
  border-left: 1px solid #136d87;
  border-top: 0.5px solid #136d87;
  //border-bottom: 0.5px solid #000000;
  //border-right: 0.5px solid #000000;
}

.allin {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  width: 20%;

  //background-color: #62be38;
}

.allin .red {
  display: inline-block;
  outline: none;
  text-align: center;
  text-decoration: none;
  width: 100%;
  flex: 1;
  margin: 0;
  font-size: 1.5vw;
  background-color: red;
  border: 1px solid #136d87;
  color: #000;
}

.allin .green {
  display: inline-block;
  outline: none;
  text-align: center;
  text-decoration: none;
  width: 100%;
  flex: 1;
  font-size: 1.5vw;
  margin: 0;
  background-color: greenyellow;
  border: 1px solid #136d87;
}

.allin .red:hover {
  cursor: pointer;
  background-color: rgba(231, 34, 34, 0.63);
}

.allin .green:hover {
  cursor: pointer;
  background-color: #c6ff78;
}

.el-radio-group {
  display: flex;
  justify-content: space-around;
}

.el-radio-button:focus:not(.is-focus):not(:active):not(.is-disabled) {
  -webkit-box-shadow: 0 0px 0px #ccc;
  box-shadow: 0 0px 0px #ccc;
}

.duoxuan {
  // border: 1px solid #136d87;
  width: 100%;
  // height: 100px;
  // text-align: center;
}

.warningi {
  width: 100%;
  text-align: center;
}

.fenzuzhuti {
  font-size: 12px;
  color: #909399;
  // border-bottom: 1px solid #000;
}

::v-deep .el-input .el-input--medium .el-input--suffix .is-focus {
  width: 100%;
  border: 1px solid red;
  font-size: 50px;
}

.biaodan {
  width: 100%;
  height: 109vh;
  // border: 1px solid red;
  overflow-y: auto;
  //  overflow: hidden;
  -webkit-overflow-scrolling: touch; /* 提高移动设备上的滚动性能 */
}

/* 隐藏滚动条但仍可滚动 */
.biaodan::-webkit-scrollbar {
  display: none;
}

::v-deep .el-select {
  width: 100%;
}

::v-deep .is-bordered {
  margin: 0;
}

::v-deep .el-checkbox.is-bordered + .el-checkbox.is-bordered {
  margin: 0;
}

.xian {
  border-bottom: 1px solid #000;
}

.fenzuzhuti {
  font-weight: 700;
  // font-style: 20px;
  // font-size: 20px;
  margin-left: 10px;
}

.fenzuzhutizi {
  display: flex;
  // flex-wrap:noweap;
  flex-wrap: wrap;
}

.xiaoul {
  margin: 0.5vh 0 0 0;
  padding: 0;
  width: 100%;
}

.xiaoli {
  list-style: none;
  // motion: 1px;
  padding: 0 0 3.5px 3.5px;
  width: 50%;
  display: block;
  float: left;
}

.tijiao {
  // border-top: 1px solid #136d87;
  display: flex;
  margin-top: 1vh;
  // justify-content: space-around;
  justify-content: flex-end;
  align-items: center;
  // height: 10vh;
  // border: 1px solid red;
  // height: 9vh;
  button {
    margin-right: 1vw;
    // color: #b33939;
  }

  :last-child {
    margin-right: 0;
  }
}

::v-deep .btn2 {
  background-color: rgba(255, 255, 255, 0);
  color: #136d87;
  border: 1px solid #136d87;
  width: 8vw;
  margin: 0;
  margin-left: 0;
  padding: 10px 0;
}

::v-deep #tab-second.el-tabs__item.is-top {
  color: #000;
}

::v-deep #tab-first.el-tabs__item.is-top {
  color: #000;
}

::v-deep .el-tabs__nav-wrap {
  display: flex;
  justify-content: center;
}

::v-deep .el-tabs__nav-wrap::after {
  height: 1px;
  background-color: #136d87;
}

.others {
  box-sizing: border-box;
  padding: 10px;
  width: 100%;
  display: flex;
  align-items: center;

}

.others-inputbox {
  flex-grow: 1;
}

::v-deep .el-tabs__active-ba {
  height: 4px;
}
</style>





























