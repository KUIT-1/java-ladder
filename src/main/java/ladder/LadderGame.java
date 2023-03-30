package ladder;

import ladder.creator.LadderCreator;
//import ladder.creator.LadderCreator;

public class LadderGame {
//    private LadderCreator ladderCreator;
    private LadderCreator ladderCreator;
    // DI
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void drawLine(Position row, Position col) {
        ladderCreator.drawLine(row, col);
    }

    public int run(Position startPoint) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getLineByRows());
        return ladderRunner.run(startPoint);
    }

}
