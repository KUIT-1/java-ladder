package ladder;

public class Ladder {

    //private final int[][] rows;
    private final Row[] rows;
    private final int row;
    private final int numberOfPerson;
    // public Ladder(int row, int numberOfPerson) {rows = new int[row][numberOfPerson];}

    public Ladder(int row, int numberOfPerson){
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        rows = new Row[row];
        for(int i=0; i<row; i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    //사다리의 각 라인의 생성은 drawLine(position) 메서드를 만들어 수동으로 사다리를 만들 수 있게 한다.
    // 즉, 처음 만들어진 사다리는 아예 빈 사다리이다.
    public void drawLine(int row, int col){
        // (col, row) 라인 만들기
        rows[row].drawLine(col);
    }
    public int run(int position){
        for(int i=0; i< rows.length; i++) {
            rows[i].newPosition(position);
        }
        return position;

    }
}