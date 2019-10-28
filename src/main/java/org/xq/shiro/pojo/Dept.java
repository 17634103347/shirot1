package org.xq.shiro.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class Dept implements Serializable {
    private Long did;
    private String dept_name;
}
