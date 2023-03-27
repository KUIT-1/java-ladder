package ladder.domain;

import ladder.domain.wrapper.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void createNode() throws Exception {
        //given
        Node leftNode = Node.createLeftNode();
        Node centerNode = Node.createCenterNode();
        Node rightNode = Node.createRightNode();

        //then
        /** 생성 */
        Assertions.assertEquals(Direction.LEFT.getDirection(), leftNode.getValue());
        Assertions.assertEquals(Direction.CENTER.getDirection(), centerNode.getValue());
        Assertions.assertEquals(Direction.RIGHT.getDirection(), rightNode.getValue());

        /** 비교 */
        Assertions.assertTrue(leftNode.isLeft());
        Assertions.assertTrue(rightNode.isRight());
    }

}
