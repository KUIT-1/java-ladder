package ladder;

import java.util.HashSet;
import java.util.Random;

import static ladder.Direction.*;
import static ladder.Node.*;

public class Rows {
    private final Node[] nodes;

    public Rows(NaturalNumber numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];

        for(int r = 0; r< nodes.length; r++){
            nodes[r] = createNoLadderNode();
        }
    }

    public void drawLine(Position position){
        validatePositionSize(position);
        nodes[position.getPosition()] = createLadderNode();

        // 연속 2개의 사다리가 만들어지는지 확인
        for(int c=0; c<=nodes.length-3; c++){
            validateDrawline(c, position);
        }
    }

    public boolean RandomLadderDrawLine(Position position){
        validatePositionSize(position);

        nodes[position.getPosition()] = createLadderNode();

        for(int c=0; c<=nodes.length-3; c++){
            validateDrawline(c, position);
        }

        if(position.getPosition() < nodes.length-1 && nodes[position.getPosition()].isLadder() && nodes[position.getPosition()+1].isLadder()){
            return true;
        }
        if(position.getPosition() > 0 && nodes[position.getPosition()].isLadder() && nodes[position.getPosition()-1].isLadder()){
            return true;
        }
        return false;
    }


    public void nextPosition(Position num){
        validatePositionSize(num);

        // 현재 위치 기준 오른쪽에 사다리가 있을 때 오른쪽으로 이동
        if (num.getPosition() < nodes.length-1 && nodes[num.getPosition()].isLadder() && nodes[num.getPosition()+1].isLadder()){
            num.plusPosition();
            return;
        }
        // 현재 위치 기준 왼쪽에 사다리가 있을 때 왼쪽으로 이동
        if (num.getPosition() > 0 && nodes[num.getPosition()].isLadder() && nodes[num.getPosition()-1].isLadder()){
            num.minusPosition();
        }
    }

    public void printRow(Boolean row, Position xpos){
        String str = "";
        for(int i=0; i<nodes.length; i++){
            str += nodes[i].getDirection();
            if(xpos.getPosition() == i && row){ str += "*"; }
            str += " ";
        }
        System.out.println(str);
    }

    // 사다리 그릴 수 있는지 확인
    private void validateDrawline(int col, Position position){
        if(nodes[col].isLadder() && nodes[col+1].isLadder() && nodes[col+2].isLadder()){
            nodes[position.getPosition()] = createNoLadderNode();
        }
    }

    private void validateRandomDrawline(int col, Position position){
        if(nodes[col].isLadder() && nodes[col+1].isLadder() && nodes[col+2].isLadder()){
            nodes[position.getPosition()] = createNoLadderNode();
            nodes[position.getPosition()+1] = createNoLadderNode();
        }
    }

    private void validatePositionSize(Position position) {
        if (!position.isSmaller(nodes.length)) {
            throw new IllegalArgumentException("올바른 사다리의 위치가 아닙니다.");
        }
    }
}
