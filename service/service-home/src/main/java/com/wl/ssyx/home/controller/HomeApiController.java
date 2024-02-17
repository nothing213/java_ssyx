package com.wl.ssyx.home.controller;

import com.wl.ssyx.common.auth.AuthContextHolder;
import com.wl.ssyx.common.result.Result;
import com.wl.ssyx.home.service.HomeService;
import com.wl.ssyx.model.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.beans.binding.ObjectExpression;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "首页")
@RequestMapping("api/home")
@RestController
public class HomeApiController {

    @Resource
    private HomeService homeService;

    @ApiOperation("首页")
    @GetMapping("index")
    public Result index(HttpServletRequest request){

        Long userId = AuthContextHolder.getUserId();
        Map<String, Object> map = homeService.homeData(userId);
        return Result.ok(map);

    }

}
