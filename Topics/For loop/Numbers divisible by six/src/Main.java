import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int sum =0; 
        int var;
        int numberElements = scanner.nextInt();
        for(int i=0;i<numberElements;i++) {
            var = scanner.nextInt();
            if(var%6==0){
             sum += var;
            }

            
        }
        
        System.out.println(sum);
    }
}
