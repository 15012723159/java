package com.qfx.service.impl;

import com.qfx.service.ISMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements ISMSCodeService {

    @Autowired
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
    }
}
