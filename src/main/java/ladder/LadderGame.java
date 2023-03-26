package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    LadderCreator LadderCreator;

    public LadderGame(NumberOfRow row, NumberOfPerson numberOfPerson) {
        LadderCreator = LadderFactory.createSelfLadderCreator(row, numberOfPerson);
    }

    public void drawLine(int x, int leftY, int rightY) {
        LadderCreator.drawLine(x,leftY,rightY);
    }

    public int run(LadderNumber ladderNum) {
        return LadderFactory.createLadderRunner(LadderCreator).run(ladderNum);
    }

    public int getNumberOfPerson() {
        return LadderCreator.getRows()[0].getLength();
    }

    public int getRow() {
        return LadderCreator.getRows().length;
    }

    public Row[] getRowsForTest() {
        return LadderCreator.getRows();
    }

}
