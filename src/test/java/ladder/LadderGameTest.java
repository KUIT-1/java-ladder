package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {

    @Test
    @DisplayName("run ladder")
    void runLadder(){
        //when
        CreateLadder ladder= new CreateLadder(2,3);
        ladder.drawLine(0,0);
        Player[] players=new Player[3];
        LadderGame ladderGame = new LadderGame(ladder,2,3,players);
        //given
        ladderGame.run(0);
        ladderGame.run(1);
        ladderGame.run(2);
        //then
        assertEquals(1,ladderGame.run(0));
        assertEquals(0,ladderGame.run(1));
        assertEquals(2,ladderGame.run(2));

    }

    @Test
    @DisplayName("get game result")
    void gameResult(){
        //when
        CreateLadder ladder= new CreateLadder(2,3);
        ladder.drawLine(0,0);
        Player[] players=new Player[3];
        LadderGame ladderGame = new LadderGame(ladder,2,3,players);
        //given
        ladderGame.gameResult();
        //then
        assertEquals(1,ladderGame.getGameResult(0));
        assertEquals(0,ladderGame.getGameResult(1));
        assertEquals(2,ladderGame.getGameResult(2));

    }




}
