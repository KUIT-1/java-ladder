package ladder;

import static ladder.LadderPosition.createLadderPosition;
import static ladder.Node.*;
import static ladder.Position.createPosition;

public class Row {

    Node[] nodes;

    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()+1];
        for (int i=0; i<=numberOfPerson.getNumber(); i++) {
            nodes[i] = createCenterNode();
        }
    }

    public void drawLine(Position y) {
        validatePosition(y);
        nodes[y.getPosition()] = createRightNode();
        nodes[y.getNextPosition()] = createLeftNode();
    }

    public void nextPosition(Position position) {
        if (nodes[position.getPosition()].isLeft()) {
            position.minus();
            return;
        }

        if (nodes[position.getPosition()].isRight()) {
            position.plus();
        }
    }

    public String rowToString(LadderPosition ladderPosition, Position x) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=1; i<nodes.length; i++) {
            stringBuilder.append(nodes[i].getNodeDirection());

            Position y = createPosition(i);
            LadderPosition currentPosition = createLadderPosition(x, y);

            if (ladderPosition.equals(currentPosition)) {
                stringBuilder.append("*");
            }

            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    public boolean noLines(Position y) {
        return (nodes[y.getPosition()].isCenter() && nodes[y.getNextPosition()].isCenter());
    }

    private void validatePositionSize(Position y) {
        if (!y.isSmaller(nodes.length-1)) {
            throw new IllegalArgumentException("라인을 만들 줄이 사다리 라인 개수의 범위 안에 있어야 합니다.");
        }
    }

    private void validatePosition(Position y) {
        validatePositionSize(y);
        if (!noLines(y)) {
            throw new IllegalArgumentException("이미 사다리가 생성된 줄입니다.");
        }
    }
}