import java.util.List;

public class BankDemo {
    public static void main() {
        System.out.println("-------------- BANK OF JAVA DEMO -------------------");

        List<Account> accounts = List.of(
                new SavingsAccount("Savings-1", 0.0),
                new CurrentAccount("Current-1", 0.0)
        );

        System.out.println("\n--------------- Deposit 115 in each account ------------------");
        // deposit 115 to each account
        accounts.forEach(acc ->{
            acc.deposit(115.0);
            printAccountBalance(acc);
        });

        System.out.println("\n--------------- Withdraw 10 in each account ------------------");
        // withdraw 10 and print balance for each account
        accounts.forEach(acc -> {
            acc.withdraw(10);
            printAccountBalance(acc);
        });

        System.out.println("\n--------------- Withdraw 25 in each account ------------------");
        // withdraw 25, savings account should reject
        accounts.forEach(acc -> {
            acc.withdraw(25.0);
            printAccountBalance(acc);
        });

        System.out.println("\n--------------- Withdraw 100 in each account ------------------");
        // withdraw 100 - Current account should allow overdraft
        accounts.forEach(acc -> {
            acc.withdraw(100.0);
            printAccountBalance(acc);
        });

        System.out.println("\n--------------- Withdraw 120 in each account ------------------");
        // withdraw 120 - Current account reject overdraft
        accounts.forEach(acc -> {
            acc.withdraw(120.0);
            printAccountBalance(acc);
        });

        System.out.println("\n--------------- Run End of Month Method ------------------");
        // run end of month method, for each acc
        accounts.forEach(acc -> {
            acc.endOfMonth();
            printAccountBalance(acc);
        });

        System.out.println("--------------- END ------------------");
    }

    /** Helper function for printing the account number and balance */
    private static void printAccountBalance(Account acc) {
        System.out.println(acc.getAccountNumber() + " : $" + acc.getBalance());
    }
}
