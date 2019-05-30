/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.LoginDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.LoginDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */

public class LoginDAOImpl implements LoginDAO{
 private  Connection connection;

    public LoginDAOImpl() {
         connection = ConnectionFactory.getInstance().getConnection();
    }
     
   
    
    @Override
    public boolean add(LoginDTO dto) throws Exception {
         String query = "INSERT INTO User VALUES(?, password(?))";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1, dto.getUserName());
        stm.setObject(2, dto.getPassword());
        int res=stm.executeUpdate();
        return(res>0);
    }

    @Override
    public boolean update(LoginDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(LoginDTO dto) throws Exception {
    /*  String query = "SELECT * FROM user WHERE username = ? AND password = password(?)";
       PreparedStatement stm = connection.prepareStatement(query);
        // PreparedStatement stm = conn.prepareStatement(query);
        stm.setObject(1, dto.getUserName());
        stm.setObject(2, dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getPassword());
        ResultSet rst = stm.executeQuery();
        return rst.next();*/
    
     String query = "SELECT * FROM Login WHERE  userName = ? AND Password = ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1, dto.getUserName());
        stm.setObject(2, dto.getPassword());
        ResultSet rst = stm.executeQuery();
        System.out.println( dto.getUserName());
        System.out.println(dto.getPassword());
        //System.out.println(rst.next());
        return rst.next();
      //  System.out.println("namr"+dto.getUserName());
      //  System.out.println("pas");
    }

   
}
