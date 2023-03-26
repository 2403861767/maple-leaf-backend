package com.seeleaf.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author seeleaf
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -4956390150714922766L;

    private String userAccount;

    private String userPassword;


}
