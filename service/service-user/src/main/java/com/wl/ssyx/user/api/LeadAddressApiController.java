package com.wl.ssyx.user.api;

import com.wl.ssyx.user.service.UserService;
import com.wl.ssyx.vo.user.LeaderAddressVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RequestMapping("/api/user/leader")
@RestController
public class LeadAddressApiController {

    @Resource
    private UserService userService;

//    @Resource
//    private LeaderService leaderService;

    @ApiOperation("提货点地址信息")
    @GetMapping("/inner/getUserAddressByUserId/{userId}")
    public LeaderAddressVo getUserAddressByUserId(@PathVariable(value = "userId") Long userId) {
        return userService.getLeaderAddressVoByUserId(userId);
    }
}
