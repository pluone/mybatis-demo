package org.example.simple.mapper;

import org.example.simple.model.SysPrivilege;

import java.util.List;

public interface PrivilegeMapper {
    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}