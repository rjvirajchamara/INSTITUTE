/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.BatchTransferDAO;
import lk.ijse.student_manage.dto.BatchTranferDTO;
import lk.ijse.student_manage.service.custom.BatchTransferService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BatchTransferServiceImpl implements BatchTransferService{
    
    private  BatchTransferDAO batchTranferDAO;

    public BatchTransferServiceImpl() {
        
        batchTranferDAO= (BatchTransferDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BatchTransfer);
    }
    
    

    @Override
    public boolean add(BatchTranferDTO dto) throws Exception {
        return batchTranferDAO.add(dto);
      
    }

    @Override
    public boolean update(BatchTranferDTO dto) throws Exception {
      return batchTranferDAO.update(dto);
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
       return batchTranferDAO.getAll();
    }

}
