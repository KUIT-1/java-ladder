package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void personNumValidate(){
        //when
        int numberOfPerson =3;
        Ladder ladder = new Ladder(1,numberOfPerson);
        //given
        int personNum = 5;
        //then
        assertThrows(IllegalArgumentException.class,()->ladder.run(personNum));
    }
    @Test
    void runTest() {
        Ladder ladder = new Ladder(5, 7);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 5);
        ladder.drawLine(4, 7);
        ladder.runAll();
    }
}
