import java.util.ArrayList;
// YOU ARE IMPLEMENTING THE VM MODEL CLASSES AND THE MONEY CLASSES JUST WAITTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT


public class VMmodel {
    // handles logic and data
    public int getStatus() { return this.status; }

    public double getVMmoney() {
        if (status == 1){
            return currentVM.getTotalMoney();
        }
        return currentSVM.getTotalMoney();
    }
    public int getDenom1() {
        if (this.status == 1) {
            return currentVM.get1denom();
        }
        else {
            return currentSVM.get1denom();
        }
    }
    public int getDenom5() {
        if (this.status == 1) {
            return currentVM.get5denom();
        }
        else {
            return currentSVM.get5denom();
        }
    }
    public int getDenom10() {
        if (this.status == 1) {
            return currentVM.get10denom();
        }
        else {
            return currentSVM.get10denom();
        }
    }
    public int getDenom20() {
        if (this.status == 1) {
            return currentVM.get20denom();
        }
        else {
            return currentSVM.get20denom();
        }
    }
    public int getDenom50() {
        if (this.status == 1) {
            return currentVM.get50denom();
        }
        else {
            return currentSVM.get50denom();
        }
    }
    public int getDenom100() {
        if (this.status == 1) {
            return currentVM.get100denom();
        }
        else {
            return currentSVM.get100denom();
        }
    }
    public void addDenom(int denomType, int denomAmt) {
        switch (denomType)
        {
            case 1 -> {
                if (this.status == 1) {
                    currentVM.add1denom(denomAmt);
                }
                else {
                    currentSVM.add1denom(denomAmt);
                }
            }
            case 5 -> {
                if (this.status == 1) {
                    currentVM.add5denom(denomAmt);
                }
                else {
                    currentSVM.add5denom(denomAmt);
                }
            }
            case 10 -> {
                if (this.status == 1) {
                    currentVM.add10denom(denomAmt);
                }
                else {
                    currentSVM.add10denom(denomAmt);
                }
            }
            case 20 -> {
                if (this.status == 1) {
                    currentVM.add20denom(denomAmt);
                }
                else {
                    currentSVM.add20denom(denomAmt);
                }
            }
            case 50 -> {
                if (this.status == 1) {
                    currentVM.add50denom(denomAmt);
                }
                else {
                    currentSVM.add50denom(denomAmt);
                }
            }
            case 100 -> {
                if (this.status == 1) {
                    currentVM.add100denom(denomAmt);
                }
                else {
                    currentSVM.add100denom(denomAmt);
                }
            }
        }
    }

    public void addUserDenom(int denomType, int denomAmt) {
        switch (denomType)
        {
            case 1 -> {
                if (this.status == 1) {
                    currentVM.userAdd1denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd1denom(denomAmt);
                }
            }
            case 5 -> {
                if (this.status == 1) {
                    currentVM.userAdd5denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd5denom(denomAmt);
                }
            }
            case 10 -> {
                if (this.status == 1) {
                    currentVM.userAdd10denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd10denom(denomAmt);
                }
            }
            case 20 -> {
                if (this.status == 1) {
                    currentVM.userAdd20denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd20denom(denomAmt);
                }
            }
            case 50 -> {
                if (this.status == 1) {
                    currentVM.userAdd50denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd50denom(denomAmt);
                }
            }
            case 100 -> {
                if (this.status == 1) {
                    currentVM.userAdd100denom(denomAmt);
                }
                if(status == 2) {
                    currentSVM.userAdd100denom(denomAmt);
                }
            }
        }
    }

    public void collectChange() {
        if (this.status == 1)
        {
            currentVM.collectChange();
        }
        if(status == 2) {
            currentSVM.collectChange();
        }
    }

    public void collectMoney() {
        if (this.status == 1)
        {
            currentVM.collectIncome();
        }
        if(status == 2) {
            currentSVM.collectIncome();
        }
    }

    public void regVMchoice() {
        status = 1;
        currentVM = new VendingMachine(8, "Fro-Yo Friend!");
    }

    public void specVMchoice() {
        status = 2;
        currentSVM = new SpecialVendingMachine(10, "Fro-Yo Friend!");
    }

    public boolean getExistingStatus() {
        if(status == 0)
            return false; // that means no vending machine has been created
        else {
            return true; // that means it has been set to either 1 or 2
        }
    }

