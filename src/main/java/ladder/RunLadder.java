package ladder;

public class RunLadder {

    Row[] ladder;
    public RunLadder(Row[] ladder) {
        this.ladder=ladder;
    }

    int run(Position position){

        for(int rowIdx=0;rowIdx<ladder.length;rowIdx++){
            printLadderBeforeAndAfter(position,rowIdx);
            ladder[rowIdx].nextPosition(position);
            printLadderBeforeAndAfter(position,rowIdx);
        }

        return position.getPosition();

    }

    private void printLadderBeforeAndAfter(Position position,int rowIdx) {
        for(int i=0;i<ladder.length;i++){
            if(rowIdx==i)//*포함 출력
                ladder[i].printNodesWithStar(position);
            else
                ladder[i].printNodesWithoutStar();
            System.out.println();
        }
    }
}
