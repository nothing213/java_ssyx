package com.wl.ssyx.home.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface HomeService  {


    Map<String, Object> homeData(Long userId);
}
