import java.util.Scanner;

public class Recur {
    static void recur(int x){
        if(x > 0){
            recur(x - 1);
            System.out.println(x);
            recur(x - 2);
        }
    }
    static void recur2(int x){
        if (x > 0){
            recur2(x - 2);
            System.out.println(x);
            recur2(x - 1);
        }
    }
    static void recurX1(int x){
        while (x > 0){
            recurX1(x - 1);
            System.out.println(x);
            x = x - 2;
        }
    }
    static void recurX2(int x){
        IntStack s = new IntStack(x);

        while (true){
            if (x > 0){
                s.push(x);
                x = x - 1;
                continue;
            }
            if (s.isEmpty() != true){
                x = s.pop();
                System.out.println(x);
                x = x - 2;
                continue;
            }
            break;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        System.out.println("--recur--");
        recur(x);
        System.out.println("--recur2--");
        recur2(x);
        System.out.println("--recurX1--");
        recurX1(x);
        System.out.println("--recurX2--");
        recurX2(x);

    }
}
