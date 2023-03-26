package com.seeleaf.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamJoinRequest implements Serializable {
    private static final long serialVersionUID = 7107954149219101914L;
    private Long teamId;
    private String  password;
}
