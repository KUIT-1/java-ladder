package ladder;

import static ladder.Direction.*;

public class Row {
    int[] floor;

    public Row(int numberOfPerson) {
        validate(numberOfPerson);
        this.floor = new int[numberOfPerson];
    }

    public void draw(int positionY) {
        validatePositionY(positionY);
        floor[positionY] = RIGHT.value();
        floor[positionY+1] = LEFT.value();
    }

    public int nextPosition(int ladderNum) {
        if (floor[ladderNum] == RIGHT.value()) return RIGHT.move();
        if (floor[ladderNum] == LEFT.value()) return LEFT.move();
        return DOWN.move();
    }

    private void validate(int numberOfPerson) {
        if(numberOfPerson < 2)
            throw new IllegalArgumentException("사람이 너무 적습니다.");
    }

    private void validatePositionY(int positionY) {
        if(positionY >= floor.length)
            throw new IllegalArgumentException("범위를 벗어나 사다리를 그릴 수 없습니다.");
        if(floor[positionY] != 0)
            throw new IllegalArgumentException("사다리 라인이 이미 존재합니다.");
    }
}
