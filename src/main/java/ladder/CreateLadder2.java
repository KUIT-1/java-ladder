package ladder;

public class CreateLadder2 {
    private Row[] ladder;

    public CreateLadder2(int totalRow,int totalCol) {
        validateTotalRow(totalRow);
        ladder=new Row[totalRow];
        for(int i=0;i<totalRow;i++){
            ladder[i]=new Row(totalCol);
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
}
