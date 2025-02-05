package week3;

/* 문제 : 백준 1406번 - 에디터

    영어 소문자만을 기록
    문장 맨 앞 / 맨 뒤 / 중간에 <커서> 위치
    길이 L인 문자열 => 커서 가능한 위치 == L + 1개  => 힌트일 것 -> L+1크기의 배열을 만들어야 하나?
    L : 커서 왼쪽으로 한 칸 옮기기
    D : 커서 오른쪽으로 한 칸 옮기기
    B : 커서 왼쪽에 있는 문자 삭제
    P $ : $ 문자를 커서 왼쪽에 추가
    %  명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치
       명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열
*/
/*

   접근 방식 1. 배열 사용    => 실패. 시간초과
        [ , a,  , b,  , c,  , d,  ] 커서 위치를 포함한 공간을 확보한 배열을 생성해서 로직대로 움직이기

   접근 방식 2. 스택으로 접근

   접근 방식 3.


 */

/*
    참고. https://mygumi.tistory.com/62
 */

import java.util.Scanner;

public class BJ1406ARRAY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();     // 입력받는 문자열

        char[] charArr = new char[2*str.length()+ 1];

        int idx = 0;
        for(int i=1; i<charArr.length; i+=2){
            charArr[i] = str.charAt(idx);
            idx ++;
        }

        int M = sc.nextInt();   // 명령어 개수
//        System.out.println("명령어 개수는: " + M);

        int cursor = charArr.length-1;     // 초기에 커서는 맨 뒤에 위치
        sc.nextLine();
        for(int i=0; i<M; i++){
            String command = sc.nextLine();

            char[] commandArr = command.toCharArray();

            if(commandArr[0] == 'L'){
                // 왼쪽으로 한 칸 이동
                if(cursor != 0){
                    cursor -= 2;
                }
            }else if(commandArr[0] == 'D'){
                if(cursor != (charArr.length - 1)){
                    cursor += 2;
                }
            }else if(commandArr[0] == 'B'){
                if(cursor != 0){
                    charArr[cursor - 1] = '\u0000';
                }
            }else{
                charArr[cursor] = commandArr[2];
            }
        }

        String result = "";
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] != '\u0000'){
                result += String.valueOf(charArr[i]);
            }
        }
        System.out.println(result);



    }
}
