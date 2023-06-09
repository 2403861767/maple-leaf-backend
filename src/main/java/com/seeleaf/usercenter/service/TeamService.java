package com.seeleaf.usercenter.service;

import com.seeleaf.usercenter.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seeleaf.usercenter.model.domain.User;
import com.seeleaf.usercenter.model.dto.TeamQuery;
import com.seeleaf.usercenter.model.request.TeamJoinRequest;
import com.seeleaf.usercenter.model.request.TeamQuitRequest;
import com.seeleaf.usercenter.model.request.TeamUpdateRequest;
import com.seeleaf.usercenter.model.vo.TeamUserVo;

import java.util.List;

/**
* @author 24038
* @description 针对表【team(队伍表)】的数据库操作Service
* @createDate 2023-03-10 16:39:55
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     * @param team
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVo> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 队长解散（删除）队伍
     * @param teamId
     * @return
     */
    boolean deleteTeam(long teamId, User loginUser);
}
