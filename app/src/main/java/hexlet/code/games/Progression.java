package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression implements Engine {

    @Override
    public void getQuestion() {
        final int[] progression = getArithmeticProgression();

        int randomIndex = getRandomPositiveNumber(progression.length - 1);

        int answer = progression[randomIndex];

        StringBuilder question = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            question.append(" ").append(i == randomIndex ? ".." : String.valueOf(progression[i]));
        }

        Engine.QUESTIONS.put(String.valueOf(question), String.valueOf(answer));
    }

    @Override
    public String getRule() {
        return "What number is missing in the progression?";
    }
}
