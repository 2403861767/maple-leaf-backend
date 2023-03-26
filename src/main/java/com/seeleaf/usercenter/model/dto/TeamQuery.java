package com.seeleaf.usercenter.model.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.seeleaf.usercenter.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 队伍查询包装类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeamQuery extends PageRequest {
    private Long id;

    private List<Long>  idList;

    /**
     * 搜索关键词 同时对队伍名称和描述搜索
     */
    private String searchText;
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




}
