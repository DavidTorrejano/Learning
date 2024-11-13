package libro.fork_join_framework;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    // This will define the length of the task to then be divided
    public static final long THRESHOLD = 10_000;

    // This public constructor is to create the main task
    public ForkJoinSumCalculator(long[] numbers) {
        this (numbers, 0, numbers.length);

    }

    // This private constructor is to create subtasks of the main task
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // The size of the subarray summed by this task
        int length = end - start;
        // Here we are determining if it will be a concurrent or a sequential task
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);

        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

}
