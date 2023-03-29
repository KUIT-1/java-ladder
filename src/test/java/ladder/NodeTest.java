package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    void getNodeDirection() {
        Node node = Node.createRightNode();

        assertEquals(1, node.getNodeDirection());
        assertTrue(node.isRight());
        assertFalse(node.isLeft());
    }
}
