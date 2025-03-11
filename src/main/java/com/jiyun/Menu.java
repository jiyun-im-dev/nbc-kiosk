package com.jiyun;

import com.jiyun.enums.Category;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();

    @Getter
    private static final Menu menu = new Menu(); // 싱글톤

    // 기본 생성자에서 메뉴를 초기화
    // 싱글톤은 객체를 단 하나만 생성해서 공유해야 하므로 생성자를 private 으로 막음
    private Menu() {
        menuItems.add(new MenuItem(Category.BURGER, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(Category.BURGER, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(Category.BURGER, "Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(Category.BURGER, "Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem(Category.DRINK, "Cola", 2200, "냠냠콜라"));
        menuItems.add(new MenuItem(Category.DRINK, "Zero Cola", 2200, "제로콜라"));
        menuItems.add(new MenuItem(Category.DESSERT, "Chocolate Ice Cream", 2500, "달콤한 초콜릿 아이스크림"));
        menuItems.add(new MenuItem(Category.DESSERT, "Strawberry Ice Cream", 2500, "딸기 시럽이 뿌려진 아이스크림"));
    }

}
