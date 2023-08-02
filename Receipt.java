import java.util.ArrayList;

public class Receipt {
    public Receipt () {
        userReceipt = new ArrayList<>();
    }

    public void newTotalBill() {
        this.totalBill = 0; // need to reset because it will count again
        for(int i = 0; i < userReceipt.size(); i++)
        {
            this.totalBill += userReceipt.get(i).getItemPrice();
        }
    }

    public void addItemToReceipt(Item item) {
        this.userReceipt.add(item);
        newTotalBill();
    }

    public void resetEntireReceipt() {
        int size = this.userReceipt.size();
        for(int i = 1; i < size; i++)
        {
            this.userReceipt.remove(i-1);
        }
    }

    public int getTotalCalories() {
        int kcal = 0;
        for (int i = 0; i < userReceipt.size(); i++) {
            kcal += this.userReceipt.get(i).getCalories();
        }
        return kcal;
    }

    public double getTotalBill() { return this.totalBill; }

    public void resetTotalBill() { this.totalBill = 0; }

    public void resetBill() {
        for(int i = 0; i < userReceipt.size(); i++)
        {
            this.userReceipt.remove(i);
        }
        resetTotalBill();
    }

    public ArrayList<Item> getUserReceipt() { return this.userReceipt; }

    // Attributes
    private ArrayList<Item> userReceipt;
    private double totalBill = 0;
}
