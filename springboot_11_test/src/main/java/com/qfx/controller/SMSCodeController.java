package com.qfx.controller;

import com.qfx.service.ISMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms")
public class SMSCodeController {
    @Autowired
    private ISMSCodeService smsCodeService;
    @GetMapping("/getCode/{mobile}")
    public String getCode(@PathVariable String mobile) {
        return smsCodeService.getCode(mobile);
    }

    @GetMapping("/checkCode/{mobile}/{code}")
    public Boolean checkCode(@PathVariable String mobile,@PathVariable String code) {
        return smsCodeService.checkCode(mobile,code);
    }
}
