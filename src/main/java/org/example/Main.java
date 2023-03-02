package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        long lastPhraseIndex = 0;
        List<Phrase> phrases = new ArrayList<>();

        while (true) {
            System.out.print("명령)");
            String command = sc.nextLine().trim();// 한줄을 입력받기 위해 nextLine() 사용, 띄워쓰기 공백 제거를 위해 trim()사용

            if (command.equals("종료")) {
                return;
            } else if (command.equals("등록")) {
                System.out.printf("명언 : ");
                String phrase = sc.nextLine().trim(); // 명언을 입력받기
                System.out.printf("작가 : ");
                String authorName = sc.nextLine().trim(); // 작가 이름을 입력받기
                long id = lastPhraseIndex + 1; // 저장할 때 마다 id값 증가시켜주기

                phrases.add(new Phrase(id, phrase, authorName)); // 입력 받은 값 저장

                System.out.printf("%d번 명언이 등록되었습니다\n", id); // 결과 출력
            }
        }
    }
}