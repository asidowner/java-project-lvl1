package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Even {
    private static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int RANGE = 50;

    public static void startGame() {
        HashMap<String, String> gameData = new HashMap<>();

        while (gameData.size() < Engine.ROUNDS) {
            generateRoundData(gameData);
        }

        Engine.initGame(RULE, gameData);
    }

    private static void generateRoundData(HashMap<String, String> data) {

        int question = Utils.getRandomPositiveNumber(RANGE);
        String answer = question % 2 == 0 ? "yes" : "no";
        data.put(String.valueOf(question), answer);
    }
}
