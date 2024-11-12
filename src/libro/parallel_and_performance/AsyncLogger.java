package libro.parallel_and_performance;

/*
Core Concurrency Concepts:


Threads and Processes
Thread lifecycle (new, runnable, blocked, waiting, terminated)
Race conditions
Thread safety
Deadlocks and livelocks


Java Threading Basics:

// Basic thread creation
Thread thread = new Thread(() -> {
    // Work here
});

// Thread states
thread.start();
thread.join();
thread.interrupt();

Java Concurrency Utilities (java.util.concurrent):


ExecutorService (used in our example)

// Instead of creating threads manually
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> { task });


Thread Pools

Fixed Thread Pool
Cached Thread Pool
Scheduled Thread Pool
Single Thread Executor




Synchronization Mechanisms:

// Basic synchronization
synchronized (object) {
        // Critical section
        }

// Volatile keyword (used in our example)
volatile boolean flag;

// Locks
Lock lock = new ReentrantLock();
lock.lock();
try {
        // Critical section
        } finally {
        lock.unlock();
}

Concurrent Collections:


ConcurrentLinkedQueue (what we used)
ConcurrentHashMap
BlockingQueue implementations
CopyOnWriteArrayList


Advanced Concepts:


CompletableFuture for async programming
Fork/Join framework
Atomic variables
Semaphores and CountDownLatch

Here's a suggested learning path:

Start Here:

Basic Java programming
Object-oriented programming concepts
Basic threading concepts


Intermediate:

Thread lifecycle and states
Synchronization
Thread safety
Common concurrency patterns


Advanced:

java.util.concurrent package
Non-blocking algorithms
Memory model
Performance considerations



Resources I recommend:

Books:

"Java Concurrency in Practice" by Brian Goetz
"Core Java Volume I & II" by Cay Horstmann


Online Courses:

Oracle's Java Tutorials (Concurrency section)
Coursera/Udemy courses on Java concurrency


Practice Projects:

Build a thread pool from scratch
Implement producer-consumer pattern
Create a concurrent cache
Build a task scheduler
 */
