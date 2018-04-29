package factorial;

public class RecursiveFibonacci {

    public long compute(int n) {

        long factorial;
        if (n <= 2) {
            factorial = 1;
        } else {
            factorial = compute(n - 1) + compute(n - 2);
        }
        return factorial;
    }
}
