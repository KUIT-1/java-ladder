package ladder;

public class Row {

    int[] row;

    public Row(int numberOfPerson){
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int col){
        validateColumn(col);
        row[col] = 1;
        row[col+1] = -1;
    }

    public int nextPosition(int position){
        validatePosition(position);
        if(row[position] == 1) return position+1;
        if(row[position] == -1) return position-1;
        return position;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson<1){
            throw new IllegalArgumentException();
        }
    }

    private void validateColumn(int col) {
        if ((col<0)||(col>=row.length)){
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(int position) {
        if ((position<0)||(position>row.length)){
            throw new IllegalArgumentException();
        }
    }

}
