package sellclothes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;


public class AddItem extends javax.swing.JDialog {

    // Variables declaration
    private javax.swing.JTextField displ_txt;
    private javax.swing.JLabel item_img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_items;
    private javax.swing.JTextField txt_buyingPrice;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_clotheID;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_stock;

    private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] person_image = null;

    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;

    //Constructor
    public AddItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_items = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        txt_clotheID = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        item_img = new javax.swing.JLabel();
        displ_txt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_category = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_buyingPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        //Close Button
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/close.png")));
        jButton1.setText("CLOSE");
        jButton1.setFont(new java.awt.Font("arial", 1, 12));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        //Clear Button
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/clear.png")));
        jButton4.setText("CLEAR");
        jButton4.setFont(new java.awt.Font("arial", 1, 12));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        //Save Button
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/save1.png")));
        jButton5.setText("SAVE");
        jButton5.setFont(new java.awt.Font("arial", 1, 12));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );


        //Table
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Clothes"));
        table_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_items);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Clothe Information"));

        jLabel3.setText("Quantity in Stock:");

        jLabel1.setText("Clothe Name:");

        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_priceKeyTyped(evt);
            }
        });

        jLabel4.setText("Clothe Id:");

        jLabel2.setText("Selling Price:");

        txt_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stockKeyTyped(evt);
            }
        });


        item_img.setForeground(new java.awt.Color(255, 255, 255));
        item_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jDesktopPane1.setLayer(item_img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(item_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(item_img, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        //Upload Button
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/uploadImage.png")));
        jButton2.setFont(new java.awt.Font("arial", 1, 12));
        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Category:");

        jLabel6.setText("Buying Price:");

        txt_buyingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buyingPriceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_clotheID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addComponent(txt_category))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_buyingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(displ_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jDesktopPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(displ_txt)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_clotheID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_buyingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1204, 467));
        setLocationRelativeTo(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        AddItem neest = new AddItem(null, true);
        FileFilter filter = new FileNameExtensionFilter("Images","jpg","jpeg","png");
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);

        int returnVal = chooser.showOpenDialog(neest);

        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
         File myFile = chooser.getSelectedFile();
         String path = myFile.getAbsolutePath();
         item_img.setIcon(ResizeImage(path));

       //  String fname =myFile.getAbsolutePath();
         String dispName = myFile.getName();
         
         displ_txt.setText(dispName);

         File f = chooser.getSelectedFile();
         filename = f.getAbsolutePath();


         try {

              File image = new File(filename);
              FileInputStream fis = new FileInputStream(image);
              ByteArrayOutputStream bos = new ByteArrayOutputStream();
              byte[] buf = new byte [1024];
            for(int readNum; (readNum = fis.read(buf))!=-1;)
            {

                bos.write(buf,0,readNum);

            }

            person_image = bos.toByteArray();
          }catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, e);
        }

        }
    }

    private void txt_priceKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c== KeyEvent.VK_DELETE)|| c== KeyEvent.VK_BACK_SPACE){
            evt.consume();
        }
    }


    //Save Button Click Event
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
        conn = Connect.Connectdb();
        if(txt_clotheID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Clothe ID must be provided");
            return;
        }
        if(txt_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Product Name must be provided");
            return;
        }
        if(txt_category.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Category must be provided");
            return;
        }
        if(txt_price.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Selling price must be provided");
            return;
        }
        if(txt_buyingPrice.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Buying Price must be provided");
            return;
        }
        if(txt_stock.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Quantity in stock must be provided");
            return;
        }
        //
        if(displ_txt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Product photo must be provided");
            return;
        }
        try{
            String NewStudent = "INSERT INTO `products`( `ProductId`, `Name`, Category, `Photo`, `Price`, BuyingPrice, `Quantity`) VALUES (?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(NewStudent);
            pst.setString(1, txt_clotheID.getText());
            pst.setString(2, txt_name.getText());
            pst.setString(3, txt_category.getText());
            pst.setBytes(4, person_image);
            pst.setString(5, txt_price.getText());
            pst.setString(6, txt_buyingPrice.getText());
            pst.setString(7, txt_stock.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Clothe details saved succesfully", "System Notification", JOptionPane.INFORMATION_MESSAGE);
            LoadTable();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Close Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void txt_buyingPriceKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }

    private void txt_stockKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }

    //Clear Button Click Event
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        txt_buyingPrice.setText("");
        txt_category.setText("");
        txt_clotheID.setText("");
        txt_name.setText("");
        txt_price.setText("");
        txt_stock.setText("");
    }
    public ImageIcon ResizeImage(String ImagePath)
    {
       ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(item_img.getWidth(),item_img.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);

        return image;
    }


    //Table Date
     private void LoadTable()
    {
       DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
       conn = Connect.Connectdb();
       try{
            String sql="SELECT `Id`, `ProductId`, `Name`, Category, `Price`, `Quantity`as Stock FROM `products` WHERE 1";
            stm=conn.prepareStatement(sql);
            rs=stm.executeQuery(sql);
            table_items.setModel(DbUtils.resultSetToTableModel(rs));
            resizeColumnWidth(table_items);
            
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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        // Create and display the dialog
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddItem dialog = new AddItem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


}
