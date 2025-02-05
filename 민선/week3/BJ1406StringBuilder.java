package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ1406StringBuilder {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
//        System.out.println("입력받은 문자열: " + sb.toString());

        
        int M = Integer.parseInt(br.readLine());    // 명령어 개수
//        System.out.println("명령어 개수 = " + M);


        int cursor = sb.length()-1;    // 초기에 커서는 맨 뒤에 위치
//        System.out.println("cursor = " + cursor);
        for(int i=0; i<M; i++){
            String command = br.readLine();
//            System.out.println("command = " + command);
            StringBuilder cb = new StringBuilder(command);

            char ch = cb.charAt(0);

//            if(cursor == 0 || cursor == (sb.length()-1)){
//                continue;
//            }
            if(ch == 'L'){
                if(cursor != -1){
                    cursor --;
                }

            }else if(ch == 'D'){
                if(cursor != (sb.length()-1)){
                    cursor ++;
                }
            }else if(ch == 'B'){
                if(cursor != -1){
                    sb.deleteCharAt(cursor);
                    cursor --;
                }
            }else{

                String s = Character.valueOf(cb.charAt(2)).toString();
                sb.insert(cursor + 1, s);
                cursor ++;
            }
//            System.out.println("sb = " + sb);
//            System.out.println("cursor = " + cursor);


        }
        String result = sb.toString();


        System.out.println(result);
    }
}
