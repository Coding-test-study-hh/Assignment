import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastIdx = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 2. 밑에 put한 map을 통해서 그 다음 값 유무 확인
            System.out.println("char : "+c);
            if (lastIdx.containsKey(c)) {
                // 3. 현재 i (index)에서 기존에 put한 lastIdx를 빼면 위치를 얻을수 있음
                answer[i] = i - lastIdx.get(c);
                System.out.println("true : "+lastIdx.get(c));
                System.out.println("i - lastIdx : " + (i-lastIdx.get(c)));
            } else {
                answer[i] = -1;
                System.out.println("false : "+lastIdx.get(c));
            }
            
            // 1. 어찌됐든 put
            lastIdx.put(c, i);
            System.out.println("put : "+lastIdx.get(c));
            System.out.println(" ");
        }
        
        return answer;
    }
}