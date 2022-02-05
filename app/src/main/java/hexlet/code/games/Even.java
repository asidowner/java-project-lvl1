package hexlet.code.games;

import hexlet.code.Engine;


public final class Even implements Engine {
    @Override
    public void getQuestion() {
        int askingNumber = getRandomPositiveNumber();
        Engine.QUESTIONS.put(Integer.toString(askingNumber), askingNumber % 2 == 0 ? "yes" : "no");
    }

    @Override
    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
