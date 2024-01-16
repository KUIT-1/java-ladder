package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.NumberOfPerson;

public class Row {

    private Node[] nodes;

    public Row(NumberOfPerson numberOfPerson) {
        this.nodes = new Node[numberOfPerson.getNumberOfPerson()];
        for (int i = 0; i < numberOfPerson.getNumberOfPerson(); i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    public void nextPosition(CurrentPosition currentPosition) {
        validateCurrentPositionY(currentPosition);

        if (nodes[currentPosition.getY()].isLeft()) {
            currentPosition.goRight();
            return;
        }
        if (nodes[currentPosition.getY()].isRight()) {
            currentPosition.goLeft();
            return;
        }
    }

    public int getValue(int y) {
        return nodes[y].getValue();
    }

    public void setValue(int leftY, int rightY) {
        nodes[leftY] = Node.createLeftNode();
        nodes[rightY] = Node.createRightNode();
    }

    private void validateCurrentPositionY(CurrentPosition currentPosition) {
        if (currentPosition.isYBiggerThan(nodes.length)) throw new IllegalArgumentException();
    }

    public int getLength() {
        return nodes.length;
    }

    public void viewValues(int row, CurrentPosition currentPosition) {
        for (int i = 0; i < nodes.length; i++) {
            if (currentPosition.equal(row, i)) {
                System.out.print(getValue(i) + "* ");
                continue;
            }
            System.out.print(getValue(i) + "  ");
        }
        System.out.println();
    }
}
