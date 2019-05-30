/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.peymentDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.paymentDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class PeymentDAOImpl implements peymentDAO{
private Connection connection;

    public PeymentDAOImpl() {
        connection= ConnectionFactory.getInstance().getConnection();
    }

        
        
    
    @Override
    public boolean add(paymentDTO peyment) throws Exception {
        System.out.println(peyment);
        String SQL = "INSERT INTO  payment VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, peyment.getPid());
        stm.setObject(2, peyment.getPtype());
        stm.setObject(3, peyment.getRid());
        stm.setObject(4, peyment.getFee());
        stm.setObject(5, peyment.getDiscount());
        stm.setObject(6, peyment.getFirstAmount());
        stm.setObject(7, peyment.getSecondAmount());
        stm.setObject(8, peyment.getTax_rate());
        stm.setObject(9, peyment.getTax());
        stm.setObject(10, peyment.getDelay());
        stm.setObject(11, peyment.getTotalAmount());
        stm.setObject(12, peyment.getBalance());
        stm.setObject(13, peyment.getpDate());
        stm.setObject(14, peyment.getpStatus());
        stm.setObject(15, peyment.getDuePaymentDate());
        
        System.out.println(("tax")+peyment.getTax());
        
       // stm.setObject(6, student.getGender());
        int res = stm.executeUpdate();
        System.out.println("result "+res);
        return (res > 0);
    }

    @Override
    public boolean update(paymentDTO dto) throws Exception {
      // System.out.println(peyment);
       String SQL="UPDATE payment SET Ptype=?,RID=?,fee=?,discount=?,firstAmount=?,secondAmount=?,tax_rate=?,tax=?,delay=?,totalAmount=?,balance=?,Date=?,payment_statas=?,DuepaymentDate=? WHERE PID=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
       // stm.setObject(1, dto.getPid());
        System.out.println("rid"+dto.getRid());
        System.out.println("rid"+dto.getpStatus());
        
        stm.setObject(1, dto.getPtype());
        stm.setObject(2, dto.getRid());
        stm.setObject(3, dto.getFee());
        stm.setObject(4, dto.getDiscount());
        stm.setObject(5, dto.getFirstAmount());
        stm.setObject(6, dto.getSecondAmount());
        stm.setObject(7, dto.getTax_rate());
        stm.setObject(8, dto.getTax());
        stm.setObject(9, dto.getDelay());
        stm.setObject(10, dto.getTotalAmount());
        stm.setObject(11, dto.getBalance());
        stm.setObject(12, dto.getpDate());
        stm.setObject(13, dto.getpStatus());
        stm.setObject(14, dto.getDuePaymentDate());
         stm.setObject(15, dto.getPid());
       int res=stm.executeUpdate();
        
        return res>0;
    }

    

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public paymentDTO get(String key) throws Exception {
        String sql="Select * from  payment where PID='"+key+"'";// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Statement preparedStatement= connection.createStatement();
        ResultSet resultSet=preparedStatement.executeQuery(sql);
        if (resultSet.next()) {
            return new paymentDTO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                    new BigDecimal(resultSet.getString(4)),Integer.parseInt(resultSet.getString(5)),new BigDecimal(resultSet.getString(6)),
                    new BigDecimal(resultSet.getString(7)),Integer.parseInt(resultSet.getString(8)),new BigDecimal(resultSet.getString(9)),Integer.parseInt(resultSet.getString(10)),new BigDecimal(resultSet.getString(11)),new BigDecimal(resultSet.getString(12)),resultSet.getDate(13),resultSet.getString(14),resultSet.getDate(15));
        }
        return null;
    }

    @Override
    public ArrayList<paymentDTO> getAll() throws Exception {
        String sql = "Select * from  payment";
        Statement  preparedStatemen = connection.createStatement();
        ResultSet resultSet =  preparedStatemen.executeQuery(sql);
        ArrayList<paymentDTO> alpeyment = null;

        while (resultSet.next()) {

            if (alpeyment == null) {
                alpeyment = new ArrayList<>();
            }
            paymentDTO peyment = new paymentDTO(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getBigDecimal(4),
                    resultSet.getInt(5),
                    resultSet.getBigDecimal(6),
                    resultSet.getBigDecimal(7),
                    resultSet.getByte(8),
                    resultSet.getBigDecimal(9),
                    resultSet.getInt(10),
                    resultSet.getBigDecimal(11),
                    resultSet.getBigDecimal(12),
                    resultSet.getDate(13), 
                    resultSet.getString(14), 
                    resultSet.getDate(15));
        
            alpeyment.add(peyment);
    }
        return alpeyment;
}}

    


