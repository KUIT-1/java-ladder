# Ladder
## 구현 기능

- Ladder: 사다리 생성
- drawLine: 사다리 라인 그리기
- run: 사다리 게임하기

## 조건 / 제한

- 게임하는 사람 수, 사다리 층의 수
  - 1 < 사람 수
  - (사람 수 + 1) <= 사다리 층 수
- 사다리 라인 그리는 위치
  - 0 < x < 사다리층-1
  - 0 <= y < 사람수-1
  - 사다리 라인의 사전 존재 여부


## 보완할 것

- [ ] Ladder 생성자 wrapper class
- [x] 사다리 이중 배열 -> Row[] ; 책임 나누기
- [x] Position 에서 사용하는 Ladder 없애기
- [x] pointX, pointY wrapper class
- [x] 사다리 라인 생성 시 1, -1, 0 상수 enum 처리
- [ ] LadderTest 에서 Position 관련 Test -> PositionTest
- [ ] validation 메서드 본인 자리 찾아주기

## 참고

- 객체지향 생활 체조 9원칙 (소트웍스 앤솔러지)