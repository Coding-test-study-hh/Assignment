// 입력 : String, 출력 : String
// 계산 : 주어진 s의 각 문자를 index만큼 이동 시킨다(ascii)
// 제약조건 : 1. skip에 있는 있는 알파벳은 건너뛴다. 2. z를 넘어갈 경우 다시 a로 돌아간다.
// 목표 : 1. 입력값 처리. 2. 제약조건 처리
// 자료구조 생각하기 : Set으로 skip 문자열 처리.
import java.util.Set;
import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        // String 입출력이 빈번하므로 answer를 StringBuilder로 변경
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        System.out.println(skip);
        
        // skip문자열 Set으로 구조화
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        // 문자열 이동 로직 테스트
        for (char c : s.toCharArray()) {
            char current = c;
            int count = 0;
            
            
            while (count < index) {
                current++; // current는 계속 이동해야 하므로 while 구조를 사용.
                
                // current가 'z'를 넘어서면 'a'를 대입하고 순환시킨다.
                if (current > 'z') {
                    current = 'a';
                }
                
                // skip 문자에 current가 포함되어 있지 않은 경우에만 count
                // 결국 skip 문자는 건너뛰는 효과
                if (!skipSet.contains(current)) {
                    count++;
                }
            }
            answer.append(current);
        }
        return answer.toString();
    }
}