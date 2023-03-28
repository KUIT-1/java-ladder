# java-ladder

# 2주차 미션 - 사다리 타기 요구사항 2단계
# 기능 요구사항 2: 사다리 출력
사다리를 만든 후, 제대로 생성되었는지를 확인하기 위해서는 사다리의 모양을 출력해볼 필요가 있다.

---
# 기능 요구사항 3: 사다리 자동 생성
사다리의 Line을 정책에 맞게 자동생성 해보자.

1. 자동 생성되는 사다리의 Line의 수는 `사다리 행*열 *0.3`이다.
2. 사다리는의 Line은 겹쳐져서 생성될 수 없다. (e.g., 1 -1 -1 / 1 1 -1)
3. 가능하다면 `LadderGame`에 인터페이스를 활용한 의존성 주입을 통해 `LadderCreator`를 변경할 수 있도록 해본다.
4. 정적 팩토리 메서드 패턴을 활용하여 LadderGame을 생성해보자.
    - e.g., `LadderGame ladderGame = LadderGameFactory.createRandomLadderGame()`
    - 의존성 주입을 팩토리 메서드가 맡을 수 있게 된다.
    - 즉, LadderGame을 생성하는 책임을 한 클래스가 맞게 된다!
