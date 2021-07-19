package com.buit.cis.op.dctwork.ybtspost.xml;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * @Author sunjx
 * @Date 2020-11-03 15:11
 * @Description
 **/
public abstract class YbXmlUtil {

    /**
     * xml to javabean
     */
    public static <T> T toObj(String xml, TypeReference<T> typeReference){
        Map<String, Object> map = cn.hutool.core.util.XmlUtil.xmlToMap(xml);
        JSONObject jsonObject = JSONUtil.parseFromMap(map);
        System.out.println(JSONUtil.toJsonStr(jsonObject));
        return JSONUtil.toBean(jsonObject, typeReference, false);
    }

    /**
     * javabean to xml
     */
    public static String toXml(Object obj, String rootName){
        String xmldata = XmlUtil.mapToXmlStr(JSONUtil.parseObj(obj, false, true), rootName);
        xmldata = xmldata.replaceFirst(" standalone=\"no\"", "").replaceFirst("UTF-8","utf-8").replaceAll("null","");
        return xmldata;
    }

    /**
     * format
     */
    public static String format(String xml){
        return XmlUtil.format(xml).replaceFirst(" standalone=\"no\"", "");
    }
}
