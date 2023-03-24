package ladder;

public class Rows {

    private final int[][] rows;

    public Rows(int row, int numberOfPerson){
        rows = new int[row][numberOfPerson];
        validateLadder();
    }

    public int getNumofRow(){
        return rows.length;
    }

    public int getNumofPerson(){
        return rows[0].length;
    }

    public int getValue(int row, int col){
        return rows[row][col];
    }

    // 사람 수가 0명 이하이거나 사다리 길이가 0이하 일 때
    private void validateLadder(){
        if(rows.length < 1 || rows[0].length < 1){
            throw new IllegalArgumentException("사다리 생성 불가");
        }
    }

    public void drawLine(int row, int col){
        row -= 1;
        col -= 1;

        // 입력받은 행, 열이 범위에서 벗어나는지 확인
        validatePosition(row,col);

        rows[row][col] = 1;

        // 연속 2개의 사다리가 만들어지는지 확인
        for(int c=0; c<rows[0].length-3; c++){
            if(rows[row][c] == 1 && rows[row][c+1] == 1 && rows[row][c+2] == 1){
                // 연속 세 점의 값이 1이 되지 못하도록 현재위치 값을 2로 설정 (연속 2개의 사다리 = 연속 세 점의 값이 1)
                rows[row][col] = 2;
                return;
            }
        }
    }

    private void validatePosition(int row, int col){
        if (col >= rows[0].length || row >= rows.length){
            throw new ArrayIndexOutOfBoundsException("사다리 위치 벗어남");
        }
    }

    public int run(int num){
        num -= 1;

        for(int row = 0; row< rows.length; row++){
            validateNumOfPerson(row,num);

            // 현재 위치 기준 오른쪽에 사다리가 있을 때 오른쪽으로 이동
            if (num >= 0 && num < rows[row].length-1 && rows[row][num] == 1 && rows[row][num+1] == 1){
                num = num + 1;
                continue;
            }
            // 현재 위치 기준 왼쪽에 사다리가 있을 때 왼쪽으로 이동
            if (num > 0 && num <= rows[row].length-1 && rows[row][num] == 1 && rows[row][num-1] == 1){
                num = num - 1;
                continue;
            }
        }

        return num+1;
    }

    // 사다리 인원 초과 또는 미만일 때
    private void validateNumOfPerson(int row, int num){
        if (num < 0 || num > rows[row].length-1){
            throw new IllegalArgumentException("사다리 인원이 올바르지 않습니다.");
        }
    }
}
