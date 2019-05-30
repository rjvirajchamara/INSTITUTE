/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.views;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import lk.ijse.student.idgenarator.IDGenarator;
import lk.ijse.student_manage.controller.ControllerFactory;
import lk.ijse.student_manage.controller.custom.CourseController;
import lk.ijse.student_manage.controller.custom.GurdlanController;
import lk.ijse.student_manage.controller.custom.QueryController;
import lk.ijse.student_manage.controller.custom.StudentController;
import lk.ijse.student_manage.controller.custom.impl.CourseConrollerImpl;
import lk.ijse.student_manage.controller.custom.impl.GurdlanControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.QueryControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.StudentControllerImpl;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.GurdlanDTO;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.studentpayment.jasper.Startjasper;
import lk.ijse.studentpayment.util.JasperReportViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author chamara
 *
 */
public class studentview extends javax.swing.JFrame {

   // private ArrayList<StudentDTO> StudentList;
    private  ArrayList<QueryDTO> queryList;

    private String searchType = "";
  //  private ArrayList<StudentDTO> searchStudentList;
    private  ArrayList<QueryDTO> searchQStudentList;
private  Connection connection;
    /**
     * Creates new form studentview
     */
    StudentController studentcotroller = new StudentControllerImpl();
    GurdlanController gurdlanController = new GurdlanControllerImpl();
    QueryController queryController=  new QueryControllerImpl();
      CourseController coursecotroller = new CourseConrollerImpl();

    
      private void clearTextFields() {
        tfSID.setText("");
        tfName.setText("");
        txtnice.setText("");
         txtemail1.setText("");
         txtSchool.setText("");
         txtAddress.setText("");
         //txtDateOfbirth.setText("");
         txtwrite.setText("");
         connection = ConnectionFactory.getInstance().getConnection();
    }

    
    
    
    public studentview() {
        initComponents();
        getAllStudentDetails();
        IDGenarator();
        IDGenarator1();
        
        
        tfSID.setBorder(null);
        tfName.setBorder(null);
        txtnice.setBorder(null);
        txtemail1.setBorder(null);
        txtSchool.setBorder(null);
        txtAddress.setBorder(null);
      //  txtDateOfbirth.setBorder(null);
        txtwrite.setBorder(null);
        TxtTel.setBorder(null);
        workig.setBorder(null);
        txtGAddress.setBorder(null);
        GEmail.setBorder(null);
        txtNameOFParent.setBorder(null);
        txttelephone.setBorder(null);
        txtMobile.setBorder(null);
        txtUniversityOrother.setBorder(null);
        txtgid.setBorder(null);
        txt1design.setBorder(null);

        studentcotroller = (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        queryController=(QueryController)ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Query);
        StudentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (StudentTable.getSelectedRow() == -1) {
                    return;
                }

                tfSID.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 0).toString());
               // tfNIC.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 1).toString());
                tfName.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 1).toString());
                txtAddress.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 2).toString());
                TxtTel.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 3).toString());
                txtnice.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 6).toString());
                comboGender.setSelectedItem(StudentTable.getValueAt(StudentTable.getSelectedRow(),5).toString());
                txtemail1.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 7).toString());
                txtSchool.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 4).toString());
               Date.setDateFormatString(StudentTable.getValueAt(StudentTable.getSelectedRow(), 8).toString());
                
                //TxtTel.setText(StudentTable.getValueAt(StudentTable.getSelectedRow(), 8).toString());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkerboardPainter1 = new org.jdesktop.swingx.painter.CheckerboardPainter();
        checkerboardPainter2 = new org.jdesktop.swingx.painter.CheckerboardPainter();
        email2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        typecombo = new javax.swing.JComboBox();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        StudentTable = new org.jdesktop.swingx.JXTable();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        txtwrite = new javax.swing.JTextField();
        TxtTel = new javax.swing.JTextField();
        txtSchool = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtemail1 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        txtAddress = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        btAddStudent = new javax.swing.JLabel();
        btUpdateStudent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUniversityOrother = new javax.swing.JTextField();
        comboGender = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtnice = new javax.swing.JTextField();
        txttelephone = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        tfSID = new javax.swing.JTextField();
        workig = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtNameOFParent = new javax.swing.JTextField();
        txtGAddress = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        GEmail = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt1design = new javax.swing.JTextField();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jXMultiSplitPane1 = new org.jdesktop.swingx.JXMultiSplitPane();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jSeparator18 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCombohighereduqua = new javax.swing.JComboBox<>();
        txtgid = new javax.swing.JTextField();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Date = new com.toedter.calendar.JDateChooser();
        tfSID12 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 230, -1));

        typecombo.setBackground(new java.awt.Color(0, 255, 255));
        typecombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        typecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SID", "Name", "Address", "Telephone", "School", "email", "dob" }));
        typecombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typecomboItemStateChanged(evt);
            }
        });
        typecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typecomboActionPerformed(evt);
            }
        });
        getContentPane().add(typecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 170, 31));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 230, -1));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 368, 230, -1));

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "FUll Name", "Address", "Telephone", "School", "Email", "NIC", "DoB", "Hignereduquq", "Gname", "Gmobile", " GAddress"
            }
        ));
        jScrollPane3.setViewportView(StudentTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1350, 250));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 230, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 52, 230, 0));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 200, -1));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 230, -1));

        txtwrite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtwrite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtwrite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        txtwrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtwriteActionPerformed(evt);
            }
        });
        txtwrite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtwriteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtwriteKeyReleased(evt);
            }
        });
        getContentPane().add(txtwrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 230, 30));

        TxtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelActionPerformed(evt);
            }
        });
        getContentPane().add(TxtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 230, -1));
        getContentPane().add(txtSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("gender");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 60, 20));

        txtemail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemail1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtemail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 230, -1));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 230, -1));
        getContentPane().add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 230, 0));

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 230, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 230, -1));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 230, 0));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 230, -1));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 220, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 230, 0));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 132, 230, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("back");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 70, 20));

        btAddStudent.setBackground(new java.awt.Color(51, 204, 255));
        btAddStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btAddStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btAddStudent.setText("Add Student");
        btAddStudent.setOpaque(true);
        btAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddStudentMouseClicked(evt);
            }
        });
        getContentPane().add(btAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 140, 30));

        btUpdateStudent.setBackground(new java.awt.Color(0, 204, 102));
        btUpdateStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btUpdateStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUpdateStudent.setText("Update Student");
        btUpdateStudent.setOpaque(true);
        btUpdateStudent.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btUpdateStudentAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btUpdateStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateStudentMouseClicked(evt);
            }
        });
        getContentPane().add(btUpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("University or other");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 30));

        txtUniversityOrother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversityOrotherActionPerformed(evt);
            }
        });
        getContentPane().add(txtUniversityOrother, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 230, -1));

        comboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female" }));
        getContentPane().add(comboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 230, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 110, -1));

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 420, 40, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tel");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 20, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 52, 230, -1));

        txtnice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtniceActionPerformed(evt);
            }
        });
        getContentPane().add(txtnice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 230, -1));

        txttelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelephoneActionPerformed(evt);
            }
        });
        getContentPane().add(txttelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 230, -1));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 230, 0));

        tfSID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSIDActionPerformed(evt);
            }
        });
        getContentPane().add(tfSID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 230, -1));

        workig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workigActionPerformed(evt);
            }
        });
        getContentPane().add(workig, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 160, 230, 20));
        getContentPane().add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 230, -1));

        txtNameOFParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameOFParentActionPerformed(evt);
            }
        });
        getContentPane().add(txtNameOFParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 230, 20));

        txtGAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtGAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 230, 20));

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 230, 20));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 230, -1));
        getContentPane().add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 230, -1));

        GEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GEmailActionPerformed(evt);
            }
        });
        getContentPane().add(GEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 280, 230, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Working place");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 130, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Address");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 130, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Designation");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 130, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 130, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("back");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 14, 80, 20));
        getContentPane().add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Higher edu qua");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 130, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText(" PARENT/GUARDIAN DETAILS");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 380, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Nic");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 50, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Email");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Student ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Full Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Address");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("telephone");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 130, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("DateOfbirth");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 130, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("mobile");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 130, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Name of parent");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 130, -1));
        getContentPane().add(txt1design, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 230, 20));
        getContentPane().add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, 230, -1));
        getContentPane().add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 300, 230, -1));
        getContentPane().add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 72, 230, 0));
        getContentPane().add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 120, 230, -1));
        getContentPane().add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 182, 230, 0));
        getContentPane().add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 240, 230, -1));
        getContentPane().add(jXMultiSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));
        getContentPane().add(jXCollapsiblePane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 132, 230, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Designation");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 130, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("guardialid");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 130, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Email");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 130, -1));

        jCombohighereduqua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Master", "Degree", "Diplomas", "A/L", "O/L" }));
        jPanel2.add(jCombohighereduqua, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 230, -1));

        txtgid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgidActionPerformed(evt);
            }
        });
        jPanel2.add(txtgid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 230, -1));
        jPanel2.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 230, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("School");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 110, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Next");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 410, 90, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("print details");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 120, 30));
        jPanel2.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 240, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 760));

        tfSID12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSID12ActionPerformed(evt);
            }
        });
        getContentPane().add(tfSID12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 230, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -110, 1700, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddStudentMouseClicked
        try {
             StudentDTO student = new StudentDTO(
                    tfSID.getText(),
                    tfName.getText(),
                    txtAddress.getText(),
                    TxtTel.getText(),
                    txtSchool.getText(),
                    (String) comboGender.getSelectedItem(),
                    txtemail1.getText(),
                    Date.getDate().toString(),
                    txtnice.getText(),
                     txtUniversityOrother.getText(),
                     (String)jCombohighereduqua.getSelectedItem());
            
            
            
            
            GurdlanDTO urdlanDTO= new GurdlanDTO(
                    txtgid.getText(),
                    tfSID.getText(),
                    txtNameOFParent.getText(),
                    txttelephone.getText(),
                    txtMobile.getText(),
                    txt1design.getText(),
                    workig.getText(),
                    txtGAddress.getText(),
                    GEmail.getText());
                    
            
            
            
            //System.out.println("ghjkl");
          
                   // txtNice.getText());
                   // TxtDateOfBirth.getText().toString());
                    
            
            boolean result = studentcotroller.adWithTrance(student,urdlanDTO);
            getAllStudentDetails();
            if (result) {
                JOptionPane.showMessageDialog(this, "Student has been successfully added...!");
            } else {
                JOptionPane.showMessageDialog(this, "Student has not been added...!");
            }
        } catch (Exception ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btAddStudentMouseClicked

    private void btUpdateStudentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btUpdateStudentAncestorAdded

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {


    }//GEN-LAST:event_btUpdateStudentAncestorAdded

    private void btUpdateStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateStudentMouseClicked

        StudentDTO student = new StudentDTO(
                  tfSID.getText(),
                    tfName.getText(),
                    txtAddress.getText(),
                    TxtTel.getText(),
                    txtSchool.getText(),
                    (String) comboGender.getSelectedItem(),
                    txtemail1.getText(),
                    Date.getDate().toString(),
                    txtnice.getText(),
                     txtUniversityOrother.getText(),
                     (String)jCombohighereduqua.getSelectedItem());
                    
        try {
            // System.out.println("Clickd");
            boolean result = studentcotroller.update(student);
            getAllStudentDetails();
              System.out.println("date"+student.getDob());

            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been successfully updated...!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer has not been updated...!");
            }
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btUpdateStudentMouseClicked

    private void tfSIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSIDActionPerformed

    private void txtemail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemail1ActionPerformed

    private void txtniceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtniceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtniceActionPerformed

    private void typecomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typecomboItemStateChanged
        txtwrite.setText("");
        this.searchType = (String) typecombo.getSelectedItem();
    }//GEN-LAST:event_typecomboItemStateChanged

    private void typecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typecomboActionPerformed

    private void txtwriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtwriteActionPerformed
        addTableDetails();
    }//GEN-LAST:event_txtwriteActionPerformed

    private void txtwriteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwriteKeyPressed

    }//GEN-LAST:event_txtwriteKeyPressed

    private void txtwriteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwriteKeyReleased
        this.searchType = (String) typecombo.getSelectedItem();
        searchStudentDetails(searchType, txtwrite.getText());

    }//GEN-LAST:event_txtwriteKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       Registration registrationView = new Registration();
        registrationView.setVisible(true);
                StudentDTO student = new StudentDTO(
                 tfSID.getText(),
                    tfName.getText(),
                    txtAddress.getText(),
                    TxtTel.getText(),
                    txtSchool.getText(),
                    (String) comboGender.getSelectedItem(),
                    txtemail1.getText(),
                    txtnice.getText(),
                    txtnice.getText(),
                     txtUniversityOrother.getText(),
                     (String)jCombohighereduqua.getSelectedItem());
                        
              //  (String) comboGender.getSelectedItem());
                
                registrationView.getStudentDetails(student);
        removeAll();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        getAllStudentDetails();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearTextFields() ;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelephoneActionPerformed

    private void TxtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTelActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Home h=new Home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Home h=new Home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void txtUniversityOrotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversityOrotherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversityOrotherActionPerformed

    private void txtGAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGAddressActionPerformed

    private void workigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workigActionPerformed

    private void txtNameOFParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameOFParentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameOFParentActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void GEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GEmailActionPerformed

    private void tfSID12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSID12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSID12ActionPerformed

    private void txtgidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgidActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       try {
            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(Startjasper.class.getResourceAsStream("/lk/ijse/studentpayment/view/Payment333_A4.jasper"));

            JasperPrint fillledReport = JasperFillManager.fillReport(compiledReport, new HashMap<>(), connection);
            JasperReportViewer jasperReportViewer = new JasperReportViewer(fillledReport);
            jasperReportViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JTextField GEmail;
    private org.jdesktop.swingx.JXTable StudentTable;
    private javax.swing.JTextField TxtTel;
    private javax.swing.JLabel btAddStudent;
    private javax.swing.JLabel btUpdateStudent;
    private javax.swing.JButton btn_refresh;
    private org.jdesktop.swingx.painter.CheckerboardPainter checkerboardPainter1;
    private org.jdesktop.swingx.painter.CheckerboardPainter checkerboardPainter2;
    private javax.swing.JComboBox<String> comboGender;
    private javax.swing.JTextField email2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCombohighereduqua;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXMultiSplitPane jXMultiSplitPane1;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSID;
    private javax.swing.JTextField tfSID12;
    private javax.swing.JTextField txt1design;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtGAddress;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtNameOFParent;
    private javax.swing.JTextField txtSchool;
    private javax.swing.JTextField txtUniversityOrother;
    private javax.swing.JTextField txtemail1;
    private javax.swing.JTextField txtgid;
    private javax.swing.JTextField txtnice;
    private javax.swing.JTextField txttelephone;
    private javax.swing.JTextField txtwrite;
    private javax.swing.JComboBox typecombo;
    private javax.swing.JTextField workig;
    // End of variables declaration//GEN-END:variables
 private void addTableDetails() {
    }

    private void getAllStudentDetails() {
        try {
            this.queryList = (ArrayList<QueryDTO>) queryController.getALlstudent();

            DefaultTableModel dtm = (DefaultTableModel) StudentTable.getModel();

            dtm.setRowCount(0);

            for (QueryDTO student : queryList) {

                Object[] rowData = {student.getSID(),
                    student.getName(),
                    student.getAddress(),
                    student.getTelephone(),
                    student.getSchool(),
                  //  student.getGender(),
                    student.getEmail(),
                     student.getNIC(),
                    student.getDob(),
                    student.getHignereduquq(),
                    student.getGname(),
                    student.getGmobile(),
                    student.getEmail(),};
                    

                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchStudentDetails(String type, String searchText) {

        System.out.println("T"+searchType);
         System.out.println("st"+searchText);
       // System.out.println("sL"+StudentList);
        System.out.println("Result  " + type.equals("SID"));
        if (type.equals("SID")) {

            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getSID().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);

                }
            }
        } else if (type.equals("Name")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getName().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);
                }
            }
        } else if (type.equals("Address")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getAddress().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);
                }
            }
        } else if (type.equals("Telephone")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getTelephone().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);
                }
            }
        } else if (type.equals("School")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getSchool().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);
                }

            }
        } else if (type.equals("email")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getEmail().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);

                }
            }
        } else if (type.equals("dob")) {
            searchQStudentList = new ArrayList<>();
            for (QueryDTO queryDTO : queryList) {
                if (queryDTO.getDob().toLowerCase().contains(searchText.toLowerCase())) {
                    searchQStudentList.add(queryDTO);
                }
            }
        }
        try {

            DefaultTableModel dtm = (DefaultTableModel) StudentTable.getModel();

            dtm.setRowCount(0);

            for (QueryDTO student : searchQStudentList) {

                Object[] rowData = {student.getSID(),
                    
                   student.getName(),
                    student.getAddress(),
                    student.getTelephone(),
                    student.getSchool(),
                  //  student.getGender(),
                    student.getEmail(),
                    student.getNIC(),
                    student.getDob(),
                    student.getHignereduquq(),
                    student.getGname(),
                    student.getGmobile(),
                    student.getEmail(),};
          //      System.out.println("nic"+student.getNIC());
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void IDGenarator() {

        try {
            tfSID.setText(IDGenarator.getNewID("Student", " SID", "S"));

        } catch (SQLException ex) {
            Logger.getLogger(studentview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void IDGenarator1() {

        try {
            txtgid.setText(IDGenarator.getNewID("gurdlan", "Gid", "G"));

        } catch (SQLException ex) {
            Logger.getLogger(studentview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);
        }

     }}
