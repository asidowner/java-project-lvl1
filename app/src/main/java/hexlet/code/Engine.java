package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public interface Engine {
    int ANSWER_FOR_WIN = 3;
    String NAME = Cli.greet();

    Map<String, String> getQuestions();

    String getRule();

    default void startGame() {
        System.out.println(getRule());
        Map<String, String> questions = getQuestions();

        int countWin = 0;
        for (String question : questions.keySet()) {
            System.out.printf("Question: %s\nYour answer: ", question);

            Scanner scanner = new Scanner(System.in);

            String answer = scanner.next();
            String expectedAnswer = questions.get(question);

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                break;
            }

            System.out.println("Correct!");
            countWin++;
        }

        if (countWin == ANSWER_FOR_WIN) {
            System.out.printf("Congratulations, %s!\n", NAME);
        }

    };
}
