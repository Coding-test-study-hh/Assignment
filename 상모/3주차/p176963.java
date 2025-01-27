import java.util.Map;
import java.util.HashMap;

// 각 이름들이 몇점을 뜻하는지 매칭을 하고 그 매칭된 이름으로 각 배열마다 점수를 계산하여서 순서대로 배열 형태로 리턴해야함
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();

        int[] answer = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);    
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (map.get(photo[i][j]) != null) {
                        answer[i] += map.get(photo[i][j]);   
                    }
                }
            }    
        return answer;
    }
}
