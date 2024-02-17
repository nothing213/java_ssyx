package com.wl.ssyx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.ssyx.model.acl.Admin;
import com.wl.ssyx.model.acl.Role;
import com.wl.ssyx.vo.acl.AdminQueryVo;

import java.util.Map;

public interface AdminService  extends IService<Admin> {
    IPage<Admin> selectPageUser(Page<Admin> pageParam, AdminQueryVo adminQueryVo);

}
