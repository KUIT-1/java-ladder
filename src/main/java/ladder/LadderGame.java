package ladder;
import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }


    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRow());
        ladderRunner.run(position);

        return position.getPosition();
    }

    public int runWithPrint(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRow());
        ladderRunner.printLadderGame(position);

        System.out.println(position.getPosition());

        return position.getPosition();
    }
}
