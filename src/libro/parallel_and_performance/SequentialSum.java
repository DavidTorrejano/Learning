package libro.parallel_and_performance;


import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SequentialSum {

    public static void main(String[] args) {

        Long start = System.nanoTime();
        Long result = rangedParallelSum(99999999L);
        Long end = System.nanoTime();
        System.out.println("Duration: " + (end - start)/1000000 + " ms");
        System.out.println(result);



    }

    // This is getting a sum from an infinite stream limited by the n argument and then reduced, it is all sequential
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    // In order to make it "parallel" all we need to do in this case is use the method .parallel()
    // Nonetheless, it won't work as expected, the whole list of numbers isn't available at the beginning of the
    // reduction process, making it impossible to efficiently partition the stream in chunks to be processed in parallel.
    public static Long parallelSum(Long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    // Using more specialized methods:
    // LongStream.rangeClosed() works on primitive long numbers directly, hence, no boxing or unboxing overhead
    public static long rangedSum(long N) {
        return LongStream.rangeClosed(1, N)
                .reduce(0L, Long::sum);
    }

    // Now using .parallel()
    public static long rangedParallelSum(long N) {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0L, Long::sum);

    }


}
