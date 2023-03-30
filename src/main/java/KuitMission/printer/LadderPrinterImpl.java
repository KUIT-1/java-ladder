package KuitMission.printer;

import KuitMission.ladder.Ladder;

public class LadderPrinterImpl implements LadderPrinter {
    @Override
    public void print(Ladder ladder) {
        for (int i = 0; i < ladder.rows.length; i++) {
            for (int j = 0; j < ladder.rows[0].numofCol; i++) {
                System.out.print(ladder.rows[i].getHere(j));
            }
            System.out.println();
        }
    }
}
