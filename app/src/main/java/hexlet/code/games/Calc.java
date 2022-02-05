package hexlet.code.games;

import hexlet.code.Engine;

public final class Calc implements Engine {
    @Override
    public void getQuestion() {

        int firstNumber = getRandomPositiveNumber();
        int secondNumber = getRandomPositiveNumber();

        String operator = getRandomOperator();

        int sum = switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };

        String question = firstNumber + " " + operator + " " + secondNumber;
        Engine.QUESTIONS.put(question, Integer.toString(sum));

    }

    @Override
    public String getRule() {
        return "What is the result of the expression?";
    }
}
