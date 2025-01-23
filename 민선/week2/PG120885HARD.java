package week2;
/* 문제. 프로그래머스 - 이진수 더하기

 */
/* 접근방식.  */
// 에러. : 케이스 3개에서 런타임 에러.
// 해결. : str.equals("문자열") 로 비교 연산 변경 후 해결됨!
// 개선. : 이진수 덧셈 연산을 메서드로 만들어서 사용하는 방법을 생각해보자.


public class PG120885HARD {
    public String solution(String bin1, String bin2) {
        String answer = "";  // 이진수 계산 결과

        String remain; // (bin1, bin2 길이가 다를 경우)남은 문자열 처리
        int len = 0;   // 두 이진수 중 더 짧은 길이

        // 두 문자열 길이를 비교하여 짧은 쪽의 길이 len 으로 저장
        // 나머지 긴 바이너리 문자열을 remain으로 저장
        if (bin1.length() > bin2.length()) {
            len = bin2.length();
            remain = bin1.substring(0, bin1.length() - bin2.length());
        } else if (bin1.length() < bin2.length()) {
            len = bin1.length();
            remain = bin2.substring(0, bin2.length() - bin1.length());
        } else {
            len = bin1.length();
            remain = "";
        }
        String carry = "0"; // 캐리값 초기화

        // 두 이진수의 동일 길이 부분만큼 뒤에서부터 한 자리씩 더하기 연산
        // (<-) 연산 방향
        for (int i = 0; i < len; i++) {
            char one = bin1.charAt(bin1.length() - 1 - i);
            char two = bin2.charAt(bin2.length() - 1 - i);

            if (one == '1' && two == '1') {     // 1 + 1
                if (carry.equals("0")) {
                    carry = "1";                // 캐리 없을 경우 => 캐리 +1
                    answer = "0" + answer;      // 계산 결과는 0
                } else {
                    // 캐리 있었을 경우 => 캐리 그대로 (1)
                    answer = "1" + answer;      // 계산 결과는 1
                }
            } else if (one == '0' && two == '0') {  // 0 + 0
                if (carry.equals("1")) {            // 캐리 있을 경우
                    answer = "1" + answer;          // 계산 결과는 1
                    carry = "0";                    // 캐리는 0으로 초기화
                } else {                            // 캐리 있을 경우
                    answer = "0" + answer;          // 계산 결과는 0
                }
            } else {                                // 1 + 0 || 0 + 1
                if (carry.equals("1")) {            // 캐리 있을 경우
                    answer = "0" + answer;          // 계산 결과는 0, 캐리는 그대로(1)
                } else {                            // 캐리 없을 경우
                    carry = "0";                    // 캐리는 0으로 변경
                    answer = "1" + answer;          // 계산 결과는 1
                }
            }
        }
        // bin1, bin2 길이가 다를 경우
        // remain 처리(=> 길이가 긴 bin의 앞부분)
        // 나머지 같은 로직...
        for (int i = remain.length() - 1; i >= 0; i--) {
            char fi = remain.charAt(i);
            if (fi == '1' && carry.equals("1")) {
                carry = "1";
                answer = "0" + answer;
            } else if (fi == '1' && carry.equals("0")) {
                carry = "0";
                answer = "1" + answer;
            } else if (fi == '0' && carry.equals("1")) {
                carry = "0";
                answer = "1" + answer;
            } else {
                answer = "0" + answer;
            }
        }

        // 최종 캐리가 남아있다면 추가
        if (carry.equals("1")) {
            answer = carry + answer;
        }

        return answer;
    }
}