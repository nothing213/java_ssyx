package com.wl.ssyx.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.ssyx.model.product.SkuInfo;
import com.wl.ssyx.vo.product.SkuInfoVo;
import com.wl.ssyx.vo.product.SkuStockLockVo;

import java.util.List;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author wl
 * @since 2023-10-27
 */
public interface SkuInfoService extends IService<SkuInfo> {

    SkuInfoVo getSkuInfoVo(Long skuId);

    List<SkuInfo> findSkuInfoList(List<Long> skuIdList);

    List<SkuInfo> findSkuInfoByKeyword(String keyword);

    List<SkuInfo> findNewPersonSkuInfoList();

    Boolean checkAndLock(List<SkuStockLockVo> skuStockLockVoList, String orderNo);
}
