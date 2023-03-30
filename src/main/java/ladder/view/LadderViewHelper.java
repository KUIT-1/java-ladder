package ladder.view;

import ladder.Point;
import ladder.Position;
import ladder.Row;

public class LadderViewHelper {
    public String getLadderView(Row[] rows, Point playerPoint){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < rows.length; i++){
            rows[i].createStringEachRow(Position.createPosition(i), playerPoint, sb);
        }
        return sb.toString();
    }
}
