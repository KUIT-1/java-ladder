package ladder.domain.creator;

import java.util.Random;

public class RandomUtil {

    private final static Random random;

    static {
        random = new Random(System.currentTimeMillis());
    }

    public static int generate(int range) {
        return random.nextInt(range);
    }
}
