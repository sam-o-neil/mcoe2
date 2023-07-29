public abstract class VendingMachine {
    public VendingMachine(int SLOTS, String NAME) {
        this.SLOTS = SLOTS;
        this.NAME = NAME;
    }

    public int getSLOTS() { return this.SLOTS; }
    public String getNAME() { return this.NAME; }

    // Attributes ======================================================================================================
    private final int SLOTS; // Number of slots the vending machine has
    private final String NAME; // Name of the vending machine for GUI purposes and organization
}
