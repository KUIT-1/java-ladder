package ladder.random;

import java.util.Set;
import java.util.HashSet;
import ladder.random.Point;

/* class 명을 LadderManager와 같은 형태로 변환한 후, LadderSize를 상속받는 형태로 구현.. */
public class RanomCreatorManager {
    private final LadderSize ladderSize;

    /* height와 numberOfPerson만 LadderSize의 필드가 되도록 분리작업 필요해 보임. */
//    private NaturalNumber height;
//    private NaturalNumber numberOfPerson;

    /* 즉, 이 친구를 */
    // 해당 좌표를 기준으로 오른쪽을 뻗는 라인이 존재함을 의미
    private Set<Point> line = new HashSet<Point>();

    public RanomCreatorManager(LadderSize ladderSize){
        this.ladderSize = ladderSize;
    }

    public void addPoint(Point point){
        point.setColSize(ladderSize.getNumberOfPerson());
        line.add(point);
    }

    public boolean has(Point point){
        point.setColSize(ladderSize.getNumberOfPerson());
        return line.contains(point);
    }
}