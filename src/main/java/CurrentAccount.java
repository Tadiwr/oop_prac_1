public class CurrentAccount extends Account{

    private final double overdraftLimit;
    private final double maintenanceFee;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.overdraftLimit = -100;
        this.maintenanceFee = 5;
    }

    @Override
    public boolean withdraw(double amount) {
        double nextBalance = this.balance - amount;

        if (amount < 0) {
            System.out.println("You cannot withdraw a negative amount");
            return false;
        }

        if (nextBalance < overdraftLimit) {
            System.out.println("Withdrawal rejected, overdraft limit reached");
            return false;
        }

        this.balance = nextBalance;
        return true;
    }

    /** Method that charges a fixed maintenance fee on account balance */
    @Override
    public void endOfMonth() {
        this.balance -= this.maintenanceFee;
    }
}

