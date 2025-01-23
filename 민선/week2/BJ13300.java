package week2;
/* 문제. 백준 - 13300
*
*  남학생끼리
* 같은 학년 
*   */
/* 접근방식.
*   1.
* */
import java.util.*;

public class BJ13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int N = sc.nextInt();
        int K = sc.nextInt();
//        System.out.println("N = " + N);
//        System.out.println("K = " + K);
        int[][] arr = new int[2][6];
        int cnt = 0; // 방 개수
        for(int i=0; i<N; i++){
            int gender = sc.nextInt();
            int grade = sc.nextInt();

            int value = arr[gender][grade-1];
            arr[gender][grade-1] ++;
//            if(value < K){
//                cnt ++;
//                arr[gender][grade-1]++;
//            }else if(value == K){
//                cnt ++;
//                arr[gender][grade-1] = 0 ;
//            }
//            arr[gender][grade-1]++;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j <arr[0].length; j++){
                int value = arr[i][j];
                // 그냥 K % 로
                if(value > 0 && value <=K){
                    cnt ++;

                }else if(value > K){
                    cnt += (value/K) + 1;
                }
                // value가 K 로 나눠 떨어질 경우
                // value % K == 0
            }
        }
        System.out.println(cnt);

        

    }
}
