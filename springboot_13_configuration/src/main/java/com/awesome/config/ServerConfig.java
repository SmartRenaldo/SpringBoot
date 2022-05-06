package com.awesome.config;

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

@Data
//@Component
@ConfigurationProperties(prefix = "servers")
//2. open bean properties check
@Validated
public class ServerConfig {
    @Max(value = 8848, message = "The max value cannot exceed 8848")
    @Min(value = 222, message = "The min value cannot be less than 222")
    private int port;
    private String ipAddress;
    private long timeout;

    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeout;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
