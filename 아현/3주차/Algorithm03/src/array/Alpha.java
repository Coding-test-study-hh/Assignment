package array;

import java.util.Scanner;

public class Alpha {
    /* 설명.
    *  알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에
    *   몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
    *   (입력)
    *   첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
    *   (출력)
    *   단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("단어를 입력하세요");

        //알파벳을 넣을 배열
        int[] arr = new int['z'-'a'];

        //단어 입력받기
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i)-('z'-'a');
            arr[temp]++;
        }

        for (int i = 0; i < 'z'-'a'; i++) {
            System.out.print(arr[i] + "");
        }




        // 단어 s에 포함된 알파벳의 갯수를 각각 구한다.


    }
}
