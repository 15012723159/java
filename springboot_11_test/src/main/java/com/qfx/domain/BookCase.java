package com.qfx.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private String name;

    private String description;

    private String type;
}
