/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.views;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import lk.ijse.student.idgenarator.IDGenarator;
import lk.ijse.student_manage.controller.ControllerFactory;
import lk.ijse.student_manage.controller.custom.BatchController;
import lk.ijse.student_manage.controller.custom.CourseController;
import lk.ijse.student_manage.controller.custom.RegistrationController;
import lk.ijse.student_manage.controller.custom.StudentController;
import lk.ijse.student_manage.controller.custom.impl.BatchControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.CourseConrollerImpl;
import lk.ijse.student_manage.controller.custom.impl.RegistrationControllrtImpl;
import lk.ijse.student_manage.controller.custom.impl.StudentControllerImpl;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.CoureDTO;
import lk.ijse.student_manage.dto.RegistrationDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.studentpayment.jasper.Startjasper;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chamara
 */
public class Registration extends javax.swing.JFrame {

    private ArrayList<RegistrationDTO> registrationList;
    private ArrayList<StudentDTO> StudentList;
    private ArrayList<BatchDTO> BatchList;
    private ArrayList<CoureDTO> CoureList;
    private String searchType = "";
    private ArrayList<RegistrationDTO> searchregistrationList;
    private static StudentDTO studentDTO1;

    /**
     * Creates new form studentview
     */
    RegistrationController registrationcotroller = new RegistrationControllrtImpl();
    StudentController studentcotroller = new StudentControllerImpl();
    BatchController batchController = new BatchControllerImpl();
    CourseController courseController = new CourseConrollerImpl();

    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();
        getAllStudentDetails();
        IDGenarator();
        IDGenarator();
        getAllCourseDetails();
        getAllRegistrationDetails();
        
