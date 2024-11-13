package libro.fork_join_framework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculatorMain {
    public static void main(String[] args) {

        long start = System.nanoTime();
        long result = forkJoinSum(9_000_000L);
        long end = System.nanoTime();
        System.out.println("Execution time: " + ((end - start)/1_000_000) + " ms");
        System.out.println("Result: " + result);
    }

    public static long forkJoinSum(long n) {
        long [] numbers = LongStream.rangeClosed(0, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        try(ForkJoinPool pool = new ForkJoinPool()) {
            return pool.invoke(task);
        }
    }
}
