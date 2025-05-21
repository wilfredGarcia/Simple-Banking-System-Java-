import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a,b;
        long sum=0;
        a=scanner.nextInt();
        b=scanner.nextInt();
        sum=a;
        for(int i=a+1;i<b;i++){
            sum*=i;
        }
        System.out.println(sum);
    }
}