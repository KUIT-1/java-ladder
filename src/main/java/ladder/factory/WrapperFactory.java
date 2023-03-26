package ladder.factory;

import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.Position;

import java.awt.*;

public class WrapperFactory {

    public static Position createPosition(LadderCreator ladderCreator, int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY), ladderCreator);
    }
}
