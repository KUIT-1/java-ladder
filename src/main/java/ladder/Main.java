package ladder;


public class Main {

    public static void main(String arg[]) {

        //변수 설정
        final int LADDERLENGTH = 10;
        final int NUMBEROFPERSON = 10;
        final int START = 5;

        //게임 시작
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(LADDERLENGTH, NUMBEROFPERSON);
        DrawLadder(START, ladderGame);
    }


    //* Ladder를 출력하는 함수
    private static void DrawLadder(int START, LadderGame ladderGame){

        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        int ans = ladderGame.run(START);
        System.out.println();
        System.out.println(ANSI_YELLOW + "===============================");
        System.out.println(ANSI_GREEN + "시작 Line : " + ANSI_RESET + START);
        System.out.println(ANSI_GREEN + "도착 Line : " + ANSI_RESET + ans);
        System.out.println(ANSI_YELLOW + "===============================" + ANSI_RESET);
    }

}
