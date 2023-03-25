package ladder;

public class Ladder {
	Row[] Rows;
			
	public Ladder(int numRow, int numPerson) {
		Rows = new Row[numRow]; //row의 사이즈
		for (int i =0; i<numRow; i++) {
			Rows[i] = new Row(numPerson); //tempRows라는 배열에 담기
		}
	}
	
	public void drawLine(int nthRow, int startLine) { //몇번쨰 row
		Rows[nthRow].draw(startLine);
	}
	
	public int run(int nthPerson) {
		for (int i = 0; i<Rows.length; i++) {//행들 얻어오기
			Row row = Rows[i]; //데이터 얻어와서
			nthPerson = row.moveRow(nthPerson);
		}
		return nthPerson;
	}

}
