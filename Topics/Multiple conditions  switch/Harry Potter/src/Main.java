import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String name = scanner.nextLine();
        switch (name) {
            case "gryffindor":
                System.out.println("bravery");
                break;
            case "hufflepuff":
                System.out.println("loyalty");
                break;
            case "slytherin":
                System.out.println("cunning");
                break;
            case  "ravenclaw":
                System.out.println("intellect");
                break;
            default:
                System.out.println("not a valid house");
                break;
        }
    }
}