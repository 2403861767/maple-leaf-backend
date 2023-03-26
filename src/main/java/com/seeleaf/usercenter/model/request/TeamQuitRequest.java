package com.seeleaf.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍
 *
 * @author seeleaf
 */
@Data
public class TeamQuitRequest implements Serializable {
    private static final long serialVersionUID = 7107954149219101914L;
    private Long teamId;
}
