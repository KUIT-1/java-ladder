package ladder.runner;

import ladder.Point;
import ladder.Position;
import ladder.Row;
import ladder.view.LadderViewResolver;

public class LadderRunner {
    Row[] rows;
    LadderViewResolver ladderViewResolver = new LadderViewResolver();

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition) {
        String status;
        for (int i = 0; i < rows.length; i++) {
            System.out.print("step: ");
            System.out.println(i+1);
            System.out.println("before");
            status = ladderViewResolver.getLadderView(rows, Point.createPoint(Position.createPosition(i), startPosition));
            System.out.println(status);

            rows[i].getNextPosition(startPosition);

            System.out.println("after");
            status = ladderViewResolver.getLadderView(rows, Point.createPoint(Position.createPosition(i), startPosition));
            System.out.println(status);
            System.out.println("----------------------------------------------------");
        }
        return startPosition;
    }
}
