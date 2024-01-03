package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.Rung;

import java.util.HashSet;
import java.util.Set;

public class RandomRung {

    public static Set<Rung> getRandomRungs(Ladder ladder, int count) {
        Set<Rung> randomRungSet = new HashSet<>(count);

        while (randomRungSet.size() != count){
            randomRungSet.add(getRandomRung(ladder));
        }

        return randomRungSet;
    }

    private static Rung getRandomRung(Ladder ladder) {
        int randomX = RandomUtil.generate(ladder.getRowSize());
        int randomY = RandomUtil.generate(ladder.getNumberOfPersonSize() - 1);

        return Rung.of(randomX, randomY, randomY + 1);
    }
}
