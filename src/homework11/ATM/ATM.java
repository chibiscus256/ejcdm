package homework11.ATM;
import homework11.BankAccount;

public interface ATM {

    String getInfo();

    default long getBalance(BankAccount bankAccount) {
        return bankAccount.getBalance();
    }

    default boolean deposit(BankAccount bankAccount, long depositAmount) {
        synchronized (bankAccount.getBalanceLock()) {
            return bankAccount.deposit(depositAmount);
        }
    }

    default boolean withdraw(BankAccount bankAccount, long withdrawalAmount) {
        synchronized (bankAccount.getBalanceLock()) {
            return bankAccount.withdraw(withdrawalAmount);
        }
    }
}