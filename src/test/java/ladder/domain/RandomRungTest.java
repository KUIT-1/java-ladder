package ladder.domain;

import ladder.domain.creator.RandomRung;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.wrapper.Rung;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomRungTest {

    @Test
    @DisplayName("중복없이 count 만큼 생성 되는지")
    public void creatRandomRung() throws Exception {
        //given
        Ladder ladder = Ladder.of(NumberOfRow.of(100), NumberOfPerson.of(100));

        //when
        Collection<Rung> randomRungs = RandomRung.getRandomRungs(ladder, 3000);

        //then
        // 중복 제거해도 3000개의 Rung이 생성되어야 함
        assertEquals(3000, randomRungs.stream().distinct().count());
    }


    @Test
    @DisplayName("Ladder의 범위를 지키며 생성되는지")
    public void validateRandomRungRange() throws Exception {
        //given
        Ladder ladder = Ladder.of(NumberOfRow.of(100), NumberOfPerson.of(100));

        //when
        Collection<Rung> randomRungs = RandomRung.getRandomRungs(ladder, 3000);

        //then
        // 중복 제거해도 3000개의 Rung이 생성되어야 함
        assertEquals(3000, randomRungs.stream()
                        .filter(rung -> rung.getLeftPointXInt() < 100).count());
        assertEquals(3000, randomRungs.stream()
                        .filter(rung -> rung.getLeftPointYInt() < 100).count());
        assertEquals(3000, randomRungs.stream()
                        .filter(rung -> rung.getRightPointXInt() < 100).count());
        assertEquals(3000, randomRungs.stream()
                        .filter(rung -> rung.getRightPointYInt() < 100).count());
    }
}
