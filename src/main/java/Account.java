/** Abstract base class for a bank account */
public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Method to deposit money into account, that rejects negative deposits
     */
    public void deposit(double amount) {

        if (amount < 0) {
            System.out.println(this.accountNumber + ": You cannot deposit a negative amount");
            return;
        }

        this.balance += amount;

    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Method that withdraws an amount from the bank account rejects negative amounts.e
     */
    public abstract void withdraw(double amount);

    /** Method called at the end of an account month to perform operations on the
     * account like charging small fixed fees or applying interest */
    public abstract void endOfMonth();
}
