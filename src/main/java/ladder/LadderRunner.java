package ladder;

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
            printLadder(ladderPosition, "before");
            rows[ladderPosition.getYPosition()].nextPosition(ladderPosition.getX());
            printLadder(ladderPosition, "after");
        }

        return;
    }

    private void printLadder(LadderPosition ladderPosition, String state){
        System.out.println(state);
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(ladderPosition.getXPosition(),ladderPosition.checkCurrentRow(i));
        }
        System.out.println();
    }
}