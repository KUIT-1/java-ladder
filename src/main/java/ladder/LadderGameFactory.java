package ladder;

import static ladder.LadderGame.createLadderGame;
import static ladder.LadderSize.createLadderSize;
import static ladder.creator.LadderNormalCreator.createLadderNormalCreator;
import static ladder.creator.LadderRandomCreator.createLadderRandomCreator;


//사다리가 Randomize한지 아닌지
public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(int ladderLength, int numberOfPerson) {
        LadderSize ladderSize = createLadderSize(ladderLength, numberOfPerson);
        LadderGame ladderGame = createLadderGame(createLadderRandomCreator(ladderSize));
        //어떤 값이 들어가던지 내부적으로 Randomize하게 만들어져서 아무 값이나 넣어주었음.
        ladderGame.drawLine(0,0,Direction.DOWN);
        return ladderGame;
    }

    public static LadderGame createNormalLadderGame(int ladderLength, int numberOfPerson) {
        LadderSize ladderSize = createLadderSize(ladderLength, numberOfPerson);
        return createLadderGame(createLadderNormalCreator(ladderSize));
    }
}
