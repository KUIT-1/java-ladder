package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    @Test
    @DisplayName("Position 유효성 검사")
    void isPositionRight(){
        assertThrows(IllegalArgumentException.class, () -> new Position(0,1));
        new Position(1,1);
    }
}
