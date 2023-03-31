package ladder;

public class Ladder {

    //private final int[][] rows;
    private final Row[] rows;
    private final int row;
    private final int numberOfPerson;
    // public Ladder(int row, int numberOfPerson) {rows = new int[row][numberOfPerson];}
    private final int height; // 세로줄의 개수
    private final int width; // 가로줄의 개수

    public Ladder(int row, int numberOfPerson){
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        height = row;
        width = numberOfPerson * 2 - 1; // 각 가로줄에는 세로줄이 2개씩 들어가므로, 사람 수에 2를 곱하고 1을 빼준다.
        rows = new Row[row];
        for(int i=0; i<row; i++){
            rows[i] = new Row(numberOfPerson);
        }
    }

    //사다리의 각 라인의 생성은 drawLine(position) 메서드를 만들어 수동으로 사다리를 만들 수 있게 한다.
    // 즉, 처음 만들어진 사다리는 아예 빈 사다리이다.
    public void drawLine(int row, int col){
        // (col, row) 라인 만들기
        rows[row].drawLine(col);
    }
    public int run(int position){
//        for(int i=0; i< rows.length; i++) {
//            rows[i].newPosition(position);
//        }
//        return position;
        LadderPosition currentPosition = new LadderPosition(position, 0);
        for (int i = 0; i < height; i++) {
            String rowString = rows[i].getRowString();
            if (currentPosition.getX() > 0 && rowString.charAt(currentPosition.getX() * 2 - 1) == '-') { // 현재 위치에서 왼쪽으로 가는 사다리가 있는 경우
                currentPosition = new LadderPosition(currentPosition.getX() - 1, currentPosition.getY() + 1);
            } else if (currentPosition.getX() < width - 1 && rowString.charAt(currentPosition.getX() * 2 + 1) == '-') { // 현재 위치에서 오른쪽으로 가는 사다리가 있는 경우
                currentPosition = new LadderPosition(currentPosition.getX() + 1, currentPosition.getY() + 1);
            }
        }
        return currentPosition.getX();

    }

    public void printLadder(int position) {
        for (int i = 0; i < height; i++) {
            String rowString = rows[i].getRowString();
            if (i == position) { // 현재 위치에 * 표시
                System.out.println(rowString.replaceAll("(\\\\|-)", "$0*"));
            } else {
                System.out.println(rowString);
            }
        }
    }

}