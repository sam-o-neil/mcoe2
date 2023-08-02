public class VMcontroller {
    private VMmodel vmModel;
    private VMview vmView;

    public VMcontroller(VMmodel vmModel, VMview vmView) {
        this.vmView = vmView;
        this.vmModel = vmModel;

        // displays the type of vending machine to be created menu
        this.vmView.setTypeMachineCreationActionListener(e -> this.vmView.typeMachineMenu());

        // return to main menu
        this.vmView.setReturnMMBtnActionListener(e -> this.vmView.mainMenuOpen());

        // return to test menu
        this.vmView.setReturnTMBtnActionListener(e -> {
            this.vmModel.setBillZero();
            this.vmView.testingFeaturesMenu();
        });

        // exits the program
        this.vmView.setExitProgramActionListener(e -> System.exit(13));

        // simulation methods
        this.vmView.setSimulationMenuOpenActionListener(e -> {
            this.vmModel.getUserBill().resetEntireReceipt();
            this.vmModel.setBillZero();
            if(this.vmModel.getStatus() == 1)
                this.vmView.simulationFeaturesMenu(vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
            if(this.vmModel.getStatus() == 2)
                this.vmView.specialChooseFlavorMenu(this.vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2));
        });

        // maintenance methods
        this.vmView.setMaintenanceMenuOpenActionListener(e -> this.vmView.maintenanceFeaturesMenu());
        this.vmView.setTransactionSummaryMaintenanceBtnActionListener(e -> {
            vmModel.runCurrentStock();
            vmView.transactionSummaryMaintenanceMenu(this.vmModel.getInitialS(), this.vmModel.getCurrentS());
        });

        // opens test features menu
        this.vmView.setAccessTestMenuBtnActionListener(e -> {
            if (this.vmModel.getExistingStatus()) {
                this.vmModel.setBillZero();
                this.vmView.testingFeaturesMenu();
            }
            else {
                this.vmView.makeNotif("You have not created a vending machine yet! Make one first.");
                this.vmView.mainMenuOpen();
            }
        });

        // creates a regular vending machine
        this.vmView.setCreateRegularVMBtnActionListener(e -> {
            this.vmModel.regVMchoice();
            this.vmView.makeNotif("Successfully Created a Vending Machine! You will now be returned to the Main Menu");
            this.vmView.mainMenuOpen();
        });

        // creates a special vending machine
        this.vmView.setCreateSpecialVMBtnActionListener(e -> {
            this.vmModel.specVMchoice();
            this.vmView.makeNotif("Successfully Created a Fro-yo Special Vending Machine! You will now be returned to the Main Menu");
            this.vmView.mainMenuOpen();
        });

        // Money Methods
        // opens the add money menu
        this.vmView.setAccessMoneyMenuBtnActionListener(e -> this.vmView.machineCashMenu(this.vmModel.getDenom1(), this.vmModel.getDenom5(), this.vmModel.getDenom10(), this.vmModel.getDenom20(), vmModel.getDenom50(), this.vmModel.getDenom100(), this.vmModel.getVMmoney()));

        // user will submit the inputted denominations
        this.vmView.setSubmitInputtedMoneyDenomsActionListener(e -> {
            boolean inputs = false;
            int denomChoice = 0;
            int denomAmtChoice = 0;
            try {
                denomChoice = (Integer.parseInt(vmView.getDenomTypeText()));
                denomAmtChoice = (Integer.parseInt(vmView.getDenomAmtText()));
            } catch (NumberFormatException l) {
                this.vmView.makeNotif("Invalid Input! Denominations can be 1, 5, 10, 20, 50, 100 only. Amount should be (reasonable) positive numbers only.");
                this.vmView.clearDenomTypeTF();
                this.vmView.clearAmtDenomTypeTF();
            }
            if (denomChoice != 1 && denomChoice != 5 && denomChoice != 10 && denomChoice != 20 && denomChoice != 50 && denomChoice != 100) {
                this.vmView.makeNotif("Invalid Input! Denominations can be 1, 5, 10, 20, 50, 100 only. Amount should be (reasonable) positive numbers only.");
                this.vmView.clearDenomTypeTF();
                this.vmView.clearAmtDenomTypeTF();
            }
            if (denomChoice == 1 || denomChoice == 5 || denomChoice == 10 || denomChoice == 20 || denomChoice == 50 || denomChoice == 100 && denomAmtChoice > 0) {
                inputs = true;
            }
            if (inputs) {
                this.vmModel.addDenom(denomChoice, denomAmtChoice);
                this.vmView.clearDenomTypeTF();
                this.vmView.clearAmtDenomTypeTF();
                this.vmView.machineCashMenu(this.vmModel.getDenom1(), this.vmModel.getDenom5(), this.vmModel.getDenom10(), this.vmModel.getDenom20(), vmModel.getDenom50(), this.vmModel.getDenom100(), this.vmModel.getVMmoney());
            }
            if (!inputs) {
                this.vmView.clearDenomTypeTF();
                this.vmView.clearAmtDenomTypeTF();
            }
        });

        // user will collect money from the machine
        this.vmView.setCollectMoneyActionListener(e -> {
            double incomeAtCollection = 0.0;
            incomeAtCollection = vmModel.getVMmoney();
            this.vmModel.collectMoney();
            vmView.makeNotif("You've made " + incomeAtCollection + " Peso/s! Hooray!");
            vmView.clearAmtDenomTypeTF();
            vmView.clearDenomTypeTF();
            vmView.machineCashMenu(this.vmModel.getDenom1(), this.vmModel.getDenom5(), this.vmModel.getDenom10(), this.vmModel.getDenom20(), vmModel.getDenom50(), this.vmModel.getDenom100(), this.vmModel.getVMmoney());
        });

        // user will input money to "buy" from the machine
        this.vmView.setUserInputMoneyDenomsActionListener(e -> {
            boolean inputs = false;
            int denomChoice = 0;
            int denomAmtChoice = 0;
            try {
                denomChoice = (Integer.parseInt(vmView.getUserInputMoney()));
                denomAmtChoice = (Integer.parseInt(vmView.getUserAmountInput()));
            } catch (NumberFormatException l) {
                this.vmView.makeNotif("This machine doesn't accept that! Denominations can be 1, 5, 10, 20, 50, 100 only. Amount should be positive numbers only.");
                this.vmView.clearUserInputMoney();
                this.vmView.clearUserAmountInput();
            }
            if (denomChoice != 1 && denomChoice != 5 && denomChoice != 10 && denomChoice != 20 && denomChoice != 50 && denomChoice != 100) {
                this.vmView.makeNotif("This machine doesn't accept that! Denominations can be 1, 5, 10, 20, 50, 100 only. Amount should be positive numbers only.");
                this.vmView.clearUserInputMoney();
                this.vmView.clearUserAmountInput();
            }
            if (denomChoice == 1 || denomChoice == 5 || denomChoice == 10 || denomChoice == 20 || denomChoice == 50 || denomChoice == 100 && denomAmtChoice > 0) {
                inputs = true;
            }
            if (inputs) {
                this.vmModel.addUserDenom(denomChoice, denomAmtChoice);
                this.vmModel.addDenom(denomChoice, denomAmtChoice);
                this.vmView.clearUserInputMoney();
                this.vmView.clearUserAmountInput();
                if (vmModel.getStatus() == 1){
                    this.vmView.simulationFeaturesMenu(vmModel.getUserMoney(), vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                }
                if (vmModel.getStatus() == 2){
                    this.vmView.specialFinalPurchaseScreen(this.vmModel.getUserBill(), this.vmModel.getUserMoney());
                }
            }
            if (!inputs) {
                this.vmView.clearUserInputMoney();
                this.vmView.clearUserAmountInput();
            }
        });

        // user will collect change
        this.vmView.setUserCollectChangeActionListener(e -> {
            double incomeAtCollection = 0.0;
            incomeAtCollection = vmModel.getUserMoney();
            this.vmModel.collectChange();
            vmView.makeNotif("Your change is " + incomeAtCollection + " Thank you Froyo Friend!");
            vmView.clearUserAmountInput();
            vmView.clearUserInputMoney();
            if (vmModel.getStatus() == 1){
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
            }
            if(vmModel.getStatus() == 2){
                vmView.specialFinalPurchaseScreen(this.vmModel.getUserBill(), this.vmModel.getUserMoney());
            }
        });

        // reset Receipt/Transaction
        this.vmView.setRestartTransactionBtnActionListener(e -> {
            this.vmModel.restartTransaction();
            vmView.enableOtherButtons();
            vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
        });

        // REGULAR VENDING MACHINE BUYING BUTTONS
        this.vmView.setVYBtnActionListener(e -> {
            if (vmModel.getStatus() == 1) {
                vmModel.buyRegItem(0);
                vmView.setCurrentRegItem(0);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(0);
                vmView.specialChooseFruitMenu(this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4));
            }
        });

        this.vmView.setCYBtnActionListener(e -> {
            if (vmModel.getStatus() == 1) {
                this.vmModel.buyRegItem(1);
                vmView.setCurrentRegItem(1);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(1);
                vmView.specialChooseFruitMenu(this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4));
            }
        });

        this.vmView.setSYBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(2);
                vmView.setCurrentRegItem(2);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(2);
                vmView.specialChooseFruitMenu(this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4));
            }
        });

        this.vmView.setCMBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(3);
                vmView.setCurrentRegItem(3);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(3);
                vmView.specialChooseExtraMenu(this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), this.vmModel.getStockOfItem(7));
            }
        });

        this.vmView.setBBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(4);
                vmView.setCurrentRegItem(4);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(4);
                vmView.specialChooseExtraMenu(this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), this.vmModel.getStockOfItem(7));
            }
        });

        this.vmView.setCSBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(6);
                vmView.setCurrentRegItem(6);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(6);
                vmView.specialChooseSyrupMenu();
            }
        });

        this.vmView.setKKBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(5);
                vmView.setCurrentRegItem(5);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() ==2 ) {
                vmModel.addItemToReceipt(5);
                vmView.specialChooseSyrupMenu();
            }
        });

        this.vmView.setCBtnActionListener(e -> {
            if (vmModel.getStatus() == 1){
                this.vmModel.buyRegItem(7);
                vmView.setCurrentRegItem(7);
                vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                vmView.disableOtherButtons();
            }
            if (vmModel.getStatus() == 2) {
                vmModel.addItemToReceipt(7);
                vmView.specialChooseSyrupMenu();
            }
        });

        this.vmView.setSpecialChocoSBtnActionListener(e -> {
            this.vmModel.addSyrupToReceipt(1);
            this.vmView.specialFinalPurchaseScreen(this.vmModel.currentSVM.getUserReceipt(), this.vmModel.getUserMoney());
        });

        this.vmView.setSpecialCaramelSBtnActionListener(e -> {
            System.out.println("working");
            this.vmModel.addSyrupToReceipt(2);
            this.vmView.specialFinalPurchaseScreen(this.vmModel.currentSVM.getUserReceipt(), this.vmModel.getUserMoney());
        });

        this.vmView.setSpecialMilkSBtnActionListener(e -> {
            this.vmModel.addSyrupToReceipt(3);
            this.vmView.specialFinalPurchaseScreen(this.vmModel.currentSVM.getUserReceipt(), this.vmModel.getUserMoney());
        });

        this.vmView.setFinalizePurchaseBtnActionListener(e -> {
            double value = this.vmModel.machineHasEnoughMoney();
            if (vmView.getCurrentRegItem() == -1 || !vmModel.userHasEnoughMoney())
            {
                vmView.makeNotif("You need to choose an item first. Please make sure you have enough money in the machine to complete the transaction");
            }
            else if (this.vmModel.userHasEnoughMoney()){
                if (value != -1) {
                    vmView.makeNotif("Thank you for your purchase! Your change is : " + this.vmModel.userChangeValue() + " Pesos!");
                    vmView.enableOtherButtons();
                    this.vmModel.collectChange();
                    this.vmModel.finalizeRegPurchase(vmView.getCurrentRegItem());
                    this.vmModel.restartTransaction();
                    vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                }
                else {
                    vmView.makeNotif("Unfortunately, our machine does not have enough money to return change for this transaction, it is now void. Please enter exact amount or less to try again.");
                    vmView.enableOtherButtons();
                    this.vmModel.restartTransaction();
                    vmView.simulationFeaturesMenu(this.vmModel.getUserMoney(), this.vmModel.getTotalBill(), vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), vmModel.getStockOfItem(7));
                }
            }
        });

        this.vmView.setSpecialFinalizePurchaseBtnActionListener(e -> {
            if(vmModel.getUserBill().getTotalBill() > vmModel.getUserMoney())
                vmView.makeNotif("You do not have enough money to complete this transaction.");
            if(vmModel.getUserBill().getTotalBill() <= vmModel.getUserMoney()) {
                vmView.preparingOrderPopUp(vmModel.getUserBill());
            }
        });

        this.vmView.setThankYouBtnActionListener(e -> {
            vmView.testingFeaturesMenu();
            vmView.makeNotif("Thank you for purchasing! Your change is " + vmModel.buySpecItem() + " Pesos! Come back soon!");
        });

        this.vmView.setViewReceiptBtnActionListener(e -> this.vmView.receiptPopUp(this.vmModel.getUserBill()));

        this.vmView.setCloseReceiptBtnActionListener(e -> this.vmView.disposeRecieptFrame() );

        this.vmView.setChangePriceMaintenanceBtnActionListener(e -> {
            vmView.clearNewItemPriceInputTF();
            vmView.clearNewItemPriceTypeTF();
            vmView.changeItemPriceMaintenanceMenu(this.vmModel.getPriceOfItem(0), this.vmModel.getPriceOfItem(1), this.vmModel.getPriceOfItem(2), this.vmModel.getPriceOfItem(3), this.vmModel.getPriceOfItem(4), this.vmModel.getPriceOfItem(5), this.vmModel.getPriceOfItem(6), this.vmModel.getPriceOfItem(7));
        });

        this.vmView.setAddStocksMaintenanceBtnActionListener(e -> {
            vmView.clearNewStockAmtTF();
            vmView.clearItemToStockTF();
            vmView.restockItemMaintenanceMenu(this.vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), this.vmModel.getStockOfItem(7));
        });

        this.vmView.setSubmitNewItemPriceBtnActionListener(e -> {
            double newPrice = 0;
            int itemChoice = 0;
            try {
                newPrice = (Double.parseDouble(vmView.getNewItemPriceInputTF()));
                itemChoice = (Integer.parseInt(vmView.getNewItemPriceTypeInputTF()));
            } catch (NumberFormatException l){
                vmView.makeNotif("Either your new price is not positive or the item type is out of range. Please check your inputs and try again.");
                vmView.clearNewItemPriceTypeTF();
                vmView.clearNewItemPriceInputTF();
            }
            if (itemChoice > 0 && itemChoice < 9 && newPrice > 0)
            {
                this.vmModel.changeItemPrice(itemChoice-1, newPrice);
                vmView.changeItemPriceMaintenanceMenu(this.vmModel.getPriceOfItem(0), this.vmModel.getPriceOfItem(1), this.vmModel.getPriceOfItem(2), this.vmModel.getPriceOfItem(3), this.vmModel.getPriceOfItem(4), this.vmModel.getPriceOfItem(5), this.vmModel.getPriceOfItem(6), this.vmModel.getPriceOfItem(7));
            }
            if (itemChoice < 0 && itemChoice > 8 && newPrice < 0)
            {
                vmView.makeNotif("Your Inputs are Invalid. Make sure you're inputting positive values and your item choice is within range.");
                vmView.clearNewItemPriceInputTF();
                vmView.clearNewItemPriceTypeTF();
            }
        });

        this.vmView.setSubmitRestockBtnActionListener(e -> {
            int newStock = 0;
            int itemChoice = 0;
            try {
                newStock = (Integer.parseInt(vmView.getNewStockAmtTF()));
                itemChoice = (Integer.parseInt(vmView.getItemToStockTF()));
            } catch (NumberFormatException l){
                vmView.makeNotif("Either your new stock is not positive or the item type is out of range. Please check your inputs and try again.");
                vmView.clearNewStockAmtTF();
                vmView.clearItemToStockTF();
            }
            if (itemChoice > 0 && itemChoice < 9 && newStock > 0)
            {
                this.vmModel.restockItem(itemChoice-1, newStock);
                vmView.clearItemToStockTF();
                vmView.clearNewStockAmtTF();
                vmView.restockItemMaintenanceMenu(this.vmModel.getStockOfItem(0), this.vmModel.getStockOfItem(1), this.vmModel.getStockOfItem(2), this.vmModel.getStockOfItem(3), this.vmModel.getStockOfItem(4), this.vmModel.getStockOfItem(5), this.vmModel.getStockOfItem(6), this.vmModel.getStockOfItem(7));
            }
            if (itemChoice < 1 || itemChoice > 8 || newStock < 0)
            {
                vmView.makeNotif("Your Inputs are Invalid. Make sure you're inputting positive values and your item choice is within range.");
                vmView.clearNewStockAmtTF();
                vmView.clearItemToStockTF();
            }
        });
    }
}
