package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Random;

public class Calc {
    public static HashMap<String, String> getQuestions(int rounds) {
        HashMap<String, String> questions = new HashMap<>();
        for (int i = 0; i < rounds; i++) {
            final int range = 50;
            int firstNumber = Engine.getRandomPositiveNumber(range);
            int secondNumber = Engine.getRandomPositiveNumber(range);

            String operator = getRandomOperator();

            int sum = switch (operator) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                default -> 0;
            };

            String question = firstNumber + " " + operator + " " + secondNumber;
            questions.put(question, String.valueOf(sum));
        }
        return questions;
    }

    public static String getRule() {
        return "What is the result of the expression?";
    }

    private static String getRandomOperator() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};
        return operators[Math.abs(random.nextInt(operators.length - 1))];
    }
}
