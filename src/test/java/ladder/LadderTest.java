package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


  Ladder ladder;

  //길이 5, 사람 수 5로 초기화
  @BeforeEach
  public void Test_Before() {
      ladder = new Ladder(5, 5);
  }


//Error Test/////////////////////////////////////////

    //drawLine을 할 때 index가 정상 범위인지?
    @Test
    @DisplayName("Validation drawLine")
    public void Test_Valid_DrawLine() {
        //row가 범위 밖
        assertEquals(false, ladder.drawLine(1000, 0, "right"));
        //col이 범위 밖
        assertEquals(false, ladder.drawLine(0, 1000, "right"));
        //최좌측에서 왼쪽으로 사다리 연결
        assertEquals(false, ladder.drawLine(0, 1, "left"));
        //최우측에서 오른쪽으로 사다리 연결
        assertEquals(false, ladder.drawLine(0,5, "right"));
        //direction에 left,right 외의 다른 값이 들어갔을 때
        assertEquals(false, ladder.drawLine(0,3,"trash"));
    }

    //시작 person의 위치가 정상적인지?
    @Test
    @DisplayName("Validation start position")
    public void Test_Valid_Start() {
        //시작 위치가 음수
        assertEquals(-1, ladder.run(-1));
        //시작 위치가 사다리 초과
        assertEquals(-1, ladder.run(100));
    }

/////////////////////////////////////////////////////


//Normal Operation Test//////////////////////////////

    //선이 없을 때 쭉 내려오는지?
    @Test
    @DisplayName("Only One Ladder")
    public void Test_One_Ladder() {
      ladder = new Ladder(10,1);
      assertEquals(0,ladder.run(0));
    }

    //중간에 선을 만났을 때 건너가지는지 - 2개 사다리 1개 선
    @Test
    @DisplayName("2 Ladder 1 Line")
    public void Test_Two_Ladder_One_Line() {
      ladder = new Ladder(10, 2);
      ladder.drawLine(1,1,"left");
      assertEquals(1,ladder.run(0));
    }

    //정상 작동
    @Test
    @DisplayName("Normal Operation")
    public void Test_Normal() {
      ladder.drawLine(1,1, "right");
      ladder.drawLine(2, 0, "right");
      ladder.drawLine(3, 3, "left");
      ladder.drawLine(1,4, "left" );

      assertEquals(3, ladder.run(1));
    }

/////////////////////////////////////////////////////




}