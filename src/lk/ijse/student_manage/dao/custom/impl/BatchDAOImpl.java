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
import lk.ijse.student_manage.dao.custom.BatchDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
    
        
public class BatchDAOImpl implements BatchDAO{
  private Connection connection;

    public BatchDAOImpl() {
            connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(BatchDTO batch) throws Exception {
         String SQL = "INSERT INTO batch VALUES (?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, batch.getBID());
        stm.setObject(2, batch.getBatchname());
       int res = stm.executeUpdate();
        return (res > 0);
    }

    @Override
    public boolean update(BatchDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws Exception {
        String sql = "Select * from batch";
        Statement  preparedStatemen = connection.createStatement();
        ResultSet resultSet =  preparedStatemen.executeQuery(sql);
        ArrayList<BatchDTO> albatch = null;

        while (resultSet.next()) {

            if (albatch == null) {
                albatch = new ArrayList<>();
            }
            BatchDTO batch = new BatchDTO(resultSet.getString(1),
                    resultSet.getString(2));
        
            albatch.add(batch);
    }
        return albatch;
}}
 
    
    
    
   
    
