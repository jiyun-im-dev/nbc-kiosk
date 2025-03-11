package com.jiyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(new Menu(), new Cart());
        kiosk.start();
    }
}