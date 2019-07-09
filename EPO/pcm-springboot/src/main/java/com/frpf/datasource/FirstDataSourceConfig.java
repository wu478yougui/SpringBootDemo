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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * add by yougui.wu@hand-china.com
 */

@Configuration
@MapperScan(basePackages = "com.frpf.pcm.mapper",sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class FirstDataSourceConfig {

    @Value("${spring.datasource.firstdary.url}")
    private String firstdaryUrl;

    @Value("${spring.datasource.firstdary.username}")
    private String firstdaryUserName;

    @Value("${spring.datasource.firstdary.password}")
    private String firstdaryPassword;

    @Value("${spring.datasource.firstdary.driver-class-name}")
    private String firstdaryDriverClassName;


    //创建数据源
    @Bean(name="firstDataSource")
    @ConfigurationProperties(prefix="spring.datasource.firstdary")
    public DataSource getFirstDataSource(){
        DataSource build = DataSourceBuilder.create()
                .driverClassName(firstdaryDriverClassName)
                .url(firstdaryUrl)
                .username(firstdaryUserName)
                .password(firstdaryPassword).build();
        return build;
    }

    //创建SqlSessionFactory
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    //创建事务管理器
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //创建SqlSessionTemplate
    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception{
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
