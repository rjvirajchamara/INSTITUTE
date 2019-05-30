/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.batchdetailsDAO;
import lk.ijse.student_manage.dto.batchdetailsDTO;
import lk.ijse.student_manage.service.custom.batchdetailsService;

/**
 *
 * @author  chamara 
 */
public class batchdetailsServiceImpl implements batchdetailsService {
      private batchdetailsDAO batchdetDAO;

    public batchdetailsServiceImpl() {
        batchdetDAO = (batchdetailsDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.batchdetails);
    }
      

    @Override
    public boolean add(batchdetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
