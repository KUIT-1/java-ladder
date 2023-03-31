package ladder;

public class LadderRunner {
    private final Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(int startPosition) {
        int currentPosition = startPosition;
        for (Row row : ladder.getRows()) {
            if (currentPosition > 1 && row.isLineDrawn(currentPosition - 1)) {
                currentPosition--;
            } else if (currentPosition < row.getNumberOfPerson() && row.isLineDrawn(currentPosition)) {
                currentPosition++;
            }
        }
        return currentPosition;
    }
}
