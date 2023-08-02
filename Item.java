/**
 * This is a class for the Item object
 * @author Samantha O'Neil
 */
public class Item {

    /**
     * This is the constructor for the Item class. It is impossible to make an instance missing any of these params
     * @param caloriesAmt amount of calories in the item
     * @param priceAmt initial price of the item
     * @param name the name of the item
     */
    public Item(int caloriesAmt, double priceAmt, String name) {
        this.Calories = caloriesAmt;
        this.itemPrice = priceAmt;
        this.ItemName = name;
    }

    /**
     * This is the second constructor for the Item class, for the message pop ups in the Special Vending Machine. It is impossible to make an instance missing any of these params
     * @param caloriesAmt amount of calories in the item
     * @param priceAmt initial price of the item
     * @param name the name of the item
     * @param prepMsg the preparation message to be displayed when buying an item from a special vending machine
     */
    public Item(int caloriesAmt, double priceAmt, String name, String prepMsg) {
        this.Calories = caloriesAmt;
        this.itemPrice = priceAmt;
        this.ItemName = name;
        this.prepMsg = prepMsg;
    }

    /**
     * This is the only way to have public access to the private attribute calories
     * @return calories attribute of the item
     */
    public int getCalories() {
        return this.Calories;
    }

    /**
     * This is the only way to publicly access the private attribute Item Price
     * @return the price of an item
     */
    public double getItemPrice() {
        return this.itemPrice;
    }

    /**
     * This is the only way to publicly access the private attribute Item Name
     * @return the name of an item
     */
    public String getItemName() {
        return this.ItemName;
    }

    /**
     * This method is for maintenance. It allows the user to change the price of an item.
     * @param priceAmt the new price of an item
     */
    public void setItemPrice(double priceAmt) {
        this.itemPrice = priceAmt;
    }

    public String getPrepMsg() { return this.prepMsg; }

    private int Calories;
    private String prepMsg;
    private double itemPrice;
    private String ItemName;

}

