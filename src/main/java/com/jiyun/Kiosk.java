package com.jiyun;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Kiosk {

    private Menu menu;

    public void start(Scanner scanner) {
        while (true) {
            // 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            printList(menu.getCategories());
            System.out.println("0. 종료");

            // 메뉴 출력 및 선택
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
            }
        }
    }

    private <T> void selectMenu(Scanner scanner, List<T> list) {
        String inputString = scanner.nextLine();
        try {
            int inputNum = Integer.parseInt(inputString);
            System.out.println("선택한 메뉴: " + list.get(inputNum - 1));
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("유효하지 않은 입력입니다.");
        }
    }

    private <T> void printList(List<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i - 1));
        }
    }

}
