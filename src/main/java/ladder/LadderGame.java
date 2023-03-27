package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {
    private LadderCreator ladderCreator;

    public LadderGame(NaturalNumber height, NaturalNumber numberOfPerson) {
        this.ladderCreator = new LadderCreator(height, numberOfPerson);
    }

    public void drawLine(Position row, Position col) {
        ladderCreator.drawLine(row, col);
    }

    public int run(Position startPoint) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getLineByRows());
        return ladderRunner.run(startPoint);
    }

}
