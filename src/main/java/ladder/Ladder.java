package ladder;

public class Ladder {
    LadderArray ladderArray; //이차원배열 정보를 담은 변수

    //사다리 생성자
    public Ladder(int num,int height){
        this.ladderArray=new LadderArray(num,height);
    }
    //사다리 Line 생성 함수
    void drawLine(int x,int y){
        ladderArray.draw(x,y);
    }
    //사다리 타는 함수
    int run(int num){
        return ladderArray.run(num);
    }
    int[] getInform(){
        int[] arrayInform = {ladderArray.getNum(),ladderArray.getHeight()};
        return arrayInform;
    }
    int[][] getArray(){
        return ladderArray.array;
    }
}