package ladder;

public class Position {
    int position;
    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Position createPosition(int position){
        return new Position(position);
    }
    public void moveLeft() {
        position--;
        validatePosition();
    }

    public void moveRight() {
        position++;
    }

    public void validatePosition(){
        if(position<0){
            throw new IllegalArgumentException("유효한 위치가 아닙니다");
        }
    }
}
