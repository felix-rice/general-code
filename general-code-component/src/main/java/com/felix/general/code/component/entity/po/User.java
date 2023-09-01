package com.felix.general.code.component.entity.po;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-03
 */
@Data
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -3269592132397031225L;
    private Long id;
    private String userId;
    private String userName;
    private String email;
    private Integer age;
    private Long createTime;
    private Long updateTime;
}
