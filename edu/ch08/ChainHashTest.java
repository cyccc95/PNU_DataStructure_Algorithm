package ch08;

import java.util.Scanner;

class ChainHash {
	//--- 해시를 구성하는 노드 ---//
	class Node {
		private Student data;     // 키값
		private Node next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

		public Node() {
			this.data  = null;
			this.next = null;
		}

		public Node(Student s) {
			this.data = new Student(s);
			this.next = null;
		}
		
		public Node(Student s, Node p) {
			this.data = s;
			this.next = p;
		}
		
		//--- 키값을 반환 ---//
		public Integer getKey() {
			return this.data.getNo();
		}
		
		//--- 값을 반환 ---//
		public String getValue() {
			return this.data.getName();
		}

		//--- 키의 해시값을 반환 ---//
		public int hashCode() {
			int hash = 11;
			hash = 31* hash * getKey().intValue();
			hash = hash * hash;
			return hash % 13;
		}
	}

	private int size;            // 해시 테이블의 크기
	private Node[] table;        // 해시 테이블

	//--- 생성자(constructor) ---//
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	//--- 해시값을 구함 ---//
	public int hashValue(Integer key) {
		int hash = 11;
		hash = 31 * hash * key.intValue();
		hash = hash * hash;
		return hash % 13;
	}

	//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public String search(Integer key) {
		int hash = hashValue(key);	// 검색할 데이터의 해시값
		Node p = table[hash];       // 선택 노드
		int cnt = 1;
		while (p != null) {
			if (p.getKey() == key)
				return "(" + p.getKey() + ") " + p.getValue() + " : " + hash + "테이블의 " + cnt + "에 있습니다.";	// 검색 성공
			p = p.next;             // 다음 노드를 선택
			cnt++;
		}
		return "그 데이터는 없습니다.";                   // 검색 실패
	}

	//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public void add(Student st) {
		int hash = hashValue(st.getNo());	// 추가할 데이터의 해시값
		Node p = table[hash];            	// 선택 노드
		if (p == null) {
			Node input = new Node(st);
			table[hash] = input;
			return;
		}
		while(p != null) {
			if(p.getKey() == st.getNo()) {
				System.out.println("그 데이터는 이미 존재합니다.");
				return;
			}
			p = p.next;
		}
		Node input = new Node(st,table[hash]);
		table[hash] = input;
	}
	
	//--- 키값이 key인 요소를 삭제 ---//
	public void remove(Integer key) {
		int hash = hashValue(key);       // 삭제할 데이터의 해시값
		Node p = table[hash];            // 선택 노드
		Node pp = null;                  // 바로 앞의 선택 노드
		
		while (p != null) {
			if (p.getKey() == key) {
				break;
			}
			pp = p;
			p = p.next;             
		}
		if (p == null) {
			System.out.println("그 데이터는 없습니다.");
			return;
		} 
		if(pp == null) {
			table[hash] = p.next;
		} else {
			pp.next = p.next;
		}
		System.out.println("(" + key + ") " + p.getValue() + "를 삭제");
		
	}
	

	//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ (%d) %s ",p.getKey(),p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}


public class ChainHashTest {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ChainHash hash = new ChainHash(13);
		int select = 0;
		while (select != 6) {
			System.out.print("SimpleChainHash:: Select 1:Add, 2:Delete, 3:Search, 4:PrintDump, 5:Quit => ");
			select = sc.nextInt();
			switch (select) {
				case 1: // add
					Student input = new Student();
	                System.out.print("번호: ");
	                input.setNo(sc.nextInt());
	                System.out.print("이름: ");
	                input.setName(sc.next());
	                hash.add(input);
	                System.out.println(input.toString());
					break;
				case 2: // Delete
					System.out.print("Key to delete : ");
					hash.remove(sc.nextInt());
					break;
				case 3:
					System.out.print("Key to search : ");
					int val = sc.nextInt();
					System.out.println(hash.search(val));
					break;
				case 4:
					hash.dump();
					break;
				case 5:
					System.out.println("Quit");
					break;
				default:
					System.out.println("WRONG INPUT  ");
					System.out.println("Re-Enter");
					break;
				}
			if (select == 5) {
				break;
			}
		}
	}
}
