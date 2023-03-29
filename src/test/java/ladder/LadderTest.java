package ladder;

import ladder.creator.RandomLadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderPosition.*;
import static ladder.NaturalNumber.*;
import static ladder.Position.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    @DisplayName("사다리1 생성")
    public void getLadder1() {
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(6));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);


        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(1)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(5)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(1)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(6)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(5)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(6)));

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
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(6));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);


        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(5)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(4),createPosition(5)));
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
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(3), createNaturalNumber(5));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);


        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(0),createPosition(0))));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(0),createPosition(3))));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(-1),createPosition(-2))));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(1)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(5)));
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
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(5));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(1)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(5)));
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
        assertThrows(IllegalArgumentException.class, () -> LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(0)));

        System.out.println();
    }

    @Test
    @DisplayName("사다리 길이가 0")
    public void getLadder6() {

        //Ladder ladder = new Ladder(0, 0);
        assertThrows(IllegalArgumentException.class, () -> LadderSize.createLadderSize(createNaturalNumber(0), createNaturalNumber(0)));

        System.out.println();
    }

    @Test
    @DisplayName("랜덤 사다리 생성")
    public void getRandomLadder(){
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame();

        System.out.println(ladderGame.run(createPosition(2)));

    }


}

