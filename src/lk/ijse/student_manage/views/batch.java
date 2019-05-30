/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import lk.ijse.student.idgenarator.IDGenarator;
import lk.ijse.student_manage.controller.ControllerFactory;
import lk.ijse.student_manage.controller.custom.BatchController;
import lk.ijse.student_manage.controller.custom.CourseController;
import lk.ijse.student_manage.controller.custom.QueryController;
import lk.ijse.student_manage.controller.custom.batchdetailsController;
import lk.ijse.student_manage.controller.custom.impl.BatchControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.CourseConrollerImpl;
import lk.ijse.student_manage.controller.custom.impl.QueryControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.batchdetailsControllerImpl;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.CoureDTO;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.dto.batchdetailsDTO;

/**
 *
 * @author chamara
 */
public class batch extends javax.swing.JFrame {

    private ArrayList<CoureDTO> CourseList;
    private ArrayList<BatchDTO> batchList;
    private ArrayList<QueryDTO> queryList;
    /**
     * Creates new form batch
     */
    CourseController coursecotroller = new CourseConrollerImpl();
    BatchController batchController = new BatchControllerImpl();
    batchdetailsController bController = new batchdetailsControllerImpl();
    QueryController queryController = new QueryControllerImpl();

    /**
     * Creates new form batch1
     */
    public batch() {
        initComponents();
        getAllCourseDetails();
        IDGenarator();
        getAllBatchDetails();
        //IDGenarator1();
        txtBID.setBorder(null);
        txtBatchDetalId.setBorder(null);
        BatchName.setBorder(null);
        txtcourseID.setBorder(null);

        coursecotroller = (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Course);
        batchController = (BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Batch);
        bController = (batchdetailsController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.batchdetails);
        queryController = (QueryController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Query);
        BatchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (BatchTable.getSelectedRow() == -1) {
                    return;
                }
                txtBatchDetalId.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 0).toString());
            }

        });

        CourseTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (CourseTable1.getSelectedRow() == -1) {
                    return;
                }
                txtcourseID.setText(CourseTable1.getValueAt(CourseTable1.getSelectedRow(), 0).toString());
            }

        });

        CourseTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (CourseTable1.getSelectedRow() == -1) {
                    return;
                }

                txtcourseID.setText(CourseTable1.getValueAt(CourseTable1.getSelectedRow(), 0).toString());
                //  txtcoursename.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 1).toString());
                //  TxtDuration.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 2).toString());
                //  txtCourseFee.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 3).toString());
                //  txtRegfee.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 4).toString());
                //  txtCstatas.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 5).toString());
                //  txtdiscount.setText(BatchTable.getValueAt(BatchTable.getSelectedRow(), 6).toString());
                // txtSchool.setText(CourseTable.getValueAt(CourseTable.getSelectedRow(), 7).toString());
                // comboGender.setSelectedItem(CourseTable.getValueAt(CourseTable.getSelectedRow(),8).toString());

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
        jLabel4 = new javax.swing.JLabel();
        txtBatchDetalId = new javax.swing.JTextField();
        txtcourseID = new javax.swing.JTextField();
        BatchName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btAddStudent = new javax.swing.JLabel();
        btUpdateStudent = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BatchTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        CourseTable1 = new org.jdesktop.swingx.JXTable();
        jLabel7 = new javax.swing.JLabel();
        txtBID = new javax.swing.JTextField();
        ComboBox1Status = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("course Id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 140, 40));
        jPanel1.add(txtBatchDetalId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 220, 30));
        jPanel1.add(txtcourseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 220, 30));
        jPanel1.add(BatchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 220, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 14, 90, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Star Date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Status");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 140, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Batch Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 140, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Batch Detal  ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 140, 30));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

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
        jPanel1.add(btAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 140, 30));

        btUpdateStudent.setBackground(new java.awt.Color(0, 204, 102));
        btUpdateStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btUpdateStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUpdateStudent.setText("Update Student");
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
        jPanel1.add(btUpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 150, 30));

        BatchTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BatchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Batch Id", "starDate", "CoseID", "BatchID", "BatchName", "Status"
            }
        ));
        jScrollPane2.setViewportView(BatchTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 700, 280));

        CourseTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        CourseTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(CourseTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 630, 280));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Batch  ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, 30));
        jPanel1.add(txtBID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 220, 30));

        ComboBox1Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "full time", "part time" }));
        jPanel1.add(ComboBox1Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 220, 20));

        jDateChooser1.setMinimumSize(new java.awt.Dimension(20, 17));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 220, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 220, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 220, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 220, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void btAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddStudentMouseClicked

        try {
            BatchDTO batch = new BatchDTO(
                    txtBID.getText(),
                    BatchName.getText());

            batchdetailsDTO bDTO = new batchdetailsDTO(
                    txtBatchDetalId.getText(),
                    txtBID.getText(),
                    txtcourseID.getText(),
                    ComboBox1Status.getSelectedItem().toString(),
                    jDateChooser1.getDate().toString());

            getAllBatchDetails();
            // System.out.println("Clickd");
            boolean result = batchController.adWithTrance(batch, bDTO);
            getAllCourseDetails();
            //  System.out.println(result);

            if (result) {
                JOptionPane.showMessageDialog(this, "Customer has been successfully updated...!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer has not been updated...!");
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

        /* StudentDTO student = new StudentDTO(
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

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(batch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(batch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(batch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(batch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new batch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BatchName;
    private javax.swing.JTable BatchTable;
    private javax.swing.JComboBox<String> ComboBox1Status;
    private org.jdesktop.swingx.JXTable CourseTable1;
    private javax.swing.JLabel btAddStudent;
    private javax.swing.JLabel btUpdateStudent;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtBID;
    private javax.swing.JTextField txtBatchDetalId;
    private javax.swing.JTextField txtcourseID;
    // End of variables declaration//GEN-END:variables

    private void IDGenarator1() {

        try {
            txtBatchDetalId.setText(IDGenarator.getNewID(" batch", "BAID", "Ba"));

        } catch (SQLException ex) {
            Logger.getLogger(studentview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void IDGenarator() {

        try {
            txtBID.setText(IDGenarator.getNewID("batchdetails", " BID", "B"));

        } catch (SQLException ex) {
            Logger.getLogger(studentview.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentview.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void getAllCourseDetails() {
        try {
            this.CourseList = (ArrayList<CoureDTO>) coursecotroller.getAll();

            DefaultTableModel dtm = (DefaultTableModel) CourseTable1.getModel();

            dtm.setRowCount(0);

            for (CoureDTO Coures : CourseList) {

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

    private void getAllBatchDetails() {
        try {
            this.queryList = (ArrayList<QueryDTO>) queryController.getAll();

            DefaultTableModel dtm = (DefaultTableModel) BatchTable.getModel();

            dtm.setRowCount(0);

            for (QueryDTO Coures : queryList) {

                Object[] rowData = {Coures.getBatchBAID(),
                    Coures.getBatchCourseName(),
                    Coures.getBatchDate(),
                    Coures.getBatchID(),
                    Coures.getBatchName(),
                    Coures.getBatchStatus(),};
                // Coures.getDiscount(),};
                // Coures.getDob(),};

                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
