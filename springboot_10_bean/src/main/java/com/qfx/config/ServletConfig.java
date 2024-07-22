package com.qfx.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;



//@Component
@Data
@ConfigurationProperties(prefix = "servers")
@Validated
public class ServletConfig {
    private String ipAddr;

    @Max(value = 65535,message = "最大值不能超过65535")
    @Min(value = 80,message = "最小值不能小于80")
    private int port;

    private int timeOut;

    @DurationUnit(ChronoUnit.MINUTES)
    private Duration connectTimeOut;

    @DataSizeUnit(DataUnit.GIGABYTES)
    private DataSize dataSize;
}
