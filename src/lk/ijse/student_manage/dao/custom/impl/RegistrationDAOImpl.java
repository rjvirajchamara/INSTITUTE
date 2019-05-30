/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.RegistrationDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.RegistrationDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class RegistrationDAOImpl implements RegistrationDAO{
    
    private Connection connection;

    public RegistrationDAOImpl() {
        connection =ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public boolean add(RegistrationDTO  Registration ) throws Exception {
      String SQL = "INSERT INTO registration VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, Registration.getRID());
        stm.setObject(2, Registration.getSID());
        stm.setObject(3, Registration.getBID());
        stm.setObject(4, Registration.getCID());
        stm.setObject(5, Registration.getRegDate());
        stm.setObject(6, Registration.getCourse_fee());
        stm.setObject(7, Registration.getRegfeestatar());
        stm.setObject(8, Registration.getStatus());
        int res = stm.executeUpdate();
        return (res > 0);
    }
    

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrationDTO get(String Dto) throws Exception {
    RegistrationDTO register=null;
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(" select * from registration where sid='"+Dto+"'");
        while(rst.next()){
            register= new RegistrationDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getBigDecimal(6),rst.getString(7),rst.getString(8));
            
        }
        return register;
    }

    
    
       
            
    

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
          
        String sql = "Select * from registration ";
        Statement  preparedStatemen = connection.createStatement();
        ResultSet resultSet =  preparedStatemen.executeQuery(sql);
        ArrayList<RegistrationDTO> alstudent = null;

        while (resultSet.next()) {

            if (alstudent == null) {
                alstudent = new ArrayList<>();
            }
            RegistrationDTO registration = new RegistrationDTO(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getBigDecimal(6),
                    resultSet.getString(7),
                  // resultSet.getString(8),
                    resultSet.getString(8));
        
            alstudent.add(registration);
    }
        return alstudent;
}}
 



   

