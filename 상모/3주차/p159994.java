// 특정 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들기
// 제약조건 : 
// 1. 원하는 카드 뭉치에서 카드를 순서대로 한장 씩 사용, 2. 중복 사용 불가 3. 카드 순서 변경 불가, 4. 카드는 무조건 사용되어야 함.
// 계산 : goal 문자 배열을 기준으로 순서대로 card1~2에서 일치하면 "Yes" 아니면 "No"
// 출력값 : answer = "Yes" || "No"
// 목표 : 1. goal에서 순서대로 cards1과 cards2에서 부합하는 문자열 뽑기 2. 두 카드에서 순서에 맞는 카드를 찾지 못하면 "No" 리턴, 맞으면 "Yes" 리턴
// 자료구조 : goal 문자열을 Set으로 처리(x) -> 순서가 보장 되어야 하기 때문에 그대로 배열 사용, 양쪽 배열에서 값이 있는지 확인해야 하므로 그것에 맞는 자료형 생각하기. : 내가 적절한 자료형이 뭔지 찾는것과 메서드를 잘 모르네? -> cards를 트리맵으로 뽑아쓰자.
// 되도록 선형 구조를 만들어야 함.
// 문제 핵심은 각 카드 배열에서 문자열을 빼먹지 않고 순서대로 만들수 있는가임.
// goal을 기준으로 cards1과 cards2에서 각각 첫번째 것만 선택하도록 한다면? 있으면 지우고, 없으면 그대로 "No"리턴
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> cardsList1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> cardsList2 = new ArrayList<>(Arrays.asList(cards2));
        
        for (String s : goal) {
            // cardsList1에서 첫 번째 단어와 비교
            if (!cardsList1.isEmpty() && cardsList1.get(0).equals(s)) {
                cardsList1.remove(0);
            }
            // cardsList2에서 첫 번째 단어와 비교
            else if (!cardsList2.isEmpty() && cardsList2.get(0).equals(s)) {
                cardsList2.remove(0);
            }
            // 두 카드 뭉치에서 찾을 수 없는 경우
            else {
                return "No";
            }
        }
        // 모든 단어를 순서대로 만들었다면 "Yes"
        return "Yes";
    }
}