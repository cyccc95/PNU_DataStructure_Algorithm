package ch04;

import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public static class EmptyStackException extends RuntimeException {
//		private static final long serialVersionUID = 1L;
		public EmptyStackException() {
//			super();
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public static class OverflowStackException extends RuntimeException {
		public OverflowStackException() {
		}
	}

//private T data[];           // 스택용 배열
	private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public Stack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<T>(capacity);
		} catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public T push(T x) {
		if(top >= capacity) {
			throw new OverflowStackException();
		}
		if(top >= data.size()) {
			data.add(x);
		} else {
			data.set(top, x);
		}
		return data.get(top++);
	}
	
//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public T pop()  {
		if(top <= 0) {
			throw new EmptyStackException();
		}
		T temp = data.get(--top);
		data.remove(top);
		return temp;
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public T peek() {
		if(top <= 0) {
			throw new EmptyStackException();
		}
		return data.get(top - 1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(T x) {
		for(int i = top - 1; i >= 0; i--) {
			if(data.get(i).equals(x)) {
				return i;
			}
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		for(int i = 0; i < top; i++) {
			System.out.print(data.get(i) + " ");
		}
		System.out.println();
	}
}
