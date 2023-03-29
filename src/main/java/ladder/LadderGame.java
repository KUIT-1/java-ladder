package ladder;

import ladder.creator.LadderCreator;
import ladder.runner.LadderRunner;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator; // DI
    }

    public void drawLine(Position row, Position col){
        ladderCreator.drawLine(row, col);
    }

    public Position run(Position startPosition) {

        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(startPosition);
    }
}
