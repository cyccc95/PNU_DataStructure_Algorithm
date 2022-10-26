package ch04;

import java.util.Scanner;

public class Backtracking_Queen {
    public static void SolveQueen(int[][] data) {
        Stack2 st = new Stack2(data.length);
        int answer = 0;
        int row, col;
        int count = 0;
        
        while(count < data.length) { 					// 0행의 모든 col에 퀸을 배치해 볼 동안
        	row = 0;									// row는 0에서 시작
        	col = count;								// 0행에 몇개의 퀸을 배치해봤는지 체크할 count
        	while(row < data.length) {					// 모든 row에 퀸을 배치해 볼 동안
        		Point p = new Point(row,col);			// 현재 위치의 p 생성
        		if(check(data,row,col)) {				// 충돌 체크
        			data[row][col] = 1;					// 충돌 안하면 현재 위치 data에 저장
        			st.push(p);							// 현재 위치 스택에 푸시
        			row++; col = 0;						// 다음 행
        		} else {								// 충돌하면
        			col++;								// 다음 col 검사
        		}
        		if(col >= data[0].length) {				// 각 행에서 만족하는 col이 없으면
        			p = st.pop();						// 스택에서 이전 위치 팝
        			row = p.getX(); col = p.getY();		// 이전 위치를 현 위치로 저장
        			data[row][col] = 0;					// 이전 위치 데이터 삭제
        			col++;								// 이전 위치에서 col + 1해서 다음 위치부터 검사
        			if(row == 0) {						// 반복하다가 팝한 데이터가 0행이면 count 올려서 다음 케이스 검사
        				count++;
        				break;
        			}
        		}	
        		if(row == data.length) {				// 모든 row에 배치해서 정답이 나오면
        			print(data); answer++;	
        			for(int i = 0; i < st.size();i++){  // 정답 출력하고 경우의 수 +
        				System.out.print("--");								
        			}
        			System.out.println();
        			p = st.pop();						// 이전 위치 팝
        			row = p.getX(); col = p.getY();		// 현재 위치로 저장
        			data[row][col] = 0;					// 데이터에서 이전 위치 삭제
        			col++;								// col + 1 해서 다음 위치부터 검사
        		}
        	}
        }
        System.out.println("경우의 수 : " + answer);
    }
    public static boolean check(int[][] data, int row, int col){
        int i,j;

        // 같은 col에 이미 퀸이 있는지 체크
        for(i = 0; i < data.length; i++){
        	if(col >= data.length) {
        		return false;
        	}
            if(data[i][col] == 1){
                return false;
            }
        }
        // 왼쪽 대각선으로 퀸이 있는지 체크
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(data[i][j] == 1){
                return false;
            }
        }
        // 오른쪽 대각선으로 퀸이 있는지 체크
        for(i = row, j = col; i >= 0  && j <= data.length - 1; i--, j++){
            if(data[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void print(int[][] data){
        for (int i = 0; i <data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
            	if(data[i][j] == 0) {
            		System.out.print(" X");
            	} else {
            		System.out.print(" Q");
            	}
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n을 입력받아서 nxn 행렬 생성
        System.out.print("n을 입력하세요 : ");
        int n = sc.nextInt();
        int[][] data = new int[n][n];

        SolveQueen(data);

    }
}

