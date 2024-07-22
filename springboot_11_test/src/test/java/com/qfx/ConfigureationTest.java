package com.qfx;

import com.qfx.config.MsgConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MsgConfig.class})
@Slf4j
public class ConfigureationTest {

    @Autowired
    private String msg;
    @Test
    void TestMsg(){
        log.info(msg);
    }
}
