package com.qfx.service.impl;

import com.qfx.service.ISMSCodeService;
import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class SMSCodeServiceImpl implements ISMSCodeService {
    @Autowired
    private MemcachedClient memcachedClient;
    @Override
    public String getCode(String mobile)  {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }
        String code = sb.toString();
        log.info("code="+code);
        try{
            memcachedClient.set(mobile,0,code);
        }catch (Exception e){
            e.printStackTrace();
        }

        return code;
    }

    @Override
    public Boolean checkCode(String mobile, String code) {
        String memcode = null;
        try{
             memcode = memcachedClient.get(mobile.toString()) ;
             log.info("memcode= "+memcode);
             log.info("code="+code);
        }catch (Exception e){
            e.printStackTrace();
        }


        return code.equals(memcode);
    }

    // 基于redis cahce-simple整合
   /* @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public String getCode(String mobile) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }
        String code = sb.toString();
        stringRedisTemplate.opsForValue().set(mobile,code,300, TimeUnit.SECONDS);
        return code;
    }

    @Override
    public Boolean checkCode(String mobile, String code) {
        String saveCode = stringRedisTemplate.opsForValue().get(mobile);

        return code.equals(saveCode);
    }*/
}
