# Todo (2주차)

- Primitive type 을 Wrapper Class 로
  - NaturalNum
  - Position
  - int[] row -> Node[] row

- Ladder 클래스의 책임을 분리

  - LadderRunner
  - LadderCreator
  - LadderGame

- 사다리 출력하기
  - Row.Show()
  : 한 줄을 String 으로 출력

  - LadderPosition Class
    - (x, y)
  - 현재 위치(*) 출력하기
    - Run method 내에서 위치가 바뀌기 이전에 한번, 이후에 한번씩 출력하기


- 사다리 자동 생성

  - 자동 생성되는 Line 의 수 : 행 * 열 * (0.3)
  - LadderGame 에 인터페이스를 활용한 DI 로 LadderCreator 을 변경하도록 해보기
  - 정적 팩토리 메서드 패턴을 이용하여 LadderGame 을 생성하기

    - LadderGame ladderGame = LadderGameFactory.createRandomLadderGame()
    - DI 는 Factory Method 가 맡도록 하기
    - LadderGame 을 생성하는 책임을 한 클래스에게.
  