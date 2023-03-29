- 사다리 생성 시, 사다리 길이가 0이거나 사다리 탈 수 있는 사람이 0명이면 IllegalArgumentException
- 사다리 타기 실행 시, 선택된 사다리 번호가 만들어진 범위에서 벗어나면 IllegalArgumentException
- 사다리 선 그릴 때, 사다리 위치에서 벗어나면 IllegalArgumentException
- 사다리 선 그릴 때, 선이 이미 있는 위치이면 IllegalArgumentException

- 랜덤 사다리 line 개수가 행*열*0.3이 아니면 예외처리
- 