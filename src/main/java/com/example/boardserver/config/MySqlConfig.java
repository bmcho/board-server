package com.example.boardserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.boardserver.mapper")
public class MySqlConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource mapperResource = new PathMatchingResourcePatternResolver().getResource("classpath:mappers/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperResource);

        Resource configResource = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config");
        sqlSessionFactoryBean.setConfigLocation(configResource);

        return sqlSessionFactoryBean.getObject();
    }

}
