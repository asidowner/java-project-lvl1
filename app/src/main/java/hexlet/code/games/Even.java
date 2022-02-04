package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Even implements Engine {
    @Override
    public final Map<String, String> getQuestions() {
        Map<String, String> questions = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < Engine.ANSWER_FOR_WIN; i++) {
            final int maxNumber = 100;
            int askingNumber = random.nextInt(random.nextInt(maxNumber));
            questions.put(Integer.toString(askingNumber), askingNumber % 2 == 0 ? "yes" : "no");
        }
        return questions;
    }

    @Override
    public final String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