    public int getStockOfItem(int index) {
        if (status == 1)
        {
            return currentVM.getStockOfItem(index);
        }
        return currentSVM.getStockOfItem(index);
    }

    public double getPriceOfItem(int index) {
        if (status == 1)
        {
            return currentVM.getPriceOfItem(index);
        }
        return currentSVM.getPriceOfItem(index);
    }

    public double getUserMoney() {
        double userMoney = 0;
        if (status == 1)
        {
            userMoney = currentVM.getUserMoney();
        }
        if(status == 2) {
            userMoney = currentSVM.getUserMoney();
        }
        return userMoney;
    }

    public void addItemToReceipt(int index) {
        if (status == 1)
            this.currentVM.addIndexToReceipt(index);
        if(status == 2) {
            this.currentSVM.addIndexToReceipt(index);
        }
    }

    public void addSyrupToReceipt(int type) {
        if (type == 1)
            this.currentSVM.addItemToReceipt(new Item(45, 30, "Chocolate Syrup", "Melting Chocolate..."));
        if (type == 2)
            this.currentSVM.addItemToReceipt(new Item(32, 30, "Caramel Syrup", "Melting Caramel..."));
        if (type == 3)
            this.currentSVM.addItemToReceipt(new Item(25, 30, "Milk Cereal Syrup", "Pouring Milk Cereal..."));
    }
    public double getTotalBill() {
        if (status == 1)
            return this.currentVM.getTotalBill();
        return this.currentSVM.getTotalBill();
    }

    public void buyRegItem(int number) {
        currentVM.buyRVMitem(number); // number will depend on which button is pressed and will be set in the controller
    }

    public double buySpecItem() {
        double change = currentSVM.buyReceipt();
        return change;
    }

    public void finalizeRegPurchase(int number) {
        currentVM.finalizePurchase(number);
    }

    public boolean userHasEnoughMoney() {
        boolean value = false;
        if (status == 1)
        {
            if (this.currentVM.getUserMoney() >= this.currentVM.getTotalBill())
            {
                value = true;
            }
            else
            {
                value = false;
            }
        }
        if(status == 2) {
            if (this.currentSVM.getUserMoney() >= this.currentSVM.getTotalBill())
            {
                value = true;
            }
            else
            {
                value = false;
            }
        }
        return value;
    }

    public double machineHasEnoughMoney() {
        if(status == 1)
        {
            return this.currentVM.generateChange();
        }
        return this.currentSVM.generateChange();
    }

    public double userChangeValue() {
        double change = 0;
        if (status == 1)
            change = this.currentVM.getChangeValue();
        if (status == 2)
            change = this.currentSVM.getChangeValue();
        return change;
    }

    public void restartTransaction() {
        if (status == 1)
        {
            currentVM.restartTransaction();
        }
        if(status == 2) {
            currentSVM.restartTransaction();
        }
    }

    public void setBillZero() {
        if (status == 1)
        {
            this.currentVM.restartTransaction();
        }
        else {
            this.currentSVM.restartTransaction();
        }
    }

    public Receipt getUserBill() {
        if (status == 1)
        {
            return this.currentVM.getUserReceipt();
        }

        return this.currentSVM.getUserReceipt();

    }

    public void changeItemPrice(int index, double newPrice) {
        if (status == 1)
            this.currentVM.changeItemPrice(index, newPrice);
        else {
            this.currentSVM.changeItemPrice(index, newPrice);
        }
    }

    public void restockItem(int index, int newStocks)
    {
        if (status == 1)
        {
            this.currentVM.restockItem(index, newStocks);
        }
        if (status == 2)
        {
            this.currentSVM.restockItem(index, newStocks);
        }
    }

    public ArrayList<String> getInitialS() {
        if (status == 1)
            return this.currentVM.getInitialStock();
        return this.currentSVM.getInitialStock();
    }

    public ArrayList<String> getCurrentS() {
        if (status == 1)
            return this.currentVM.getCurrentStock();
        return this.currentSVM.getCurrentStock();
    }

    public void runCurrentStock() {
        if (status == 1)
            this.currentVM.setCurrentStock();
        if (status == 2)
            this.currentSVM.setCurrentStock();
    }

    // Attributes
    int status = 0; // 1 for vending 2 for special
    VendingMachine currentVM;
    SpecialVendingMachine currentSVM;
}
