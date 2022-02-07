package hexlet.code;

import java.util.HashMap;

public final class Engine {

    public static void initGame(String rule, HashMap<String, String> questions) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = Utils.getNextInput();

        System.out.printf("Hello, %s!\n", name);

        System.out.println(rule);

        for (String question : questions.keySet()) {
            System.out.printf("Question: %s\nYour answer: ", question);

            String answer = Utils.getNextInput();
            String expectedAnswer = questions.get(question);

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                System.out.printf("Let's try again, %s!\n", name);
                return;
            }
            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!\n", name);
    }

    public static int getRoundsCount() {
        final int roundsCount = 3;
        return roundsCount;
    }
}
