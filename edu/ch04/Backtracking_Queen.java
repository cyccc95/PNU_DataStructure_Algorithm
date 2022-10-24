package ch04;

import java.util.Scanner;

public class Backtracking_Queen {
    public static void SolveQueen(int[][] data) {
        Stack2 st = new Stack2(data.length);
        int answer = 0;
        int row, col;
        int count = 0;
        while(count < data.length){ // 첫번째 row의 모든 col에 다 배치해볼 때까지
            row = 0;
            col = count;
            while (row < data.length && col < data.length){
                if(check(data,row,col)){
                    data[row][col] = 1;
                    Point p = new Point(row,col);
                    st.push(p);
                    row++;
                    col = 0;
                } else {
                    col++;
                }

                if (col == data.length) {
                    clearData(data, row - 1);
                    Point pop = st.pop();
                    row = pop.getX();
                    col = pop.getY() + 1;
                    if(row == 0) {
                        break;
                    }
                    if(col == data.length){
                        clearData(data, row - 1);
                        Point pop2 = st.pop();
                        row = pop2.getX();
                        col = pop2.getY() + 1;
                        if(row == 0) {
                            break;
                        }
                    }
                }
                if (row == data.length) {
                    print(data);
                    for(int i = 0; i < data.length;i++) {
                    	System.out.print("--");
                    }
                    System.out.println();
                    answer++;
                    clearData(data, row - 1);

                    Point pop = st.pop();
                    row = pop.getX();
                    col = pop.getY() + 1;
                    if(col == data.length){
                        clearData(data, row - 1);
                        Point pop2 = st.pop();
                        row = pop2.getX();
                        col = pop2.getY() + 1;
                    }
                }
            }
            st.clear();
            clearData(data,0);
            count++;
        }
        System.out.println(answer);
    }
    public static boolean check(int[][] data, int row, int col){
        int i,j;
        // 같은 col에 이미 퀸이 있는지 체크
        for(i = 0; i < row; i++){
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

    public static void clearData(int[][] data, int row){
        for(int i = row; i < data.length; i++){
            for(int j = 0; j < data.length; j++){
                data[i][j] = 0;
            }
        }
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

