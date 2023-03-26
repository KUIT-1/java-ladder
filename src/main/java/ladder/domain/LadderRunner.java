package ladder.domain;

import ladder.domain.wrapper.LadderNumber;

public class LadderRunner {

    private Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(LadderNumber ladderNum) {
        for (Row row : ladder.getRows()) {
            row.nextPosition(ladderNum);
        }

        return ladderNum.getNumber();
    }

}
