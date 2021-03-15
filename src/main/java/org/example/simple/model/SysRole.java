package org.example.simple.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 有效标志
     */
    private EnabledStateEnum enabled;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;

    private SysUser user;

    private List<SysPrivilege> privilegeList;

    public enum EnabledStateEnum {
        DISABLED(0),
        ENABLED(1),
        ;

        private int state;

        EnabledStateEnum(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}
