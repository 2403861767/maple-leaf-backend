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
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = -2885529868009180522L;
    private Long id;
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
    private Date expireTime;

    /**
     * 状态：0-公开，1-私有，2-加密
     */
    private Integer status;

    private String password;


}
