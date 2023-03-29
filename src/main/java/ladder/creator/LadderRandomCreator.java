package ladder.creator;

import ladder.*;

import java.util.HashSet;

import static ladder.LadderPosition.createLadderPosition;

public class LadderRandomCreator implements LadderCreator {
    private final Row[] rows;
    LadderSize ladderSize;
    int numOfLine = 0;

    public LadderRandomCreator(NaturalNumber row, NaturalNumber numberOfPerson) {

        ladderSize = LadderSize.createLadderSize(row.getNumber(),numberOfPerson.getNumber());
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        getRandomLines();
    }

    private void getRandomLines(){
        HashSet<LadderPosition> set = new HashSet<>();
        numOfLine = ladderSize.getRandomNumber();
        int numofCurrentLine = 0;
        while(numofCurrentLine<numOfLine) {
            if(addLadderPositionHashSet(set)) numofCurrentLine++;
        }
    }

    public boolean addLadderPositionHashSet(HashSet<LadderPosition> set){
        LadderPosition ladderPosition = getLandomLadderPosition();
        int beforeSize = set.size();
        set.add(ladderPosition);
        if (beforeSize < set.size()){
            try{
                drawLine(ladderPosition.getX(), ladderPosition.getY());
                return true;
            }catch (IllegalArgumentException e){}
        }
        return false;
    }

    public LadderPosition getLandomLadderPosition(){
        Position randomRow = Position.createPosition(ladderSize.getRandomRow());
        int randomCol = ladderSize.getRandomCol();
        return createLadderPosition(randomRow,randomCol);
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public Row[] getRow() {
        return rows;
    }
}
