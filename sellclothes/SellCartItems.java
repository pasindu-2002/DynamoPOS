package sellclothes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SellCartItems extends javax.swing.JFrame {

    // Variables declaration
    private javax.swing.JTextField amountPaind;
    private javax.swing.JButton btn_cart;
    private javax.swing.JComboBox combo_export;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mpesacode;
    private javax.swing.JTable table_cart;
    private javax.swing.JTextField txt_amtPay;
    private javax.swing.JTextField txt_bonus;
    private javax.swing.JTextField txt_clotheId;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_taxt;
    private javax.swing.JTextField txt_total;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stm = null;
    int quantityAvailable;
    int x =0;
    FileOutputStream fos ;
    String ItemSoldBy = null;

    //Constructor
    public SellCartItems() {
        initComponents();
        TruncateTable(); 
        LoadTable();
        iconMethod();
    }

    //Constructor
    public SellCartItems(String SoldBy) {
        initComponents();
        ItemSoldBy = SoldBy;
        TruncateTable(); 
        LoadTable();
        iconMethod();
    }


    //Get Icon
    public void iconMethod()
    {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }


    //Designing
    private void initComponents() {

        //Variable
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_clotheId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        btn_cart = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cart = new javax.swing.JTable();
        combo_export = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        mpesacode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txt_taxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_bonus = new javax.swing.JTextField();
        amountPaind = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt_total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_amtPay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        //Selle item Information Section
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clothe Information"));

        jLabel1.setText("Clothe Id:");

        txt_price.setEditable(false);
        txt_price.setText("0");
        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_priceKeyTyped(evt);
            }
        });

        jLabel2.setText("Clothe Name:");

        txt_clotheId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clotheIdKeyReleased(evt);
            }
        });

        jLabel4.setText("Quantity Bought:");

        txt_name.setEditable(false);

        jLabel3.setText("Clothe Price:");

        txt_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_quantityKeyTyped(evt);
            }
        });

        btn_cart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/cart_mini.png")));
        btn_cart.setText("ADD TO CART");
        btn_cart.setBackground(Color.white);
        btn_cart.setFont(new java.awt.Font("Tahoma", 1, 11));
        btn_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cartActionPerformed(evt);
            }
        });


        // Layout
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_clotheId, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_clotheId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );


        //Items List Section
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Items List"));

        table_cart.setAutoCreateRowSorter(true);
        table_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cartMouseClicked(evt);
            }
        });
        table_cart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_cartKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_cart);

        combo_export.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Export Data--", "To PDF", "To Excel" }));
        combo_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_exportActionPerformed(evt);
            }
        });

        //Layout
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(combo_export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(combo_export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );


        //Payment Information Section
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Information"));

        jLabel11.setText("Amount Paid:");
        jLabel10.setText("Paypal Transaction Code:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/payment.png")));
        jButton5.setText("CONFIRM PAYMENT");
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton5.setBackground(Color.white);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_taxt.setEditable(false);

        jLabel5.setText("Mode of Payment:");

        jLabel9.setText("Discount:");

        jLabel7.setText("Total Tax:");

        txt_bonus.setText("0");
        txt_bonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bonusKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bonusKeyTyped(evt);
            }
        });

        amountPaind.setText("0");
        amountPaind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountPaindKeyTyped(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Mode of Payment--","Cash","Debit/ Credit Card", "Paypal", " " }));

        txt_total.setEditable(false);

        jLabel6.setText("Total cart Amount:");

        jLabel8.setText("Amount to Pay:");

        txt_amtPay.setEditable(false);

        //Layout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_taxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(amountPaind, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mpesacode, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_amtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_total)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_taxt)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_bonus)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_amtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(mpesacode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountPaind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(35, 35, 35)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(1301, 611));
        setLocationRelativeTo(null);
    }

    private void txt_priceKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c== KeyEvent.VK_DELETE)|| c== KeyEvent.VK_BACK_SPACE){
            evt.consume();
        }
    }

    //Get Clothe Details withing ClotheID
    private void txt_clotheIdKeyReleased(java.awt.event.KeyEvent evt) {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        try{

            String sql ="SELECT * FROM `products` WHERE `ProductId` =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_clotheId.getText());
            rs= pst.executeQuery();

            if(rs.next())
            {
                String name = rs.getString("Name");
                txt_name.setText(name);
                String price = rs.getString("Price");
                txt_price.setText(price);
                String quantity = rs.getString("Quantity");
                quantityAvailable = Integer.parseInt(quantity);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //Quantity Input
    private void txt_quantityKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }

    //Add Cart Button
    private void btn_cartActionPerformed(java.awt.event.ActionEvent evt) {
        if(txt_clotheId.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Clothe ID must be provided");
            return;
        }
        if(txt_quantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Quantity bought must be provided");
            return;
        }

        int quantity = Integer.parseInt(txt_quantity.getText());
        if( quantity >  quantityAvailable){
            JOptionPane.showMessageDialog(null, "Item quantity is more than stock available");
        }else{
            DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
            conn = Connect.Connectdb();
            try{
                String user = "INSERT INTO `customer_basket`( `ProductId`, `Quantity`, `Price`, `TotalAmount`) VALUES (?,?,?,?)";
                pst = conn.prepareStatement(user);
                pst.setString(1, txt_clotheId.getText());
                pst.setString(2, txt_quantity.getText());
                pst.setString(3, txt_price.getText());
                int total = Integer.parseInt(txt_quantity.getText()) *  Integer.parseInt(txt_price.getText());
                pst.setString(4,String.valueOf(total + Double.parseDouble(txt_taxt.getText())));
                pst.execute();
                //load to table
                LoadTable();
                SumCart();
                reset();

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    //Table Click Event
    private void table_cartMouseClicked(java.awt.event.MouseEvent evt) {
        try{

            int row=table_cart.getSelectedRow();

            txt_clotheId.setText(table_cart.getValueAt(row, 1).toString());
            txt_quantity.setText(table_cart.getValueAt(row, 2).toString());
            txt_price.setText(table_cart.getValueAt(row, 3).toString());

            SalesReceipt s = new SalesReceipt();
            txt_name.setText(  s.GetProductName(table_cart.getValueAt(row, 1).toString()));

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    //Delete cart withing Delete Key
    private void table_cartKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DELETE)
        {
            JOptionPane.showMessageDialog(null, "Delete");

        }
    }


    //Confirm Payment Button Click
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        //loop through cart
        if(jComboBox1.getSelectedItem().equals("--Select Mode of Payment--"))
        {
            JOptionPane.showMessageDialog(null, "You must select mode of payment first");
            return;
        }

        int amtttt = Integer.parseInt(amountPaind.getText());
        
        if(amtttt == 0)
        {
            JOptionPane.showMessageDialog(null, "You must enter the amount paid");
            return;
        }
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();

        String ReceiptNumber = randomUUID(10, 0, 'R');
        String Amount = txt_bonus.getText();
        try
        {
            String sql = "SELECT * FROM customer_basket";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next())
            {
                //update stock quantity
                updateStock(rs.getString("ProductId"), rs.getInt("Quantity"));
            }
            //select where to save receipt

            RecordDiscount( ReceiptNumber,  Amount);
            //record sales
            getBasket(ReceiptNumber);
            //record payment
            RecordPayment(ReceiptNumber,  amountPaind.getText(), (String) jComboBox1.getSelectedItem());

            PrintReceipt  p = new PrintReceipt(ReceiptNumber, ItemSoldBy);
            p.setVisible(true);

            // TruncateTable();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    //Export Section
    private void combo_exportActionPerformed(java.awt.event.ActionEvent evt) {
        if(!combo_export.getSelectedItem().equals("--Export Data--"))
        {
            if(combo_export.getSelectedItem().equals("To PDF"))
            {
                int option = JOptionPane.showConfirmDialog(this, "Your data will be exported to a PDF file", "System Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    try {
                        
                        Boolean complete = table_cart.print();

                    } catch (PrinterException ex) {
                        Logger.getLogger(SellCartItems.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if(combo_export.getSelectedItem().equals("To Excel"))
            {
                int option = JOptionPane.showConfirmDialog(this, "Your data will be exported to an excel file", "System Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    boolean status =  writeToExcel() ;
                    if(status ==true)
                    {
                        JOptionPane.showMessageDialog( this, "Export Succesful","Success", JOptionPane.INFORMATION_MESSAGE);

                    }else{

                        JOptionPane.showMessageDialog( this, "Export Failed","Error", JOptionPane.ERROR_MESSAGE);

                    }

                }
            }
        }else{
            JOptionPane.showMessageDialog( this, "Please select an option to import","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }


    private void txt_bonusKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }

    private void amountPaindKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }

    private void mpesacodeKeyReleased(java.awt.event.KeyEvent evt) {
        int pos = mpesacode.getCaretPosition();
        mpesacode.setText(mpesacode.getText().toUpperCase());
        mpesacode.setCaretPosition(pos);
    }

    private void mpesacodeKeyTyped(java.awt.event.KeyEvent evt) {
        if (mpesacode.getText().length() >= 10 )
                evt.consume();
    }

    //Bonus Calculation
    private void txt_bonusKeyReleased(java.awt.event.KeyEvent evt) {
        double amttopay = Double.parseDouble(txt_total.getText()) + Double.parseDouble(txt_taxt.getText());
        double bonus = Double.parseDouble(txt_bonus.getText());
        double finalAmt = amttopay - bonus;
        txt_amtPay.setText(String.valueOf(finalAmt));
    }

    // Insert Payment Details
   private void RecordPayment(String ReceiptNumber, String AmountPaid, String ModeOfPayment)
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        
        try{
            String user = "INSERT INTO `payment_records`( `ReceiptNumber`, `AmountPaid`, `ModeOfPayment`) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(user);
            pst.setString(1, ReceiptNumber);
            pst.setString(2, AmountPaid);
              pst.setString(3, ModeOfPayment);
            pst.execute();                  
                     
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
    }

    //Insert Discount Details
    private void RecordDiscount(String Receipt, String Amount)
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        
        try{
            String user = "INSERT INTO `discounts`( `Receipt`, `Amount`) VALUES (?,?)";
            pst = conn.prepareStatement(user);
            pst.setString(1, Receipt);
            pst.setString(2, Amount);
            pst.execute();                  
                     
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
    }

    // Get Customer Basket Details
    public void getBasket(String Receipt)
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        try
        {
            String sql = "SELECT * FROM `customer_basket`";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while (rs.next())
            {
                recordSales(Receipt,rs.getString("ProductId"), rs.getString("Quantity"), rs.getString("Price"));                
            }
                     
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
    }


    //Insert Sales Details
    public void recordSales(String Receipt, String ProductId, String QuantitySold, String SellingPrice)
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        
        long time = System.currentTimeMillis();
          java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        try{
            String user = "INSERT INTO `item_sales`( Receipt, `ProductId`, `QuantitySold`, `SellingPrice`, `Date`, SoldBy) VALUES (?,?,?,?,?,?)";
            pst = conn.prepareStatement(user);
            pst.setString(1, Receipt);
            pst.setString(2, ProductId);
            pst.setString(3, QuantitySold);
            pst.setString(4, SellingPrice);
            pst.setTimestamp(5, timestamp);
            pst.setString(6, ItemSoldBy);
            pst.execute();                  
                     
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    public void reset()
    {
       // txt_amtPay.setText("");
        txt_clotheId.setText("");
        txt_name.setText("");
        txt_price.setText("");
        txt_quantity.setText("");
       // txt_taxt.setText("");
       // txt_total.setText("");
    }
    private void LoadTable()
    {
       DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
       conn = Connect.Connectdb();
       try{
            String sql="SELECT * FROM `customer_basket` WHERE 1";
            stm=conn.prepareStatement(sql);
            rs=stm.executeQuery(sql);
            table_cart.setModel(DbUtils.resultSetToTableModel(rs));
            resizeColumnWidth(table_cart);
            SumCart();
            
        }catch(Exception e)
        {
           e.printStackTrace();
        }finally{
        try{
            rs.close();
            pst.close();
            
        }catch(Exception e)
        {
        }
    }
    
    }
  
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 15; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}


    //Get Tax
     public int getTaxAmount()
    {
        int amt = 0;
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        try{

            String sql ="SELECT * FROM `tax_settings`";
            pst = conn.prepareStatement(sql);
            rs= pst.executeQuery();

            if(rs.next())
            {
                amt = rs.getInt("Amount");  
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return amt;
    }

    //Cart Calculation
    public void SumCart()
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        String shopTotal = "0";
        try
        {
            String sql = "SELECT COALESCE(SUM(TotalAmount), 0) as Total FROM `customer_basket`";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while (rs.next())
            {
                 shopTotal = rs.getString("Total");
                txt_total.setText(shopTotal);
                int tax = getTaxAmount();
                String  tamant = txt_price.getText();
                
                int taxm = 0;
                
                if(tamant=="")
                {
                 taxm = 0;
                }
                else{
                    taxm = Integer.parseInt(tamant);
                }
                double vat= tax * 0.01 * taxm;
                txt_taxt.setText(String.valueOf(vat));
                
                txt_amtPay.setText(String.valueOf( vat+ Integer.parseInt(shopTotal)));
                
            }
                     
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
    } 
    
    private void TruncateTable()
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        try{
            String delete ="TRUNCATE TABLE customer_basket;";
            pst = conn.prepareStatement(delete);
            pst.execute();
            LoadTable();
        }catch(Exception e)
        {
             e.printStackTrace();
        }
    }


    //Export Excel
    private boolean writeToExcel()
    {
        boolean success = false;

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet();

        TreeMap<String, Object[]> data = new TreeMap<>();

        data.put("-1", new Object[]{ table_cart.getColumnName(0), table_cart.getColumnName(1), table_cart.getColumnName(2)  });

        for(int i = 0; i< table_cart.getRowCount(); i++)
        {
             data.put(Integer.toString(i), new Object[]{ getCellValue(i, 0), getCellValue(i, 1), getCellValue(i, 2), getCellValue(i, 3)  });
        }

        Set<String> ids  = data.keySet();
        XSSFRow row;
        int rowID =0;
        for(String key: ids)
        {
            row = ws.createRow(rowID++);

            Object[] values = data.get(key);

            int cellID= 0;

            for(Object o: values)
            {
                Cell cell =  row.createCell(cellID++);
                cell.setCellValue(o.toString());

            }
        }
        
        
        JFileChooser c = new JFileChooser();
        c.addChoosableFileFilter(new FileFilter()
        {
          String description = "Microsoft Excel Worksheet (.xlsx)";
          String extension = "xlsx";//the filter passed to program
          public String getDescription()
          {
            return description;
          }
          public boolean accept(File f)
          {
            if(f == null) return false;
            if(f.isDirectory()) return true;
            return f.getName().toLowerCase().endsWith(extension);
          }
        });
        c.setAcceptAllFileFilterUsed(false);
    
        String path_to_class_list = c.getCurrentDirectory().toString()+ "/" +c.getSelectedFile().getName() +".xlsx";

        try{
          fos = new FileOutputStream(path_to_class_list);
            wb.write(fos);
            fos.close();
             success = true;
        }catch(Exception e)
        {
        e.printStackTrace();
        }

        return success;

    }
    private String getCellValue(int x, int y)
    {
        return table_cart.getValueAt(x, y).toString();

    }
    
    private void updateStock(String ProductId, int CartQuantity)
    {
       DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
       conn = Connect.Connectdb();
        //fetch stock quantity   
        try
        {
            String sql = "SELECT  `Quantity` FROM `products` WHERE `ProductId` = '"+ProductId+"'";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while (rs.next())
            {
                int oldStock = rs.getInt("Quantity");
                
                //delete by quantity
                int newStock = oldStock - CartQuantity;
                
                String sqlUpdate="UPDATE `products` SET `Quantity`= '"+newStock+"' WHERE `ProductId` = '"+ProductId+"'";
                pst = conn.prepareStatement(sqlUpdate);
                pst.execute();           
                
            }
                     
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }   
            
    }

    //Print Receipt
    private void PrintReceipt(String ReceiptNumber)
    {
        JFileChooser c = new JFileChooser();
        c.addChoosableFileFilter(new FileFilter()
        {
          String description = "PDF File (.pdf)";
          String extension = "pdf";
          public String getDescription()
          {
            return description;
          }
          public boolean accept(File f)
          {
            if(f == null) return false;
            if(f.isDirectory()) return true;
            return f.getName().toLowerCase().endsWith(extension);
          }
        });
        c.setAcceptAllFileFilterUsed(false);

        int rVal = c.showSaveDialog(SellCartItems.this);
        
        if (rVal == JFileChooser.APPROVE_OPTION) {
          
            String path = c.getCurrentDirectory().toString()+ "/" +c.getSelectedFile().getName() +".pdf";
            SalesReceipt s = new SalesReceipt();
            s.generateReceipt(path, ReceiptNumber);
        }
    }

    //Generate Receipt ID
    static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    final private Random rng = new SecureRandom();

    char randomChar(){
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }
     private String randomUUID(int length, int spacing, char spacerChar){
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while(length > 0){
            if(spacer == spacing){
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SellCartItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellCartItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellCartItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellCartItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellCartItems().setVisible(true);
            }
        });
    }


}
