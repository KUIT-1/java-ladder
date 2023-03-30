package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    @DisplayName("Position 생성자")
    void When_createPositionByVal_Expect_getPositionIsVal(){
        Position position = createPosition(3);
        assertEquals(3, position.getPosition());
    }

    @Test
    @DisplayName("Position의 다음 위치")
    void When_CallNextPositionByA_Expect_ReturnAPlusOne(){
        Position position = createPosition(3);
        Position nextPosition = position.nextPosition();
        assertEquals(4, nextPosition.getPosition());
    }

}
