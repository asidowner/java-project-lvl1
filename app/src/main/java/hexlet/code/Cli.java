package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String greet(Scanner scanner) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.printf("Hello, %s!\n", name);
        return name;
    }
}
