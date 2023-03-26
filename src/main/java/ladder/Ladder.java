package ladder;

public class Ladder {
    private LadderRun ladderRun;

    public Ladder(NaturalNumber height, NaturalNumber numberOfPerson) {
        ladderRun = new LadderRun(height, numberOfPerson);
    }

    public void drawLine(Position row, Position col) {
        ladderRun.drawLine(row, col);
    }

    public int run(Position startPoint) {
        return ladderRun.run(startPoint);
    }

}
