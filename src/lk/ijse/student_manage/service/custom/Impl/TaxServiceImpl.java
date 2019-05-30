/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.TaxDAO;
import lk.ijse.student_manage.dto.TaxDTO;
import lk.ijse.student_manage.service.custom.TaxService;

/**
 *
 * @author  chamara 
 */
public class TaxServiceImpl implements TaxService{
 
    private TaxDAO taxDAO;

    public TaxServiceImpl() {
        taxDAO = (TaxDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Tax);
    }
    
    @Override
    public boolean add(TaxDTO dto) throws Exception {
        return taxDAO.add(dto);
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
