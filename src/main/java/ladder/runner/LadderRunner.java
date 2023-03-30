package ladder.runner;

import ladder.Point;
import ladder.Position;
import ladder.Row;
import ladder.StringManager;
import ladder.view.LadderViewHelper;

import static ladder.Position.createPosition;

public class LadderRunner {
    Row[] rows;
    LadderViewHelper ladderViewHelper = new LadderViewHelper();
    StringManager stringManager = new StringManager();

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition) {
        System.out.println(stringManager.getStartMessage());
        System.out.println(stringManager.getDoubleDash());
        for (int i = 0; i < rows.length; i++) {
            viewEachStep(startPosition, i, "before");
            rows[i].getNextPosition(startPosition);
            viewEachStep(startPosition, i, "after");
        }
        System.out.println(stringManager.getEndMessage());
        return startPosition;
    }

    private void viewEachStep(Position startPosition, int i, String str) {
        String status;
        System.out.print(stringManager.getStepInfoMessage());
        System.out.println(i + 1);
        System.out.println(str);
        status = ladderViewHelper.getLadderView(rows, Point.createPoint(createPosition(i), startPosition));
        System.out.println(status);
        if (str.equals("after")) {
            System.out.println(stringManager.getSingleDash());
        }
    }
}
