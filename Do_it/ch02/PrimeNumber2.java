public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;    // 찾은 소수의 개수
        int[] prime = new int[500];

        prime[ptr++] = 2;
        // 2외의 짝수는 제외하고 n보다 작은 소수로 나누어 떨어지지 않으면 n은 소수
        for (int n = 3; n <= 1000; n += 2){
            int i;
            for (i = 1; i < ptr; i++){
                counter++;
                if(n % prime[i] == 0) break;
            }
            if(ptr == i){
                prime[ptr++] = n;
            }
        }
        for (int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }
        System.out.println("나눗셈을 수행한 횟수: " + counter);
    }
}

// 빠른 알고리즘은 메모리를 많이 필요로 하는 경향이 있다.