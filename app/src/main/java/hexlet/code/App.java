package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression"};

        System.out.println("Please enter the game number and press Enter.");

        for (int i = 1; i < games.length; i++) {
            System.out.printf("%s - %s\n", i, games[i]);
        }

        int index = 0;
        System.out.printf("%s - %s\n", index, games[index]);
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        final int gameId = scanner.nextInt();

        try {
            startGame(games[gameId]);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private static void startGame(String gameName) {
        Engine game;

        switch (gameName) {
            case "Greet" -> Cli.greet();
            case "Even" -> {
                game = new Even();
                System.out.println(game.startGame());
            }
            case "Calc" -> {
                game = new Calc();
                System.out.println(game.startGame());
            }
            case "GCD" -> {
                game = new GCD();
                System.out.println(game.startGame());
            }
            case "Progression" -> {
                game = new Progression();
                System.out.println(game.startGame());
            }
            default -> {
            }
        }
    }
}
