package org.xq.shiro.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//表示在redis中创建emp的一个hash集合, 存储emp对象数据

@ToString
@Data
public class Emp implements Serializable {
    private Long eid;
    private String ename;
    private String sex;
    private Integer age;
    //输入日期格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //输出日期格式化
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date statdata;
    private Long salary;
    private Long did;
}
