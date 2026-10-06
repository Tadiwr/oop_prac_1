public class SavingsAccount extends Account {

    private final double MINIMUM_BALANCE = 100.00;
    private final double INTEREST_RATE = 0.05;

    public SavingsAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount < 0) {
            System.out.println("You cannot withdraw a negative amount");
            return false;
        }

        double nextBalance = this.balance - amount;

        if (nextBalance < MINIMUM_BALANCE) {
            System.out.println("Withdrawal rejected as it takes balance below the minimum account balance");
            return false;
        }

        this.balance = nextBalance;

        return true;
    }

    /** Applies a fixed interest rate to the balance **/
    @Override
    public void endOfMonth() {
        double interestEarned = this.balance * this.INTEREST_RATE;
        this.balance += interestEarned;
    }
}
