package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    @DisplayName("사다리1 생성")
    public void getLadder1() {
        Ladder ladder = new Ladder(4, 6);
        ladder.drawLine(1, 1);
        ladder.drawLine(1, 2);
        ladder.drawLine(1, 3);
        ladder.drawLine(4, 3);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 5);
        ladder.drawLine(3, 1);
        ladder.drawLine(3, 2);
        ladder.drawLine(1, 6);
        ladder.drawLine(3, 5);
        ladder.drawLine(4, 2);
        ladder.drawLine(2, 4);
        ladder.drawLine(3, 6);
        ladder.drawLine(4, 4);
        ladder.print();
        System.out.println(ladder.run(1));
        System.out.println(ladder.run(2));
        System.out.println(ladder.run(3));
        System.out.println(ladder.run(4));
        System.out.println(ladder.run(5));
        System.out.println(ladder.run(6));
        System.out.println();
    }

    @Test
    @DisplayName("사다리2 생성")
    public void getLadder2() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(1, 5);
        ladder.drawLine(1, 2);
        ladder.drawLine(1, 4);
        ladder.drawLine(3, 4);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 3);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 3);
        ladder.drawLine(4, 5);
        ladder.drawLine(4, 2);
        ladder.print();
        System.out.println(ladder.run(1));
        System.out.println(ladder.run(2));
        System.out.println(ladder.run(3));
        System.out.println(ladder.run(4));
        System.out.println(ladder.run(5));
        System.out.println();
    }

    @Test
    @DisplayName("사다리 선 그릴 수 있는 범위 벗어날 때")
    public void getLadder3(){
        Ladder ladder = new Ladder(3, 5);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ladder.drawLine(0,3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ladder.drawLine(5,4));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ladder.drawLine(-1,-2));
        ladder.drawLine(1,1);
        ladder.drawLine(1,2);
        ladder.drawLine(1,4);
        ladder.drawLine(1,5);
        ladder.drawLine(2,2);
        ladder.drawLine(2,3);
        ladder.drawLine(3,3);
        ladder.drawLine(3,2);
        ladder.print();
        System.out.println(ladder.run(1));
        System.out.println(ladder.run(2));
        System.out.println(ladder.run(3));
        System.out.println(ladder.run(4));
        System.out.println(ladder.run(5));
        System.out.println();
    }

    @Test
    @DisplayName("사람이 사다리 개수의 범위를 벗어날 때")
    public void getLadder4() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(1, 5);
        ladder.drawLine(1, 2);
        ladder.drawLine(1, 4);
        ladder.drawLine(3, 4);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 3);
        ladder.drawLine(3, 2);
        ladder.drawLine(4, 3);
        ladder.drawLine(4, 5);
        ladder.drawLine(4, 2);
        ladder.print();
        System.out.println(ladder.run(1));
        System.out.println(ladder.run(2));
        System.out.println(ladder.run(3));
        System.out.println(ladder.run(4));
        System.out.println(ladder.run(5));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(6));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(0));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(-1));
        System.out.println();
    }



    @Test
    @DisplayName("사다리 탈 수 있는 사람이 0명")
    public void getLadder5() {
        // Ladder ladder = new Ladder(4, 0);
        assertThrows(IllegalArgumentException.class, () -> new Ladder(4,0));

        System.out.println();
    }

    @Test
    @DisplayName("사다리 길이가 0")
    public void getLadder6() {
        //Ladder ladder = new Ladder(0, 0);
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0,0));

        System.out.println();
    }


}

