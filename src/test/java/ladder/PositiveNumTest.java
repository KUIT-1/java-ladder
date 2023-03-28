package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ladder.PositiveNum.createPositiveNumber;
import static org.junit.jupiter.api.Assertions.*;


class PositiveNumTest {

    PositiveNum positiveNum;
    @BeforeEach
    void BeforeTest() {

        positiveNum = createPositiveNumber(3);
    }
    //음수를 제대로 걸러내는지?
    @Test
    void validNegative() {

        //정상작동
        assertDoesNotThrow(()->positiveNum.validNegative(3));

        //에러
        assertThrows(IllegalArgumentException.class, () -> positiveNum.validNegative(-10));

        //경계값 테스트
        assertDoesNotThrow(()->positiveNum.validNegative(0));
        assertThrows(IllegalArgumentException.class, () -> positiveNum.validNegative(-1));
    }


    @Test
    public void createPositiveNumberTest() {
        assertEquals(PositiveNum.class, positiveNum.getClass());
    }

}
