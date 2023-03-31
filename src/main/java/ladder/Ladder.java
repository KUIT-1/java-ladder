package ladder;

import java.util.Random;

public class Ladder {
    private final int numOfPeople;
    private final int ladderHeight;
    private int[][] ladder;

    public Ladder(int numOfPeople, int ladderHeight) {
        this.numOfPeople = numOfPeople;
        this.ladderHeight = ladderHeight;
        ladder = new int[numOfPeople - 1][ladderHeight];
    }

    private int moveRightOrLeft(int currentPosition) {
        return new Random().nextBoolean() ? currentPosition + 1 : currentPosition - 1;
    }

    private void drawLine(int lineIndex) {
        int position = lineIndex;
        for (int i = 0; i < ladderHeight; i++) {
            position = moveRightOrLeft(position);
            ladder[lineIndex][i] = position;
        }
    }

    public int run(int selectedLine) {
        for (int i = 0; i < ladder.length; i++) {
            drawLine(i);
        }
        int result = selectedLine;
        for (int i = 0; i < ladderHeight; i++) {
            int currentLine = result - 1;
            if (currentLine >= 0 && currentLine < ladder.length && ladder[currentLine][i] != i) {
                result = ladder[currentLine][i];
            }
        }
        return result;
    }
}