package ladder.runner;

import ladder.Position;
import ladder.Row;

public class LadderRunner {
    Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public Position run(Position startPosition) {
        // ladderStartNum 을 선택한 경우에 ladderEdnNum 에 도달한다
        for (Row row : rows) {
            row.getNextPosition(startPosition);
        }
        return startPosition;
    }
}
