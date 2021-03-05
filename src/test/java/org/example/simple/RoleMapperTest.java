package org.example.simple;

import org.apache.ibatis.session.SqlSession;
import org.example.simple.mapper.RoleMapper;
import org.example.simple.model.SysPrivilege;
import org.example.simple.model.SysRole;
import org.junit.Test;

import java.util.List;

public class RoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAllRoleAndPrivileges() {
        //获取 sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取 RoleMapper 接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectAllRoleAndPrivileges();
            for (SysRole role : roleList) {
                System.out.println("角色名：" + role.getRoleName());
                for (SysPrivilege privilege : role.getPrivilegeList()) {
                    System.out.println("权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }


}
