package ladder;

public class Node {
    Direction direction;

    public Node(Direction direction) {
        this.direction = direction;
    }

    public static Node createCenterNode(){
        return new Node(Direction.CENTER);
    }

    public static Node createLeftNode(){
        return new Node(Direction.LEFT);
    }

    public static Node createRightNode(){
        return new Node(Direction.RIGHT);
    }

    public boolean isDirectionRight(){
        return direction.equals(Direction.RIGHT);
    }

    public boolean isDirectionLeft(){
        return direction.equals(Direction.LEFT);
    }

    public boolean isDirectionCenter(){
        return direction.equals(Direction.CENTER);
    }


    public void move(Position position) {
        if(isDirectionLeft()){
            position.moveLeft();
        }
        if(isDirectionRight()){
            position.moveRight();
        }
    }


    public void printNode() {
        direction.printDirection();
    }

    public void printPositionNode(boolean positionIdx) {
        direction.printPositionDirection(positionIdx);
    }


}
