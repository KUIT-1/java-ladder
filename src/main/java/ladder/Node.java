package ladder;

public class Node {
    public Direction direction; // <- 임시로 public 으로 변경함

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node createRightNode() {
        return new Node(Direction.RIGHT);
    }

    public static Node createLeftNode() {
        return new Node(Direction.LEFT);
    }

    public static Node createStraightNode() {
        return new Node(Direction.STRAIGHT);
    }

    public boolean isRight() {
        return direction.equals(Direction.RIGHT);
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public boolean isStraight() {
        return direction.equals(Direction.STRAIGHT);
    }
}
