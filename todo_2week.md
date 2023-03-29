# Todo (2주차)

️🟢 구현 및 리팩토링 완료

🔵 리팩토링 필요

🔴 아직 구현 안함
- Primitive type 을 Wrapper Class 로 ️🟢
  - NaturalNum️🟢
  - Position️🟢
  - int[] row -> Node[] row️🟢

- Ladder 클래스의 책임을 분리️🟢

  - LadderRunner️🟢
  - LadderCreator️🟢
  - LadderGame️🟢

- 사다리 출력하기️🟢

  - 출력 관련 책임을 담당하는 클래스를 만들자 (LadderView)️🟢
      - Row.Show()️🟢
      - 한 줄을 String 으로 출력️🟢
      - Point Class️🟢
      - (x, y)️🟢
      - 현재 위치(*) 출력하기️🟢
      - Run method 내에서 위치가 바뀌기 이전에 한번, 이후에 한번씩 출력하기️🟢


- 사다리 자동 생성 🔴

  - 사다리 생성 관련한 책임을 담당하는 클래스를 만들자 (LadderGameFactory)
  - LadderGameFactory.createRandomLadderGame(density p)

    - 자동 생성되는 Line 의 수 : 행 * 열 * (0.3)
    - LadderGame 에 인터페이스를 활용한 DI 로 LadderCreator 을 변경하도록 해보기
    - 정적 팩토리 메서드 패턴을 이용하여 LadderGame 을 생성하기

      - LadderGame ladderGame = LadderGameFactory.createRandomLadderGame()
      - DI 는 Factory Method 가 맡도록 하기
      - LadderGame 을 생성하는 책임을 한 클래스에게.
  