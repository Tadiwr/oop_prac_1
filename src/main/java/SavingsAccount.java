public class SavingsAccount extends Account {

    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
        this.minimumBalance = 100;
        this.interestRate = 0.05;
    }

    @Override
    public void withdraw(double amount) {

        if (amount < 0) {
            System.out.println(this.accountNumber + ": You cannot withdraw a negative amount");
            return;
        }

        double nextBalance = this.balance - amount;

        if (nextBalance < minimumBalance) {
            System.out.println(this.accountNumber + ": Withdrawal rejected as it takes balance below the minimum of " + this.minimumBalance);
            return;
        }

        this.balance = nextBalance;

    }

    /** Applies a fixed interest rate to the balance **/
    @Override
    public void endOfMonth() {
        double interestEarned = this.balance * this.interestRate;
        this.balance += interestEarned;
    }
}
