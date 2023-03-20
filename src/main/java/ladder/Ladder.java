package ladder;

public class Ladder {
    private LadderRun ladderRun;
    private PositionManager positionManager;

    public Ladder(int height, int numberOfPerson) {
        validateLadder(height, numberOfPerson);
        positionManager = new PositionManager(height, numberOfPerson);
        ladderRun = new LadderRun(positionManager);
    }

    private void validateLadder(int height, int numberOfPerson) {
        if(height <= 0 || numberOfPerson <= 0)
            throw new IllegalArgumentException("높이와 인원수 값이 유효하지 않습니다.");
    }

    public void drawLine(int row, int col) {
        positionManager.drawLine(row, col);
    }

    public int run(int startPoint) {
        return ladderRun.run(startPoint);
    }
}
