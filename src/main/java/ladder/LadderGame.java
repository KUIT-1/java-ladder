package ladder;

import ladder.creator.LadderCreator;


public class LadderGame{
    LadderCreator ladderCreator;
    private LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame createLadderGame(LadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }


    public boolean drawLine(int row, int col, Direction direction) {
       return ladderCreator.drawLine(row, col, direction);
    }

    public int run(int start) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getCols());
        return ladderRunner.run(start);
    }
    
}
