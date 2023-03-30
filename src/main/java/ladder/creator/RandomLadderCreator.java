package ladder.creator;

import ladder.LadderSize;
import ladder.Point;
import ladder.Position;
import ladder.Row;
import ladder.creator.random.RandomNumberGenerator;

import java.util.HashSet;

public class RandomLadderCreator implements LadderCreator {
    Row[] rows;
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    CustomLadderCreator customLadderCreator;
    LadderSize ladderSize;

    public RandomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        customLadderCreator = new CustomLadderCreator(ladderSize);
        rows = customLadderCreator.getRows();
        drawLine();
    }

    @Override
    public void drawLine(Position row, Position col) {
        // unused
    }

    @Override
    public void drawLine() {
        HashSet<Point> hs = new HashSet<>();
        int maxLineNum = getLineNum(ladderSize);
        while (hs.size() < maxLineNum){
            Position row = Position.createPosition(randomNumberGenerator.getRandomNumber(ladderSize.getNumOfRows()-1));
            Position col = Position.createPosition(randomNumberGenerator.getRandomNumber(ladderSize.getNumberOfPerson()-2));
            if(customLadderCreator.getRows()[row.getPosition()].isValid(col)){
                customLadderCreator.drawLine(row, col);
                hs.add(Point.createPoint(row, col));
            }
        }
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    public int getLineNum(LadderSize ladderSize) {
        return (int) (ladderSize.getNumberOfPerson() * ladderSize.getNumOfRows() * 0.3);
    }
}
