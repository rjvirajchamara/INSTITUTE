/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.BatchTranferController;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dto.BatchTranferDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.BatchTransferService;
import lk.ijse.student_manage.service.custom.batchdetailsService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BatchTransferControllerImpl implements BatchTranferController{

   private BatchTransferService batchTransferService;
    //private batchdetailsService batchdetailsService1;
    public BatchTransferControllerImpl() {
        batchTransferService = (BatchTransferService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.BatchTransfer);
    }
   
   
    
    @Override
    public boolean add(BatchTranferDTO dto) throws Exception {
       return batchTransferService.add(dto);
    }

    @Override
    public boolean update(BatchTranferDTO dto) throws Exception {
        return  batchTransferService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchTranferDTO search(String id) throws Exception {
       return  batchTransferService.get(id);
    }

    @Override
    public ArrayList<BatchTranferDTO> getAll() throws Exception {
        return  batchTransferService.getAll();
    }

}
