package ladder;

import junit.framework.TestCase;

public class LadderTest extends TestCase {
	public void testRunWhenNoLine() throws Exception {
		Ladder ladder = new Ladder(1,3);
		int target = ladder.run(0); //starting position 0으로 잡기
		assertEquals(0, target);
		
		target = ladder.run(1);
		assertEquals(1, target); //현재 사람 중 2번째에서 출발한다면? > 현재 위치 return 됨
	}
	

	public void testLineLeft() throws Exception {
		// 0 1 1 배열에 담긴값!
		Ladder ladder = new Ladder(1,3);
		ladder.drawLine(0,1); //첫지점에 라인 그엇을 때
	
		int target = ladder.run(2); //세번째 값으로 이동 했을 때 2나와야함
		assertEquals(1, target);
		
		// 1 1 0
		ladder = new Ladder(1,3);
		ladder.drawLine(0,0);
		
		ladder.run(0);
		
	}
	//우측 확인
	public void testLineRight() throws Exception {
		// 0 1 1 배열에 담긴값! 우측 이동시
		Ladder ladder = new Ladder(1,3);
		ladder.drawLine(0,1); 
			
		int target = ladder.run(1); //오른쪽에 라인 있으니 +1해야한다.
		assertEquals(2, target);
		
		// 0 1 1
		ladder = new Ladder(1,3);
		ladder.drawLine(0,1);
		
		target = ladder.run(2);
		assertEquals(1, target);
		
		
	}
	public void testRows() throws Exception {
		// 1 1 0 0
		// 0 1 1 0
		// 0 0 1 1 
		Ladder ladder = new Ladder(3, 4); //row 3, 사람 4
		ladder.drawLine(0, 0); //라인 긋기
		ladder.drawLine(1, 1);
		ladder.drawLine(2, 2);
		
		assertEquals(3, ladder.run(0));
		assertEquals(0, ladder.run(1));
		assertEquals(1, ladder.run(2));
		assertEquals(2, ladder.run(3));
		//하나의 행으로만 되어있던 > 2차원 배열로 만든다음에 단위테스트 진행했음
		//예외 로직 추가해야함!
	}
}