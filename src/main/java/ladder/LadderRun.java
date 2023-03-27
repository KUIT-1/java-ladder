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
            printLadder(node);
            System.out.println("\t\t\t\t↓");
            lastPoint = node.move(lineManager);
        }
        System.out.println("\n\n=================\n");
        return lastPoint.getPosition();
    }

    public void printLadder(Node node) {
        String ladder_str = lineManager.printLineByRows(node);
        System.out.print(ladder_str);
    }

}
