package ladder;

public class StringManager {
    String right = "┠";
    String left = "┫";
    String straight = "┃";
    String startMessage = "[사다리 타기 게임을 시작합니다.]";
    String endMessage = "와! 사타리 타기 게임이 종료되었습니다~~~~!";
    String singleDash = "----------------------------------------------------";
    String doubleDash = "====================================================";
    String userSymbol = "*";
    String validateDrawingPositionErrorMessage = "startPosition 위치에서 Line 을 생성할 수 없습니다.";
    String validatePositionSizeErrorMessage = "포지션의 사이즈가 너무 큽니다!";
    String validatePositionErrorMessage = "유효하지 않은 Position 입니다.";
    String stepInfoMessage = "step: ";

    public String getStepInfoMessage() {
        return stepInfoMessage;
    }

    public String getValidateDrawingPositionErrorMessage() {
        return validateDrawingPositionErrorMessage;
    }

    public String getValidatePositionSizeErrorMessage() {
        return validatePositionSizeErrorMessage;
    }

    public String getValidatePositionErrorMessage() {
        return validatePositionErrorMessage;
    }

    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }

    public String getStraight() {
        return straight;
    }

    public String getStartMessage() {
        return startMessage;
    }

    public String getEndMessage() {
        return endMessage;
    }

    public String getSingleDash() {
        return singleDash;
    }

    public String getDoubleDash() {
        return doubleDash;
    }
    public String getSpace(){
        return " ";
    }
    public String getTab(){
        return "\t";
    }
    public String getUserSymbol(){
        return userSymbol;
    }
    public String getNewLine(){
        return "\n";
    }

    public String getResultString(Position resultPosition){
        StringBuilder sb = new StringBuilder();
        sb.append(">> 최종 도착지는 ");
        sb.append(resultPosition.getPosition() + 1);
        sb.append(" 번째 사다리 입니다.(사다리 번호는 1부터 시작)\n");
        sb.append(singleDash);
        sb.append(getNewLine());
        return sb.toString();
    }
}
