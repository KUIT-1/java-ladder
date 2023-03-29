package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRow());
        ladderRunner.run(position);

        return position.getPosition();
    }

    public void drawLine(LadderPosition ladderPosition){
        ladderCreator.drawLine(ladderPosition);
    }

}
