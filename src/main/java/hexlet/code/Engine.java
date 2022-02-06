package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;


public final class Engine {

    public static void chooseGame(LinkedHashMap<String, String> games) {
        Scanner scanner = new Scanner(System.in);
        String gameName = games.get(scanner.next());

        switch (gameName) {
            case "Greet" -> Cli.greet();
            case "Even", "Calc", "GCD", "Progression", "Prime" -> startGame(gameName);
            default -> {
            }
        }
    }

    private static void startGame(String gameName) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.printf("Hello, %s!\n", name);

        final int rounds = 3;
        HashMap<String, String> questions = new HashMap<>();
        String rule = "";
        switch (gameName) {
            case "Even" -> {
                rule = Even.getRule();
                questions = Even.getQuestions(rounds);
            }
            case "Calc" -> {
                rule = Calc.getRule();
                questions = Calc.getQuestions(rounds);
            }
            case "GCD" -> {
                rule = GCD.getRule();
                questions = GCD.getQuestions(rounds);
            }
            case "Progression" -> {
                rule = Progression.getRule();
                questions = Progression.getQuestions(rounds);
            }
            case "Prime" -> {
                rule = Prime.getRule();
                questions = Prime.getQuestions(rounds);
            }
            default -> {
            }
        }

        if (!questions.isEmpty()) {
            System.out.println(rule);
            String result = checkQuestions(questions);
            System.out.printf(result, name);
        }
    }

    private static String checkQuestions(HashMap<String, String> questions) {
        String result = "Congratulations, %s!\n";
        Scanner scanner = new Scanner(System.in);

        for (String question : questions.keySet()) {
            System.out.printf("Question: %s\nYour answer: ", question);

            String answer = scanner.next();
            String expectedAnswer = questions.get(question);

            if (!expectedAnswer.equals(answer)) {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s.\n", answer, expectedAnswer);
                result = "Let's try again, %s!\n";
                break;
            }
            System.out.println("Correct!");
        }

        return result;
    }

    public static int getRandomPositiveNumber(int range) {
        Random random = new Random();
        return Math.abs(random.nextInt(range));
    }

    public static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int getGCD(int firstNumber, int secondNumber) {

        int[] firstArray = getIntegerFactorization(firstNumber);
        int[] secondArray = getIntegerFactorization(secondNumber);

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

    private static int[] getIntegerFactorization(int number) {
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

    private static int[] getPrimeNumbersList(int range) {
        int[] primeList = new int[0];

        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                primeList = ArrayUtils.add(primeList, i);
            }
        }

        return primeList;
    }

    public static int[] getArithmeticProgression() {
        final int range = 100;
        final int incrementRange = range / 4;
        final int arrayRange = 10;

        int increment = Engine.getRandomPositiveNumber(incrementRange) + Engine.getRandomPositiveNumber(incrementRange);
        int[] progression = new int[arrayRange];
        int firstNumber = Engine.getRandomPositiveNumber(range);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = firstNumber + i * increment;
        }

        return progression;
    }
}
