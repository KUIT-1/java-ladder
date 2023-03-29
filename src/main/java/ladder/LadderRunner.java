package ladder;

import static ladder.LadderPosition.createLadderPosition;

public class LadderRunner {

    Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i=1; i<rows.length; i++) {
            Position x = Position.createPosition(i);
            LadderPosition ladderPosition = createLadderPosition(x, position);

            System.out.println("Before");
            printRows(ladderPosition);

            rows[i].nextPosition(position);

            System.out.println("After");
            printRows(ladderPosition);
        }

        return position.getPosition();
    }

    private void printRows(LadderPosition ladderPosition) {
        for (int i=1; i<rows.length; i++) {
            Position x = Position.createPosition(i);
            System.out.println(rows[i].rowToString(ladderPosition, x));
        }
    }
}
