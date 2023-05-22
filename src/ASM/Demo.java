package ASM;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class Demo extends JFrame {
    private JPanel mainPanel;
    private JTable tb_clothes;
    private JTextField txtName;
    private JTextField txtCode;
    private JTextField txtAmount;
    private JTextField txtPrice;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnAdd;
    private JTextField txtCategory;

    String shHarry="Manager.dat";
    int row=0;

    DefaultTableModel tbModed;
    List<Manager> JDiShop = new ArrayList<>();
    Demo(String title) {
        super(title);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tb_clothes.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Name", "ID", "Amount", "Price", "Category"
                }
        ));
        tbModed = (DefaultTableModel) tb_clothes.getModel();
        JDiShop=(List<Manager>) Controller.readObject(shHarry);
        if (JDiShop == null || JDiShop.size()==0) {
            JDiShop = new ArrayList<>();
            JDiShop.add(new Manager("T-Shirt", 111, 55, 60000, "Shirt"));
        }
        allLish();
        disPlayinf(row);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                space();
            }
        });


        tb_clothes.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tb_ManagementClick();
            }

            private void tb_ManagementClick() {
                row=tb_clothes.getSelectedRow();
                disPlayinf(row);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Remove();
            }
        });

        btnUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fixTable();
            }
        });
    }

    private void fixTable() {
        //edit table
        editTbl();
        allLish();
        Controller.WriteObject(shHarry, JDiShop);
        tb_clothes.setRowSelectionInterval(row, row);
    }
    private void Remove(){

        int result = JOptionPane.showConfirmDialog(this, "Do you really want to delete?",
                "Delete",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            JDiShop.remove(row);
            allLish();
            Controller.WriteObject(shHarry,JDiShop);
        }
    }

    private void editTbl() {
        Manager i = JDiShop.get(row);
        i.setProductID(Integer.parseInt(txtCode.getText()));
        i.setAmount(Integer.parseInt(txtAmount.getText()));
        i.setPrice(Integer.parseInt(txtPrice.getText()));
        i.setCategory(txtCategory.getText());
    }


    private void space() {
        insertLish();
        allLish();
        Controller.WriteObject(shHarry,JDiShop);
    }

    private void allLish() {
        //filltoTable
        tbModed.setRowCount(0);
        for (Manager i:JDiShop) {
            Object[] row = new Object[] {
                    i.getProductName(), i.getProductID(), i.getAmount(), i.getPrice(), i.getCategory()};
            tbModed.addRow(row);
        }
    }

    private void insertLish() {
        Manager i = new Manager(txtName.getText(),Integer.parseInt(txtCode.getText()),
                Integer.parseInt(txtAmount.getText()), Integer.parseInt(txtPrice.getText()),
                txtCategory.getText());
        JDiShop.add(i);
    }


    private void disPlayinf(int row)  {
        String ProductName = (String) tb_clothes.getValueAt(row, 0);
        txtName.setText(ProductName);
        int ProductCode = (int) tb_clothes.getValueAt(row, 1);
        txtCode.setText(String.valueOf(ProductCode));
        int Amount = (int) tb_clothes.getValueAt(row, 2);
        txtAmount.setText(String.valueOf(Amount));
        int Price = (int) tb_clothes.getValueAt(row, 3);
        txtPrice.setText(String.valueOf(Price));
        String Category = (String) tb_clothes.getValueAt(row, 4);
        txtCategory.setText(Category);
    }

    public static void main (String[]args){
        JFrame fr = new Demo("JDiShop");
        fr.setSize(900, 450);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }
}
