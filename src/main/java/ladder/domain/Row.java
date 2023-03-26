package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;

public class Row {

    private Node[] nodes;

    public Row(NumberOfPerson numberOfPerson) {
        this.nodes = new Node[numberOfPerson.getNumberOfPerson()];
        for (int i = 0; i < numberOfPerson.getNumberOfPerson(); i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    public void nextPosition(LadderNumber ladderNum, CurrentPosition currentPosition) {
        validateLadderNumber(ladderNum);

        if (nodes[ladderNum.getNumber()].isLeft()) {
            ladderNum.goRight();
            currentPosition.setY(ladderNum.getNumber());
            return;
        }
        if (nodes[ladderNum.getNumber()].isRight()) {
            ladderNum.goLeft();
            currentPosition.setY(ladderNum.getNumber());
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

    private void validateLadderNumber(LadderNumber ladderNum) {
        if (ladderNum.isBigger(nodes.length)) throw new IllegalArgumentException();
    }

    public int getLength() {
        return nodes.length;
    }

    public void viewValues(int numberOfPersonSize, int row, CurrentPosition currentPosition) {
        for (int i = 0; i < numberOfPersonSize; i++) {
            if (currentPosition.equal(row, i)) {
                System.out.print(getValue(i) + "* ");
                continue;
            }
            System.out.print(getValue(i) + "  ");
        }
        System.out.println();
    }
}
