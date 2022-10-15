public class Gstack<E>{
    private E[] stk; // 스택용 배열
    private int capacity; // 스택 용량
    private int ptr; // 스택 포인터

    // 실행 시 예외: 스택이 비어 있음
    public static class EmptyGstackException extends RuntimeException {
        public EmptyGstackException(){}
    }
    // 실행 시 예외: 스택이 가득 참
    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException(){}
    }
    // 생성자
    public Gstack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        try {
            stk = (E[])new Object[capacity]; // 스택 본체용 배열 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }
    // 스택에 x를 푸시
    public E push(E x) throws OverflowGstackException {
        if (ptr >= capacity)    // 스택이 가득 참
            throw new OverflowGstackException();
        return stk[ptr++] = x;
    }
    // 스택에서 데이터를 팝
    public E pop() throws EmptyGstackException {
        if (ptr <= 0)
            throw new EmptyGstackException();
        return stk[--ptr];
    }
    // 스택에서 데이터를 피크
    public E peek() throws EmptyGstackException {
        if (ptr <= 0)
            throw new EmptyGstackException();
        return stk[ptr - 1];
    }
    // 스택을 비움
    public void clear(){ ptr = 0; }
    // 스택에서 x를 검색하여 인덱스 반환(없으면 -1)
    public int indexOf(E x){
        for (int i = ptr - 1; i >= 0; i--){
            if (stk[i].equals(x))
                return i;
        }
        return -1;
    }
    // 스택 용량을 반환
    public int getCapacity(){ return capacity; }
    // 스택에 쌓여있는 데이터수 반환
    public int size() { return ptr; }
    // 스택이 비어 있는가?
    public boolean isEmpty(){ return ptr <= 0; }
    // 스택이 가득 찼는가?
    public boolean isFull(){ return ptr >= capacity; }
    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(){
        if(ptr <= 0){
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0; i < ptr; i++){
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
