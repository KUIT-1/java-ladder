package ladder;

import ladder.NaturalNumber;
import java.util.Set;
import java.util.HashSet;
import ladder.random.Point;
import java.util.Set;
public class LadderSize {
    private NaturalNumber height;
    private NaturalNumber numberOfPerson;

    public LadderSize(NaturalNumber height, NaturalNumber numberOfPerson){
        this.height = height;
        this.numberOfPerson = numberOfPerson;
    }

    public int getHeight(){
        return height.getNumber();
    }

    public int getNumberOfPerson(){
        return numberOfPerson.getNumber();
    }

}