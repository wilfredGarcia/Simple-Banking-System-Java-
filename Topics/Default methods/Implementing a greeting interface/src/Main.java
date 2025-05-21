import java.util.Scanner;

interface Greetings {
    // TODO: Define the default 'greet' method here
    default String greet(String name){
        return "Hello, " +name+"!";
    }
}

class GreetingsImpl implements Greetings {
    // TODO: Implement the 'greet' method here
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Greetings greetings = new GreetingsImpl();
        String greeting = greetings.greet(name);
        System.out.println(greeting);
    }
}