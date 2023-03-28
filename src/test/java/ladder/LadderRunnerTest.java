package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.Direction.*;
import static ladder.Direction.RIGHT;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class LadderRunnerTest {

    LadderCreator ladderCreator;
    LadderRunner ladderRunner;

    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        ladderCreator = new LadderCreator(height, numberOfPerson);
        ladderRunner = new LadderRunner(ladderCreator.getLineByRows());
    }

    @Test
    @DisplayName("validateStartPoint : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladderRunner.validateStartPoint(createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()-> ladderRunner.validateStartPoint(createPosition(7)));
    }




}
