package ch06;

import java.util.Comparator;

public class LinkedList<E> {
//연결 리스트 클래스
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터(다음 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리 포인터(머리 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	public LinkedList() {
		this.head = null;
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
	// --- 꼬리 노드 삽입 ---//
	public void add(E obj) {
		Node<E>	ptr = head;
		if(head == null) {
			head = new Node<E>(obj,ptr);
			return;
		}
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = new Node<E>(obj,null);
	}

	// --- 노드p 삭제 ---//
	public void delete(E obj) {//전달 객체를 삭제
		if(head != null) {
			if(obj == head.data) {		// p가 머리 노드면 머리 노드 삭제
				head = head.next;
			} else {
				Node<E> ptr = head;
				while(ptr.next.data != obj) {
					ptr = ptr.next;
					if(ptr == null) return; // p가 리스트에 없음
				}
				ptr = ptr.next;
			}
		}
		
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}