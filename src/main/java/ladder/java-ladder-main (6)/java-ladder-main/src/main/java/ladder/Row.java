package ladder;

public class Row {
	int[] person;//몇명의 사람
	
	Row(int numPerson){
		person = new int[numPerson];
		
	}
	//row생성시 라인을 그을 수 있게 하는 메소드
	void draw(int startLine) {
		person[startLine] = 1;
		person[startLine +1] = 1;
	}

	//refactoring 한번! moveRow부분 빼줌
	int moveRow(int nthPerson) {
		if (person[nthPerson]==0) {
			return nthPerson;
		}
		
		if(nthPerson -1 >= 0) { //좌측으로 이동할 수 있을 때, 없을 떄는 - validation**
			if(person[nthPerson -1] ==1) { 
				return nthPerson -1;
			}
		}
		return nthPerson +1;
	}
	
}
