import java.util.Locale;
import java.util.Scanner;

public class Game {

    Player player;

    public Game() {
        Scene entrance = new Scene("A vár bejáratánál állsz. Északra egy nagy faajtó található.");
        Scene hall = new Scene("A nagyteremben vagy. Keletre és nyugatra is van egy-egy ajtó.");
        Scene armory = new Scene("A fegyvertárban vagy. Látsz egy fényes kardot az állványon.");

        entrance.setExit(Direction.ÉSZAK, hall);
        hall.setExit(Direction.DÉL, entrance);
        hall.setExit(Direction.NYUGAT, armory);
        armory.setExit(Direction.KELET, hall);

        player = new Player(entrance);
    }

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
            display("------------------------------");
            display(player.getCurrentScene().getDescription());
            display(">");
            //scaner nextLine() mindig egy teljes sort olvas be

            String input = scanner.nextLine().toLowerCase(Locale.ROOT).trim();

            String[] words = input.split(" ");
            String command = words[0];

            // Ha van 2. szó itt kinyerjük egy ternary operátorral -> ugyanaz, mint egy if-then, csak tömör
            String subject = words.length > 1 ? words[1] : "";

            switch (command) {
                case "menj":
                    Direction direction = Direction.fromString(subject);
                    movePlayer(direction);
                    break; // ha nincs break, akkor tovább menne a következő ágra, szóval kötelezően kell

                case "kilép":
                    display("Köszi a játékot!");
                    scanner.close();
                    return;

                default:
                    display("Nem értem a parancsot!");
                    break;
            }
        }
    }

    private void movePlayer(Direction direction) {
        Scene nextScene = player.getCurrentScene().getExit(direction);

        if (nextScene == null) {
            display("Nem mehetsz arra!");
            return;
        }
        else {
            player.setCurrentScene(nextScene);
        }


    }

    private void display(String message) {
        System.out.println(message);
    }
}