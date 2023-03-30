package ladder;

public class Position {
    private int position;
    private static final int START_INDEX = 1;

    private Position(int position) {
        this.position = position;
    }

    public static Position createPosition(int position){
        validateNumber(position);
        return new Position(position);
    }

    private static void validateNumber(int position){
        if(position < START_INDEX)
            throw new IllegalArgumentException("유효한 위치가 아닙니다. 자연수로 입력해주세요.");
    }

    public int getPosition(){
        return position;
    }

    public Position nextPosition() {
        return createPosition(position + 1);
    }
}
