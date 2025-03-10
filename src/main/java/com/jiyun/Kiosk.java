package com.jiyun;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Kiosk {

    private Menu menu;
    private Cart cart;

    public void start(Scanner scanner) {
        while (true) {
            // 메인 메뉴 출력
            printMainMenu();

            // 메뉴 카테고리 선택 및 MenuItem 출력
            List<MenuItem> menuItems = selectMenu(scanner);

            // MenuItem 선택
            selectMenuItem(scanner, menuItems);
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

    private List<MenuItem> selectMenu(Scanner scanner) {
        try {
            String inputString = scanner.nextLine();
            int inputNum = Integer.parseInt(inputString);

            // 0을 입력하면 프로그램 종료
            if (inputNum == 0) {
                System.exit(0);
            }

            // 카테고리를 선택하면 해당 카테고리의 MenuItem 리스트 출력
            if (inputNum <= Category.values().length) {
                for (int i = 1; i <= menu.getMenuItems().size(); i++) {
                    if (menu.getMenuItems().get(i - 1).getCategory().getIndex() == inputNum) {
                        System.out.println(menu.getMenuItems().get(i - 1));
                    }
                }
                // 해당 카테고리의 MenuItem 만 들어 있는 리스트를 반환
                return menu.getMenuItems().stream()
                        .filter(item -> item.getCategory().getIndex() == inputNum)
                        .collect(Collectors.toList());
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
        } catch (Exception e) {
            System.out.println("시스템 에러가 발생했습니다.");
        }
        return null;
    }

    private <T> void selectMenuItem(Scanner scanner, List<T> list) {
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
        } catch (Exception e) {
            System.out.println("시스템 에러가 발생했습니다.");
        }
    }

    private <T> void printList(List<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i - 1));
        }
    }

}
