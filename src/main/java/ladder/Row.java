package ladder;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

import static ladder.Ladder.numberOfPerson;

public class Row {

    private int[] oneRow;

    public Row(int numberOfPerson) {
        oneRow = new int[numberOfPerson];
    }

    public void drawLine(int column) {
        if(column<numberOfPerson-1) {
            oneRow[column] = 1;
            oneRow[column + 1] = -1;
        }else
            System.out.println("사다리 줄을 잘못 그렸습니다.");
    }

    public int nextPosition(int pColumn) {
        if (oneRow[pColumn] == 1) {
            pColumn++;
        } else if (oneRow[pColumn] == -1) {
            pColumn--;
        }
        return pColumn;
    }

    @Override
    public String toString() {
        return Arrays.toString(oneRow);
    }
}