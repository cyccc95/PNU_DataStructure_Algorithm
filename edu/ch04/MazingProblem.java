package ch04;

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
		MazeStack st = new MazeStack(12 * 15);
		
		// 초기 위치 설정한 뒤 스택에 푸시
		Position p = new Position(1,1,0);
		int x = p.getX();
		int y = p.getY();
		int dir = p.getDir();
		st.push(p); mark[x][y] = 1; // 첫 위치를 스택에 푸시하고 마크에 저장
		
		while(x != 12 || y != 15) {
			while(dir < 8) {
				int nextX = move(p).getX();
				int nextY = move(p).getY();
				if(maze[nextY][nextX] == 0 && mark[nextY][nextX] != 1){ // 다음 위치가 0이고 마크 아니면
					st.push(p); // 새로운 위치를 스택에 푸시
					p.setX(nextX); p.setY(nextY); p.setDir(0);
					mark[x][y] = 1; // 마크에 저장
				} else { // 다음 위치가 1이거나 왔던길(mark가 1이면)
					dir++;
					p.setDir(dir);
				}
				if(dir == 8) { // 벽이나 왔던길이라서 모두 막히면
					st.pop(); // 막혀있는 현재 위치를 팝(삭제)
					x = st.peek().getX();
					y = st.peek().getY(); // 이전 위치로 돌아감
					dir = 0;
					p.setX(nextX);
					p.setY(nextY);
					p.setDir(dir);
				}
			}
			if(x == 12 && y == 15) {
				st.dump();
				break;
			}
		}
		
		
	}
	
	static Position move(Position p) {
		int x = p.getX();
		int y = p.getY();
		int dir = p.getDir();
		Position newP = new Position(x,y,dir);
		
		switch(dir) {
			case 0: // N
				newP.setY(y - 1);
				break;
			case 1: // NE
				newP.setX(x + 1);
				newP.setY(y - 1);
				break;
			case 2:	// E
				newP.setX(x + 1);
				break;
			case 3: // SE
				newP.setX(x + 1);
				newP.setY(y + 1);
				break;
			case 4: // S
				newP.setY(y + 1);
				break;
			case 5: // SW
				newP.setX(x - 1);
				newP.setY(y + 1);
				break;
			case 6: // W
				newP.setX(x - 1);
				break;
			case 7: // NW
				newP.setX(x - 1);
				newP.setY(y - 1);
				break;
		}
		return newP;
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
