package ladder;

public enum Direction {
    LEFT(-1), CENTER(0), RIGHT(1);
    private int dirction;

    Direction(int dirction) {
        this.dirction = dirction;
    }

    public int getDirction() {
        return dirction;
    }
}
