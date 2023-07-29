
public class VMcontroller {
    private VMmodel vmModel;
    private VMview vmView;

    public VMcontroller(VMmodel vMmodel, VMview vmView)
    {
        this.vmView = vmView;
        this.vmModel = vMmodel;

        this.vmView.setCreateBtnActionListener(e -> vmView.vendingTypeView());

        this.vmView.setExitBtnActionListener(e -> System.exit(5));

        this.vmView.setRegBtnActionListener(e -> vmView.createRegView());

        this.vmView.setvmCreateSubmitBtnActionListener(e -> {
            boolean inputs = false;
            do {
                int slotNumber = 0;
                String VMname = vmView.getNameTxt();
                String VMslots = vmView.getSlotsTxt();
                try {
                    slotNumber = Integer.parseInt(VMslots);
                } catch (NumberFormatException l) {
                    vmView.clearInputSlots();
                    vmView.showInputError();
                }
                inputs = vmModel.verifyCreateInputs(slotNumber, VMname);
            } while (!inputs);
            this.vmModel.setExistingVM(inputs); // sets existing VM boolean in model to true
            this.vmView.vendingMMview();
        });

        this.vmView.setReturnMMBtnActionListener(e ->
        {
            vmView.vendingMMview();
        });

        this.vmView.setTestBtnActionListener(e -> {
            // vmView.testVMmenu;
        });

        this.vmView.setMaintainBtnActionListener(e -> {
            // vmView.maintainVMmenu;
        });
    }

    // handles requests from the user interacts with model
    public boolean existingVMstatus() { return this.vmModel.getExistingStatus(); }

}
