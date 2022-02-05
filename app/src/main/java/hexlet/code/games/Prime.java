package hexlet.code.games;

import hexlet.code.Engine;

public final class Prime implements Engine {
    @Override
    public void getQuestion() {
        int question = getRandomPositiveNumber();
        String answer = isPrime(question) ? "yes" : "no";

        Engine.QUESTIONS.put(String.valueOf(question), answer);
    }

    @Override
    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
