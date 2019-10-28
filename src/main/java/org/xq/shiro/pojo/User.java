package org.xq.shiro.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Data
public class User {

    private int id;
    private String name;
    private String password;
}
