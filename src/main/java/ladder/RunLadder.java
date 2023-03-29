package ladder;

public class RunLadder {

    Row[] ladder;
    public RunLadder(Row[] ladder) {
        this.ladder=ladder;
    }

    int run(Position position){

        for(int i=0;i<ladder.length;i++){
            ladder[i].nextPosition(position);
        }

        return position.getPosition();

    }
}
