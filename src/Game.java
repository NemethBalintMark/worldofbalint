import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // git remote add origin URL
        // git remote add origin https://github.com/NemethBalintMark/worldofbalint.git

        Game game = new Game();
        game.play();

    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display("Üdv a várkalandban!");

        while (true) {
            String input = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
            String command = input;

            switch (command) {
                case "kilep":
                    display("Köszi a játékot!");
                    scanner.close();
                    return;
            }
        }
    }

    private void display(String message) {
        System.out.println(message);
    }
}