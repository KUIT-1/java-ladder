package KuitMission;

import KuitMission.creator.DesignLadderCreator;
import KuitMission.creator.LadderCreator;
import KuitMission.manager.LadderManagerImpl;
import KuitMission.printer.LadderPrinter;
import KuitMission.printer.LadderPrinterImpl;
import KuitMission.runner.LadderRunner;
import KuitMission.runner.LadderRunnerImpl;

public class LadderConfig {
    public LadderManagerImpl ladderManager() {
        return new LadderManagerImpl(ladderCreator(),ladderPrinter(),ladderRunner());
    }
    private static LadderCreator ladderCreator(){
        return new DesignLadderCreator();
    }
    private static LadderPrinter ladderPrinter(){
        return new LadderPrinterImpl();
    }
    private static LadderRunner ladderRunner(){
        return new LadderRunnerImpl();
    }
}
