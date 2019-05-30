/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.views;

import lk.ijse.studentpayment.util.JasperReportViewer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import lk.ijse.student_manage.controller.custom.PeymentController;
import lk.ijse.student_manage.controller.custom.QueryController;
import lk.ijse.student_manage.controller.custom.RegistrationController;
import lk.ijse.student_manage.controller.custom.StudentController;
import lk.ijse.student_manage.controller.custom.TaxController;
import lk.ijse.student_manage.controller.custom.impl.BatchControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.CourseConrollerImpl;
import lk.ijse.student_manage.controller.custom.impl.PeymentControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.QueryControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.RegistrationControllrtImpl;
import lk.ijse.student_manage.controller.custom.impl.StudentControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.TaxControllerImpl;
import lk.ijse.student_manage.controller.custom.paymenttypeController;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.CoureDTO;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.dto.RegistrationDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.TaxDTO;
import lk.ijse.student_manage.dto.paymentTypeDTO;
import lk.ijse.student_manage.dto.paymentDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.TaxService;
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
 *
 */
public class peyment extends javax.swing.JFrame {

    private ArrayList<QueryDTO> peymentQueryList;
    private ArrayList<QueryDTO> searchpeymentQueryList;
    private ArrayList<paymentDTO> peymenttList;
    private String searchType = "";
    private ArrayList<paymentDTO> searchpeymentList;
    private static StudentDTO studentDTO1;
    private static studentview st;
    private static int lateFeeRate = 0;
    private static int govTax = 2;
    private String paymentType = "defualt";
    /**
     * Creates new form studentview
     */
    private Connection connection;
    PeymentController peymentcotroller = new PeymentControllerImpl();

    RegistrationController registrationController = new RegistrationControllrtImpl();
    CourseController coursecotroller = new CourseConrollerImpl();
    BatchController batchController = new BatchControllerImpl();
    StudentController studentcotroller = new StudentControllerImpl();
    TaxController taxController = new TaxControllerImpl();
    QueryController queryController = new QueryControllerImpl();

    private void clearTextFields() {
        txtPeymentId.setText("");
        txtRegistratiaID.setText("");

        txtCourseFee.setText("");
        txtAmount.setText("");
        txtDiscount.setText("");
        txtGovRate.setText("");
        secondAmount.setText("");
        txtTax.setText("");
        txtdelayIntrst.setText("");
        //txtDuPaymentDate.setText("");
        txtSecondAmount.setText("");
        txtblase.setText("");
        StudentName134.setText("");
        txtPDate.setText("");
        txtTax.setText("");
        txtdelayIntrst.setText("");
        txtTotalAmount.setText("");
        txtCoursename.setText("");
        secondAmount.setText("");
        Amount.setText("");
        txtsrach.setText("");

    }

    public peyment() {
        initComponents();
        getAllPeymentDetails();
        IDGenarator();
        connection = ConnectionFactory.getInstance().getConnection();
        setCurrentDate();

        // jasperReport();
        txtGovRate.setText(String.valueOf(govTax));
        // searchStudentDetails1();
        //  searchpaymentDetails1();
        txtPeymentId.setBorder(null);
        txtRegistratiaID.setBorder(null);

        txtCourseFee.setBorder(null);
        txtAmount.setBorder(null);
        txtDiscount.setBorder(null);
        txtGovRate.setBorder(null);
        secondAmount.setBorder(null);
        txtTax.setBorder(null);
        txtdelayIntrst.setBorder(null);
        txtDuPaymentDate.setBorder(null);
        txtSecondAmount.setBorder(null);
        txtblase.setBorder(null);
        StudentName134.setBorder(null);
        txtPDate.setBorder(null);
        txtTax.setBorder(null);
        txtdelayIntrst.setBorder(null);
        txtTotalAmount.setBorder(null);
        txtCoursename.setBorder(null);
        secondAmount.setBorder(null);
        Amount.setBorder(null);
        txtsrach.setBorder(null);
        //  txtStudentNice.setBounds(null);
        //StudentName.setBounds(null);
        queryController = (QueryController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Query);
        taxController = (TaxController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Tax);
        coursecotroller = (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Course);
        studentcotroller = (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        batchController = (BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Batch);
        peymentcotroller = (PeymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.payment);
        queryController = (QueryController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.Query);
        peymentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (peymentTable.getSelectedRow() == -1) {
                    return;
                }
                txtPeymentId.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 0).toString());
                txtRegistratiaID.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 1).toString());
                txtCourseFee.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 3).toString());
                txtDiscount.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 4).toString());
                txtAmount.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 5).toString());
                txtGovRate.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 6).toString());
                txtTax.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 7).toString());
                txtdelayIntrst.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 8).toString());
                //  pdate(),(peymentTable.getValueAt(peymentTable.getSelectedRow(), 9).toString());
                txtSecondAmount.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 9).toString());
                txtblase.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 10).toString());
                //txtpay.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 11).toString());
