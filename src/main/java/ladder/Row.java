package ladder;

import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;

//각 열씩 분리해서 drawLine 해주기 위해 클래스
public class Row {
    int[] row;

    public Row(int NumberOfPerson) {
        //사람수를 맞게 받았는지 확인하는 코드 추가하기
        row = new int [NumberOfPerson];
    }

    //사다리의 가로줄을 생성하는 메서드
    //라기 보다는 input = 몇번째 사다리를 탔는지 , output = 도착하는 사다리의 번호
    public void drawLine(int StartPosition) {
        //유효성 처리 : if(spotY<row && spotX<numberOfPerson-1)
        row[StartPosition] = RIGHT.getDirction();
        row[StartPosition+1] = LEFT.getDirction();
        }
        // 같은 높이의 가로줄이 두번 연속되지 않게 설정해두기
    }
