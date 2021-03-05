package org.example.simple.mapper;

import org.example.simple.model.SysRole;

import java.util.List;

public interface RoleMapper {
    SysRole selectRoleById(Long id);

    List<SysRole> selectAllRoleAndPrivileges();

    List<SysRole> selectRoleByUserId(Long userId);
}