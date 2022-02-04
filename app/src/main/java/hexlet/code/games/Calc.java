package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Calc implements Engine {
    @Override
    public final Map<String, String> getQuestions() {
        Map<String, String> questions = new HashMap<>();
        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < Engine.ANSWER_FOR_WIN; i++) {
            final int maxNumber = 100;
            int firstNumber = random.nextInt(random.nextInt(maxNumber));
            int secondNumber = random.nextInt(random.nextInt(maxNumber));
            String operator = operators[Math.abs(random.nextInt(operators.length - 1))];

            int sum = switch (operator) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                default -> 0;
            };

            String question = firstNumber + " " + operator + " " + secondNumber;
            questions.put(question, Integer.toString(sum));
        }
        return questions;
    }

    @Override
    public final String getRule() {
        return "What is the result of the expression?";
    }
}
