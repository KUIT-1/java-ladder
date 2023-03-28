package ladder;


public class DrawLadder {

    private Col[] cols;

    private DrawLadder(Col[] cols, Position ans_col, Position ans_row) {
        this.cols = cols;
        for(int i = 0; i < cols[0].getColLength(); i++) System.out.println();
        System.out.print(this.showLadder(ans_row, ans_col));
        try{Thread.sleep(1500);} catch(InterruptedException e) {}
    }

    public static DrawLadder createDrawLadder(Col[] cols, Position ans_col, Position ans_row) {
        return new DrawLadder(cols, ans_col, ans_row);
    }

    //사다리 출력 함수
    public String showLadder(Position current_row,Position current_col) {

        String S = "";
        //숫자 출력
        for(int i = 0; i < cols.length; i++) S += i + " ";
        S += "\n";

        //열 출력
        for(int i = 0; i < cols[0].getColLength(); i++) {
            //행 출력
            S = getRow(current_row, current_col, S, i);
            S += "\n";
        }
        //숫자 출력
        for(int i = 0; i < cols.length; i++) S += i + " ";
        S += "\n";
        return S;
    }

    //* 행 출력 함수
    private String getRow(Position current_row, Position current_col, String S, int i) {
        for(int j = 0; j < cols.length; j++) S = getColor(current_row, current_col, S, i, j);
        return S;
    }

    //* 색상 추가 함수
    private String getColor(Position current_row, Position current_col, String S, int i, int j) {

        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        if((i == current_row.getPosition()) && (j == current_col.getPosition())) S += ANSI_RED;
        S += cols[j].toString(i);
        S += ANSI_RESET;
        return S;
    }
}
