public class Q15 {
    static void spira(int n){
        for (int i = 1; i <= n; i++){
            for (int j = i; j <= (2*n-1)/2; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print("*");
            }
            for (int j = i; j <= (2*n-1)/2; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void npira(int n){
        for (int i = 1; i <= n; i++){
            for (int j = i; j <= (2*n-1)/2; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print(i);
            }
            for (int j = i; j <= (2*n-1)/2; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        spira(5);
        spira(7);
        npira(4);
        npira(7);
    }
}
