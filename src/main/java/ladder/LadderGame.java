package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    LadderCreator ladderCreator;

    public LadderGame(NumberOfRow row, NumberOfPerson numberOfPerson) {
        ladderCreator = LadderPositionFactory.createLadderCreator(row, numberOfPerson);
    }

    public void drawLine(int x, int leftY, int rightY) {
        ladderCreator.drawLine(x,leftY,rightY);
    }

    public int run(LadderNumber ladderNum) {
        return LadderPositionFactory.createLadderRunner(ladderCreator).run(ladderNum);
    }

    public int getNumberOfPerson() {
        return ladderCreator.getRows()[0].getLength();
    }

    public int getRow() {
        return ladderCreator.getRows().length;
    }

    public Row[] getRowsForTest() {
        return ladderCreator.getRows();
    }

}
