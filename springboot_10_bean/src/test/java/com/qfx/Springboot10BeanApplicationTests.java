package com.qfx;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class Springboot10BeanApplicationTests {
    @Value("${servers.ipAddr}")
    private  String msg;

    @Value("${datasource.password}")
    private String password;
    @Test
    void contextLoads() {
        log.info(msg);
        log.info("password="+password);
    }

}
