/**
 * @(#)EHREntryNames.java Created on 2010-6-1 下午04:43:02
 *
 * 版权：版权所有 bsoft.com.cn 保留所有权力。
 */
package com.buit.utill;

import java.util.HashMap;
import java.util.Map;

/**
 * @description PHIS 系统参数配置集合
 *
 * @author <a href="mailto:liyl@bsoft.com.cn">liyl</a>
 */
public interface BUHISSystemArgument {

	public static final String BXBZ_FYXH = "BXBZ_FYXH"; // 医保报销标志对应费用序号
	public static final String VIPBRXZ = "VIPBRXZ";//控制发票上显示的金额，是否是乘以支付比例得出的结果
	public static final String CFXQ = "CFXQ";
	public static final String CFJEJJX = "CFJEJJX";//处方总金额界限

	public static final String XQJSFS = "XQJSFS";
	public static final String CKSX_KCSL_ORDER_YF = "CKSX_KCSL_ORDER_YF";
	public static final String CKSX_YPXQ_ORDER_YF = "CKSX_YPXQ_ORDER_YF";
	public static final String CKSX_YPXQ_YF = "CKSX_YPXQ_YF";
	// public static final String CYF = "CYF";
	public static final String GHXQ = "GHXQ";
	public static final String JSYP = "JSYP";
	public static final String MRXZ = "MRXZ";
	public static final String MZYP = "MZYP";
	public static final String PLJC = "PLJC";
	public static final String PLJC_ZY = "PLJC_ZY";
	public static final String PLJC_CY = "PLJC_CY";
	// public static final String QYDDDL = "QYDDDL";
	// public static final String XYF = "XYF";
	public static final String YJSJ_YF = "YJSJ_YF";
	public static final String YS_MZ_FYYF_CY = "YS_MZ_FYYF_CY";
	public static final String YS_MZ_FYYF_XY = "YS_MZ_FYYF_XY";
	public static final String YS_MZ_FYYF_ZY = "YS_MZ_FYYF_ZY";
	public static final String YXWGHBRJZ = "YXWGHBRJZ";
	public static final String YYJGTS = "YYJGTS";
	public static final String ZDCSMZH = "ZDCSMZH";
	public static final String ZDCSJZH = "ZDCSJZH";
	public static final String ZDJZHXNGH = "ZDJZHXNGH";
	public static final String ZDMZHXNGH = "ZDMZHXNGH";
	public static final String ZXKZJG = "ZXKZJG";
	// public static final String ZXSYKCYP = "ZXSYKCYP";
	// public static final String ZYF = "ZYF";
	public static final String FHYZHJF = "FHYZHJF";
	public static final String MTSQYCGHF = "MTSQYCGHF";

	public static final String CKSX_KCSL_YF = "CKSX_KCSL_YF";
	// public static final String WGHMS = "WGHMS";
	public static final String GHF = "GHF";
	public static final String YBZLF = "YBZLF";
	public static final String ZJF = "ZJF";
	public static final String ZLF = "ZLF";
	public static final String BLF = "BLF";
	public static final String DQGHRQ = "DQGHRQ";
	public static final String DQZBLB = "DQZBLB";
	public static final String YSZJS = "YSZJS";
	public static final String MPI = "MPI";
	public static final String SFQYGWXT = "SFQYGWXT";
	public static final String SFQYXNJC = "SFQYXNJC";//是否启用社区心脑监测 1:启用,0:不启用。
	public static final String GWWEBSERVICE_ADDRESS = "GWWEBSERVICE_ADDRESS";
	public static final String JCF = "JCF";
	public static final String FP_ZLF = "FP_ZLF";
	// public static final String YB_ZH_BRXZLIST = "YB_ZH_BRXZLIST";//
	// 珠海医保用于性质用于控制开放哪些报销
	// public static final String YB_ZH_SFQY = "YB_ZH_SFQY";// 珠海社保是否启用(私有参数)
	public static final String YJSJ_YK = "YJSJ_YK";// 药库月结日
	public static final String ZYHM = "ZYHM";// 住院号码
	public static final String BAHM = "BAHM";// 病案号码
	public static final String YZLR_BZLX = "YZLR_BZLX";
	public static final String BQCHXSWS = "BQCHXSWS";
	public static final String XSFJJJ_YS = "XSFJJJ_YS";
	public static final String XSFJJJ_HS = "XSFJJJ_HS";
	public static final String XSFJJJ = "XSFJJJ";
	public static final String ZYYSQY = "ZYYSQY";
	// public static final String REPORT_COUNTDATE_MZ = "REPORT_COUNTDATE_MZ";
	public static final String YPKL_YK = "YPKL_YK";// 药库财务验收药品扣率

	public static final String KCPD_PC = "KCPD_PC";// 药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点
	public static final String WPJFBZ = "WPJFBZ";// '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
	public static final String MZWPJFBZ = "MZWPJFBZ";// '物品计费标志'，'0'表示不启用，‘1’表示启用，默认是‘0’
	public static final String WZSFXMJG = "WZSFXMJG";// '门诊物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
	public static final String WZSFXMJGZY = "WZSFXMJGZY";// '住院物资收费项目价格'，'0'表示不启用，‘1’表示启用，默认是‘0’
	public static final String SFZJFY = "SFZJFY";// 收费直接发药
	public static final String BASYKSMRZ = "BASYKSMRZ";
	public static final String SX_PREALARM = "SX_PREALARM";// 药品过期预警 截止日期参数
	public static final String SHIYB = "SHIYB";// 市医保病人性质
	public static final String SHENGYB = "SHENGYB";// 省医保病人性质
	public static final String YHYB = "YHYB";// 余杭医保病人性质
	public static final String SYB_YYDJ = "SYB_YYDJ";// 市医保医院等级
	public static final String SYB_ZFYP = "SYB_ZFYP";// 市医保自费药品
	public static final String SYB_KBZY = "SYB_KBZY";// 市医保可使用的中草药
	public static final String GHFXM = "GHFXM";// 挂号费对应医疗明细项目编号
	public static final String ZJFXM = "ZJFXM";// 专家费对应医疗明细项目编号
	public static final String ZLFXM = "ZLFXM";// 诊疗费对应医疗明细项目编号
	public static final String BLFXM = "BLFXM";// 病历费对应医疗明细项目编号
	// EMR params
	public static final String QNYDK = "QNYDK";
	public static final String YXXJYSXG = "YXXJYSXG";
	public static final String QZWZXJY = "QZWZXJY";
	public static final String DYQWZXJY = "DYQWZXJY";
	public static final String QMYZXJY = "QMYZXJY";
	public static final String EMRVERSION = "EMRVERSION";
	public static final String SFJYWBKB = "SFJYWBKB";
	// 医技取消窗口前置条件1:门诊医技,2:住院医技,3:同时使用 默认使用3 其余1和2未进行配置
	public static final String BMSZ = "BMSZ";
	public static final String QYMZSF = "QYMZSF";
	public static final String BAHMDYZYHM = "BAHMDYZYHM";
	public static final String BAHMCXFP = "BAHMCXFP";
	public static final String YJZXQXZD = "YJZXQXZD";
	public static final String GHKSSFPB = "GHKSSFPB";
	public static final String ZXSSFDJ = "ZXSSFDJ";
	public static final String ZYQFKZ = "ZYQFKZ";
	public static final String ZYQFTXYZ = "ZYQFTXYZ";
	public static final String JCQFKZ = "JCQFKZ";
	public static final String CWFXH = "CWFXH";
	public static final String ZFCWF = "ZFCWF";
	public static final String ZLFXH = "ZLFXH";
	public static final String ICUXH = "ICUXH";
	public static final String ZLFYDJ = "ZLFYDJ";
	// public static final String QYMZPD = "QYMZPD";
	public static final String QYFYCK = "QYFYCK";
	public static final String QYDZBL = "QYDZBL";
	public static final String YBSJSJUJG = "YBSJSJUJG"; // 医保对照复制 源机构

	public static final String BSDYRJBZ = "BSDYRJBZ";// 博思打印软件标志

	// 门诊发药自动刷新秒数
	public static final String MZFYZDSXMS = "MZFYZDSXMS";
	public static final String QYJYBZ = "QYJYBZ";
	public static final String QYTJBGBZ = "QYTJBGBZ";
	public static final String CARDORMZHM = "CARDORMZHM";
	public static final String HQFYYF = "HQFYYF";
	public static final String QYNLXZ = "QYNLXZ";// 建档年龄限制

	public static final String BZLBFFHJGH = "BZLBFFHJGH";// 边诊疗边付费划价工号
	// public static final String XNFPXL = "XNFPXL"; // 虚拟发票序列
	public static final String YZLRFHTYGH = "YZLRFHTYGH";// 医嘱录入可为同一工号
	public static final String MPI_ADDRESS = "MPI_ADDRESS";
	public static final String MPI_WORKPALCE = "MPI_WORKPALCE";
	public static final String MPI_WORKCODE = "MPI_WORKCODE";
	public static final String MPI_TELE = "MPI_TELE";
	public static final String YMJDYSGH = "YMJDYSGH";

	// public static final String SYBCYXE = "SYBCYXE";
	// public static final String SYBGDBZCYXE = "SYBGDBZCYXE";
	public static final String CFXYZYMXSL = "CFXYZYMXSL";
	public static final String CFCYMXSL = "CFCYMXSL";
	public static final String QYCFCZQZTJ = "QYCFCZQZTJ";// 录入处方处置前置条件是否启用，如果启用，则未录入诊断不允许录入处方处置，1表示启用，0表示不启用
	public static final String YKACCOUNTPRICE = "YKACCOUNTPRICE";// 药库记账价格标准：1，零售价格；2，进货价格；3，批发价格
	public static final String JIANYANSERVERIP = "JIANYANSERVERIP";// 检验服务IP地址
	public static final String TIJIANSERVERIP = "TIJIANSERVERIP";// 体检服务IP地址
	public static final String CWFZDLJ = "CWFZDLJ";// 床位费自动累加

	public static final String YHYBSERVERIP = "YHYBSERVERIP";// 余杭医保服务器地址
	public static final String YHYBSERVERPORT = "YHYBSERVERPORT";// 余杭医保服务器端口
	public static final String YHYBSERVERSERVLET = "YHYBSERVERSERVLET";// 余杭医保服务SERVLET
	public static final String QYSXZZ = "QYSXZZ"; // 启用门诊转诊 检查申请 住院上转
	public static final String ZDZDTJ = "ZDZDTJ";// 中心调价站点是否自动调价
	public static final String MZDCFJE = "MZDCFJE";// 门诊大处方金额
	public static final String ETLRQLX = "ETLRQLX";// ETL日期类型(收费日期(SFRQ)、结帐日期(JZRQ)和汇总日期(HZRQ))
	public static final String ETLBEGINDATE = "ETLBEGINDATE";// ETL时间段采集数据 开始日期
	public static final String ETLENDDATE = "ETLENDDATE";// ETL时间段采集数据 结束日期
	public static final String MZKCDJSJ = "MZKCDJSJ";// 门诊库存冻结时间 1是开单,2是收费
	public static final String SFQYYFYFY = "SFQYYFYFY";// 是否启用药房预发药,0是不启用,1启用
	public static final String KCDJTS = "KCDJTS";// 库存冻结天数,单位是天
	public static final String JCKCDJTS = "JCKCDJTS";// 基础库存冻结天数,单位是天 若启用了预发药则需要配置此值
	// public static final String TJRQLX = "TJRQLX";//
	// 住院性质费用汇总报表/出院病人汇总表的统计日期类型(收费日期(SFRQ)、结帐日期(JZRQ)和汇总日期(HZRQ))
	public static final String FPYL = "FPYL";// 发票预览
	public static final String GHDYJMC = "GHDYJMC";// 挂号打印机名称
	public static final String MZHJSFDYJMC = "MZHJSFDYJMC";// 门诊划价收费打印机名称
	public static final String ZYJKDYJMC = "ZYJKDYJMC";// 住院缴款打印机名称
	public static final String ZYJSDYJMC = "ZYJSDYJMC";// 住院结算打印机名称
	public static final String JCJSDYJMC = "JCJSDYJMC";// 家床结算打印机名称
	public static final String YZTDMYTS = "YZTDMYTS";// 医嘱套打每页条数
	public static final String YZBDYSFTD = "YZBDYSFTD";// 医嘱本打印是否需要套打
	public static final String YZBDYSJ = "YZBDYSJ";// 打印时间,1是提交后打印,2是复核后打印
	public static final String ZKCZHHYDY = "ZKCZHHYDY";// 转科重整后换页打印,0是否,1是是
	// 抗菌药物
	public static final String QYKJYWGL = "QYKJYWGL";
	public static final String QYKJYYY = "QYKJYYY";
	public static final String QYSJYSSQ = "QYSJYSSQ";
	public static final String QYZYKJYWSP = "QYZYKJYWSP";
	public static final String KJYSYTS = "KJYSYTS";
	public static final String QYMZDZBL = "QYMZDZBL";// 启用门诊电子病历
	// 业务锁,单用户登录
	public static final String XZYHDL = "XZYHDL";// 限制用户登录
	public static final String QYYWS = "QYYWS";// 启用业务锁功能
	public static final String QYXXXT = "QYXXXT";

