package com.seeleaf.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author seeleaf
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3493035409542207024L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
