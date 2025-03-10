package com.jiyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Kiosk kiosk = new Kiosk(new Menu(), new Cart());
        kiosk.start(scanner);
    }
}