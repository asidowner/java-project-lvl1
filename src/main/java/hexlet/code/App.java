package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        final Scanner scanner = new Scanner(System.in);

        final String choise = scanner.next();
        switch (choise) {
            case "1" -> Cli.greet();
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> GCD.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            default -> {
            }
        }

    }
}
