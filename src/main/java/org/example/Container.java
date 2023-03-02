package org.example;

import java.util.Scanner;

public class Container {
    static Scanner sc; // 계속 Scanner를 생성하지 않고 한곳에서 부르기 위함

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }
}
