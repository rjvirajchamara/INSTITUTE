/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.BatchDAO;
import lk.ijse.student_manage.dao.custom.batchdetailsDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.dto.SuperDTO;
import lk.ijse.student_manage.dto.batchdetailsDTO;
import lk.ijse.student_manage.service.custom.BatchService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BatchServiceImpl implements BatchService {

    private BatchDAO batchDAO;
     private batchdetailsDAO batchdetDAO;
    

    public BatchServiceImpl() {
        batchDAO = (BatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Batch);
          batchdetDAO = (batchdetailsDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.batchdetails);
    }
    
    
            
    @Override
    public boolean add(BatchDTO dto) throws Exception {
        return batchDAO.add(dto);
    }

    @Override
    public boolean update(BatchDTO dto) throws Exception {
        return batchDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return  batchDAO.delete(key);
    }

    @Override
    public BatchDTO get(String key) throws Exception {
        return  batchDAO.get(key);
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws Exception {
        return batchDAO.getAll();
    }

    @Override
    public boolean adWithTrance(BatchDTO b, batchdetailsDTO a) throws Exception {
         Connection con = ConnectionFactory.getInstance().getConnection();
      
        con.setAutoCommit(false);
        try {
            boolean add = batchDAO.add(b);
            System.out.println(b);
            if (add) {
                boolean add1 = batchdetDAO.add(a);
                System.out.println(a);
                if (add1) {
                    con.commit();
                    System.out.println("done");
                    return true;
                } else {
                    con.rollback();
                    return false;
                }
            } else {
                con.rollback();
                return false;
            }
        } finally {
            con.setAutoCommit(true);
        }

    }
    }
    




