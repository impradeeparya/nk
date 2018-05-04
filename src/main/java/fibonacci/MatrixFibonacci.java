package fibonacci;

public class MatrixFibonacci {

    long matrix[][] = {{1, 1}, {1, 0}};

    public long compute(int n) {

        long fibonacci[][] = {{1, 1}, {1, 0}};

        for (int index = 2; index < n; index++) {
            fibonacci = multiply(fibonacci);
        }

        return fibonacci[0][0];
    }

    private long[][] multiply(long[][] fibonacci) {
        long x0 = fibonacci[0][0] * matrix[0][0] + fibonacci[0][1] * matrix[1][0];
        long x1 = fibonacci[0][0] * matrix[0][1] + fibonacci[0][1] * matrix[1][1];
        long y0 = fibonacci[1][0] * matrix[0][0] + fibonacci[1][1] * matrix[1][0];
        long y1 = fibonacci[1][0] * matrix[0][1] + fibonacci[1][1] * matrix[1][1];

        fibonacci[0][0] = x0;
        fibonacci[0][1] = x1;
        fibonacci[1][0] = y0;
        fibonacci[1][1] = y1;

        return fibonacci;
    }

    private long[][] multiply(long[][] fibonacci, long[][] matrix) {
        long x0 = fibonacci[0][0] * matrix[0][0] + fibonacci[0][1] * matrix[1][0];
        long x1 = fibonacci[0][0] * matrix[0][1] + fibonacci[0][1] * matrix[1][1];
        long y0 = fibonacci[1][0] * matrix[0][0] + fibonacci[1][1] * matrix[1][0];
        long y1 = fibonacci[1][0] * matrix[0][1] + fibonacci[1][1] * matrix[1][1];

        fibonacci[0][0] = x0;
        fibonacci[0][1] = x1;
        fibonacci[1][0] = y0;
        fibonacci[1][1] = y1;

        return fibonacci;
    }

    public long optimizedCompute(int n) {
        long fibonacci[][] = {{1, 1}, {1, 0}};
        computeFibonacci(fibonacci, n - 1);

        return fibonacci[0][0];
    }

    private void computeFibonacci(long fibonacci[][], int n) {
        if (n == 0 || n == 1)
            return;
        computeFibonacci(fibonacci, n / 2);
        multiply(fibonacci, fibonacci);

        if (n % 2 != 0)
            multiply(fibonacci);
    }
}
