package ladder;

public class Ladder {
    private LadderRun ladderRun;

    public Ladder(int height, int numberOfPerson) {
        validateLadder(height, numberOfPerson);
        ladderRun = new LadderRun(height, numberOfPerson);
    }

    public void drawLine(int row, int col) {
        ladderRun.drawLine(row, col);
    }

    public int run(int startPoint) {
        return ladderRun.run(startPoint);
    }

    private void validateLadder(int height, int numberOfPerson) {
        if(height <= 0 || height > 10)
            throw new IllegalArgumentException("높이는 1 이상 10 이하여야 합니다.");
        if(numberOfPerson <= 0 || numberOfPerson > 20)
            throw new IllegalArgumentException("인원수는 1명 이상 20명 이하여야 합니다.");
    }
}