//                txtDupaymentDate.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 12).toString());
                // txtdelayIntrst .setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 14).toString());
                txtsrach.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 15).toString());
                txtTotalAmount.setText(peymentTable.getValueAt(peymentTable.getSelectedRow(), 11).toString());
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
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jXMultiSplitPane1 = new org.jdesktop.swingx.JXMultiSplitPane();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        txtsrach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        txtPeymentId = new javax.swing.JTextField();
        txtRegistratiaID = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtCourseFee = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        Half = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        txtGovRate = new javax.swing.JTextField();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtTax = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtdelayIntrst = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtSecondAmount = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPDate = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDuPaymentDate = new com.toedter.calendar.JDateChooser();
        txtTotalAmount = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        txtblase = new javax.swing.JTextField();
        jSeparator29 = new javax.swing.JSeparator();
        cmbPaymentStatus = new javax.swing.JComboBox<>();
        jSeparator41 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        peymentTable = new org.jdesktop.swingx.JXTable();
        jSeparator38 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        txtCoursename = new javax.swing.JTextField();
        StudentName134 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator35 = new javax.swing.JSeparator();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator37 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        secondAmount = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        Amount = new javax.swing.JTextField();
        btAddStudent = new javax.swing.JLabel();
        btUpdateStudent = new javax.swing.JLabel();
        typecombo = new javax.swing.JComboBox();
        txtwrite = new javax.swing.JTextField();
        btn_refresh = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        email3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtAmount1 = new javax.swing.JTextField();
        txtblase1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDate2 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        txtPaymentDate1 = new com.toedter.calendar.JDateChooser();
        txtPaymentDate2 = new com.toedter.calendar.JDateChooser();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 362, 230, 0));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 242, 230, 0));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 152, 230, 0));
        getContentPane().add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 84, 230, -1));
        getContentPane().add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 332, 230, 0));
        getContentPane().add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));
        getContentPane().add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 332, 230, 0));
        getContentPane().add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 230, 0));
        getContentPane().add(jXMultiSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));
        getContentPane().add(jXCollapsiblePane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("payment ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 110, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Registration ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Course  fee");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("GoVRate");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 80, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 316, 230, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("back");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 14, 70, 30));

        txtsrach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsrachActionPerformed(evt);
            }
        });
        txtsrach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsrachKeyReleased(evt);
            }
        });
        jPanel1.add(txtsrach, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 50, 220, 20));

        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("back");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 70, 20));
        jPanel1.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 366, 230, -1));

        txtPeymentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeymentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtPeymentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 230, -1));
        jPanel1.add(txtRegistratiaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 230, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 230, -1));

        txtCourseFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseFeeActionPerformed(evt);
            }
        });
        jPanel1.add(txtCourseFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("paymenttype");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 130, 20));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Full");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 80, -1));

        buttonGroup1.add(Half);
        Half.setText("half");
        Half.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HalfActionPerformed(evt);
            }
        });
        jPanel1.add(Half, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Discount");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 140, -1));

        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        jPanel1.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 230, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("First Amount ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 140, 20));
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 230, -1));

        txtGovRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGovRateActionPerformed(evt);
            }
        });
        jPanel1.add(txtGovRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 230, -1));
        jPanel1.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 172, 230, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Total Amount ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 140, 20));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 272, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("GovTax");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 70, -1));

        txtTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxActionPerformed(evt);
            }
        });
        jPanel1.add(txtTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 230, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DelayIntrst");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 100, -1));

        txtdelayIntrst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdelayIntrstActionPerformed(evt);
            }
        });
        jPanel1.add(txtdelayIntrst, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 230, 20));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 230, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("second amaunt");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 107, 130, 20));

        txtSecondAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondAmountActionPerformed(evt);
            }
        });
        jPanel1.add(txtSecondAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 230, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("pdate");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 140, 20));

        txtPDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPDateActionPerformed(evt);
            }
        });
        jPanel1.add(txtPDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 230, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 130, 0));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 268, 230, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Balance");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 140, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("PaymentStatas");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 140, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Duepaymentdate");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 140, 20));
        jPanel1.add(txtDuPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 230, -1));
        jPanel1.add(txtTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 230, -1));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 212, 230, 10));
        jPanel1.add(txtblase, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 230, 20));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 134, 240, -1));

        cmbPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Settled", "Pending" }));
        cmbPaymentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentStatusActionPerformed(evt);
            }
        });
        jPanel1.add(cmbPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 230, -1));
        jPanel1.add(jSeparator41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 240, 220, -1));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 222, 230, -1));
        jPanel1.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 230, -1));

        peymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                " PID", "RID", "paymenttype", "fee", "Discount", "FirstAmount", "SecondAmount", "Tax_Rate", "tax", "blace", "dalay", "Totalamount", "date", "PaymentStatas", "dupepaymentdate", "SID"
            }
        ));
        jScrollPane3.setViewportView(peymentTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1360, 240));
        jPanel1.add(jSeparator38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 70, 220, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Course");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 30));
        jPanel1.add(txtCoursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 230, 20));

        StudentName134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentName134ActionPerformed(evt);
            }
        });
        jPanel1.add(StudentName134, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 100, 210, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("second amount");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 210, 130, 30));
        jPanel1.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 132, 140, 0));
        jPanel1.add(jSeparator36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 122, 200, 0));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("StudentName");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 100, 30));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 230, 0));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 180, 220, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("StudentNIce");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 100, 30));
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 122, 210, -1));
        jPanel1.add(jSeparator37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 238, 220, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 230, 10));
        jPanel1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 244, 220, 0));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 230, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 14, -1, -1));

        secondAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondAmountActionPerformed(evt);
            }
        });
        jPanel3.add(secondAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 160, 220, -1));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 164, 230, 30));
        jPanel3.add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 220, -1));

        btAddStudent.setBackground(new java.awt.Color(51, 204, 255));
        btAddStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btAddStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btAddStudent.setText("Add payment");
        btAddStudent.setOpaque(true);
        btAddStudent.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btAddStudentAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddStudentMouseClicked(evt);
            }
        });
        jPanel3.add(btAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 160, 30));

        btUpdateStudent.setBackground(new java.awt.Color(0, 204, 102));
        btUpdateStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btUpdateStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btUpdateStudent.setText("Update payment");
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
        jPanel3.add(btUpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 160, 30));

        typecombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        typecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SID", "RID", "Status", "fee", "paymenttype", "Amount", "Blasce", "paymentstatas", "DuepaymentDate", " ", " " }));
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
        jPanel3.add(typecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 170, 31));

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
        jPanel3.add(txtwrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 190, 30));

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel3.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 140, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("1payment");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 400, 130, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 110, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("2ndPaymet");
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 400, 150, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 750));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 740));

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, -1, -1));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 50, 70, -1));
        getContentPane().add(email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 230, -1));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 20));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, -1, -1));
        getContentPane().add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 272, 230, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 52, 230, 10));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 1460, 700));
        getContentPane().add(txtAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 230, -1));
        getContentPane().add(txtblase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 230, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("PeymentDatedrop ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 217, 120, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Total Amount ");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 140, 20));
        getContentPane().add(txtDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 230, -1));

        jInternalFrame1.setVisible(true);
        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));
        getContentPane().add(txtPaymentDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 230, -1));
        getContentPane().add(txtPaymentDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddStudentMouseClicked

        try {

            paymentDTO payment = new paymentDTO();
            payment.setPid(txtPeymentId.getText());
            //type
            payment.setRid(txtRegistratiaID.getText());
            payment.setFee(new BigDecimal(txtCourseFee.getText()));
            payment.setDiscount(Integer.parseInt(txtDiscount.getText()));
            payment.setFirstAmount(new BigDecimal(txtAmount.getText()));
            payment.setSecondAmount(new BigDecimal(txtSecondAmount.getText()));
            payment.setTax_rate(Integer.parseInt(txtGovRate.getText()));
            payment.setTax(new BigDecimal(txtTax.getText()));
            payment.setDelay(0);
            payment.setTotalAmount(new BigDecimal(txtTotalAmount.getText()));
            payment.setBalance(new BigDecimal(txtblase.getText()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtPDate.getText());
            payment.setpDate(date);
            payment.setpStatus(cmbPaymentStatus.getSelectedItem().toString());
            payment.setDuePaymentDate(txtDuPaymentDate.getDate());
            payment.setPtype(paymentType);

            Boolean Add = peymentcotroller.add(payment);
            System.out.println("UI" + payment);
            System.out.println("Type" + paymentType);
            if (Add) {
                 getAllPeymentDetails();
             /*   System.out.println("paymentdate is" + txtDuPaymentDate.getDateFormatString());
                System.out.println("tax is" + txtTax.getText());
                System.out.println("blase is" + txtblase.getText());
                // System.out.println("discount is" + txtFullAmount.getText());
                //System.out.println("discount is" + txtFullAmount.getText());
                //System.out.println("discount is" + txtFullAmount.getText());
                System.out.println("com is" + cmbPaymentStatus.getSelectedItem());
                System.out.println("txtb is" + txtTotalAmount.getText());
                System.out.println("discount is" + txtDuPaymentDate.getDateFormatString());

                System.out.println("discount is" + txtAmount.getText());*/
                JOptionPane.showMessageDialog(this, "Made the Payment ", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
               // getAllPeymentDetails();
                JOptionPane.showMessageDialog(this, "Operation Failed", "Eror", JOptionPane.ERROR_MESSAGE);
            }

//        try {
//            paymentDTO peyment = new paymentDTO(
//                    txtPeymentId.getText(),
//                    txtRegistratiaID.getText(),
//                    txtpaid.getText(),
//                    txtCourseFee.getText(),
//                    PeymentCombo.getSelectedItem().toString(),
//                    txtDiscount.getText(),
//                    jTextGonrate.getText(),
//                    txtGonTAx.getText(),
//                    txtdelayIntrst.getText(),
//                    date.getDate().toString(),
//                    txtPaymentDate.getDate().toString(),
//                    txtAmount.getText(),
//                    txtblase.getText(),
//                    txtpaymentstatas.getText(),
//                    txtDupaymentDate.getText());
//
//            System.out.println("j");
//            //txtdelayIntrst.getText());
//            boolean result = peymentcotroller.add(peyment);
//            System.out.println("result view " + result);
//            if (result) {
//                JOptionPane.showMessageDialog(this, "peyment has been successfully added...!");
//            } else {
//                JOptionPane.showMessageDialog(this, "peyment has not been added...!");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        } catch (Exception ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btAddStudentMouseClicked

    private void btUpdateStudentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btUpdateStudentAncestorAdded

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {


    }//GEN-LAST:event_btUpdateStudentAncestorAdded

    private void btUpdateStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateStudentMouseClicked

        try {

            paymentDTO payment = new paymentDTO();
            payment.setPid(txtPeymentId.getText());
            payment.setRid(txtRegistratiaID.getText());
            System.out.println("paymentdate is" + payment.getRid());
            payment.setFee(new BigDecimal(txtCourseFee.getText()));
            payment.setDiscount(Integer.parseInt(txtDiscount.getText()));
            payment.setFirstAmount(new BigDecimal(txtAmount.getText()));
            payment.setSecondAmount(new BigDecimal(txtSecondAmount.getText()));
            //   payment.setTax_rate(Integer.parseInt(txtGovRate.getText()));
            payment.setTax(new BigDecimal(txtGovRate.getText()));
            payment.setDelay(0);
            payment.setTotalAmount(new BigDecimal(txtTotalAmount.getText()));
            payment.setBalance(new BigDecimal(txtblase.getText()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtPDate.getText());
            payment.setpDate(date);
            payment.setpStatus(cmbPaymentStatus.getSelectedItem().toString());
            payment.setDuePaymentDate(txtDuPaymentDate.getDate());
            payment.setPtype(paymentType);

            Boolean update = peymentcotroller.update(payment);
            System.out.println("UI" + payment);
            System.out.println("Type" + paymentType);
            if (update) {
                getAllPeymentDetails();
                /* System.out.println("paymentdate is" + payment.getRid());
                System.out.println("tax is" + payment.getFee());
                System.out.println("blase is" + payment.getDiscount());
                 System.out.println("discount is" +  payment.getFirstAmount());
                System.out.println("discount is" +  payment.getSecondAmount());
               System.out.println("discount is" +  payment.getTax_rate());
                System.out.println("com is" +  payment.getTax());
                System.out.println("txtb is" +  payment.getDelay());
                System.out.println("discount is" +  payment.getBalance());
                    System.out.println("com is" +  payment.getpDate());
                System.out.println("txtb is" +  payment.getpStatus());
                System.out.println("discount is" +  payment.getDuePaymentDate());   
                 */

                System.out.println("discount is" + payment.getPtype());
                JOptionPane.showMessageDialog(this, "Made the Payment ", "update", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Operation Failed", "Eror", JOptionPane.ERROR_MESSAGE);
            }

//        try {
//            paymentDTO peyment = new paymentDTO(
//                    txtPeymentId.getText(),
//                    txtRegistratiaID.getText(),
//                    txtpaid.getText(),
//                    txtCourseFee.getText(),
//                    PeymentCombo.getSelectedItem().toString(),
//                    txtDiscount.getText(),
//                    jTextGonrate.getText(),
//                    txtGonTAx.getText(),
//                    txtdelayIntrst.getText(),
//                    date.getDate().toString(),
//                    txtPaymentDate.getDate().toString(),
//                    txtAmount.getText(),
//                    txtblase.getText(),
//                    txtpaymentstatas.getText(),
//                    txtDupaymentDate.getText());
//
//            System.out.println("j");
//            //txtdelayIntrst.getText());
//            boolean result = peymentcotroller.add(peyment);
//            System.out.println("result view " + result);
//            if (result) {
//                JOptionPane.showMessageDialog(this, "peyment has been successfully added...!");
//            } else {
//                JOptionPane.showMessageDialog(this, "peyment has not been added...!");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        } catch (Exception ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_btUpdateStudentMouseClicked

    private void txtPeymentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeymentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeymentIdActionPerformed

    private void txtTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxActionPerformed

    private void typecomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typecomboItemStateChanged
        txtwrite.setText("");
        this.searchType = (String) typecombo.getSelectedItem();
    }//GEN-LAST:event_typecomboItemStateChanged

    private void typecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typecomboActionPerformed

    private void txtwriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtwriteActionPerformed
        //  addTableDetails();
    }//GEN-LAST:event_txtwriteActionPerformed

    private void txtwriteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwriteKeyPressed

    }//GEN-LAST:event_txtwriteKeyPressed

    private void txtwriteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwriteKeyReleased
        this.searchType = (String) typecombo.getSelectedItem();
        searchpaymentDetails1(searchType, txtwrite.getText());
    }//GEN-LAST:event_txtwriteKeyReleased

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed

    }//GEN-LAST:event_btn_refreshActionPerformed

    private void txtdelayIntrstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdelayIntrstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdelayIntrstActionPerformed

    private void txtCourseFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseFeeActionPerformed

    private void txtGovRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGovRateActionPerformed


    }//GEN-LAST:event_txtGovRateActionPerformed

    private void txtsrachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsrachActionPerformed
        //  Studentserach ();
    }//GEN-LAST:event_txtsrachActionPerformed

    private void txtsrachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsrachKeyReleased
        // Str
    }//GEN-LAST:event_txtsrachKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String sid = txtsrach.getText();
            //  String rid = txtsrach.getText();
            RegistrationDTO register = registrationController.search(sid);
            // ArrayList<QueryDTO> query = queryController.getCourseName(rid);

            if (register != null) {

                txtRegistratiaID.setText(register.getRID());

                txtCourseFee.setText(register.getCourse_fee().toString());

                //     txtCoursename.setText(query.toString());
                CoureDTO search = coursecotroller.search(register.getCID());
                if (null != search) {
                    txtDiscount.setText(search.getDiscount().toString());

                }
                ArrayList<QueryDTO> list = queryController.getCourseName(sid);
                for (QueryDTO queryDTO : list) {
                    StudentName134.setText(queryDTO.getStudentname());
                    txtCoursename.setText(queryDTO.getCoursename());
                    System.out.println("Qcoursname" + queryDTO.getCoursename());
                    secondAmount.setText(queryDTO.getNIC());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Student not Registerd Before...");
            }
        } catch (Exception ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        /*    txtPaymentDate.setEnabled(false);
        
        String pType = "Full";
        int CFee = Integer.parseInt(txtCourseFee.getText());
        System.out.println("" + CFee);
        int x = Integer.parseInt(txtDiscount.getText());
        int Dis = 100 - x;
        int y = CFee * Dis;
        int z = y / 100;
        txtAmount.setText(String.valueOf(z));
       System.out.println(txtAmount.getText());
         */
        ///////////////////////////////////////////////////////////
        BigDecimal courseFee = new BigDecimal(txtCourseFee.getText());
        BigDecimal discount = new BigDecimal(txtDiscount.getText());
        BigDecimal discountForCourseFee = courseFee.multiply(discount).divide(new BigDecimal(100));
        BigDecimal ammountWithoutTax = courseFee.subtract(discountForCourseFee);
        BigDecimal taxForAmmount = ammountWithoutTax.multiply(new BigDecimal(govTax)).divide(new BigDecimal(100));
        BigDecimal ammountWithTax = ammountWithoutTax.add(taxForAmmount);

        txtAmount.setText(String.valueOf(ammountWithTax));
        txtTax.setText(String.valueOf(taxForAmmount));
        paymentType = "Full";
        ////////////////////////////////////////////////

        //int dis = 100 - Integer.parseInt(txtDiscount.getText());
        //System.out.println("discount is" + dis);
        //BigDecimal dividebyHundred = courseFee.divide(BigDecimal.valueOf(100));
        //System.out.println("divide by 100" + dividebyHundred);
        //System.out.println(dividebyHundred);
        //BigDecimal d = dividebyHundred.multiply(BigDecimal.valueOf(dis));
        //System.out.println("d" + d);
        // BigDecimal amount = dividebyHundred.multiply(courseFee.subtract(d));//discount
        //System.out.println("amount" + amount);
        //Tax
        //BigDecimal tax = new BigDecimal(txtGovRate.getText());
        //         int tax=Integer.parseInt(txtGovRate.getText());
        // BigDecimal amountDividedByHundred = amount.divide(BigDecimal.valueOf(100));
        // BigDecimal taxAmount = amountDividedByHundred.multiply(tax);
        //BigDecimal totalAmount = amount.add(taxAmount);
        //txtAmount.setText(String.valueOf(totalAmount));
        txtblase.setText("0");
        cmbPaymentStatus.setSelectedIndex(0);
////                //discount

//                

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void HalfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HalfActionPerformed

        txtDuPaymentDate.setEnabled(true);
//        txtTaxAmount.setText("");
//        txtTotalAmount.setText("");
//        txtBalance.setText("");
        paymentType = "Half";
//            paymentDTO search = peymentcotroller.search(pType);
//            if (null != search) {
        cmbPaymentStatus.setSelectedIndex(1);
        int discount = 0;
        txtDiscount.setText(String.valueOf(discount));
        BigDecimal amount = new BigDecimal(txtCourseFee.getText());
        BigDecimal dividedAmount = amount.divide(BigDecimal.valueOf(2));
        txtAmount.setText(String.valueOf(dividedAmount));
        //Amount

        BigDecimal taxRate = new BigDecimal(txtGovRate.getText());
        BigDecimal totAmount = new BigDecimal(txtAmount.getText());

        BigDecimal dividedTotAmountByHundred = totAmount.divide(BigDecimal.valueOf(100));
        BigDecimal taxAmount = dividedTotAmountByHundred.multiply(taxRate);
        txtTax.setText(String.valueOf(taxAmount));
        BigDecimal totalAmountWithTax = totAmount.add(taxAmount);
        txtTotalAmount.setText(totalAmountWithTax.toString());
        txtdelayIntrst.setText(String.valueOf(lateFeeRate));
        BigDecimal balance = amount.subtract(totAmount);
        txtblase.setText(balance.toString());
        //////////////////////////////////////////


    }//GEN-LAST:event_HalfActionPerformed

    private void btAddStudentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btAddStudentAncestorAdded

        try {

            boolean selected = jRadioButton1.isSelected();
            if (selected) {
                paymentType = "Full";
            } else {
                paymentType = "Half";
                try {

                    paymentDTO payment = new paymentDTO();
                    payment.setPid(txtPeymentId.getText());

                    payment.setPtype(txtRegistratiaID.getText());
                    payment.setRid(txtRegistratiaID.getText());

                    payment.setFee(new BigDecimal(txtCourseFee.getText()));

                    payment.setDiscount(Integer.parseInt(txtDiscount.getText()));
                    payment.setFirstAmount(new BigDecimal(txtAmount.getText()));
                    payment.setSecondAmount(new BigDecimal(0));
                    payment.setTax_rate(Integer.parseInt(txtTax.getText()));
                    payment.setTax(new BigDecimal(txtTax.getText()));
                    //LateFeeDTO search = lateFeeController.search("LA001");
                    //if (null != search) {
                    //  payment.setDelay(search.getLateInterest());
                    // }
                    payment.setTotalAmount(new BigDecimal(txtTotalAmount.getText()));
                    payment.setSecondAmount(new BigDecimal(txtSecondAmount.getText()));
                    payment.setBalance(new BigDecimal(txtblase.getText()));
                    payment.setpDate(parseDate(txtDuPaymentDate.getDateFormatString()));
                    payment.setpStatus(cmbPaymentStatus.getSelectedItem().toString());
                    payment.setDuePaymentDate(txtDuPaymentDate.getDate());
                    boolean add = peymentcotroller.add(payment);

                    if (add) {
                        JOptionPane.showMessageDialog(this, "Made the Payment ", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("discount is" + txtAmount);
                    } else {
                        JOptionPane.showMessageDialog(this, "Operation Failed", "Eror", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException exception) {

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btAddStudentAncestorAdded

    private void txtPDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPDateActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked


    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        // private void jasperReport() {
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(Startjasper.class.getResourceAsStream("/lk/ijse/studentpayment/view/NewPayment_1_1.jasper"));
            
            HashMap<String, Object> parHashMap = new HashMap<>();
            parHashMap.put("pDate", txtPDate.getText());
            parHashMap.put("Course", jRadioButton1.getText());
            parHashMap.put("CourseName", txtCoursename.getText());
            parHashMap.put("nic", secondAmount.getText());
            parHashMap.put("StudentName", StudentName134.getText());
            parHashMap.put("CourseFee", txtCourseFee.getText());

            parHashMap.put("discount", txtDiscount.getText());
            parHashMap.put("TotalAmount", txtAmount.getText());

            parHashMap.put("taxRate",txtTax.getText());
             parHashMap.put("taxAmount", txtTotalAmount.getText());
            parHashMap.put("taxAmount                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ", txtblase.getText());
            // parHashMap.put("Date", txtDate.getText());
           parHashMap.put("payment_statas", cmbPaymentStatus.getSelectedItem());
            parHashMap.put("DueDate", txtDuPaymentDate.getDate());
            System.out.println("u");
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

    private void StudentName134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentName134ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentName134ActionPerformed

    private void txtSecondAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecondAmountActionPerformed

    private void secondAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondAmountActionPerformed

    private void cmbPaymentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentStatusActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearTextFields();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(peyment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peyment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peyment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peyment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peyment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JRadioButton Half;
    private javax.swing.JTextField StudentName134;
    private javax.swing.JLabel btAddStudent;
    private javax.swing.JLabel btUpdateStudent;
    private javax.swing.JButton btn_refresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.painter.CheckerboardPainter checkerboardPainter1;
    private org.jdesktop.swingx.painter.CheckerboardPainter checkerboardPainter2;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JTextField email2;
    private javax.swing.JTextField email3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
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
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXMultiSplitPane jXMultiSplitPane1;
    private org.jdesktop.swingx.JXTable peymentTable;
    private javax.swing.JTextField secondAmount;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtAmount1;
    private javax.swing.JTextField txtCourseFee;
    private javax.swing.JTextField txtCoursename;
    private javax.swing.JTextField txtDate2;
    private javax.swing.JTextField txtDiscount;
    private com.toedter.calendar.JDateChooser txtDuPaymentDate;
    private javax.swing.JTextField txtGovRate;
    private javax.swing.JTextField txtPDate;
    private com.toedter.calendar.JDateChooser txtPaymentDate1;
    private com.toedter.calendar.JDateChooser txtPaymentDate2;
    private javax.swing.JTextField txtPeymentId;
    private javax.swing.JTextField txtRegistratiaID;
    private javax.swing.JTextField txtSecondAmount;
    private javax.swing.JTextField txtTax;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtblase;
    private javax.swing.JTextField txtblase1;
    private javax.swing.JTextField txtdelayIntrst;
    private javax.swing.JTextField txtsrach;
    private javax.swing.JTextField txtwrite;
    private javax.swing.JComboBox typecombo;
    // End of variables declaration//GEN-END:variables
// public void setDate() {
//        Date currentDate = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(currentDate);
//        txtPaymentDate.setDate(parseDate(date));
//    }
    public void setCurrentDate() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(currentDate);
        txtPDate.setText(date);
    }

    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fmtDate = sdf.parse(date);
            return fmtDate;

        } catch (ParseException ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void getStudentDetails(StudentDTO studentDTO) {
        if (null != studentDTO) {
            studentDTO1 = studentDTO;

        }

    }

    private void getAllPeymentDetails() {
        try {
            /* this.peymenttList = (ArrayList<paymentDTO>) peymentcotroller.getAll();

            DefaultTableModel dtm = (DefaultTableModel) peymentTable.getModel();

            dtm.setRowCount(0);

            for (paymentDTO peyment : peymenttList) {*/

            this.peymentQueryList = (ArrayList<QueryDTO>) queryController.getALlpayment();
            DefaultTableModel dtm = (DefaultTableModel) peymentTable.getModel();

            dtm.setRowCount(0);

            for (QueryDTO peyment : peymentQueryList) {

                Object[] rowData = {peyment.getPid(),
                    //  peyment.getSID(),
                    peyment.getRid(),
                    peyment.getPtype(),
                    peyment.getFee(),
                    peyment.getDiscount(),
                    peyment.getFirstAmount(),
                    peyment.getSecondAmount(),
                    peyment.getTax_rate(),
                    peyment.getTax(),
                    peyment.getTotalAmount(),
                    peyment.getDelay(),
                    peyment.getBalance(),
                    // peyment.getTotalAmount(),
                    peyment.getpDate(),
                    peyment.getpStatus(),
                    peyment.getDuePaymentDate(),
                    peyment.getSID(),};
                // peyment.getBalance(),
                // peyment.getDuePaymentDate(),
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void IDGenarator() {

        try {
            txtPeymentId.setText(IDGenarator.getNewID("payment", " PID", "P"));
        } catch (SQLException ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchpaymentDetails1(String type, String searchText) {

        System.out.println("T" + searchType);
        System.out.println("st" + searchText);
        System.out.println("sL" + peymenttList);
        System.out.println("Result  " + type.equals("SID"));
        if (type.equals("SID")) {

            searchpeymentQueryList = new ArrayList<>();
            for (QueryDTO queryDTO : peymentQueryList) {
                System.out.println(queryDTO.getSID());
                if (queryDTO.getSID().toLowerCase().contains(searchText.toLowerCase())) {
                    searchpeymentQueryList.add(queryDTO);

                }
            }
        } else if (type.equals("RID")) {
            searchpeymentQueryList = new ArrayList<>();
            for (QueryDTO queryDTO : peymentQueryList) {
                if (queryDTO.getRid().toLowerCase().contains(searchText.toLowerCase())) {
                    searchpeymentQueryList.add(queryDTO);
                }
            }
        } else if (type.equals("Status")) {
            searchpeymentQueryList = new ArrayList<>();
            for (QueryDTO queryDTO : peymentQueryList) {
                if (queryDTO.getpStatus().toLowerCase().contains(searchText.toLowerCase())) {
                    searchpeymentQueryList.add(queryDTO);
                }
            }
        }
//            }
//        } else if (type.equals("Blasce")) {
//            searchpeymentList = new ArrayList<>();
//            for (paymentDTO paymentDTO : peymenttList) {
//                if (paymentDTO.getDuePaymentDate().toLowerCase().contains(searchText.toLowerCase())) {
//                    searchpeymentList.add(paymentDTO);
//                }
//            }
//
//        } else if (type.equals("Discount")) {
//            searchpeymentList = new ArrayList<>();
//            for (paymentDTO paymentDTO : peymenttList) {
//                if (paymentDTO.getDiscount().toLowerCase().contains(searchText.toLowerCase())) {
//                    searchpeymentList.add(paymentDTO);
//                }
//
//            }
//        } else if (type.equals("paymentstatas")) {
//            searchpeymentList = new ArrayList<>();
//            for (paymentDTO paymentDTO : peymenttList) {
//                if (paymentDTO.getPaymentstatas().toLowerCase().contains(searchText.toLowerCase())) {
//                    searchpeymentList.add(paymentDTO);
//
//                }
//            }
//        } else if (type.equals("DuepaymentDate")) {
//            searchpeymentList = new ArrayList<>();
//            for (paymentDTO paymentDTO : peymenttList) {
//                if (paymentDTO.getDuepaymentDate().toLowerCase().contains(searchText.toLowerCase())) {
//                    searchpeymentList.add(paymentDTO);
//                }
//            }
//            // } else if (type.equals("DuepaymentDate")) {
//            //searchpeymentList = new ArrayList<>();
//            //for (paymentDTO paymentDTO : peymenttList) {
//            //  if (paymentDTO.getDiscount().toLowerCase().contains(searchText.toLowerCase())) {
//            //   searchpeymentList.add(paymentDTO);
//
//        }
        try {

            DefaultTableModel dtm = (DefaultTableModel) peymentTable.getModel();

            dtm.setRowCount(0);

            for (QueryDTO peyment : searchpeymentQueryList) {
                
                 Object[] rowData = {peyment.getPid(),
                    //  peyment.getSID(),
                    peyment.getRid(),
                    peyment.getPtype(),
                    peyment.getFee(),
                    peyment.getDiscount(),
                    peyment.getFirstAmount(),
                    peyment.getSecondAmount(),
                    peyment.getTax_rate(),
                    peyment.getTax(),
                    peyment.getTotalAmount(),
                    peyment.getDelay(),
                    peyment.getBalance(),
                    // peyment.getTotalAmount(),
                    peyment.getpDate(),
                    peyment.getpStatus(),
                    peyment.getDuePaymentDate(),
                    peyment.getSID(),};

               /* Object[] rowData = {peyment.getBalance(),
                    //   peyment.getSID(),
                    peyment.getDelay(),
                    peyment.getDelay(),
                    peyment.getFee(),
                    peyment.getPtype(),
                    peyment.getDiscount(),
                    peyment.getSecondAmount(),
                    peyment.getTax_rate(),
                    peyment.getTotalAmount(),
                    peyment.getSecondAmount(),
                    peyment.getDiscount(),
                    peyment.getTax_rate(),
                    peyment.getTax(),
                    peyment.getTax_rate(),
                    peyment.getpStatus(),
                    peyment.getSID(),};*/
                System.out.println("sL" + rowData);
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}

//    private void IDGenarator1() {
//
//        try {
//            txtpaid.setText(IDGenarator.getNewID("payment", " PaID", "P"));
//        } catch (SQLException ex) {
//            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//  private void addTableDetails() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
/*  private void searchStudentDetails1() {
     String id=(String) jComboBox1.getSelectedItem();
        try {
            re
            txtsrach.setText(speciality.getNic());
        } catch (Exception ex) {
            Logger.getLogger(peyment.class.getName()).log(Level.SEVERE, null, ex);
      
    
}*/
//private void searchStudentDetails1() {
//   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
// }

