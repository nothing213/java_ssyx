package com.wl.ssyx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.ssyx.model.user.User;
import com.wl.ssyx.vo.user.LeaderAddressVo;
import com.wl.ssyx.vo.user.UserLoginVo;

public interface UserService extends IService<User> {
    User getByOpenid(String openId);

    LeaderAddressVo getLeaderAddressVoByUserId(Long id);

    UserLoginVo getUserLoginVo(Long id);
}
