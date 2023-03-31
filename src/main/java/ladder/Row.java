package ladder;

public class Row {
    Node[] nodes;

    public Row(int totalCol) {
        validateTotalCol(totalCol);
        nodes = new Node[totalCol];
        for(int i=0;i<totalCol;i++){
            nodes[i]= Node.createCenterNode();
        }

    }

    private void validateTotalCol(int totalCol) {
        if(totalCol<=0){
            throw new IllegalArgumentException("열 개수(사람 수)가 0 또는 음수입니다");
        }
    }


    public void drawLine(int startCol) {
        validateDrawLineCol(startCol);
        validateAlreadyHasLine(startCol);
        validateNotToDrawConnectedLine(startCol);
        nodes[startCol]=Node.createRightNode();
        nodes[startCol+1]=Node.createLeftNode();

    }

//    public int move(int col){
//        if(nodes[col].isDirectionRight())
//            return col+1;
//        else if(nodes[col].isDirectionLeft())
//            return col-1;
//        else
//            return col;
//    }

    private void validateAlreadyHasLine(int startCol) {
        if(nodes[startCol].isDirectionLeft()||nodes[startCol+1].isDirectionRight())
            throw new IllegalArgumentException("이미 선이 그어져 있습니다");

    }

    private void validateNotToDrawConnectedLine(int startCol) {
        if(nodes[startCol].isDirectionRight()||nodes[startCol+1].isDirectionLeft())
            throw new IllegalArgumentException("연결되게 선을 그을 수 없습니다");

    }

    private void validateDrawLineCol(int startCol) {
        if(startCol<0 || startCol>=nodes.length-1)
            throw new IllegalArgumentException("선을 그을 수 없는 col입니다");
    }

    public void nextPosition(Position position) {
        nodes[position.getPosition()].move(position);
//        if(nodes[col.getpCol()].isDirectionLeft()){
//            col.moveLeft();
//        }
//        if(nodes[col.getpCol()].isDirectionRight()){
//            col.moveRight();
//        }
//        else{
//            //stay
//        }
    }

    public void printRow() {
        for(int i=0;i<nodes.length;i++){
            nodes[i].printNode();
        }
    }



    public void printNodesWithStar(Position position) {

        for(int nodeIdx=0;nodeIdx<nodes.length;nodeIdx++){
            boolean positionIdx=false;
            if(position.getPosition()==nodeIdx)
                positionIdx=true;
            nodes[nodeIdx].printPositionNode(positionIdx);
        }
    }

    public void printNodesWithoutStar() {

        for(int nodeIdx=0;nodeIdx<nodes.length;nodeIdx++){
            nodes[nodeIdx].printNode();
        }
    }
}
