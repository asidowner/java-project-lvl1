package hexlet.code.games;

import hexlet.code.Engine;


public final class GCD implements Engine {
    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public void getQuestion() {
        int firstNumber = getRandomPositiveNumber();
        int secondNumber = getRandomPositiveNumber();

        final int[] firstIntegerFactorization = getIntegerFactorization(firstNumber);
        final int[] secondIntegerFactorization = getIntegerFactorization(secondNumber);

        int answer = getGCD(firstIntegerFactorization, secondIntegerFactorization);
        Engine.QUESTIONS.put(firstNumber + " " + secondNumber, Integer.toString(answer));
    }
}
