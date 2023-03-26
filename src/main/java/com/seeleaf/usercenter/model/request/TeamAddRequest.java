package com.seeleaf.usercenter.model.request;

import com.seeleaf.usercenter.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 队伍查询包装类
 */
@Data
public class TeamAddRequest implements Serializable {

    private static final long serialVersionUID = 8323506692432429958L;
    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 创建人id
     */
    private Long userId;

    /**
     * 状态：0-公开，1-私有，2-加密
     */
    private Integer status;

    private String password;




}
