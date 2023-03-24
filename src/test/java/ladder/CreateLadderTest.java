package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateLadderTest {
    @Test
    @DisplayName("create ladder test")
    void createLadder(){
        //when
        CreateLadder ladder= new CreateLadder(2,2);
        //given
        ladder.drawLine(0,0);
        //then
        assertEquals(true,ladder.isLadderDirectionLeft(0,0));
        assertEquals(true,ladder.isLadderDirectionRight(0,1));


    }

    @Test
    @DisplayName("error of creating minus row")
    void invalidLadderRow(){

        assertThrows(IllegalArgumentException.class,() -> new CreateLadder(0,2));

    }

    @Test
    @DisplayName("error of creating minus col")
    void invalidLadderCol(){
        assertThrows(IllegalArgumentException.class,() -> new CreateLadder(2,0));
    }

    @Test
    @DisplayName("error of drawline")
    void invalidDrawLine(){
        //when
        CreateLadder ladder= new CreateLadder(2,2);

        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(0,1));
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(2,0));
    }



}
