package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static ladder.Direction.DOWN;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    static Node node;
    @BeforeEach
    void init() {
        node = new Node(createPosition(2));
    }

    @Test
    @DisplayName("Node 생성자 테스트")
    void When_CreateNode_Expect_stateIsDown(){
        try {
            Field stateField = node.getClass().getDeclaredField("state");
            stateField.setAccessible(true);
            Direction state = (Direction)stateField.get(node);
            assertEquals(DOWN, state);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Node 한 칸 아래로")
    void When_MoveNodeDown_Expect_currentRowIsIncreasing(){
        try {
            Field curRowField = node.getClass().getDeclaredField("current_row");
            curRowField.setAccessible(true);
            Position current_row = (Position)curRowField.get(node);
            int pre_row = current_row.getPosition();

            Method method = node.getClass().getDeclaredMethod("gotoDown");
            method.setAccessible(true);
            method.invoke(node);

            current_row = (Position)curRowField.get(node);
            assertEquals(pre_row+1, current_row.getPosition());

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
