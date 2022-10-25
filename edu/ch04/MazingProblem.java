public class MazingProblem {
	static void solveMaze(int[][] input) {
		// input을 1로 둘러싼 maze와 지나간 길을 체크할 mark 생성
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16)) {
					maze[i][j] = 1;
					mark[i][j] = 1;
				}
				else {
					maze[i][j] = input[i - 1][j - 1];
					mark[i][j] = 0;
				}
				
			}
		}
		
		// 스택 생성
		MazeStack st = new MazeStack(100);

		// move 생성
		int[][] move = {
				{0,-1}, // N
				{1,-1},	// NE
				{1,0}, // E
				{1,1}, // SE
				{0,1}, // S
				{-1,1}, // SW
				{-1,0}, // W
				{-1,-1}, // NW
		};

		// 초기 위치 설정한 뒤 스택에 푸시
		int x , y, dir;
		int nextX, nextY;
		boolean found = false;
		Position p = new Position(1,1,0);
		st.push(p); mark[1][1] = 1; // 첫 위치를 스택에 푸시하고 마크에 저장

		while(!st.isEmpty() && !found) {
			x = st.peek().getX(); y = st.peek().getY(); dir = 0;
			st.pop();
			while(dir < 8 && !found) {
				nextX = x + move[dir][0];
				nextY = y + move[dir][1];
				if(maze[nextY][nextX] == 0 && mark[nextY][nextX] != 1) { // 다음 위치가 0이거나 왔던길이 아니면
					mark[nextY][nextX] = 1;
					x = nextX; y = nextY; dir = 0;
					p = new Position(x,y,dir);
					st.push(p);
				} else {
					dir++;
				}
				if(x == 15 && y == 12){  // 출구에 도착하면
					found = true;
				}
			}
		}
		if(found){
			st.dump();
		} else {
			System.out.println("경로를 찾지 못했습니다.");
		}

	}
	
	public static void main(String[] args) {
		int[][] input = {
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		solveMaze(input);
	}

}
