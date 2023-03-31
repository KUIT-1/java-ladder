package ladder;

public class LadderGame {
    CreateLadder ladder;

    public LadderGame(CreateLadder ladder) {
        this.ladder = ladder;
        printLadderGame(ladder);
    }

    private void printLadderGame(CreateLadder ladder) {
        ladder.printLadder();
    }

    int run(Position position){
        RunLadder runLadder=new RunLadder(ladder.getLadder());
        return runLadder.run(position);
    }
}
