package ladder;

public class LadderGame2 {
    CreateLadder2 ladder;

    public LadderGame2(CreateLadder2 ladder) {
        this.ladder = ladder;
    }

    int run(Position col){
        RunLadder runLadder=new RunLadder(ladder.getLadder());
        return runLadder.run(col);
    }
}
