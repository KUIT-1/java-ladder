package ladder;

public class Row {
    int[] cols;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        this.cols = new int[numberOfPerson+1];
    }

    public void drawLine(int col) {
        validateDrawLineCol(col);
        cols[col] = 1;
        cols[col+1] = -1;
    }

    public int getSelection(int selection) {
        switch (cols[selection]) {
            case 1: selection++; break;
            case -1: selection--; break;
            case 0: return selection;
        }

        if (selection < 1) {
            return cols.length;
        }
        if (selection > cols.length) {
            return 1;
        }

        return selection;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("참가자 수가 1보다 작은 수입니다.");
        }
    }

    private void validateDrawLineCol(int col) {
        if ((col <= 0) || (col >= cols.length - 1)) {
            throw new IllegalArgumentException("라인을 만들 줄이 사다리 라인 개수의 범위 안에 있어야 합니다.");
        }
    }
}
