/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.RegistrationController;
import lk.ijse.student_manage.dto.RegistrationDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.RegistrationService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class RegistrationControllrtImpl implements RegistrationController{
    
    private RegistrationService registrationService;

    public RegistrationControllrtImpl() {
        
        registrationService= (RegistrationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.Registration);
    }
    
    @Override
    public boolean add(RegistrationDTO dto) throws Exception {
        return registrationService.add(dto);
    }

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
        return registrationService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return  registrationService.delete(id);
    }

    @Override
    public RegistrationDTO search(String Dto) throws Exception {
        return registrationService.get(Dto);
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        return  registrationService.getAll();
    }

}
