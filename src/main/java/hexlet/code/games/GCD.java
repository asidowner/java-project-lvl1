package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;

public class GCD {

    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        final int rounds = 3;
        for (int i = 0; i < rounds; i++) {
            generateRoundData(questions);
        }

        final String rule = "Find the greatest common divisor of given numbers.";
        Engine.initGame(rule, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 1000;

        int firstNumber = Utils.getRandomPositiveNumber(range);
        int secondNumber = Utils.getRandomPositiveNumber(range);

        int answer = getGCD(firstNumber, secondNumber);

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

    private static int getGCD(int firstNumber, int secondNumber) {

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

}
