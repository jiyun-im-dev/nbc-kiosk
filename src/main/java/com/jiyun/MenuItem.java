package com.jiyun;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuItem {

    private String name;
    private Integer price;
    private String description;

    @Override
    public String toString() {
        return name + " | " + price + " | " + description;
    }

}
