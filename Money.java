/**
 * This class is the money class which is responsible for generating change and breaking down denominations
 * @author Samantha O'Neil
 */
public class Money {

    /**
     * This is the constructor for the money object. You cannot make an object if you don't specify the amount of each denomination
     *
     * @param denom1   the 1 peso coins
     * @param denom5   the 5 peso coins
     * @param denom10  the 10 peso coins
     * @param denom20  the 20 peso bills
     * @param denom50  the 50 peso bills
     * @param denom100 the 100 peso bills
     */
    public Money(int denom1, int denom5, int denom10, int denom20, int denom50, int denom100) {
        this.denom1 = denom1;
        this.denom5 = denom5;
        this.denom10 = denom10;
        this.denom20 = denom20;
        this.denom50 = denom50;
        this.denom100 = denom100;
    }

    /**
     * This method will return the amount of 1 peso coins
     *
     * @return amount of 1 peso coins
     */
    public int getDenom1() {
        return this.denom1;
    }

    /**
     * This method will return the amount of 5 peso coins
     *
     * @return amount of 5 peso coins
     */
    public int getDenom5() {
        return this.denom5;
    }

    /**
     * This method will return the amount of 10 peso coins
     *
     * @return amount of 10 peso coins
     */
    public int getDenom10() {
        return this.denom10;
    }

    /**
     * This method will return the amount of 20 peso bills
     *
     * @return amount of 20 peso bills
     */
    public int getDenom20() {
        return this.denom20;
    }

    /**
     * This method will return the amount of 50 peso bills
     *
     * @return amount of 50 peso bills
     */
    public int getDenom50() {
        return this.denom50;
    }

    /**
     * This method will return the amount of 100 peso bills
     *
     * @return amount of 100 peso bills
     */
    public int getDenom100() {
        return this.denom100;
    }

    /**
     * This method will add o specific amount of 1 peso coins
     *
     * @param amt how many coins to add
     */
    public void addDenom1(int amt) {
        this.denom1 += amt;
    }

    /**
     * This method will add o specific amount of  5 peso coins
     *
     * @param amt how many coins to add
     */
    public void addDenom5(int amt) {
        this.denom5 += amt;
    }

    /**
     * This method will add o specific amount of 10 peso coins
     *
     * @param amt how many coins to add
     */
    public void addDenom10(int amt) {
        this.denom10 += amt;
    }

    /**
     * This method will add o specific amount of 20 peso bills
     *
     * @param amt how many bills to add
     */
    public void addDenom20(int amt) {
        this.denom20 += amt;
    }

    /**
     * This method will add o specific amount of 50 peso bills
     *
     * @param amt how many bills to add
     */
    public void addDenom50(int amt) {
        this.denom50 += amt;
    }

    /**
     * This method will add o specific amount of 100 peso bills
     *
     * @param amt how many bills to add
     */
    public void addDenom100(int amt) {
        this.denom100 += amt;
    }

    /**
     * This method takes the total amount of money in the vending machine and returns it
     * @return
     */
    public double getTotalAmt() { return (this.denom1 + (denom5 * 5) + (denom10 * 10) + (denom20 * 20) + (denom50 * 50) + (denom100 * 100)); }

    /**
     * This method is very important to the entire process. It will break down the change required by which denominations are either most efficient or based on what is available
     *
     * @param userMoney the remaining amount of the user's money to be given in change
     * @return returns the amount in change if it was able to successfully break down the change, or it will return -1 if it was unsuccessful
     */
    public double generateChange(double userMoney) {
        double totalChange = 0.0;
        int used100 = 0, used50 = 0, used20 = 0, used10 = 0, used5 = 0, used1 = 0;

        if (userMoney > 0) {
            // Calculate the number of each denomination starting from the largest
            if (this.denom100 > 0) {
                used100 = (int) (userMoney / 100);
                userMoney %= 100;
            }

            if (this.denom50 > 0) {
                used50 = (int) (userMoney / 50);
                userMoney %= 50;
            }

            if (this.denom20 > 0) {
                used20 = (int) (userMoney / 20);
                userMoney %= 20;
            }

            if (this.denom10 > 0) {
                used10 = (int) (userMoney / 10);
                userMoney %= 10;
            }

            if (this.denom5 > 0) {
                used5 = (int) (userMoney / 5);
                userMoney %= 5;
            }

            if (this.denom1 > 0) {
                used1 = (int) userMoney;
            }

            // Check if the machine has enough denominations to provide change
            if (used100 > this.denom100 || used50 > this.denom50 || used20 > this.denom20 ||
                    used10 > this.denom10 || used5 > this.denom5 || used1 > this.denom1) {
                return -1; // Machine cannot provide change
            }

            // Update the machine's denominations
            this.denom100 -= used100;
            this.denom50 -= used50;
            this.denom20 -= used20;
            this.denom10 -= used10;
            this.denom5 -= used5;
            this.denom1 -= used1;

            // Calculate the total change provided
            totalChange = used100 * 100 + used50 * 50 + used20 * 20 + used10 * 10 + used5 * 5 + used1;
        }
        return totalChange;
    }

    /**
     *
     */
    public boolean collectIncome() {
        this.denom1 = 0;
        this.denom5 = 0;
        this.denom10 = 0;
        this.denom20 = 0;
        this.denom50 = 0;
        this.denom100 = 0;

        System.out.println("Income Collected"); // for debugging purposes only

        return true;
    }

    public void collectChange() {
        this.denom1 = 0;
        this.denom5 = 0;
        this.denom10 = 0;
        this.denom20 = 0;
        this.denom50 = 0;
        this.denom100 = 0;

        System.out.println("Change Collected by User"); // for debugging purposes only

    }

    // Attributes
    private int denom1;
    private int denom5;
    private int denom10;
    private int denom20;
    private int denom50;
    private int denom100;

}
