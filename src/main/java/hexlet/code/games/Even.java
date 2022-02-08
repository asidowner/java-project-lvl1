package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Even {
    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        for (int i = 0; i < Engine.getRoundsCount(); i++) {
            generateRoundData(questions);
        }

        final String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.initGame(rule, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 50;

        int question = Utils.getRandomPositiveNumber(range);
        String answer = question % 2 == 0 ? "yes" : "no";
        data.put(String.valueOf(question), answer);
    }
}
