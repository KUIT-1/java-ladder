package ladder;

import ladder.wrapper.LadderNumber;
import ladder.wrapper.Row;

public class LadderRunner {

    Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(LadderNumber ladderNum) {
        for (Row row : rows) {
            row.nextPosition(ladderNum);
        }

        return ladderNum.getNumber();
    }

}
