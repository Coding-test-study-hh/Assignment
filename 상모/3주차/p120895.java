class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] ch = my_string.toCharArray();
        
        ch[num1] = my_string.charAt(num2);
        ch[num2] = my_string.charAt(num1);
        
        // String,valueOf는 Object값을 String으로 변환할때 쓰며
        // NPE를 회피할수 있다고 한다. 따라서 toString() 보다 이것의 사용을 추천하고 있다.
        String answer = String.valueOf(ch);
        return answer;
    }
}