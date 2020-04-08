package com.cyzs.springbootmybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: xh
 * @create: 2020-04-08 15:42
 */
@Configuration
public class DruidConfig {

    /**ConfigurationProperties必须要加上，不然application配置文件的配置用不上*/
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource()throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        //初始化连接池数量
        druidDataSource.setInitialSize(5);
        //最小连接池数量，这个不起效果
        druidDataSource.setMinIdle(5);
        //最大连接池数量
        druidDataSource.setMaxActive(20);
        //最长等待5000秒
        druidDataSource.setMaxWait(5000);
        //检测需要关闭的空闲连接
        druidDataSource.setTimeBetweenEvictionRunsMillis(50000);
        //连接最短生存时间
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //配置扩展插件，stat监控统计，wall防SQL注入
        druidDataSource.setFilters("stat,wall");
        //慢日志记录
        Properties properties = new Properties();
        properties.setProperty("druid.stat.mergeSql", "true");
        properties.setProperty("druid.stat.slowSqlMillis", "5000");
        druidDataSource.setConnectProperties(properties);
        //合并多个DruidDataSource的数据
        druidDataSource.setUseGlobalDataSourceStat(true);
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), new String[]{"/druid/*"});
        Map<String, String> map = new HashMap();
        map.put("loginUsername", "root");
        map.put("loginPassword", "123456");
        map.put("allow", "");
        map.put("deny", "192.168.9.1");
        bean.setInitParameters(map);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> map = new HashMap();
        map.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
