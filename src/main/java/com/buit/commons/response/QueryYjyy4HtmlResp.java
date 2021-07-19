package com.buit.commons.response;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：QueryYjyy4HtmlResp<br>
 * 类描述：查询诊间医技预病html组装-返回<br>
 * @author 老花生
 */
@ApiModel(value="查询诊间医技预病html组装-返回")
public class QueryYjyy4HtmlResp {

    /**
     * dataList : [{"items":[{"type":"header","id":"t_kyyrc_0","value":"可预约人次"},{"id":"t_kyyrc_1_1","value":0,
     * "type":"data","jklx":"1"},{"id":"t_kyyrc_1_18","value":0,"type":"data","jklx":"1"},{"id":"t_kyyrc_10_6",
     * "value":0,"type":"data","jklx":"10"},{"id":"t_kyyrc_10_12","value":0,"type":"data","jklx":"10"},{"id
     * ":"t_kyyrc_10_13","value":0,"type":"data","jklx":"10"},{"id":"t_kyyrc_2_3","value":0,"type":"data","jklx":"2"}
     * ,{"id":"t_kyyrc_20_7","value":0,"type":"data","jklx":"20"},{"id":"t_kyyrc_20_8","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_kyyrc_20_9","value":0,"type":"data","jklx":"20"},{"id":"t_kyyrc_3_11","value":0,
     * "type":"data","jklx":"3"},{"id":"t_kyyrc_30_17","value":0,"type":"data","jklx":"30"},{"id":"t_kyyrc_4_4",
     * "value":0,"type":"data","jklx":"4"},{"id":"t_kyyrc_5_5","value":0,"type":"data","jklx":"5"},{"id
     * ":"t_kyyrc_5_10","value":0,"type":"data","jklx":"5"},{"id":"t_kyyrc_5_2","value":0,"type":"data","jklx":"5"},{
     * "id":"t_kyyrc_5_14","value":0,"type":"data","jklx":"5"},{"id":"t_kyyrc_5_15","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_kyyrc_7_16","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header",
     * "id":"t_yyyrc_1","value":"已预约人次"},{"id":"t_yyyrc_1_1","value":0,"type":"data","jklx":"1"},{"id":"t_yyyrc_1_18
     * ","value":0,"type":"data","jklx":"1"},{"id":"t_yyyrc_10_6","value":0,"type":"data","jklx":"10"},{"id
     * ":"t_yyyrc_10_12","value":0,"type":"data","jklx":"10"},{"id":"t_yyyrc_10_13","value":0,"type":"data",
     * "jklx":"10"},{"id":"t_yyyrc_2_3","value":0,"type":"data","jklx":"2"},{"id":"t_yyyrc_20_7","value":0,
     * "type":"data","jklx":"20"},{"id":"t_yyyrc_20_8","value":0,"type":"data","jklx":"20"},{"id":"t_yyyrc_20_9",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_yyyrc_3_11","value":0,"type":"data","jklx":"3"},{"id
     * ":"t_yyyrc_30_17","value":0,"type":"data","jklx":"30"},{"id":"t_yyyrc_4_4","value":0,"type":"data","jklx":"4"}
     * ,{"id":"t_yyyrc_5_5","value":0,"type":"data","jklx":"5"},{"id":"t_yyyrc_5_10","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_yyyrc_5_2","value":0,"type":"data","jklx":"5"},{"id":"t_yyyrc_5_14","value":0,
     * "type":"data","jklx":"5"},{"id":"t_yyyrc_5_15","value":0,"type":"data","jklx":"5"},{"id":"t_yyyrc_7_16",
     * "value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_7","value":"06:00-07:00"},{"id
     * ":"t_7_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_7_1_18","click":true,
     * "info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_7_10_6","click":true,"info":"超声1","value":0,
     * "type":"data","jklx":"10"},{"id":"t_7_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{
     * "id":"t_7_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_7_2_3","click":true,
     * "info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_7_20_7","click":true,"info":"内镜1","value":0,
     * "type":"data","jklx":"20"},{"id":"t_7_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{
     * "id":"t_7_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_7_3_11","click":true,
     * "info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_7_30_17","click":true,"info":"胶片","value":0,
     * "type":"data","jklx":"30"},{"id":"t_7_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id
     * ":"t_7_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_7_5_10","click":true,
     * "info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_7_5_2","click":true,"info":"脑电图","value":0,
     * "type":"data","jklx":"5"},{"id":"t_7_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id
     * ":"t_7_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_7_7_16","click":true,
     * "info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_8","value":"07:00-08:00"}
     * ,{"id":"t_8_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_8_1_18","click":true,
     * "info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_8_10_6","click":true,"info":"超声1","value":0,
     * "type":"data","jklx":"10"},{"id":"t_8_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{
     * "id":"t_8_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_8_2_3","click":true,
     * "info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_8_20_7","click":true,"info":"内镜1","value":0,
     * "type":"data","jklx":"20"},{"id":"t_8_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{
     * "id":"t_8_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_8_3_11","click":true,
     * "info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_8_30_17","click":true,"info":"胶片","value":0,
     * "type":"data","jklx":"30"},{"id":"t_8_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id
     * ":"t_8_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_8_5_10","click":true,
     * "info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_8_5_2","click":true,"info":"脑电图","value":0,
     * "type":"data","jklx":"5"},{"id":"t_8_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id
     * ":"t_8_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_8_7_16","click":true,
     * "info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_9","value":"08:00-09:00"}
     * ,{"id":"t_9_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_9_1_18","click":true,
     * "info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_9_10_6","click":true,"info":"超声1","value":0,
     * "type":"data","jklx":"10"},{"id":"t_9_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{
     * "id":"t_9_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_9_2_3","click":true,
     * "info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_9_20_7","click":true,"info":"内镜1","value":0,
     * "type":"data","jklx":"20"},{"id":"t_9_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{
     * "id":"t_9_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_9_3_11","click":true,
     * "info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_9_30_17","click":true,"info":"胶片","value":0,
     * "type":"data","jklx":"30"},{"id":"t_9_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id
     * ":"t_9_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_9_5_10","click":true,
     * "info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_9_5_2","click":true,"info":"脑电图","value":0,
     * "type":"data","jklx":"5"},{"id":"t_9_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id
     * ":"t_9_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_9_7_16","click":true,
     * "info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_10","value":"09:00-10:00"
     * },{"id":"t_10_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_10_1_18",
     * "click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_10_10_6","click":true,"info":"超声1",
     * "value":0,"type":"data","jklx":"10"},{"id":"t_10_10_12","click":true,"info":"超声2","value":0,"type":"data",
     * "jklx":"10"},{"id":"t_10_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_10_2_3
     * ","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_10_20_7","click":true,"info":"内镜1",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_10_20_8","click":true,"info":"内镜2","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_10_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_10_3_11
     * ","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_10_30_17","click":true,"info":"胶片",
     * "value":0,"type":"data","jklx":"30"},{"id":"t_10_4_4","click":true,"info":"钼靶","value":0,"type":"data",
     * "jklx":"4"},{"id":"t_10_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_10_5_10",
     * "click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_10_5_2","click":true,"info":"脑电图",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_10_5_14","click":true,"info":"心电图1","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_10_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_10_7_16
     * ","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_11",
     * "value":"10:00-11:00"},{"id":"t_11_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_11_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_11_10_6","click":true,
     * "info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_11_10_12","click":true,"info":"超声2","value":0,
     * "type":"data","jklx":"10"},{"id":"t_11_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{
     * "id":"t_11_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_11_20_7","click":true,
     * "info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_11_20_8","click":true,"info":"内镜2","value":0,
     * "type":"data","jklx":"20"},{"id":"t_11_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{
     * "id":"t_11_3_11","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_11_30_17",
     * "click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_11_4_4","click":true,"info":"钼靶",
     * "value":0,"type":"data","jklx":"4"},{"id":"t_11_5_5","click":true,"info":"动态心电","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_11_5_10","click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_11_5_2",
     * "click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_11_5_14","click":true,"info":"心电图1",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_11_5_15","click":true,"info":"心电图2","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_11_7_16","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type
     * ":"header","id":"t_12","value":"11:00-11:30"},{"id":"t_12_1_1","click":true,"info":"CT机","value":0,
     * "type":"data","jklx":"1"},{"id":"t_12_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_12_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_12_10_12","click":true,
     * "info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_12_10_13","click":true,"info":"超声3","value":0,
     * "type":"data","jklx":"10"},{"id":"t_12_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{
     * "id":"t_12_20_7","click":true,"info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_12_20_8",
     * "click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_12_20_9","click":true,"info":"内镜3",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_12_3_11","click":true,"info":"X线机","value":0,"type":"data",
     * "jklx":"3"},{"id":"t_12_30_17","click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_12_4_4",
     * "click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_12_5_5","click":true,"info":"动态心电",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_12_5_10","click":true,"info":"肺功能","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_12_5_2","click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_12_5_14",
     * "click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_12_5_15","click":true,"info":"心电图2",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_12_7_16","click":true,"info":"病理","value":0,"type":"data",
     * "jklx":"7"}]},{"items":[{"type":"header","id":"t_14","value":"13:00-14:00"},{"id":"t_14_1_1","click":true,
     * "info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_14_1_18","click":true,"info":"测试","value":0,
     * "type":"data","jklx":"1"},{"id":"t_14_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{
     * "id":"t_14_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_14_10_13",
     * "click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_14_2_3","click":true,"info":"MRI机",
     * "value":0,"type":"data","jklx":"2"},{"id":"t_14_20_7","click":true,"info":"内镜1","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_14_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_14_20_9
     * ","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_14_3_11","click":true,"info":"X线机",
     * "value":0,"type":"data","jklx":"3"},{"id":"t_14_30_17","click":true,"info":"胶片","value":0,"type":"data",
     * "jklx":"30"},{"id":"t_14_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_14_5_5",
     * "click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_14_5_10","click":true,"info":"肺功能",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_14_5_2","click":true,"info":"脑电图","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_14_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_14_5_15
     * ","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_14_7_16","click":true,"info":"病理",
     * "value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_15","value":"14:00-15:00"},{"id
     * ":"t_15_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_15_1_18","click":true,
     * "info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_15_10_6","click":true,"info":"超声1","value":0,
     * "type":"data","jklx":"10"},{"id":"t_15_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{
     * "id":"t_15_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_15_2_3",
     * "click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_15_20_7","click":true,"info":"内镜1",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_15_20_8","click":true,"info":"内镜2","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_15_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_15_3_11
     * ","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_15_30_17","click":true,"info":"胶片",
     * "value":0,"type":"data","jklx":"30"},{"id":"t_15_4_4","click":true,"info":"钼靶","value":0,"type":"data",
     * "jklx":"4"},{"id":"t_15_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_15_5_10",
     * "click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_15_5_2","click":true,"info":"脑电图",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_15_5_14","click":true,"info":"心电图1","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_15_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_15_7_16
     * ","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_16",
     * "value":"15:00-16:00"},{"id":"t_16_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_16_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_16_10_6","click":true,
     * "info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_16_10_12","click":true,"info":"超声2","value":0,
     * "type":"data","jklx":"10"},{"id":"t_16_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{
     * "id":"t_16_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_16_20_7","click":true,
     * "info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_16_20_8","click":true,"info":"内镜2","value":0,
     * "type":"data","jklx":"20"},{"id":"t_16_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{
     * "id":"t_16_3_11","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_16_30_17",
     * "click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_16_4_4","click":true,"info":"钼靶",
     * "value":0,"type":"data","jklx":"4"},{"id":"t_16_5_5","click":true,"info":"动态心电","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_16_5_10","click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_16_5_2",
     * "click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_16_5_14","click":true,"info":"心电图1",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_16_5_15","click":true,"info":"心电图2","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_16_7_16","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type
     * ":"header","id":"t_17","value":"16:00-17:00"},{"id":"t_17_1_1","click":true,"info":"CT机","value":0,
     * "type":"data","jklx":"1"},{"id":"t_17_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_17_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_17_10_12","click":true,
     * "info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_17_10_13","click":true,"info":"超声3","value":0,
     * "type":"data","jklx":"10"},{"id":"t_17_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{
     * "id":"t_17_20_7","click":true,"info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_17_20_8",
     * "click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_17_20_9","click":true,"info":"内镜3",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_17_3_11","click":true,"info":"X线机","value":0,"type":"data",
     * "jklx":"3"},{"id":"t_17_30_17","click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_17_4_4",
     * "click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_17_5_5","click":true,"info":"动态心电",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_17_5_10","click":true,"info":"肺功能","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_17_5_2","click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_17_5_14",
     * "click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_17_5_15","click":true,"info":"心电图2",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_17_7_16","click":true,"info":"病理","value":0,"type":"data",
     * "jklx":"7"}]},{"items":[{"type":"header","id":"t_18","value":"17:00-18:00"},{"id":"t_18_1_1","click":true,
     * "info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_18_1_18","click":true,"info":"测试","value":0,
     * "type":"data","jklx":"1"},{"id":"t_18_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{
     * "id":"t_18_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_18_10_13",
     * "click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_18_2_3","click":true,"info":"MRI机",
     * "value":0,"type":"data","jklx":"2"},{"id":"t_18_20_7","click":true,"info":"内镜1","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_18_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_18_20_9
     * ","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_18_3_11","click":true,"info":"X线机",
     * "value":0,"type":"data","jklx":"3"},{"id":"t_18_30_17","click":true,"info":"胶片","value":0,"type":"data",
     * "jklx":"30"},{"id":"t_18_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_18_5_5",
     * "click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_18_5_10","click":true,"info":"肺功能",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_18_5_2","click":true,"info":"脑电图","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_18_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_18_5_15
     * ","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_18_7_16","click":true,"info":"病理",
     * "value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_19","value":"18:00-19:00"},{"id
     * ":"t_19_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_19_1_18","click":true,
     * "info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_19_10_6","click":true,"info":"超声1","value":0,
     * "type":"data","jklx":"10"},{"id":"t_19_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{
     * "id":"t_19_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_19_2_3",
     * "click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_19_20_7","click":true,"info":"内镜1",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_19_20_8","click":true,"info":"内镜2","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_19_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_19_3_11
     * ","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_19_30_17","click":true,"info":"胶片",
     * "value":0,"type":"data","jklx":"30"},{"id":"t_19_4_4","click":true,"info":"钼靶","value":0,"type":"data",
     * "jklx":"4"},{"id":"t_19_5_5","click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_19_5_10",
     * "click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_19_5_2","click":true,"info":"脑电图",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_19_5_14","click":true,"info":"心电图1","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_19_5_15","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_19_7_16
     * ","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type":"header","id":"t_20",
     * "value":"19:00-20:00"},{"id":"t_20_1_1","click":true,"info":"CT机","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_20_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id":"t_20_10_6","click":true,
     * "info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_20_10_12","click":true,"info":"超声2","value":0,
     * "type":"data","jklx":"10"},{"id":"t_20_10_13","click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{
     * "id":"t_20_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{"id":"t_20_20_7","click":true,
     * "info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_20_20_8","click":true,"info":"内镜2","value":0,
     * "type":"data","jklx":"20"},{"id":"t_20_20_9","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{
     * "id":"t_20_3_11","click":true,"info":"X线机","value":0,"type":"data","jklx":"3"},{"id":"t_20_30_17",
     * "click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_20_4_4","click":true,"info":"钼靶",
     * "value":0,"type":"data","jklx":"4"},{"id":"t_20_5_5","click":true,"info":"动态心电","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_20_5_10","click":true,"info":"肺功能","value":0,"type":"data","jklx":"5"},{"id":"t_20_5_2",
     * "click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_20_5_14","click":true,"info":"心电图1",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_20_5_15","click":true,"info":"心电图2","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_20_7_16","click":true,"info":"病理","value":0,"type":"data","jklx":"7"}]},{"items":[{"type
     * ":"header","id":"t_21","value":"20:00-21:00"},{"id":"t_21_1_1","click":true,"info":"CT机","value":0,
     * "type":"data","jklx":"1"},{"id":"t_21_1_18","click":true,"info":"测试","value":0,"type":"data","jklx":"1"},{"id
     * ":"t_21_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{"id":"t_21_10_12","click":true,
     * "info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_21_10_13","click":true,"info":"超声3","value":0,
     * "type":"data","jklx":"10"},{"id":"t_21_2_3","click":true,"info":"MRI机","value":0,"type":"data","jklx":"2"},{
     * "id":"t_21_20_7","click":true,"info":"内镜1","value":0,"type":"data","jklx":"20"},{"id":"t_21_20_8",
     * "click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_21_20_9","click":true,"info":"内镜3",
     * "value":0,"type":"data","jklx":"20"},{"id":"t_21_3_11","click":true,"info":"X线机","value":0,"type":"data",
     * "jklx":"3"},{"id":"t_21_30_17","click":true,"info":"胶片","value":0,"type":"data","jklx":"30"},{"id":"t_21_4_4",
     * "click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_21_5_5","click":true,"info":"动态心电",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_21_5_10","click":true,"info":"肺功能","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_21_5_2","click":true,"info":"脑电图","value":0,"type":"data","jklx":"5"},{"id":"t_21_5_14",
     * "click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_21_5_15","click":true,"info":"心电图2",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_21_7_16","click":true,"info":"病理","value":0,"type":"data",
     * "jklx":"7"}]},{"items":[{"type":"header","id":"t_22","value":"21:00-22:00"},{"id":"t_22_1_1","click":true,
     * "info":"CT机","value":0,"type":"data","jklx":"1"},{"id":"t_22_1_18","click":true,"info":"测试","value":0,
     * "type":"data","jklx":"1"},{"id":"t_22_10_6","click":true,"info":"超声1","value":0,"type":"data","jklx":"10"},{
     * "id":"t_22_10_12","click":true,"info":"超声2","value":0,"type":"data","jklx":"10"},{"id":"t_22_10_13",
     * "click":true,"info":"超声3","value":0,"type":"data","jklx":"10"},{"id":"t_22_2_3","click":true,"info":"MRI机",
     * "value":0,"type":"data","jklx":"2"},{"id":"t_22_20_7","click":true,"info":"内镜1","value":0,"type":"data",
     * "jklx":"20"},{"id":"t_22_20_8","click":true,"info":"内镜2","value":0,"type":"data","jklx":"20"},{"id":"t_22_20_9
     * ","click":true,"info":"内镜3","value":0,"type":"data","jklx":"20"},{"id":"t_22_3_11","click":true,"info":"X线机",
     * "value":0,"type":"data","jklx":"3"},{"id":"t_22_30_17","click":true,"info":"胶片","value":0,"type":"data",
     * "jklx":"30"},{"id":"t_22_4_4","click":true,"info":"钼靶","value":0,"type":"data","jklx":"4"},{"id":"t_22_5_5",
     * "click":true,"info":"动态心电","value":0,"type":"data","jklx":"5"},{"id":"t_22_5_10","click":true,"info":"肺功能",
     * "value":0,"type":"data","jklx":"5"},{"id":"t_22_5_2","click":true,"info":"脑电图","value":0,"type":"data",
     * "jklx":"5"},{"id":"t_22_5_14","click":true,"info":"心电图1","value":0,"type":"data","jklx":"5"},{"id":"t_22_5_15
     * ","click":true,"info":"心电图2","value":0,"type":"data","jklx":"5"},{"id":"t_22_7_16","click":true,"info":"病理",
     * "value":0,"type":"data","jklx":"7"}]}]
     * HeaderChild : {"type":"header","items":[{"id":"1_1","value":"CT机","jklx":"1"},{"id":"1_18","value":"测试",
     * "jklx":"1"},{"id":"10_6","value":"超声1","jklx":"10"},{"id":"10_12","value":"超声2","jklx":"10"},{"id":"10_13",
     * "value":"超声3","jklx":"10"},{"id":"2_3","value":"MRI机","jklx":"2"},{"id":"20_7","value":"内镜1","jklx":"20"},{"id
     * ":"20_8","value":"内镜2","jklx":"20"},{"id":"20_9","value":"内镜3","jklx":"20"},{"id":"3_11","value":"X线机",
     * "jklx":"3"},{"id":"30_17","value":"胶片","jklx":"30"},{"id":"4_4","value":"钼靶","jklx":"4"},{"id":"5_5",
     * "value":"动态心电","jklx":"5"},{"id":"5_10","value":"肺功能","jklx":"5"},{"id":"5_2","value":"脑电图","jklx":"5"},{"id
     * ":"5_14","value":"心电图1","jklx":"5"},{"id":"5_15","value":"心电图2","jklx":"5"},{"id":"7_16","value":"病理",
     * "jklx":"7"}]}
     * body : null
     * Header : {"type":"header","items":[{"value":"","rowspan":2,"width":100},{"id":"1","value":"CT","colspan":2,
     * "jklx":"1"},{"id":"10","value":"超声","colspan":3,"jklx":"10"},{"id":"2","value":"MRI","colspan":1,"jklx":"2"},{
     * "id":"20","value":"内镜","colspan":3,"jklx":"20"},{"id":"3","value":"X线检查","colspan":1,"jklx":"3"},{"id":"30",
     * "value":"","colspan":1,"jklx":"30"},{"id":"4","value":"钼靶","colspan":1,"jklx":"4"},{"id":"5","value":"动态心电",
     * "colspan":5,"jklx":"5"},{"id":"7","value":"","colspan":1,"jklx":"7"}]}
     * code : 200
     */

