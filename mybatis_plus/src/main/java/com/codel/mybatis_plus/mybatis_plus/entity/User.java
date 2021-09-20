package com.codel.mybatis_plus.mybatis_plus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private int id;

    private String name;

    private String password;
    private String email;


}
