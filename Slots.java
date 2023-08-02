import java.util.ArrayList;

public class Slots {
    public Slots (String nameOfItem) {
        this.Stock = new ArrayList<>();
        this.nameOfItem = nameOfItem;
    }
    public void initializeItems(int numSlots) {
        do
        {
            this.Stock.add(new Item(0, 0.0, "Empty"));
            System.out.println("Stock Initializing: " + this.Stock.size());
        } while (this.Stock.size() < numSlots);
    }

    public ArrayList<Item> getStocks() { return this.Stock; };

    private String nameOfItem;
    private ArrayList<Item> Stock;
}
