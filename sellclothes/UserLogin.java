package sellclothes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;


public class UserLogin extends javax.swing.JFrame {

    // Variables
    private javax.swing.JLabel bView;
    private javax.swing.JButton btn_login;

    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField username;

    utilities.DisplayTrayIcon DTI = new utilities.DisplayTrayIcon();
    int pX, pY, x=0;
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Constructor
    public UserLogin() {
        initComponents();
        iconMethod();
       
    }

    //Get Icon Image
    public void iconMethod() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    private void initComponents() {

        // Variable
        pwd = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bView = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        // Password Input Area
        pwd.setFont(new java.awt.Font("Tahoma", 0, 12));
        pwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdKeyPressed(evt);
            }
        });
        getContentPane().add(pwd);
        pwd.setBounds(175, 450, 220, 30);

        // Username Input Area
        username.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(username);
        username.setBounds(175, 377, 220, 30);

        // Login Button
        btn_login.setText("LOGIN");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(205, 510, 150, 30);
        btn_login.setBackground(new java.awt.Color(0, 128, 255));
        btn_login.setForeground(new java.awt.Color(255, 255, 255));

        // Password Text
        jLabel2.setFont(new java.awt.Font("Arial", 0, 17));
        jLabel2.setForeground(new java.awt.Color(0, 128, 255));
        jLabel2.setText("Username:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(85, 350, 140, 80);

        // Username Text
        jLabel3.setFont(new java.awt.Font("Arial", 0, 17));
        jLabel3.setForeground(new java.awt.Color(0, 128, 255));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(85, 430, 100, 70);

        // Cancel Button
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/cancel1.png")));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1050, -2, 50, 50);

        // Minimums Button
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/mini.png")));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1013, -2, 50, 50);

        // Image
        bView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/loging_back.png")));
        bView.setText("jLabel7");
        getContentPane().add(bView);
        bView.setBounds(563, 42, 546, 713);

        // Logo
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/logo.png")));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 90, 700, 100);

        //Loging Text
        jLabel.setFont(new java.awt.Font("Tahoma", 0, 30));
        jLabel.setForeground(new java.awt.Color(0, 128, 255));
        jLabel.setText("Login");
        Font myFont = new Font("Courier", Font.BOLD,35);
        jLabel.setFont(myFont);
        getContentPane().add(jLabel);
        jLabel.setBounds(230, 280, 140, 80);

        // Input Area Background
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/input_login.png")));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 225, 600,400);

        //Background Pic
       jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/Loging_background.png")));
       getContentPane().add(jLabel1);
       jLabel1.setBounds(0, 42, 1109, 756);

        setSize(new java.awt.Dimension(1109, 756));
        setLocationRelativeTo(null);
    }

    // Window Opening
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        for (double i = 0.0; i <= 1.0; i = i + 0.1)
        {
            String val = i + "F";

            float f = Float.valueOf(val);

            this.setOpacity(f);

            try{
                Thread.sleep(100);

            }catch (Exception e) {}

        }
    }

    //Drag Application
    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
        
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {
         pX = evt.getX();
         pY = evt.getY();
    }

    //Exit Button
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
       int option=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?");
        if(option==0)
        {
            System.exit(0);
        }
    }


    public void close()
    {
        this.dispose();
    }

    private void pwdKeyPressed(java.awt.event.KeyEvent evt) {
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
            conn = Connect.Connectdb();
        if(username.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter your username first.");
            return;

        }
        if(pwd.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You must enter your password.");
            return;
        }


        // Check Username and Password
          try{
            
            String sql = "SELECT * FROM `users` WHERE `Username` = ? AND `Password` = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, username.getText().toUpperCase());
            pst.setString(2, pwd.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                this.hide();
                if(rs.getString("Role").equals("Admin"))
                {
                    long time = System.currentTimeMillis();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
                    close();
                    Dashboard mainPanel = new Dashboard(true, rs.getString("Name"), timestamp.toString());
                    mainPanel.setVisible(true);
                    setTimeStamp(rs.getString("Name"), timestamp.toString());
                }else{
                     long time = System.currentTimeMillis();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
                    close();
                    Dashboard mainPanel = new Dashboard(false, rs.getString("Name") , timestamp.toString());
                    mainPanel.setVisible(true);
                    setTimeStamp(rs.getString("Name"), timestamp.toString());
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "User not found\nKindly check your username/password ", "Error", JOptionPane.ERROR_MESSAGE);

                pwd.setText("");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog( null, "PLEASE CONFIRM YOUR DATABASE IS UP AND RUNNING.","SYSTEM ERROR!! ", JOptionPane.ERROR_MESSAGE);
                       
        }
        }
    }

    // Validation inputs
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
            conn = Connect.Connectdb();
        if(username.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter your username first.");
            return;

        }
        if(pwd.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "You must enter your password.");
            return;
        }

          try{
            
            String sql = "SELECT * FROM `users` WHERE `Username` = ? AND `Password` = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, username.getText().toUpperCase());
            pst.setString(2, pwd.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                this.hide();
                if(rs.getString("Role").equals("Admin"))
                {
                     long time = System.currentTimeMillis();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
                    close();
                    Dashboard mainPanel = new Dashboard(true, rs.getString("Name"), timestamp.toString());
                    mainPanel.setVisible(true);
                    setTimeStamp(rs.getString("Name"), timestamp.toString());
                }else{
                     long time = System.currentTimeMillis();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
                    close();
                    Dashboard mainPanel = new Dashboard(false, rs.getString("Name"), timestamp.toString());
                    mainPanel.setVisible(true);
                    setTimeStamp(rs.getString("Name"), timestamp.toString());
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "User not found\nKindly check your username/password ", "Error", JOptionPane.ERROR_MESSAGE);

                pwd.setText("");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog( null, "PLEASE CONFIRM YOUR DATABASE IS UP AND RUNNING.","SYSTEM ERROR!! ", JOptionPane.ERROR_MESSAGE);
                       
        }
    }


    //Insert Login  Details
    private void setTimeStamp(String User, String TimeStamp)
    {
        try{
            String NewStudent = "INSERT INTO `login_time_stamps`( `User`, `Activity`, `Time`) VALUES ( ?, ?, ? )";
            pst = conn.prepareStatement(NewStudent);
            pst.setString(1, User);
            pst.setString(2, "Logged In");
            pst.setString(3, TimeStamp);
            pst.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
