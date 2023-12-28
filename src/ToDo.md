# Refactoring ToDoList : 목표의식 잡는 연습
## Row의 사다리 방향을 표시하는 1과 -1 하드코딩 된 것을 상수로 표현
  1. public static final 사용하기
  2. enum 클래스 이용하기
     -> Discount 클래스 만들고, ing/stop 메서드 만들기
     -> enum 클래스 내부의 상수에 대한 logic을 분리할 수 있어 1번처럼 상수를 선언하는 것 보다 객체지향적인 코드가 가능해진다.
     
    # enum 클래스 검색해서 공부하기

## primitive type을 찾아서 Wrapper 클래스로 감싸기(포장)
     # 유효성 처리? 그게 뭔데..
     # wraaper 클래스 그게 뭔데 (지난주 세미나 복습하기)
     # 생성자, getter 의 기능? 필요한 이유
    ㄴ  
(매개변수가 어디서는 자연수(row)이고, 어디서는 position인 것이 다른 개발자가 봤을 때 변수명만으로 이해가 어려울 수 있다 )
  - Ladder 생성자 -> 자연수 Wrapper 클래스 -> int row라는 값에 대한 로직을 Ladder클래스로부터 분리할 수 있음
  - Position 나타내는 변수 -> Position Wrapper 클래스
  - Row의 상태값인 int -> Node Wrapper 클래스   //?


## Ladder 클래스 분리
  - LadderGame
  - LadderRunner
  - LadderCreator



# 내 원래 코드에서 바꿔야할 부분
- Ladder 클래스의 이차원배열을 Row 클래스 생성을 통해 일차원배열로 바꿔주기
- 그러고 2번째 강의 18분부터 보기

# 2주차 과제
- 사다리가 잘 만들어졌는지 확인하기 위해 문자열을 생성하기
 -> 사다리의 위치, 사다리가 어떻게 돌아가고 있는지 확인할 수 있음
 -> 출력하는 코드 적기
- 사다리의 Line을 자동생성 하는 기능 추가하기(RamdomLadderCreator, 의존성 주입?해보기!!)