// 자르는 시작 지점을 한 칸씩 뒤로 미는데 시작 지점에서 부터 마지막 지점까지 p의 길이만큼 남았을 때만 민다.
// 자르고 배열에 넣고 p와 대조한 후, p보다 작거나 같을 때 카운팅 한다.
// 비교할때 정수형으로 변환후 비교한다.
// 제약조건으로 02, 03과 같은 숫자는 2, 3으로 변환해야 한다.
class False {
    public int solution(String t, String p) {
        int answer = 0;
        int beginIndex = 0;
        int endIndex = p.length();
        int count = t.length()+1;
        String str = "";
        int num = 0;

        while (count != p.length()) {
            str = t.substring(beginIndex++, endIndex++);
            count--;

            num = Integer.parseInt(str);
            if (num <= Integer.parseInt(p)) {
                answer++;
            }
        }

        return answer;
    }
}

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long numP = Long.parseLong(p);

        for (int i = 0; i <= t.length() - len; i++) {
            String subStr = t.substring(i, i + len);

            long numT = Long.parseLong(subStr);

            if (numT <= numP) {
                answer++;
            }
        }
        return answer;
    }
}