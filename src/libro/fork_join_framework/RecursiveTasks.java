package libro.fork_join_framework;

public class RecursiveTasks {
    // This is a representation of what the method of a recursive task looks like:

    /*
    if (task is small enough or no longer divisible) {
        compute task sequentially
    } else {
        split task in two subtasks
        call this method recursively possibly further splitting each subtask
        wait for the completion of all subtasks
        combine the results of each subtask
    }
     */

    // Executing a parallel sum using the fork/join framework
    // We'll do it in the class  ForkJoinSumCalculator
}
