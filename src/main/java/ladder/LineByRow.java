package ladder;

public class LineByRow {
    private LineByPosition[] lineByPositions;

    public LineByRow(NaturalNumber numberOfPerson) {
        lineByPositions = new LineByPosition[numberOfPerson.getNumber() + 1];
        initLineByPosition(numberOfPerson);
    }

    private void initLineByPosition(NaturalNumber numberOfPerson) {
        for(int col = 1; col <= numberOfPerson.getNumber(); col++){
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
        for(int col = 1; col < lineByPositions.length;col++){
            str_row += lineByPositions[col].infoLine();
            if(isCurrentRow && node.isEqualCol(Position.createPosition(col)))
                str_row += "*";
            str_row += "\t";
        }
        return str_row;
    }

}
