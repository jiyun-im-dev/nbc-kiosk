package com.jiyun;

import lombok.AllArgsConstructor;

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

            // 메뉴 항목 출력 및 선택
            String inputString = scanner.nextLine();
            try {
                int inputNum = Integer.parseInt(inputString);
                switch (inputNum) {
                    case 0:
                        return;
                    case 1:
                        printList(menu.getBurgers());
                        selectMenu(scanner, menu.getBurgers());
                        break;
                    case 2:
                        printList(menu.getDrinks());
                        selectMenu(scanner, menu.getDrinks());
                        break;
                    case 3:
                        printList(menu.getDesserts());
                        selectMenu(scanner, menu.getDesserts());
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다.");
            } catch (Exception e) {
                System.out.println("시스템 에러가 발생했습니다.");
            }
        }
    }

    private void printMainMenu() {
        // 카테고리 출력
        System.out.println("[ MAIN MENU ]");
        printList(menu.getCategories());
        System.out.println("0. 종료");

        // 장바구니에 물건이 있으면 ORDER MENU 출력
        if (!cart.isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
    }

    private <T> void selectMenu(Scanner scanner, List<T> list) throws Exception {
        String inputString = scanner.nextLine();
        int inputNum = Integer.parseInt(inputString);
        MenuItem selectedMenu = (MenuItem) list.get(inputNum - 1);
        System.out.println("선택한 메뉴: " + selectedMenu);

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인     2. 취소");
        inputString = scanner.nextLine();
        inputNum = Integer.parseInt(inputString);
        switch (inputNum) {
            case 1:
                cart.add(selectedMenu);
                break;
            case 2:
                break;
            default:
                System.out.println("올바른 값을 입력해 주세요.");
        }
    }

    private <T> void printList(List<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i - 1));
        }
    }

}
