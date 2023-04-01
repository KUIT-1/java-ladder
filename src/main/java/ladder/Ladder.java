package ladder;

import java.util.Arrays;

public class Ladder {

    private final Row[] rows;
    public static int ladderRow, numberOfPerson;

    public Ladder(int row, int numberOfPerson) {
        this.ladderRow = row;
        this.numberOfPerson = numberOfPerson;
        //rows = new int[row][numberOfPerson];
        rows = new Row[row];

        //각 Row객체의 인스턴스를 생성
        for(int i=0;i<row;i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int column){
        rows[row].drawLine(column);
    }

    public int run(int startPosition){
        String printBefore = toString();
        System.out.println("//Before");
        System.out.println(printBefore);

        //int pRow=0; //몇 행에 있는지 알려주는 변수
        int pCol=startPosition;  //몇번째 사다리에 있는지 알려주는 변수

        for(int pRow=0;pRow<ladderRow;pRow++){
            pCol=rows[pRow].nextPosition(pCol);
        }

        String printAfter = toString();
        System.out.println("//After");
        System.out.println(printAfter);

        return pCol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(Arrays.toString(row.oneRow)).append("\n");
        }
        return sb.toString();
    }

}