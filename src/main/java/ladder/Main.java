package ladder;

import java.util.Random;

public class Main {

    public static void main(String arg[]) {
        Ladder ladder = new Ladder(10, 10);
        Random random = new Random();
        for(int i = 0; i < 30; i++) {
            switch (random.nextInt(2)) {
                case 0:
                    ladder.drawLine(random.nextInt(9), random.nextInt(9), "left");
                    break;
                case 1:
                    ladder.drawLine(random.nextInt(9), random.nextInt(9), "right");
                    break;
            }
        }
        System.out.println("도착 Line : " + ladder.run(-1));

        System.out.println(ladder);
    }
}
