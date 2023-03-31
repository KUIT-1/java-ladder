# java-ladder

1. 두 개의 사다리를 연속으로 그릴 수 없음
2. 사다리가 있는 위치에 1저장
3. 1이 저장되어 있지 않은 위치에는 사다리가 없음
4. 현재 위치 기준 오른쪽에 사다리가 있을 때 오른쪽으로 이동
   (현재 위치와 오른쪽으로 +1인 위치의 값이 모두 1일 때)
5. 현재 위치 기준 왼쪽에 사다리가 있을 때 오른쪽으로 이동
   (현재 위치와 왼쪽으로 -1인 위치의 값이 모두 1일 때)
6. 연속 2개의 사다리가 만들어지지 않게 하기 위해 연속 3개의 위치가 1이 되지 않도록 조절
   (연속 2개의 사다리 = 연속 세 점의 값이 1)

- Direction enum 클래스 -> 사다리 선이 있는지 없는지를 1 또는 0으로 정의 (Direction -> isOrNotLine)
- LadderPostion 클래스 -> 사다리 선 생성할 위치 넘겨줄 때 사용
- LadderSize 클래스 -> 사다리 생성할 크기 넘겨줄 때 사용 -
- Rows 클래스 -> 사다리 행 클래스
- Node 클래스 -> 사다리 위치 클래스, 사다리 선 정보 갖고있음

DI
- LadderCreator 인터페이스에 getRow(), drawLine(), validatePositionSize() 메서드 추출
- GeneralLadderCreator, RandomLadderCreator 클래스에서 LadderCreator 인터페이스의 메서드들 구현
- LadderGame 클래스에서 인스턴스 변수로 LadderCreator 선언
- LadderGame 클래스의 생성자를 통해 구체화된 LadderCreator 받아와서 초기화
- LadderGameFactory 클래스에서 LadderGame 클래스로 LadderCreator 클래스와의 의존성 주입

랜덤 사다리
- RandomLadderCreator 클래스에서 랜덤사다리 생성
- LadderGameFactory 클래스의 createRandomLadderGame메서드에서 HashSet<LadderPosition>을 통해 중복되는 선 확인
- 값 비교위해 LadderPostion 클래스에서 hashCode(), equals() 오버라이딩

사다리 실행 및 출력
- LadderGame 클래스의 run메서드 실행하면 LadderRunner객체 생성 후, LadderRunner객체의 run메서드 실행
- LadderRunner 클래스의 run메서드에서 사다리 print
- LadderGame 클래스의 drawLine메서드에서 LadderCreator 클래스의 drawLine메서드 호출하여 사다리 선 그리기 수행