package com.sh.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2021/1/26.
 */
@Component
@PropertySource("classpath:application.yml")//制定读取配置文件的路径
@ConfigurationProperties(prefix = "spring.redis")
public class RedisDTO {
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.password}")
    private String password;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
