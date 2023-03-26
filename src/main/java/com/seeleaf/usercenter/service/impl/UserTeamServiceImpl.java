package com.seeleaf.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seeleaf.usercenter.model.domain.UserTeam;
import com.seeleaf.usercenter.service.UserTeamService;
import com.seeleaf.usercenter.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【user_team(用户队伍关系表)】的数据库操作Service实现
* @createDate 2023-03-10 16:41:30
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




