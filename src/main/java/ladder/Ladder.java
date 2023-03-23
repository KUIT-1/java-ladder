package ladder;


public class Ladder {
    Rows rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new Rows(row, numberOfPerson);
    }

    public void drawLine(int row, int col){
        rows.drawLine(row,col);
    }

    public int run(int num){
        return rows.run(num);
    }

    public void print(){
        for(int row = 0; row< rows.getNumofRow(); row++){
            for(int col = 0; col< rows.getNumofPerson(); col++){
                System.out.print(rows.getValue(row,col) + " ");
            }
            System.out.println();
        }
    }

}
