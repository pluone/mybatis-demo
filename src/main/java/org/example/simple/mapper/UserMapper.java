package org.example.simple.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.simple.model.SysRole;
import org.example.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);

    // 返回主键
    int insert2(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    int deleteById(SysUser sysUser);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
}