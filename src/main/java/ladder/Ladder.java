package ladder;

// 사람 - 2명 이상
// 사다리 - 2층 이상
//  -> 사다리 라인이 (사람수-1)개 이상이라고 "가정"

public class Ladder {
    //private final int[][] rows;
    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        validateRow(row);
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position position) {
        validatePositionX(position.getX());
        rows[position.getX()].draw(position.getY());
    }

    private void validatePositionX(int positionX) {
        if(positionX==0 || positionX >= rows.length-1)
            throw new IllegalArgumentException("범위를 벗어나 사다리 라인을 그릴 수 없습니다.");
    }

    public int run(int ladderNum) {
        for(int i=0; i<rows.length; i++) {
            ladderNum += rows[i].nextPosition(ladderNum);
        }

        return ladderNum;
    }

    private static void validateRow(int row) {
        if (row < 3) {
            throw new IllegalArgumentException("사다리 층이 부족합니다.");
        }
    }
}