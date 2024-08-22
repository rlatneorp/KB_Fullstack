package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:/application.properties"})
@MapperScan(basePackages = {"org.scoula.mapper"})
public class RootConfig {
    //application.properties 파일에서 값을 읽어와서 변수에 주입.
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") private String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // 설정 객체에 데이터베이스 연결 경로를 설정.
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        // HikariDataSource객체 생성 후 설정을 적용.
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //  SqlSessionFactoryBean 객체 생성
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        // mybatis 설정 파일 위치.
        sqlSessionFactory.setConfigLocation(
            applicationContext.getResource("classpath:/mybatis-config.xml"));

        // dataSource 설정.
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        // DataSourceTransactionManager 객체 생성
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
    return manager;
    }
}
