package com.qfx;

import com.alibaba.druid.pool.DruidDataSource;
import com.qfx.config.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServletConfig.class)
public class Springboot10BeanApplication {
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
    public static void main(String[] args) {
     ConfigurableApplicationContext ctx =  SpringApplication.run(Springboot10BeanApplication.class, args);
      ServletConfig sevlet =   ctx.getBean(ServletConfig.class);
      System.out.println(sevlet.toString());

        DruidDataSource druidDataSource =  ctx.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getDriverClassName());
    }

}
