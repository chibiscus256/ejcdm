package homework11;

public class BankAccount {

    private String holder;
    private long balance;
    private final Object balanceLock = new Object();

    BankAccount(String holder) {
        this(holder, 0);
    }

    BankAccount(String holder, long initialBalance) {
        this.holder = holder;
        setBalance(initialBalance);
    }


    public boolean deposit(long depositAmount) {
        return setBalance(balance + depositAmount);
    }


    public boolean withdraw(long withdrawalAmount) {
        return setBalance(balance - withdrawalAmount);
    }

    public long getBalance() {
        return balance;
    }

    public Object getBalanceLock() {
        return balanceLock;
    }

    private boolean setBalance(long balance) {
        if (balance >= 0) {
            this.balance = balance;
            return true;
        }
        return false;
    }
}