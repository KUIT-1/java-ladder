package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator{
    private final Rows[] rows;
    private final LadderSize ladderSize;
    HashSet<LadderPosition> numOfLine;

    public RandomLadderCreator(LadderSize ladderSize, HashSet numOfLine) {
        this.numOfLine = numOfLine;
        this.ladderSize = ladderSize;
        rows = new Rows[ladderSize.getRowSize().getNumber()];
        for (int i = 0; i < ladderSize.getRowSize().getNumber(); i++) {
            rows[i] = new Rows(ladderSize.getColSize());
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition){
        validatePositionSize(ladderPosition.getRowPosition());

        if(rows[ladderPosition.getRowPosition().getPosition()].RandomLadderDrawLine(ladderPosition.getColPosition())){
            numOfLine.add(ladderPosition);
            System.out.println(ladderPosition.getRowPosition().getPosition());
            System.out.println(ladderPosition.getColPosition().getPosition());
        }
    }

    @Override
    public void validatePositionSize(Position position) {
        if (!position.isSmaller(rows.length)) {
            throw new IllegalArgumentException("올바른 사다리의 위치가 아닙니다.");
        }
    }

    @Override
    public Rows[] getRow() {
        return rows;
    }

}
