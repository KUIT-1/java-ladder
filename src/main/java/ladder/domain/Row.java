package ladder.domain;

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

    public int getValue(int y) {
        return nodes[y].getValue();
    }

    public void setValue(int leftY, int rightY) {
        nodes[leftY] = Node.createLeftNode();
        nodes[rightY] = Node.createRightNode();
    }

    public void nextPosition(LadderNumber ladderNum) {
        validateLadderNumber(ladderNum);

        if (nodes[ladderNum.getNumber()].isLeft()) {
            ladderNum.goRight();
            return;
        }
        if (nodes[ladderNum.getNumber()].isRight()) {
            ladderNum.goLeft();
            return;
        }
    }


    private void validateLadderNumber(LadderNumber ladderNum) {
        if (ladderNum.isBigger(nodes.length)) throw new IllegalArgumentException();
    }

    public int getLength() {
        return nodes.length;
    }
}
