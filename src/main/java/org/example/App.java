package org.example;

import org.example.phrase.controller.PhraseController;
import org.example.system.controller.SystemController;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        PhraseController phraseController = new PhraseController();

        while (true) {
            System.out.print("명령)");
            String command = Container.getScanner().nextLine().trim();// 한줄을 입력받기 위해 nextLine() 사용, 띄워쓰기 공백 제거를 위해 trim()사용
            Rq rq = new Rq(command);
            if (rq.getActionCode().equals("종료")) {
                systemController.exit();
                return;
            } else if (rq.getActionCode().equals("등록")) {
                phraseController.add();
            } else if (rq.getActionCode().equals("목록")) {
                phraseController.printList();
            } else if (rq.getActionCode().equals("삭제")) {
                phraseController.remove(rq);
            } else if (rq.getActionCode().equals("수정")) {
                phraseController.update(rq);
            }
        }
    }
}
