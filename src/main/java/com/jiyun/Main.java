package com.jiyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(Menu.getMenu(), new Cart());
        kiosk.start();
    }
}