package ladder;

public enum Direction {
    LEFT(1),RIGHT(-1),CENTER(0);
    int direction;

    Direction(int direction) {
        this.direction=direction;
    }

    public int getDirection() {
        return direction;
    }



    public void printDirection() {
        if(direction==1){
            System.out.print("1");

        }
        else if(direction==0){
            System.out.print("0");

        }
        else if(direction==-1){
            System.out.print("-1");
        }

        System.out.print(" ");

    }

    public void printPositionDirection(boolean positionIdx) {
        if(direction==1){
            System.out.print("1");

        }
        else if(direction==0){
            System.out.print("0");

        }
        else if(direction==-1){
            System.out.print("-1");
        }

        if(positionIdx)
            System.out.print("* ");
        else
            System.out.print(" ");


    }
}
