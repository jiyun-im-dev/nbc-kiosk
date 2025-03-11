package com.jiyun;

import com.jiyun.enums.Message;

import java.util.Scanner;

public class Util {

    public static int getIntegerInput(Scanner scanner) {
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

}
