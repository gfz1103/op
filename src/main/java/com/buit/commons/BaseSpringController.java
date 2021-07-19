package com.buit.commons;


import cn.hutool.core.util.StrUtil;
import com.buit.utill.RedisFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;

/**
* @ClassName: BaseSpringController
* @Description: 所有 的基础类
* @author 神算子
* @date 2020年4月26日 下午3:34:33
*
 */
public abstract class BaseSpringController extends BaseController{
	static final Logger logger = LoggerFactory.getLogger(BaseSpringController.class);

	/**
	 * 开发环境
	 */
	static final String DEVELOP_ENVIRONMENT = "dev";
	static final String ACTIVE = "spring.profiles.active";

	@Autowired
    private Environment env;
	@Autowired
    private HttpServletRequest request;
	@Autowired
    private RedisFactory redisFactory;

	/**
     * 获取登录用户信息
     */
    public SysUser getUser() {
		String token = request.getHeader("token");
		if(StringUtils.isBlank(token)){
			token = request.getParameter("token");
		}
		String refreshTokenKey = String.format("JWT_TOKEN::%s", token);
		SysUser loginUser=redisFactory.getValue(refreshTokenKey, SysUser.class);


        //方便测试注意后期去掉
//		loginUser.setHospitalId(310112041);
        if (null == loginUser) {
			//如果开发环境 为了测试方便
            if(env.getProperty(ACTIVE).startsWith(DEVELOP_ENVIRONMENT)) {
                loginUser =new SysUser();
                loginUser.setUserId(0);
                loginUser.setUserName("超级管理员");
                loginUser.setHospitalId(310107001);
                loginUser.setGroupId(1);
                loginUser.setDataVersion(1);
                loginUser.setDeptId(14);
                return loginUser;
             }else {
                 throw BaseException.create("ERROR_USER_0000");
             }
        }
        return loginUser;
    }
	/**
	 * 获取请求方IP
	 *
	 * @return 客户端Ip
	 */
	public String getIpAddress(){
		String xff = StrUtil.isEmpty(request.getHeader("REQUEST-IP")) ? request.getParameter("REQUEST-IP") : request.getHeader("REQUEST-IP");
		if (StrUtil.isEmpty(xff)) {
			throw BaseException.create("ERROR_IP_0001");
		}else{
			return xff;
		}
	}

	/**
	 * 获取请求方mac地址
	 * @return mac地址
	 */
	public  String getMac(){
//		StringBuffer sb = new StringBuffer("");
//		try {
//			InetAddress localHost = InetAddress.getLocalHost();
//
//			//获取网卡，获取地址
//			byte[] mac = NetworkInterface.getByInetAddress(localHost).getHardwareAddress();
//			System.out.println("mac数组长度："+mac.length);
//			for(int i=0; i<mac.length; i++) {
//				if(i!=0) {
//					sb.append("-");
//				}
//				//字节转换为整数
//				int temp = mac[i]&0xff;
//				String str = Integer.toHexString(temp);
//				System.out.println("每8位:"+str);
//				if(str.length()==1) {
//					sb.append("0"+str);
//				}else {
//					sb.append(str);
//				}
//			}
//
//		}catch (SocketException e){
//			logger.error("获取ip失败:",e);
//		}catch (UnknownHostException e){
//			logger.error("获取mac失败:",e);
//		}
//		return sb.toString().toUpperCase();

//		String str = null;
//		String mac = null;
//		String ip=getIpAddress();
//		try{
//			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
//			InputStreamReader ir = new InputStreamReader(p.getInputStream(),"gbk");
//			LineNumberReader input = new LineNumberReader(ir);
//			for (; true;) {
//				str = input.readLine();
//				if (str != null) {
//					if (str.indexOf("MAC 地址") > 1) {
//						mac = str.substring(str.indexOf("MAC 地址") + 9);
//						break;
//					}
//				}
//			}
//			System.out.println(mac);
//		}catch(IOException e){
//			e.printStackTrace();
//		}

		return "00:00:00:00";
	}
}
