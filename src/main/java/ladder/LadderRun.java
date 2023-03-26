package ladder;

public class LadderRun {

    private LineManager lineManager;

    public LadderRun(NaturalNumber height, NaturalNumber numberOfPerson) {
        this.lineManager = new LineManager(height, numberOfPerson);
    }

    public void drawLine(int row, int col) {
        lineManager.drawLine(row, col);
    }

    public int run(NaturalNumber startPoint) {
        lineManager.validateStartPoint(startPoint);
        Node node = new Node(startPoint);
        int lastPoint = startPoint.getNumber();
        while(lineManager.isRowExceedHeight(node)){
            lastPoint = node.move(lineManager);
        }
        return lastPoint;
    }

}
