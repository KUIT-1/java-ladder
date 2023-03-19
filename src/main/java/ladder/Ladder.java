package ladder;

public class Ladder {

    private final int[][] rows;
    int height;
    int numberOfPerson;

    public Ladder(int height, int numberOfPerson) {
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        rows = new int[height+1][numberOfPerson+1];

    }

    public int run(int startNumber) {
        return startNumber;
    }

}
