package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령)");
            String command = sc.nextLine().trim();// 한줄을 입력받기 위해 nextLine() 사용, 띄워쓰기 공백 제거를 위해 trim()사용

            if (command.equals("종료")) {
                return;
            } else if (command.equals("등록")) {
                System.out.printf("명언 : ");
                String phrase = sc.nextLine().trim();
                System.out.printf("작가 : ");
                String authorName = sc.nextLine().trim();
            }
        }
    }
}