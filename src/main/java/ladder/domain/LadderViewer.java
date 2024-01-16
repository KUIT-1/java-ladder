package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;

public class LadderViewer {

    private final Ladder ladder;

    private LadderViewer(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderViewer of(Ladder ladder) {
        return new LadderViewer(ladder);
    }

    public void view(String message, CurrentPosition currentPosition) {
        System.out.println(message);
        ladder.view(currentPosition);
        System.out.println();
    }

}
