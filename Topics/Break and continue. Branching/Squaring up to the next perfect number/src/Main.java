import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        int result=0;
        double aux = 0;

        for(int i = N+1; i < 10000; i++){
                aux=Math.sqrt(i);
            if(!(aux%1.0>0)) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        // Your code to find the first perfect square greater than N goes here
        // Use a loop and the break statement when you find the answer

        // Print the result here
    }
}