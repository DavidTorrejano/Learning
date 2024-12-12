package concurrency;

import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentBuffer<T> {
    private final Queue<T> buffer;
    private final Semaphore putPermits;
    private final Semaphore takePermits;

    public ConcurrentBuffer(int capacity) {
        this.buffer = new LinkedBlockingQueue<>(capacity);
        this.putPermits = new Semaphore(capacity);
        this.takePermits = new Semaphore(0);
    }

    public void produce(T item) throws InterruptedException {
        putPermits.acquire();
        try {
            buffer.add(item);
            takePermits.release();
        } catch (IllegalStateException e) {
            putPermits.release();
            throw e;
        }
    }

    public T consume() throws InterruptedException {
        takePermits.acquire();
        try {
            T item = buffer.remove();
            putPermits.release();
            return item;
        } catch (Exception e) {
            takePermits.release();
            throw e;
        }
    }
}

// Ejemplo de uso
class ProducerConsumerDemo {
    public static void main(String[] args) {
        ConcurrentBuffer<Integer> buffer = new ConcurrentBuffer<>(10);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    buffer.produce(i);
                    System.out.println("Producido: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    int item = buffer.consume();
                    System.out.println("Consumido: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}