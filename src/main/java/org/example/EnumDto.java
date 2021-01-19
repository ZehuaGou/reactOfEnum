package org.example;

import lombok.Data;

/**
 * 包含枚举各常量实例信息的实体类
 */
@Data
public class EnumDto {
    /**
     * 编号
     */
    private Integer code;

    /**
     * 详细信息
     */
    private String desc;
}
