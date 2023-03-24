package ladder;

import java.awt.*;

public class LadderPositionFactory {

    public static Ladder createLadder(int row, int numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    public static Position createPosition(Ladder ladder, int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY), ladder);
    }
}
