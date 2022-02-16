package hexlet.code;

import java.util.HashMap;
import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS = 3;

    public static void initGame(String rule, HashMap<String, String> gameData) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();

        System.out.printf("Hello, %s!\n", name);

        System.out.println(rule);

        for (String question : gameData.keySet()) {
            System.out.printf("Question: %s\nYour answer: ", question);

            String answer = scanner.next();
            String expectedAnswer = gameData.get(question);

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                System.out.printf("Let's try again, %s!\n", name);
                scanner.close();
                return;
            }
            System.out.println("Correct!");
        }
        System.out.printf("Congratulations, %s!\n", name);
        scanner.close();
    }
}
