import java.util.Scanner;
import java.util.Stack;

public class p10828 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int comLen = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < comLen; i++) {
            String command = sc.nextLine();
            String[] splitedCommand = command.split(" ");
            switch (splitedCommand[0]) {
                case "push":
                    stack.push(splitedCommand[1]);
                    break;
                case "pop":
                    System.out.println(stack.empty() ? -1 : stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;
                
                case "empty":
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
                
                case "top":
                    System.out.println(stack.empty() ? -1 : stack.peek());
                    break;
                    
                default:
                    break;
            }
        }

        sc.close();
    }
}
