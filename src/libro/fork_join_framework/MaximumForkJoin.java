package libro.fork_join_framework;

import java.util.Arrays;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class MaximumForkJoin {
    public static void main(String[] args) {

        long maxConcurrency;
        long [] arr = LongStream.rangeClosed(0, 90_000_000).map(n -> (long)(Math.random()*n)).toArray();

        long start = System.nanoTime();
        OptionalLong max = Arrays.stream(arr).max();
        long end = System.nanoTime();

        long startCon = System.nanoTime();
        ForkJoinTask<Long> task = new MaximumFinder(arr);
        try(ForkJoinPool pool = new ForkJoinPool()) {
            maxConcurrency = pool.invoke(task);
        }
        long endCon = System.nanoTime();

        MaximumFinder maximumSearch = new MaximumFinder(arr);
        long maximum = maximumSearch.compute();
        System.out.println("El máxi max: " + maximum);

        System.out.println("Concurrency execution time: " + ((endCon - startCon)/1_000_000) + " ms");
        System.out.println("Result by MaximumFinder: " + maxConcurrency);

        System.out.println("Sequential execution time: " + ((end - start)/1_000_000) + " ms");
        System.out.println("Result by max(): " + max.getAsLong());

    }
}

class MaximumFinder extends RecursiveTask<Long> {

    private final long [] array;
    private final int start;
    private final int end;
    private final static int THRESHOLD = 10_000;

    public MaximumFinder(long[] array) {
        this (array, 0, array.length);
    }

    private MaximumFinder(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;

        if (length <= THRESHOLD) {
            return sequentialMaximumFinder();
        }

        MaximumFinder leftTask = new MaximumFinder(array, start, start + length/2);
        MaximumFinder rightTask = new MaximumFinder(array, start + length/2, end);

        // We are
        leftTask.fork();
        // Here we are using the current thread to process the array
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();

        return rightResult > leftResult ? rightResult : leftResult;
    }

    public Long sequentialMaximumFinder() {
        long maxNumber = 0;
        for (int i = start; i < end; i++) {
            if (array[i] > maxNumber) {
                maxNumber = Math.max(maxNumber, array[i]);
            }
        }
        return maxNumber;
    }
}