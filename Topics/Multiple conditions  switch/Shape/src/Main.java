import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        String result = switch (option) {
            case 1 -> "square";
            case 2 -> "circle";
            case 3 -> "triangle";
            case 4 -> "rhombus";
            default -> "";
        };

        if(!result.isEmpty()) {
            System.out.println("You have chosen a " + result);

        }else {

            System.out.println("There is no such shape!");
        }

        // start coding here
    }
}