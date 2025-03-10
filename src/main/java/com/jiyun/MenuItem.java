package com.jiyun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuItem {

    private Category category;
    private String name;
    private Integer price;
    private String description;

    @Override
    public String toString() {
        return name + " | " + price + " | " + description;
    }

}
