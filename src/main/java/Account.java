/** Abstract base class for a bank account */
public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /** Method to deposit money into account, that rejects negative deposits
     * returns true if deposit was successful else returns false */
    public boolean deposit(double amount) {

        if (amount < 0) {
            System.out.println("You cannot deposit a negative amount");
            return false;
        }

        this.balance += amount;
        return true;

    }

    public double getBalance() {
        return this.balance;
    }

    /** Method that withdraws an amount from the bank account rejects negative amounts.
     *  Returns true if the withdrawal was successful else returns false*/
    public abstract boolean withdraw(double amount);

    /** Method called at the end of an account month to perform operations on the
     * account like charging small fixed fees or applying interest */
    public abstract void endOfMonth();

}