    private HeaderChildBean HeaderChild;
    private Object body;
    private HeaderBean Header;
    private int code;
    private List<DataListBean> dataList;

    public HeaderChildBean getHeaderChild() {
        return HeaderChild;
    }

    public void setHeaderChild(HeaderChildBean headerChild) {
        HeaderChild = headerChild;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public HeaderBean getHeader() {
        return Header;
    }

    public void setHeader(HeaderBean header) {
        Header = header;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class HeaderChildBean {
        /**
         * type : header
         * items : [{"id":"1_1","value":"CT机","jklx":"1"},{"id":"1_18","value":"测试","jklx":"1"},{"id":"10_6",
         * "value":"超声1","jklx":"10"},{"id":"10_12","value":"超声2","jklx":"10"},{"id":"10_13","value":"超声3",
         * "jklx":"10"},{"id":"2_3","value":"MRI机","jklx":"2"},{"id":"20_7","value":"内镜1","jklx":"20"},{"id":"20_8",
         * "value":"内镜2","jklx":"20"},{"id":"20_9","value":"内镜3","jklx":"20"},{"id":"3_11","value":"X线机","jklx":"3"},
         * {"id":"30_17","value":"胶片","jklx":"30"},{"id":"4_4","value":"钼靶","jklx":"4"},{"id":"5_5","value":"动态心电",
         * "jklx":"5"},{"id":"5_10","value":"肺功能","jklx":"5"},{"id":"5_2","value":"脑电图","jklx":"5"},{"id":"5_14",
         * "value":"心电图1","jklx":"5"},{"id":"5_15","value":"心电图2","jklx":"5"},{"id":"7_16","value":"病理","jklx":"7"}]
         */

        private String type;
        private List<ItemsBean> items;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 1_1
             * value : CT机
             * jklx : 1
             */

            private String id;
            private String value;
            private String jklx;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getJklx() {
                return jklx;
            }

            public void setJklx(String jklx) {
                this.jklx = jklx;
            }
        }
    }

    public static class HeaderBean {
        /**
         * type : header
         * items : [{"value":"","rowspan":2,"width":100},{"id":"1","value":"CT","colspan":2,"jklx":"1"},{"id":"10",
         * "value":"超声","colspan":3,"jklx":"10"},{"id":"2","value":"MRI","colspan":1,"jklx":"2"},{"id":"20",
         * "value":"内镜","colspan":3,"jklx":"20"},{"id":"3","value":"X线检查","colspan":1,"jklx":"3"},{"id":"30","value":"","colspan":1,"jklx":"30"},{"id":"4","value":"钼靶","colspan":1,"jklx":"4"},{"id":"5","value":"动态心电","colspan":5,"jklx":"5"},{"id":"7","value":"","colspan":1,"jklx":"7"}]
         */

        private String type;
        private List<ItemsBeanX> items;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ItemsBeanX> getItems() {
            return items;
        }

        public void setItems(List<ItemsBeanX> items) {
            this.items = items;
        }

        public static class ItemsBeanX {
            /**
             * value :
             * rowspan : 2
             * width : 100
             * id : 1
             * colspan : 2
             * jklx : 1
             */

            private String value;
            private int rowspan;
            private int width;
            private String id;
            private int colspan;
            private String jklx;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getRowspan() {
                return rowspan;
            }

            public void setRowspan(int rowspan) {
                this.rowspan = rowspan;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getColspan() {
                return colspan;
            }

            public void setColspan(int colspan) {
                this.colspan = colspan;
            }

            public String getJklx() {
                return jklx;
            }

            public void setJklx(String jklx) {
                this.jklx = jklx;
            }
        }
    }

    public static class DataListBean {
        private List<ItemsBeanXX> items;

        public static class ItemsBeanXX {
            /**
             * type : header
             * id : t_kyyrc_0
             * value : 可预约人次
             * jklx : 1
             */

            private String type;
            private String id;
            private String value;
            private String jklx;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getJklx() {
                return jklx;
            }

            public void setJklx(String jklx) {
                this.jklx = jklx;
            }
        }
    }
}
