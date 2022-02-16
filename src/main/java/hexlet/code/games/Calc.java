package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Calc {
    private static final String RULE = "What is the result of the expression?";
    private static final int RANGE = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void startGame() {
        HashMap<String, String> gameData = new HashMap<>();

        while (gameData.size() < Engine.ROUNDS) {
            generateRoundData(gameData);
        }

        Engine.initGame(RULE, gameData);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        int firstNumber = Utils.getRandomPositiveNumber(RANGE);
        int secondNumber = Utils.getRandomPositiveNumber(RANGE);

        char operator = getRandomOperator();

        int sum = calculate(firstNumber, secondNumber, operator);

        String question = firstNumber + " " + operator + " " + secondNumber;
        data.put(question, String.valueOf(sum));
    }


    private static char getRandomOperator() {
        return OPERATORS[Utils.getRandomPositiveNumber(OPERATORS.length - 1)];
    }

    private static int calculate(int firstNumber, int secondNumber, char operator) {
        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new Error("Unknown operator for calc : " + operator);
        };
    }
}
