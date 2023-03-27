package ladder.domain.creator;

import java.util.Random;

public class RandomUtil {

    private Random random;

    private RandomUtil() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public static RandomUtil createRandomUtil() {
        return new RandomUtil();
    }

    public int generate(int range) {
        return random.nextInt(range);
    }
}
