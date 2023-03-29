package ladder;

import ladder.creator.LadderDefinedCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    @DisplayName("run 실행 확인")
    void runSuccessWhenFourRowFourColFourLine() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderDefinedCreator ladderDefinedCreator = new LadderDefinedCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderDefinedCreator);

        //given
        ladderDefinedCreator.drawLine(createPosition(0), createPosition(1));
        ladderDefinedCreator.drawLine(createPosition(1),createPosition(0));
        ladderDefinedCreator.drawLine(createPosition(2),createPosition(2));
        ladderDefinedCreator.drawLine(createPosition(3),createPosition(0));

        Position nthOfPerson = createPosition(0);
        //then
        assertEquals(0,ladderGame.run(nthOfPerson));

        nthOfPerson = createPosition(3);

        assertEquals(2,ladderGame.run(nthOfPerson));
    }

    @Test
    void runPrintLadder(){
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderDefinedCreator ladderDefinedCreator = new LadderDefinedCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderDefinedCreator);

        //given
        ladderDefinedCreator.drawLine(createPosition(0), createPosition(1));
        ladderDefinedCreator.drawLine(createPosition(1),createPosition(0));
        ladderDefinedCreator.drawLine(createPosition(2),createPosition(2));
        ladderDefinedCreator.drawLine(createPosition(3),createPosition(0));

        ladderGame.runWithPrint(createPosition(0));
    }

    @Test
    void runRandomLadder(){
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(row, numberOfPerson);

        ladderGame.runWithPrint(createPosition(0));
    }

}