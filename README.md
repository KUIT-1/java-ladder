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

- Rows클래스
  - getNumofRow() : 사다리 길이 반환
  - getNumofPerson() : 사람 수 반환
  - getValue() : 해당 위치에 저장된 값 반환
  - validateLadder() : 사다리 생성 시, 사람 수가 0명 이하이거나 사다리 길이가 0이하인지 검사
  - validatePosition() : 해당 위치가 사다리에서 벗어난 위치인지 검사
  - validateNumOfPerson() : 사다리 타기 실행 시, 참여하는 사람의 수 검사
  - drawLine() : 사다리 그리는 함수

- 사다리 생성 시, 사다리 길이가 0이거나 사다리 탈 수 있는 사람이 0명이면 IllegalArgumentException
- 사다리 타기 실행 시, 선택된 사다리 번호가 만들어진 범위에서 벗어나면 IllegalArgumentException
- 사다리 선 그릴 때, 사다리 위치에서 벗어나면 IllegalArgumentException

Direction -> isOrNotLadder