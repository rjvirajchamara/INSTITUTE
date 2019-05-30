/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.BatchTranferDTO;
import lk.ijse.student_manage.service.custom.BatchTransferService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BatchTransferDAOImpl implements BatchTransferService{

    private Connection connection;

    public BatchTransferDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public boolean add(BatchTranferDTO batchtranfer) throws Exception {
      String SQL = "INSERT INTO batchtranfer VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, batchtranfer.getTID());
        stm.setObject(2, batchtranfer.getRID());
        stm.setObject(3, batchtranfer.getSID());
        stm.setObject(4, batchtranfer.getBID_Old());
        stm.setObject(5, batchtranfer.getBID_New());
        stm.setObject(6, batchtranfer.getTransferfee());
        stm.setObject(7, batchtranfer.getTrasnferDate());
        
        int res = stm.executeUpdate();
        return (res > 0);
    
    }

    @Override
    public boolean update(BatchTranferDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchTranferDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BatchTranferDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
