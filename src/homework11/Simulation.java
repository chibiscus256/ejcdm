package homework11;

import homework11.ATM.ATM;
import homework11.ATM.ATMs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static private BankAccount bankAccount = new BankAccount("Noah", 20000);
    static private boolean running = true;
    static private ATM sberATM = ATMFactory.createATM(ATMs.Sber);
    static private ATM vtbATM = ATMFactory.createATM(ATMs.Vtb);
    static private ATM uniATM = ATMFactory.createATM(ATMs.Uni);
    static private ATM secondSberATM = ATMFactory.createATM(ATMs.Sber);

    public static void main(String[] args) {
        while (running) {
            displayCurrentInfo();
            handleInput();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayCurrentInfo() {
        System.out.println("Current balance: " + bankAccount.getBalance());
        System.out.println("Enter an integer {positive for deposit} or {negative for withdrawal}.\nOr anything other " +
                "than that to exit");

    }

    private static void handleInput() {
        try {
            String input = reader.readLine();
            long amount = Long.parseLong(input);
            simulateParallelTransactions(amount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            running = false;
        }
    }

    private static void simulateParallelTransactions(long amount) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            threads.add(makeDepositThread(sberATM, 1));
            threads.add(makeDepositThread(vtbATM, 1));
            threads.add(makeDepositThread(uniATM, 1));
            threads.add(makeWithdrawalThread(sberATM, 1));
            threads.add(makeWithdrawalThread(vtbATM, 1));
            threads.add(makeWithdrawalThread(uniATM, 1));
        }

        if (amount >= 0) {
            threads.add(makeDepositThread(secondSberATM, amount));
        } else {
            threads.add(makeWithdrawalThread(secondSberATM, -amount));
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Thread makeDepositThread(ATM atm, long amount) {
        return new Thread(() -> {
            boolean success = atm.deposit(bankAccount, amount);
            if (!success) {
                System.err.println("Failed deposit of {" + amount + "}  in {" + Thread.currentThread().getName() +
                        "}. Operation cancelled.");
            }
        });
    }

    private static Thread makeWithdrawalThread(ATM atm, long amount) {
        return new Thread(() -> {
            boolean success = atm.withdraw(bankAccount, amount);
            if (!success) {
                System.err.println("Failed withdrawal of {" + amount + "} in {" + Thread.currentThread().getName() +
                        "}. Operation cancelled.");
            }
        });
    }
}