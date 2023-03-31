package ladder;

import ladder.creator.GeneralLadderCreator;
import ladder.creator.RandomLadderCreator;

import java.util.HashSet;
import java.util.Random;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(){
        HashSet<LadderPosition> numOfLine = new HashSet<LadderPosition>();

        LadderSize ladderSize = LadderSize.createRandomLadderSize();
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize, numOfLine);

        Random random = new Random();

        while (true){
            Position randomRowPos = Position.createPosition(random.nextInt(ladderSize.getRowSize().getNumber())+1);
            Position randomColPos = Position.createPosition(random.nextInt(ladderSize.getColSize().getNumber())+1);
            randomRowPos.minusPosition();
            randomColPos.minusPosition();

            LadderPosition ladderPosition = LadderPosition.createLadderPosition(randomRowPos, randomColPos);

            randomLadderCreator.drawLine(ladderPosition);

            if(numOfLine.size() == ladderSize.numOfLine().getNumber()){
                break;
            }

        }

        return new LadderGame(randomLadderCreator);
    }

    public static LadderGame createLadderGame(LadderSize ladderSize){
        GeneralLadderCreator generalLadderCreator = new GeneralLadderCreator(ladderSize);

        return new LadderGame(generalLadderCreator);
    }

}
