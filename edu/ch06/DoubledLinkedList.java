package ch06;

import java.util.Comparator;

import ch06.LinkedList.Node;

public class DoubledLinkedList<E> {
	//원형 이중 연결 리스트 클래스 - first node를 가짐

	// --- 노드 ---//
	class Node<E> {
		private E data; // 데이터
		private Node<E> prev; // 앞쪽포인터(앞쪽 노드에 대한 참조)
		private Node<E> next; // 뒤쪽포인터(뒤쪽 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node() {
			this.data = null;
			this.prev = this;
			this.next = this;
		}
		Node(E obj){
			this.data = obj;
			this.prev = null;
			this.next = null;
		}
	}

	private Node<E> head; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList() {
		head = new Node<E>(); 
	}

	// --- 리스트가 비어있는가? --- //
	public boolean isEmpty() {
		return head.next == head;
	}
	
	// --- 노드를 검색 ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next; // 현재 스캔 중인 노드
		// 실제 head 노드는 더미 노드이므로 다음부터 검색
		while (ptr != head) {
			if (c.compare(obj, ptr.data) == 0) {
				return ptr.data; // 검색 성공
			}
			ptr = ptr.next; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<E> ptr = head.next; // 더미 노드의 뒤쪽 노드

		while (ptr != head) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(E obj, Comparator<? super E> no, Comparator<? super E> name) {
		Node<E> ptr = head.next;
		Node<E> input = new Node<E>(obj);
		
		// head 더미 말고 없으면
		if(isEmpty()) {
			head.next = input;
			head.prev = input;
			input.next = head;
			input.prev = head;
			return;
		}
		// input을 haed.next(첫 번째 요소)랑 비교
		if(no.compare(input.data, head.next.data) < 0) {
			Node<E> temp = head.next;
			head.next = input;
			input.next = temp;
			input.prev = head;
			temp.prev = input;
			return;
		} else if (no.compare(input.data, head.next.data) == 0 &&
				name.compare(input.data, head.next.data) < 0) {
			Node<E> temp = head.next;
			head.next = input;
			input.next = temp;
			input.prev = head;
			temp.prev = input;
			return;
		}
		
		// head.next 요소 다음부터 비교
		while(ptr.next != head) {
			if(no.compare(input.data, ptr.next.data) < 0) {
				Node<E> temp = ptr.next;
				ptr.next = input;
				input.next = temp;
				input.prev = ptr;
				temp.prev = input;
				return;
			} else if (no.compare(input.data, ptr.next.data) == 0 &&
					name.compare(input.data, ptr.next.data) < 0) {
				Node<E> temp = ptr.next;
				ptr.next = input;
				input.next = temp;
				input.prev = ptr;
				temp.prev = input;
				return;
			}
			ptr = ptr.next;
		}
		ptr.next = input;
		input.prev = ptr;
		input.next = head;
		head.prev = input;
	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(E obj, Comparator<? super E> no, Comparator<? super E> name) {
		Node<E> ptr = head.next;
		if(no.compare(ptr.data, obj) == 0 &&
				name.compare(ptr.data, obj) == 0) {
			head.next = ptr.next;
			ptr.next.prev = head;
			return;
		}
		while(ptr.next != head) {
			if(no.compare(ptr.next.data, obj) == 0 &&
					name.compare(ptr.next.data, obj) == 0) {
				ptr.next = ptr.next.next;
				ptr.next.next.prev = ptr;
				return;
			}
			ptr = ptr.next;
		}
		System.out.println("그 데이터는 없습니다.");
	}
}
