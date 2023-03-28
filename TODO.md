# java-ladder
# TODO LIST - 리팩토링

- 이차원 배열(LadderArray)을 일차원 배열(Row)로 수정
- 사다리에서 표시된 부분이 1로 하드코딩된 것을 상수로 표현
  - public static final int LADDER_CHECKED = 1 ;
- 사다리 생성(Ladder)과 사다리 타기(LadderManager)로 나누어서 역할 분배
  - Ladder 클래스 -> 생성(생성자, drawLine)
  - LadderManager 클래스 -> run, game 수행
- 각 함수가 담당하는 역할은 하나로! (이름도 직관적이게 수정)
- Primitive type들을 찾아서 Wrapper 클래스로 포장
  - Ladder 클래스 생성자 -> 자연수 Wrapper 클래스
    - 자연수에 대한 클래스에서 유효성 검사도 같이 함으로서 생성 클래스에서 따로 유효성 검사를 할 필요가 없다!
  - Row의 상태값인 int -> Node Wrapper 클래스
    - 상태값 처리에 대한 유효성 검사도 같이 함으로
- 유효성 검사 함수 valid~ 로 만들어보기 
    - 생성할 때 숫자 자연수인지 -> 인자를 자연수 wrapper로 설정하면 따로 validate 체크할 필요 없음!
      - 자연수 숫자 생성자 호출이 너무 다발적.. creteNaturalNumer로 함수 생성
    - 사다리 Line 만들 때 유효한지 -> 인자를 Node wrapper로 설정하면 따로 validate 체크할 필요 없음!
    - run 할 때 유효한 값인지 -> position 클래스를 따로 만들어서 현재 위치 값 저장 용도로!!
    - 에러를 낼 때 메세지를 자세하게 쓰는게 좋음!

# TODO LIST - 2주차 미션
- 사다리 출력
  - 현재 사다리 모양을 확인할 수 있도록 사다리 상태를 출력하는 기능
- 사다리 자동 생성 -> 자동 생성하는 클래스를 따로 만들기 (인터페이스를 활용한 의존성 주입 시도해보자)
  - 자동 생성되는 사다리의 Line 수는 사다리 행*열*0.3
- 커밋 컨벤션에 따라 커밋 메세지 작성하기

