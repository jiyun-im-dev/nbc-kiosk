package com.jiyun;

public enum Category {

    BURGER(1),
    DRINK(2),
    DESSERT(3)
    ;

    private final int index;

    Category(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }

}
