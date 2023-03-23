package ladder;

public class LadderArray {
    int[][] array; //이차원 배열
    //Point 객체를 따로 만들어서 하면 좋다!
    public LadderArray(int num, int height) {
        array=new int[num][height+1]; //이차원 배열 초기화(x는 1보다 크고, y도 1보다 크다고 가정)
    }
    public void draw(int x, int y) {
        if(0<=x && x<array.length-1 && y>0 && y<array[0].length){
            checkSpot(x,y);
        }
        else{
            throw new IllegalArgumentException("Input Error");
        }
    }
    public void checkSpot(int x, int y){
        if(array[x][y]!=1 && array[x+1][y]!=1){
            array[x][y]=1;
            array[x+1][y]=1;
        }
        else
            throw new IllegalArgumentException("Input Error");
    }
    public int run(int num) {
        int x=num-1;
        int y=0;
        y++; //한칸 이동
        while(y<array[0].length) {
            x=checkNext(x,y);
            y++; //한칸 이동
        }
        return x+1;
    }
    public int checkNext(int x, int y){
        if(array[x][y]==1){
            if (x == 0) {
                return x+1;//오른쪽 점 확인 할 필요 없이 ㄱ
            }
            if (x == array.length - 1)
                return x-1;//왼쪽 점 확인 할 필요 없이 ㄱ
            //오른쪽 왼쪽 점 확인 후 이동
            if(array[x+1][y]==1)
                return x+1;
            return x-1;
        }
        return x; // 아무것도 아니면 그냥 x 반환
    }
    public int getNum(){
        return array.length;
    }
    public int getHeight(){
        return array[0].length;
    }
}
