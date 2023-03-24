package ladder;

public class Ladder {
    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row - 1].drawLine(col);
    }

    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            Row currentRow = rows[i];
            int currentPos = position;

            // 오른쪽으로 선이 그려져 있으면 오른쪽으로 이동
            if (currentPos < currentRow.getNumberOfPerson() && currentRow.isLineDrawn(currentPos)) {
                currentPos++;
            }
            // 왼쪽으로 선이 그려져 있으면 왼쪽으로 이동
            else if (currentPos > 1 && currentRow.isLineDrawn(currentPos - 1)) {
                currentPos--;
            }

            // 다음행 위치 업데이트해주기
            position = currentPos;
        }

        return position;
    }

    public void runAll() {
        for (int i = 1; i <= rows[0].getNumberOfPerson(); i++) {
            System.out.println("Start position: " + i + " => " + run(i));
        }
    }
}

