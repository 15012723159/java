package com.qfx.service;

public interface ISMSCodeService {

    public String getCode(String mobile);

    public Boolean checkCode(String mobile, String code);
}
