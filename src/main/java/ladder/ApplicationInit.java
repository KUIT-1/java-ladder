package ladder;

import java.awt.*;

public class ApplicationInit {

    private static Ladder ladder;
    private static Position position;

    public static Ladder createLadder(int numberOfPerson, int row) {
        ApplicationInit.ladder = new Ladder(numberOfPerson, row);
        return ApplicationInit.ladder;
    }

    public static Position createPosition(int leftX, int leftY, int rightX, int rightY) {
        ApplicationInit.position = new Position(new Point(leftX, leftY), new Point(rightX, rightY), ApplicationInit.ladder);
        return ApplicationInit.position;
    }
}