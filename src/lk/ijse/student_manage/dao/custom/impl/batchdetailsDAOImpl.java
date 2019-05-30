/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.batchdetailsDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.batchdetailsDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class batchdetailsDAOImpl implements batchdetailsDAO{
    
    private Connection connection;

    public batchdetailsDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(batchdetailsDTO batchdetails ) throws Exception {
        System.out.println(batchdetails);
        String SQL = "INSERT INTO batchdetails VALUES (?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, batchdetails.getBAID());
        stm.setObject(2, batchdetails.getBID());
         stm.setObject(3, batchdetails.getCID());
        stm.setObject(4, batchdetails.getStartdate());
         stm.setObject(5, batchdetails.getBstatas());
        //stm.setObject(6, batchdetails.getBID());
       int res = stm.executeUpdate();
        return (res > 0);
    }

    @Override
    public boolean update(batchdetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public batchdetailsDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<batchdetailsDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
