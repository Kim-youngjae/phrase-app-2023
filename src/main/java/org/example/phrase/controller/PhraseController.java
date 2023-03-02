package org.example.phrase.controller;

import org.example.Container;
import org.example.Phrase;
import org.example.Rq;

import java.util.ArrayList;
import java.util.List;

public class PhraseController {
    long lastPhraseIndex = 0;
    List<Phrase> phrases = new ArrayList<>();

    public void add() {
        System.out.printf("명언 : ");
        String phrase = Container.getScanner().nextLine().trim(); // 명언을 입력받기
        System.out.printf("작가 : ");
        String authorName = Container.getScanner().nextLine().trim(); // 작가 이름을 입력받기
        long id = lastPhraseIndex + 1; // 저장할 때 마다 id값 증가시켜주기

        phrases.add(new Phrase(id, phrase, authorName)); // 입력 받은 값 저장

        System.out.printf("%d번 명언이 등록되었습니다\n", id); // 결과 출력
        lastPhraseIndex = id;
    }

    public void printList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for (int i = phrases.size() - 1; i >= 0; i--) { // 뒤에서부터 출력
            System.out.printf("%d / %s / %s\n", phrases.get(i).getId(), phrases.get(i).getAuthorName(), phrases.get(i).getPhrase()); // 리스트의 값들을 getter메서드로 가져옴
        }
    }

    public void remove(Rq rq) {
        // 삭제의 경우는 명령이 ?를 기준으로 옵션과 붙어있다.
        int id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("id값(정수)을 입력하세요");
            return;
        }

        Phrase phrase = findById(id);
        if (phrase == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.", id);
            return;
        }

        phrases.remove(phrase);
        System.out.printf("%d번 명언이 삭제되었습니다.", id);
    }



    public Phrase findById(int id) {
        for (int i = 0; i < phrases.size(); i++) { // phrases 리스트안에서
            if (phrases.get(i).getId() == id) { // id일치하는 명언이 있으면 반환
                return phrases.get(i);
            }
        }
        return null; // 없으면 null반환
    }
}
