package com.wl.ssyx.product.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.ssyx.model.product.SkuInfo;
import com.wl.ssyx.mq.constants.MqConst;
import com.wl.ssyx.mq.service.RabbitService;
import com.wl.ssyx.product.mapper.SkuInfoMapper;
import com.wl.ssyx.product.service.SkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wl.ssyx.vo.product.SkuInfoVo;
import com.wl.ssyx.vo.product.SkuStockLockVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author wl
 * @since 2023-10-27
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {
    @Resource
    private RabbitService rabbitService;

    public void publish(Long skuId,Integer status){
        if(status == 1)
        {
            SkuInfo skuInfo = baseMapper.selectById(skuId);
            skuInfo.setPublishStatus(status);
            baseMapper.updateById(skuInfo);
            rabbitService.sendDelayMessage(
                    MqConst.EXCHANGE_GOODS_DIRECT,
                    MqConst.ROUTING_GOODS_UPPER,
                    skuId,
                    1);
        }
    }
    @Override
    public SkuInfoVo getSkuInfoVo(Long skuId) {
        return null;
    }

    @Override
    public List<SkuInfo> findSkuInfoList(List<Long> skuIdList) {
        return null;
    }

    @Override
    public List<SkuInfo> findSkuInfoByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<SkuInfo> findNewPersonSkuInfoList() {

        Page<SkuInfo> pageParam = new Page<>(1,3);

        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SkuInfo::getIsNewPerson,1);
        wrapper.eq(SkuInfo::getPublishStatus,1);
        wrapper.orderByDesc(SkuInfo::getStock);

        IPage<SkuInfo> skuInfoIPage = baseMapper.selectPage(pageParam,wrapper);
        List<SkuInfo> skuInfoList = skuInfoIPage.getRecords();

        return skuInfoList;
    }

    @Override
    public Boolean checkAndLock(List<SkuStockLockVo> skuStockLockVoList, String orderNo) {
        return null;
    }
}
