package org.example.simple.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.example.simple.model.SysRole;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义TypeHandler，用于处理EnabledStateEnum类型
 */
public class EnabledTypeHandler implements TypeHandler<SysRole.EnabledStateEnum> {
    private final Map<Integer, SysRole.EnabledStateEnum> map = new HashMap<>();

    public EnabledTypeHandler() {
        for (SysRole.EnabledStateEnum stateEnum : SysRole.EnabledStateEnum.values()) {
            map.put(stateEnum.getState(), stateEnum);
        }
    }


    @Override
    public void setParameter(PreparedStatement ps, int i, SysRole.EnabledStateEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getState());
    }

    @Override
    public SysRole.EnabledStateEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return map.get(rs.getInt(columnName));
    }

    @Override
    public SysRole.EnabledStateEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return map.get(rs.getInt(columnIndex));
    }

    @Override
    public SysRole.EnabledStateEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return map.get(cs.getInt(columnIndex));
    }
}
