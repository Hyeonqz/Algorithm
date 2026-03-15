# DFS (깊이 우선 탐색)

## 1. DFS란?

DFS(Depth First Search)는 그래프나 트리를 탐색할 때 **한 방향으로 최대한 깊이 들어간 후**, 더 이상 갈 수 없으면 되돌아와 다른 방향을 탐색하는 알고리즘이다.

### 핵심 특징
- 스택(Stack) 또는 재귀(Recursion)으로 구현
- 모든 노드를 방문하는 데 적합
- 경로 탐색, 사이클 감지, 연결 요소 찾기에 활용
- 시간복잡도: **O(V + E)** (V: 정점 수, E: 간선 수)

---

## 2. 기본 구현 (Java)

### 재귀 방식 (가장 일반적)
```java
static boolean[] visited;
static List<Integer>[] graph;

public static void dfs(int node) {
    visited[node] = true;
    System.out.print(node + " ");

    for (int next : graph[node]) {
        if (!visited[next]) {
            dfs(next);
        }
    }
}
```

### 스택 방식 (재귀 깊이 제한 우회)
```java
public static void dfs(int start) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[N + 1];

    stack.push(start);
    visited[start] = true;

    while (!stack.isEmpty()) {
        int node = stack.pop();
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                stack.push(next);
            }
        }
    }
}
```

### 2D 격자(Grid) DFS 패턴
```java
static int[] dx = {0, 0, 1, -1};
static int[] dy = {1, -1, 0, 0};
static boolean[][] visited;
static char[][] map;

public static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if (visited[nx][ny]) continue;
        if (map[nx][ny] == '0') continue; // 조건에 따라 변경

        dfs(nx, ny);
    }
}
```

---

## 3. 문제 유형별 DFS 패턴

### 3-1. 연결 요소 개수 세기
그래프에서 연결된 덩어리(섬, 영역 등)의 개수를 세는 문제

**특징**: 모든 노드를 순회하며 방문 안 한 노드에서 DFS 시작, count++

```java
int count = 0;
for (int i = 1; i <= N; i++) {
    if (!visited[i]) {
        dfs(i);
        count++;
    }
}
```

**대표 문제**: 백준 1260, 2667(단지번호붙이기), 11724(연결 요소의 개수)

---

### 3-2. 경로 탐색 (모든 경로 / 최단 경로)
시작점에서 목적지까지의 경로를 구하는 문제

**특징**: 목적지 도달 시 카운트, 백트래킹 필수

```java
static int answer = 0;

public static void dfs(int current, int target) {
    if (current == target) {
        answer++;
        return;
    }

    visited[current] = true;

    for (int next : graph[current]) {
        if (!visited[next]) {
            dfs(next, target);
        }
    }

    visited[current] = false; // 백트래킹
}
```

**대표 문제**: 프로그래머스 - 타겟 넘버, 네트워크

---

### 3-3. 백트래킹 (조합/순열 탐색)
모든 경우의 수를 탐색하되, 조건에 맞지 않으면 가지치기하는 문제

**특징**: 조건 검사 후 재귀, 재귀 후 상태 복원

```java
public static void dfs(int depth, int start) {
    if (depth == R) {
        // 결과 처리
        return;
    }

    for (int i = start; i <= N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            selected[depth] = i;
            dfs(depth + 1, i + 1); // 조합이면 i+1, 순열이면 0 또는 start
            visited[i] = false;
        }
    }
}
```

**대표 문제**: 백준 15649(N과M), 프로그래머스 - 소수 찾기

---

### 3-4. 사이클 탐지
방향/무방향 그래프에서 사이클 존재 여부 확인

```java
static int[] color; // 0: 미방문, 1: 방문 중, 2: 완료

public static boolean dfs(int node) {
    color[node] = 1;

    for (int next : graph[node]) {
        if (color[next] == 1) return true;  // 사이클 발견
        if (color[next] == 0 && dfs(next)) return true;
    }

    color[node] = 2;
    return false;
}
```

---

### 3-5. 트리 DFS (부모-자식 관계)
트리 구조에서 루트부터 리프까지 탐색

```java
public static void dfs(int node, int parent) {
    for (int next : graph[node]) {
        if (next == parent) continue; // 부모 방향으로 되돌아가지 않음
        dfs(next, node);
    }
}
```

---

## 4. 문제 분석 가이드 - DFS로 풀어야 하는지 판단하기