        txtRegistrationid.setBorder(null);
        txtStudent3.setBorder(null);
        txtStudentname1.setBorder(null);
        txtStudentnic.setBorder(null);
        txtCourseID.setBorder(null);
        txtCourseName.setBorder(null);
        BatchId.setBorder(null);
        RbatchNAme.setBorder(null);
        txtfee.setBorder(null);
        txtFeestaatus.setBorder(null);
        
        
        
        
        
        
        studentcotroller = (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        registrationcotroller = (RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Registion);
        batchController = (BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Batch);
        setStudentID();
        CourseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (CourseTable.getSelectedRow() == -1) {
                    return;
                }
                txtCourseID.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 0).toString());
                txtCourseName.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 1).toString());
                txtfee.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 3).toString());
                txtFeestaatus.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 4).toString());
            }
        });

        CourseTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (CourseTable1.getSelectedRow() == -1) {
                    return;
                }
                BatchId.setText(CourseTable1.getValueAt(CourseTable1.getSelectedRow(), 0).toString());
                RbatchNAme.setText(CourseTable1.getValueAt(CourseTable1.getSelectedRow(), 1).toString());
                //  txtCourseID.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 0).toString());
                // txtCourseName.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 1).toString());

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

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RegistrationTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRegistrationid = new javax.swing.JTextField();
        RbatchNAme = new javax.swing.JTextField();
        txtfee = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        CourseTable1 = new org.jdesktop.swingx.JXTable();
        jLabel3 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtStudentnic = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFeestaatus = new javax.swing.JTextField();
        txtStudentname1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        RegStatus = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        CourseTable = new org.jdesktop.swingx.JXTable();
        BatchId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStudent3 = new javax.swing.JTextField();
        txtCourseID = new javax.swing.JTextField();
        RegistrationDate = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        btAddStudent = new javax.swing.JLabel();
        btUpdateStudent = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 52, 200, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 112, 200, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Course name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 140, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registration ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 117, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Batch name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("fee");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 99, 30));

        RegistrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RID", "SID", "BID", "CID", "RegistrationDAte", "fee", "RegfeeStatus", "regstatas"
            }
        ));
        jScrollPane1.setViewportView(RegistrationTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 424, 670, 270));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RegistrationDate");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 151, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Student name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("RegStatus");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("RegFeeStatus");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 110, 30));

        txtRegistrationid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistrationidActionPerformed(evt);
            }
        });
        jPanel1.add(txtRegistrationid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 202, -1));

        RbatchNAme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbatchNAmeActionPerformed(evt);
            }
        });
        jPanel1.add(RbatchNAme, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 202, -1));
        jPanel1.add(txtfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 202, -1));

        CourseTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "BID", "Batchname"
            }
        ));
        jScrollPane3.setViewportView(CourseTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 140, 270));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Batch ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 140, 30));

        txtCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 202, -1));

        txtStudentnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentnicActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 202, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Student ID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 14, 80, 20));
        jPanel1.add(txtFeestaatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 220, -1));

        txtStudentname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentname1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 202, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Student nic");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 30));

        RegStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "inActive", " " }));
        jPanel1.add(RegStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, 220, -1));

        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CID", "Coursename", "Duration", "Coursefee", "RegFee", "Cstatas", "Discount"
            }
        ));
        jScrollPane4.setViewportView(CourseTable);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, 550, 270));
        jPanel1.add(BatchId, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 200, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Course ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, 30));

        txtStudent3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudent3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudent3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 202, -1));

        txtCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtCourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 202, -1));
        jPanel1.add(RegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 230, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 200, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 49, 200, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 200, -1));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 200, -1));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 200, -1));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 200, 10));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 200, -1));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 200, -1));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 220, -1));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 222, 230, 0));

        btAddStudent.setBackground(new java.awt.Color(51, 204, 255));
        btAddStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btAddStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btAddStudent.setText("Add Registration");
        btAddStudent.setOpaque(true);
        btAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddStudentMouseClicked(evt);
            }
        });
        jPanel2.add(btAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 180, 30));

        btUpdateStudent.setBackground(new java.awt.Color(0, 204, 102));
        btUpdateStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btUpdateStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUpdateStudent.setText("Update Registration");
        btUpdateStudent.setOpaque(true);
        btUpdateStudent.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btUpdateStudentAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btUpdateStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateStudentMouseClicked(evt);
            }
        });
        jPanel2.add(btUpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 200, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("bill");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, 130, 30));

        jComboBox1.setBackground(new java.awt.Color(0, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RegistrationID", "StudentId", "BatchID" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 200, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 340, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddStudentMouseClicked
        try {
            RegistrationDTO registration = new RegistrationDTO();
            registration.setRID(txtRegistrationid.getText());
            registration.setSID(txtStudent3.getText());
            registration.setBID(BatchId.getText());
            registration.setCID(txtCourseID.getText());
            registration.setRegDate(RegistrationDate.getDate().toString());
            //registration.setStatus(RegStatus.getSelectedItem().toString());
            registration.setRegfeestatar(txtFeestaatus.getText());
             registration.setStatus(RegStatus.getSelectedItem().toString());
            registration.setCourse_fee(new BigDecimal(txtfee.getText()));
            // registration.setRegDate((RegistrationDate.toString()));
            //  registration.setRegfeestatar(RegFeeStatus.getSelectedItem().toString());
            // registration.setpDate(date(RegistrationDate.getText()));
            // registration.RegistrationDate.getDate().toString()) 
            //RegistrationDate.getDate().toString())            

            //  txtstatus.getText());
            // getAllRegistrationDetails();
            boolean result = registrationcotroller.add(registration);
            getAllRegistrationDetails();
            if (result) {
                JOptionPane.showMessageDialog(this, "Registration been successfully ...!");
            } else {
                JOptionPane.showMessageDialog(this, "Registration has not been ...!");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }//GEN-LAST:event_btAddStudentMouseClicked

    private void btUpdateStudentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btUpdateStudentAncestorAdded

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

    }//GEN-LAST:event_btUpdateStudentAncestorAdded

    private void btUpdateStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateStudentMouseClicked

        /*   RegistrationDTO registration = new RegistrationDTO(
            tfSID.getText(),
            tfNIC.getText(),
            tfName.getText(),
            txtAddress.getText(),
            txtemail1.getText(),
            TxtDateOfBirth.getText(),
            tfTel.getText(),
            txtSchool.getText(),
            txtMoblie.getText());

        try {
            // System.out.println("Clickd");
            boolean result = studentcotroller.update(student);
            //  System.out.println(result);

            if (result){
                JOptionPane.showMessageDialog(this, "Customer has been successfully updated...!");
            }else{
                JOptionPane.showMessageDialog(this, "Customer has not been updated...!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }//GEN-LAST:event_btUpdateStudentMouseClicked

    private void RbatchNAmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbatchNAmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbatchNAmeActionPerformed

    private void txtRegistrationidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistrationidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistrationidActionPerformed

    private void txtCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNameActionPerformed
        // TODO add 
    }//GEN-LAST:event_txtCourseNameActionPerformed

    private void txtStudentnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentnicActionPerformed

    private void txtCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIDActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtStudent3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudent3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudent3ActionPerformed

    private void txtStudentname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentname1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        // private void jasperReport() {
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(Startjasper.class.getResourceAsStream("/lk/ijse/studentpayment/view/Newresis.jasper"));

            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("pDate}", txtRegistrationid.getText());
            parHashMap.put("CourseFee", txtStudent3.getText());
            parHashMap.put("StudentName", txtStudentname1.getText());
            parHashMap.put("nic", txtStudentname1.getText());
            parHashMap.put("StudentName", txtCourseName.getText());
            parHashMap.put("BatchStartDate", RbatchNAme.getText());

            parHashMap.put("CourseFee", txtFeestaatus.getText());
            parHashMap.put("DueDate", RegistrationDate.getDate());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parHashMap, new JREmptyDataSource());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            java.awt.Container container = jasperViewer.getContentPane();

            JDialog jDialog = new JDialog();
            jDialog.setContentPane(container);
            jDialog.setSize(jasperViewer.getSize());
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*   try {
                JasperReport compiledReport = (JasperReport) JRLoader.loadObject(Startjasper.class.getResourceAsStream("/lk/ijse/studentpayment/jasper/payments.jasper"));
                Connection connection = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/billingsystem", "root", "viraj11");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
                }

                JasperPrint fillledReport = JasperFillManager.fillReport(compiledReport, new HashMap<>(), connection);
                JasperReportViewer jasperReportViewer = new JasperReportViewer(fillledReport);
                jasperReportViewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(Startjasper.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     //   clearTextFields() ;
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BatchId;
    private org.jdesktop.swingx.JXTable CourseTable;
    private org.jdesktop.swingx.JXTable CourseTable1;
    private javax.swing.JTextField RbatchNAme;
    private javax.swing.JComboBox<String> RegStatus;
    private com.toedter.calendar.JDateChooser RegistrationDate;
    private javax.swing.JTable RegistrationTable;
    private javax.swing.JLabel btAddStudent;
    private javax.swing.JLabel btUpdateStudent;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtFeestaatus;
    private javax.swing.JTextField txtRegistrationid;
    private javax.swing.JTextField txtStudent3;
    private javax.swing.JTextField txtStudentname1;
    private javax.swing.JTextField txtStudentnic;
    private javax.swing.JTextField txtfee;
    // End of variables declaration//GEN-END:variables
    private void getAllRegistrationDetails() {
        try {
            this.registrationList = (ArrayList<RegistrationDTO>) registrationcotroller.getAll();

            DefaultTableModel dtm = (DefaultTableModel) RegistrationTable.getModel();

            dtm.setRowCount(0);

            for (RegistrationDTO Registration : registrationList) {

                Object[] rowData = {Registration.getRID(),
                    Registration.getSID(),
                    Registration.getBID(),
                    Registration.getCID(),
                    Registration.getRegDate(),
                    Registration.getCourse_fee(),
                    Registration.getRegfeestatar(),
                    Registration.getStatus(),};
                // Coures.getDob(),};

                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllCourseDetails() {
        try {
            this.CoureList = (ArrayList<CoureDTO>) courseController.getAll();

            DefaultTableModel dtm = (DefaultTableModel) CourseTable.getModel();

            dtm.setRowCount(0);

            for (CoureDTO Coures : CoureList) {

                Object[] rowData = {Coures.getCID(),
                    Coures.getCoursename(),
                    Coures.getDuration(),
                    Coures.getCourse_fee(),
                    Coures.getRegfee(),
                    Coures.getCStatas(),
                    Coures.getDiscount(),};
                // Coures.getDob(),};

                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllStudentDetails() {
        try {
            this.BatchList = (ArrayList<BatchDTO>) batchController.getAll();

            DefaultTableModel dtm = (DefaultTableModel) CourseTable1.getModel();

            dtm.setRowCount(0);

            for (BatchDTO batch : BatchList) {

                Object[] rowData = {batch.getBID(),
                    batch.getBatchname(),};

                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void IDGenarator() {

        try {
            txtRegistrationid.setText(IDGenarator.getNewID("registration", " RID", "R"));

        } catch (SQLException ex) {
            Logger.getLogger(studentview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void getStudentDetails(StudentDTO studentDTO) {
        if (null != studentDTO) {
            studentDTO1 = studentDTO;
            txtStudent3.setText(studentDTO1.getSID());
            txtStudentname1.setText(studentDTO1.getName());
            txtStudentnic.setText(studentDTO1.getNic());
        }

    }

    public void setStudentID() {
//        txtStudent2.setText(studentDTO1.getSID());
//        System.out.println(studentDTO1.getSID());
    }
}
