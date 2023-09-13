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
    private PositiveNum pLength;
    //* 생성자 - 초기화
    public Ladder(int ladderLength, int numberOfPerson) {

        pLength = new PositiveNum(ladderLength);
        PositiveNum pPerson = new PositiveNum(numberOfPerson);

        cols = new Col[pPerson.getNum()];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new Col(pLength);
        }
    }


    //* 실행 함수

    //start : 시작 위치
    public int run(int start) {
        Position ans = new Position(new PositiveNum(start), new PositiveNum(cols.length));

        //끝만나기 전에 좌로 갈지 우로 갈지 체크해서 이동
        for(int i = 0; i < pLength.getNum(); i++) {
            //더해줌
            Col col = cols[ans.getPosition()];
            //방향값을 확인하고 더해줌
            ans.addPosition(col.checkDirection(new PositiveNum(i)));
        }

        //마지막 위치 return
        return ans.getPosition();
    }

    //* 선 긋는 함수

    //row : 선 그을 시작 위치(length)
    //col : 선 그을 시작 사다리
    //direction : 방향(좌측인지 우측인지)
    //좌측 : -1, 우측 : 1

    //정상작동 시 true, 오작동 시 false return
    public boolean drawLine(int row, int col, Direction direction) {
        PositiveNum positionRow = new PositiveNum(row);
        Position positionCol = new Position(new PositiveNum(col), new PositiveNum(cols.length));
        if(!positionCol.detectWall(direction)) return connect(positionRow, positionCol, direction);
        return false;
    }

    //* 실질적으로 사다리 연결해주는 함수
    private boolean connect(PositiveNum pRow, Position pCol, Direction direction) {
        //fromCol : line을 그을 Col
        //toCol : line이 그어질 Col
        //방향에 맞춰 양방향으로 다닐 수 있게 연결
        Col fromCol = cols[pCol.getPosition()];
        fromCol.drawLine(pRow, direction);
        Col toCol = cols[pCol.getPosition() + direction.getNum()];
        toCol.drawLine(pRow, direction.opposite());
        return true;
    }



}
