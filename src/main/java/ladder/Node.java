package ladder;

public class Node {
    Direction2 direction;

    public Node(Direction2 direction) {
        this.direction = direction;
    }

    public static Node createCenterNode(){
        return new Node(Direction2.CENTER);
    }

    public static Node createLeftNode(){
        return new Node(Direction2.LEFT);
    }

    public static Node createRightNode(){
        return new Node(Direction2.RIGHT);
    }

    public boolean isDirectionRight(){
        return direction.equals(Direction2.RIGHT);
    }

    public boolean isDirectionLeft(){
        return direction.equals(Direction2.LEFT);
    }

    public boolean isDirectionCenter(){
        return direction.equals(Direction2.CENTER);
    }


    public void move(Position position) {
        if(isDirectionLeft()){
            position.moveLeft();
        }
        if(isDirectionRight()){
            position.moveRight();
        }
    }
}
