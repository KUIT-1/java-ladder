package ladder;

import ladder.creator.AutogenerateLadderCreator;
import ladder.creator.CustomizationLadderCreator;

public class LadderGameFactory {
    private LadderGameFactory(){}

    public static LadderGame CustomizationLadderGame(LadderSize ladderSize){
        CustomizationLadderCreator customizationLadderCreator = new CustomizationLadderCreator(ladderSize);
        return new LadderGame(customizationLadderCreator);
    }

    public static LadderGame AutogenerateLadderGame(LadderSize ladderSize){
        AutogenerateLadderCreator autogenerateLadderCreator = new AutogenerateLadderCreator(ladderSize);
        return new LadderGame(autogenerateLadderCreator);
    }

}
