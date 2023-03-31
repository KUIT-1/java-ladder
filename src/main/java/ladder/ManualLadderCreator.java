package ladder;

public class ManualLadderCreator implements LadderCreator{
    private Row[] ladder;
    private LadderSize ladderSize;

    public ManualLadderCreator(LadderSize ladderSize) {
        validateTotalRow(ladderSize.totalRow);
        ladder=new Row[ladderSize.totalRow];
        for(int i=0;i<ladderSize.totalRow;i++){
            ladder[i]=new Row(ladderSize.totalCol);
        }

    }

    public void drawLine(int rowIdx,int startCol){

        validateDrawLineRow(rowIdx);
        ladder[rowIdx].drawLine(startCol);

    }

    private void validateDrawLineRow(int rowIdx) {
        if(rowIdx<0 || rowIdx>=ladder.length)
            throw new IllegalArgumentException("선을 그을 수 없는 row입니다");
    }


    void validateTotalRow(int totalRow){
        if(totalRow<=0){
            throw new IllegalArgumentException("행 개수가 0 또는 음수입니다");
        }
    }

    public Row[] getLadder() {
        return ladder;
    }

    public void printLadder() {
        for(int i=0;i<ladder.length;i++){
            ladder[i].printRow();
            System.out.println();
        }
    }
}
