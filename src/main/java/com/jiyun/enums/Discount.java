package com.jiyun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Discount {

    VETERAN(10), // 국가 유공자
    MILITARY(5), // 군인
    STUDENT(3), //학생
    DEFAULT(0); // 일반

    private final int percent;

}
