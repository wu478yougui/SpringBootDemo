package com.frpf.datasource;

/**
 * Created by WuYouGui on 2019/7/9.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * add by yougui.wu@hand-china.com
 */
@Configuration
@MapperScan(basePackages = "com.frpf.om.mapper",sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class SecondDataSourceConfig {

    @Value("${spring.datasource.secondary.url}")
    private String secondaryUrl;

    @Value("${spring.datasource.secondary.username}")
    private String secondaryUserName;

    @Value("${spring.datasource.secondary.password}")
    private String secondaryPassword;

    @Value("${spring.datasource.secondary.driver-class-name}")
    private String secondaryDriverClassName;

    //创建数据源
    @Bean(name="secondDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    @Primary
    public DataSource getSecondDataSource(){
        DataSource build = DataSourceBuilder.create()
                .driverClassName(secondaryDriverClassName)
                .url(secondaryUrl)
                .username(secondaryUserName)
                .password(secondaryPassword).build();
        return build;
    }

    //创建SqlSessionFactory
    @Bean(name = "secondSqlSessionFactory")
    @Primary
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    //创建事务管理器
    @Bean(name = "secondTransactionManager")
    @Primary
    public DataSourceTransactionManager secondTransactionManager(@Qualifier("secondDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //创建SqlSessionTemplate
    @Bean(name = "secondSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    private Class getType(String type){
        try {
            return Class.forName(type);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
