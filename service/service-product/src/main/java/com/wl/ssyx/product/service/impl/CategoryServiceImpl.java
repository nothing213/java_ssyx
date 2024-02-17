package com.wl.ssyx.product.service.impl;


import com.wl.ssyx.model.product.Category;
import com.wl.ssyx.product.mapper.CategoryMapper;
import com.wl.ssyx.product.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author wl
 * @since 2023-10-27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
