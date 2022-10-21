package ch04;

import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> s = new Stack<>(64);
		
		while(true) {
			System.out.printf("현재 데이터 개수 : %d / %d\n",s.size(),s.getCapacity());
			System.out.print("(1) push (2) pop (3) peek (4) dump (5) search (6) clear (7) print (0) stop : ");
			int menu = sc.nextInt();
			if(menu == 0) break;
			
			String x;
			
			switch (menu) {
			case 1: // push
				System.out.print("푸시할 데이터 : ");
				x = sc.next();
				try {
					s.push(x);
				} catch(Stack.OverflowStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2: // pop
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch(Stack.EmptyStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 3: // peek
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch(Stack.EmptyStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 4: // dump
				s.dump();
				break;
			case 5: // search
				System.out.print("검색할 데이터 : ");
				x = sc.next();
				int n = s.indexOf(x);
				if(n >= 0) {
					System.out.println("그 데이터는 " + n + "번째에 있습니다.");
				} else {
					System.out.println("그 데이터가 없습니다.");
				}
				break;
			case 6: // clear
				s.clear();
				break;
			case 7: // print
				System.out.println("용량 : " + s.getCapacity());
				System.out.println("데이터 수 : " + s.size());
				System.out.println("비어 " + (s.isEmpty() ? "있습니다." : "있지 않습니다."));
				System.out.println("가득 차 " + (s.isFull() ? "있습니다." : "있지 않습니다."));
				break;
			}
		}
	}

}
