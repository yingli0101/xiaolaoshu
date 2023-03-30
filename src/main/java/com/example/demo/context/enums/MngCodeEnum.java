package com.example.demo.context.enums;

import lombok.Getter;

/**
 * 常量类
 */
@Getter
public enum MngCodeEnum {

    USER_ALL("user_all", "查询所有", false),
    USER_SINGLE("user_single", "查询单个", false);

    MngCodeEnum(String name, String desc, boolean isTran) {
        this.name = name;
        this.desc = desc;
        this.isTran = isTran;
    }

    private final String name;
    private final String desc;
    private final boolean isTran;

    public static MngCodeEnum getMngCodeByCode(String name) {
        for (MngCodeEnum value : MngCodeEnum.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return MngCodeEnum.USER_ALL;
    }
}
