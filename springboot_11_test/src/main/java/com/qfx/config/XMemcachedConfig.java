package com.qfx.config;

import com.qfx.domain.MemCache;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configuration
public class XMemcachedConfig {
  /*  @Autowired
    private XMemcachedClient xMemcachedClient;*/
    @Autowired
    private MemCache memCache;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(memCache.getHost()+":"+memCache.getPort());
        MemcachedClient memcachedClient  = memcachedClientBuilder.build();
        return memcachedClient;
    }
}
