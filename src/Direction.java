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
}
