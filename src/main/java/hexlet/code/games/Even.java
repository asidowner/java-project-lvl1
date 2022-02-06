package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Even {
    public static HashMap<String, String> getQuestions(int count) {
        HashMap<String, String> questions = new HashMap<>();
        final int range = 100;
        for (int i = 0; i < count; i++) {
            int askingNumber = Engine.getRandomPositiveNumber(range);
            questions.put(
                    String.valueOf(askingNumber),
                    askingNumber % 2 == 0 ? "yes" : "no");
        }
        return questions;
    }

    public static String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
