package hexlet.code;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public interface Engine {
    int ANSWER_FOR_WIN = 3;
    int MAX_RANGE_FOR_NUMBER = 100;
    HashMap<String, String> QUESTIONS = new HashMap<>();
    String NAME = Cli.greet();

    void getQuestion();

    String getRule();

    default String startGame() {
        System.out.println(getRule());

        for (int i = 0; i < ANSWER_FOR_WIN; i++) {
            getQuestion();
        }

        for (String question : QUESTIONS.keySet()) {
            System.out.printf("Question: %s\nYour answer: ", question);

            Scanner scanner = new Scanner(System.in);

            String answer = scanner.next();
            String expectedAnswer = QUESTIONS.get(question);

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                return "Let's try again, " + NAME + "!";
            }

            System.out.println("Correct!");
        }
        return "Congratulations, " + NAME + "!";
    }

    default int[] getPrimeNumbersList(int range) {
        int[] primeList = new int[0];

        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                primeList = ArrayUtils.add(primeList, i);
            }
        }

        return primeList;
    }

    default boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i * i < number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    default int[] getIntegerFactorization(int number) {
        int[] primeList = getPrimeNumbersList(number);
        int tmp = number;
        int[] result = new int[0];

        while (tmp > 1) {
            for (int prime : primeList) {
                if (tmp % prime == 0) {
                    tmp /= prime;
                    result = ArrayUtils.add(result, prime);
                    break;
                }
            }
        }


        return result;
    }

    default int getGCD(int[] firstArray, int[] secondArray) {
        int[] gcdByPrime = new int[0];

        for (int k : firstArray) {
            for (int j = 0; j < secondArray.length; j++) {
                if (secondArray[j] == k) {
                    gcdByPrime = ArrayUtils.add(gcdByPrime, secondArray[j]);
                    secondArray = ArrayUtils.remove(secondArray, j);
                    break;
                }
            }
        }

        int result = 1;
        if (gcdByPrime.length > 0) {
            for (int prime : gcdByPrime) {
                result *= prime;
            }
        }
        return result;
    }

    default int getRandomPositiveNumber() {
        Random random = new Random();
        return Math.abs(random.nextInt(MAX_RANGE_FOR_NUMBER));
    }

    default String getRandomOperator() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};
        return operators[Math.abs(random.nextInt(operators.length - 1))];
    }
}
