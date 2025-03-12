package com.jiyun;

import com.jiyun.enums.Category;
import com.jiyun.enums.Discount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Cart cart = Cart.getCart();

    @Test()
    @DisplayName("할인된 가격 계산")
    void calculateDiscount() {
        // given
        MenuItem menuitem1 = new MenuItem(Category.BURGER, "test1", 5000, "burger");
        MenuItem menuitem2 = new MenuItem(Category.DRINK, "test2", 2000, "drink");
        cart.add(menuitem1);
        cart.add(menuitem2);

        // when
        int priceVeteran = cart.calculateTotalWithDiscount(Discount.VETERAN);// 국가 유공자는 10퍼센트 할인
        int priceStudent = cart.calculateTotalWithDiscount(Discount.STUDENT);// 학생은 3퍼센트 할인

        // then
        assertEquals((5000 + 2000) * 0.9, priceVeteran);
        assertEquals((5000 + 2000) * 0.97, priceStudent);
    }

}