	// 皮试管理
	public static final String QYPSXT = "QYPSXT";
	public static final String PSXQ = "PSXQ";
	public static final String PSSJ = "PSSJ";
	public static final String PSSXJG = "PSSXJG";
	public static final String PSSFDYXM = "PSSFDYXM";

	public static final String SFSFXZKS = "SFSFXZKS";// 收费是否需要选择科室,0是不需要 1是需要
														// 默认0
	public static final String CFDPCQSL = "CFDPCQSL";// 处方点评抽取数量,默认是100
	public static final String MZFPFDFS = "MZFPFDFS";// 门诊发票分单方式
	public static final String MZFPSFLD = "MZFPSFLD";// 门诊发票是否连打
	public static final String MZFPMXSL = "MZFPMXSL";// 门诊发票连打明细数量

	// add by gaof
	public static final String SFQYJKJSAN = "SFQYJKJSAN";// 是否启用健康结算按钮
	public static final String KSDM_TJ = "KSDM_TJ";// 健康证
	public static final String JCEDTS = "JCEDTS";// 家床额定天数
	public static final String JCJKJEZD = "JCJKJEZD";// 家床缴款金额只读
	public static final String JCJKDYJMC = "JCJKDYJMC";// 住院缴款打印机名称
	// add by shiwy
	public static final String ZYFPSFZCGY = "ZYFPSFZCGY";// 住院发票是否支持公有
	public static final String JKSJSFZCGY = "JKSJSFZCGY";// 缴款收据是否支持公有
	public static final String JCFPSFZCGY = "JCFPSFZCGY";// 家床发票是否支持公有
	public static final String JCJKSJSFZCGY = "JCJKSJSFZCGY";// 家床缴款收据是否支持公有
	public static final String QYJCGL = "QYJCGL";// 启用家床管理
	public static final String JCBH = "JCBH";// 家床编号
	public static final String JCH = "JCH";// 家床号
	public static final String JCKCGL = "JCKCGL";// 家床库存管理,1不进行库存管理,2提交并直接发药,3提交到药房发药
	public static final String KLX = "KLX";// 卡类型

	public static final String JCZZLJTS = "JCZZLJTS";// 家床终止临近天数
	public static final String SJDOREHY = "SJDOREHY";// 时间段或号源

	// 药品入出库确认模式
	public static final String YPCRKMS = "YPCRKMS";// 是否弹窗看明细
	// 合理用药
	public static final String SFQYHLYY = "SFQYHLYY";// 是否启用合理用药
	public static final String HLYYIP = "HLYYIP";// 合理用药IP
	//危机值
	public static final String SFQYWJZTX = "SFQYWJZTX";// 是否启用危机值提醒
	public static final String WJZCLSX = "WJZCLSX";//危急值处理时限
	public static final String WJZCSSX = "WJZCSSX";//危急值超时时限
	public static final String WJZTXJGSJ = "WJZTXJGSJ";//危急值提醒间隔时间
	//医嘱不同途径对应不同药房(古美需求)
	public static final String YZTJDYYF = "YZTJDYYF";//医嘱不同途径对应不同药房
	public static final String MZSFHJYF = "MZSFHJYF";//门诊收费划价药房(选择该药房发药窗口用)
	public static final String SFYXFYJZTSYFY = "SFYXFYJZTSYFY";//是否允许费用记账退所有费用
	//系统参数预约时间点的第B分钟有效
	public static final String YYGHSXB = "YYGHSXB";
	//妇科科室
	public static final String FKKS = "FKKS";//妇科科室
	//医保性质代码
	public static final String YBXZ = "YBXZ";//医保性质代码
	//POS门店号
	public static final String POSMDH = "POSMDH";//POS机门店号

	public static final String CDMZKS="CDMZKS";//肠道门诊对应挂号科室代码

	public static final String ZDXZS="ZDXZS";//诊断限制数，最多一次可以开几条诊断

	public static final String CFXZS="CFXZS";//处方限制数，最多一次可以开几条处方

	public static final String CDMZKFSJD="CDMZKFSJD";//肠道门诊开放时间段

	public static final String ZYSYGYTJ="ZYSYGYTJ";//住院输液给药途径

	public static final String ZYKS="ZYKS";//中医科室代码

	public static final String ZDJSSL="ZDJSSL";//自动计算数量

	public static final String TJKS="TJKS";//体检科室代码
	public static final String YFS="YFS";//牙防所代码

	public static final String QYZDFYJ = "QYZDFYJ"; // 启用自动发药机接口

	public static final String JCSMFWXM = "JCSMFWXM"; // 家床上门服务项目

	public static final String ZDTJ = "ZDTJ"; //是否启用自动调价,1是自动调,0是不启用 默认0

	public static final String SFQYPDYPFP = "SFQYPDYPFP"; //是否启用盘点药品分配,1是启用,0是不启用 默认是1

	public static final String PDXHLY = "PDXHLY"; //排队序号来源，1：老系统，0：新系统

	public static final String CFTD = "CFTD"; //处方打印，1：套打，0：白纸打
	public static final String CFQX= "CFQX"; //是否启用门诊同科室上级可以修改下级处方权限，1：启用，0：不启用，默认是0
	public static final String SFZDHG = "SFZDHG"; //收费自动回滚，1：是，0：否

	public static final String SFQYYYGH = "SFQYYYGH"; //是否启用预约挂号，1：是，0：否



	public static final String BJQXH = "BJQXH"; // 报价器型号  0：无 报价器     1：古美默认型号(良标)，2：吴径新型号（上海宇驰Q9），3：通导

	public static final String ZGURL = "ZGURL"; //综管平台URL

	public static final String SFQYMHYL1 = "SFQYMHYL1";// (门诊)是否启用闵行医疗救助(0否,1是)
	public static final String SFQYMHYL5 = "SFQYMHYL5";// (住院)是否启用闵行医疗救助(0否,1是)
	public static final String SFQYWXHLYY = "SFQYWXHLYY";// 是否启用万序合理用药(0停用,1门诊,2住院,3启用门诊与住院)
	public static final String SFQYYBZNTX = "SFQYYBZNTX"; //是否启用医保智能提醒 参数控制，值为1才启用，默认0

	public static final String MZXPLX = "MZXPLX"; 		//门诊小屏类型  0没有,1吴泾,2龙柏
	public static final String JDKDYYPYF = "JDKDYYPYF"; //静滴卡打印药品用法(增加 ： 3 静滴   11 静推  12 雾吸   26 膀胱冲洗)

	public static final String SFDCPQSL = "SFDCPQSL"; //是否带出盘前数量(0否,1是)
	public static final String SFQYCYXT = "SFQYCYXT"; //是否启用草药系统(0否,1是 ,默认1)
	public static final String SFQYZYSY = "SFQYZYSY"; //是否启用住院输液(0否,1是 ,默认1)

	public static final String FFDDYYFLB = "FFDDYYFLB"; //服法单打印药房列表(值是逗号分割的药房ID列表)
	public static final String SFQYCYDJSF = "SFQYCYDJSF"; //是否启用草药代煎收费，1：是，0：否

	public static final String CYFYDYCF = "CYFYDYCF"; //且药品类型为草药，打印一张与医生处相同的处方单，1：是，0：否
	public static final String CYCFDYDJ = "CYCFDYDJ"; //且药品类型为草药，右上角打印‘煎’，1：是，0：否

	public static final String LXCSSFBT = "LXCSSFBT"; //龙柏需求，如病人性质为离休，则离休证号必填，0：否，1：是

	public static final String JCQYSFKTJ = "JCQYSFKTJ"; //龙柏需求，如家床开药库存为0，则不允许提交，0：不启用，1：启用
	public static final String JCDYFFD = "JCDYFFD"; //龙柏需求，家床发药打印服法单，0：不启用，1：启用

	public static final String GGXXXZYBYP = "GGXXXZYBYP"; //公共信息新增医保药品,默认0（关）
	public static final String PDFYKZ = "PDFYKZ"; //盘点发药控制，默认0， 1是,0否

	public static final String SFQYJCBHZZ = "SFQYJCBHZZ"; //是否启用家床编号自增，0：否，1：是
	public static final String SFQYZYHMZZ = "SFQYZYHMZZ"; //是否启用住院号码自增，0：否，1：是
	public static final String SFTZCYSFCW = "SFTZCYSFCW"; //是否通知出院释放床位，0：否，1：是
	public static final String SFQYYFFYJH = "SFQYYFFYJH"; //龙柏需求，是否启用药房发药叫号，0：否，1：是
	public static final String SFCPSKZ = "SFCPSKZ"; //龙柏需求，收费处皮试控制，0：否，1：是

	public static final String ZDFYJWSURL = "ZDFYJWSURL"; //自动发药机webservice地址
	public static final String SFBXFPCW = "SFBXFPCW"; //是否必须分配床位
	public static final String SFQYGPHLD = "SFQYGPHLD"; //是否启用GP护理单
	public static final String ZSDYPYFSY = "ZSDYPYFSY"; //注射单药品用法输液(多个用","分隔)
	public static final String ZSDYPYFJD = "ZSDYPYFJD"; //注射单药品用法静滴
	public static final String ZSDYJJMSY = "ZSDYJJMSY"; //注射单医技静脉输液(费用序号)
	public static final String ZSDYJSFSY = "ZSDYJSFSY"; //注射单医技收费输液(费用序号,多个用","分隔)

	public static final String EKKSDM = "EKKSDM"; //儿科科室代码(儿保处方笺)
	public static final String EKCFDYBZ = "EKCFDYBZ"; //儿科处方打印标志
	public static final String SFPSZDFF = "SFPSZDFF"; //是否皮试自动付费(0否，1是)
	public static final String ZCYSLXZ = "ZCYSLXZ"; 	//中成药数量限制(单张处方),0不限制
	public static final String LSYZMRPC = "LSYZMRPC"; 	//临时医嘱默认频次
	public static final String YPCKDDYPB = "YPCKDDYPB"; 	//药品出库单
	public static final String YSYFSB = "YSYFSB"; 	//延生药房识别
	public static final String JMBRXZ = "JMBRXZ"; 	//计免病人性质
	public static final String BRXZ_SYBX = "BRXZ_SYBX";//病人性质_商业保险
	public static final String ZDDYSYD = "ZDDYSYD"; 	//自动打印输液单
	public static final String GMSYD = "GMSYD"; 	//古美输液单

	public static final String ZYYPJKUSER = "ZYYPJKUSER"; 	//中药饮片接口用户名（市药事系统注册用户的用户名）
	public static final String ZYYPJKPWD = "ZYYPJKPWD"; 	//中药饮片接口密码（市药事系统注册用户的密码）
	public static final String ZYYPJKBBH = "ZYYPJKBBH"; 	//中药饮片接口版本号
	public static final String ZYYPJKYQBM = "ZYYPJKYQBM"; 	//中药饮片接口药企编码(市药事系统对药企的统编代码)
	public static final String ZYYPJKWSDL = "ZYYPJKWSDL"; 	//中药饮片接口地址
	public static final String SFQYZYYPJK = "SFQYZYYPJK"; 	//是否启用中药饮片接口(0否，1是)

	public static final String PDJHYXNL = "PDJHYXNL"; 	//排队叫号老人优先年龄
	public static final String PDJHYXXZ = "PDJHYXXZ"; 	//排队叫号老人优先病人优先性质(多个","号分隔)
	public static final String PDJHJHJG = "PDJHJHJG"; 	//排队叫号间隔时间(默认20分)
	public static final String SQJHMS = "SQJHMS"; 		//社区叫号模式
	public static final String SQJHSJ = "SQJHSJ"; 		//社区叫号模式启用时间(hh:mm:ss)
	public static final String SQJHBHZKS = "SQJHBHZKS"; //社区叫号不候诊科室(以","分隔)
	public static final String SQJHYCSJ = "SQJHYCSJ"; 	//社区叫号延迟时间（分钟）

	public static final String SQJGBM = "SQJGBM"; 		//社区机构编码
	public static final String SQXTMS = "SQXTMS"; 		//社区系统模式(LB龙柏,GM古美,WJ吴泾,默认GM);

	public static final String TWDCS = "TWDCS";
	public static final String YFCWYBCS = "YFCWYBCS";
	public static final String MZBKBRXZ = "MZBKBRXZ";//民政帮困病人性质
	public static final String LXBRXZ = "LXBRXZ";//离休病人性质
	public static final String JHSYXZ = "JHSYXZ";//计划生育性质
	public static final String JHSYJMBL = "JHSYJMBL";//计划生育减免比例

	public static final String BQYPYLSJ = "BQYPYLSJ";// 病区药品预领时间 1:领药日期第二天00:00:00  2:领药日期第二天08:30:00,默认1

	public static final String ZFBPZWJM = "ZFBPZWJM";// 支付宝文件名
	public static final String SFTB40 = "SFTB40";// 是否同步40库(1是,0否)
	public static final String SFTBBSRUN = "SFTBBSRUN";// 是否同步Bsrun库(1是,0否)

