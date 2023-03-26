package ladder;

import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.Row;
import ladder.factory.LadderFactory;

/** 얘가 핸들러? */
public class LadderGame {

    private LadderCreator LadderCreator;

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

    /**
     * 이건 수정해보기
     * @return
     */
    public ladder.domain.creator.LadderCreator getLadderCreator() {
        return LadderCreator;
    }
}
