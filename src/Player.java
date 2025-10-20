import java.util.ArrayList;

public class Player {
    private Scene scene;
    private ArrayList<Item> Inventory;

    public Player(Scene startingScene) {
        this.scene = startingScene;
        this.Inventory = new ArrayList<>();
    }

    public Scene getCurrentScene() {
        return this.scene;
    }

    public void setCurrentScene(Scene scene) {
        this.scene = scene;
    }

    public void takeItem(Item item) {
        this.Inventory.add(item);
    }

    public String getInventoryString() {
        if (this.Inventory.isEmpty()) {
            return "A leltárad üres.";
        }

        // A StringBuilder objektumot olyan szituációkban használjuk,
        // mint például egy loop, ahol sok stringet fűzünk össze (concat)
        // Ez azért szükséges, mert a Java-ban a String immutable,
        // és egyébként mindig újjat hozna létre, ami költséges és lassú
        StringBuilder returnString = new StringBuilder();

        for (Item item : this.Inventory) {
            returnString.append(" ").append(item.getName());
        }

        return returnString.toString();
    }
}