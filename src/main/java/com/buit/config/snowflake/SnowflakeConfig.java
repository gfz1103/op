package com.buit.config.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author sunjx
 * @Date 2020.05.27 14:34
 **/
@Configuration
public class SnowflakeConfig {

    @Value("${snowflake.work-id:1}")
    private Integer workId;

    @Value("${snowflake.data-id:1}")
    private Integer dataId;

    @Bean
    public Snowflake snowflake(){
        return IdUtil.createSnowflake(workId, dataId);
    }
}
