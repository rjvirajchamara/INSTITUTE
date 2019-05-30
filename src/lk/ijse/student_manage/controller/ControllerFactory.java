/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.controller;

import lk.ijse.student_manage.controller.custom.CourseController;
import lk.ijse.student_manage.controller.custom.impl.BatchControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.BatchTransferControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.CourseConrollerImpl;
import lk.ijse.student_manage.controller.custom.impl.GurdlanControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.LoginControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.PeymentControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.QueryControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.RegistrationControllrtImpl;
import lk.ijse.student_manage.controller.custom.impl.StudentControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.TaxControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.batchdetailsControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.paymenttypeControllerImpl;
import lk.ijse.student_manage.dto.paymentTypeDTO;

/**
 *
 * @author chamara
 */
public class ControllerFactory {
    
    public enum ControllerTypes{
        STUDENT,Loging,Batch,Registion,payment,BatchTransfer,Course,paymenttype,batchdetails,Tax,Query,Gurdlan;
    }
    
    private static ControllerFactory controllerFactory;
    
    private ControllerFactory(){
        
        
        
    }
    
    public static ControllerFactory getInstance(){
        if (controllerFactory == null){
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }
    
    public SuperController getController(ControllerTypes controller) {
        switch (controller){
            case STUDENT:
                return new StudentControllerImpl();
            case Loging:
                return  new LoginControllerImpl();
                
             case Batch:
                 return new BatchControllerImpl();
                 
              case Registion:
                  return  new RegistrationControllrtImpl();
                  
              case payment:
                  return  new  PeymentControllerImpl();
                  
              case BatchTransfer:
                  return  new BatchTransferControllerImpl();
              case Course:
                  return  new CourseConrollerImpl();
              case paymenttype:
                  return  new paymenttypeControllerImpl();
               case  batchdetails:
                   return  new batchdetailsControllerImpl();
               case Tax:
                   return  new TaxControllerImpl();
               case Query:
                   return  new QueryControllerImpl();
               case Gurdlan:
                   return  new GurdlanControllerImpl();
                   
            default:
                return null;
        }
    }
    
}
