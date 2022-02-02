package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void startGame() {
        System.out.println("Welcome to the Brain Games!");
        Scanner sc = new Scanner(System.in);
        System.out.print("May I have your name? ");
        System.out.printf("Hello, %s!\n", sc.next());
    }
}
