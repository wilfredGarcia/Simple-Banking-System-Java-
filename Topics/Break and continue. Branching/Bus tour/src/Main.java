import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int numberOfBrdiges = scanner.nextInt();
        int i = 0;
        while (i<numberOfBrdiges) {

            int actualHeightBridge = scanner.nextInt();
            if (actualHeightBridge <= height) {

                System.out.println("Will crash on bridge " + (1+i));
                break;
            }
            else{i++;}
        }

        if(i==numberOfBrdiges){System.out.println("Will not crash");}
        // start coding here
    }
}