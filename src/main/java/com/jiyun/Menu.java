package com.jiyun;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Menu {

    private final List<String> categories = new ArrayList<>();
    private final ArrayList<MenuItem> burgers = new ArrayList<>();
    private final ArrayList<MenuItem> drinks = new ArrayList<>();
    private final ArrayList<MenuItem> desserts = new ArrayList<>();

    // 기본 생성자에서 메뉴를 초기화
    public Menu() {
        categories.add("Burgers");
        categories.add("Drinks");
        categories.add("Desserts");
        burgers.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        drinks.add(new MenuItem("Cola", 2200, "냠냠콜라"));
        drinks.add(new MenuItem("Zero Cola", 2200, "제로콜라"));
        desserts.add(new MenuItem("Chocolate Ice Cream", 2500, "달콤한 초콜릿 아이스크림"));
        desserts.add(new MenuItem("Strawberry Ice Cream", 2500, "딸기 시럽이 뿌려진 아이스크림"));
    }

}
