package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public boolean isRight() {
        return direction.equals(Direction.RIGHT);
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public boolean isCenter() {
        return direction.equals(Direction.CENTER);
    }

    public int getNodeDirection() {
        return direction.getDirection();
    }

    public static Node createRightNode() {
        return new Node(Direction.RIGHT);
    }

    public static Node createLeftNode() {
        return new Node(Direction.LEFT);
    }

    public static Node createCenterNode() {
        return new Node(Direction.CENTER);
    }
}
