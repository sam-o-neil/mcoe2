import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VMview {
    // handles data presentation
    private JFrame mainFrame; // main window
    private JLabel title;
    private JPanel header, center;
    JLabel promptLbl = new JLabel();
    JLabel prompt2Lbl = new JLabel();
    private JButton regBtn = new JButton();
    private JButton specialBtn = new JButton();
    private JButton returnMMBtn = new JButton();
    private JButton submitCreateVMBtn = new JButton();
    private JButton addMoney = new JButton();
    private JButton testVM = new JButton();
    private JButton maintainVM = new JButton();
    private JButton exitBtn, createBtn, testBtn;
    private JTextField inputName = new JTextField();
    private JTextField inputSlots = new JTextField();
    private JTable transactionSummary; // for maintenance purposes

    public VMview() {
        this.mainFrame = new JFrame("Vending Machine");
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setResizable(false);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(350, 450);

        this.header = new JPanel(new FlowLayout());
        this.header.setBackground(Color.decode("#F5DADF"));

        this.title = new JLabel();
        title.setText("Vending Machine Menu");
        titleLook(title);
        header.add(title);

        this.center = new JPanel(new FlowLayout());
        this.center.setBackground(Color.decode("#F5DADF"));

        this.createBtn = new JButton("Create a NEW Vending Machine");
        createBtn.setPreferredSize(new Dimension(210, 20));
        btnLook(createBtn);

        this.exitBtn = new JButton("Exit Program");
        exitBtn.setPreferredSize(new Dimension(160, 20));
        btnLook(exitBtn);

        this.testBtn = new JButton("Test Existing Machine");
        testBtn.setPreferredSize(new Dimension(180, 20));
        btnLook(testBtn);

        center.add(createBtn);
        center.add(testBtn);
        center.add(exitBtn);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.setVisible(true);
    }
    public String getNameTxt() { return this.inputName.getText(); }
    public String getSlotsTxt() { return this.inputSlots.getText(); }
    public void btnLook(JButton button) {
        button.setForeground(Color.decode("#009B77"));
        button.setFocusable(false);
    }
    public void titleLook(JLabel label) {
        label.setFont(new Font("Helvetica", Font.BOLD, 22));
        label.setForeground(Color.decode("#E35B89"));
    }
    public void clearInputName() {
        this.inputName.setText("");
    }
    public void clearInputSlots() {
        this.inputSlots.setText("");
    }
    public void showInputError() {
        JOptionPane.showConfirmDialog(null, "Input Error! Name should be below 12 characters and Vending Machine slots can only be between 8-10","Input Error", JOptionPane.DEFAULT_OPTION);
    }
    public void vendingMMview() {
        this.header.removeAll();
        this.center.removeAll();

        this.center = new JPanel(new FlowLayout());
        this.header = new JPanel(new FlowLayout());



        this.header.setBackground(Color.decode("#F5DADF"));
        this.center.setBackground(Color.decode("#F5DADF"));

        this.title = new JLabel();
        title.setText("Vending Machine Menu");
        titleLook(title);
        header.add(title);

        this.createBtn.setText("Create a NEW Vending Machine");
        createBtn.setPreferredSize(new Dimension(210, 20));
        btnLook(createBtn);

        this.testBtn.setText("Test Existing Machine");
        testBtn.setPreferredSize(new Dimension(180, 20));
        btnLook(testBtn);

        this.exitBtn.setText("Exit Program");
        exitBtn.setPreferredSize(new Dimension(160, 20));
        btnLook(exitBtn);

        center.add(createBtn);
        center.add(testBtn);
        center.add(exitBtn);

        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.setVisible(true);
    }
    public void vendingTypeView() {
        this.header.removeAll();
        this.center.removeAll();

        this.center = new JPanel(new FlowLayout());
        this.header = new JPanel(new FlowLayout());

        this.title = new JLabel();
        title.setText("Choose Type of Machine");
        titleLook(title);
        this.header.add(title);

        this.regBtn.setText("Create Regular Vending Machine");
        this.regBtn.setPreferredSize(new Dimension(210, 20));
        btnLook(regBtn);

        this.specialBtn.setText("Create Special Vending Machine");
        this.specialBtn.setPreferredSize(new Dimension(175, 20));
        btnLook(specialBtn);

        this.returnMMBtn.setText("Return to Main Menu");
        this.returnMMBtn.setPreferredSize(new Dimension(160, 20));
        btnLook(returnMMBtn);

        this.center.setBackground(Color.decode("#F5DADF"));
        this.header.setBackground(Color.decode("#F5DADF"));

        this.center.add(regBtn);
        this.center.add(specialBtn);
        this.center.add(returnMMBtn);

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);

        this.mainFrame.setVisible(true);
    }
    public void createRegView() {
        this.header.removeAll();
        this.center.removeAll();

        this.center = new JPanel(new FlowLayout());
        this.header = new JPanel(new FlowLayout());

        this.title = new JLabel();
        this.title.setText("Creating a VM");
        titleLook(title);

        this.promptLbl.setText("Name of Machine: ");
        this.promptLbl.setFont(new Font("Helvetica", Font.PLAIN, 12));
        this.promptLbl.setForeground(Color.decode("#00A881"));

        // title display and bottom information
        this.prompt2Lbl.setText("Number of Slots: ");
        this.prompt2Lbl.setFont(new Font("Helvetica", Font.PLAIN, 12));
        this.prompt2Lbl.setForeground(Color.decode("#00A881"));

        this.inputSlots.setColumns(15);
        this.inputName.setColumns(15);

        this.returnMMBtn.setText("Back to Main Menu");
        this.returnMMBtn.setPreferredSize(new Dimension(175, 20));
        btnLook(returnMMBtn);

        this.submitCreateVMBtn.setText("Submit Information");
        this.submitCreateVMBtn.setPreferredSize(new Dimension(175, 20));
        btnLook(submitCreateVMBtn);

        this.header.add(title); // shows title of current tab
        this.center.add(promptLbl); // prompts user to input name
        this.center.add(inputName); // text field to input name
        this.center.add(prompt2Lbl); // prompts user to input number of slots
        this.center.add(inputSlots); // text field to input number of slots
        this.center.add(submitCreateVMBtn); // button to create a vending machine
        this.center.add(returnMMBtn); // button to return to main menu

        this.mainFrame.add(header, BorderLayout.NORTH);
        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.setVisible(true);
    }
    public void testMenu() {
        this.header.removeAll();
        this.center.removeAll();

        this.center = new JPanel(new FlowLayout());
        this.header = new JPanel(new FlowLayout());

        this.title = new JLabel();
        title.setText("Vending Machine");
        titleLook(title);

        this.testVM.setText("Test Vending Machine Features");
        this.testVM.setPreferredSize(new Dimension(200, 20));
        btnLook(testVM);

        this.maintainVM.setText("Maintenance Features");
        this.maintainVM.setPreferredSize(new Dimension(200, 20));
        btnLook(maintainVM);

        this.header.add(title);
        this.center.add(testBtn);
        this.center.add(maintainVM);

        this.mainFrame.add(center, BorderLayout.CENTER);
        this.mainFrame.add(header, BorderLayout.NORTH);
    }
    public void setCreateBtnActionListener(ActionListener actionListener) {this.createBtn.addActionListener(actionListener);}
    public void setExitBtnActionListener(ActionListener actionListener) {this.exitBtn.addActionListener(actionListener);}
    public void setTestBtnActionListener(ActionListener actionListener) {this.testVM.addActionListener(actionListener);}
    public void setMaintainBtnActionListener(ActionListener actionListener) {this.maintainVM.addActionListener(actionListener);}
    public void setvmCreateSubmitBtnActionListener(ActionListener actionListener) {this.submitCreateVMBtn.addActionListener(actionListener);}
    public void setReturnMMBtnActionListener(ActionListener actionListener) {this.returnMMBtn.addActionListener(actionListener);}
    public void setRegBtnActionListener(ActionListener actionListener) { this.regBtn.addActionListener(actionListener);}
    public void setSpecialBtnActionListener(ActionListener actionListener) {this.specialBtn.addActionListener(actionListener);}
}
