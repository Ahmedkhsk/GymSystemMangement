package gymsystemmangement;

import Classes.*;
import java.awt.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Home extends javax.swing.JFrame {

    public Home() {

        initComponents();   
        this.setSize(1250, 700);
        ImageIcon imageIcon = new ImageIcon("mainlogo.png");
        this.setIconImage(imageIcon.getImage());

        mytable.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable.getTableHeader().setForeground(Color.decode("#006665"));
        mytable.setRowHeight(35);
        mytable1.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable1.getTableHeader().setForeground(Color.decode("#006665"));
        mytable1.setRowHeight(35);

        mytable2.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable2.getTableHeader().setForeground(Color.decode("#006665"));
        mytable2.setRowHeight(35);
        mytable2.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable4.getTableHeader().setForeground(Color.decode("#006665"));
        mytable4.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable4.setRowHeight(35);
        mytable3.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable3.getTableHeader().setForeground(Color.decode("#006665"));
        mytable3.setRowHeight(35);
        MenuPanel.setSelectedIndex(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        jLabel28.setText("Ahmed Khaled");

        DefaultTableCellRenderer def = new DefaultTableCellHeaderRenderer();
        def.setHorizontalAlignment(SwingConstants.CENTER);
        mytable.setDefaultRenderer(Object.class, def);
        mytable1.setDefaultRenderer(Object.class, def);
        mytable2.setDefaultRenderer(Object.class, def);
        mytable3.setDefaultRenderer(Object.class, def);
        mytable4.setDefaultRenderer(Object.class, def);

        loadTableDataTrainee();
        loadTableDataTrainer();
        loadTableDataPackage();
        loadTableDataEquipment();
        loadTableDataReceptionist();
        LoadTrainersComboBox();
        LoadPackagesComboBox();
        loadDashBord();
    }

    public Home(String use) {
        initComponents();
        this.setSize(1250, 700);
        ImageIcon imageIcon = new ImageIcon("mainlogo.png");
        this.setIconImage(imageIcon.getImage());
        mytable.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable.getTableHeader().setForeground(Color.decode("#006665"));
        mytable.setRowHeight(35);
        mytable1.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable1.getTableHeader().setForeground(Color.decode("#006665"));
        mytable1.setRowHeight(35);

        mytable2.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable2.getTableHeader().setForeground(Color.decode("#006665"));
        mytable2.setRowHeight(35);
        mytable2.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable4.getTableHeader().setForeground(Color.decode("#006665"));
        mytable4.setRowHeight(35);
        mytable4.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable3.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 16));
        mytable3.getTableHeader().setForeground(Color.decode("#006665"));
        mytable3.setRowHeight(35);
        MenuPanel.setSelectedIndex(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jLabel28.setText(use);

        loadTableDataTrainee();
        loadTableDataTrainer();
        loadTableDataPackage();
        loadTableDataEquipment();
        loadTableDataReceptionist();
        LoadTrainersComboBox();
        LoadPackagesComboBox();
        loadDashBord();

        DefaultTableCellRenderer def = new DefaultTableCellHeaderRenderer();
        def.setHorizontalAlignment(SwingConstants.CENTER);
        mytable.setDefaultRenderer(Object.class, def);
        mytable1.setDefaultRenderer(Object.class, def);
        mytable2.setDefaultRenderer(Object.class, def);
        mytable3.setDefaultRenderer(Object.class, def);
        mytable4.setDefaultRenderer(Object.class, def);
    }

    public void loadDashBord() {
        jLabel22.setText(countTrainer() + "");
        jLabel26.setText(countTrainee() + "");
    }

    public void LoadTrainersComboBox() {
        jComboBox4.removeAllItems();
        ArrayList<Trainer> trainers = getTrainers();
        jComboBox4.addItem("Select Trainer");
        for (Trainer t : trainers) {
            jComboBox4.addItem(t.getName());
        }
    }

    public void LoadPackagesComboBox() {
        jComboBox3.removeAllItems();
        ArrayList<Classes.Package> packages = getPackages();
        jComboBox3.addItem("Select Package");
        for (Classes.Package t : packages) {
            jComboBox3.addItem(t.getType());
        }
    }

    public ArrayList<Trainee> getTrainees() {
        ArrayList<Trainee> trainees = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            Statement st = con.createStatement();
            String q = "select * from Trainee";
            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                int id = rs.getInt("TraineeID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                float weight = rs.getFloat("weight");
                float height = rs.getFloat("height");
                String goal = rs.getString("goal");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                int PackageID = rs.getInt("PackageID");
                int TrainerID = rs.getInt("TrainerID");

                Trainee tr = new Trainee(id, name, age, phone, weight, height, goal, startDate, endDate, PackageID, TrainerID);
                trainees.add(tr);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return trainees;
    }

    public ArrayList<Trainer> getTrainers() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            Statement st = con.createStatement();
            String q = "select * from Trainer";
            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                int id = rs.getInt("TrainerID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                float salary = rs.getFloat("salary");
                String speciality = rs.getString("speciality");

                Trainer tr = new Trainer(id, name, age, phone, salary, speciality);
                trainers.add(tr);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return trainers;
    }

    public ArrayList<Classes.Package> getPackages() {
        ArrayList<Classes.Package> packages = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            Statement st = con.createStatement();
            
            String q = "select * from Package";
            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                int id = rs.getInt("PackageID");
                String type = rs.getString("Type");
                int Duration = rs.getInt("Duration");
                float packageFee = rs.getFloat("packageFee");

                Classes.Package pa = new Classes.Package(id, type, Duration, packageFee);
                packages.add(pa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return packages;
    }

    private void loadTableDataTrainee() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "SELECT Trainee.TraineeID, Trainee.name, Trainee.age, Trainee.phone, Trainee.goal, Trainee.weight, Trainee.height, "
                    + "Trainee.startDate, Trainee.endDate, Package.Type AS packageName, Trainer.name AS trainerName "
                    + "FROM Trainee "
                    + "JOIN Package ON Trainee.PackageID = Package.PackageID "
                    + "JOIN Trainer ON Trainee.TrainerID = Trainer.TrainerID";

            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) mytable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("TraineeID"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("phone"),
                    rs.getString("goal"),
                    rs.getFloat("weight"),
                    rs.getFloat("height"),
                    rs.getString("trainerName"),
                    rs.getString("packageName"),
                    rs.getString("startDate"),
                    rs.getString("endDate")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadTableDataTrainer() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "SELECT * FROM Trainer ";

            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) mytable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("TrainerID"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("Speciality"),
                    rs.getString("phone"),
                    rs.getFloat("salary")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTableDataPackage() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "SELECT * FROM Package";

            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) mytable2.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("PackageID"),
                    rs.getString("Type"),
                    rs.getInt("Duration"),
                    rs.getFloat("packageFee")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTableDataEquipment() {
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "SELECT * FROM Equipment";

            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) mytable3.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("EquipmentID"),
                    rs.getString("EquipmentName"),
                    rs.getString("targetMuscle")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTableDataReceptionist() {
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "SELECT * FROM Receptionist";

            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) mytable4.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("ReceptionistID"),
                    rs.getString("ReceptionistName"),};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading table data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void changeBgoffFocus(JButton btn) {
        btn.setForeground(Color.white);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(true);
    }

    public void changeBgOnFocus(JButton btn) {
        btn.setForeground(Color.black);
        btn.setContentAreaFilled(true);
        btn.setBackground(Color.white);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
    }

    public int countTrainee() {
        int count = 0;
        ArrayList<Trainee> trs = getTrainees();

        count = trs.size();
        return count;
    }

    public int countTrainer() {
        int count = 0;

        ArrayList<Trainer> trs = getTrainers();
        count = trs.size();

        return count;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Trainee = new javax.swing.JButton();
        trainerbtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        dashbtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        MenuPanel = new javax.swing.JTabbedPane();
        trainerpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        traineepanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        mytable1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        packagepanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        mytable2 = new javax.swing.JTable();
        dashboard = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        equippanel = new javax.swing.JPanel();
        traineepanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        mytable3 = new javax.swing.JTable();
        receppanel = new javax.swing.JPanel();
        trainerpanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane6 = new javax.swing.JScrollPane();
        mytable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gym Management System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 101));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/logindumbell.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fitness");

        Trainee.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Trainee.setForeground(new java.awt.Color(255, 255, 255));
        Trainee.setText("Trainee");
        Trainee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Trainee.setContentAreaFilled(false);
        Trainee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TraineeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TraineeFocusLost(evt);
            }
        });
        Trainee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraineeActionPerformed(evt);
            }
        });

        trainerbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        trainerbtn.setForeground(new java.awt.Color(255, 255, 255));
        trainerbtn.setText("Trainer");
        trainerbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        trainerbtn.setContentAreaFilled(false);
        trainerbtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trainerbtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                trainerbtnFocusLost(evt);
            }
        });
        trainerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerbtnActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/logpng.png"))); // NOI18N
        jButton4.setText("LogOut");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Package");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Equipment");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        dashbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dashbtn.setForeground(new java.awt.Color(255, 255, 255));
        dashbtn.setText("Dashboard");
        dashbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        dashbtn.setContentAreaFilled(false);
        dashbtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dashbtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dashbtnFocusLost(evt);
            }
        });
        dashbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashbtnActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Receptionist");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trainerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dashbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Trainee, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(dashbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trainerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Trainee, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 780));

        trainerpanel.setBackground(java.awt.Color.white);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("Caoch Name");

        jTextField1.setBackground(new java.awt.Color(238, 238, 238));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.gray);
        jLabel6.setText("Caoch Age");

        jTextField2.setBackground(new java.awt.Color(238, 238, 238));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setText("Phone Number");

        jTextField3.setBackground(new java.awt.Color(238, 238, 238));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setText("Speciality");

        jComboBox2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cardio", "Physique", "Strength", "Performance" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.gray);
        jLabel9.setText("Salary");

        jTextField4.setBackground(new java.awt.Color(238, 238, 238));

        jButton1.setBackground(new java.awt.Color(0, 102, 101));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 101));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 102, 101));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Reset");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 102, 101));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Delete");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(jTextField1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jTextField2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel3))
        );

        mytable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Spciality", "Phone", "Salary"
            }
        ));
        mytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mytable);

        javax.swing.GroupLayout trainerpanelLayout = new javax.swing.GroupLayout(trainerpanel);
        trainerpanel.setLayout(trainerpanelLayout);
        trainerpanelLayout.setHorizontalGroup(
            trainerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        trainerpanelLayout.setVerticalGroup(
            trainerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trainerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        MenuPanel.addTab("Trainer", trainerpanel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.gray);
        jLabel10.setText("Member Name");

        jTextField5.setBackground(new java.awt.Color(238, 238, 238));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.gray);
        jLabel11.setText("Age");

        jTextField6.setBackground(new java.awt.Color(238, 238, 238));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.gray);
        jLabel12.setText("Phone Number");

        jTextField7.setBackground(new java.awt.Color(238, 238, 238));

        jTextField8.setBackground(new java.awt.Color(238, 238, 238));

        jTextField9.setBackground(new java.awt.Color(238, 238, 238));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.gray);
        jLabel13.setText("Weight");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.gray);
        jLabel14.setText("Height");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.gray);
        jLabel15.setText("Goal");

        jTextArea2.setColumns(10);
        jTextArea2.setRows(2);
        jTextArea2.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTextArea2);

        jComboBox3.setBackground(new java.awt.Color(238, 238, 238));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Package" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.gray);
        jLabel16.setText("Pakcage");

        jButton2.setBackground(new java.awt.Color(0, 102, 101));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 102, 101));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Add");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 101));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Reset");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 102, 101));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Delete");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 102, 101));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("BMR");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jComboBox4.setBackground(new java.awt.Color(238, 238, 238));
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Trainer" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(java.awt.Color.gray);
        jLabel18.setText("Trainer");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel39.setForeground(java.awt.Color.gray);
        jLabel39.setText("00");

        mytable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mytable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Phone", "Goal", "Weight", "Height", "Trainer", "package", "StartD", "EndD"
            }
        ));
        mytable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(mytable1);
        if (mytable1.getColumnModel().getColumnCount() > 0) {
            mytable1.getColumnModel().getColumn(8).setResizable(false);
            mytable1.getColumnModel().getColumn(9).setResizable(false);
        }

        jButton15.setBackground(new java.awt.Color(0, 102, 101));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText(" Subscription");
        jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3))
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(26, 26, 26)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel13)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel14))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(207, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel39)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout traineepanelLayout = new javax.swing.GroupLayout(traineepanel);
        traineepanel.setLayout(traineepanelLayout);
        traineepanelLayout.setHorizontalGroup(
            traineepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        traineepanelLayout.setVerticalGroup(
            traineepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(traineepanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 310, Short.MAX_VALUE))
        );

        MenuPanel.addTab("Trainee", traineepanel);

        packagepanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(java.awt.Color.gray);
        jLabel19.setText("Type");

        jTextField10.setBackground(new java.awt.Color(238, 238, 238));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.gray);
        jLabel20.setText("Duration");

        jTextField11.setBackground(new java.awt.Color(238, 238, 238));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(java.awt.Color.gray);
        jLabel21.setText("Package Fee");

        jTextField12.setBackground(new java.awt.Color(238, 238, 238));

        jButton10.setBackground(new java.awt.Color(0, 102, 101));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Add");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 102, 101));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Update");
        jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton16.setBorderPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 102, 101));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Reset");
        jButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton17.setBorderPainted(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 102, 101));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Delete");
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton18.setBorderPainted(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 1)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(46, 46, 46)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(29, 29, 29)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        mytable2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mytable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Duration", "Package Fee"
            }
        ));
        mytable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(mytable2);

        javax.swing.GroupLayout packagepanelLayout = new javax.swing.GroupLayout(packagepanel);
        packagepanel.setLayout(packagepanelLayout);
        packagepanelLayout.setHorizontalGroup(
            packagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(packagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        packagepanelLayout.setVerticalGroup(
            packagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(packagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(packagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        MenuPanel.addTab("package", packagepanel);

        dashboard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(0, 102, 101));

        jLabel27.setBackground(java.awt.Color.gray);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/icons8-person-100.png"))); // NOI18N

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Mostafa Salah");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel28)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 102, 101));

        jLabel34.setBackground(java.awt.Color.gray);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/icons8-user-groups-64.png"))); // NOI18N

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Number of Trainers");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(28, 28, 28))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel22))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34)))
                .addGap(37, 37, 37)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 102, 101));

        jLabel36.setBackground(java.awt.Color.gray);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/icons8-weight-lifting-68.png"))); // NOI18N

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Number of Trainees");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("10");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(28, 28, 28))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(29, 29, 29))
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/file.png"))); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymsystemmangement/file (4).jpg"))); // NOI18N

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel29))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        MenuPanel.addTab("Workout", dashboard);

        traineepanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(java.awt.Color.gray);
        jLabel17.setText("Equipment Name");

        jTextField13.setBackground(new java.awt.Color(238, 238, 238));

        jTextField16.setBackground(new java.awt.Color(238, 238, 238));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(java.awt.Color.gray);
        jLabel24.setText("Target  Muscles");

        jButton19.setBackground(new java.awt.Color(0, 102, 101));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Update");
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton19.setBorderPainted(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 102, 101));
        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Add");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton20.setBorderPainted(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 102, 101));
        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Reset");
        jButton21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton21.setBorderPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(0, 102, 101));
        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Delete");
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton22.setBorderPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(97, 97, 97)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField16))
                .addGap(153, 153, 153))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mytable3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mytable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipmant Name", "Target Muscles"
            }
        ));
        mytable3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                mytable3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        mytable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytable3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(mytable3);

        javax.swing.GroupLayout traineepanel1Layout = new javax.swing.GroupLayout(traineepanel1);
        traineepanel1.setLayout(traineepanel1Layout);
        traineepanel1Layout.setHorizontalGroup(
            traineepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(traineepanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        traineepanel1Layout.setVerticalGroup(
            traineepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(traineepanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout equippanelLayout = new javax.swing.GroupLayout(equippanel);
        equippanel.setLayout(equippanelLayout);
        equippanelLayout.setHorizontalGroup(
            equippanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equippanelLayout.createSequentialGroup()
                .addComponent(traineepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        equippanelLayout.setVerticalGroup(
            equippanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equippanelLayout.createSequentialGroup()
                .addComponent(traineepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MenuPanel.addTab("Equipment", equippanel);

        trainerpanel1.setBackground(java.awt.Color.white);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton24.setBackground(new java.awt.Color(0, 102, 101));
        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Update");
        jButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton24.setBorderPainted(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 102, 101));
        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Reset");
        jButton25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton25.setBorderPainted(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 102, 101));
        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Delete");
        jButton26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton26.setBorderPainted(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(java.awt.Color.gray);
        jLabel25.setText("New Password");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("00");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(java.awt.Color.gray);
        jLabel31.setText("Name");

        jTextField17.setBackground(new java.awt.Color(238, 238, 238));

        jPasswordField1.setBackground(new java.awt.Color(238, 238, 238));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField17, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(195, 195, 195)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        mytable4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mytable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        mytable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytable4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(mytable4);

        javax.swing.GroupLayout trainerpanel1Layout = new javax.swing.GroupLayout(trainerpanel1);
        trainerpanel1.setLayout(trainerpanel1Layout);
        trainerpanel1Layout.setHorizontalGroup(
            trainerpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainerpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        trainerpanel1Layout.setVerticalGroup(
            trainerpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trainerpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trainerpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout receppanelLayout = new javax.swing.GroupLayout(receppanel);
        receppanel.setLayout(receppanelLayout);
        receppanelLayout.setHorizontalGroup(
            receppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(receppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(receppanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(trainerpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        receppanelLayout.setVerticalGroup(
            receppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(receppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(receppanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(trainerpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MenuPanel.addTab("Receptionist", receppanel);

        getContentPane().add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -36, 990, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TraineeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraineeActionPerformed
        MenuPanel.setSelectedIndex(1);
    }//GEN-LAST:event_TraineeActionPerformed

    private void trainerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerbtnActionPerformed
        MenuPanel.setSelectedIndex(0);
    }//GEN-LAST:event_trainerbtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to LogOut Application", "Confirm", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MenuPanel.setSelectedIndex(2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void dashbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashbtnActionPerformed
        MenuPanel.setSelectedIndex(3);
    }//GEN-LAST:event_dashbtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MenuPanel.setSelectedIndex(4);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
        String name = jTextField2.getText().trim();
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(jTextField1.getText());
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Age Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Age Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float salary;
        try {
            salary = Float.parseFloat(jTextField4.getText());
            if (salary <= 0) {
                JOptionPane.showMessageDialog(null, "Salary Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Salary Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String phone = jTextField3.getText();
        String speciality = jComboBox2.getSelectedItem().toString();
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "INSERT INTO Trainer (name,age,phone,salary,speciality) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, phone);
            pst.setFloat(4, salary);
            pst.setString(5, speciality);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainer();
                LoadTrainersComboBox();
                loadDashBord();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Trainer.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton8ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String name = jTextField2.getText().trim();
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(jTextField1.getText());
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Age Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Age Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float salary;
        try {
            salary = Float.parseFloat(jTextField4.getText());
            if (salary <= 0) {
                JOptionPane.showMessageDialog(null, "Salary Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Salary Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String phone = jTextField3.getText();
        String speciality = jComboBox2.getSelectedItem().toString();
        int id = Integer.parseInt(jLabel3.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");
            String q = "UPDATE Trainer "
                    + "set name = (?),age = (?),phone = (?),salary = (?),speciality = (?)"
                    + "where TrainerID = (?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, phone);
            pst.setFloat(4, salary);
            pst.setString(5, speciality);
            pst.setInt(6, id);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainer Update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainer();
                LoadTrainersComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Trainer.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Reset
            jButton8ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jLabel3.setText("00");
        jComboBox2.setSelectedIndex(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int tid = Integer.parseInt(jLabel3.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "Delete from Trainer where TrainerID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setInt(1, tid);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainer Deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainer();
                LoadTrainersComboBox();
                loadDashBord();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Delete Trainer.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton8ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            int id = Integer.parseInt(jLabel39.getText());
            String name = jTextField5.getText().trim();
            if (!name.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;
            try {
                age = Integer.parseInt(jTextField6.getText());
                if (age <= 0) {
                    JOptionPane.showMessageDialog(null, "Age Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Age Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float weight;
            try {
                weight = Float.parseFloat(jTextField8.getText());
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(null, "Weight Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Weight Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float height;
            try {
                height = Float.parseFloat(jTextField9.getText());
                if (height <= 0) {
                    JOptionPane.showMessageDialog(null, "Height Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Height Weight Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String phone = jTextField7.getText();
            String goal = jTextArea2.getText();
            int PID = jComboBox3.getSelectedIndex();
            int TID = jComboBox4.getSelectedIndex();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "UPDATE Trainee "
                    + "set name = (?),age = (?),phone = (?),weight = (?),height = (?)"
                    + ",goal = (?),PackageID = (?),TrainerID = (?) "
                    + "where TraineeID = (?)";

            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, phone);
            pst.setFloat(4, weight);
            pst.setFloat(5, height);
            pst.setString(6, goal);
            pst.setInt(7, PID);
            pst.setInt(8, TID);
            pst.setInt(9, id);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainee Update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainee();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Trainee.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton12ActionPerformed(evt);

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        String name = jTextField5.getText().trim();
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(jTextField6.getText());
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Age Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Age Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float weight;
        try {
            weight = Float.parseFloat(jTextField8.getText());
            if (weight <= 0) {
                JOptionPane.showMessageDialog(null, "Weight Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Weight Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float height;
        try {
            height = Float.parseFloat(jTextField9.getText());
            if (height <= 0) {
                JOptionPane.showMessageDialog(null, "Height Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Height Weight Input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String phone = jTextField7.getText();
        String goal = jTextArea2.getText();
        
        int PID = jComboBox3.getSelectedIndex();
        int TID = jComboBox4.getSelectedIndex();

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        
        ArrayList<Classes.Package> packages = getPackages();
        
        for (Classes.Package t : packages) 
            if (t.getId() == PID) 
                endDate.add(Calendar.MONTH, t.getDuration());
        
        
        String st;
        String ed;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        st = sdf.format(startDate.getTime());
        ed = sdf.format(endDate.getTime());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "INSERT INTO Trainee(name,age,phone,weight,height,goal,startDate,endDate,PackageID,TrainerID) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, phone);
            pst.setFloat(4, weight);
            pst.setFloat(5, height);
            pst.setString(6, goal);
            pst.setString(7, st);
            pst.setString(8, ed);
            pst.setInt(9, PID);
            pst.setInt(10, TID);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainee added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                loadTableDataTrainee();
                loadDashBord();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Trainee.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton12ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jLabel39.setText("00");
        jTextField5.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextArea2.setText("");
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int tid = Integer.parseInt(jLabel39.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");
            String q = "Delete from Trainee where TraineeID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setInt(1, tid);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Trainee Deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainee();
                loadDashBord();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Delete Trainee.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton12ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            float weight = Float.parseFloat(jTextField8.getText());
            float height = Float.parseFloat(jTextField9.getText());
            int age = Integer.parseInt(jTextField6.getText());

            double BMR = 88.362 + (13.397 * weight) + (4.799 * height) - (4.330 * age);

            JOptionPane.showMessageDialog(null, "BMR is " + BMR, "Calc BMR", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        try {
                String type = jTextField11.getText().trim();
            if (!type.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duration;
            try {
                duration = Integer.parseInt(jTextField10.getText());
                if (duration <= 0) {
                    JOptionPane.showMessageDialog(null, "Duration Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Duration Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float packageFee;
            try {
                packageFee = Float.parseFloat(jTextField12.getText());
                if (packageFee <= 0) {
                    JOptionPane.showMessageDialog(null, "packageFee Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid packageFee Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "INSERT INTO Package (Type,Duration,packageFee) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, type);
            pst.setInt(2, duration);
            pst.setFloat(3, packageFee);
            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Package added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataPackage();
                LoadPackagesComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Package.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton17ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        try {
        int id = Integer.parseInt(jLabel41.getText());
        String type = jTextField11.getText().trim();
            if (!type.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duration;
            try {
                duration = Integer.parseInt(jTextField10.getText());
                if (duration <= 0) {
                    JOptionPane.showMessageDialog(null, "Duration Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Duration Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float packageFee;
            try {
                packageFee = Float.parseFloat(jTextField12.getText());
                if (packageFee <= 0) {
                    JOptionPane.showMessageDialog(null, "packageFee Must be More Than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid packageFee Input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "UPDATE Package "
                    + "set type = (?),duration = (?),packageFee = (?)"
                    + "where PackageID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setString(1, type);
            pst.setInt(2, duration);
            pst.setFloat(3, packageFee);
            pst.setInt(4, id);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Package Update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataPackage();
                LoadPackagesComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Package.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton17ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jLabel41.setText("00");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int pid = Integer.parseInt(jLabel41.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "Delete from Package where PackageID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setInt(1, pid);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "PackageID Deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataPackage();
                LoadPackagesComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Delete PackageID.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton17ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        
        try {
            String name = jTextField17.getText().trim();
            if (!name.matches("^[a-zA-Z\\s]+$")) {
                JOptionPane.showMessageDialog(null, "Name must contain only letters and spaces", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(jLabel33.getText());
            String pass = jPasswordField1.getText();
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");
            String q = "UPDATE Receptionist "
                    + "set ReceptionistName = (?),ReceptionistPassword = (?) where ReceptionistID = (?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setString(2, pass);
            pst.setInt(3, id);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Receptionist Update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataReceptionist();
                jLabel28.setText(name);
            } else {
                JOptionPane.showMessageDialog(null, "Receptionist to Update Trainer.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Reset
            jButton25ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jLabel33.setText("00");
        jTextField17.setText("");
        jPasswordField1.setText("");
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        int id = Integer.parseInt(jLabel33.getText());
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "Delete from Receptionist where ReceptionistID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setInt(1, id);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Receptionist Deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataReceptionist();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Delete Receptionist.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton25ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void dashbtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dashbtnFocusGained

    }//GEN-LAST:event_dashbtnFocusGained

    private void dashbtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dashbtnFocusLost

    }//GEN-LAST:event_dashbtnFocusLost

    private void trainerbtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trainerbtnFocusGained

    }//GEN-LAST:event_trainerbtnFocusGained

    private void trainerbtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trainerbtnFocusLost

    }//GEN-LAST:event_trainerbtnFocusLost

    private void TraineeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TraineeFocusGained

    }//GEN-LAST:event_TraineeFocusGained

    private void TraineeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TraineeFocusLost

    }//GEN-LAST:event_TraineeFocusLost

    private void mytable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytable1MouseClicked

        try {
            int selectedRow = mytable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) mytable1.getModel();

            jLabel39.setText(model.getValueAt(selectedRow, 0).toString());//id
            jTextField5.setText(model.getValueAt(selectedRow, 1).toString()); // Name
            jTextField6.setText(model.getValueAt(selectedRow, 2).toString()); // Age
            jTextField7.setText(model.getValueAt(selectedRow, 3).toString()); // Phone
            jTextArea2.setText(model.getValueAt(selectedRow, 4).toString()); // Goal
            jTextField8.setText(model.getValueAt(selectedRow, 5).toString()); // Weight
            jTextField9.setText(model.getValueAt(selectedRow, 6).toString()); // Height
            jComboBox4.setSelectedItem(model.getValueAt(selectedRow, 7).toString()); // Trainer Name
            jComboBox3.setSelectedItem(model.getValueAt(selectedRow, 8).toString()); // Package Name

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_mytable1MouseClicked

    private void mytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytableMouseClicked
        try {
            int selectedRow = mytable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) mytable.getModel();

            jLabel3.setText(model.getValueAt(selectedRow, 0).toString());
            jTextField2.setText(model.getValueAt(selectedRow, 1).toString());
            jTextField1.setText(model.getValueAt(selectedRow, 2).toString());
            jComboBox2.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
            jTextField3.setText(model.getValueAt(selectedRow, 4).toString());
            jTextField4.setText(model.getValueAt(selectedRow, 5).toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_mytableMouseClicked

    private void mytable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytable2MouseClicked
        try {
            int selectedRow = mytable2.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) mytable2.getModel();

            jLabel41.setText(model.getValueAt(selectedRow, 0).toString());
            jTextField11.setText(model.getValueAt(selectedRow, 1).toString());
            jTextField10.setText(model.getValueAt(selectedRow, 2).toString());
            jTextField12.setText(model.getValueAt(selectedRow, 3).toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_mytable2MouseClicked

    private void mytable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytable4MouseClicked
        try {
            int selectedRow = mytable4.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) mytable4.getModel();

            jLabel33.setText(model.getValueAt(selectedRow, 0).toString());
            jTextField17.setText(model.getValueAt(selectedRow, 1).toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_mytable4MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MenuPanel.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            int PID = Integer.parseInt(jLabel39.getText());
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();

            ArrayList<Classes.Package> packages = getPackages();
            for (Classes.Package t : packages) {
                if (t.getId() == PID) {
                    endDate.add(Calendar.MONTH, t.getDuration());
                }
            }

            String st;
            String ed;

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            st = sdf.format(startDate.getTime());
            ed = sdf.format(endDate.getTime());

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "UPDATE Trainee "
                    + "set startDate = (?) , endDate = (?)"
                    + "where TraineeID = (?)";

            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, st);
            pst.setString(2, ed);
            pst.setInt(3, PID);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Subscription Renewed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataTrainee();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Subscription.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton12ActionPerformed(evt);

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        int eid = Integer.parseInt(jLabel38.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "Delete from Equipment where EquipmentID = (?)";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setInt(1, eid);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Equipment Deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataEquipment();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Delete Equipment.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton21ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        jLabel38.setText("00");
        jTextField13.setText("");
        jTextField16.setText("");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String name = jTextField13.getText();
        String tm = jTextField16.getText();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "INSERT INTO Equipment (EquipmentName,targetMuscle) VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setString(2, tm);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Equipment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataEquipment();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Equipment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton21ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        String name = jTextField13.getText();
        String tm = jTextField16.getText();
        int id = Integer.parseInt(jLabel38.getText());
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem", "root", "");

            String q = "UPDATE Equipment "
                    + "set EquipmentName = (?),targetMuscle = (?) where EquipmentID = (?)";

            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1, name);
            pst.setString(2, tm);
            pst.setInt(3, id);
            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Equipment Update successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTableDataEquipment();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Equipment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jButton21ActionPerformed(evt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void mytable3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mytable3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_mytable3AncestorAdded

    private void mytable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytable3MouseClicked
        try {
            int selectedRow = mytable3.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) mytable3.getModel();

            jLabel38.setText(model.getValueAt(selectedRow, 0).toString());
            jTextField13.setText(model.getValueAt(selectedRow, 1).toString());
            jTextField16.setText(model.getValueAt(selectedRow, 2).toString());
        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_mytable3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane MenuPanel;
    private javax.swing.JButton Trainee;
    private javax.swing.JPanel dashboard;
    private javax.swing.JButton dashbtn;
    private javax.swing.JPanel equippanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable mytable;
    private javax.swing.JTable mytable1;
    private javax.swing.JTable mytable2;
    private javax.swing.JTable mytable3;
    private javax.swing.JTable mytable4;
    private javax.swing.JPanel packagepanel;
    private javax.swing.JPanel receppanel;
    private javax.swing.JPanel traineepanel;
    private javax.swing.JPanel traineepanel1;
    private javax.swing.JButton trainerbtn;
    private javax.swing.JPanel trainerpanel;
    private javax.swing.JPanel trainerpanel1;
    // End of variables declaration//GEN-END:variables
}
