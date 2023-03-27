package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.*;
import static ladder.Position.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    @DisplayName("사다리1 생성")
    public void getLadder1() {
        NaturalNumber numberOfPerson = createNaturalNumber(6);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(createPosition(1), createPosition(1));
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(3));
        ladderCreator.drawLine(createPosition(2), createPosition(2));
        ladderCreator.drawLine(createPosition(4), createPosition(3));
        ladderCreator.drawLine(createPosition(2), createPosition(5));
        ladderCreator.drawLine(createPosition(3), createPosition(1));
        ladderCreator.drawLine(createPosition(3), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(6));
        ladderCreator.drawLine(createPosition(3), createPosition(5));
        ladderCreator.drawLine(createPosition(4), createPosition(2));
        ladderCreator.drawLine(createPosition(2), createPosition(4));
        ladderCreator.drawLine(createPosition(4), createPosition(4));
        ladderCreator.drawLine(createPosition(3), createPosition(6));
        //ladder.print();
        System.out.println(ladderGame.run(createPosition(1)));
        System.out.println(ladderGame.run(createPosition(2)));
        System.out.println(ladderGame.run(createPosition(3)));
        System.out.println(ladderGame.run(createPosition(4)));
        System.out.println(ladderGame.run(createPosition(5)));
        System.out.println(ladderGame.run(createPosition(6)));
        System.out.println();
    }

    @Test
    @DisplayName("사다리2 생성")
    public void getLadder2() {
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(createPosition(1), createPosition(5));
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(4));
        ladderCreator.drawLine(createPosition(2), createPosition(2));
        ladderCreator.drawLine(createPosition(3), createPosition(4));
        ladderCreator.drawLine(createPosition(2), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(2));
        ladderCreator.drawLine(createPosition(4), createPosition(2));
        ladderCreator.drawLine(createPosition(4), createPosition(3));
        ladderCreator.drawLine(createPosition(4), createPosition(5));
        //ladder.print();
        System.out.println(ladderGame.run(createPosition(1)));
        System.out.println(ladderGame.run(createPosition(2)));
        System.out.println(ladderGame.run(createPosition(3)));
        System.out.println(ladderGame.run(createPosition(4)));
        System.out.println(ladderGame.run(createPosition(5)));
        System.out.println();
    }

    @Test
    @DisplayName("사다리 선 그릴 수 있는 범위 벗어날 때")
    public void getLadder3(){
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        NaturalNumber row = createNaturalNumber(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        assertThrows(IllegalArgumentException.class, () -> ladderCreator.drawLine(createPosition(0),createPosition(3)));
        assertThrows(IllegalArgumentException.class, () -> ladderCreator.drawLine(createPosition(0),createPosition(0)));
        assertThrows(IllegalArgumentException.class, () -> ladderCreator.drawLine(createPosition(-1),createPosition(-2)));
        ladderCreator.drawLine(createPosition(1), createPosition(1));
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(4));
        ladderCreator.drawLine(createPosition(2), createPosition(2));
        ladderCreator.drawLine(createPosition(2), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(5));
        //ladder.print();
        System.out.println(ladderGame.run(createPosition(1)));
        System.out.println(ladderGame.run(createPosition(2)));
        System.out.println(ladderGame.run(createPosition(3)));
        System.out.println(ladderGame.run(createPosition(4)));
        System.out.println(ladderGame.run(createPosition(5)));
        System.out.println();
    }

    @Test
    @DisplayName("사람이 사다리 개수의 범위를 벗어날 때")
    public void getLadder4() {
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);

        LadderGame ladderGame = new LadderGame(ladderCreator);


        ladderCreator.drawLine(createPosition(1), createPosition(5));
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(4));
        ladderCreator.drawLine(createPosition(2), createPosition(2));
        ladderCreator.drawLine(createPosition(2), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(3));
        ladderCreator.drawLine(createPosition(3), createPosition(2));
        ladderCreator.drawLine(createPosition(4), createPosition(2));
        ladderCreator.drawLine(createPosition(4), createPosition(3));
        ladderCreator.drawLine(createPosition(4), createPosition(5));
        ladderCreator.drawLine(createPosition(4), createPosition(2));
        //ladder.print();
        System.out.println(ladderGame.run(createPosition(1)));
        System.out.println(ladderGame.run(createPosition(2)));
        System.out.println(ladderGame.run(createPosition(3)));
        System.out.println(ladderGame.run(createPosition(4)));
        System.out.println(ladderGame.run(createPosition(5)));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(6)));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(0)));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(-1)));
        System.out.println();
    }



    @Test
    @DisplayName("사다리 탈 수 있는 사람이 0명")
    public void getLadder5() {
        // Ladder ladder = new Ladder(4, 0);
        assertThrows(IllegalArgumentException.class, () -> new LadderCreator(createNaturalNumber(4),createNaturalNumber(0)));

        System.out.println();
    }

    @Test
    @DisplayName("사다리 길이가 0")
    public void getLadder6() {
        //Ladder ladder = new Ladder(0, 0);
        assertThrows(IllegalArgumentException.class, () -> new LadderCreator(createNaturalNumber(0),createNaturalNumber(0)));

        System.out.println();
    }


}

