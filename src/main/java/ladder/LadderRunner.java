package ladder;

import ladder.lineinfo.LineByRow;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;

public class LadderRunner {

    private LineByRow[] lineByRows;
    private final NaturalNumber numberOfPerson;
    private final NaturalNumber height;
    private static final int START_INDEX = 1;

    public LadderRunner(LineByRow[] lineByRows) {
        this.lineByRows = lineByRows;
        numberOfPerson = lineByRows[START_INDEX].lengthOfRow();
        height = createNaturalNumber(lineByRows.length - START_INDEX);
    }

    public int run(Position startPoint) {
        validateStartPoint(startPoint);
        Node node = new Node(startPoint);
        Position lastPoint = startPoint;

        System.out.println("start : "+ startPoint.getPosition());

        while(node.isRowExceedValue(height)){
            printLineByRows(node);
            System.out.println("\t\t\t\t↓");
            lastPoint = node.move(lineByRows);
        }
        System.out.println("\t\tans :\t"+lastPoint.getPosition());
        System.out.println("=================\n");

        return lastPoint.getPosition();
    }

    public void validateStartPoint(Position startPoint) {
        if(startPoint.getPosition() > numberOfPerson.getNumber())
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

    public void printLineByRows(Node node) {
        String str_Ladder = "";
        boolean IsCurrentRow = false;

        for(int row = START_INDEX; row <= height.getNumber(); row++){
            if(node.isEqualRow(createPosition(row)))
                IsCurrentRow = true;
            str_Ladder += lineByRows[row].infoRow(IsCurrentRow, node) + "\n";
            IsCurrentRow = false;
        }

        System.out.print(str_Ladder);
    }

}
