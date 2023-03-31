package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
@Test
public void runTest(){
    Ladder ladder = new Ladder(5,5);
    int result=ladder.run(1);
    assertEquals(1,result);
    result = ladder.run(2);
    assertEquals(2, result);
    result = ladder.run(3);
    assertEquals(3, result);
    result = ladder.run(4);
    assertEquals(4, result);
    result = ladder.run(5);
    assertEquals(5, result);
}
}