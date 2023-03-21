package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    Ladder ladder;

    @Test
    @DisplayName("사다리 만들기 - Ladder")
    @BeforeEach
    void makeLadder(){
        // 사람 부족
        assertThrows(IllegalArgumentException.class, () -> new Ladder(3,1));
        // 사다리 층 부족
        assertThrows(IllegalArgumentException.class, () -> new Ladder(2,2));
        ladder = new Ladder(6, 4);
    }

    @Test
    @DisplayName("사다리라인 만들기 - drawLine")
    void drawLine(){
        ladder.drawLine(new Position(1, 1));

        // 이미 사다리 라인이 존재할 때, 생성할 수 없음
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(new Position(1, 2)));
    }

    @Test
    @DisplayName("사다리타기 - run")
    void run(){
        ladder.drawLine(new Position(1, 1));
        ladder.drawLine(new Position(2, 2));
        ladder.drawLine(new Position(4, 1));
        assertEquals(1, ladder.run(3));
    }
}