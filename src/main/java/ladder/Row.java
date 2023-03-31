package ladder;

public class Row {
    Node[] nodes;
    StringManager stringManager = new StringManager();

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
            throw new IllegalArgumentException(stringManager.getValidateDrawingPositionErrorMessage());
        }
    }

    private void validatePositionSize(Position position) {
        if (!position.isSmaller(nodes.length)) {
            throw new IllegalArgumentException(stringManager.getValidatePositionSizeErrorMessage());
        }
    }

    public void validatePosition(int nowPosition) {
        if (nowPosition < 0 || nowPosition >= nodes.length) {
            throw new IllegalArgumentException(stringManager.getValidatePositionErrorMessage());
        }
    }

    public void createStringEachRow(Position nowRow, Point playerPoint, StringBuilder sb) {
        for (int i = 0; i < nodes.length; i++) {
            Point point = Point.createPoint(nowRow, Position.createPosition(i));
            if (playerPoint.equals(point)) {
                sb.append(stringManager.getUserSymbol());
            }
            appendCharacter(sb, i);
            sb.append(stringManager.getTab());
        }
        sb.append(stringManager.getNewLine());
    }

    private void appendCharacter(StringBuilder sb, int i) {
        int dir = nodes[i].direction.getDirection();
        if(dir == Direction.RIGHT.getDirection()){
            sb.append(stringManager.right);
        }
        if(dir == Direction.LEFT.getDirection()){
            sb.append(stringManager.left);
        }
        if(dir == Direction.STRAIGHT.getDirection()){
            sb.append(stringManager.straight);
        }
    }

    public boolean isValid(Position position) {
        if(position.getPosition() < 0 || position.getPosition() >= nodes.length){
            return false;
        }
        if(nodes[position.getPosition()].isLeft() /*left*/ || nodes[position.getNextPosition()].isRight()){
            return false;
        }
        return true;
    }
}
