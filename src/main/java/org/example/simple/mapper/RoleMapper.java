package org.example.simple.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;
import org.example.simple.model.SysRole;

import java.util.List;

@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    @Select({"select id,role_name roleName, enabled, create_by createBy, create_time createTime",
            "from sys_role",
            "where id = #{id}"})
    SysRole selectById(Long id);

    SysRole selectRoleById(Long id);

    List<SysRole> selectAllRoleAndPrivileges();

    List<SysRole> selectRoleByUserId(Long userId);

//    @Update({"update sys_role",
//            "set role_name = #{roleName},",
//            "enabled = #{enabled},",
//            "create_by = #{createBy},",
//            "create_time = #{createTime, jdbcType=TIMESTAMP}",
//            "where id = #{id}"
//    })
    int updateById(SysRole sysRole);

    @ResultMap("roleMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    List<SysRole> selectAll(RowBounds rowBounds);
}