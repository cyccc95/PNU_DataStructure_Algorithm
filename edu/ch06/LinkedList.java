package ch06;

import java.util.Comparator;

public class LinkedList<E> {
//연결 리스트 클래스
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터(다음 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<E> head; // 머리 포인터(머리 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	public LinkedList() {
		head = null;
	}

	// --- 노드 검색 ---//
	public E search(E obj, Comparator<? super E> c) {//<? super E>는 wild card로서 E의 subclass에 대하여 모두 적용
		Node<E> ptr = head; // 현재 스캔 중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) { // 검색 성공
				return ptr.data;
			}
			ptr = ptr.next; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}
	
	// --- 노드 삽입 ---//
	public void add(E obj, Comparator<? super E> no, Comparator<? super E> name) {		
		Node<E> ptr = head;
		Node<E> input = new Node<E>(obj);
		// head가 비었으면 head에 add
		if(head == null) {
			head = new Node<E>(obj);
			return;
		}
		// input을 head랑 비교
		if(no.compare(input.data, head.data) < 0) {
			head = input;
			input.next = ptr;
			return;
		} else if (no.compare(input.data, head.data) == 0 &&
				name.compare(input.data, head.data) < 0) {
			Node<E> temp = head;
			head = input;
			input.next = temp;
			return;
		}
		
		// head 이후 요소랑 비교
		while(ptr.next != null) {
			if(no.compare(input.data, ptr.next.data) < 0) {
				Node<E> temp = ptr.next;
				ptr.next = input;
				input.next = temp;
				return;
			} else if (no.compare(input.data, ptr.next.data) == 0 &&
					name.compare(input.data, ptr.next.data) < 0) {
				Node<E> temp = ptr.next;
				ptr.next = input;
				input.next = temp;
				return;
			}
			ptr = ptr.next;
		}
		ptr.next = input;
		
		
	}

	// --- 노드 삭제 ---//
	public void delete(E obj, Comparator<? super E> no, Comparator<? super E> name) {		//전달 객체를 삭제
		Node<E> ptr = head;
		if(no.compare(ptr.data, obj) == 0 &&
				name.compare(ptr.data, obj) == 0) {
			head = head.next;
			return;
		}
		while(ptr.next != null) {
			if(no.compare(ptr.next.data, obj) == 0 &&
					name.compare(ptr.next.data, obj) == 0) {
				ptr.next = ptr.next.next;
				return;
			}
			ptr = ptr.next;
		}
		System.out.println("그 데이터는 없습니다.");
		
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}