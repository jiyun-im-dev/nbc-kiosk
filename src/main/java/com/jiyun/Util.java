package com.jiyun;

import com.jiyun.enums.Message;

import java.util.List;
import java.util.Scanner;

public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput() {
        while (true) {
            try {
                String inputString = scanner.nextLine();
                return Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println(Message.NUMBER_ERROR);
            } catch (Exception e) {
                System.out.println(Message.SYSTEM_ERROR);
            }
        }
    }

    public static <T> void printList(List<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i - 1));
        }
    }

}
