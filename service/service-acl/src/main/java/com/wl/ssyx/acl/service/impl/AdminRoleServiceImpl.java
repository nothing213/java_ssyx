package com.wl.ssyx.acl.service.impl;

import com.wl.ssyx.acl.mapper.AdminRoleMapper;
import com.wl.ssyx.acl.service.AdminRoleService;
import com.wl.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
