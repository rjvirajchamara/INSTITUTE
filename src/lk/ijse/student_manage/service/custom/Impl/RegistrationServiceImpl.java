/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.RegistrationDAO;
import lk.ijse.student_manage.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.student_manage.dto.RegistrationDTO;
import lk.ijse.student_manage.service.custom.RegistrationService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class RegistrationServiceImpl implements RegistrationService{
    
    private RegistrationDAO registrationDAO;
    
    public RegistrationServiceImpl(){
     registrationDAO = (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Registration);
    }
    @Override
    public boolean add(RegistrationDTO dto) throws Exception {
       return registrationDAO.add(dto);
    }

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
        return registrationDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
      return registrationDAO.delete(key);
    }

    @Override
    public RegistrationDTO get(String Dto) throws Exception {
        return registrationDAO.get(Dto);
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        return registrationDAO.getAll();
    }

    
}
