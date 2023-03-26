package ladder;

public class Ladder {
    private LadderRun ladderRun;

    public Ladder(NaturalNumber height, NaturalNumber numberOfPerson) {
        ladderRun = new LadderRun(height, numberOfPerson);
    }

    public void drawLine(int row, int col) {
        ladderRun.drawLine(row, col);
    }

    public int run(NaturalNumber startPoint) {
        return ladderRun.run(startPoint);
    }

}
