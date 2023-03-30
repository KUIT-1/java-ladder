package ladder.lineinfo;

import ladder.Direction;
import ladder.NaturalNumber;
import ladder.Node;
import ladder.Position;
import ladder.lineinfo.LineByPosition;

public class LineByRow {
    private LineByPosition[] lineByPositions;
    private static final int START_INDEX = 1;


    public LineByRow(NaturalNumber numberOfPerson) {
        lineByPositions = new LineByPosition[numberOfPerson.getNumber() + 1];
        initLineByPosition(numberOfPerson);
    }

    private void initLineByPosition(NaturalNumber numberOfPerson) {
        for(int col = START_INDEX; col <= numberOfPerson.getNumber(); col++){
            lineByPositions[col] = new LineByPosition();
        }
    }

    public void addLinetoRight(Position col) {
        lineByPositions[col.getPosition()].addLinetoRight();
    }

    public void addLinetoLeft(Position col) {
        lineByPositions[col.getPosition()].addLinetoLeft();
    }

    public Direction nextDirection(Position col, Direction state) {
        return lineByPositions[col.getPosition()].nextDirection(state);
    }

    public NaturalNumber lengthOfRow(){
        return NaturalNumber.createNaturalNumber(lineByPositions.length - 1);
    }

    public String infoRow(boolean isCurrentRow, Node node) {
        String str_row = "";
        for(int col = START_INDEX; col < lineByPositions.length;col++){
            str_row += lineByPositions[col].infoLine();
            if(isCurrentRow && node.isEqualCol(Position.createPosition(col)))
                str_row += "*";
            str_row += "\t";
        }
        return str_row;
    }

}
