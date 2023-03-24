package ladder;

public class Direction {
     int direction;
    // -1(왼쪽으로 선 그어져 있음) , 0 , +1 (오른쪽으로 선 그어져 있음) +1 ___ -1
     public Direction(int direction) {
         this.direction = direction;
     }

     public int getDirection(){
         return direction;
     }

     boolean isLeft(){
        return direction==1;
     }

     boolean isRight(){
        return direction==-1;
     }

     boolean isNoDirection(){
         return direction==0;
     }

}
