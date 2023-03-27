package com.example.tools.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
/*
@Configuration
public class RedisConfig {

    @Value("${spring.redis.r1.host}")
    private String r1Host;
    @Value("${spring.redis.r1.port}")
    private String r1Port;
    @Value("${spring.redis.r1.password}")
    private String r1Password;
    @Value("${spring.redis.r1.timeout}")
    private String r1Timeout;


    @Bean("r1RedisTemplate")
    public RedisTemplate<String,String> getR1RedisTemplate(){
        return build(r1Host,r1Port,r1Password,r1Timeout);
    }
    @Value("${spring.redis.r2.host}")
    private String r2Host;
    @Value("${spring.redis.r2.port}")
    private String r2Port;
    @Value("${spring.redis.r2.password}")
    private String r2Password;
    @Value("${spring.redis.r2.timeout}")
    private String r2Timeout;

    @Bean("r2RedisTemplate")
    public RedisTemplate<String,String> getR2RedisTemplate(){
        return build(r2Host,r2Port,r2Password,r2Timeout);
    }


    private RedisTemplate<String,String> build(String host,String port,String password,String timeout){
        //单机部署
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host,Integer.parseInt(port));
        redisStandaloneConfiguration.setPassword(password);
        //集群部署
        //RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(Arrays.asList(commonHost.split(";")));
        //redisClusterConfiguration.setPassword(commonPassword);
        LettucePoolingClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(Long.parseLong(timeout)))
                .poolConfig(new GenericObjectPoolConfig())
                .build();
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration,clientConfig);
        //必须初始化实例
        connectionFactory.afterPropertiesSet();
        //如果要使pool参数生效,一定要关闭shareNativeConnection
        //lettuceConnectionFactory.setShareNativeConnection(false);

        RedisTemplate<String, String> commonRedisTemplate = new StringRedisTemplate();
        commonRedisTemplate.setConnectionFactory(connectionFactory);
        // key、hash的key 采用 String序列化方式 【可自行配置】
        commonRedisTemplate.setKeySerializer(new StringRedisSerializer());
        commonRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // value、hash的value 采用 String 序列化方式
        commonRedisTemplate.setValueSerializer(new StringRedisSerializer());
        commonRedisTemplate.setHashValueSerializer(new StringRedisSerializer());
        commonRedisTemplate.afterPropertiesSet();
        return commonRedisTemplate;
    }

}
 */