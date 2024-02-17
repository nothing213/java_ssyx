package com.wl.ssyx.home.service.Impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wl.ssyx.client.product.ProductFeignClient;
import com.wl.ssyx.client.user.UserFeignClient;
import com.wl.ssyx.common.result.Result;
import com.wl.ssyx.home.service.HomeService;
import com.wl.ssyx.model.product.Category;
import com.wl.ssyx.model.product.SkuInfo;
import com.wl.ssyx.vo.user.LeaderAddressVo;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {
    Map<String, Object> map = new HashMap<>();

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private ProductFeignClient productFeignClient;

    @Override
    public Map<String, Object> homeData(Long userId) {
        LeaderAddressVo userAddressByUserId = userFeignClient.getUserAddressByUserId(userId);
        map.put("userAddressByUserId",userAddressByUserId);

        List<Category> allCategoryList = productFeignClient.findAllCategoryList();
        map.put("allCategoryList",allCategoryList);

        List<SkuInfo> newPersonSkuInfoList = productFeignClient.findNewPersonSkuInfoList();
        map.put("newPersonSkuInfoList",newPersonSkuInfoList);

        return map;
    }
}
