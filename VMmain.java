import javax.swing.*;

public class VMmain {
    public static void main(String args[]) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        VMview vmView = new VMview();
        VMmodel vmModel = new VMmodel();
        VMcontroller vmController = new VMcontroller(vmModel, vmView);
    }
}
