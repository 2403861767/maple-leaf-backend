package com.seeleaf.usercenter.model.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * 用户包装类（脱敏）
 */
@Data
public class UserVo {
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
     * role表示用户身份,0表示普通用户,1表示管理员
     */
    private Integer userRole;

    /**
     * 星球编号
     */
    private String planetCode;

//    /**
//     * 用户的标签列表 Json
//     */
//    private String tags;
//
//    /**
//     * 用户个人介绍
//     */
//    private String profile;
}
