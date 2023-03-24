package ladder;

import java.util.Random;

public class Ladder {


    private int numOfPeople;
    private int ladderHeight;
    private int[][] ladder;

    public Ladder(int numOfPeople, int ladderHeight) {
        this.numOfPeople = numOfPeople;
        this.ladderHeight = ladderHeight;
        ladder = new int[ladderHeight][numOfPeople - 1];

    }

    private void drawLne(int position) {

        Random random = new Random();
        for (int i = 0; i < ladderHeight; i++) {
            if (random.nextBoolean()) {
                position++;
            } else if (position > 0) {
                position--;
            }
            ladder[i][position] = 1;
        }
    }

    public int run(int selectedLine) {
        for (int i = 0; i < numOfPeople - 1; i++) {
            drawLne(i);
        }
        int result = selectedLine;
        for (int i = 0; i < ladderHeight; i++) {
            if (ladder[i][result] == 1) {
                result++;
            } else if (result > 0 && ladder[i][result - 1] == 1) {
                result--;
            }
        }
        return result + 1; //사다리번호는 1부터시작하므로 +1
    }
}