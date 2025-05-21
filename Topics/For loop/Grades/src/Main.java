import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        String grade;
        grade = scanner.nextLine();
        for (int i = 0; i < students; i++) {
            grade = scanner.nextLine();
            switch (grade) {
                case "A": A++; break;
                case "B": B++; break;
                case "C": C++; break;
                case "D": D++; break;
            }
        }
        System.out.println(D+" "+C+" "+B+" "+A);
        // start coding here

    }
}