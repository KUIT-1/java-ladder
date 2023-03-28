package ladder;

import ladder.domain.wrapper.LadderNumber;
import ladder.factory.LadderFactory;

public class LadderGameStarter {

    public static void main(String[] args) {

        LadderGame ladderGame = LadderFactory.createLadderGame(
                LadderFactory.createRandomLadderCreator(4, 5));
        ladderGame.getLadderCreator().drawLine();
        System.out.println("시작 0 = " + ladderGame.run(LadderNumber.createLadderNumber(0)));
    }
}
