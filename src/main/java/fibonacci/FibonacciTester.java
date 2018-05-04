package fibonacci;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FibonacciTester {

    public static void main(String[] args) {

        /*
         * T(n)=T(n-1)+T(n-2)+O(1)
         * F(n) = F(n-1)+F(n-2)
         * x^2 – x–1 = 0
         * x = (1+\sqrt{5})/2 and x=(1 – \sqrt{5})/2
         * F(n) = ($\alpha_1)^n + ($\alpha_2)^n
         * T(n) = O(1.6180)^n
         * */

        int n = 50;
        recursiveFibonacci(n); // tc : 2^n, sp : O(n)
        memorizedFibonacci(n); // tc : o(n), sp : O(n)
        bottomUpFibonacci(n); // tc : o(n), sp : O(n)
        optimizedBottomUpFibonacci(n); //tc : o(n), sp : O(2)
        matrixFibonacci(n); // tc : o(n), sp : O(1)
        optimizedMatrixFibonacci(n); // tc : o(logn), sp : o(10)


    }

    private static void recursiveFibonacci(int n) {
        System.out.println("###################Recursive Fibonacci###################");
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Recursive Fibonacci start : " + startTime);
        System.out.println(fibonacci.compute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Recursive Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }

    private static void memorizedFibonacci(int n) {
        System.out.println("###################Memorized Fibonacci###################");
        MemorizedFibonacci fibonacci = new MemorizedFibonacci(n);
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Memorized Fibonacci start : " + startTime);
        System.out.println(fibonacci.compute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Memorized Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }

    private static void bottomUpFibonacci(int n) {
        System.out.println("###################Bottom Up Fibonacci###################");
        BottomUpFibonacci fibonacci = new BottomUpFibonacci(n);
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Bottom Up Fibonacci start : " + startTime);
        System.out.println(fibonacci.compute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Bottom Up Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }

    private static void optimizedBottomUpFibonacci(int n) {
        System.out.println("###################Optimized Bottom Up Fibonacci###################");
        BottomUpFibonacci fibonacci = new BottomUpFibonacci(2);
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Optimized Bottom Up Fibonacci start : " + startTime);
        System.out.println(fibonacci.optimizedCompute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Optimized Bottom Up Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }

    private static void matrixFibonacci(int n) {
        System.out.println("###################Matrix Fibonacci###################");
        MatrixFibonacci fibonacci = new MatrixFibonacci();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Matrix Fibonacci start : " + startTime);
        System.out.println(fibonacci.compute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Matrix Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }

    private static void optimizedMatrixFibonacci(int n) {
        System.out.println("###################Optimized Matrix Fibonacci###################");
        MatrixFibonacci fibonacci = new MatrixFibonacci();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Optimized Matrix Fibonacci start : " + startTime);
        System.out.println(fibonacci.optimizedCompute(n));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Optimized Matrix Fibonacci end : " + endTime + " ms : " + startTime.until(endTime, ChronoUnit.MILLIS));
    }
}
