package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Prime {
    public static String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static HashMap<String, String> getQuestions(int rounds) {
        HashMap<String, String> questions = new HashMap<>();
        final int range = 100;
        for (int i = 0; i < rounds; i++) {
            int question = Engine.getRandomPositiveNumber(range);
            String answer = Engine.isPrime(question) ? "yes" : "no";

            questions.put(String.valueOf(question), answer);
        }
        return questions;
    }
}
