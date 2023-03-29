package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeTest {

    @Test
    @DisplayName("move node which has right direction")
    void moveRight(){
        Node node=Node.createRightNode();
        Position position=new Position(0);
        node.move(position);
        assertEquals(1,position.getPosition());
    }

    @Test
    @DisplayName("move node which has left direction")
    void moveLeft(){
        Node node1=Node.createLeftNode();
        Position position1=new Position(1);
        node1.move(position1);
        assertEquals(0,position1.getPosition());

        Node node2=Node.createLeftNode();
        Position position2=new Position(0);

        assertThrows(IllegalArgumentException.class,() -> node1.move(position2));
    }

    @Test
    @DisplayName("move node which has center direction")
    void moveCenter(){
        Node node=Node.createCenterNode();
        Position position=new Position(0);
        node.move(position);
        assertEquals(0,position.getPosition());
    }
}
