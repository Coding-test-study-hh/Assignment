import java.util.Scanner;

public class p13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int max = sc.nextInt();

        int[][] students = new int[6][2];
        for(int i = 0; i < total; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            students[grade - 1][gender]++;
        }

        int count = 0;
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                if (students[i][j] > 0) {
                    // count += (students[i][j] + max - 1) / max; // 올림 처리
                    if (students[i][j] % max != 0) {
                        count += students[i][j] / max + 1;
                    } else {
                        count += students[i][j] / max;
                    }
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}
