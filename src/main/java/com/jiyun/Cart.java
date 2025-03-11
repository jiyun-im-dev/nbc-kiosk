package com.jiyun;

import com.jiyun.enums.Discount;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private static final Map<MenuItem, Integer> items = new HashMap<>(); // 키: MenuItem, 값: 수량

    @Getter
    private static final Cart cart = new Cart(); // 싱글톤

    // 싱글톤은 객체를 단 하나만 생성해서 공유해야 하므로 생성자를 private 으로 막음
    private Cart() {}

    public int calculateTotal() {
        int total = 0;
        for (Map.Entry<MenuItem, Integer> item : items.entrySet()) {
            total += item.getKey().getPrice() * item.getValue(); // 가격 * 수량
        }
        return total;
    }

    public int calculateTotalWithDiscount(Discount discount) {
        int total = 0;
        for (Map.Entry<MenuItem, Integer> item : items.entrySet()) {
            total += item.getKey().getPrice() * item.getValue(); // 가격 * 수량
        }
        total -= total / 100 * discount.getPercent();
        return total;
    }

    public void add(MenuItem item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1); // 수량에 1을 더해서 저장
        } else {
            items.put(item, 1);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void print() {
        for (MenuItem menuItem : items.keySet()) {
            System.out.println(items.get(menuItem) + "개 | " + menuItem);
        }
    }

    public void clear() {
        items.clear();
    }

}
