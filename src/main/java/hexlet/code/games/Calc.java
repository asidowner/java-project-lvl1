package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Random;

public class Calc {
    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        for (int i = 0; i < Engine.getRoundsCount(); i++) {
            generateRoundData(questions);
        }

        final String rule = "What is the result of the expression?";
        Engine.initGame(rule, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 50;
        int firstNumber = Utils.getRandomPositiveNumber(range);
        int secondNumber = Utils.getRandomPositiveNumber(range);

        String operator = getRandomOperator();

        int sum = switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };

        String question = firstNumber + " " + operator + " " + secondNumber;
        data.put(question, String.valueOf(sum));
    }


    private static String getRandomOperator() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};
        return operators[Math.abs(random.nextInt(operators.length - 1))];
    }
}
