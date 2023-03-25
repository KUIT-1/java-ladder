package ladder;

import ladder.creator.SelfLadderCreator;

public class LadderGame {

    SelfLadderCreator selfLadderCreator;

    public LadderGame(NumberOfRow row, NumberOfPerson numberOfPerson) {
        selfLadderCreator = LadderPositionFactory.createLadderCreator(row, numberOfPerson);
    }

    public void drawLine(int x, int leftY, int rightY) {
        selfLadderCreator.drawLine(x,leftY,rightY);
    }

    public int run(LadderNumber ladderNum) {
        return LadderPositionFactory.createLadderRunner(selfLadderCreator).run(ladderNum);
    }

    public int getNumberOfPerson() {
        return selfLadderCreator.getRows()[0].getLength();
    }

    public int getRow() {
        return selfLadderCreator.getRows().length;
    }

    public Row[] getRowsForTest() {
        return selfLadderCreator.getRows();
    }

}
