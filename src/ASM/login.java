package ASM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JLabel txtlog;
    private JTextField txtName;
    private JTextField txtPass;
    private JButton resetButton;
    private JButton loginButton;
    private JPanel mainPanel;

    public login(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.pack();
        txtlog.setText("Login");


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    private void reset() {
        txtName.setText("");
        txtPass.setText("");
    }

    private void login(){
        String usr = txtName.getText();
        String pass = txtPass.getText();
        if ( usr.equals("datnhism") && pass.equals("12345678") ){
            this.setVisible(false);
            JFrame c = new Demo("JDiShop");
            c.setSize(1000, 500);
            c.setLocationRelativeTo(null);
            c.setVisible(true);
            JOptionPane.showMessageDialog(this, "Login successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong, please check again!");
        }
    }



    public static void main(String[] args) {
        login c = new login("Login");
        c.setVisible(true);
    }

}
