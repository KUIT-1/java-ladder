package ladder.domain;

import ladder.domain.wrapper.Direction;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node createLeftNode() {
        return new Node(Direction.LEFT);
    }

    public static Node createRightNode() {
        return new Node(Direction.RIGHT);
    }

    public static Node createCenterNode() {
        return new Node(Direction.CENTER);
    }

    public int getValue() {
        return direction.getDirection();
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public boolean isRight() {
        return direction.equals(Direction.RIGHT);
    }

}
