package ladder;

import static ladder.Direction.*;

public class Ladder {


    private final int[] rows;
    public static int row, numberOfPerson;
    public static final int DIRECTION_LEFT =-1;
/*
    public Ladder(int row, int numberOfPerson) {
        this.rows = rows;
        rows = new int[numberOfPerson];
        //row:사다리의높이, numeberOfPerson:세로줄의개수
    }
    */
    public Ladder(int row, int numberOfPerson) {
        this.row=row;
        rows = new int[numberOfPerson];
        //row:사다리의높이, numeberOfPerson:세로줄의개수
    }

    //사다리의 가로줄을 생성하는 메서드
    void drawLine(int row, int col) {
        rows[row].drawLine(col);
        }


    //사다리를 선택하면 도착하는 사다리의 번호를 알려주는 메서드
    int run(int position){
        //position == 시작하는 사다리의 열+1
        //시작위치 = [0][position-1];
        int y=0;
        int x=position-1;

        while(true){
            if(y==row) {
                //System.out.println(y + " " + x);
                return x + 1;
            }

            if(rows[y][x]== CENTER.getDirction()){
                y++;
                //System.out.println(y + " " + x);
                continue;
            }
            if(rows[y][x]==RIGHT.getDirction()){
                x++;
                y++;
                //System.out.println(y + " " + x);
                continue;
            }
            if(rows[y][x]== LEFT.getDirction()){
                x--;
                y++;
                //System.out.println(y + " " + x);
            }
        }
    }

}