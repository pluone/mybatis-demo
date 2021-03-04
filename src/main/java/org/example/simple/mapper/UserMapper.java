package org.example.simple.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.simple.model.SysRole;
import org.example.simple.model.SysUser;

import java.util.List;
import java.util.Map;

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

    // 动态SQL, 通过where和if动态拼装查询条件
    List<SysUser> selectByUser(SysUser sysUser);

    int updateByIdSelective(SysUser sysUser);

    // 使用ID或者userName查询用户，使用choose,when,otherwise拼装SQL
    SysUser selectByIdOrUserName(SysUser sysUser);

    List<SysUser> selectByIdList(List<Long> idList);

    int insertList(List<SysUser> userList);

    int updateByMap(Map<String,Object> map);
}