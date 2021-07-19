package com.buit.utill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HisUtil {

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
        return matter.format(date);
    }

    public static final Map<String,Object> upcaseKeys(Map<String,Object> src){
        Map<String,Object> target=new HashMap<String, Object>(src.size());
        for(Iterator<String> it = src.keySet().iterator(); it.hasNext();){
            String key=it.next();
            target.put(key.toUpperCase(), src.get(key));
        }
        return target;
    }
    /**
     * 获取指定格式的日期
     *
     * @param format
     * @return
     */
    public static String getDate(String format,Date date) {
        SimpleDateFormat matter = new SimpleDateFormat(format);
        return matter.format(date);
    }

}
