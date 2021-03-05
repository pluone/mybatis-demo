package org.example.simple.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPrivilege {
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
}
