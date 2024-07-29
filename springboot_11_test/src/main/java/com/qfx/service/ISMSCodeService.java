package com.qfx.service;

import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.concurrent.TimeoutException;

public interface ISMSCodeService {

    public String getCode(String mobile);

    public Boolean checkCode(String mobile, String code);
}
