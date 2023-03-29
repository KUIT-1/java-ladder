package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void drawLine(LadderPosition ladderPosition) {
        ladderCreator.drawLine(ladderPosition);
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRow());
        return ladderRunner.run(position);
    }
}