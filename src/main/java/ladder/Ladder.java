package ladder;

//가정//////////////////////////////////////////////////////////////

//* 시작 위치는 0 끝 위치는 numberOfPerson-1
//* 선은 수평으로만 그을 수 있음
//* 한번에 여러줄 이동 불가
//* 사다리는 연속적이지 않고 비연속적임(int 좌표 값으로 표시할 수 있음)
//* 선이 양쪽으로 있는 경우 랜덤하게 이동(나중에 그려진 선으로 이동)

///////////////////////////////////////////////////////////////////

public class Ladder {

    //사다리
    private Col[] cols;
    //사다리 길이
    private int ladder_length;

    //* 생성자 - 초기화
    public Ladder(int ladder_length, int numberOfPerson) {
        cols = new Col[numberOfPerson];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new Col(ladder_length);
        }
        this.ladder_length = ladder_length;
    }

    //* 실행 함수

    //start : 시작 위치
    public int run(int start) {

        //start 위치 확인 - 범위 밖일 시 -1 return
        if(!valid_position(start)) return -1;
        int ans = start;

        //사다리 길이동안 좌로 갈지 우로갈지 체크해서 이동
        for(int i = 0; i < ladder_length; i++) {
            Col col = cols[ans];
            ans += col.checkDirection(i);
        }

        //마지막 위치 return
        return ans;
    }

    //* 위치가 범위 내인지 확인하는 함수

    //범위 내이면 true, 밖이면 -1 return
    public boolean valid_position(int position) {
        if(position >= ladder_length) return false;
        if(position < 0) return false;
        return true;
    }

    //* 선 긋는 함수

    //row : 선 그을 시작 줄
    //col : 선 그을 시작 위치
    //direction : 방향(좌측인지 우측인지)
    //좌측 : -1, 우측 : 1

    //정상작동 시 true, 오작동 시 false return
    public boolean drawLine(int row, int col, String direction) {
        //사다리 밖으로 안나가는지 확인하고 선을 그어줌
        if(!valid_position(col)) return false;
        if((direction.equals("left") && row > 0)) return connect(row, col, -1);
        if ((direction.equals("right")) && (row < cols.length-1)) return connect(row, col, 1);
        return false;
    }

    //* 실질적으로 사다리 연결해주는 함수
    private boolean connect(int row, int col, int direction) {
        //from_col : line을 그을 Col
        //to_col : line이 그어질 Col
        //방향에 맞춰 양방향으로 다닐 수 있게 연결
        Col from_col = cols[row];
        from_col.drawLine(col, direction);
        Col to_col = cols[row + direction];
        to_col.drawLine(col, -direction);
        return true;
    }



}
