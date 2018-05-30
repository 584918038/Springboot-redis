package com.xsh.springboot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfig {
	
	@Bean(name="druid")
	@Primary//将当前连接池作为默认的
	@ConfigurationProperties(prefix="spring.datasource.druid")
	public DataSource createDruid(){
		DataSource ds = DataSourceBuilder.create().type(DruidDataSource.class).build();
		return ds;
	}
}
