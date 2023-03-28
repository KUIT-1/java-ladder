package ladder;

import ladder.creator.LadderCreator;
import ladder.runner.LadderRunner;

public class LadderGame {
    LadderCreator ladderCreator;

    public LadderGame(NaturalNumber row, NaturalNumber numberOfPerson) {
        ladderCreator = new LadderCreator(row, numberOfPerson);
    }

    public void drawLine(Position row, Position col){
        ladderCreator.drawLine(row, col);
    }

    public Position run(Position startPosition) {

        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(startPosition);
    }
}
