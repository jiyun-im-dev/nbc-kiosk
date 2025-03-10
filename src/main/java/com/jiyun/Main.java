package com.jiyun;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Kiosk kiosk = new Kiosk(new Menu());
        kiosk.start(scanner);
    }
}