package com.codel.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//如果要配置新的数据源属性，这个配置类就要使用

// 重新配置包里面的数据的时候，就要重新配置包里面的配置类，然后返回bean，也就是更新包里面的组件
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDruid() {
        return new DruidDataSource();
    }
}
