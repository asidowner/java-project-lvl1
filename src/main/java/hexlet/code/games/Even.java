package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Even {
    private static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int RANGE = 50;

    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        while (questions.size() < Engine.ROUNDS) {
            generateRoundData(questions);
        }

        Engine.initGame(RULE, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {

        int question = Utils.getRandomPositiveNumber(RANGE);
        String answer = question % 2 == 0 ? "yes" : "no";
        data.put(String.valueOf(question), answer);
    }
}
