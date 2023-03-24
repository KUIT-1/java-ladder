package ladder;

public class CreateLadder {

    private Direction[][] ladder;
    // -1(왼쪽으로 선 그어져 있음) , 0 , +1 (오른쪽으로 선 그어져 있음) +1 ___ -1
    pRow pRow;
    int totalRow;
    int totalCol;

    public CreateLadder( int totalRow, int totalCol) {

        this.totalRow = totalRow;
        this.totalCol = totalCol;
        pRow=new pRow(0);
        validateLadderRow(totalRow);
        validateLadderCol(totalCol);
        this.ladder=initLadder();


    }


    private Direction[][] initLadder() {
        ladder=new Direction[totalRow][];
        for(int i = 0; i< totalRow; i++){
            ladder[i] = new Direction[totalCol];
            initLadderCols(i);

        }
        return ladder;

    }

    private void initLadderCols(int i) {
        for(int j = 0; j< totalCol; j++){
            ladder[i][j]=new Direction(0);
        }
    }



    public void drawLine(int row_idx,int startCol){
        validateDrawLine(row_idx,startCol);
        validateNotToDrawConnedtedLine(row_idx,startCol);
        ladder[row_idx][startCol] = new Direction(1);
        ladder[row_idx][startCol+1]= new Direction(-1);
    }

    void validateNotToDrawConnedtedLine(int row, int startcol){
        //if(ladder[row][startcol]==-1 || ladder[row][startcol+1]==1)
        if(ladder[row][startcol].isRight()|| ladder[row][startcol+1].isLeft())
            throw new IllegalArgumentException();

    }

    boolean isLadderDirectionLeft(int row,int col){
        return ladder[row][col].isLeft();
    }

    boolean isLadderDirectionRight(int row,int col){
        return ladder[row][col].isRight();
    }

    boolean isLadderDirectionNo(int row,int col) {
         return ladder[row][col].isNoDirection();
    }
    void validateLadderRow(int totalRow){
        if(totalRow<=0){
            throw new IllegalArgumentException("행 개수가 0 또는 음수입니다");
        }
    }

    void validateLadderCol(int totalCol){
        if(totalCol<=0){
            throw new IllegalArgumentException("열 개수(사람 수)가 0 또는 음수입니다");
        }
    }

    void validateDrawLine(int row_idx,int startCol){

        if(!(startCol>=0 && startCol<totalCol-1)||!(row_idx>=0 && row_idx<totalRow))
            throw new IllegalArgumentException("선을 그을 수 없는 점입니다");
    }

    int getDirection(int row,int col){
        return ladder[row][col].getDirection();
    }



}
