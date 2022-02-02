package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        getGameList(); // Получаем список игр
        chooseGame(); // Выбираем игру
    }

    public static void getGameList() {
        Map<Integer, String> games = new LinkedHashMap<>();

        games.put(1, "Greet");
        games.put(2, "Even");
        games.put(0, "Exit");

        System.out.println("Please enter the game number and press Enter.");
        for (Integer key : games.keySet()) {
            System.out.printf("%s - %s\n", key, games.get(key));
        }
        System.out.print("Your choice: ");
    }

    public static void chooseGame() {
        Scanner scanner = new Scanner(System.in);

        int choseGame = scanner.nextInt();

        if (choseGame != 0) { // 0 - Exit
            String name = Cli.greet(scanner);
            if (choseGame == 2) {
                Even.game(scanner, name);
            }
        }
    }
}
