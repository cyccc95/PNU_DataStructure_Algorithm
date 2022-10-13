import java.lang.reflect.Array;
import java.util.Arrays;

public class Q5 {
    static void rcopy(int[] a, int[] b){
        for (int i = 0; i < b.length; i++){
            a[i] = b[b.length -1 -i];
        }
    }

    public static void main(String[] args) {
        int[] b = {1,2,3,4,5};
        int[] a = new int[b.length];
        rcopy(a,b);
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
    }
}
