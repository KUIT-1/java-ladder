package ladder;

public class LadderGame {
    CreateLadder ladder;
    Player[] players;
    int totalRows;
    int personNum;

    int[] gameResult;


    public LadderGame(CreateLadder ladder, int totalRows, int personNum,Player[] players) {

        this.ladder= ladder;
        this.players=players;
        this.totalRows=totalRows;
        this.personNum=personNum;
        initPlayers();


    }

    private void initPlayers() {
        for(int i=0;i<personNum;i++){
            players[i]=new Player();
        }
    }

    int getDirectionByMove(int row, int col){
            return ladder.getDirection(row,col);
    }

    int run(int col){
        int pRow=0;

        while(pRow!=totalRows-1){
            col+=getDirectionByMove(pRow,col);
            pRow++;

        }
        return col;
    }



    int[] gameResult(){//결과값인 col 반환하는 배열
        gameResult= new int[personNum];
        for(int i=0;i<personNum;i++){
            int endCol=run(i);
            players[i].setEndCol(endCol);
            gameResult[i]=endCol;
        }

        return gameResult;
    }

    int getGameResult(int ith){
        return gameResult[ith];
    }


}
