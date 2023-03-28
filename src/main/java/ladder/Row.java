package ladder;

public class Row {
    int[] row;

    public Row(NaturalNumber numberOfPerson) {
        row = new int[numberOfPerson.getNumber()];
        // 유효하다면 참여하는 사람 수 만큼 생성
    }

    public void drawLine(Position startPosition) {
        // startPosition 에서 Line 을 그릴 수 있는 지 확인
        validateDrawingPosition(startPosition);
        row[startPosition.getPosition()] = Direction.RIGHT.getDirection();
        row[startPosition.getNextPosition()] = Direction.LEFT.getDirection();
    }

    public void getNextPosition(Position nowPosition) {
        validatePositionSize(nowPosition);
        // nowPosition 이 유효한 지 확인
        if (connectedNothing(nowPosition)) {
            // 아무것도 연결되어 있지 않다면
            return; // go Straight!
        }
        if (connectedLeft(nowPosition)) {
            // startPoSITION 에서 왼쪽으로 연결되어 있다면?
            nowPosition.goLeft();
            // 왼쪽을 먼저 간다.
        }
        // 아무것도 연결되어 있는 것이 아니지만
        // 왼쪽으로도 연결되어 있지 않다면 오른쪽으로 연결되어 있다는 것
        nowPosition.goRight();
    }

    public boolean connectedNothing(Position position) {
        return row[position.getPosition()] == Direction.STRAIGHT.getDirection();
    }

    public boolean connectedLeft(Position position) {
        return row[position.getPosition()] == Direction.LEFT.getDirection();
    }

    public void validateDrawingPosition(Position startPosition) {
        validatePositionSize(startPosition);
        if (row[startPosition.getPosition()] == Direction.LEFT.getDirection() /*left*/ || row[startPosition.getNextPosition()] == Direction.RIGHT.getDirection() /*right*/) {
            throw new IllegalArgumentException("startPosition 위치에서 Line 을 생성할 수 없습니다.");
        }
    }

    private void validatePositionSize(Position position) {
        if(!position.isSmaller(row.length)){
            throw new IllegalArgumentException("포지션의 사이즈가 너무 큽니다!");
        }
    }

    public void validatePosition(int nowPosition) {
        if (nowPosition < 0 || nowPosition >= row.length) {
            throw new IllegalArgumentException("유효하지 않은 Position 입니다.");
        }
    }
}
