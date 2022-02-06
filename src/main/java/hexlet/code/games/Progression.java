package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Progression {

    public static String getRule() {
        return "What number is missing in the progression?";
    }

    public static HashMap<String, String> getQuestions(int rounds) {
        HashMap<String, String> questions = new HashMap<>();
        for (int i = 0; i < rounds; i++) {
            int[] progression = Engine.getArithmeticProgression();
            int randomIndex = Engine.getRandomPositiveNumber(progression.length - 1);
            int answer = progression[randomIndex];

            StringBuilder question = new StringBuilder();

            for (int j = 0; j < progression.length; j++) {
                question.append(j == randomIndex ? ".." : String.valueOf(progression[j])).append(" ");
            }

            questions.put(question.toString(), String.valueOf(answer));
        }

        return questions;
    }
}
