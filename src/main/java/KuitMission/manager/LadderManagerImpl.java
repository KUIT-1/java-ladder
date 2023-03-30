package KuitMission.manager;

import KuitMission.creator.LadderCreator;
import KuitMission.ladder.Ladder;
import KuitMission.printer.LadderPrinter;
import KuitMission.runner.LadderRunner;

public class LadderManagerImpl implements LadderManager {
    private final LadderCreator ladderCreator;
    private final LadderPrinter ladderPrinter;
    private final LadderRunner ladderRunner;
    private Ladder ladder;

    public LadderManagerImpl(LadderCreator ladderCreator, LadderPrinter ladderPrinter, LadderRunner ladderRunner) {
        this.ladderCreator = ladderCreator;
        this.ladderPrinter = ladderPrinter;
        this.ladderRunner = ladderRunner;

    }

    @Override
    public void createLadder(int numofPerson, int heightofLadder) {
        this.ladder = ladderCreator.createLadder(numofPerson, heightofLadder);
    }

    @Override
    public void drawLine(int numofLadder, int y) {
        this.ladder = ladderCreator.drawLine(ladder, numofLadder, y);
    }

    @Override
    public int run(Ladder ladder, int startNumofLadder) {
        return ladderRunner.run(ladder, startNumofLadder);
    }

    @Override
    public void print(Ladder ladder) {
        ladderPrinter.print(ladder);
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
