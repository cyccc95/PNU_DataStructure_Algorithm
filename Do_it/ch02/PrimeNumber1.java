public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0;

        for (int n = 2; n <= 1000; n++){
            int i;
            for (i = 2; i < n; i++){
                counter++;
                if(n % i == 0){
                    break;
                }
            }
            // for문을 벗어날 때 i++이 돼서 n == i 비교 가능
            if (n == i){
                System.out.println(n);
            }
        }
        System.out.println("나눗셈을 실행한 횟수: " + counter);
    }
}
