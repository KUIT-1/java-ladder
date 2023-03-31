package ladder;

public class LadderRunner {
    private final Rows[] rows;

    public LadderRunner(Rows[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        position.minusPosition();

        for(int i = 0; i< rows.length; i++){
            Position ypos = Position.createPosition(i+1);
            ypos.minusPosition();
            LadderPosition ladderPosition = LadderPosition.createLadderPosition(position,ypos);

            System.out.println("Before");
            printLadder(ladderPosition);

            rows[i].nextPosition(position);

            System.out.println("After");
            printLadder(ladderPosition);
        }

        position.plusPosition();

        return position.getPosition();
    }

    public void printLadder(LadderPosition ladderPosition){
        for(int j = 0; j< rows.length; j++){
            compareAndPrintRow(j, ladderPosition);
        }
        System.out.println();
    }

    private void compareAndPrintRow(int j, LadderPosition ladderPosition){
        if(ladderPosition.getColPosition().getPosition()==j) {
            rows[j].printRow(true, ladderPosition.getRowPosition());
            return;
        }
        rows[j].printRow(false, ladderPosition.getRowPosition());
    }
}
