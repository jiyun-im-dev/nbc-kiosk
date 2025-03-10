package com.jiyun;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class Kiosk {

    private Menu menu;

    public void start(Scanner scanner) {
        while (true) {
            for (int i = 1; i <= menu.getMenuItems().size(); i++) {
                System.out.print(i + ". ");
                System.out.println(menu.getMenuItems().get(i - 1));
            }
            System.out.println("0. 종료");
            String inputString = scanner.nextLine();
            if (inputString.equals("0")) {
                return;
            } else {
                try {
                    int inputNum = Integer.parseInt(inputString);
                    System.out.println("선택한 메뉴: " + menu.getMenuItems().get(inputNum - 1));
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해 주세요.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("유효하지 않은 입력입니다.");
                }
            }
        }
    }

}
