package com.codel.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门名称
     */
    private String name;

    @TableField("parentId")
    private Integer parentid;

    @TableField("depPath")
    private String deppath;

    private Boolean enabled;

    @TableField("isParent")
    private Boolean isparent;


}
