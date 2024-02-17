package com.wl.ssyx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.ssyx.acl.service.RoleService;
import com.wl.ssyx.common.result.Result;
import com.wl.ssyx.model.acl.Role;
import com.wl.ssyx.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("角色分页查询")
    @GetMapping("/{current}/{limit}")
    public Result pageList(@PathVariable Long current,
                           @PathVariable Long limit,
                           RoleQueryVo roleQueryVo) {

        Page<Role> page = new Page<>(current,limit);
        IPage<Role> pageModel = roleService.selectRolePage(page,roleQueryVo);

        return Result.ok(pageModel);
  }
    //2 根据id查询角色
   @ApiOperation("根据id查询角色")
   @GetMapping("get/{id}")
   public Result get(@PathVariable Long id){
        Role role = roleService.getById(id);
        return Result.ok(role);
  }
    //3 添加角色
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        boolean is_success = roleService.save(role);
        if(is_success) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    //4 修改角色
    @ApiOperation("修改角色")
    @PutMapping("update")
    public Result update(@RequestBody Role role) {
        roleService.updateById(role);
        return Result.ok(null);
    }

    //5 根据id删除角色
    @ApiOperation("根据id删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        roleService.removeById(id);
        return Result.ok(null);
    }

    //6 批量删除角色
    // json数组[1,2,3]  --- java的list集合
    @ApiOperation("批量删除角色")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        roleService.removeByIds(idList);
        return Result.ok(null);
    }

}
