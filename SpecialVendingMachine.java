import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine{
    public SpecialVendingMachine(int SLOTS, String NAME) {
        super(SLOTS, NAME);
        this.VMslots = new ArrayList<>();
        initializeSpecialSlots();
    }

    public void initializeSpecialSlots() {
        int i;
        this.VMslots.add(new Slots("Vanilla Yogurt"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(0).getStocks().add(0, new Item(80, 75, "Vanilla Yogurt", "Swirling Vanilla..."));
        }

        this.VMslots.add(new Slots("Chocolate Yogurt"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(1).getStocks().add(new Item(135, 80, "Chocolate Yogurt", "Swirling Choco..."));
        }

        this.VMslots.add(new Slots("Strawberry Yogurt"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(2).getStocks().add(new Item(105, 85, "Strawberry Yogurt", "Swirling Strawberry..."));
        }

        this.VMslots.add(new Slots("Cup of Mangoes"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(3).getStocks().add(new Item(50, 65, "Cup of Mangoes", "Dicing Mangoes..."));
        }

        this.VMslots.add(new Slots("Banana"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(4).getStocks().add(new Item(30, 25, "Banana", "Peeling Banana..."));
        }

        this.VMslots.add(new Slots("Kit-Kat"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(5).getStocks().add(new Item(200, 90, "Kit-Kat", "Preparing Kit-Kat..."));
        }

        this.VMslots.add(new Slots("Cheesecake Slice"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(6).getStocks().add(new Item(175, 120, "Cheesecake Slice", "Baking Cheesecake Slice..."));
        }

        this.VMslots.add(new Slots("Cereal"));
        for (i = 0; i < 10; i++) {
            this.VMslots.get(7).getStocks().add(new Item(100, 55, "Cereal", "Measuring Cereal..."));
        }

        System.out.println("Special Vending Machine Initialized");
        System.out.println("Stocks will be 10 when initialized");
    }

    public double buyReceipt() {
        for(int i = 0; i < this.VMslots.size(); i++){
            for (int j = 0; j < getUserReceipt().getUserReceipt().size(); j++) {
                this.VMslots.get(i).getStocks().remove(this.getUserReceipt().getUserReceipt().get(j));
            }
        }
        return this.generateChange();
    }

    private ArrayList<Slots> VMslots;
}
