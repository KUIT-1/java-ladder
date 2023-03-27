package ladder;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;

public class LadderRunner {

    private LineByRow[] lineByRows;
    private final NaturalNumber numberOfPerson;
    private final NaturalNumber height;

    public LadderRunner(LineByRow[] lineByRows) {
        this.lineByRows = lineByRows;
        numberOfPerson = lineByRows[1].lengthOfRow();
        height = createNaturalNumber(lineByRows.length - 1);
    }

    public int run(Position startPoint) {
        Node node = new Node(startPoint);
        Position lastPoint = startPoint;
        validateStartPoint(startPoint);

        while(node.isRowExceedValue(height)){
            printLineByRows(node);
            System.out.println("\t\t\t\t↓");

            lastPoint = node.move(lineByRows);
        }
        System.out.println("\n\n=================\n");

        return lastPoint.getPosition();
    }

    public void validateStartPoint(Position startPoint) {
        if(startPoint.getPosition() > numberOfPerson.getNumber())
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

    public String printLineByRows(Node node) {
        String str_Ladder = "";
        boolean IsCurrentRow = false;

        for(int row = 1; row <= height.getNumber(); row++){
            if(node.isEqualRow(createPosition(row)))
                IsCurrentRow = true;
            str_Ladder += lineByRows[row].infoRow(IsCurrentRow, node) + "\n";
            IsCurrentRow = false;
        }
        return str_Ladder;
    }

}
