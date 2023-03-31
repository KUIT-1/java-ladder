package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
    @Test
    @DisplayName("ladder game")
    void ladderGame(){
        LadderSize ladderSize=new LadderSize(2,3);
        ManualLadderCreator ladder=new ManualLadderCreator(ladderSize);
        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        LadderGame ladderGame =new LadderGame(ladder);

        Position position0=Position.createPosition(0);
        assertEquals(2,ladderGame.run(position0));

//        Position position1=Position.createPosition(1);
//        assertEquals(0,ladderGame.run(position1));
//
//        Position position2=Position.createPosition(2);
//        assertEquals(1,ladderGame.run(position2));

    }


}
