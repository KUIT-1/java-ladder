package ladder;

import ladder.domain.wrapper.LadderNumber;
import ladder.factory.LadderGameFactory;

public class LadderGameStarter {

    public static void main(String[] args) {

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(4, 5);
        System.out.println("시작 0 = " + ladderGame.run(LadderNumber.of(0)));
    }
}
