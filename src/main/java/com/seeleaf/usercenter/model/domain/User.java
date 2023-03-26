package com.seeleaf.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private long id;

    /**
     * 昵称

     */
    private String username;

    /**
     * 登入账号

     */
    private String userAccount;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户头像

     */
    private String avatarUrl;

    /**
     * 密码

     */
    private String userPassword;

    /**
     * 电话

     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 表示用户状态

     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * role表示用户身份,0表示普通用户,1表示管理员
     */
    private Integer userRole;

    /**
     * 星球编号
     */
    private String planetCode;

    /**
     * 用户的标签列表 Json
     */
    private String tags;

    /**
     * 用户个人介绍
     */
    private String profile;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}