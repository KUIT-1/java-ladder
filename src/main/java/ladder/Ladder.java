package ladder;

import java.util.ArrayList;

//가정//////////////////////////////////////////////////////////////

    //* 선은 수평으로만 그을 수 있음
    //* 한번에 여러줄 이동 불가
    //* 사다리는 연속적이지 않고 비연속적임(int 좌표 값으로 표시할 수 있음)

///////////////////////////////////////////////////////////////////

public class Ladder {

    //사다리
    private Row[] rows;
    //사다리 길이
    private int ladder_length;

    //생성자 - 초기화
    public Ladder(int ladder_length, int numberOfPerson) {
        rows = new Row[numberOfPerson];
        for(int i = 0; i < rows.length; i++) {
            rows[i] = new Row(ladder_length);
        }
        this.ladder_length = ladder_length;
    }

    //실행
    //start : 시작 위치
    public int run(int start) {
        int ans = start;

        //사다리 길이동안 좌로 갈지 우로갈지 체크해서 이동
        for(int i = 0; i < ladder_length; i++) {
            Row row = rows[ans];
            ans += row.checkDirection(i);
        }

        return ans;
    }

    //선 긋는 함수
    //row : 선 그을 시작 줄
    //col : 선 그을 시작 위치
    //direction : 방향(좌측인지 우측인지)
    //좌측 : -1, 우측 : 1
    public boolean drawLine(int row, int col, String direction) {
        //사다리 밖으로 안나가는지 확인하고 선을 그어줌
        if((direction.equals("left") && row > 0))
            return connect(row, col, -1);
        else if ((direction.equals("right")) && (row < rows.length-1))
            return connect(row, col, 1);
        return false;
    }

    //실질적으로 선을 긋는 함수
    private boolean connect(int row, int col, int direction) {
        //from_row : line을 그을 row
        //to_row : line이 그어질 row
        //방향에 맞춰 양방향으로 다닐 수 있게 해줌
        Row from_row = rows[row];
        from_row.drawLine(col, direction);
        Row to_row = rows[row + direction];
        to_row.drawLine(col, -direction);
        return true;
    }


}
