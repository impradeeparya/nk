package factorial;

public class MemorizedFibonacci {

    private long[] cache;

    MemorizedFibonacci(int n) {
        this.cache = new long[n + 1];
    }

    public long compute(int n) {

        long factorial;

        if (this.cache[n] > 0) {
            factorial = cache[n];
        } else {
            if (n <= 2) {
                factorial = 1;
            } else {
                factorial = compute(n - 1) + compute(n - 2);
            }
            this.cache[n] = factorial;
        }
        return factorial;
    }
}
