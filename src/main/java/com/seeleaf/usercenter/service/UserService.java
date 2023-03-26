package com.seeleaf.usercenter.service;

import com.seeleaf.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seeleaf.usercenter.model.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.seeleaf.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.seeleaf.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 * @author seeleaf
 */
public interface UserService extends IService<User> {





    /***
     *  注册接口
     * @param userAccount   用户账户
     * @param userPassword  登入密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return 新用户的id
     */
    long UserRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 登录接口
     * @param userAccount 用户账户
     * @param userPassword 登入密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
    /**
     * 用户脱敏
     * @param originUser 原用户对象
     * @return 安全用户
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);
    List<User> searchUsersByTagsBySQL(List<String> tagNameList);



    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前用户登录信息
     * @return
     */
    User getLoginUser(HttpServletRequest request);
    /**
     * 是否为管理员
     * @param request 发送的请求
     * @return 是否允许
     */
    boolean isAdmin(HttpServletRequest request);
    /**
     * 是否为管理员
     * @param loginUser 登录的用户
     * @return 是否允许
     */
    boolean isAdmin(User loginUser);

    List<User> matchUsers(long num, User loginUser);
}
