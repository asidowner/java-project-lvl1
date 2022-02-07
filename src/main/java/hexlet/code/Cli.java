package hexlet.code;


public class Cli {
    public static void greet() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = Utils.getNextInput();

        System.out.printf("Hello, %s!\n", name);
    }
}
