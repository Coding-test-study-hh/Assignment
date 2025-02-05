package week2;
// [2주차] 실시간 공통 풀이
/* 문제. 백준 - 13300
 *
 *   성별, 학년
 *   최대 인원수 한정
 *   */
/* 접근방식.
 *   1.  [성별][학년] 2차원 배열 생성해서 인원수 다 담기
 *   2.  이중for문 돌려서 인원수 확인해가며 방 개수 카운트
 * */
// 개선. 입력 받을 때, 배열에 담겨있는 값? 계산해서

import java.util.*;

public class BJ13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 학생 수
        int K = sc.nextInt();   // 방 최대 인원

        int[][] arr = new int[2][6];    //  [성별][학년]

        int cnt = 0; // 방 개수

        for(int i=0; i<N; i++){
            int gender = sc.nextInt();
            int grade = sc.nextInt();

            arr[gender][grade-1] ++;
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j <arr[0].length; j++){
                int value = arr[i][j];
                // 해결.
                cnt += value / K; // 몫만큼 방 추가
                if (value % K != 0) { // 나머지가 있으면 방 하나 추가
                    cnt++;
                }
                // 에러.
//                if(value > 0 && value <=K){
//                    cnt ++;   // 그냥 카운트를 하나 올리고 있었음...
//                }else if(value > K && value%K != 0){
//                    cnt += (value/K) + 1;
//                }
            }
        }
        System.out.println(cnt);



    }
}