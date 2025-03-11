package com.jiyun;

import com.jiyun.enums.Category;
import com.jiyun.enums.Discount;
import com.jiyun.enums.Message;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.jiyun.Util.getIntegerInput;

@AllArgsConstructor
public class Kiosk {

    private Menu menu;
    private Cart cart;

    public void start() {
        while (true) {
            // 메인 메뉴 출력
            printMainMenu();

            // 메뉴 카테고리(버거, 음료, 디저트 또는 주문 메뉴) 선택
            selectMenu();
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("========== 키오스크 시작 ==========");
        System.out.println();
        // 카테고리 출력
        System.out.println("[ MAIN MENU ]");
        Arrays.stream(Category.values()).forEach(s -> System.out.println(s.getIndex() + ". " + s));
        System.out.println("0. 종료");

        // 장바구니에 물건이 있으면 ORDER MENU 출력
        if (!cart.isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    // 메인 메뉴(Burgers, Drinks...) 선택
    private void selectMenu() {
        int inputNum = getIntegerInput();
        int categoryCount = Category.values().length;

        // 0을 입력하면 프로그램 종료
        if (inputNum == 0) {
            System.exit(0);
        }

        // 메뉴 카테고리를 선택한 경우
        if (inputNum <= categoryCount) {
            // 선택한 카테고리의 MenuItem 만 들어 있는 리스트를 반환
            List<MenuItem> menuItemsByCategory = getMenuItemsByCategory(Category.values()[inputNum - 1]);
            printMenuItems(menuItemsByCategory);
            selectMenuItem(menuItemsByCategory);
            return;
        }

        // 카테고리 개수를 초과한 수를 입력하면 에러 메시지를 출력하고 처음으로 돌아감
        if (cart.isEmpty()) {
            Message.WRONG_INPUT.print();
            return;
        }

        // 카트에 물건이 담겨 있을 때 주문 메뉴 선택한 경우
        if (inputNum == categoryCount + 1) {
            order();
            return; // order 로직이 끝나면 처음으로 돌아감
        }

        // 카트에 물건이 담겨 있을 때 주문 취소 메뉴 선택한 경우
        if (inputNum == categoryCount + 2) {
            cancelOrder();
            return;
        }

        Message.WRONG_INPUT.print();
    }

    private List<MenuItem> getMenuItemsByCategory(Category category) {
        return menu.getMenuItems().stream()
                .filter(item -> item.getCategory().getIndex() == category.getIndex())
                .toList();
    }

    private void printMenuItems(List<MenuItem> menuItems) {
        // 선택한 카테고리의 MenuItem 을 출력
        for (int i = 1; i <= menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i - 1));
        }
    }

    // 선택한 카테고리에서 주문할 메뉴 선택
    private <T> void selectMenuItem(List<MenuItem> menuItems) {
        try {
            int inputNum = getIntegerInput();
            MenuItem selectedMenu = menuItems.get(inputNum - 1);
            System.out.println("선택한 메뉴: " + selectedMenu);

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인     2. 취소");
            inputNum = getIntegerInput();
            switch (inputNum) {
                case 1 -> cart.add(selectedMenu);
                case 2 -> {
                }
                default -> Message.WRONG_INPUT.print();
            }
        } catch (IndexOutOfBoundsException e) {
            Message.WRONG_INPUT.print();
        }
    }

    private void order() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        cart.print(); // 장바구니에 담긴 모든 메뉴 출력

        System.out.println("[ Total ]");
        System.out.println(cart.calculateTotal() + "원"); // 총액 출력
        System.out.println("1. 주문      2. 메뉴판");

        int inputNum = getIntegerInput();

        switch (inputNum) {
            case 1 -> {
                Discount.print(); // 할인 정보 출력
                // 할인 타입을 숫자로 받아서 Discount 타입으로 변경
                Discount discountType = Discount.values()[getIntegerInput() - 1];
                System.out.println("주문이 완료되었습니다. 금액은 " + cart.calculateTotalWithDiscount(discountType) + "원입니다.");
                cart.clear();
            }
            case 2 -> {
            } // 메뉴판으로 돌아감
            default -> {
                Message.WRONG_INPUT.print();
            }
        }
    }

    private void cancelOrder() {
        System.out.println("주문이 취소되었습니다. 초기 화면으로 되돌아갑니다.");
        cart.clear();
    }

}