	public static final String GP02 = "GP02";// 签约
	public static final String GP03 = "GP03";// 转诊
	public static final String GP04 = "GP04";// 处方延伸
	public static final String GPURL = "GPURL";//GP接口地址
	public static final String GP06 = "GP06";// EHR
	public static final String GP07 = "GP07";//nfc发卡
	public static final String GPENABLED = "GPENABLED";// 是否启用GP
	public static final String GPHOMEPAGE = "GPHOMEPAGE";// GP首页地址
	public static final String YSCFCX = "YSCFCX";// 延伸处方查询 0 通用 1古美
	public static final String YPDBBZKZ = "YPDBBZKZ";// 药品调拨包装控制 0 通用 1古美
	public static final String CCFHZCX = "CCFHZCX";// 长处方汇总查询 0 通用 1古美
	public static final String YPDR = "YPDR";// 药品调入药库限制 0 通用 1古美
	public static final String BLTZGL = "BLTZGL";// 病历录入时年龄小于18必须录入体重 0 通用 1古美
	public static final String FYJJNSL = "FYJJNSL";// 发药机机内数量参数 0 关闭 1开启
	public static final String ZYTZBSFYXH = "ZYTZBSFYXH";// 中医体质辨识
	public static final String LCJHZCS = "LCJHZCS";// 零差价汇总，默认数值0.05，即百分之五
	public static final String LBMZBL = "LBMZBL";// 龙柏门诊病历参数 默认值0
	public static final String YBBBFZR = "YBBBFZR";// 医保报表负责人
	public static final String YLHZBKBBLXDH = "YLHZBKBBLXDH";// 医疗互助帮困报表联系电话
	public static final String YLHZBKBBYHZH = "YLHZBKBBYHZH";// 医疗互助帮困报表银行账户
	public static final String YLHZBKBBYHMC = "YLHZBKBBYHMC";// 医疗互助帮困报表银行名称
	public static final String LBYLHZBK = "LBYLHZBK";// 龙柏医疗互助帮困参数 默认值0
	public static final String QZJIPDZ = "QZJIPDZ";// 前置机IP地址
	public static final String YBBBBH = "YBBBBH";// 医保报表编号
	public static final String LNHL_JCHL = "LNHL_JCHL";//老年护理_基础护理
	public static final String QYJCZDFYJ = "QYJCZDFYJ";//启用家床自助发药


	public static final String DWKKS = "DWKKS";//大外科，取GY_KSDM,多个科室，隔开
	public static final String DNKKS = "DNKKS";//大内科，取GY_KSDM,多个科室，隔开
	public static final String DFKKS = "DFKKS";//大妇科，取GY_KSDM,多个科室，隔开
	public static final String WEBREPORTURL = "WEBREPORTURL";//报表URL
	public static final String YBZFYXZ = "YBZFYXZ";//医保自费药限制 0，关闭开自费药。1开启开自费药
	public static final String YBGJYXZ = "YBGJYXZ";//医保高价药限制 0，关闭开自费药。1开启开自费药
	public static final String YBZFXMXZ = "YBZFXMXZ";//医保自费项目限制 0，关闭开自费药。1开启开自费药

	public static final String JSYPML = "JSYPML";//精神药品、麻醉药品目录


	public static final String GHJMSZ = "GHJMSZ";//是否挂号减免。1:挂号减免，0：挂号不减免

	public static final String LSYZSYPCCS = "LSYZSYPCCS";			//临时医嘱使用频次参数 ：0：默认乘以SYPC。1：不乘以SYPC(如：bid 发药的时候不乘以2)
	public static final String DPYBSDY = "DPYBSDY";  //门诊病史打印代配药 ： 0 关闭 1开启  门诊病史打印显示代配药字样

	public static final String BYQDZXSJ = "BYQDZXSJ";  //摆药QD执行时间(摆药单打印)：默认23:59


	//捷医参数 start
	public static final String fyxsdf = "fyxsdf";         // 费用显示到分  0否，1是
	public static final String JYOPEN = "JYOPEN";			//捷医启用判别

	public static final String XTYSZZ = "XTYSZZ";			//血透医生资质

	public static final String BQYPYLTS = "BQYPYLTS";// 摆药病区药品预领时间 1:领药日期第二天23:59:59  2:领药日期第二天09:30:00, 3:领药日期第二天12:30:00

	public static final String BLZDCDJQ = "BLZDCDJQ";//病案首页中，病理诊断打印时长度截取及换行设置，0.不截取。>0 截取几位，默认0，int类型


	//捷医参数 end

	/*	蓝宙新增参数	*/
	public static final String JAJGID = "JAJGID";			// 蓝宙医院 JGID
	public static final String WZSHQX = "WZSHQX";		//物资审核权限

	public static final String BBJBSJ = "BBJBSJ";		// 白班交班时间
	public static final String XYBJBSJ = "XYBJBSJ";		// 小夜班交班时间
	public static final String DYBJBSJ = "DYBJBSJ";		// 大夜班交班时间

	public static final String JYKSXZ = "JYKSXZ";			//捷医科室限制。自助机不显示该科室

	public static final String SMJFYS = "SMJFYS";			//费用记账手麻计费默认医生
	public static final String SMJFKS = "SMJFKS";			//费用记账手麻计费默认科室

	public static final String EMRBAJG = "EMRBAJG";//emr病案机构
	public static final String EMRBAYYDM = "EMRBAYYDM";//emr病案机构