### DFS를 선택해야 하는 신호
| 키워드 | 예시 |
|--------|------|
| "연결된", "이어진", "인접한" | 연결된 노드의 수, 인접한 섬의 개수 |
| "경로가 존재하는지" | A에서 B로 갈 수 있는지 |
| "모든 경우의 수" | 가능한 모든 경로, 조합 |
| "영역", "섬", "단지" | 2D 격자에서 연결된 영역 |
| "사이클" | 순환이 존재하는지 |
| "깊이", "레벨" | 트리/그래프 깊이 탐색 |

### DFS vs BFS 선택 기준
| | DFS | BFS |
|--|-----|-----|
| **최단 경로** | X | O |
| **경로 존재 여부** | O | O |
| **모든 경우 탐색** | O (백트래킹) | 비효율 |
| **연결 요소** | O | O |
| **메모리** | 스택 크기 | 큐 크기 |
| **구현 난이도** | 재귀로 간단 | 반복문 필요 |

### 단계별 문제 분석 방법

#### Step 1. 자료구조 파악
- 그래프? → 인접 리스트 or 인접 행렬
- 격자(2D 배열)? → dx/dy 방향 배열 활용
- 트리? → 부모-자식 관계 설정

#### Step 2. 탐색 목적 파악
- "가능한지(존재 여부)" → 단순 DFS
- "몇 개인지(카운팅)" → DFS + count
- "최솟값/최댓값" → DFS + 조건 비교
- "모든 경우" → DFS + 백트래킹

#### Step 3. 방문 처리 설계
- 단순 방문 여부: `boolean[] visited`
- 백트래킹 필요: DFS 진입 시 true, 반환 시 false
- 경로 비용 포함: `int[] dist` 또는 `int[][] dist`

#### Step 4. 기저 조건(Base Case) 정의
- 목적지 도달
- 범위 초과 (격자 DFS)
- 이미 방문한 노드

---

## 5. 자주 실수하는 부분

### 실수 1: 백트래킹에서 방문 처리 복원 누락
```java
// 틀린 코드
dfs(next, target);

// 올바른 코드
visited[node] = true;
dfs(next, target);
visited[node] = false; // 반드시 복원!
```

### 실수 2: 격자 DFS에서 범위 체크 순서
```java
// 틀린 코드 (NullPointerException 발생 가능)
if (map[nx][ny] == '1' && nx >= 0 && nx < N) dfs(nx, ny);

// 올바른 코드 (범위 체크를 먼저!)
if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
if (map[nx][ny] == '0') continue;
dfs(nx, ny);
```

### 실수 3: 재귀 깊이 초과 (StackOverflowError)
- 노드 수가 100,000 이상이면 재귀 대신 스택 방식 사용 고려
- Java 기본 스택 크기: ~500~1000 depth

### 실수 4: 방향 그래프에서 양방향 처리
```java
// 양방향 그래프
graph[a].add(b);
graph[b].add(a); // 이 줄 빠트리면 안 됨

// 단방향 그래프
graph[a].add(b); // 한 방향만
```

---

## 6. 코딩 테스트 DFS 체크리스트

```
[ ] visited 배열 초기화 했는가?
[ ] 범위 체크를 가장 먼저 했는가?
[ ] 백트래킹이 필요한 문제에서 상태 복원을 했는가?
[ ] 그래프 입력 방향(단방향/양방향)을 확인했는가?
[ ] 재귀 깊이 초과 가능성이 있는가? (N > 10,000)
[ ] 시작점 방문 처리를 했는가?
[ ] 기저 조건(Base Case)이 빠짐없이 정의되었는가?
```

---

## 7. 난이도별 추천 문제

### 입문
- 백준 1260: DFS와 BFS (기본 구현)
- 백준 2667: 단지번호붙이기 (격자 DFS)

### 초급
- 프로그래머스 타겟 넘버 (백트래킹)
- 프로그래머스 네트워크 (연결 요소)
- 백준 11724: 연결 요소의 개수

### 중급
- 프로그래머스 소수 찾기 (백트래킹 + 조합)
- 백준 2580: 스도쿠 (백트래킹 심화)
- 백준 1987: 알파벳 (격자 + 백트래킹)

### 고급
- 백준 9663: N-Queen (백트래킹 최적화)
- 프로그래머스 여행경로 (경로 탐색)
- 백준 1005: ACM Craft (위상정렬 + DFS)