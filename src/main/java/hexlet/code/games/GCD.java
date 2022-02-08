package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;

public class GCD {
    private static final String RULE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        while (questions.size() < Engine.ROUNDS) {
            generateRoundData(questions);
        }

        Engine.initGame(RULE, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 500;

        int firstNumber = Utils.getRandomPositiveNumber(range);
        int secondNumber = Utils.getRandomPositiveNumber(range);

        int[] firstArray = getIntegerFactorization(firstNumber);
        int[] secondArray = getIntegerFactorization(secondNumber);

        int answer = getGCD(firstArray, secondArray);

        data.put(firstNumber + " " + secondNumber, String.valueOf(answer));
    }

    private static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static int getGCD(int[] firstArray, int[] secondArray) {
        int result = 1;

        for (int k : firstArray) {
            for (int j = 0; j < secondArray.length; j++) {
                if (secondArray[j] == k) {
                    result *= secondArray[j];
                    secondArray = ArrayUtils.remove(secondArray, j);
                    break;
                }
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

}
