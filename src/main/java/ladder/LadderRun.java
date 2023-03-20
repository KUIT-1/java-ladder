package ladder;

public class LadderRun {

    private final PositionManager positionManager;

    public LadderRun(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    public int run(int startPoint) {
        positionManager.validateStartPoint(startPoint);
        Node node = new Node(startPoint);
        int lastPoint = startPoint;
        while(positionManager.isRowExceedHeight(node)){
            lastPoint = node.move(positionManager);
        }
        return lastPoint;
    }

}
