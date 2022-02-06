package hexlet.code;


import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        LinkedHashMap<String, String> games = new LinkedHashMap<>();
        String[] gameNames = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

        for (int i = 1; i < gameNames.length; i++) {
            games.put(String.valueOf(i), gameNames[i]);
        }
        games.put(String.valueOf(0), gameNames[0]);

        for (String gameId : games.keySet()) {
            System.out.printf("%s - %s\n", gameId, games.get(gameId));
        }

        System.out.print("Your choice: ");

        Engine.chooseGame(games);
    }
}
