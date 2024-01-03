package ladder.factory;

import ladder.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

public class LadderGameFactory {

    private LadderGameFactory() {}

    public static LadderGame createSelfLadderGame(int row, int numberOfPerson) {
        SelfLadderCreator selfLadderCreator = new SelfLadderCreator(
                        Ladder.of(NumberOfRow.of(row), NumberOfPerson.of(numberOfPerson)));
        return LadderGame.of(selfLadderCreator);
    }

    public static LadderGame createRandomLadderGame(int row, int numberOfPerson) {
        Ladder ladder = Ladder.of(NumberOfRow.of(row), NumberOfPerson.of(numberOfPerson));
        SelfLadderCreator selfLadderCreator = new SelfLadderCreator(ladder);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladder, selfLadderCreator);
        return LadderGame.of(randomLadderCreator);
    }

}
