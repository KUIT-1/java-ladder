package ladder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator{
    private Row[] ladder;
    private LadderSize ladderSize;

    public AutoLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        validateTotalRow(ladderSize.totalRow);
        ladder=new Row[ladderSize.totalRow];
        for(int i=0;i<ladderSize.totalRow;i++){
            ladder[i]=new Row(ladderSize.totalCol);
        }

        pickRandomPoint();
    }

    private void pickRandomPoint() {
        int totalLineNum= (int) (ladderSize.totalCol* ladderSize.totalRow*0.3);
        Random randRow=new Random(ladderSize.totalRow);
        Random randCol=new Random(ladderSize.totalCol-1);
        Map randomPoints=new HashMap<Integer,Integer>();
        while(randomPoints.size()<=totalLineNum){
            //선이 연결되지 않게 어떻게 처리?
            randomPoints.put(randRow,randCol);
        }

        Iterator<Integer> it = randomPoints.keySet().iterator();
        while(it.hasNext()) {
            int key = it.next();
            drawLine(key, (Integer) randomPoints.get(key));
        }

    }

    private void validateTotalRow(int totalRow) {
        if(totalRow<=0){
            throw new IllegalArgumentException("행 개수가 0 또는 음수입니다");
        }
    }

    @Override
    public void drawLine(int rowIdx, int startCol) {
        validateDrawLineRow(rowIdx);
        ladder[rowIdx].drawLine(startCol);
    }

    @Override
    public Row[] getLadder() {
        return ladder;
    }

    private void validateDrawLineRow(int rowIdx) {
        if(rowIdx<0 || rowIdx>=ladder.length)
            throw new IllegalArgumentException("선을 그을 수 없는 row입니다");
    }


}


