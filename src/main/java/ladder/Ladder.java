package ladder;

public class Ladder {

    private final int[][] rows;
    public static int row, numberOfPerson;

    public Ladder(int row, int numberOfPerson) {
        this.row=row;
        rows = new int[row][numberOfPerson];
        //row:사다리의높이, numeberOfPerson:세로줄의개수

    }

    //사다리의 가로줄을 생성하는 메서드
    void drawLine(int spotY, int spotX) {
        if(spotY<row && spotX<numberOfPerson-1) {
            rows[spotY][spotX] = 1;
            rows[spotY][spotX + 1] = -1;
        }
        // 같은 높이의 가로줄이 두번 연속되지 않게 설정해두기
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

            if(rows[y][x]==0){
                y++;
                //System.out.println(y + " " + x);
                continue;
            }
            if(rows[y][x]>0){
                x++;
                y++;
                //System.out.println(y + " " + x);
                continue;
            }
            if(rows[y][x]<0){
                x--;
                y++;
                //System.out.println(y + " " + x);
            }
        }
    }

}