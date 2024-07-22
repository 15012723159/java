package com.qfx;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(properties = {"test.prop=hello world2"})
@Slf4j
@SpringBootTest(args = {"--test.prop=hello world3"})
class Springboot11TestApplicationTests {

    @Value("${test.prop}")
    private String msg;
    @Test
    void contextLoads() {
    }

    @Test
    void testPropertires(){
        log.info("msg="+ msg);
    }
}
