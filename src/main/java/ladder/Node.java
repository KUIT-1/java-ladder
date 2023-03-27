package ladder;

public class Node {
    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public int getDirection(){
        //return Integer.toString(direction.getDirection());
        return direction.getDirection();
    }

    public boolean isLadder() {
        return direction.equals(Direction.isLadder);
    }

    public boolean noLadder() {
        return direction.equals(Direction.noLadder);
    }

    public static Node createNoLadderNode() {
        return new Node(Direction.noLadder);
    }

    public static Node createLadderNode() {
        return new Node(Direction.isLadder);
    }
}

