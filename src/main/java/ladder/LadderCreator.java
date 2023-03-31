package ladder;

import java.util.List;

public class LadderCreator {
    public static Ladder create(int numberOfRows, int numberOfPeoplePerRow, List<Position> positions) {
        Ladder ladder = new Ladder(numberOfRows, numberOfPeoplePerRow);

        for (Position position : positions) {
            ladder.drawLine(position.getRow(), position.getPosition());
        }

        return ladder;
    }

    public static Ladder create(int numberOfRows, int numberOfPeoplePerRow, List<Position> positions, List<Integer> startPoints) {
        Ladder ladder = create(numberOfRows, numberOfPeoplePerRow, positions);

        LadderRunner ladderRunner = new LadderRunner(ladder);


        return ladder;
    }
}

