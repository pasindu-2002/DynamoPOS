
package sellclothes;

import java.awt.*;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;


public class Dashboard extends javax.swing.JFrame {

    // Variables declaration
    private javax.swing.JLabel date_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel time_txt;
    private javax.swing.JLabel txt_time_logged_in;
    private javax.swing.JLabel txthello;

    boolean previledge;
    String ActiveUser = null;
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Constructor
    public Dashboard() {
        initComponents();
        this.pack();
        iconMethod();
        TimeClass();
    }

    // Constructor
    public Dashboard(boolean accessLevel, String username, String timee) {
        initComponents();
        jMenu2.setVisible(accessLevel);
        jMenu3.setVisible(accessLevel);
        jMenu2.setVisible(accessLevel);
        jLabel5.setEnabled(accessLevel);
        txthello.setText(": "+username);
        ActiveUser = username;
        
        previledge = accessLevel;
        this.pack();
        iconMethod();
        TimeClass();
        
        txt_time_logged_in.setText("You Logged in at: " + timee);
    }

    // Get Icon
    public void iconMethod()
    {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    // Get Time
    public void TimeClass()
    {
        
        SimpleDateFormat d = new SimpleDateFormat("dd:MM:yyyy");
        Date date = new Date();
        date_txt.setText(": "+ d.format(date));
        Thread gregtime = new Thread()
            {
            public void run(){
                try {
                    for(;;){
                    GregorianCalendar time = new GregorianCalendar();
                         int hour = time.get(Calendar.HOUR_OF_DAY);
                         int min = time.get(Calendar.MINUTE); 
                         int sec =time.get (Calendar.SECOND);
                         time_txt.setText(": "+hour+":"+min+":"+sec);
                         
                    sleep(1000);
                } }catch (InterruptedException ex) {}
            }
            };
    
            gregtime.start();
            
            
    }

    // Designing
    private void initComponents() {

        txthello = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        date_txt = new javax.swing.JLabel();
        time_txt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_time_logged_in = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        //Set Close Button
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Title
        setTitle("Dynamo POS - System Dashboard");
        setResizable(false);

        //User Account
        txthello.setFont(new java.awt.Font("Tahoma", 1, 18));
        txthello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/User.png")));
        txthello.setText(" JL");

        //DynamoPOS Logo
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/welcome.png")));
        jLabel1.setText(" ");

        //Date icon
        date_txt.setFont(new java.awt.Font("Tahoma", 1, 18));
        date_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/date.png")));
        date_txt.setText("jLabel2");

        //Time icon
        time_txt.setFont(new java.awt.Font("Tahoma", 1, 18));
        time_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/time1.png")));
        time_txt.setText("jLabel3");

        //View Item Section
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/viewItem.png")));
        jLabel4.setText("VIEW ITEMS");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        //Add User Section
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/Add_user.png")));
        jLabel5.setText("ADD USER");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        //Sell Item Section
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/cart1.png")));
        jLabel6.setText("  SELL ITEMS");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        //View Users Section
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/viewUser.png")));
        jLabel7.setText("  VIEW USERS");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        //Analysis Section
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/sales.png")));
        jLabel8.setText("    ANALYSIS");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        //Stock Section
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/store.png")));
        jLabel9.setText("STOCK");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        //New Complaint Section
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/addComment.png")));
        jLabel10.setText("NEW COMPLAINT");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        //View Complaints Section
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/comment2.png")));
        jLabel11.setText("VIEW COMPLAINTS");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        //Logout Icon
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/logout.png")));
        jLabel2.setText("");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        //Set Login Time
        txt_time_logged_in.setFont(new java.awt.Font("Tahoma", 1, 11));
        txt_time_logged_in.setText("jLabel3");

        //Sales Menu
        jMenu1.setText("Sales");
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/bar-code_48x48.png")));
        jMenuItem4.setText("Sell Item");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/project-plan_48x48.png")));
        jMenuItem5.setText("Sales Analysis Report");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenuBar1.add(jMenu1);


        //Stock Management Menu
        jMenu2.setText("Stock Management");
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/additem.png")));
        jMenuItem3.setText("Add Item");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/updateitem.png")));
        jMenuItem14.setText("Update Item");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/view_Item.png")));
        jMenuItem7.setText("View Items");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/sales_mini.png")));
        jMenuItem12.setText("Product sales Analysis");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);
        jMenuBar1.add(jMenu2);


        //User Management Menu
        jMenu3.setText("User Management");
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/adduser.png")));
        jMenuItem1.setText("Add User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/updateuser.png")));
        jMenuItem13.setText("Update User");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/view_Item.png")));
        jMenuItem8.setText("View Users");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);
        jMenuBar1.add(jMenu3);


        //System Menu
        jMenu4.setText("System");
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/setting.png")));
        jMenuItem6.setText("Settings");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attatchments/About.png")));
        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        // Set Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_time_logged_in, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txthello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(date_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(time_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(date_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(time_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_time_logged_in, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        setSize(new java.awt.Dimension(1369, 730));
        setLocationRelativeTo(null);
    }


    //About section menu bar
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        About a = new About(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }

    //Add Item menu bar
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        AddItem a = new AddItem(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }

    // Cart(Checkout section) Menu bar
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        SellCartItems s = new SellCartItems(ActiveUser);
        s.setVisible(true);
    }

    //Sales Analysis Menu bar
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        SalesAnalysis a = new SalesAnalysis(this, rootPaneCheckingEnabled);
        a.setVisible(true);

    }

    //Setting Menu Bar
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
        Settings s = new Settings(this, rootPaneCheckingEnabled);
        s.setVisible(true);
    }

    //View Stock Menu bar
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewStock v = new ViewStock(this, rootPaneCheckingEnabled);
        v.setVisible(true);
    }

    //View Complaint Menu bar
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewComplaints v = new ViewComplaints(this, rootPaneCheckingEnabled);
        v.setVisible(true);
    }


    //Add Complaint Menu bar
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {
        RecordComplaint r = new RecordComplaint(this, rootPaneCheckingEnabled);
        r.setVisible(true);
    }

    // Cart(Checkout section) Main Menu
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
        SellCartItems s = new SellCartItems(ActiveUser);
        s.setVisible(true);
    }

    // Add User Main Menu
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
        if(previledge == true)
        {
            Users u = new Users(this, rootPaneCheckingEnabled);
            u.setVisible(true);
        }
        
    }

    //Product Sale Analysis Main Menu
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
        SalesAnalysis u = new SalesAnalysis(this, rootPaneCheckingEnabled);
        u.setVisible(true);
    }

    //Add Complaints Main Menu
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
        RecordComplaint r = new RecordComplaint(this, rootPaneCheckingEnabled);
        r.setVisible(true);
    }

    //View Complaints Main Menu
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
        ViewComplaints v = new ViewComplaints(this, rootPaneCheckingEnabled);
        v.setVisible(true);
    }

    //View Stock Main Menu
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
        ViewStock s = new ViewStock(this, rootPaneCheckingEnabled);
        s.setVisible(true);
    }

    //View Users Main Manu
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
        ViewUsers s = new ViewUsers(this, rootPaneCheckingEnabled);
        s.setVisible(true);
    }

    //View Item Details
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        ViewItems v = new ViewItems(this, rootPaneCheckingEnabled);
        v.setVisible(true);
    }

    //Update Complaint Menu bar
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {
        UpdateComplaint u = new UpdateComplaint(this, rootPaneCheckingEnabled);
        u.setVisible(true);
    }


    //Update User Menu bar
    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {
        UpdateUser u = new UpdateUser(this, rootPaneCheckingEnabled);
        u.setVisible(true);
        
    }

    //Product Sale Analysis Menu bar
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {
        SalesAnalysis u = new SalesAnalysis(this, rootPaneCheckingEnabled);
        u.setVisible(true);
    }


    //Add Users Menu bar
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        Users u =new Users(this, rootPaneCheckingEnabled);
        u.setVisible(true);
    }

    //View User Details Menu bar
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewUsers v = new ViewUsers(this, rootPaneCheckingEnabled);
        v.setVisible(true);
    }


    //Logout Alert box Menu bar
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
       int p = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "System Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
        if (p == 0)
        {
            long time = System.currentTimeMillis();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
            UserLogin u = new UserLogin();
            u.setVisible(true);
            setTimeStamp(ActiveUser, timestamp.toString());
            this.dispose();
        }
    }

    //Update Item Details Menu bar
    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {
       UpdateItem s = new UpdateItem(this, previledge);
       s.setVisible(true);
    }


    // Insert Login Details
    private void setTimeStamp(String User, String TimeStamp)
    {
        DatabaseConnection.DbConnection Connect = new DatabaseConnection.DbConnection();
            conn = Connect.Connectdb();
        try{
            String NewStudent = "INSERT INTO `login_time_stamps`( `User`, `Activity`, `Time`) VALUES ( ?, ?, ? )";
            pst = conn.prepareStatement(NewStudent);
            pst.setString(1, User);
            pst.setString(2, "Logged Out");
            pst.setString(3, TimeStamp);
            pst.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }


}
