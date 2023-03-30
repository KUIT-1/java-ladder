package ladder.creator.random;

import ladder.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderSize.createLadderSize;
import static ladder.NaturalNumber.createNaturalNumber;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("RandomNumber 생성 test")
    public void randomNumberGenerateTest(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LadderSize ladderSize = createLadderSize(
                createNaturalNumber(5), createNaturalNumber(5)
        );
        int rnd = randomNumberGenerator.getRandomNumber(ladderSize.getNumberOfPerson());
        assertTrue(rnd >= 0 && rnd <= ladderSize.getNumberOfPerson(), "random number 는 0 ~ max 여야 합니다.");
    }
}