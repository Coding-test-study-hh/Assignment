import java.util.Map;
import java.util.HashMap;

class False {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Map<Integer, Boolean> skipMap = new HashMap<>();
        Map<Integer, Character> askiiMap = new HashMap<>();
        
        for (int i = 0; i < skip.length(); i++) {
            skipMap.put((int) skip.charAt(i), false);
        }
        
        for (int i = 0; i < 25 - skip.length(); i++) {
            if (skipMap.get(97 + i) == null || skipMap.get(97 + i) != false) {
                askiiMap.put(i+97, (char)(i+97));   
            }
        }
        
        System.out.println(askiiMap);
        
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            
            if (skipMap.get(s.charAt(i)) == null) {
                key = s.charAt(i) + index;
            } else {
                key = s.charAt(i) + index+1;
            }
            
            
            System.out.println(key);
            
            answer += askiiMap.get(s.charAt(i));
        }
        
        return answer;
    }
}

import java.util.*;
// 주어진 s에서 skip의 문자들을 제외하고 index 값 만큼, 각 알파벳을 뒤로 미룬다.
// z를 넘어가면 a로 돌아온다.
// 97~122
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        
        // skip 문자들을 Set에 저장
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        // 각 문자를 index만큼 뒤로 이동시키며 결과 문자열 생성
        for (char c : s.toCharArray()) {
            int count = 0;  // 이동한 횟수
            char current = c;
            
            while (count < index) {
                current++; // 다음 문자로 이동
                if (current > 'z') {
                    current = 'a'; // z를 넘어가면 a로 순환
                }
                if (!skipSet.contains(current)) {
                    count++; // skip되지 않는 문자만 카운트
                }
            }
            
            answer.append(current); // 변환된 문자 추가
        }
        
        return answer.toString();
    }
}
