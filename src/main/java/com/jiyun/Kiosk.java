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
            String s = scanner.nextLine();
            if (s.equals("0")) {
                return;
            }
        }
    }

}
