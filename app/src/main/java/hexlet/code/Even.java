package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void game(Scanner scanner, String name) {

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;
        final int correctAnswersForWin = 3;
        while (correctAnswers < correctAnswersForWin) {
            String expectedAnswer = getQuestion();
            String answer = scanner.next();

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                break;
            } else {
                System.out.println("Correct!");
                ++correctAnswers;
                if (correctAnswers == correctAnswersForWin) {
                    System.out.printf("Congratulations, %s!\n", name);
                }
            }
        }
    }

    public static String getQuestion() {
        final int maxNumber = 100;
        final int minNumber = 0;
        // Получаем число в диапазоне от minNumber до maxNumber
        int askingNumber = (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);

        System.out.printf("Question: %s\nYour answer: ", askingNumber);

        return askingNumber % 2 == 0 ? "yes" : "no";
    }
}
