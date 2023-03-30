package ladder.random;

import ladder.LadderSize;

import java.util.Set;
import java.util.HashSet;

public class RandomCreatorManager {
    private final LadderSize ladderSize;

    // 해당 좌표를 기준으로 오른쪽을 뻗는 라인이 존재함을 의미
    private Set<Point> line = new HashSet<Point>();

    public RandomCreatorManager(LadderSize ladderSize){
        this.ladderSize = ladderSize;
    }

    public void addPoint(Point point){
        line.add(point);
    }

    public boolean has(Point point){
        return line.contains(point);
    }
}