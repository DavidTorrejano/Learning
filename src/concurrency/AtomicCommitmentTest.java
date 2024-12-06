package concurrency;

public class AtomicCommitmentTest {
    public static void main(String[] args) {
        AtomicCommitment acc = new AtomicCommitment(500);
        System.out.println("First account " + acc.getBalance());
        AtomicCommitment acc2 = new AtomicCommitment(300);
        System.out.println("Second account " + acc2.getBalance());

        acc.transfer(acc2, 200);

        System.out.println("First account new balance " + acc.getBalance());
        System.out.println("Second account new balance " + acc2.getBalance());

    }
}



class AtomicCommitment {
    private long balance;

    public AtomicCommitment(long initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public synchronized void setBalance(long newBalance) {
        this.balance = newBalance;
    }

    public void transfer(AtomicCommitment to, long amount) {
        boolean success = false;
        while (!success) {
            long fromBalance = getBalance();
            long toBalance = to.getBalance();

            if (fromBalance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }

            long newFromBalance = fromBalance - amount;
            long newToBalance = toBalance + amount;

            // here we are making sure the values used when getting the information from the two accounts is the same
            // as it was so we can update both accounts, if that operation fails, it will be retried, this is useful
            // when the used objects are frequently read but not written, otherwise, we might see a livelock, which can
            // utilize many resources and finally do nothing.
            synchronized (this) {
                synchronized (to) {
                    if (getBalance() == fromBalance && to.getBalance() == toBalance) {
                        setBalance(newFromBalance);
                        to.setBalance(newToBalance);
                        success = true;
                    }
                }
            }
        }
    }
}