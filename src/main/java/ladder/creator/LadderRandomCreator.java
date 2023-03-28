package ladder.creator;

import ladder.LadderSize;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;

public class LadderRandomCreator {
    private final Row[] rows;
    LadderSize ladderSize;
    int numOfLine = 0;

    public LadderRandomCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        HashSet<LadderSize> set = new HashSet<LadderSize>();
        ladderSize = LadderSize.createLadderSize(row.getNumber(),numberOfPerson.getNumber());
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        numOfLine = ladderSize.getRandomNumber();
        System.out.println(numOfLine);
        int numofCurrentLine = 0;
        while(numofCurrentLine<numOfLine){
            try {
                Position randomRow = Position.createPosition(ladderSize.getRandomRow());
                Position randomCol = Position.createPosition(ladderSize.getRandomCol());;

                int beforeSize = set.size();
                set.add(LadderSize.createLadderSize(randomRow.getPosition(),randomCol.getPosition()));

                if(beforeSize<set.size()){
                    drawLine(randomRow,randomCol);
                    System.out.println(randomRow.getPosition()+" "+randomCol.getPosition());
                    numofCurrentLine++;
                }

            }catch (IllegalArgumentException e){
            }
        }

    }

    public void getRandomTest(){
        for (int i = 0; i < 10; i++) {
            System.out.println("실행 "+Integer.toString(ladderSize.getRandomCol())+" "+ Integer.toString(ladderSize.getRandomRow()));
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRow() {
        return rows;
    }
}
