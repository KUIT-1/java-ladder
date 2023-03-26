package ladder;

public class LadderRun {

    private LineManager lineManager;

    public LadderRun(NaturalNumber height, NaturalNumber numberOfPerson) {
        this.lineManager = new LineManager(height, numberOfPerson);
    }

    public void drawLine(Position row, Position col) {
        lineManager.drawLine(row, col);
    }

    public int run(Position startPoint) {
        lineManager.validateStartPoint(startPoint);
        Node node = new Node(startPoint);
        Position lastPoint = startPoint;
        while(lineManager.isRowExceedHeight(node)){
            lastPoint = node.move(lineManager);
        }
        return lastPoint.getPosition();
    }

}
