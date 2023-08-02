import java.util.ArrayList;

public class VendingMachine {
    public VendingMachine(int SLOTS, String NAME) {
        this.SLOTS = SLOTS;
        this.NAME = NAME;
        this.VMslots = new ArrayList<Slots>();
        initializeSlots();
        setInitialStock();
    }

    /**
     * This is the getter for the SLOTS attribute
     * @return the number of slots a vending machine has
     */
    public int getSLOTS() { return this.SLOTS; }

    /**
     * This is the getter for the NAME attribute
     * @return the name of the vending machine
     */
    public String getNAME() { return this.NAME; }

    /**
     * This is the getter for the total money in all denominations the machine currently has
     * @return the total amount of money the machine has at the given time
     */
    public double getTotalMoney() { return moneyVM.getTotalAmt(); }

    public int getStockOfItem(int index) { return this.VMslots.get(index).getStocks().size(); }

    public double getPriceOfItem(int index) { return this.VMslots.get(index).getStocks().get(index).getItemPrice(); }

    public void setInitialStock() {
        for (int i = 0; i < this.VMslots.size(); i++){
            this.initialStock.add(i, "Initial stock of " + this.VMslots.get(i).getStocks().get(i).getItemName() + ": " + this.getStockOfItem(i));
        }
    }

    public void setCurrentStock() {
        for (int i = 0; i < this.VMslots.size(); i++) {
            if(this.getStockOfItem(i) == 0)
                this.currentStock.add(i, "Current stock of " + this.VMslots.get(i).getStocks().get(i).getItemName() + "is 0. Empty SLOT.");
            this.currentStock.add(i, "Current stock of " + this.VMslots.get(i).getStocks().get(i).getItemName() + ": " + this.getStockOfItem(i));
        }
    }

    public ArrayList<String> getInitialStock() { return this.initialStock; }

    public ArrayList<String> getCurrentStock() { return this.currentStock; }

    public void initializeSlots() {
        int i;
        this.VMslots.add(new Slots("Vanilla Yogurt"));
        for (i = 0; i < 10; i++){
            this.VMslots.get(0).getStocks().add(new Item(80, 75, "Vanilla Yogurt", "Swirling Vanilla..."));
        }

        this.VMslots.add(new Slots("Chocolate Yogurt"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(1).getStocks().add(new Item(135, 80, "Chocolate Yogurt", "Swirling Choco..."));
        }

        this.VMslots.add(new Slots("Strawberry Yogurt"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(2).getStocks().add(new Item(105, 85, "Strawberry Yogurt", "Swirling Strawberries..."));
        }

        this.VMslots.add(new Slots("Cup of Mangoes"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(3).getStocks().add(new Item(50, 65, "Cup of Mangoes", "Dicing Mangoes..."));
        }

        this.VMslots.add(new Slots("Banana"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(4).getStocks().add(new Item(30, 25, "Banana", "Peeling Bananas..."));
        }

        this.VMslots.add(new Slots("Kit-Kat"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(5).getStocks().add(new Item(200, 90, "Kit-Kat", "Dividing Kitkats..."));
        }

        this.VMslots.add(new Slots("Cheesecake Slice"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(6).getStocks().add(new Item(175, 120, "Cheesecake Slice", "Slicing Cheesecake..."));
        }

        this.VMslots.add(new Slots("Cereal"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(7).getStocks().add(new Item(100, 55, "Cereal", "Shaking Cereal..."));
        }

        System.out.println("Regular Vending Machine Initialized");
        System.out.println("Stocks will be 10 when initialized");
    }

    public int get1denom() { return moneyVM.getDenom1(); }
    public int get5denom() { return moneyVM.getDenom5(); }
    public int get10denom() { return moneyVM.getDenom10(); }
    public int get20denom() { return moneyVM.getDenom20(); }
    public int get50denom() { return moneyVM.getDenom50(); }
    public int get100denom() { return moneyVM.getDenom100(); }
    public void add1denom(int amount) { moneyVM.addDenom1(amount); }
    public void add5denom(int amount) { moneyVM.addDenom5(amount); }
    public void add10denom(int amount) { moneyVM.addDenom10(amount); }
    public void add20denom(int amount) { moneyVM.addDenom20(amount); }
    public void add50denom(int amount) { moneyVM.addDenom50(amount); }
    public void add100denom(int amount) { moneyVM.addDenom100(amount); }
    public void collectIncome() { moneyVM.collectIncome(); }
    public double getUserMoney() { return userMoney.getTotalAmt(); }
    public void userAdd1denom(int amount) {
        userMoney.addDenom1(amount);
    }
    public void userAdd5denom(int amount) {
        userMoney.addDenom5(amount);
    }
    public void userAdd10denom(int amount) {
        userMoney.addDenom10(amount);
    }
    public void userAdd20denom(int amount) {
        userMoney.addDenom20(amount);
    }
    public void userAdd50denom(int amount) {
        userMoney.addDenom50(amount);
    }
    public void userAdd100denom(int amount) {
        userMoney.addDenom100(amount);
    }
    public void collectChange() { userMoney.collectChange(); }
    public void addItemToReceipt(Item item) { this.vmReceipt.addItemToReceipt(item);}
    public double getTotalBill() { return this.vmReceipt.getTotalBill(); }

    public void restartTransaction() { this.vmReceipt.resetBill(); }

    public void buyRVMitem(int number) {
        addItemToReceipt(this.VMslots.get(number).getStocks().get(number));
        System.out.println("Purchased: " + this.VMslots.get(number).getStocks().get(number).getItemName()); // for debugging purposes only
    }

    public void addIndexToReceipt(int index) {
        addItemToReceipt(this.VMslots.get(index).getStocks().get(index));
    }

    public double generateChange() {
        return this.moneyVM.generateChange(this.getUserMoney());
    }

    public void finalizePurchase(int index) {
        this.VMslots.get(index).getStocks().remove(index);
    }

    public double getChangeValue() { return (this.userMoney.getTotalAmt()-this.getTotalBill()); }

    public Receipt getUserReceipt() {
        return this.vmReceipt;
    }

    public void changeItemPrice(int index, double newPrice) {
        this.VMslots.get(index).getStocks().get(index).setItemPrice(newPrice);
    }

    public void restockItem(int index, int newStocks) {
        for(int i = 0; i < newStocks; i++)
        {
            this.VMslots.get(index).getStocks().add(index, new Item(this.VMslots.get(index).getStocks().get(index).getCalories(), this.VMslots.get(index).getStocks().get(index).getItemPrice(), this.VMslots.get(index).getStocks().get(index).getItemName()));
        }
    }

    // Item Methods

    // Attributes ======================================================================================================
    private final int SLOTS; // Number of slots the vending machine has
    private ArrayList<Slots> VMslots;
    private final String NAME; // Name of the vending machine for GUI purposes and organization
    private Receipt vmReceipt = new Receipt();
    private ArrayList<String> currentStock;
    private ArrayList<String> initialStock;
    private Money userMoney = new Money(0,0,0,0,0,0);
    private Money moneyVM = new Money(0,0,0,0,0,0); // The machine starts out with no money
}

