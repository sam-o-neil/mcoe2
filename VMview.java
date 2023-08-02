import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class VMview {
    // handles data presentation
    private JFrame mainFrame; // main window
    private JLabel title;
    private JPanel header = new JPanel();
    private JPanel center = new JPanel();
    private JPanel bottom = new JPanel();

    private int currentRegItemInt = -1;

    // Reused Buttons
    JButton returnMMBtn = new JButton();
    JButton returnTMBtn = new JButton();
    JFrame receiptUser = new JFrame("RECEIPT");

    // Main Menu Buttons
    JButton createMachineBtn = new JButton();
    JButton accessTestMenuBtn = new JButton();
    JButton exitProgramBtn = new JButton();
    // Testing Features Menu
    JButton simulationMenuOpen = new JButton();
    JButton maintenanceMenuOpen = new JButton();

    // Create Machine Menu
    JButton regMenuChoiceBtn = new JButton();
    JButton specMenuChoiceBtn = new JButton();

    // Money Related
    JButton accessMoneyMenuBtn = new JButton();
    JButton addMoney = new JButton(); // The "Submit" button for adding money
    JButton collectMoney = new JButton(); // Collecting All Income
    JTextField denominationType = new JTextField();
    JTextField amtOfDenomination = new JTextField();

    // Regular Vending Machine Buttons
    JButton VYBtn = new JButton(); // Vanila Yogurt
    JButton CYBtn = new JButton(); // Choco Yogurt
    JButton SYBtn = new JButton(); // Strawberry Yogurt
    JButton CMBtn = new JButton(); // Cup Mangoes
    JButton BBtn = new JButton(); // Banana
    JButton CSBtn = new JButton(); // Cheesecake Slice
    JButton KKBtn = new JButton(); // Kitkat
    JButton CBtn = new JButton(); // Cereal
    JButton addPaymentBtn = new JButton(); // User will add payment
    JButton dispenseChangeBtn = new JButton(); // User will dispense change
    JButton finalizePurchaseBtn = new JButton(); // User will pay
    JButton restartTransactionBtn = new JButton(); // User will restart transaction, Empty Receipt Array
    JButton viewReceiptBtn = new JButton(); // Pops out a receipt for the user
    JButton closeReceiptBtn = new JButton(); // Closes Receipt Pop Up
    JTextField userInputMoney = new JTextField(12);
    JTextField getUserInputMoneyAmt = new JTextField(12);

    // More Maintenance Buttons
    JButton addStocksMaintenanceBtn = new JButton();
    JButton changePriceMaintenanceBtn = new JButton();
    JButton transactionSummaryMaintenanceBtn = new JButton();
    JButton submitNewItemPriceBtn = new JButton(); // Submits the users new price input and item choice
    JTextField newItemPriceInputTF = new JTextField(12);
    JTextField newItemPriceTypeTF = new JTextField(12);
    JTextField newStockAmtTF = new JTextField(12);
    JTextField newItemToStockTF = new JTextField(12);
    JButton submitRestockBtn = new JButton();

    // Special Vending Machine Buttons
    JButton specialChocoSBtn = new JButton();
    JButton specialCaramelSBtn = new JButton();
    JButton specialMilkSBtn = new JButton();
    JButton specialFinalizePurchase = new JButton();
    JButton thankYouBtn = new JButton();

    public VMview() {
        this.mainFrame = new JFrame("Vending Machine - O'NEIL");
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon vmTitle = new ImageIcon("MachineTitle.png");
        this.title = new JLabel();
        title.setIcon(vmTitle);

        setPanel(this.header);
        setPanel(this.center);
        setPanel(this.bottom);

        // Set Buttons
        ImageIcon createMachine = new ImageIcon("CreateMachineBtn.png");
        this.createMachineBtn.setIcon(createMachine);
        setButton(createMachineBtn);
        this.center.add(createMachineBtn);

        ImageIcon accessTestMenu = new ImageIcon("AccessTestMenuBtn.png");
        this.accessTestMenuBtn.setIcon(accessTestMenu);
        setButton(accessTestMenuBtn);
        this.center.add(accessTestMenuBtn);

        ImageIcon exitProrgam = new ImageIcon("ExitProgramBtn.png");
        this.exitProgramBtn.setIcon(exitProrgam);
        setButton(exitProgramBtn);
        this.center.add(exitProgramBtn);

        // Extra Designs
        JLabel froyo = new JLabel();
        ImageIcon froyoDesign = new ImageIcon("FroyoDesign.png");
        froyo.setIcon(froyoDesign);
        this.bottom.add(froyo);

        this.header.add(title);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }

    public void makeNotif(String text) {
        // making a notification clas that can notify the user of something
        JOptionPane.showMessageDialog(null, text, "Fro-yo Friend!", JOptionPane.DEFAULT_OPTION);
    }
    public void setPanel(JPanel panel) {
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.decode("#001440"));
    }
    public void setButton(JButton button) {
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
    }
    public void setLabel(JLabel label) {
        label.setForeground(Color.decode("#FFFBD7"));
        label.setBackground(Color.decode("#001440"));
        label.setFont(new Font("Verdana", Font.BOLD, 18));
    }
    public void clearNewItemPriceInputTF() { this.newItemPriceInputTF.setText(""); }
    public String getNewItemPriceInputTF() { return this.newItemPriceInputTF.getText(); }
    public void clearNewItemPriceTypeTF() { this.newItemPriceTypeTF.setText(""); }
    public String getNewItemPriceTypeInputTF() { return this.newItemPriceTypeTF.getText(); }
    public void clearNewStockAmtTF() { this.newStockAmtTF.setText(""); }
    public String getNewStockAmtTF() { return this.newStockAmtTF.getText(); }
    public void clearItemToStockTF() { this.newItemToStockTF.setText(""); }
    public String getItemToStockTF() { return this.newItemToStockTF.getText(); }
    public void clearDenomTypeTF() {
        this.denominationType.setText("");
    }
    public String getDenomTypeText() { return this.denominationType.getText(); }
    public void clearAmtDenomTypeTF() {
        this.amtOfDenomination.setText("");
    }
    public String getDenomAmtText() { return this.amtOfDenomination.getText(); }
    public String getUserInputMoney() { return this.userInputMoney.getText(); }
    public void clearUserInputMoney() { this.userInputMoney.setText(""); }
    public String getUserAmountInput() { return this.getUserInputMoneyAmt.getText(); }
    public void clearUserAmountInput() { this.getUserInputMoneyAmt.setText(""); }
    public void disposeRecieptFrame() { this.receiptUser.dispose(); }
    public int getCurrentRegItem() { return this.currentRegItemInt; }
    public void setCurrentRegItem(int index) { this.currentRegItemInt = index;}
    public void enableOtherButtons() {
        VYBtn.setEnabled(true);
        CYBtn.setEnabled(true);
        SYBtn.setEnabled(true);
        CMBtn.setEnabled(true);
        BBtn.setEnabled(true);
        KKBtn.setEnabled(true);
        CSBtn.setEnabled(true);
        CBtn.setEnabled(true);
    }
    public void disableOtherButtons() {
        VYBtn.setEnabled(false);
        CYBtn.setEnabled(false);
        SYBtn.setEnabled(false);
        CMBtn.setEnabled(false);
        BBtn.setEnabled(false);
        KKBtn.setEnabled(false);
        CSBtn.setEnabled(false);
        CBtn.setEnabled(false);
    }
    public void resetFrame() {
        this.header.removeAll();
        this.center.removeAll();
        this.bottom.removeAll();

        this.bottom = new JPanel(new FlowLayout());
        this.center = new JPanel(new FlowLayout());
        this.header = new JPanel(new FlowLayout());

        this.header.setBackground(Color.decode("#001440"));
        this.bottom.setBackground(Color.decode("#001440"));
        this.center.setBackground(Color.decode("#001440"));
    }
    public void typeMachineMenu() {
        // accessed using the createMachine button
        resetFrame();

        ImageIcon choose = new ImageIcon("ChooseTypeHeader.png");
        this.title = new JLabel(choose);

        ImageIcon regular = new ImageIcon("RegularVendingMachineBtn.png");
        ImageIcon special = new ImageIcon("SpecialVendingMachineBtn.png");
        ImageIcon bottomImg = new ImageIcon("BottomDesign.png");

        this.regMenuChoiceBtn.setIcon(regular);
        this.specMenuChoiceBtn.setIcon(special);
        setButton(regMenuChoiceBtn);
        setButton(specMenuChoiceBtn);

        JLabel bottomDesign = new JLabel();
        bottomDesign.setIcon(bottomImg);

        ImageIcon returnMMBtnImg = new ImageIcon("ReturnMainMenuBtn.png");
        this.returnMMBtn.setIcon(returnMMBtnImg);
        setButton(returnMMBtn);

        this.header.add(title);
        this.center.add(regMenuChoiceBtn);
        this.center.add(specMenuChoiceBtn);
        this.center.add(returnMMBtn);
        this.bottom.add(bottomDesign);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void mainMenuOpen() {
        resetFrame();

        ImageIcon vmTitle = new ImageIcon("MachineTitle.png");
        this.title = new JLabel();
        title.setIcon(vmTitle);

        setPanel(this.header);
        setPanel(this.center);
        setPanel(this.bottom);

        // Set Buttons
        ImageIcon createMachine = new ImageIcon("CreateMachineBtn.png");
        this.createMachineBtn.setIcon(createMachine);
        setButton(createMachineBtn);
        this.center.add(createMachineBtn);

        ImageIcon accessTestMenu = new ImageIcon("AccessTestMenuBtn.png");
        this.accessTestMenuBtn.setIcon(accessTestMenu);
        setButton(accessTestMenuBtn);
        this.center.add(accessTestMenuBtn);

        ImageIcon exitProrgam = new ImageIcon("ExitProgramBtn.png");
        this.exitProgramBtn.setIcon(exitProrgam);
        setButton(exitProgramBtn);
        this.center.add(exitProgramBtn);

        // Extra Designs
        JLabel froyo = new JLabel();
        ImageIcon froyoDesign = new ImageIcon("FroyoDesign.png");
        froyo.setIcon(froyoDesign);
        this.bottom.add(froyo);

        this.header.add(title);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void testingFeaturesMenu() {
        // accessed using the accessTestMenu button
        resetFrame();
        ImageIcon testingTitleImg = new ImageIcon("TestingFeaturesTitle.png");
        ImageIcon simulationMenuImg = new ImageIcon("SimulationMenuOpenBtn.png");
        ImageIcon maintenanceMenuImg = new ImageIcon("MaintenanceMenuOpenBtn.png");
        ImageIcon bottomDesigns = new ImageIcon("FroyoDesign.png");
        ImageIcon returnMMBtnImg = new ImageIcon("ReturnMainMenuBtn.png");

        setPanel(header);
        setPanel(center);
        setPanel(bottom);

        this.title = new JLabel(testingTitleImg);

        this.simulationMenuOpen.setIcon(simulationMenuImg);
        this.maintenanceMenuOpen.setIcon(maintenanceMenuImg);
        setButton(simulationMenuOpen);
        setButton(maintenanceMenuOpen);

        JLabel bottomFroyo = new JLabel();
        bottomFroyo.setIcon(bottomDesigns);

        this.returnMMBtn.setIcon(returnMMBtnImg);
        setButton(returnMMBtn);

        this.header.add(title);
        this.center.add(simulationMenuOpen);
        this.center.add(maintenanceMenuOpen);
        this.center.add(returnMMBtn);
        this.bottom.add(bottomFroyo);

        this.header.add(title);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void maintenanceFeaturesMenu() {
        // accessed using the maintenanceMenuOpen button
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);

        ImageIcon maintenanceMenuTitle = new ImageIcon("MaintenanceMenuTitle.png");
        ImageIcon accessMoneyMenuImg = new ImageIcon("AddMoneyMenuBtn.png");
        ImageIcon returnTMBtnImg = new ImageIcon("ReturnTestMenuBtn.png");
        ImageIcon changeItemPriceImg = new ImageIcon("ChangeItemPriceBtn.png");
        ImageIcon restockItemImg = new ImageIcon("RestockItemBtn.png");
        ImageIcon transactionHisImg = new ImageIcon("TransactionSummaryBtn.png");
        ImageIcon froyoBottomImg = new ImageIcon("FroyoDesign.png");

        this.title = new JLabel(maintenanceMenuTitle);

        this.accessMoneyMenuBtn.setIcon(accessMoneyMenuImg);
        setButton(accessMoneyMenuBtn);
        this.changePriceMaintenanceBtn.setIcon(changeItemPriceImg);
        setButton(changePriceMaintenanceBtn);
        this.addStocksMaintenanceBtn.setIcon(restockItemImg);
        setButton(addStocksMaintenanceBtn);
        this.transactionSummaryMaintenanceBtn.setIcon(transactionHisImg);
        this.returnTMBtn.setIcon(returnTMBtnImg);
        setButton(returnTMBtn);

        JLabel froyoDesign = new JLabel(froyoBottomImg);

        this.header.add(title);
        this.center.add(accessMoneyMenuBtn);
        this.center.add(changePriceMaintenanceBtn);
        this.center.add(addStocksMaintenanceBtn);
        this.center.add(returnTMBtn);
        this.bottom.add(froyoDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void simulationFeaturesMenu(double userMoney, double userBill, int stock1, int stock2, int stock3, int stock4, int stock5, int stock6, int stock7, int stock8) {
        // accessed using the simulationMenuOpen button
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        this.center.setLayout(new BorderLayout());

        JPanel left = new JPanel(new GridLayout(4,2, 1,1));
        left.setFocusable(false);
        left.setBackground(Color.decode("#001440"));
        JPanel right = new JPanel(new GridLayout(5, 1, 1, 1));
        right.setFocusable(false);
        right.setBackground(Color.decode("#001440"));

        ImageIcon simulationTitle = new ImageIcon("SimulationTitle.png");
        ImageIcon simulationBottom = new ImageIcon("SimulationBottomDesign.png");
        ImageIcon vanillaYogurt = new ImageIcon("VanillaYogurtBtn.png");
        ImageIcon chocoYogurt = new ImageIcon("ChocoYogurtBtn.png");
        ImageIcon strawberryYogurt = new ImageIcon("StrawberryYogurtBtn.png");
        ImageIcon cupMangoes = new ImageIcon("CupMangoesBtn.png");
        ImageIcon cheesecake = new ImageIcon("CheesecakeSliceBtn.png");
        ImageIcon kitKats = new ImageIcon("KitKatBtn.png");
        ImageIcon banana = new ImageIcon("BananaBtn.png");
        ImageIcon cereal = new ImageIcon("CerealBtn.png");
        ImageIcon dispenseChange = new ImageIcon("DispenseChangeBtn.png");
        ImageIcon addPayment = new ImageIcon("AddPaymentBtn.png");
        ImageIcon returnTM = new ImageIcon("ReturnTestMenuBtn.png");
        ImageIcon finalizePurch = new ImageIcon("FinalizePurchaseBtn.png");
        ImageIcon restartTransac = new ImageIcon("RestartTransactionBtn.png");
        ImageIcon viewReceiptImg = new ImageIcon("ViewReceiptBtn.png");

        this.title = new JLabel(simulationTitle);

        JPanel slot1 = new JPanel(new GridLayout(2,1));
        slot1.setBackground(Color.decode("#001440"));
        this.VYBtn.setIcon(vanillaYogurt);
        setButton(VYBtn);
        slot1.add(VYBtn);
        JLabel s1 = new JLabel("Stock: " + stock1);
        setLabel(s1);
        slot1.add(s1);

        JPanel slot2 = new JPanel(new GridLayout(2, 1));
        slot2.setBackground(Color.decode("#001440"));
        this.CYBtn.setIcon(chocoYogurt);
        setButton(CYBtn);
        slot2.add(CYBtn);
        JLabel s2 = new JLabel("Stock: " + stock2);
        setLabel(s2);
        slot2.add(s2);

        JPanel slot3 = new JPanel(new GridLayout(2,1));
        slot3.setBackground(Color.decode("#001440"));
        this.SYBtn.setIcon(strawberryYogurt);
        setButton(SYBtn);
        slot3.add(SYBtn);
        JLabel s3 = new JLabel("Stock: " + stock3);
        setLabel(s3);
        slot3.add(s3);

        JPanel slot4 = new JPanel(new GridLayout(2,1));
        slot4.setBackground(Color.decode("#001440"));
        this.CMBtn.setIcon(cupMangoes);
        setButton(CMBtn);
        slot4.add(CMBtn);
        JLabel s4 = new JLabel("Stock: " + stock4);
        setLabel(s4);
        slot4.add(s4);

        JPanel slot5 = new JPanel(new GridLayout(2,1));
        slot5.setBackground(Color.decode("#001440"));
        this.CSBtn.setIcon(cheesecake);
        setButton(CSBtn);
        slot5.add(CSBtn);
        JLabel s5 = new JLabel("Stock: " + stock5);
        setLabel(s5);
        slot5.add(s5);

        JPanel slot6 = new JPanel(new GridLayout(2,1));
        slot6.setBackground(Color.decode("#001440"));
        this.KKBtn.setIcon(kitKats);
        setButton(KKBtn);
        slot6.add(KKBtn);
        JLabel s6 = new JLabel("Stock: " + stock6);
        setLabel(s6);
        slot6.add(s6);

        JPanel slot7 = new JPanel(new GridLayout(2,1));
        slot7.setBackground(Color.decode("#001440"));
        this.BBtn.setIcon(banana);
        setButton(BBtn);
        slot7.add(BBtn);
        JLabel s7 = new JLabel("Stock: " + stock7);
        setLabel(s7);
        slot7.add(s7);

        JPanel slot8 = new JPanel(new GridLayout(2,1));
        slot8.setBackground(Color.decode("#001440"));
        this.CBtn.setIcon(cereal);
        setButton(CBtn);
        slot8.add(CBtn);
        JLabel s8 = new JLabel("Stock: " + stock8);
        setLabel(s8);
        slot8.add(s8);

        JLabel bottomDesign = new JLabel(simulationBottom);
        JLabel inputPrompt = new JLabel("Denomination To Insert: ");
        setLabel(inputPrompt);
        JLabel inputAmtPrompt = new JLabel("Amount To Insert: ");
        setLabel(inputAmtPrompt);
        this.userInputMoney.setBackground(Color.decode("#FFFBD7"));
        this.userInputMoney.setPreferredSize(new Dimension(250, 35));
        this.userInputMoney.setFont(new Font("Verdana", Font.BOLD, 20));

        this.getUserInputMoneyAmt.setBackground(Color.decode("#FFFBD7"));
        this.getUserInputMoneyAmt.setPreferredSize(new Dimension(250, 35));
        this.getUserInputMoneyAmt.setFont(new Font("Verdana", Font.BOLD, 20));

        JPanel input1 = new JPanel();
        setPanel(input1);
        input1.add(inputPrompt);
        input1.add(userInputMoney);
        JPanel input2 = new JPanel();
        input2.add(inputAmtPrompt);
        input2.add(getUserInputMoneyAmt);
        setPanel(input2);

        JLabel totalUserBill = new JLabel("               Sum Total: " + userBill);
        setLabel(totalUserBill);

        JLabel totalUserMoney = new JLabel("              Money In Machine: " + userMoney);
        setLabel(totalUserMoney);

        this.addPaymentBtn.setIcon(addPayment);
        setButton(addPaymentBtn);

        this.dispenseChangeBtn.setIcon(dispenseChange);
        setButton(dispenseChangeBtn);

        this.returnTMBtn.setIcon(returnTM);
        setButton(returnTMBtn);

        this.restartTransactionBtn.setIcon(restartTransac);
        setButton(restartTransactionBtn);

        this.finalizePurchaseBtn.setIcon(finalizePurch);
        setButton(finalizePurchaseBtn);

        this.viewReceiptBtn.setIcon(viewReceiptImg);
        setButton(viewReceiptBtn);

        this.header.add(title);

        left.add(slot1);
        left.add(slot2);
        left.add(slot3);
        left.add(slot4);
        left.add(slot5);
        left.add(slot6);
        left.add(slot7);
        left.add(slot8);

        right.add(input1);
        right.add(input2);
        right.add(addPaymentBtn);
        right.add(dispenseChangeBtn);
        right.add(returnTMBtn);

        this.bottom.add(bottomDesign);

        Border cream = BorderFactory.createLineBorder(Color.decode("#FFFBD7"));
        left.setBorder(cream);

        this.center.add(left, BorderLayout.WEST);
        this.center.add(right, BorderLayout.EAST);
        JPanel centerSquare = new JPanel(new GridLayout(6, 1));
        centerSquare.add(totalUserBill);
        centerSquare.add(totalUserMoney);
        centerSquare.add(restartTransactionBtn);
        centerSquare.add(finalizePurchaseBtn);
        centerSquare.add(viewReceiptBtn);
        setPanel(centerSquare);
        this.center.add(centerSquare, BorderLayout.CENTER);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void machineCashMenu(int denom1, int denom5, int denom10, int denom20, int denom50, int denom100, double totalMoney) {
        // accessed using the access money menu button
        resetFrame();

        ImageIcon cashMenuTitle = new ImageIcon("MachineCashTitle.png");
        ImageIcon denomPromptImg = new ImageIcon("DenominationLbl.png");
        ImageIcon amtDenomPromptImg = new ImageIcon("AmtDenominationLbl.png");
        ImageIcon bottomImg = new ImageIcon("BottomDesign.png");
        ImageIcon addMoneyImg = new ImageIcon("AddCashInputsBtn.png");
        ImageIcon collectMoneyImg = new ImageIcon("CollectIncomeBtn.png");
        ImageIcon returnTMImg = new ImageIcon("ReturnTestMenuBtn.png");

        this.title = new JLabel(cashMenuTitle);

        JLabel denominationPrompt = new JLabel();
        denominationPrompt.setIcon(denomPromptImg);
        JLabel amtDenomPrompt = new JLabel();
        amtDenomPrompt.setIcon(amtDenomPromptImg);

        this.denominationType.setBackground(Color.decode("#FFFBD7"));
        this.denominationType.setPreferredSize(new Dimension(1000, 50));
        this.denominationType.setFont(new Font("Verdana", Font.BOLD, 20));

        this.amtOfDenomination.setBackground(Color.decode("#FFFBD7"));
        this.amtOfDenomination.setPreferredSize(new Dimension(800, 50));
        this.amtOfDenomination.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel bottomDesign = new JLabel();
        bottomDesign.setIcon(bottomImg);

        setPanel(header);
        setPanel(center);
        setPanel(bottom);

        // Add Buttons
        this.addMoney.setIcon(addMoneyImg);
        this.collectMoney.setIcon(collectMoneyImg);
        this.returnTMBtn.setIcon(returnTMImg);
        setButton(returnTMBtn);
        setButton(addMoney);
        setButton(collectMoney);

        // Add Money in Machine View
        JLabel moneySummary = new JLabel();
        moneySummary.setFont(new Font("Verdana", Font.BOLD, 32));
        moneySummary.setForeground(Color.decode("#FFFBD7"));
        moneySummary.setBackground(Color.decode("#001440"));
        moneySummary.setText("<html>PHP 1 coins :  " + denom1 + " = " + denom1 + " PHP 5 coins : " + denom5 + " = " + (denom5 * 5) + " <br/>PHP 10 coins : "
                + denom10 + " = " + (denom10 * 10) + " PHP 20 bills : " + denom20 + " = " + (denom20 * 20) + " <br/>PHP 50 bills : "
                + denom50 + " = " + (denom50 * 50) + " PHP 100 bills : "  + denom100 + " = " + (denom100 * 100) + " <br/>TOTAL: " + totalMoney);

        this.header.add(title);
        this.center.add(denominationPrompt);
        this.center.add(denominationType);
        this.center.add(amtDenomPrompt);
        this.center.add(amtOfDenomination);
        this.center.add(addMoney);
        this.center.add(collectMoney);
        this.center.add(returnTMBtn);
        this.center.add(moneySummary);
        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void receiptPopUp(Receipt receipt) {
        this.receiptUser = new JFrame("Receipt");
        receiptUser.setPreferredSize(new Dimension(800, 800));
        receiptUser.setBackground(Color.decode("#001400"));
        receiptUser.setLayout(new BorderLayout());
        receiptUser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel centerSquare = new JPanel();
        setPanel(centerSquare);
        JPanel headerSquare = new JPanel();
        setPanel(headerSquare);

        JTextArea receiptInfo = new JTextArea(10, 20);
        receiptInfo.setFont(new Font("Verdana", Font.PLAIN, 12));
        receiptInfo.setForeground(Color.decode("#001440"));
        receiptInfo.setEditable(false);
        receiptInfo.setLineWrap(true);

        JScrollPane receiptProper = new JScrollPane(receiptInfo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        receiptProper.setFont(new Font("Verdana", Font.PLAIN, 16));
        receiptProper.setSize(700, 500);

        for(int i = 0; i < receipt.getUserReceipt().size(); i++)
        {
            if (i == 0) {
                receiptInfo.setText("#"+(i+1)+" : "+receipt.getUserReceipt().get(i).getItemName()+" Calories : " + receipt.getUserReceipt().get(i).getCalories() + " Price : PHP " + receipt.getUserReceipt().get(i).getItemPrice() + "***********");
            }
            else {
                receiptInfo.append("#"+(i+1)+" : "+receipt.getUserReceipt().get(i).getItemName()+" Calories : " + receipt.getUserReceipt().get(i).getCalories() + " Price : PHP " + receipt.getUserReceipt().get(i).getItemPrice() + "***********");

            }
        }

        ImageIcon receiptTitle = new ImageIcon("UserReceipt.png");
        JLabel receiptHeader = new JLabel();
        receiptHeader.setIcon(receiptTitle);

        ImageIcon closeReceiptImg = new ImageIcon("CloseReceiptBtn.png");
        this.closeReceiptBtn.setIcon(closeReceiptImg);
        setButton(closeReceiptBtn);

        centerSquare.add(receiptProper);
        centerSquare.add(closeReceiptBtn);
        headerSquare.add(receiptHeader);

        receiptUser.add(headerSquare, BorderLayout.NORTH);
        receiptUser.add(centerSquare, BorderLayout.CENTER);
        receiptUser.setVisible(true);
    }

    // More Maintenance
    public void changeItemPriceMaintenanceMenu(double price1, double price2, double price3, double price4, double price5, double price6, double price7, double price8) {
        resetFrame();
        setPanel(header);
        setPanel(center);
        this.center.setLayout(new BorderLayout());
        setPanel(bottom);

        ImageIcon changePriceTitle = new ImageIcon("ChangeItemPriceTitle.png");
        ImageIcon returmTMBtnImg = new ImageIcon("ReturnTestMenuBtn.png");
        ImageIcon submitNewPriceImg = new ImageIcon("SubmitNewPriceBtn.png");
        ImageIcon froyoBottomImg = new ImageIcon("FroyoBottomDesign.png");

        this.title = new JLabel(changePriceTitle);

        JLabel newPricePrompt = new JLabel("New Price: ");
        setLabel(newPricePrompt);

        JLabel newPriceItemChoice = new JLabel("Item to Update: ");
        setLabel(newPriceItemChoice);

        this.submitNewItemPriceBtn.setIcon(submitNewPriceImg);
        setButton(submitNewItemPriceBtn);

        this.returnTMBtn.setIcon(returmTMBtnImg);
        setButton(returnTMBtn);

        JLabel bottomDesign = new JLabel(froyoBottomImg);

        // ITEM BUTTONS DISPLAY =========================================================================================

        JPanel buttonDisplay = new JPanel(new GridLayout(4, 2,1,1));
        buttonDisplay.setFocusable(false);
        buttonDisplay.setBackground(Color.decode("#001440"));

        ImageIcon vy = new ImageIcon("VanillaYogurtBtn.png");
        ImageIcon cy = new ImageIcon("ChocoYogurtBtn.png");
        ImageIcon sy = new ImageIcon("StrawberryYogurtBtn.png");
        ImageIcon cm = new ImageIcon("CupMangoesBtn.png");
        ImageIcon b = new ImageIcon("BananaBtn.png");
        ImageIcon k = new ImageIcon("KitkatBtn.png");
        ImageIcon cs = new ImageIcon("CheesecakeSliceBtn.png");
        ImageIcon c = new ImageIcon("CerealBtn.png");

        // VANILLA YOGURT
        JPanel slot1 = new JPanel(new GridLayout(2,1));
        JLabel p1 = new JLabel(vy);
        JLabel s1 = new JLabel("ITEM #1 - Price :" + price1);
        setLabel(s1);
        slot1.add(p1);
        slot1.add(s1);
        setPanel(slot1);

        // CHOCO YOGURT
        JPanel slot2 = new JPanel(new GridLayout(2,1));
        JLabel p2 = new JLabel(cy);
        JLabel s2 = new JLabel("ITEM #2 - Price :" + price2);
        setLabel(s2);
        slot2.add(p2);
        slot2.add(s2);
        setPanel(slot2);

        // STRAWBERRY YOGURT
        JPanel slot3 = new JPanel(new GridLayout(2,1));
        JLabel p3 = new JLabel(sy);
        JLabel s3 = new JLabel("ITEM #3 - Price :" + price3);
        setLabel(s3);
        slot3.add(p3);
        slot3.add(s3);
        setPanel(slot3);

        // CUP MANGOES
        JPanel slot4 = new JPanel(new GridLayout(2,1));
        JLabel p4 = new JLabel(cm);
        JLabel s4 = new JLabel("ITEM #4 - Price :" + price4);
        setLabel(s4);
        slot4.add(p4);
        slot4.add(s4);
        setPanel(slot4);

        // CHEESECAKE
        JPanel slot5 = new JPanel(new GridLayout(2,1));
        JLabel p5 = new JLabel(cs);
        JLabel s5 = new JLabel("ITEM #5 - Price :" + price5);
        setLabel(s5);
        slot5.add(p5);
        slot5.add(s5);
        setPanel(slot5);

        // KITKAT
        JPanel slot6 = new JPanel(new GridLayout(2,1));
        JLabel p6 = new JLabel(k);
        JLabel s6 = new JLabel("ITEM #6 - Price :" + price6);
        setLabel(s6);
        slot6.add(p6);
        slot6.add(s6);
        setPanel(slot6);

        // BANANA
        JPanel slot7 = new JPanel(new GridLayout(2,1));
        JLabel p7 = new JLabel(b);
        JLabel s7 = new JLabel("ITEM #7 - Price :" + price7);
        setLabel(s7);
        slot7.add(p7);
        slot7.add(s7);
        setPanel(slot7);

        // CEREAL
        JPanel slot8 = new JPanel(new GridLayout(2,1));
        JLabel p8 = new JLabel(c);
        JLabel s8 = new JLabel("ITEM #8 - Price :" + price8);
        setLabel(s8);
        slot8.add(p8);
        slot8.add(s8);
        setPanel(slot8);

        // ==============================================================================================================

        JPanel right = new JPanel(new GridLayout(4,1,1,1));
        right.setFocusable(false);
        right.setBackground(Color.decode("#001440"));

        JPanel prompt1 = new JPanel(new GridLayout(1, 2));
        setPanel(prompt1);
        prompt1.add(newPricePrompt);
        prompt1.add(newItemPriceInputTF);

        JPanel prompt2 = new JPanel(new GridLayout(1, 2));
        setPanel(prompt2);
        prompt2.add(newPriceItemChoice);
        prompt2.add(newItemPriceTypeTF);

        this.newItemPriceInputTF.setBackground(Color.decode("#FFFBD7"));
        this.newItemPriceInputTF.setPreferredSize(new Dimension(400, 40));
        this.newItemPriceInputTF.setFont(new Font("Verdana", Font.BOLD, 20));

        this.newItemPriceTypeTF.setBackground(Color.decode("#FFFBD7"));
        this.newItemPriceTypeTF.setPreferredSize(new Dimension(400, 40));
        this.newItemPriceTypeTF.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel arrowSpacer = new JLabel("=>");
        setLabel(arrowSpacer);

        this.header.add(title);

        right.add(prompt1);
        right.add(prompt2);
        right.add(submitNewItemPriceBtn);
        right.add(returnTMBtn);

        buttonDisplay.add(slot1);
        buttonDisplay.add(slot2);
        buttonDisplay.add(slot3);
        buttonDisplay.add(slot4);
        buttonDisplay.add(slot5);
        buttonDisplay.add(slot6);
        buttonDisplay.add(slot7);
        buttonDisplay.add(slot8);

        Border cream = BorderFactory.createLineBorder(Color.decode("#FFFBD7"));
        buttonDisplay.setBorder(cream);

        this.center.add(right, BorderLayout.EAST);
        this.center.add(buttonDisplay, BorderLayout.WEST);
        JPanel centerSquare = new JPanel(new GridLayout(1,1,1,1));
        centerSquare.add(arrowSpacer);
        setPanel(centerSquare);
        this.center.add(centerSquare, BorderLayout.CENTER);

        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void restockItemMaintenanceMenu(int stock1, int stock2, int stock3, int stock4, int stock5, int stock6, int stock7, int stock8) {
        resetFrame();
        setPanel(header);
        setPanel(center);
        this.center.setLayout(new BorderLayout());
        setPanel(bottom);

        ImageIcon restockTitle = new ImageIcon("RestockItemTitle.png");
        ImageIcon returmTMBtnImg = new ImageIcon("ReturnTestMenuBtn.png");
        ImageIcon submitRestockImg = new ImageIcon("RestockBtn.png");
        ImageIcon froyoBottomImg = new ImageIcon("FroyoBottomDesign.png");

        this.title = new JLabel(restockTitle);
        setLabel(title);

        JLabel newPricePrompt = new JLabel("Amount to Stock: ");
        setLabel(newPricePrompt);

        JLabel newPriceItemChoice = new JLabel("Item to Stock: ");
        setLabel(newPriceItemChoice);

        this.submitRestockBtn.setIcon(submitRestockImg);
        setButton(submitRestockBtn);

        this.returnTMBtn.setIcon(returmTMBtnImg);
        setButton(returnTMBtn);

        JLabel bottomDesign = new JLabel(froyoBottomImg);

        // ITEM BUTTONS DISPLAY =========================================================================================

        JPanel buttonDisplay = new JPanel(new GridLayout(4, 2,1,1));
        buttonDisplay.setFocusable(false);
        buttonDisplay.setBackground(Color.decode("#001440"));

        ImageIcon vy = new ImageIcon("VanillaYogurtBtn.png");
        ImageIcon cy = new ImageIcon("ChocoYogurtBtn.png");
        ImageIcon sy = new ImageIcon("StrawberryYogurtBtn.png");
        ImageIcon cm = new ImageIcon("CupMangoesBtn.png");
        ImageIcon b = new ImageIcon("BananaBtn.png");
        ImageIcon k = new ImageIcon("KitkatBtn.png");
        ImageIcon cs = new ImageIcon("CheesecakeSliceBtn.png");
        ImageIcon c = new ImageIcon("CerealBtn.png");

        // VANILLA YOGURT
        JPanel slot1 = new JPanel(new GridLayout(2,1));
        JLabel p1 = new JLabel(vy);
        JLabel s1 = new JLabel("ITEM #1 - STOCK :" + stock1);
        setLabel(s1);
        slot1.add(p1);
        slot1.add(s1);
        setPanel(slot1);

        // CHOCO YOGURT
        JPanel slot2 = new JPanel(new GridLayout(2,1));
        JLabel p2 = new JLabel(cy);
        JLabel s2 = new JLabel("ITEM #2 - STOCK :" + stock2);
        setLabel(s2);
        slot2.add(p2);
        slot2.add(s2);
        setPanel(slot2);

        // STRAWBERRY YOGURT
        JPanel slot3 = new JPanel(new GridLayout(2,1));
        JLabel p3 = new JLabel(sy);
        JLabel s3 = new JLabel("ITEM #3 - STOCK :" + stock3);
        setLabel(s3);
        slot3.add(p3);
        slot3.add(s3);
        setPanel(slot3);

        // CUP MANGOES
        JPanel slot4 = new JPanel(new GridLayout(2,1));
        JLabel p4 = new JLabel(cm);
        JLabel s4 = new JLabel("ITEM #4 - STOCK :" + stock4);
        setLabel(s4);
        slot4.add(p4);
        slot4.add(s4);
        setPanel(slot4);

        // CHEESECAKE
        JPanel slot5 = new JPanel(new GridLayout(2,1));
        JLabel p5 = new JLabel(cs);
        JLabel s5 = new JLabel("ITEM #5 - STOCK :" + stock5);
        setLabel(s5);
        slot5.add(p5);
        slot5.add(s5);
        setPanel(slot5);

        // KITKAT
        JPanel slot6 = new JPanel(new GridLayout(2,1));
        JLabel p6 = new JLabel(k);
        JLabel s6 = new JLabel("ITEM #6 - STOCK :" + stock6);
        setLabel(s6);
        slot6.add(p6);
        slot6.add(s6);
        setPanel(slot6);

        // BANANA
        JPanel slot7 = new JPanel(new GridLayout(2,1));
        JLabel p7 = new JLabel(b);
        JLabel s7 = new JLabel("ITEM #7 - STOCK :" + stock7);
        setLabel(s7);
        slot7.add(p7);
        slot7.add(s7);
        setPanel(slot7);

        // CEREAL
        JPanel slot8 = new JPanel(new GridLayout(2,1));
        JLabel p8 = new JLabel(c);
        JLabel s8 = new JLabel("ITEM #8 - STOCK :" + stock8);
        setLabel(s8);
        slot8.add(p8);
        slot8.add(s8);
        setPanel(slot8);

        // ==============================================================================================================

        JPanel right = new JPanel(new GridLayout(4,1,1,1));
        right.setFocusable(false);
        right.setBackground(Color.decode("#001440"));

        JPanel prompt1 = new JPanel(new GridLayout(1, 2));
        setPanel(prompt1);
        prompt1.add(newPricePrompt);
        prompt1.add(newStockAmtTF);

        JPanel prompt2 = new JPanel(new GridLayout(1, 2));
        setPanel(prompt2);
        prompt2.add(newPriceItemChoice);
        prompt2.add(newItemToStockTF);

        this.newStockAmtTF.setBackground(Color.decode("#FFFBD7"));
        this.newStockAmtTF.setPreferredSize(new Dimension(400, 40));
        this.newStockAmtTF.setFont(new Font("Verdana", Font.BOLD, 20));

        this.newItemToStockTF.setBackground(Color.decode("#FFFBD7"));
        this.newItemToStockTF.setPreferredSize(new Dimension(400, 40));
        this.newItemToStockTF.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel arrowSpacer = new JLabel("=>");
        setLabel(arrowSpacer);

        this.header.add(title);

        right.add(prompt1);
        right.add(prompt2);
        right.add(submitRestockBtn);
        right.add(returnTMBtn);

        buttonDisplay.add(slot1);
        buttonDisplay.add(slot2);
        buttonDisplay.add(slot3);
        buttonDisplay.add(slot4);
        buttonDisplay.add(slot5);
        buttonDisplay.add(slot6);
        buttonDisplay.add(slot7);
        buttonDisplay.add(slot8);

        Border cream = BorderFactory.createLineBorder(Color.decode("#FFFBD7"));
        buttonDisplay.setBorder(cream);

        this.center.add(right, BorderLayout.EAST);
        this.center.add(buttonDisplay, BorderLayout.WEST);
        JPanel centerSquare = new JPanel(new GridLayout(1,1,1,1));
        centerSquare.add(arrowSpacer);
        setPanel(centerSquare);
        this.center.add(centerSquare, BorderLayout.CENTER);

        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }
    public void transactionSummaryMaintenanceMenu(ArrayList initialStock, ArrayList currentStock) {
        resetFrame();
        setPanel(header);
        setPanel(bottom);
        this.center.setLayout(new BorderLayout());

        ImageIcon titleTS = new ImageIcon("TransactionSummaryTitle.png");
        ImageIcon froyoLogo = new ImageIcon("FroyoLogo.png");
        ImageIcon bottomDesign = new ImageIcon("FroyoBottomDesign.png");

        this.title = new JLabel(titleTS);

        JLabel logo = new JLabel(froyoLogo);
        JLabel bot = new JLabel(bottomDesign);

        JTextArea initialTA = new JTextArea(initialStock.toString());
        initialTA.setLineWrap(true);
        initialTA.setEditable(false);
        JScrollPane initialSP = new JScrollPane(initialTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JTextArea currentTA = new JTextArea(currentStock.toString());
        currentTA.setEditable(false);
        currentTA.setLineWrap(false);
        JScrollPane currentSP = new JScrollPane(currentTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        this.header.add(title);
        this.center.add(initialSP, BorderLayout.WEST);
        this.center.add(logo, BorderLayout.CENTER);
        this.center.add(currentSP, BorderLayout.EAST);
        this.bottom.add(bot);
    }

    // SPECIAL VENDING MACHINE MENUS
    public void specialChooseFlavorMenu(int stock1, int stock2, int stock3) {
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        this.center.setLayout(new GridLayout(3, 1));

        ImageIcon flavorTitle = new ImageIcon("SVMChooseFlavorTitle.png");
        ImageIcon vy = new ImageIcon("VanillaYogurtBtn.png");
        ImageIcon cy = new ImageIcon("ChocoYogurtBtn.png");
        ImageIcon sy = new ImageIcon("StrawberryYogurtBtn.png");
        ImageIcon bottomDes = new ImageIcon("BottomFroyo.png");

        this.title.setIcon(flavorTitle);
        setLabel(title);

        this.VYBtn.setIcon(vy);
        setButton(VYBtn);
        this.CYBtn.setIcon(cy);
        setButton(CYBtn);
        this.SYBtn.setIcon(sy);
        setButton(SYBtn);

        JLabel bottomDesign = new JLabel(bottomDes);

        JPanel optionsPanel = new JPanel(new GridLayout(6, 1));
        setPanel(optionsPanel);

        JLabel s1 = new JLabel("Stock : " + stock1);
        setLabel(s1);

        JLabel s2 = new JLabel("Stock : " + stock2);
        setLabel(s2);

        JLabel s3 = new JLabel("Stock : " + stock3);
        setLabel(s3);

        optionsPanel.add(VYBtn);
        optionsPanel.add(s1);
        optionsPanel.add(CYBtn);
        optionsPanel.add(s2);
        optionsPanel.add(SYBtn);
        optionsPanel.add(s3);

        this.header.add(title);
        this.center.add(optionsPanel, BorderLayout.CENTER);
        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottomDesign, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }

    public void specialChooseFruitMenu(int stock4, int stock5) {
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        this.center.setLayout(new GridLayout(2, 1));

        ImageIcon fruitTitle = new ImageIcon("SVMChooseFruitTitle.png");
        ImageIcon cm = new ImageIcon("CupMangoesBtn.png");
        ImageIcon b = new ImageIcon("BananaBtn.png");
        ImageIcon bottomDes = new ImageIcon("FroyoDesign.png");

        this.title.setIcon(fruitTitle);
        setLabel(title);

        this.CMBtn.setIcon(cm);
        setButton(CMBtn);
        this.BBtn.setIcon(b);
        setButton(BBtn);

        JLabel bottomDesign = new JLabel(bottomDes);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        setPanel(optionsPanel);

        JLabel s1 = new JLabel("Stock : " + stock4);
        setLabel(s1);

        JLabel s2 = new JLabel("Stock : " + stock5);
        setLabel(s2);

        optionsPanel.add(CMBtn);
        optionsPanel.add(s1);
        optionsPanel.add(BBtn);
        optionsPanel.add(s2);

        this.header.add(title);
        this.center.add(optionsPanel, BorderLayout.CENTER);
        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottomDesign, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }

    public void specialChooseSyrupMenu() {
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        this.center.setLayout(new GridLayout(3, 1));

        ImageIcon syrupTitle = new ImageIcon("SVMChooseSyrupTitle.png");
        ImageIcon chocos = new ImageIcon("ChocolateSyrupBtn.png");
        ImageIcon caramels = new ImageIcon("CaramelSyrupBtn.png");
        ImageIcon milks = new ImageIcon("MilkCerealSyrupBtn.png");
        ImageIcon bottomDes = new ImageIcon("FroyoDesign.png");

        this.title.setIcon(syrupTitle);
        setLabel(title);

        this.specialChocoSBtn.setIcon(chocos);
        setButton(specialChocoSBtn);
        this.specialCaramelSBtn.setIcon(caramels);
        setButton(specialCaramelSBtn);
        this.specialMilkSBtn.setIcon(milks);
        setButton(specialMilkSBtn);

        JLabel bottomDesign = new JLabel(bottomDes);

        JPanel optionsPanel = new JPanel(new GridLayout(3, 1));
        setPanel(optionsPanel);

        optionsPanel.add(specialChocoSBtn);
        optionsPanel.add(specialCaramelSBtn);
        optionsPanel.add(specialMilkSBtn);

        this.header.add(title);
        this.center.add(optionsPanel, BorderLayout.CENTER);
        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottomDesign, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }

    public void specialChooseExtraMenu(int stock6, int stock7, int stock8) {
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        this.center.setLayout(new GridLayout(2, 1));

        ImageIcon extraTitle = new ImageIcon("SVMChooseExtraTitle.png");
        ImageIcon cs = new ImageIcon("CheesecakeSliceBtn.png");
        ImageIcon kk = new ImageIcon("KitkatBtn.png");
        ImageIcon c = new ImageIcon("CerealBtn.png");
        ImageIcon bottomDes = new ImageIcon("FroyoDesign.png");

        this.title.setIcon(extraTitle);
        setLabel(title);

        this.CSBtn.setIcon(cs);
        setButton(CSBtn);
        this.KKBtn.setIcon(kk);
        setButton(KKBtn);
        this.CBtn.setIcon(c);
        setButton(CBtn);

        JLabel bottomDesign = new JLabel(bottomDes);

        JPanel optionsPanel = new JPanel(new GridLayout(6, 1));
        setPanel(optionsPanel);

        JLabel s1 = new JLabel("Stock : " + stock6);
        setLabel(s1);

        JLabel s2 = new JLabel("Stock : " + stock7);
        setLabel(s2);

        JLabel s3 = new JLabel("Stock : " + stock8);
        setLabel(s3);

        optionsPanel.add(CSBtn);
        optionsPanel.add(s1);
        optionsPanel.add(KKBtn);
        optionsPanel.add(s2);
        optionsPanel.add(CBtn);
        optionsPanel.add(s3);

        this.header.add(title);
        this.center.add(optionsPanel, BorderLayout.CENTER);
        this.bottom.add(bottomDesign);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottomDesign, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }

    public void specialFinalPurchaseScreen(Receipt userReceipt, double userMoney) {
        // user money, total bill, total calories
        // user final order (print from bill, print total calories)
        // cancel purchase button, return to test menu button, finalize purchase button
        // denomination, amount of denomination, submit money
        resetFrame();
        setPanel(header);
        setPanel(center);
        setPanel(bottom);
        center.setLayout(new BorderLayout());

        ImageIcon confirmPurchaseImg = new ImageIcon("SVMConfirmOrderTitle.png");
        ImageIcon dispenseChange = new ImageIcon("DispenseChangeBtn.png");
        ImageIcon addPayment = new ImageIcon("AddPaymentBtn.png");
        ImageIcon returnTM = new ImageIcon("ReturnTestMenuBtn.png");
        ImageIcon finalPurchase = new ImageIcon("FinalizePurchaseBtn.png");

        this.title = new JLabel(confirmPurchaseImg);
        setLabel(title);
        this.header.add(title);

        JLabel orderSign = new JLabel("**** FROYO ORDER ****");
        orderSign.setBackground(Color.decode("#001440"));
        orderSign.setForeground(Color.decode("#FFFBD7"));
        orderSign.setFont(new Font("Source Code Pro", Font.BOLD, 30));

        JLabel yogurtFlavor = new JLabel("Flavor: "  + userReceipt.getUserReceipt().get(0).getItemName());
        yogurtFlavor.setBackground(Color.decode("#001440"));
        yogurtFlavor.setForeground(Color.decode("#FFFBD7"));
        yogurtFlavor.setFont(new Font("Source Code Pro", Font.ITALIC, 22));

        JLabel fruitChoice = new JLabel("Fruit: " + userReceipt.getUserReceipt().get(1).getItemName());
        fruitChoice.setBackground(Color.decode("#001440"));
        fruitChoice.setForeground(Color.decode("#FFFBD7"));
        fruitChoice.setFont(new Font("Source Code Pro", Font.ITALIC, 22));

        JLabel extraChoice = new JLabel("Extra: " + userReceipt.getUserReceipt().get(2).getItemName());
        extraChoice.setBackground(Color.decode("#001440"));
        extraChoice.setForeground(Color.decode("#FFFBD7"));
        extraChoice.setFont(new Font("Source Code Pro", Font.ITALIC, 22));

        JLabel syrupChoice = new JLabel("Syrup: " + userReceipt.getUserReceipt().get(3).getItemName());
        syrupChoice.setBackground(Color.decode("#001440"));
        syrupChoice.setForeground(Color.decode("#FFFBD7"));
        syrupChoice.setFont(new Font("Source Code Pro", Font.ITALIC, 22));

        JLabel totalCalories = new JLabel("Total KCal: " + userReceipt.getTotalCalories());
        totalCalories.setBackground(Color.decode("#001440"));
        totalCalories.setForeground(Color.decode("#FFFBD7"));
        totalCalories.setFont(new Font("Source Code Pro", Font.ITALIC, 25));

        JLabel totalPrice = new JLabel("FINAL PRICE: " + userReceipt.getTotalBill());
        totalPrice.setBackground(Color.decode("#001440"));
        totalPrice.setForeground(Color.decode("#FFFBD7"));
        totalPrice.setFont(new Font("Source Code Pro", Font.BOLD, 25));

        JLabel border = new JLabel("*** FRO-YO FRIEND ***");
        border.setBackground(Color.decode("#001440"));
        border.setForeground(Color.decode("#FFFBD7"));
        border.setFont(new Font("Source Code Pro", Font.BOLD, 30));

        JPanel left = new JPanel(new GridLayout(8, 1,4,4));
        left.setFocusable(false);
        left.setBackground(Color.decode("#001440"));
        left.add(orderSign);
        left.add(yogurtFlavor);
        left.add(fruitChoice);
        left.add(extraChoice);
        left.add(syrupChoice);
        left.add(totalCalories);
        left.add(totalPrice);
        left.add(border);

        JLabel prompt1 = new JLabel("Denomination: ");
        setLabel(prompt1);
        JLabel prompt2 = new JLabel("Amt of Coin/Bill: ");
        setLabel(prompt2);

        this.userInputMoney.setBackground(Color.decode("#FFFBD7"));
        this.userInputMoney.setPreferredSize(new Dimension(250, 35));
        this.userInputMoney.setFont(new Font("Verdana", Font.BOLD, 20));

        this.getUserInputMoneyAmt.setBackground(Color.decode("#FFFBD7"));
        this.getUserInputMoneyAmt.setPreferredSize(new Dimension(250, 35));
        this.getUserInputMoneyAmt.setFont(new Font("Verdana", Font.BOLD, 20));

        JPanel input1 = new JPanel();
        setPanel(input1);
        input1.add(prompt1);
        input1.add(userInputMoney);

        JPanel input2 = new JPanel();
        setPanel(input2);
        input2.add(prompt2);
        input2.add(getUserInputMoneyAmt);

        JLabel totalUserMoney = new JLabel("                                                                Money In Machine: " + userMoney);
        setLabel(totalUserMoney);

        JPanel centerSquare = new JPanel(new GridLayout(3,1));
        centerSquare.setFocusable(false);
        centerSquare.setBackground(Color.decode("#001440"));

        centerSquare.add(totalUserMoney);
        centerSquare.add(input1);
        centerSquare.add(input2);

        this.addPaymentBtn.setIcon(addPayment);
        setButton(addPaymentBtn);

        this.dispenseChangeBtn.setIcon(dispenseChange);
        setButton(dispenseChangeBtn);

        this.specialFinalizePurchase.setIcon(finalPurchase);
        setButton(specialFinalizePurchase);

        this.returnTMBtn.setIcon(returnTM);
        setButton(returnTMBtn);

        JPanel right = new JPanel(new GridLayout(4, 1));
        right.setFocusable(false);
        right.setBackground(Color.decode("#001440"));

        right.add(addPaymentBtn);
        right.add(dispenseChangeBtn);
        right.add(specialFinalizePurchase);
        right.add(returnTMBtn);

        this.center.add(left, BorderLayout.WEST);
        this.center.add(right, BorderLayout.EAST);
        this.center.add(centerSquare, BorderLayout.CENTER);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.setVisible(true);
    }

    public void preparingOrderPopUp(Receipt receipt) {
        resetFrame();
        setPanel(header);
        setPanel(bottom);
        this.center.setLayout(new BorderLayout());

        ImageIcon thankYouImg = new ImageIcon("ThankYouBtn.png");
        ImageIcon popUpTitle = new ImageIcon("PrepPopUpTitle.png");

        this.title = new JLabel(popUpTitle);
        header.add(title);

        JLabel prepTitle = new JLabel("**** PREPARING FOR A FRO-YO FRIEND ****");
        prepTitle.setBackground(Color.decode("#001440"));
        prepTitle.setForeground(Color.decode("#FFFBD7"));
        prepTitle.setFont(new Font("Verdana", Font.BOLD, 30));

        JLabel flavor = new JLabel("#1: " + receipt.getUserReceipt().get(0).getPrepMsg());
        flavor.setFont(new Font("Verdana", Font.BOLD, 30));
        flavor.setBackground(Color.decode("#001440"));
        flavor.setForeground(Color.decode("#FFFBD7"));

        JLabel fruit = new JLabel("#2: " + receipt.getUserReceipt().get(1).getPrepMsg());
        fruit.setFont(new Font("Verdana", Font.BOLD, 30));
        fruit.setBackground(Color.decode("#001440"));
        fruit.setForeground(Color.decode("#FFFBD7"));

        JLabel extra = new JLabel("#3: " + receipt.getUserReceipt().get(2).getPrepMsg());
        extra.setFont(new Font("Verdana", Font.BOLD, 30));
        extra.setBackground(Color.decode("#001440"));
        extra.setForeground(Color.decode("#FFFBD7"));

        JLabel syrup = new JLabel("#4: " + receipt.getUserReceipt().get(3).getPrepMsg());
        syrup.setFont(new Font("Verdana", Font.BOLD, 30));
        syrup.setBackground(Color.decode("#001440"));
        syrup.setForeground(Color.decode("#FFFBD7"));

        this.thankYouBtn.setIcon(thankYouImg);

        JLabel froyo1 = new JLabel(new ImageIcon("FroyoLogo.png"));
        JLabel froyo2 = new JLabel(new ImageIcon("FroyoLogo.png"));
        setLabel(froyo1);
        setLabel(froyo2);

        JPanel centerSquare = new JPanel(new GridLayout(6, 1,4,4));

        center.add(froyo1, BorderLayout.WEST);
        center.add(froyo2, BorderLayout.EAST);
        center.add(centerSquare, BorderLayout.CENTER);
        centerSquare.add(prepTitle);
        centerSquare.add(flavor);
        centerSquare.add(fruit);
        centerSquare.add(extra);
        centerSquare.add(syrup);
        centerSquare.add(thankYouBtn);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(bottom, BorderLayout.SOUTH);
        this.mainFrame.setVisible(true);
    }


    // Action Listeners

    /**
     * This action listener opens the menu for the user to choose what type of vending machine they want
     * @param actionListener
     */
    public void setTypeMachineCreationActionListener(ActionListener actionListener) { this.createMachineBtn.addActionListener(actionListener); }
    /**
     * This action listener closes the program
     * @param actionListener
     */
    public void setExitProgramActionListener(ActionListener actionListener) { this.exitProgramBtn.addActionListener(actionListener); }
    public void setReturnTMBtnActionListener(ActionListener actionListener) { this.returnTMBtn.addActionListener(actionListener); }
    public void setReturnMMBtnActionListener(ActionListener actionListener) { this.returnMMBtn.addActionListener(actionListener); }
    public void setSimulationMenuOpenActionListener(ActionListener actionListener) { this.simulationMenuOpen.addActionListener(actionListener); }
    public void setMaintenanceMenuOpenActionListener(ActionListener actionListener) { this.maintenanceMenuOpen.addActionListener(actionListener); }
    public void setAccessTestMenuBtnActionListener(ActionListener actionListener) { this.accessTestMenuBtn.addActionListener(actionListener); }
    public void setAccessMoneyMenuBtnActionListener(ActionListener actionListener) { this.accessMoneyMenuBtn.addActionListener(actionListener); }
    public void setCreateRegularVMBtnActionListener(ActionListener actionListener) { this.regMenuChoiceBtn.addActionListener(actionListener); }
    public void setCreateSpecialVMBtnActionListener(ActionListener actionListener) { this.specMenuChoiceBtn.addActionListener(actionListener); }
    public void setSubmitInputtedMoneyDenomsActionListener(ActionListener actionListener) { this.addMoney.addActionListener(actionListener); }
    public void setCollectMoneyActionListener(ActionListener actionListener) { this.collectMoney.addActionListener(actionListener); }
    public void setUserInputMoneyDenomsActionListener(ActionListener actionListener) {this.addPaymentBtn.addActionListener(actionListener); }
    public void setUserCollectChangeActionListener(ActionListener actionListener) { this.dispenseChangeBtn.addActionListener(actionListener); }

    // Buying Regular VM Items
    public void setRestartTransactionBtnActionListener(ActionListener actionListener) { this.restartTransactionBtn.addActionListener(actionListener); }
    public void setVYBtnActionListener(ActionListener actionListener) { this.VYBtn.addActionListener(actionListener); }
    public void setCYBtnActionListener(ActionListener actionListener) { this.CYBtn.addActionListener(actionListener); }
    public void setSYBtnActionListener(ActionListener actionListener) { this.SYBtn.addActionListener(actionListener); }
    public void setCMBtnActionListener(ActionListener actionListener) { this.CMBtn.addActionListener(actionListener); }
    public void setBBtnActionListener(ActionListener actionListener) { this.BBtn.addActionListener(actionListener); }
    public void setKKBtnActionListener(ActionListener actionListener) { this.KKBtn.addActionListener(actionListener); }
    public void setCSBtnActionListener(ActionListener actionListener) { this.CSBtn.addActionListener(actionListener); }
    public void setCBtnActionListener(ActionListener actionListener) { this.CBtn.addActionListener(actionListener); }
    public void setFinalizePurchaseBtnActionListener(ActionListener actionListener) { this.finalizePurchaseBtn.addActionListener(actionListener); }
    public void setSpecialFinalizePurchaseBtnActionListener(ActionListener actionListener) { this.specialFinalizePurchase.addActionListener(actionListener); }
    public void setViewReceiptBtnActionListener(ActionListener actionListener) { this.viewReceiptBtn.addActionListener(actionListener); }
    public void setCloseReceiptBtnActionListener(ActionListener actionListener) { this.closeReceiptBtn.addActionListener(actionListener); }
    public void setChangePriceMaintenanceBtnActionListener(ActionListener actionListener) { this.changePriceMaintenanceBtn.addActionListener(actionListener); }
    public void setAddStocksMaintenanceBtnActionListener(ActionListener actionListener) { this.addStocksMaintenanceBtn.addActionListener(actionListener); }
    public void setThankYouBtnActionListener(ActionListener actionListener) { this.thankYouBtn.addActionListener(actionListener); }

    // Changing Price
    public void setSubmitNewItemPriceBtnActionListener(ActionListener actionListener) { this.submitNewItemPriceBtn.addActionListener(actionListener); }
    // Restocking
    public void setSubmitRestockBtnActionListener(ActionListener actionListener) { this.submitRestockBtn.addActionListener(actionListener); }

    // Syrups
    public void setSpecialChocoSBtnActionListener(ActionListener actionListener) { this.specialChocoSBtn.addActionListener(actionListener); }
    public void setSpecialCaramelSBtnActionListener(ActionListener actionListener) { this.specialCaramelSBtn.addActionListener(actionListener); }
    public void setSpecialMilkSBtnActionListener(ActionListener actionListener) { this.specialMilkSBtn.addActionListener(actionListener); }
    public void setTransactionSummaryMaintenanceBtnActionListener(ActionListener actionListener) { this.transactionSummaryMaintenanceBtn.addActionListener(actionListener); }
}

