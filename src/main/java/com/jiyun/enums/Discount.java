package com.jiyun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Discount {

    VETERAN("국가 유공자", 10),
    MILITARY("군인", 5),
    STUDENT("학생", 3),
    DEFAULT("일반", 0);

    private final String name;
    private final int percent;

    public static void print() {
        for (int i = 0; i < values().length; i++) {
            System.out.println(i + 1 + ". " + values()[i].name + ": " + values()[i].percent + "%");
        }
    }

}
