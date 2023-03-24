package ladder;

import java.util.Random;

public class Row {

    private final int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson); // 참여자 수 유효한가?
        this.row = new int[numberOfPerson];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        if (startPosition >= 0 && startPosition < row.length) {
            row[startPosition] = 1;
            if (startPosition > 0) {
                row[startPosition - 1] = -1;
            }
        }
    }


    public int newPosition(int position) {
        validatePosition(position);
        Random random = new Random();
        if (row[position] == 1) { // 오른쪽으로 움직임
            position++;
        } else if (row[position] == -1) { // 왼쪽으로 움직임
            position--;
        } else { // 움직임 없을 때
        }
        return position;
    }


    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("사람 수가 너무 적습니다.");
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition < 0 || startPosition >= row.length - 1) {
            throw new IllegalArgumentException("startPosition 값이 옳지 않습니다.");
        }
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= row.length) {
            throw new IllegalArgumentException("Position 값이 유효하지 않습니다.");
        }
    }

}