package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    Map<String, String> params;
    private String actionCode;

    public Rq(String command) {
        params = new HashMap<>();

        String[] commandBits = command.split("\\?", 2);// ?를 기준으로 나누고 최대 두개로 나눈다는 의미
        actionCode = commandBits[0]; // 삭제?id=1 -> "삭제", "id=1"로 나뉘는데 그 중 0번째

        if (commandBits.length == 1) { // 삭제만 쳤을 때 처리
            return;
        }

        String[] paramBits = commandBits[1].split("&");// 나중에 여러개의 옵션을 받기 위한 분리

        for (String paramStr : paramBits) { // id=1, option2=a, option3=false
            String[] paramStrBits = paramStr.split("=", 2); // 이걸 =기준으로 분해

            if (paramBits.length == 1) {
                continue; // break나 return 하지 않은 이유: &로 다른 명령어도 묶여 있기 때문
            }

            System.out.println("paramStr = " + paramStr);


            String key = paramStrBits[0]; // id
            String value = paramStrBits[1]; // 1

            params.put(key, value); // 맵 형태로 저장
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.valueOf(getParam(name)); // 이름으로 검색했을 때 id값이 없는 경우나 없어서 id가 없을 때 발생하는 예외 처리
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}

