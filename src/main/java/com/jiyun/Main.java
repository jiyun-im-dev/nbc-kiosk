package com.jiyun;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(Menu.getMenu(), Cart.getCart());
        kiosk.start();

    }
}