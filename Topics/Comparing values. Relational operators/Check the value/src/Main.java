import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int value = scanner.nextInt();
        if(value < 10) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}