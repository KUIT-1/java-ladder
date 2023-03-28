package ladder;

import ladder.creator.LadderCreator;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }

        return position.getPosition();
    }


    public void printLadderGame(Position position){
        LadderPosition ladderPosition = LadderPosition.createLadderPosition(position, 0);

        for (int i = 0; i < rows.length; i++) {
            ladderPosition.setLocation(position, i);
            System.out.println("Before");
            printLadder(ladderPosition);
            System.out.println();
            System.out.println("After");
            printLadderAfter(ladderPosition);
            System.out.println();
        }

        return;
    }

    private void printLadder(LadderPosition ladderPosition){
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(ladderPosition,ladderPosition.checkCurrentRow(i));
            if(ladderPosition.checkCurrentRow(i)) rows[i].nextPosition(ladderPosition.getX());
        }
    }

    private void printLadderAfter(LadderPosition ladderPosition){
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(ladderPosition,ladderPosition.checkCurrentRow(i));
        }
    }
}