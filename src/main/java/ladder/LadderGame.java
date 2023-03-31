package ladder;

public class LadderGame {
    ManualLadderCreator ladder;

    public LadderGame(ManualLadderCreator ladder) {
        this.ladder = ladder;
        printLadderGame(ladder);
    }

    private void printLadderGame(ManualLadderCreator ladder) {
        ladder.printLadder();
    }

    int run(Position position){
        RunLadder runLadder=new RunLadder(ladder.getLadder());
        return runLadder.run(position);
    }
}
