/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.BatchController;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.BatchDAO;
import lk.ijse.student_manage.dao.custom.LoginDAO;
import lk.ijse.student_manage.dao.custom.batchdetailsDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.SuperDTO;
import lk.ijse.student_manage.dto.batchdetailsDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.BatchService;
import lk.ijse.student_manage.service.custom.batchdetailsService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BatchControllerImpl implements BatchController{
    
  private BatchService batchService;
   private batchdetailsService batchdetailsService1;

    public BatchControllerImpl() {
        
        batchService = (BatchService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.Batch);
//         batchdetailsService1 = (batchdetailsService)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.batchdetails);
        
    }
    
    

    @Override
    public boolean add(BatchDTO dto) throws Exception {
        return batchService.add(dto);
    }

    @Override
    public boolean update(BatchDTO dto) throws Exception {
        return  batchService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
       return batchService.delete(id);
    }

    @Override
    public BatchDTO search(String id) throws Exception {
        return  batchService.get(id);
    }

    @Override
    public ArrayList<BatchDTO> getAll() throws Exception {
        return  batchService.getAll();
    }

    @Override
    public boolean adWithTrance(BatchDTO b, batchdetailsDTO a) throws Exception {
        return batchService.adWithTrance(b, a);
    }

    }

