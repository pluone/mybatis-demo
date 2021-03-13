package org.example.simple;

import org.apache.ibatis.session.SqlSession;
import org.example.simple.mapper.RoleMapper;
import org.example.simple.model.SysPrivilege;
import org.example.simple.model.SysRole;
import org.junit.Assert;
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

    @Test
    public void testUpdateById(){
        //获取 sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取 RoleMapper 接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //由于数据库数据 enable 都是 1，所以我们给其中一个角色的 enable 赋值为 0
            SysRole role = roleMapper.selectById(2L);
            Assert.assertEquals(SysRole.EnabledStateEnum.ENABLED, role.getEnabled());
            role.setEnabled(SysRole.EnabledStateEnum.DISABLED);
            roleMapper.updateById(role);
        } finally {
            sqlSession.rollback();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
}
