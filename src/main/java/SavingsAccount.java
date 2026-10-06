public class SavingsAccount extends Account {

    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
        this.minimumBalance = 100;
        this.interestRate = 0.05;
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount < 0) {
            System.out.println("You cannot withdraw a negative amount");
            return false;
        }

        double nextBalance = this.balance - amount;

        if (nextBalance < minimumBalance) {
            System.out.println("Withdrawal rejected as it takes balance below the minimum account balance");
            return false;
        }

        this.balance = nextBalance;

        return true;
    }

    /** Applies a fixed interest rate to the balance **/
    @Override
    public void endOfMonth() {
        double interestEarned = this.balance * this.interestRate;
        this.balance += interestEarned;
    }
}