	/**
	 * 动态参数前缀 key 表示动态参数前缀部分， value表示对应查询的字典
	 */
	public static final Map<String, String> dynamicParamter = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("BQTJTS", "department");
			put("YZTS", "department");
			put("YJSJ_YF", "pharmacy");
			put("YJSJ_YK", "pharmacy");
			put("PYFS_YK", "storehouse");
			put("PKFS_YK", "storehouse");
			put("YF_PCPD", "pharmacy");
			put("KCPD_PC", "pharmacy");
			put("YJSJ_KF", "treasury");
			put("CKWZJSLX", "treasury");
			put("KCPDLX", "treasury");
			put("EJSLKZ", "treasury");

		}
	};

	// 公用默认值
	public static final Map<String, String> defaultPubValue = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{

			put(JCF, "5");
			put(FP_ZLF, "6");
			put(JSYP, "2");
			put(MZYP, "1");
			put(PLJC, "0");
			put(PLJC_ZY, "0");
			put(PLJC_CY, "0");
			put(ZDJZHXNGH, "0");
			put(ZDMZHXNGH, "0");
			put(ZXKZJG, "0");
			put(GHF, "12");
			put(YBZLF, "42");
			put(ZJF, "7");
			put(ZLF, "13");
			put(MPI, "0");
			put(SFQYGWXT, "0");
			put(SFQYXNJC, "0");
			put(GWWEBSERVICE_ADDRESS, "http://127.0.0.1:8080/CHIS");
			// put(YB_ZH_BRXZLIST, "6089,6090,6091,6092,6104");
			put(BASYKSMRZ, "/");
			put(EMRVERSION, "4. 6. 0. 4");
			// put(QYDDDL, "0");
			put(CWFXH, "0");
			put(ZFCWF, "0");
			put(ZLFXH, "0");
			put(ICUXH, "0");
			put(SHIYB, "10");
			put(SHENGYB, "11");
			put(YHYB, "12");
			put(QYDZBL, "1");
			put(GHFXM, "22");
			put(ZJFXM, "22");
			put(ZLFXM, "22");
			put(BLFXM, "22");
			put(JIANYANSERVERIP, "http://localhost:8080/BS_JYTJ");
			put(TIJIANSERVERIP, "http://localhost:8080/CYTJ");
			put("CWFZDLJ", "0");
			// put(YHYBSERVERIP, "10.81.193.2");
			// put(YHYBSERVERPORT, "9001");
			// put(YHYBSERVERSERVLET, "Test_App/ProcessA");
			put(ZDZDTJ, "0");
			put(MZDCFJE, "100");
			put(ETLRQLX, "SFRQ");
			put(ETLBEGINDATE, "1970-01-01");
			put(ETLENDDATE, "1970-01-01");
			put(XZYHDL, "0");// 限制用户登录
			put(KLX, "04");// 卡类型
			put(SFQYHLYY,"0");
			put(HLYYIP,"http://localhost:8080/BS-CKB3.0");
			put(YBXZ,"6021");//医保性质代码
			put(QYXXXT,"0");
			put(JCSMFWXM,"0");
			put(ZDTJ,"0");
			put(GGXXXZYBYP,"0");
			put(PDFYKZ,"0");
			put(LNHL_JCHL,"2024");

			put(GHJMSZ,"0");
			put(fyxsdf,"0");
			put(JYOPEN,"0");
			put(XTYSZZ,"");
			put(BLZDCDJQ,"0");

			put(LSYZSYPCCS,"0");
			put(DPYBSDY,"0");
			put(BYQDZXSJ,"23:59");
			put(JYKSXZ,"0");
			put(SMJFYS,"");
			put(SMJFKS,"");

			put(EMRBAJG,"310112041");
			put(EMRBAYYDM,"310112041");
		}
	};

	// 私有默认值
	public static final Map<String, String> defaultValue = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("BXBZ_FYXH","0");
			put(YSCFCX,"0");
			put(YPDBBZKZ,"0");
			put(YPDR,"0");
			put(CCFHZCX,"0");
			put(BLTZGL,"0");
			put(MRXZ, "30");
			// put(XYF, "2");
			// put(ZYF, "3");
			put(FHYZHJF, "0");
			// put(CYF, "4");
			put(CFXQ, "1");
			put(CFJEJJX, "5000");

			put(CKSX_KCSL_YF, "0");
			put(CKSX_KCSL_ORDER_YF, "A");
			put(CKSX_YPXQ_ORDER_YF, "A");
			put(CKSX_YPXQ_YF, "0");
			put(GHXQ, "1");
			put(YJSJ_YF, "32");
			put(YS_MZ_FYYF_CY, "-1");
			put(YS_MZ_FYYF_XY, "-1");
			put(YS_MZ_FYYF_ZY, "-1");
			put(YXWGHBRJZ, "0");
			put(YYJGTS, "7");
			put(ZDCSMZH, "0");
			put(ZDCSJZH, "1");
			// put(ZXSYKCYP, "0");
			// put(WGHMS, "0");
			put(BLF, "0");
			put(YSZJS, "0");
			// put(YB_ZH_SFQY, "0");
			// put(YJSJ_YK, "32");
			put(ZYHM, "0000000001");
			put(BAHM, "0000000001");
			put(YZLR_BZLX, "1");
			put(BQCHXSWS, "0");
			put(XSFJJJ_YS, "0");
			put(XSFJJJ_HS, "0");
			put(XSFJJJ, "0");
			put(ZYYSQY, "0");
			put(XQJSFS, "1");
			// put(REPORT_COUNTDATE_MZ, "1");
			put(YPKL_YK, "1");
			// put(KCPD_PC, "true");
			put(SFZJFY, "0");
			put("PYFS_YK", "0");
			put("PKFS_YK", "0");
			put("YF_PCPD", "1");
			put("QNYDK", "1");
			put("YXXJYSXG", "0");
			put("QZWZXJY", "0");
			put("DYQWZXJY", "0");
			put("QMYZXJY", "0");
			put("BMSZ", "3");
			put("WPJFBZ", "0");
			put("MZWPJFBZ", "0");
			put("WZSFXMJG", "1");
			put("WZSFXMJGZY", "1");
			put("QYMZSF", "0");
			put("MTSQYCGHF", "1");
			put("BAHMDYZYHM", "0");
			put("BAHMCXFP", "0");
			put("YJZXQXZD", "0");
			put("GHKSSFPB", "1");
			put("SFJYWBKB", "0");
			put("ZXSSFDJ", "1");
			put("ZYQFKZ", "0");
			put("ZYQFTXYZ", "1000");
			put("JCQFKZ", "0");
			put("SX_PREALARM", "3");
			put("ZLFYDJ", "0");
			// put("QYMZPD", "0");
			put("QYFYCK", "0");
			// put("BSDYRJBZ", "0");
			// put("YBSJSJUJG", "");

			put("MZFYZDSXMS", "20");
			put("QYJYBZ", "0");
			put("CARDORMZHM", "2");
			put("HQFYYF", "0");
			put("QYTJBGBZ", "0");
			put("QYNLXZ", "0");
			put("MPI_ADDRESS", "");
			put("MPI_WORKPLACE", "");
			put("MPI_WORKCODE", "");
			put("MPI_TELE", "");
			put("YMJDYSGH", "");
			// put("SYB_YYDJ", "10");
			// put("SYB_ZFYP", "7000000000000001");
			// put("SYB_KBZY", "5000000000000001");
			// put("BZLBFFHJGH", "0");
			// put("XNFPXL", "1");
			put("YZLRFHTYGH", "1");

			// put("SYBCYXE", "30");
			// put("SYBGDBZCYXE", "50");
			put("CFXYZYMXSL", "0");
			put("CFCYMXSL", "20");
			put("QYCFCZQZTJ", "0");
			put("YKACCOUNTPRICE", "1");
			put("QYSXZZ", "0");
			put("MZKCDJSJ", "1");
			put("SFQYYFYFY", "0");
			put("KCDJTS", "1");
			put("JCKCDJTS", "5");
			// put(TJRQLX, "SFRQ");
			put("FPYL", "0");
			put("GHDYJMC", "GHDYJ");// 挂号打印机名称
			put("MZHJSFDYJMC", "MZHJSFDYJ");// 门诊划价收费打印机名称
			put("ZYJKDYJMC", "ZYJKDYJ");// 住院缴款打印机名称
			put("ZYJSDYJMC", "ZYJSDYJ");// 住院结算打印机名称
			put("JCJSDYJMC", "JCJSDYJ");// 家床结算打印机名称
			// 抗菌药物
			put("QYKJYYY", "1");
			put("QYSJYSSQ", "1");
			put("QYKJYWGL", "0");
			put("QYZYKJYWSP", "0");
			put("KJYSYTS", "3");
			put("YZTDMYTS", "20");
			put("YZBDYSFTD", "0");
			put("YZBDYSJ", "1");
			put("ZKCZHHYDY", "1");
			put("QYYWS", "0");
			// 皮试管理
			put("PSXQ", "1");
			put("PSSJ", "20");
			put("PSSXJG", "20");
			put(QYMZDZBL, "0");// 启用门诊电子病历
			put("QYPSXT", "0");
			put("PSSFDYXM", "0");

			put("SFSFXZKS", "0");
			put("CFDPCQSL", "100");
			put(MZFPFDFS, "0");// 门诊发票分单方式
			put(MZFPSFLD, "0");// 门诊发票是否连打
			put(MZFPMXSL, "0");// 门诊发票连打明细数量

			put(SFQYJKJSAN, "0");
			put(KSDM_TJ, "0");// 健康证挂号
			put("ZYFPSFZCGY", "0");// 住院发票是否支持公有
			put("JKSJSFZCGY", "0");// 缴款收据是否支持公有
			put("JCFPSFZCGY", "0");// 家床发票是否支持公有
			put("JCJKSJSFZCGY", "0");// 家床缴款收据是否支持公有
			put(QYJCGL, "0");// 启用家床管理
			put(JCBH, "0000000001");// 家床编号
			put(JCH, "0000000001");// 家床号
			put("EDJCTS", "7");// 额定家床天数
			put("JCKCGL", "1");// 家床库存管理
			put("JCZZLJTS", "7");// 家床终止临近天数
			put("SJDOREHY", "1");// 时间段或者号源
			put("JCJKJEZD", "1");//
			put("JCEDTS", "30");// 家床额定天数
			put("JCJKDYJMC", "JCJKDYJ");// 家床缴款打印机名称
			put(YPCRKMS,"0");//药品出入库时默认弹出明细窗口
			put(SFQYWJZTX,"0");// 是否启用危机值提醒
			put(WJZCLSX,"5");//危急值处理时限
			put(WJZCSSX,"5");//危急值超时时限
			put(WJZTXJGSJ,"30");//危急值提醒间隔时间
			put(YZTJDYYF,"");//医嘱不同途径对应不同药房
			put(MZSFHJYF,"");//门诊收费划价药房(选择该药房发药窗口用)
			put(SFYXFYJZTSYFY,"0");//是否允许费用记账退所有费用
			put(YBXZ,"6021");//医保性质代码
			put(YYGHSXB,"10");//系统参数预约时间点的第B分钟有效
			put(FKKS,"8");//妇科科室代码
			put(POSMDH,"12051");//POS门店号
			put(CDMZKS,"9");//肠道科室代码
			put(ZDXZS,"30");
			put(CFXZS,"50");
			put(CDMZKFSJD,"5,8");
			put(VIPBRXZ,"6025");//VIP病人性质
			put(ZYSYGYTJ,"3,7,10,11,26,33");
			put(ZYKS,"10");
			put(ZDJSSL,"1");
			put(TJKS,"35");
			put(YFS,"0");
			put(QYZDFYJ,"0");
			put(SFQYPDYPFP,"1");
			put(PDXHLY,"0");
			put(CFTD,"1");
			put(CFQX,"0");
			put(SFZDHG,"1");

			//综管平台
			put(ZGURL,"http://10.98.25.9:8810/sqzg/out?token=ddee76431082c9afb2b73d81f159c86f3b590260");
			put(SFQYYYGH,"0");
			put(SFQYMHYL1,"0");
			put(SFQYMHYL5,"0");
			put(SFQYWXHLYY,"0");

			//综管平台
			put(ZGURL,"http://10.98.25.9:8810/sqzg/out?token=ddee76431082c9afb2b73d81f159c86f3b590260");
			put(BJQXH,"1");
			put(MZXPLX,"0");
			put(SFQYYBZNTX,"0");
			put(JDKDYYPYF," ");
			put(SFDCPQSL,"0");
			put(SFQYCYXT,"1");
			put(SFQYZYSY,"1");
			put(FFDDYYFLB,"3,4");
			put(SFQYCYDJSF,"0");

			put(CYFYDYCF,"0");
			put(CYCFDYDJ,"0");

			put(LXCSSFBT,"0");
			put(JCQYSFKTJ,"0");
			put(JCDYFFD,"0");
			put(SFQYJCBHZZ,"1");
			put(SFQYZYHMZZ,"1");
			put(SFTZCYSFCW,"0");

			put(GGXXXZYBYP,"0");
			put(PDFYKZ,"0");

			put(SFQYYFFYJH,"0");
			put(SFCPSKZ,"0");
			put(SFBXFPCW,"1");
			put(SFQYGPHLD,"0");
			put(ZSDYPYFSY,"0");
			put(ZSDYPYFJD,"0");
			put(ZSDYJJMSY,"0");
			put(ZSDYJSFSY,"0");
			put(EKKSDM,"");
			put(EKCFDYBZ,"0");
			put(SFPSZDFF,"1");
			put(ZCYSLXZ,"2");
			put(LSYZMRPC,"st");
			put(YPCKDDYPB,"1");
			put(YSYFSB,"12");
			put(JMBRXZ,"20,24,15,1000");
			put(BRXZ_SYBX,"6024");
			put(ZDDYSYD,"0");
			put(GMSYD,"0");
			put(TWDCS,"1");
			put(YFCWYBCS,"1");
			put(ZDFYJWSURL,"http://10.98.25.10:8000/ConsisWebService/ServiceHis.svc");



			//中药饮片接口参数
			put(ZYYPJKUSER,"gmsq001");
			put(ZYYPJKPWD,"zsgmsq001300");
			put(ZYYPJKBBH,"1.0.0.0");
			put(ZYYPJKYQBM,"LBYD0001");
			put(ZYYPJKWSDL,"http://10.98.24.14/ysxt-ws/service/mainservice?wsdl");
			put(SFQYZYYPJK,"0");

			put(PDJHYXNL,"70");
			put(PDJHYXXZ,"23,19");
			put(SQJHMS,"无");
			put(SQJHSJ,"06:00:00");
			put(PDJHJHJG,"20");
			put(SQJHBHZKS,"");
			put(SQJHYCSJ,"1");
			put(SQJGBM,"0");
			put(SQXTMS,"GM");

			put(ZDFYJWSURL,"http://10.98.25.10:8000/ConsisWebService/ServiceHis.svc");
			put(MZBKBRXZ,"27");
			put(LXBRXZ,"23");
			put(JHSYXZ,"18");
			put(JHSYJMBL,"0");

			put("BQYPYLSJ", "1");
			put("BQYPYLTS", "1");

			put("ZFBPZWJM", "zfbinfo.properties");

			put("SFTB40", "1");
			put("SFTBBSRUN", "1");

			put("GP02", "http://10.96.36.163:8182/fjzl/hplatQy.do");
			put("GP03", "http://10.96.36.163:8182/fjzl/hplatZz.do");
			put("GP04", "http://10.96.36.163:8182/fjzl/hplatCf.do");
			put("GP06", "");
			put("GP07", "");
			put("GPURL", "http://10.98.26.5:28081/gp/BSGPDataSub");
			put("GPENABLED", "0");
			put("GPHOMEPAGE", "http://10.98.0.4:9640/cdccommon/GPZL.html?UTP={2}&UID={0}&URR=1&GID={1}&KID=XXKSKH");
			put("FYJJNSL", "0");
			put("ZYTZBSFYXH", "1312");
			put("LCJHZCS", "0.05");
			put("LBMZBL", "0");
			put("YBBBFZR", "");
			put("YLHZBKBBLXDH", "");
			put("YLHZBKBBYHZH", "");
			put("YLHZBKBBYHMC", "");
			put("LBYLHZBK", "0");
			put("QZJIPDZ", "");
			put("YBBBBH", "");
			put(LNHL_JCHL,"2024");
			put(QYJCZDFYJ,"0");

			put(DWKKS, "");
			put(DNKKS, "");
			put(DFKKS, "");
			put(WEBREPORTURL, "http://192.168.20.43:8080/WebReport/ReportServer?reportlet=");

			put(YBZFYXZ,"0");
			put(YBZFXMXZ,"0");

			put(YBGJYXZ,"0");

			put(JSYPML,"");

			put(GHJMSZ,"0");

			put(fyxsdf,"0");
			put(JYOPEN,"0");
			put(XTYSZZ,"0");
			put(BLZDCDJQ,"0");

			put(LSYZSYPCCS,"0");
			put(DPYBSDY,"0");
			put(BYQDZXSJ,"23:59");

			put(JAJGID, "310112099");
			put(WZSHQX, "9999");
			put(BBJBSJ, "16:20:00");
			put(XYBJBSJ, "01:00:00");
			put(DYBJBSJ, "08:00:00");
			put(JYKSXZ,"0");
			put(SMJFYS,"");
			put(SMJFKS,"");

			put("EMRBAJG","310112041");
			put("EMRBAYYDM","310112041");
		}
	};

	// 备注信息
	public static final Map<String, String> defaultAlias = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			// put(XYF, " 西药归属的收费项目 ");
			// put(ZYF, " 中药归属的收费项目 ");
			put("BXBZ_FYXH","医保报销标志对应费用序号，用逗号隔开");
			put(YSCFCX,"延伸处方查询0通用，1古美需求");
			put(YPDBBZKZ,"药品调拨包装控制0通用，1古美需求");
			put(YPDR,"药品调入药库限制 0通用，1古美需求");
			put(CCFHZCX,"长处方汇总查询0通用，1古美需求");
			put(BLTZGL,"病历书写年龄小于18必须录入体重 0通用，1古美需求");
			put(KSDM_TJ, "健康证默认挂号科室");// 健康证挂号
			put(FHYZHJF, " 复核医嘱后计费 ");
			// put(CYF, " 草药归属的收费项目 ");
			put(CFXQ, " 自动调入处方的有效期0.不限制  以天为单位 ");
			put(CFJEJJX, "处方总金额界限 ");

			put(XQJSFS, "效期计算方式：0：精确到时分，1：截止到23:59:59");
			put(CKSX_KCSL_YF,
					"出库顺序_库存数量1.按库存数量出库0.不按库存数量出库 该参数值是1时，才会根据参数CKSX_KCSL_ORDER_YF的值进行排序，否则不会；并且排序时，先效期再数量");
			put(CKSX_KCSL_ORDER_YF, " 出库顺序_库存大小 A.库存少的先出库（小先出） D.库存多的先出库（大先出） ");
			put(CKSX_YPXQ_ORDER_YF,
					" 出库顺序_效期先后 A.效期早的药品先出库（早先出）D.效期迟的药品先出库（迟先出） ");
			put(CKSX_YPXQ_YF, " 出库顺序_药品效期 1.按效期出库 0.不按效期出库 ");

			put(GHXQ, " 门诊挂号效期：以天为单位 ");
			// put(YJSJ_YK, "药库月结时间 对应一个月的31天  32为月底结 ");
			put(YJSJ_YF, " 月结时间 对应一个月的31天  32为月底结 ");
			put(YS_MZ_FYYF_CY, "草药对应药房，存药房识别");
			put(YS_MZ_FYYF_XY, "西药对应药房，存药房识别");
			put(YS_MZ_FYYF_ZY, "中药对应药房，存药房识别");
			put(YXWGHBRJZ, "无挂号模式 0就是挂号模式，1就是无挂号模式 ");
			put(YYJGTS, " 预约间隔天数：以天为单位 ");
			put(ZDCSMZH, "自动产生门诊号 0.不自动产生1.自动产生");
			put(ZDCSJZH, "自动产生就诊号 0.不自动产生1.自动产生");
			// put(ZXSYKCYP,
			// " 只显示有库存的药品 0: 没有库存的药品也可以在下拉列表中显示 1: 下拉列表中只显示有库存的的药品 ");

			// put(WGHMS, "无挂号模式0.挂号模式1.无挂号模式");
			put(BLF, "病历费的价格");
			put(YSZJS, "医生站结算:0.不允许结算，1.允许结算");
			// put(YB_ZH_SFQY, "社保是否启用:0.不启用，1.启用");
			put(ZYHM, "住院号码");
			put(BAHM, "病案号码");
			put(YZLR_BZLX, "包装类型,1：医嘱录入使用包装类型 2使用药品信息中的病房包装");
			put(BQCHXSWS, "病区床号显示位数，默认为0时显示全部，其余按值从右截取显示");
			put(MRXZ, " 默认性质 ");
			put(XSFJJJ_YS, " 显示医生站附加项目 0:不显示,1:显示 ");
			put(XSFJJJ_HS, " 显示护士站附加项目 0:不显示,1:显示 ");
			put(XSFJJJ, " 显示门诊附加项目 0:不显示,1:显示 ");
			put(ZYYSQY, "住院医生站启用 0.不启用1.启用");
			put(BMSZ, "医技取消窗口前置条件1:门诊医技,2:住院医技,3:同时使用 默认使用3 其余1和2未进行配置");
			// put(REPORT_COUNTDATE_MZ, "报表统计日期 1.按收费日期,默认是1");
			put(YPKL_YK, "药库财务验收药品扣率");
			// put(KCPD_PC, "药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点");
			put(SFZJFY, "收费直接发药:0.不启用，1.启用");
			put("KCPD_PC", "药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点");
			put("YF_PCPD", "药房库存盘点是否按批次盘点,0是不按批次盘点,1是按批次盘点");
			put("PYFS_YK", "药库盘盈方式");
			put("PKFS_YK", "药库盘亏方式");
			put("QNYDK", "病程从当前病程前N份打开");
			put("YXXJYSXG", "允许下级医生修改病历 0:不允许 1:允许");
			put("QZWZXJY", "强制完整性校验 0:不需要 1:需要");
			put("DYQWZXJY", "打印前强制完整性校验 0:不是 1:是");
			put("QMYZXJY", "签名一致性校验 0:不是 1:是");
			put("WPJFBZ", "物品计费标志,0表示不启用，1表示启用，默认是0");
			put("MZWPJFBZ", "门诊物品计费标志,0表示不启用，1表示启用，默认是0");
			put("WZSFXMJG", "门诊物资收费项目价格,0表示不启用,1表示启用,默认是0");
			put("WZSFXMJGZY", "住院物资收费项目价格,0表示不启用,1表示启用,默认是0");
			put("QYMZSF", "启用门诊审方标志，0表示不启用，1表示启用，默认是0");
			put("MTSQYCGHF", "是否每天收取一次挂号费，1一天只收一次，0每次挂号都收");
			put("BAHMDYZYHM", "启用病案号码等于住院号码标志，0表示不启用，1表示启用，默认是0");
			put("BAHMCXFP", "病案号码重新分配，0表示不启用，1表示启用，默认是0");
			put("YJZXQXZD", "医技执行取消诊断，0表示不启用，1表示启用，默认是0");
			put("GHKSSFPB", "挂号科室是否需要排班，1是，0否，默认是1");
			put("SFJYWBKB", "是否禁用外部拷贝，1：是，0否，默认是0");
			put("ZXSSFDJ", "医技项目执行门诊医技只显示已收费单据 1表示显示收费单据 0表示显示全部单据");
			put("ZYQFKZ", "住院欠费控制 1表示控制 0表示不控制默认为0");
			put("ZYQFTXYZ", "住院欠费提醒阈值");
			put("JCQFKZ", "家床欠费控制 1表示控制 0表示不控制默认为0");
			put("SX_PREALARM",
					"值为n，表示药品失效预警截止时间为当前时间加上n个月。若n为非法数字则取默认值3。若为带小数点的数值则取其整数部分");
			put("ZLFYDJ", "诊疗费单价");
			// put("QYMZPD", "启用门诊排队 0：不启用，1：启用，默认为0");
			put("QYFYCK", "启用发药窗口 0：不启用，1：启用，默认为0");
			// put("YBSJSJUJG", "医保对照复制源机构的 机构id，如360121206表示八一乡卫生院的机构id");
			// put("BSDYRJBZ", "博思打印软件标志,0表示不启用,1表示启用,默认是0");

			put("MZFYZDSXMS", "门诊发药自动刷新秒数");
			put("QYJYBZ", "启用检验标志，0表示未启用，1表示启用，默认是0");
			put("QYTJBGBZ", "启用体检报告标志，0表示未启用，1表示启用，默认是0");
			put("CARDORMZHM", "设置卡管理兼容门诊号码，1卡号2门诊号码，默认是1");
			put("HQFYYF", "启用门诊医生站处方界面的药房切换功能，1表示启用，0表示不启用，默认是0");
			put("QYNLXZ", "启用建档年龄限制 0：不限制 大于0的整数：表示小于该年龄时，需要输入出生年月");
			put("MPI_ADDRESS", "新建档时默认联系地址，为空时不默认");
			put("MPI_WORKPLACE", "新建档时默认工作单位，为空时不默认");
			put("MPI_WORKCODE", "新建档时默认职业类别，为空时不默认");
			put("MPI_TELE", "新建档时默认家庭电话，为空时不默认");
			put("YMJDYSGH", "疫苗建档医生工号，多个疫苗建档医生之间用逗号(,)隔开");

			// put("SYB_YYDJ", "市医保医院等级");
			// put("SYB_ZFYP", "市医保自费药品");
			// put("SYB_KBZY", "市医保可使用的中草药");
			// put("BZLBFFHJGH", "边诊疗边付费划价工号");
			// put("XNFPXL", "虚拟发票序列");
			put("YZLRFHTYGH", "医嘱录入复核可为同一工号   0：不可为同一个人 1：可为同一个人");

			// put("SYBCYXE", "市医保病人草药限额");
			// put("SYBGDBZCYXE", "市医保规定病种病人草药限额");
			put("CFXYZYMXSL", "录入处方明细数量限制是否启用(西药中药)，0表示不启用,大于0则表示允许录入的最大处方明细数量");
			put("CFCYMXSL", "录入处方明细数量限制是否启用(草药)，0表示不启用,大于0则表示允许录入的最大处方明细数量");
			put("QYCFCZQZTJ",
					"录入处方处置前置条件是否启用，如果启用，则未录入诊断不允许录入处方处置，1表示启用，0表示不启用");

			put("YKACCOUNTPRICE", "药库记账标准价格，1表示零售价格，2表示进货价格，3表示批发价格");
			put("QYSXZZ", "启用双向转诊功能,1表示启用 0表示不启用");
			put("MZKCDJSJ", "门诊库存冻结时间  1是开单,2是收费");
			put("SFQYYFYFY", "是否启用药房预发药,0是不启用,1启用");
			put("KCDJTS", "库存冻结天数,单位是天");
			put("JCKCDJTS", "家床库存冻结天数,单位是天");
			// put(TJRQLX,
			// "//住院性质费用汇总报表/出院病人汇总表的统计日期类型 收费日期(SFRQ)、结帐日期(JZRQ)和汇总日期(HZRQ)");
			put("FPYL", "发票预览，0是直接打印，1是发票预览，默认为0");
			put("GHDYJMC", "挂号打印机名称");// 挂号打印机名称
			put("MZHJSFDYJMC", "门诊划价收费打印机名称");// 门诊划价收费打印机名称
			put("ZYJKDYJMC", "住院缴款打印机名称");// 住院缴款打印机名称
			put("ZYJSDYJMC", "住院结算打印机名称");// 住院结算打印机名称
			put("JCJSDYJMC", "家床结算打印机名称");// 家床结算打印机名称
			// 抗菌药物
			put("QYKJYWGL", "是否启用抗菌药物管理:0表示不启用，1表示启用，默认为0");
			put("QYSJYSSQ", "是否启用门诊抗菌药物上级医生授权 0表示不启用,1表示启用,默认为1");
			put("QYKJYYY", "是否启用抗菌药录入原因： 0表示不启用 ，1表示启用，默认为1");
			put("QYZYKJYWSP", "是否启用住院抗菌药物审批：0表示不开启，1表示开启，默认为0");
			put("KJYSYTS", "抗菌药物限制最大用药天数，默认为3天");
			put("YZTDMYTS", "医嘱套打每页条数,默认20,设置好后请勿随便修改 以防打印不正确");
			put("YZBDYSFTD", "医嘱本打印是否需要套打,0是不需要,1是需要,默认为0");
			put("YZBDYSJ", "医嘱本打印时间,1是提交后打印,2是复核后打印,默认为1");
			put("ZKCZHHYDY", "医嘱本打印,转科重整后换页打印,0是否,1是是");
			put("QYYWS", "启用业务锁功能：0不启用 1启用");
			// 皮试管理
			put("QYPSXT", "启用皮试系统,0不启用,1启用,默认为0");
			put("PSXQ", "皮试效期(天),默认值为1天");
			put("PSSJ", "皮试时间:默认为20,单位为分钟");
			put("PSSXJG", "皮试界面刷新间隔:默认为20,单位为秒");
			put(QYMZDZBL, "启用门诊电子病历，0：不启用 1：启用，默认不启用");// 启用门诊电子病历
			put(SFSFXZKS, "收费是否需要选择科室,0是不需要 1是需要 默认0");// 收费是否需要选择科室,0是不需要 1是需要
														// 默认0
			put(CFDPCQSL, "处方点评抽取数量,默认是100");// 处方点评抽取数量,默认是100
			put(PSSFDYXM, "皮试收费对应项目，设置皮试收费对应项目的费用序号，值为整数");
			put(SFSFXZKS, "收费是否需要选择科室,0是不需要 1是需要 默认0");// 启用门诊电子病历
			put(MZFPFDFS, "0：不分单，1：按收费项目分单，2：检查按执行科室分单，药品按药房分单");// 门诊发票分单方式
			put(MZFPSFLD, "0：不连打，1：连打");// 门诊发票是否连打
			put(MZFPMXSL, "设置大于0的数字:0表示不控制打印明细数");// 门诊发票连打明细数量
			put(SFQYJKJSAN, "是否启用健康结算按钮:0表示不显示，1表示显示");
			put(ZYFPSFZCGY, "住院发票是否支持公有:0表示不支持，1表示支持");
			put(JKSJSFZCGY, "缴款收据是否支持公有:0表示不支持，1表示支持");
			put(JCFPSFZCGY, "家床发票是否支持公有:0表示不支持，1表示支持");
			put(JCJKSJSFZCGY, "家床缴款收据是否支持公有:0表示不支持，1表示支持");
			put(QYJCGL, "启用家床管理： 0 不启用 1 启用，默认为0");
			put(JCBH, "家床病人的唯一识别号，从1开始长度为10的流水号（如0000000001）");
			put(JCH, "家床病人家床流水号，从1开始长度为10的流水号（如0000000001）");
			put(JCEDTS, "机构允许病人家床的最大天数，即开始时间和终止时间的天数");
			put(JCJKJEZD, "家床缴款金额是否设置为只读");
			put(JCKCGL, "家床库存管理,1不进行库存管理,2提交并直接发药,3提交到药房发药");
			put("JCZZLJTS", "家床登记临近终止日期提醒天数，默认临近7天提示");// 家床终止临近天数
			put("SJDOREHY", "门诊转诊号源支持时间段和具体号源两种模式，1表示时间段，2表示号源");// 家床终止临近天数
			put("JCJKDYJMC", "家床缴款打印机名称");// 住院缴款打印机名称
			put(YPCRKMS,"药品入出库时是否弹出明细窗口:0.弹出,1.不弹");//药品入出库确认模式
			put(SFQYWJZTX,"是否启用危机值提醒:0.不启用,1.启用");//是否启用危机值提醒
			put(WJZCLSX,"危急值处理时限,单位:分");//危急值处理时限
			put(WJZCSSX,"危急值超时时限,单位:分");//危急值超时时限
			put(WJZTXJGSJ,"危急值提醒间隔时间,单位:秒");//危急值超时时限
			put(YZTJDYYF,"医嘱不同途径对应不同药房,格式:途径1,途径2,途径3=药房1,药房2,药房3  格式错误会导致系统报错!");//医嘱不同途径对应不同药房
			put(MZSFHJYF,"门诊收费划价药房(选择该药房发药窗口用)");
			put(SFYXFYJZTSYFY,"是否允许费用记账退所有费用,0是只退记账数据,1是退所有数据");
			put(YBXZ,"医保性质代码");
			put(YYGHSXB,"系统参数预约时间点的第B分钟有效，排队叫号使用这个参数");//系统参数预约时间点的第B分钟有效
			put(FKKS,"妇科科室代码，妇幼减免使用这个参数");//妇科科室代码
			put(POSMDH,"POS门店号，pos机使用这个参数");//POS门店号
			put(CDMZKS,"肠道门诊对应挂号科室代码,默认为'',不同科室之间用,隔开");//POS门店号
			put(ZDXZS,"最多可以开几条诊断");
			put(CFXZS,"最多可以开几条处方");
			put(CDMZKFSJD,"肠道门诊开放时间段");
			put(ZYSYGYTJ,"病区医嘱给药途径是这些类型的要保存到BSRUN库");
			put(ZYKS,"中医科室代码");
			put(ZDJSSL,"是否启用门诊处方自动计算用药总量 1:启用 0:不启用 默认为1");
			put(TJKS,"体检科室代码");
			put(YFS,"牙防所代码");
			put(QYZDFYJ,"启用自动发药机接口 0:不启用,1:启用 默认为不启用");
			put(SFQYPDYPFP,"是否启用盘点药品分配,1是启用,0是不启用 默认是1");
			put(PDXHLY,"排队序号来源，1：老系统，0：新系统");
			put(CFTD,"处方打印，1：套打，0：白纸打");
			put(CFQX,"是否启用门诊同科室上级可以修改下级处方权限，1：启用，0：不启用，默认是0");
			put(SFZDHG,"收费自动回滚，1：是，0：否");
			put(SFQYYYGH,"是否启用预约挂号，1：是，0：否");

			put(BJQXH,"报价器型号   ，0：无 报价器     1：古美默认型号(良标)，2：吴径新型号（上海宇驰Q9）");

			put(SFQYMHYL1,"门诊是否启用闵行医疗救助，1：是，0：否");
			put(SFQYMHYL5,"住院是否启用闵行医疗救助，1：是，0：否");
			put(SFQYWXHLYY,"是否启用万序合理用药(0停用,1门诊,2住院,3启用门诊与住院");
			//综管平台
			put(ZGURL,"综管平台URL");
			put(MZXPLX,"门诊小屏类型  0没有,1吴泾,2龙柏  ");
			put(SFQYYBZNTX,"是否启用医保智能提醒 参数控制，值为1才启用，默认0");
			put(JDKDYYPYF,"增加静滴卡打印药品用法参数 ,有配置参数，就查询出这些用法的数据");
			put(SFDCPQSL,"是否带出盘前数量(0否,1是)");

			put(SFQYCYXT,"是否启用草药系统,1：是，0：否，默认启用");
			put(SFQYZYSY,"是否启用住院输液,1：是，0：否，默认启用");

			put(FFDDYYFLB,"服法单打印药房列表(值是逗号分割的药房ID列表)");
			put(SFQYCYDJSF,"是否启用草药代煎收费，1：是，0：否");

			put(CYFYDYCF,"且药品类型为草药，打印一张与医生处相同的处方单，1：是，0：否");
			put(CYCFDYDJ,"且药品类型为草药，右上角打印‘煎’，1：是，0：否");

			put(LXCSSFBT,"龙柏需求，如病人性质为离休，则离休证号必填，0：否，1：是");
			put(JCQYSFKTJ,"龙柏需求，如家床开药库存为0，则不允许提交，0：不启用，1：启用");
			put(JCDYFFD,"龙柏需求，家床发药打印服法单，0：不启用，1：启用");
			put(GGXXXZYBYP,"公共信息新增医保药品，0：关，1：开");
			put(PDFYKZ,"盘点发药控制1是,0否");
			put(SFQYJCBHZZ,"是否启用家床编号自增，0：否，1：是");
			put(SFQYZYHMZZ,"是否启用住院号码自增，0：否，1：是");
			put(SFTZCYSFCW,"是否通知出院释放床位，0：否，1：是");
			put(SFQYYFFYJH,"是否启用药房发药叫号，0：否，1：是");
			put(SFCPSKZ,"收费处皮试控制，0：否，1：是");
			put(SFBXFPCW, "是否必须分配床位，0：否，1：是");
			put(SFQYGPHLD, "是否启用GP护理单，0：否，1：是");
			put(ZSDYPYFSY, "注射单药品用法输液(多个用\",\"分隔)");
			put(ZSDYPYFJD, "注射单药品用法静滴");
			put(ZSDYJJMSY, "注射单医技静脉输液(费用序号)");
			put(ZSDYJSFSY, "注射单医技收费输液(费用序号,多个用\",\"分隔) ");
			put(ZDFYJWSURL,"自动发药机webservice地址");
			put(EKKSDM,"儿科科室代码(儿保处方笺)");
			put(EKCFDYBZ,"儿科处方打印标志，0：否，1：是");
			put(SFPSZDFF,"是否皮试自动付费，0：否，1：是");
			put(ZCYSLXZ, "中成药数量限制(单张处方),0不限制");
			put(LSYZMRPC, "临时医嘱默认频次");
			put(YPCKDDYPB, "药品出库单打印机类型0:A4,1:龙柏纸张28*22.5");
			put(YSYFSB, "延生药房药房识别");
			put(JMBRXZ, "计免病人性质");
			put(BRXZ_SYBX, "病人性质_商业保险");
			put(ZDDYSYD, "自动打印输液单");
			put(GMSYD, "古美输液单");

			put(ZYYPJKUSER, "中药饮片接口用户名（市药事系统注册用户的用户名）");
			put(ZYYPJKPWD, "中药饮片接口密码（市药事系统注册用户的密码）");
			put(ZYYPJKBBH, "中药饮片接口版本号");
			put(ZYYPJKYQBM, "中药饮片接口药企编码(市药事系统对药企的统编代码)");
			put(ZYYPJKWSDL, "中药饮片接口地址");
			put(SFQYZYYPJK, "是否启用中药饮片接口(0否，1是)");


			put(PDJHYXNL, "龙柏社区排队叫号老人优先年龄,默认70");
			put(PDJHYXXZ, "龙柏社区排队叫号病人优先性质,默认: 离休23、伤残19, 多个\",\"号分隔");
			put(SQJHMS,   "社区叫号模式(LB龙柏)");
			put(SQJHSJ,   "社区叫号模式启用时间(hh:mm:ss)");
			put(PDJHJHJG, "社区排队叫号间隔时间(分)");
			put(SQJHBHZKS, "社区叫号不候诊科室(以“,”分隔)");
			put(SQJHYCSJ,  "社区叫号延迟时间（分钟）");
			put(SQJGBM, "社区机构编码");
			put(SQXTMS, "社区系统模式(LB：龙柏、GM：古美、WJ：吴泾，默认GM )");

			put(TWDCS, "体温单参数，0：否，1：是");
			put(YFCWYBCS, "药房财务月报参数，0：否，1：是");
			put(MZBKBRXZ, "民政帮困病人性质，默认古美27");
			put(LXBRXZ, "离休病人性质，默认古美23");
			put(JHSYXZ, "计划生育性质，默认古美18");
			put(JHSYJMBL, "计划生育减免比例，默认0(1百分百,0不减免)");

			put("BQYPYLSJ", "病区药品预领时间 1:领药日期第二天00:00:00  2:领药日期第二天09:30:00 3:领药日期第二天12:30:00");
			put("BQYPYLTS", "摆药病区药品预领时间(必填，数字) 1:领药日期第二天23:59:59  2:领药日期第二天09:30:00, 3:领药日期第二天12:30:00");
			put("ZFBPZWJM", "支付宝文件名");

			put("SFTB40", "是否同步40库（1是,0否）");
			put("SFTBBSRUN", "是否同步Bsrun（1是,0否）");

			put("GP02", "签约");
			put("GP03", "转诊");
			put("GP04", "处方延伸");
			put("GP06", "EHR");
			put("GP07", "nfc发卡");
			put("GPURL", "GP接口地址");
			put("GPENABLED", "是否启用GP");
			put("GPHOMEPAGE", "GP首页地址");
			put("FYJJNSL", "是否启用发药机机内数量");
			put("ZYTZBSFYXH", "中医体质辨识费用序号");
			put("LCJHZCS", "零差价汇总，默认数值0.05，即百分之五");
			put("LBMZBL", "龙柏门诊病历参数");
			put("YBBBFZR", "医保报表负责人参数");
			put("YLHZBKBBLXDH", "医疗互助帮困报表联系电话");
			put("YLHZBKBBYHZH", "医疗互助帮困报表银行账户");
			put("YLHZBKBBYHMC", "医疗互助帮困报表银行名称");
			put("LBYLHZBK", "龙柏医疗互助帮困参数");
			put("QZJIPDZ", "前置机IP地址");
			put("YBBBBH", "医保报表编号");
			put("LNHL_JCHL", "老年护理_基础护理");
			put("QYJCZDFYJ","启用家床自动发药机，0：否，1：是");

			put(DWKKS,"大外科，取GY_KSDM,多个科室，隔开");
			put(DNKKS,"大内科，取GY_KSDM,多个科室，隔开");
			put(DFKKS,"妇科，取GY_KSDM,多个科室，隔开");
			put(WEBREPORTURL,"报表URL地址：http://192.168.20.43:8080/WebReport/ReportServer?reportlet=");

			put(YBZFYXZ, "0关闭开自费药，1开启开自费药");
			put(YBZFXMXZ, "0关闭开自费项目，1开启开自费项目");

			put(YBGJYXZ, "0关闭开高价药，1开启开高价药");

			put(JSYPML, "精神药品、麻醉药品目录(精神处方笺),配置精神药品序号");
			put(GHJMSZ, "1:挂号减免，0：挂号不减免");
			put(LSYZSYPCCS, "临时医嘱使用频次参数 ：0：默认乘以SYPC。1：不乘以SYPC");
			put(DPYBSDY, " 0 关闭  1开启 ： 门诊病史打印显示代配药字样");
			put(BYQDZXSJ, "摆药QD执行时间(摆药单打印)：默认23:59");


			put(fyxsdf,"费用结算是否显示到分（1是，0不是）");
			put("JYOPEN","捷医判别,0-all1自费2医保");
			put("XTYSZZ","血透医生资质:医生工号,多个,隔开");

			put(JAJGID, "蓝宙医院 JGID" );
			put(WZSHQX, "物资审核权限,多个用户,隔开" );
			put(BBJBSJ, "护士交班白班交班时间 格式：XX:XX:XX(必填)" );
			put(XYBJBSJ, "护士交班小夜班交班时间 格式：XX:XX:XX");
			put(DYBJBSJ, "护士交班大夜班交班时间 格式：XX:XX:XX");
			put("BLZDCDJQ","病案首页中，病理诊断打印时长度截取及换行设置，0.不截取。>0 截取几位，int类型");
			put("JYKSXZ","捷医科室限制，自助机不能挂该科室。多个科室用,隔开。最后不能有,号（英文字符）");

			put("SMJFYS","手麻计费 默认医生");
			put("SMJFKS","手麻计费默认科室");


			put("EMRBAJG","病案机构");
			put("EMRBAYYDM","病案医院代码");
		}
	};

	/**
	 * 所属类别 <item key="01" text="病人档案" /> <item key="02" text="挂号管理" /> <item
	 * key="03" text="收费管理" /> <item key="04" text="门诊诊疗" /> <item key="05"
	 * text="药房管理" /> <item key="06" text="药库管理" /> <item key="07" text="住院管理"
	 * /> <item key="08" text="病区管理" /> <item key="09" text="医技管理" /> <item
	 * key="10" text="物资管理" /> <item key="11" text="电子病历" /><item key="12"
	 * text="处方点评" /> <item key="13" text="抗菌药物" /> <item key="14" text="皮试管理"
	 * /><item key="15" text="家床管理"/>
	 */
	public static final Map<String, String> defaultCategory = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(MZFPFDFS, "03");// " 门诊发票分单方式 "
			put(MZFPSFLD, "03");// " 门诊发票是否连打 "
			put(MZFPSFLD, "03");// " 门诊发票连打明细数量 "
			// put(XYF, " 西药归属的收费项目 ");
			// put(ZYF, " 中药归属的收费项目 ");
			put(FHYZHJF, "07,08");// " 复核医嘱后计费 "
			// put(CYF, " 草药归属的收费项目 ");
			put(CFXQ, "03");// 自动调入处方的有效期0.不限制 以天为单位
			put(CFJEJJX, "04");//处方总金额界限
			put(XQJSFS, "02,03,04");// 效期计算方式：0：精确到时分，1：截止到23:59:59

			put(GHXQ, "02");// 门诊挂号效期：以天为单位
			// put(YJSJ_YK, "药库月结时间 对应一个月的31天  32为月底结 ");

			put(YS_MZ_FYYF_CY, "03,04,05,07,08");// 草药对应药房，存药房识别
			put(YS_MZ_FYYF_XY, "03,04,05,07,08");// 西药对应药房，存药房识别
			put(YS_MZ_FYYF_ZY, "03,04,05,07,08");// 中药对应药房，存药房识别
			put(YXWGHBRJZ, "02,03,04");// 无挂号模式 0就是挂号模式，1就是无挂号模式
			// put(YYJGTS, "");/ 预约间隔天数：以天为单位
			put(ZDCSMZH, "01");// 自动产生门诊号 0.不自动产生1.自动产生
			put(ZDCSJZH, "02,03,04");// 自动产生就诊号 0.不自动产生1.自动产生
			// put(ZXSYKCYP,
			// " 只显示有库存的药品 0: 没有库存的药品也可以在下拉列表中显示 1: 下拉列表中只显示有库存的的药品 ");

			// put(WGHMS, "无挂号模式0.挂号模式1.无挂号模式");
			put(BLF, "02,03,04");// 病历费的价格
			put(YSZJS, "04");// 医生站结算:0.不允许结算，1.允许结算
			// put(YB_ZH_SFQY, "社保是否启用:0.不启用，1.启用");
			put(ZYHM, "07");// 住院号码
			put(BAHM, "07");// 病案号码
			put(YZLR_BZLX, "08");// 包装类型,1：医嘱录入使用包装类型 2使用药品信息中的病房包装
			put(BQCHXSWS, "08");// 病区床号显示位数，默认为0时显示全部，其余按值从右截取显示
			put(MRXZ, "01");// 默认性质
			put(XSFJJJ_YS, "08");// 显示医生站附加项目 0:不显示,1:显示
			put(XSFJJJ_HS, "08");// 显示护士站附加项目 0:不显示,1:显示
			put(XSFJJJ, "04");// 显示门诊附加项目 0:不显示,1:显示
			put(ZYYSQY, "08");// 住院医生站启用 0.不启用1.启用
			put(BMSZ, "09");// 医技取消窗口前置条件1:门诊医技,2:住院医技,3:同时使用 默认使用3 其余1和2未进行配置
			// put(REPORT_COUNTDATE_MZ, "报表统计日期 1.按收费日期,默认是1");

			// put(KCPD_PC, "药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点");
			put(SFZJFY, "03");// 收费直接发药:0.不启用，1.启用
			put("KCPD_PC", "06");
			put("YF_PCPD", "05");
			put("PYFS_YK", "05");
			put("PKFS_YK", "05");
			put("QNYDK", "11");// 病程从当前病程前N份打开
			put("YXXJYSXG", "11");// 允许下级医生修改病历 0:不允许 1:允许
			put("QZWZXJY", "11");// 强制完整性校验 0:不需要 1:需要
			put("DYQWZXJY", "11");// 打印前强制完整性校验 0:不是 1:是
			put("QMYZXJY", "11");// 签名一致性校验 0:不是 1:是
			put("WPJFBZ", "10");// 物品计费标志,0表示不启用，1表示启用，默认是0
			put("MZWPJFBZ", "10");// 门诊物品计费标志,0表示不启用，1表示启用，默认是0
			put("WZSFXMJG", "10");// 门诊物资收费项目价格,0表示不启用,1表示启用,默认是0
			put("WZSFXMJGZY", "10");// 住院物资收费项目价格,0表示不启用,1表示启用,默认是0
			put("QYMZSF", "03,04");// 启用门诊审方标志，0表示不启用，1表示启用，默认是0
			put("MTSQYCGHF", "02,03");// 是否每天收取一次挂号费，1一天只收一次，0每次挂号都收
			put("BAHMDYZYHM", "07");// 启用病案号码等于住院号码标志，0表示不启用，1表示启用，默认是0
			put("BAHMCXFP", "07");// 病案号码重新分配，0表示不启用，1表示启用，默认是0
			put("YJZXQXZD", "09");// 医技执行取消诊断，0表示不启用，1表示启用，默认是0
			put("GHKSSFPB", "01");// 挂号科室是否需要排班，1是，0否，默认是1
			put("SFJYWBKB", "11");// 是否禁用外部拷贝，1：是，0否，默认是0
			put("ZXSSFDJ", "09");// 医技项目执行门诊医技只显示已收费单据 1表示显示收费单据 0表示显示全部单据
			put("ZYQFKZ", "07");// 住院欠费控制 1表示控制 0表示不控制默认为0
			put("ZYQFTXYZ", "07");// 住院欠费提醒阈值
			put("JCQFKZ", "15");// 家床欠费控制 1表示控制 0表示不控制默认为0
			put("SX_PREALARM", "05,06");
			// 值为n，表示药品失效预警截止时间为当前时间加上n个月。若n为非法数字则取默认值3。若为带小数点的数值则取其整数部分
			put("ZLFYDJ", "07,08");// 诊疗费单价
			// put("QYMZPD", "启用门诊排队 0：不启用，1：启用，默认为0");

			// put("YBSJSJUJG", "医保对照复制源机构的 机构id，如360121206表示八一乡卫生院的机构id");
			// put("BSDYRJBZ", "博思打印软件标志,0表示不启用,1表示启用,默认是0");

			put("QYJYBZ", "04");// 启用检验标志，0表示未启用，1表示启用，默认是0
			put("QYTJBGBZ", "04");// 启用体检报告标志，0表示未启用，1表示启用，默认是0
			put("CARDORMZHM", "01");// 设置卡管理兼容门诊号码，1卡号2门诊号码，默认是1
			put("HQFYYF", "04,05");// 启用门诊医生站处方界面的药房切换功能，1表示启用，0表示不启用，默认是0
			put("QYNLXZ", "01");// 启用建档年龄限制 0：不限制 大于0的整数：表示小于该年龄时，需要输入出生年月
			put("MPI_ADDRESS", "01");// 新建档时默认联系地址，为空时不默认
			put("MPI_WORKPLACE", "01");// 新建档时默认工作单位，为空时不默认
			put("MPI_WORKCODE", "01");// 新建档时默认职业类别，为空时不默认
			put("MPI_TELE", "01");// 新建档时默认家庭电话，为空时不默认
			put("YMJDYSGH", "03");// 疫苗建档医生工号，多个疫苗建档医生之间用逗号(,)隔开
			// put("SYB_YYDJ", "市医保医院等级");
			// put("SYB_ZFYP", "市医保自费药品");
			// put("SYB_KBZY", "市医保可使用的中草药");
			// put("BZLBFFHJGH", "边诊疗边付费划价工号");
			// put("XNFPXL", "虚拟发票序列");
			put("YZLRFHTYGH", "08");// 医嘱录入可为同一工号 0：不可为同一个人 1：可为同一个人
			// put("SYBCYXE", "市医保病人草药限额");
			// put("SYBGDBZCYXE", "市医保规定病种病人草药限额");
			put("CFXYZYMXSL", "03,04");
			// 录入处方明细数量限制是否启用(西药中药)，0表示不启用,大于0则表示允许录入的最大处方明细数量
			put("CFCYMXSL", "03,04");
			// 录入处方明细数量限制是否启用(草药)，0表示不启用,大于0则表示允许录入的最大处方明细数量
			put("QYCFCZQZTJ", "03,04");
			// 录入处方处置前置条件是否启用，如果启用，则未录入诊断不允许录入处方处置，1表示启用，0表示不启用

			put("QYSXZZ", "04");// 启用双向转诊功能,1表示启用 0表示不启用
			// put(TJRQLX,
			// "//住院性质费用汇总报表/出院病人汇总表的统计日期类型 收费日期(SFRQ)、结帐日期(JZRQ)和汇总日期(HZRQ)");
			put("FPYL", "03");
			put("GHDYJMC", "02");// 挂号打印机名称
			put("MZHJSFDYJMC", "03");// 门诊划价收费打印机名称
			put("ZYJKDYJMC", "07");// 住院缴款打印机名称
			put("ZYJSDYJMC", "07");// 住院结算打印机名称
			put("JCJSDYJMC", "15");// 家床结算打印机名称

			// 药房相关参数
			put("YF_PCPD", "05");// 药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点
			put("SFQYYFYFY", "05");// 是否启用药房预发药,0是不启用,1启用
			put("MZKCDJSJ", "05");// 门诊库存冻结时间 1是开单,2是收费
			put("KCDJTS", "05");// 库存冻结天数,单位是天
			put("JCKCDJTS", "15");// 库存冻结天数,单位是天
			put(CKSX_KCSL_YF, "05");// 出库顺序_库存数量1.按库存数量出库0.不按库存数量出库
									// 该参数值是1时，才会根据参数CKSX_KCSL_ORDER_YF的值进行排序，否则不会；并且排序时，先效期再数量
			put(CKSX_KCSL_ORDER_YF, "05");// 出库顺序_库存大小 A.库存少的先出库（小先出）
											// D.库存多的先出库（大先出）
			put(CKSX_YPXQ_ORDER_YF, "05"); // 出库顺序_效期先后
											// A.效期早的药品先出库（早先出）D.效期迟的药品先出库（迟先出）
			put(CKSX_YPXQ_YF, "05");// 出库顺序_药品效期 1.按效期出库 0.不按效期出库
			put(YJSJ_YF, "05"); // 月结时间 对应一个月的31天 32为月底结
			put("QYFYCK", "05");// 启用发药窗口 0：不启用，1：启用，默认为0
			put("MZFYZDSXMS", "05");// 门诊发药自动刷新秒数
			put(CFDPCQSL, "12");// 处方点评抽取数量,默认是100
			// 药库相关参数
			put("PLJC", "06");// 批零加成
			put("PLJC_ZY", "06");// 批零加成
			put("PLJC_CY", "06");// 批零加成
			put("YKACCOUNTPRICE", "06");// 药库记账标准价格，1表示零售价格，2表示进货价格，3表示批发价格
			put(YPKL_YK, "06");// 药库财务验收药品扣率
			put(YJSJ_YK, "06");// 药库月结时间 对应一个月的31天 32为月底结
			put(ZDZDTJ, "06");// 中心调价站点是否自动调价
			put(KCPD_PC, "06");// 药库库存盘点是否按批次盘点,false是不按批次盘点,true是按批次盘点
			put("PYFS_YK", "06");// 药库盘盈方式
			put("PKFS_YK", "06");// 药库盘亏方式
			put(QYMZDZBL, "11");// 启用门诊电子病历
			// 病区相关参数
			put(YZTDMYTS, "08");// 医嘱套打每页条数
			put(YZBDYSFTD, "08");// 医嘱本打印是否需要套打
			put(YZBDYSJ, "08");// 打印时间,1是提交后打印,2是复核后打印
			put(ZKCZHHYDY, "08");// 转科重整后换页打印,0是否,1是是

			put(SFQYJKJSAN, "03");

			put(QYPSXT, "14");
			put(PSSJ, "14");
			put(PSSXJG, "14");
			put(PSXQ, "14");
			put(PSSFDYXM, "14");// 皮试收费对应项目

			put(QYKJYWGL, "13");
			put(QYKJYYY, "13");
			put(QYSJYSSQ, "13");
			put(QYZYKJYWSP, "13");
			put(YYJGTS, "02,03");
			put(KJYSYTS, "13");
			put(ZYFPSFZCGY, "07");
			put(JKSJSFZCGY, "07");
			put(JCFPSFZCGY, "15");
			put(JCJKSJSFZCGY, "15");
			put(JCBH, "15");
			put(JCH, "15");
			put(JCZZLJTS, "15");
			put(JCKCGL, "15");
			put(SJDOREHY, "04");
			put(JCEDTS, "15");
			put(JCJKJEZD, "15");
			put(JCJKDYJMC, "15");// 家床缴款打印机名称
			put(QYJCGL, "15");
			put(YPCRKMS,"06");//药库出库确认方式
			put(YZTJDYYF,"08");//医嘱不同途径对应不同药房
			put(MZSFHJYF,"03,05");
			put(SFYXFYJZTSYFY,"08");//是否允许费用记账退所有费用
			put(YBXZ,"02,03,07");//医保性质代码
			put(YYGHSXB,"04");//系统参数预约时间点的第B分钟有效
			put(FKKS,"03");//妇科科室代码
			put(POSMDH,"02,03");//POS门店号
			put(CDMZKS,"04");//
			put(ZDXZS,"04");
			put(CFXZS,"04");
			put(CDMZKFSJD,"04");
			put(VIPBRXZ,"03,02,07");//VIP病人性质
			put(ZYSYGYTJ,"08");
			put(ZYKS,"04");
			put(ZDJSSL,"04");
			put(TJKS,"04");
			put(YFS,"04");
			put(SFQYPDYPFP,"05");
			put(PDXHLY,"04");
			put(CFTD,"04");
			put(CFQX,"04");
			put(SFZDHG,"04");
			put(SFQYYYGH,"04");
			put(BJQXH,"04");
			put(ZGURL,"04");
			put(SFQYMHYL1,"04");
			put(SFQYMHYL5,"07");
			put(SFQYWXHLYY,"04");
			put(MZXPLX,"04");
			put(SFQYYBZNTX,"04");
			put(JDKDYYPYF,"08");
			put(SFDCPQSL,"05");
			put(SFQYCYXT,"03");
			put(SFQYZYSY,"03");
			put(FFDDYYFLB,"04");
			put(SFQYCYDJSF,"04");
			put(CYFYDYCF,"05");
			put(CYCFDYDJ,"05");

			put(LXCSSFBT,"01,02");
			put(JCQYSFKTJ,"15");
			put(JCDYFFD,"15");
			put(SFQYJCBHZZ,"15");
			put(SFQYZYHMZZ,"07");
			put(SFTZCYSFCW,"08");

			put(GGXXXZYBYP,"06");
			put(PDFYKZ,"05");
			put(SFQYYFFYJH,"05");
			put(SFCPSKZ,"03");
			put(SFBXFPCW,"07");
			put(SFQYGPHLD,"04");
			put(ZSDYPYFSY,"04");
			put(ZSDYPYFJD,"04");
			put(ZSDYJJMSY,"04");
			put(ZSDYJSFSY,"04");
			put(ZDFYJWSURL,"03");
			put(EKKSDM,"04");
			put(EKCFDYBZ,"04");
			put(SFPSZDFF,"04");
			put(ZCYSLXZ,"04");
			put(LSYZMRPC,"07");
			put(YPCKDDYPB,"06");
			put(YSYFSB,"04");
			put(JMBRXZ,"04");
			put(BRXZ_SYBX,"01");
			put(ZDDYSYD,"04");
			put(GMSYD,"04");

			put(ZYYPJKUSER,"04");
			put(ZYYPJKPWD,"04");
			put(ZYYPJKBBH,"04");
			put(ZYYPJKYQBM,"04");
			put(ZYYPJKWSDL,"04");
			put(SFQYZYYPJK,"04");


			put(PDJHYXNL,"04");
			put(PDJHYXXZ,"04");
			put(SQJHMS,"04");
			put(SQJHSJ,"04");
			put(PDJHJHJG,"04");
			put(SQJHBHZKS,"04");
			put(SQJHYCSJ,"02,04");
			put(SQJGBM,"04");
			put(SQXTMS,"");
			put(MZBKBRXZ,"04");
			put(LXBRXZ,"04");
			put(JHSYXZ,"04");
			put(JHSYJMBL,"04");
			put("BQYPYLSJ", "08");
			put("BQYPYLTS", "08");
			put("SFTB40", "04");
			put("SFTBBSRUN", "04");
			put("GP02", "04");
			put("GP03", "04");
			put("GP04", "04");
			put("GP06", "04");
			put("GP07", "04");
			put("GPURL", "04");
			put("GPENABLED", "04");
			put("GPHOMEPAGE", "04");
			put("YSCFCX","06");
			put("YSCFCX","06");
			put("YPDR","05");
			put("YPDBBZKZ","05");
			put("CCFHZCX","06");
			put("BLTZGL","04");
			put("FYJJNSL","05");
			put("ZYTZBSFYXH", "04");
			put("LCJHZCS","06");
			put("LBMZBL","04");
			put("YBBBFZR","02");
			put("YLHZBKBBLXDH","02");
			put("YLHZBKBBYHZH","02");
			put("YLHZBKBBYHMC","02");
			put("LBYLHZBK","04");
			put("QZJIPDZ","04");
			put("YBBBBH","02");
			put(LNHL_JCHL,"03,04");


			put(DNKKS,"02");
			put(DWKKS,"02");
			put(DFKKS,"02");
			put(WEBREPORTURL,"04");

			put(YBZFYXZ,"04");
			put(YBZFXMXZ,"04");

			put(YBGJYXZ,"04");

			put("JSYPML","04");
			put("GHJMSZ","02");
			put("LSYZSYPCCS","08");
			put("DPYBSDY","04");
			put("BYQDZXSJ","04");

			put("fyxsdf","03");
			put(JYOPEN,"03");
			put(XTYSZZ,"04");
			put(BLZDCDJQ,"04");

			/* 	蓝宙	*/
			put(WZSHQX,"10");
			put(BBJBSJ, "08" );
			put(XYBJBSJ, "08");
			put(DYBJBSJ, "08");
			put(JYKSXZ,"03");


			put("SMJFYS","03");
			put("SMJFKS","03");

			put(EMRBAJG,"02");
			put(EMRBAYYDM,"02");
		}
	};

	// 公用备注信息
	public static final Map<String, String> defaultPubAlias = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(JSYP, " 精神药品代码对应特殊药品字典中的数据 ");
			put(MZYP, " 麻醉药品代码 对应特殊药品字典中的数据 ");
			put(PLJC, " （零售价格-进货价格）/（进货价格）的值 ");
			put(PLJC_ZY, " （零售价格-进货价格）/（进货价格）的值 ");
			put(PLJC_CY, " （零售价格-进货价格）/（进货价格）的值 ");
			// put(JCF, " 检查费归属的收费项目");
			// put(FP_ZLF, " 治疗费归属的收费项目");
			put(ZDJZHXNGH, "就诊号码虚拟工号");
			put(ZDMZHXNGH, "门诊号码虚拟工号");
			put(ZXKZJG, " 中心控制价格 0.中心不控制价格 1.中心控制价格 ");
			put(GHF, "挂号费的收费项目");
			put(YBZLF, "一般诊疗费的收费项目");
			put(ZJF, "专家费的收费项目");
			put(ZLF, "诊疗费的收费项目");
			put(MPI, "1:调用中心平台患者基本信息,0:调用本地患者基本信息。");
			put(SFQYGWXT, "是否启用社区系统 1:启用社区系统,0:不启用社区系统。");
			put(SFQYXNJC, "是否启用社区心脑监测 1:启用,0:不启用。");
			put(GWWEBSERVICE_ADDRESS, "公卫WebService地址");
			// put(YB_ZH_BRXZLIST, "珠海医保用于性质用于控制开放哪些报销");
			put(BASYKSMRZ, "病案首页空时默认值：1.空白、2.无、3.-、4./、其他为：/");
			put(EMRVERSION, "电子病历activeX插件版本号，如:4. 6. 0. 4");
			// put(QYDDDL, "启用单点登录0：不启用 1：启用");
			put(CWFXH, "床位费序号,自动床位费功能使用到");
			put(ZFCWF, "自负床位费序号,自动床位费功能使用到");
			put(ZLFXH, "诊疗费序号,自动床位费功能使用到");
			put(ICUXH, "ICU序号,自动床位费功能使用到");
			// put(SHIYB, "市医保病人性质");
			// put(SHENGYB, "省医保病人性质");
			put(YHYB, "余杭医保病人性质");
			put(QYDZBL, "启用电子病历功能，0：不启用 1：启用，默认启用");
			put(GHFXM, "挂号费对应医疗明细项目编号");
			put(ZJFXM, "专家费对应医疗明细项目编号");
			put(ZLFXM, "诊疗费对应医疗明细项目编号");
			put(BLFXM, "病历费对应医疗明细项目编号");
			put(JIANYANSERVERIP, "检验服务IP地址");
			put(TIJIANSERVERIP, "体检服务IP地址");
			put(YHYBSERVERIP, "余杭医保服务器IP");
			put(YHYBSERVERPORT, "余杭医保服务器端口");
			put(YHYBSERVERSERVLET, "余杭医保Servlet");
			put("CWFZDLJ", "床位费自动累加,1表示自动累加");
			put(ZDZDTJ, "中心调价站点是否自动调价");
			put(MZDCFJE, "门诊大处方金额");
			put(ETLRQLX, "收费日期(SFRQ)(住院统计自动使用JSRQ)、结帐日期(JZRQ)和汇总日期(HZRQ)");
			put(ETLBEGINDATE, "ETL时间段采集数据 开始日期, 例：2014-07-28");
			put(ETLENDDATE, "ETL时间段采集数据 结束日期, 例：2014-07-28");
			put(XZYHDL,
					"0：不限制，允许用户多客户端同时登录 1：限制单用户登录，登录后则不允许其它客户端登录 2：提示是否强制登录，后登录用户会把前一登录用户踢下线");// 限制用户登录
			put(DQGHRQ, "当前挂号日期，挂号初始化使用，不能修改");
			put(DQZBLB, "当前挂号类别，判断上午还是下午，挂号初始化使用，不能修改");
			put(KLX, "01健康卡;02市民卡;03社保卡;04就诊卡;99其他卡。默认04");
			put(SFQYHLYY,"是否启用合理用药 1为启用,0为不启用");
			put(HLYYIP,"合理用药IP");
			put(YBXZ,"医保性质代码");
			put(QYXXXT,"启用消息系统 0:不启用 1:启用,默认不启用");
			put(JCSMFWXM,"家床上门服务项目编码, 默认是0 ,参数格式是 123,345  123和345是对应的FEE_YLSFXM的FYXH,多个费用用,隔开");
			put(ZDTJ,"是否启用自动调价,1是自动调,0是不启用 默认0");
			put(LNHL_JCHL, "老年护理_基础护理");


			put(GHJMSZ, "1:挂号减免，0：挂号不减免");
			put(LSYZSYPCCS, "临时医嘱使用频次参数 ：0：默认乘以SYPC。1：不乘以SYPC");

			put(DPYBSDY, "0 关闭 1开启  门诊病史打印显示代配药字样");
			put(BYQDZXSJ, "摆药QD执行时间(摆药单打印)：默认23:59");
			put(fyxsdf,"1：是;0：不是");

			put("SMJFYS","手麻计费 默认医生");
			put("SMJFKS","手麻计费默认科室");

		}
	};

	/**
	 * 公用所属类别 <item key="01" text="病人档案" /> <item key="02" text="挂号管理" /> <item
	 * key="03" text="收费管理" /> <item key="04" text="门诊诊疗" /> <item key="05"
	 * text="药房管理" /> <item key="06" text="药库管理" /> <item key="07" text="住院管理"
	 * /> <item key="08" text="病区管理" /> <item key="09" text="医技管理" /> <item
	 * key="10" text="物资管理" /> <item key="11" text="电子病历" /><item key="12"
	 * text="处方点评" /> <item key="13" text="抗菌药物" /> <item key="14" text="皮试管理"
	 * /><item key="15" text="家床管理"/>
	 */
	public static final Map<String, String> defaultPubCategory = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(KSDM_TJ, "04");
			put(MZFPMXSL, "03");
			put(SFSFXZKS, "03");
			put(FPYL, "03");
			put(FP_ZLF, "03");
			put(JCF, "03");
			put(MZFPMXSL, "03");

			put(JSYP, "05,06");// 精神药品代码对应特殊药品字典中的数据
			put(MZYP, "05,06");// 麻醉药品代码 对应特殊药品字典中的数据
			put(PLJC, "06");// （零售价格-进货价格）/（进货价格）的值
			put(PLJC_ZY, "06");// （零售价格-进货价格）/（进货价格）的值
			put(PLJC_CY, "06");// （零售价格-进货价格）/（进货价格）的值
			// put(JCF, " 检查费归属的收费项目");
			// put(FP_ZLF, " 治疗费归属的收费项目");
			put(ZDJZHXNGH, "02,03,04");// 就诊号码虚拟工号
			put(ZDMZHXNGH, "01");// 门诊号码虚拟工号
			put(ZXKZJG, "06");// 中心控制价格 0.中心不控制价格 1.中心控制价格
			put(GHF, "02");// 挂号费的收费项目
			put(YBZLF, "02");// 一般诊疗费的收费项目
			put(ZJF, "02");// 专家费的收费项目
			put(ZLF, "02");// 诊疗费的收费项目
			put(MPI, "01");// 1:调用中心平台患者基本信息,0:调用本地患者基本信息。
			put(SFQYGWXT, "04");// 是否启用社区系统 1:启用社区系统,0:不启用社区系统。
			put(SFQYXNJC, "04");// 是否启用社区心脑监测 1:启用,0:不启用。
			put(GWWEBSERVICE_ADDRESS, "");// 公卫WebService地址
			// put(YB_ZH_BRXZLIST, "");//珠海医保用于性质用于控制开放哪些报销
			put(BASYKSMRZ, "11");// 病案首页空时默认值：1.空白、2.无、3.-、4./、其他为：/
			put(EMRVERSION, "11");// 电子病历activeX插件版本号，如:2. 3. 0. 2
			// put(QYDDDL, "启用单点登录0：不启用 1：启用");
			put(CWFXH, "07,08");// 床位费序号
			put(ZFCWF, "07,08");// 自负床位费序号
			put(ZLFXH, "07,08");// 诊疗费序号
			put(ICUXH, "07,08");// ICU序号
			// put(SHIYB, "市医保病人性质");
			// put(SHENGYB, "省医保病人性质");
			put(YHYB, "");// 余杭医保病人性质
			put(QYDZBL, "11");// 启用电子病历功能，0：不启用 1：启用，默认启用
			put(GHFXM, "02");// 挂号费对应医疗明细项目编号
			put(ZJFXM, "02");// 专家费对应医疗明细项目编号
			put(ZLFXM, "02");// 诊疗费对应医疗明细项目编号
			put(BLFXM, "02");// 病历费对应医疗明细项目编号
			put(JIANYANSERVERIP, "");// 检验服务IP地址
			put(TIJIANSERVERIP, "");// 体检服务IP地址
			put(YHYBSERVERIP, "");// 余杭医保服务器IP
			put(YHYBSERVERPORT, "");// 余杭医保服务器端口
			put(YHYBSERVERSERVLET, "");// 余杭医保Servlet
			put("CWFZDLJ", "07,08");// 床位费自动累加,1表示自动累加
			put(ZDZDTJ, "06");// 中心调价站点是否自动调价
			put(MZDCFJE, "03,04");// 门诊大处方金额
			put(ETLRQLX, "07");// 收费日期(SFRQ)(住院统计自动使用JSRQ)、结帐日期(JZRQ)和汇总日期(HZRQ)
			put(DQGHRQ, "02");// 当前挂号日期，挂号初始化使用，不能修改
			put(DQZBLB, "02");// 当前挂号类别，判断上午还是下午，挂号初始化使用，不能修改
			put(SFQYHLYY,"04,08");
			put(HLYYIP,"04,08");
			put(YBXZ,"02,03,07");//医保性质代码
			put(JCSMFWXM,"15");
			put(ZDTJ,"06");
			put(LNHL_JCHL,"03,04");

			put("SMJFYS","03");
			put("SMJFKS","03");
		}
	};

}
