package ladder.creator.random;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;
    public RandomNumberGenerator() {
        this.random = new Random();
    }
    public int getRandomNumber(int max){
        int randomNumber = random.nextInt(max + 1);
        return randomNumber;
    }
}
