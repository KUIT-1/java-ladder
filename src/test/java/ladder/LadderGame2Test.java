package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGame2Test {
    @Test
    @DisplayName("ladder game")
    void ladderGame(){
        CreateLadder2 ladder=new CreateLadder2(2,3);
        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        LadderGame2 ladderGame =new LadderGame2(ladder);

        Position position0=Position.createPosition(0);
        assertEquals(2,ladderGame.run(position0));

        Position position1=Position.createPosition(1);
        assertEquals(0,ladderGame.run(position1));

        Position position2=Position.createPosition(2);
        assertEquals(1,ladderGame.run(position2));
    }
}
