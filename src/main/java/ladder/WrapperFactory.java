package ladder;

import ladder.wrapper.Position;

import java.awt.*;

public class WrapperFactory {

    public static Position createPosition(LadderGame ladderGame, int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY), ladderGame);
    }
}
