package com.awesome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "testcase.read")
public class ReadCase {
    private Integer id;
    private Integer id2;
    private Integer id3;
    private String type;
    private String name;
    private String description;
}

