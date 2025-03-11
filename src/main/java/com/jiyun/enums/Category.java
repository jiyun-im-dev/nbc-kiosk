package com.jiyun.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    BURGER(1),
    DRINK(2),
    DESSERT(3);

    private final int index;

}
