package com.wl.ssyx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wl.ssyx.model.acl.Role;
import com.wl.ssyx.vo.acl.RoleQueryVo;

import java.util.Map;

public interface RoleService extends IService<Role> {

    IPage<Role> selectRolePage(Page<Role> page, RoleQueryVo roleQueryVo);


    void saveAdminRole(Long adminId, Long[] roleId);

    Map<String, Object> getRoleByAdminId(Long adminId);
}
