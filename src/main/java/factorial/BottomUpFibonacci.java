package factorial;

public class BottomUpFibonacci {

    private long[] cache;

    BottomUpFibonacci(int n) {
        this.cache = new long[n + 1];
    }

    public long compute(int n) {

        long factorial;

        for (int number = 1; number <= n; number++) {
            if (number <= 2) {
                factorial = 1;
            } else {
                factorial = this.cache[number - 1] + this.cache[number - 2];
            }
            this.cache[number] = factorial;
        }
        return this.cache[n];
    }

    public long optimizedCompute(int n) {

        long factorial;

        for (int number = 2; number <= n; number++) {
            if (number == 2) {
                this.cache[0] = this.cache[1] = 1;
            } else {
                factorial = this.cache[0] + this.cache[1];
                this.cache[0] = this.cache[1];
                this.cache[1] = factorial;
            }
        }
        return this.cache[1];
    }
}
