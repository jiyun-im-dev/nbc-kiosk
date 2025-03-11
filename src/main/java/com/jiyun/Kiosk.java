package com.jiyun;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Kiosk {

    private Menu menu;
    private Cart cart;

    public void start(Scanner scanner) {
        while (true) {
            // 메인 메뉴 출력
            printMainMenu();

            // 메뉴 카테고리(버거, 음료, 디저트 또는 주문 메뉴) 선택
            List<MenuItem> menuItems = selectMenu(scanner);

            if (menuItems != null) {
                // 선택한 카테고리의 MenuItem 출력
                printMenuItems(menuItems);

                // MenuItem 선택
                selectMenuItem(scanner, menuItems);
            }
        }
    }

    private void printMainMenu() {
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
    private List<MenuItem> selectMenu(Scanner scanner) {
        while (true) {
            try {
                String inputString = scanner.nextLine();
                int inputNum = Integer.parseInt(inputString);

                // 0을 입력하면 프로그램 종료
                if (inputNum == 0) {
                    System.exit(0);
                } else if (inputNum <= Category.values().length) {
                    // 선택한 카테고리의 MenuItem 만 들어 있는 리스트를 생성
                    List<MenuItem> menuItems = menu.getMenuItems().stream()
                            .filter(item -> item.getCategory().getIndex() == inputNum)
                            .toList();
                    return menuItems;
                } else if (inputNum == Category.values().length + 1) {
                    if (!cart.isEmpty()) {
                        order(scanner);
                        return null;
                    } else {
                        System.out.println(Message.WRONG_INPUT);
                    }
                } else if (inputNum == Category.values().length + 2) {
                    if (!cart.isEmpty()) {
                        cancelOrder();
                        return null;
                    } else {
                        System.out.println(Message.WRONG_INPUT);
                    }
                } else {
                    System.out.println(Message.WRONG_INPUT);
                }
            } catch (NumberFormatException e) {
                System.out.println(Message.NUMBER_ERROR);
            } catch (Exception e) {
                System.out.println(Message.SYSTEM_ERROR);
            }
        }
    }

    private void printMenuItems(List<MenuItem> menuItems) {
        // 선택한 카테고리의 MenuItem 을 출력
        for (int i = 1; i <= menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i - 1));
        }
    }

    // 주문할 메뉴 선택
    private <T> void selectMenuItem(Scanner scanner, List<MenuItem> menuItems) {
        try {
            String inputString = scanner.nextLine();
            int inputNum = Integer.parseInt(inputString);
            MenuItem selectedMenu = menuItems.get(inputNum - 1);
            System.out.println("선택한 메뉴: " + selectedMenu);

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인     2. 취소");
            inputString = scanner.nextLine();
            inputNum = Integer.parseInt(inputString);
            switch (inputNum) {
                case 1 -> cart.add(selectedMenu);
                case 2 -> {}
                default -> System.out.println(Message.WRONG_INPUT);
            }
        } catch (NumberFormatException e) {
            System.out.println(Message.NUMBER_ERROR);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Message.WRONG_INPUT);
        } catch (Exception e) {
            System.out.println(Message.SYSTEM_ERROR);
        }
    }

    private void order(Scanner scanner) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        cart.print(); // 장바구니에 담긴 모든 메뉴 출력
        System.out.println("[ Total ]");
        System.out.println(cart.calculateTotal() + "원"); // 총액 출력
        System.out.println();
        System.out.println("1. 주문      2. 메뉴판");
        String inputString = scanner.nextLine();
        int inputNum = Integer.parseInt(inputString);
        switch (inputNum) {
            case 1 -> {
                System.out.println("주문이 완료되었습니다. 금액은 " + cart.calculateTotal() + "원입니다.");
                cart.clear();
                return;
            }
            case 2 -> {
                return;
            }
            default -> {
                System.out.println(Message.WRONG_INPUT);
                return;
            }
        }
        // 주문을 선택하면 주문 완료 메시지를 띄우고 장바구니를 비운다.
        // 메뉴판을 선택하면 메뉴판(버거, 음료, ..)으로 돌아간다.
    }

    private void cancelOrder() {
        System.out.println("주문이 취소되었습니다. 초기 화면으로 되돌아갑니다.");
        cart.clear();
    }

    private <T> void printList(List<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i - 1));
        }
    }

}
