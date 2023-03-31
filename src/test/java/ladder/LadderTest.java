package ladder;

import ladder.creator.RandomLadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

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
    @DisplayName("랜덤 사다리 생성")
    public void getRandomLadder(){
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame();
        System.out.println(ladderGame.run(createPosition(2)));

    }
}

