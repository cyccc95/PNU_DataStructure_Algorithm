public class DoubleHeadIntStack {
    private int[] stk;      // 스택의 본체
    private int capacity;   // 스택 용량(A B의 합계)
    private int ptrA;       // 스택포인터A
    private int ptrB;       // 스택포인터B

    public enum AorB {StackA, StackB};

    // 실행 시 예외: 스택이 비어 있음
    public class EmptyDoubleHeadIntStackException extends RuntimeException {
        public EmptyDoubleHeadIntStackException(){}
    }
    // 실행 시 예외: 스택이 가득 참
    public class OverflowDoubleHeadIntStackException extends RuntimeException{
        public OverflowDoubleHeadIntStackException(){}
    }
    // 생성자
    public DoubleHeadIntStack(int maxlen){
        ptrA = 0;
        ptrB = maxlen - 1;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }
    // 스택에 x를 푸시
    public int push(AorB sw, int x) throws OverflowDoubleHeadIntStackException {
        if (ptrA >= ptrB + 1){
            throw new OverflowDoubleHeadIntStackException();
        }
        switch (sw){
            case StackA : stk[ptrA++] = x; break;
            case StackB : stk[ptrB--] = x; break;
        }
        return x;
    }
    // 스택에서 데이터를 팝
    public int pop(AorB sw) throws EmptyDoubleHeadIntStackException {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0){
                    throw new EmptyDoubleHeadIntStackException();
                }
                x = stk[--ptrA];
                break;
            case StackB:
                if (ptrB >= capacity -1) {
                    throw new EmptyDoubleHeadIntStackException();
                }
                x = stk[++ptrB];
                break;
        }
        return x;
    }
    // 스택에서 데이터를 피크
    public int peek(AorB sw) throws EmptyDoubleHeadIntStackException {
        int x = 0;
        switch (sw){
            case StackA:
                if (ptrA <= 0){
                    throw new EmptyDoubleHeadIntStackException();
                }
                x = stk[ptrA - 1];
                break;
            case StackB:
                if (ptrB >= capacity - 1){
                    throw new EmptyDoubleHeadIntStackException();
                }
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }
    // 스택에서 x를 검색하여 인덱스 반환(없으면 -1)
    public int indexOf(AorB sw, int x){
        switch (sw){
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--){
                    if (stk[i] == x){
                        return i;
                    }
                }
                break;
            case StackB:
                for (int i = ptrB + 1; i < capacity; i++){
                    if (stk[i] == x){
                        return i;
                    }
                }
                break;
        }
        return -1;
    }
    // 스택을 비움
    public void clear(AorB sw){
        switch (sw){
            case StackA: ptrA = 0; break;
            case StackB: ptrB = capacity - 1; break;
        }
    }
    // 스택의 용량을 반환(A와 B의 합계)
    public int getCapacity(){ return capacity; }
    // 스택에 쌓여있는 데이터수 반환
    public int size(AorB sw){
        switch (sw){
            case StackA: return ptrA;
            case StackB: return capacity - ptrB - 1;
        }
        return 0;
    }
    // 스택이 비어 있는가?
    public boolean isEmpty(AorB sw){
        switch (sw){
            case StackA: return ptrA <= 0;
            case StackB: return ptrB >= capacity - 1;
        }
        return true;
    }
    // 스택이 가득 찼는가?
    public boolean isFull(){ return ptrA >= ptrB + 1; }
    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력
    public void dump(AorB sw){
        switch (sw){
            case StackA:
                if (ptrA <= 0){
                    System.out.println("스택이 비어 있습니다.");
                } else {
                    for (int i = 0; i < ptrA; i++){
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= capacity - 1){
                    System.out.println("스택이 비어 있습니다.");
                } else {
                    for (int i = capacity - 1; i > ptrB; i--){
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
