/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.TaxDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.TaxDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class TaxDAOImpl implements TaxDAO{
 private Connection connection;

    public TaxDAOImpl() {
          connection = ConnectionFactory.getInstance().getConnection();
    }
 
    @Override
    public boolean add(TaxDTO tax) throws Exception {
       String SQL = "INSERT INTO STUDENT VALUES (?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, tax.getId());
        stm.setObject(2, tax.getTax());
     int res = stm.executeUpdate();
        return (res > 0);
    }

    @Override
    public boolean update(TaxDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaxDTO get(String Dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TaxDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
