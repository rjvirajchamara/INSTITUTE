/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service;

import lk.ijse.student_manage.controller.custom.impl.paymenttypeControllerImpl;
import lk.ijse.student_manage.service.custom.Impl.BatchServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.BatchTransferServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.CourseServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.GurdlanServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.PeymentServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.QueryServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.RegistrationServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.StudentServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.TaxServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.batchdetailsServiceImpl;
import lk.ijse.student_manage.service.custom.Impl.paymenttypeServiceImpl;

/**
 *
 * @author chamara
 */
public class ServiceFactory {
    public enum ServiceTypes{
        STUDENT,Registration,Batch,payment,BatchTransfer,Course,paymenttype,batchdetails,Tax,Query,Gurdlan;
    }
    
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){
        
        
        
    }
    
    public static ServiceFactory getInstance(){
        if (serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getService(ServiceTypes serviceTypes) {
        switch (serviceTypes){
            case STUDENT:
                return new StudentServiceImpl();
                case Registration:
                    return  new RegistrationServiceImpl();
                case Batch:
                    return  new BatchServiceImpl();
                case payment:
                    return  new PeymentServiceImpl ();
                case BatchTransfer:
                    return  new BatchTransferServiceImpl();
                 case Course:
                     return  new CourseServiceImpl();
                 case paymenttype:
                     return  new paymenttypeServiceImpl();
                  case batchdetails:
                  return  new batchdetailsServiceImpl();
                  
                  case Tax:
                    return  new TaxServiceImpl();
                    
                  case Query:
                      return  new QueryServiceImpl();
                  case  Gurdlan:
                  return  new GurdlanServiceImpl();
                  
                //  return  new 
                
            default:
                return null;
        }
    }
}
