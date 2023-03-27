package ladder;

public class LadderPosition {
    private Position x, y;

    public LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public void printLadder(Rows[] rows){
        for(int j = 0; j< rows.length; j++){
            compareAndPrint(j, rows);
        }
        System.out.println();
    }

    private void compareAndPrint(int j, Rows[] rows){
        if(y.getPosition()==j) {
            rows[j].printRow(true, x);
            return;
        }
        rows[j].printRow(false, x);
    }

}
