package com.buit.utill;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"UTF-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("调用智能提醒返回:{}",resultString);
        } catch (Exception e) {
            logger.info("调用智能提醒失败:",e);
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                logger.info("调用智能提醒失败:",e);
                e.printStackTrace();
            }
        }

        return resultString;
    }


    public static void main(String[] args) {

        Map<String, String> param=new HashMap<>();
        String req="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<YL_ACTIVE_ROOT>\n" +
                "   <CFDDM>3101</CFDDM>\n" +
                "   <ZJHM>41282619981105224x</ZJHM>\n" +
                "   <XM>沈剑豪</XM>\n" +
                "   <XB>2</XB>\n" +
                "   <MZ>汉</MZ>\n" +
                "   <CSRQ>19981105</CSRQ>\n" +
                "   <HYZK>10</HYZK>\n" +
                "   <GDLXDH></GDLXDH>\n" +
                "   <YDLXDH></YDLXDH>\n" +
                "   <HJDZ></HJDZ>\n" +
                "   <JZDZ></JZDZ>\n" +
                "   <KH>F02254329</KH>\n" +
                "   <KLX>0</KLX>\n" +
                "   <YLJGDM>33233986000</YLJGDM>\n" +
                "   <JZLX>100</JZLX>\n" +
                "   <MZH>20210409000010</MZH>\n" +
                "   <ZHH></ZHH>\n" +
                "   <YYKSBM>9009</YYKSBM>\n" +
                "   <YYKSMC>神经内科</YYKSMC>\n" +
                "   <YYYSGH>0115</YYYSGH>\n" +
                "   <YBYSGH></YBYSGH>\n" +
                "   <YSXM>杜梦娟</YSXM>\n" +
                "   <AGENTIP>192.168.1.1</AGENTIP>\n" +
                "   <AGENTMAC>12:12:12:12</AGENTMAC>\n" +
                "   <ZS></ZS>\n" +
                "   <LCBX></LCBX>\n" +
                "   <SSY></SSY>\n" +
                "   <SZY></SZY>\n" +
                "   <SFSCXYYC></SFSCXYYC>\n" +
                "</YL_ACTIVE_ROOT>";
        param.put("req",req);
        String s = doPost("http://172.22.145.160:9000/basy/ybzntx", param);
        System.out.println(s);
    }

}
