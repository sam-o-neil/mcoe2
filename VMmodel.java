import java.util.ArrayList;

public class VMmodel {
    // handles logic and data
    boolean existingVM = false;
    public void createRegVM(int SLOTS, String NAME) {
        RegularVendingMachine currentVM = new RegularVendingMachine(SLOTS, NAME);
        if (currentVM.getNAME().equals(NAME)){ this.existingVM = true; } // just double-checking to see if a vending machine was created
    }
    public void createSpecVM(int SLOTS, String NAME) {
        SpecialVendingMachine currentVM = new SpecialVendingMachine(SLOTS, NAME);
        if (currentVM.getNAME().equals(NAME)) { this.existingVM = true; } // double-checking to see if a vending machine was created
    }
    public boolean verifyCreateInputs(int slots, String name) {
        boolean inputs = false;
        if (slots > 7 && slots < 11 && name.length() <= 12 && name.length() != 0)
        { inputs = true; } // valid inputs
        return inputs;
    }
    public void setExistingVM(boolean status) { this.existingVM = status; }
    public boolean getExistingStatus() { return this.existingVM; }
    public int getVMslots(VendingMachine currentVM) { return currentVM.getSLOTS(); }
    public String getVMname(VendingMachine currentVM) { return currentVM.getNAME(); }
}
