public enum Direction {
    ÉSZAK("észak"),
    DÉL("dél"),
    KELET("kelet"),
    NYUGAT("nyugat");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.direction;
    }

    public static Direction fromString(String text) {
        for (Direction d : Direction.values()) {
            if (d.direction.equalsIgnoreCase(text)) {
                return d;
            }
        }

        return null;
    }
}
