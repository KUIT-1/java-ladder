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
            LadderPosition ladderPosition = new LadderPosition(position, ypos);

            System.out.println("Before");
            ladderPosition.printLadder(rows);

            rows[i].nextPosition(position);

            System.out.println("After");
            ladderPosition.printLadder(rows);
        }

        position.plusPosition();

        return position.getPosition();
    }
}
