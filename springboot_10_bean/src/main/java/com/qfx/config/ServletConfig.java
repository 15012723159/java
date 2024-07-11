package com.qfx.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data
@ConfigurationProperties(prefix = "servers")
public class ServletConfig {
    private String ipAddr;

    private int port;

    private int timeOut;
}
