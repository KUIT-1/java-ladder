package ladder;

public class Row {
    Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.createStraightNode();
        }
    }

    public void drawLine(Position startPosition) {
        // startPosition 에서 Line 을 그릴 수 있는 지 확인
        validateDrawingPosition(startPosition);
        nodes[startPosition.getPosition()] = Node.createRightNode();
        nodes[startPosition.getNextPosition()] = Node.createLeftNode();
    }

    public void getNextPosition(Position nowPosition) {
        validatePositionSize(nowPosition);

        if (nodes[nowPosition.getPosition()].isRight()) {
            nowPosition.goRight();
            return;
        }
        if (nodes[nowPosition.getPosition()].isLeft()) {
            nowPosition.goLeft();
        }
    }

    public void validateDrawingPosition(Position startPosition) {
        validatePositionSize(startPosition);
        if (nodes[startPosition.getPosition()].isLeft() /*left*/ || nodes[startPosition.getNextPosition()].isRight()) {
            throw new IllegalArgumentException("startPosition 위치에서 Line 을 생성할 수 없습니다.");
        }
    }

    private void validatePositionSize(Position position) {
        if(!position.isSmaller(nodes.length)){
            throw new IllegalArgumentException("포지션의 사이즈가 너무 큽니다!");
        }
    }

    public void validatePosition(int nowPosition) {
        if (nowPosition < 0 || nowPosition >= nodes.length) {
            throw new IllegalArgumentException("유효하지 않은 Position 입니다.");
        }
    }
}
