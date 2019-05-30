/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dao;

import lk.ijse.student_manage.controller.custom.impl.TaxControllerImpl;
import lk.ijse.student_manage.controller.custom.impl.paymenttypeControllerImpl;
import lk.ijse.student_manage.dao.custom.BatchTransferDAO;
import lk.ijse.student_manage.dao.custom.impl.BatchDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.BatchTransferDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.CourseDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.GurdlanDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.LoginDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.PeymentDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.QueryDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.StudentDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.TaxDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.batchdetailsDAOImpl;
import lk.ijse.student_manage.dao.custom.impl.paymenttypeDAOImpl;

/**
 *
 * @author chamara
 */
public class DAOFactory {
    
    public enum DAOTypes{
        STUDENT, Login,Batch,Registration,payment,BatchTransfer,Course,paymenttype,batchdetails,Tax,Query,Gurdlan;
    }
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType) {
        switch(daoType){
            case STUDENT:
                return new StudentDAOImpl();
                
                case Login:
                    return  new LoginDAOImpl();
                    
                case Batch:
                    return  new BatchDAOImpl();
                    
                case Registration:
                    return new RegistrationDAOImpl();
                    
                case payment:
                    return  new PeymentDAOImpl();
                 
                case Course:
                    return  new CourseDAOImpl();
                
                case  paymenttype:
                    return  new paymenttypeDAOImpl();
                case batchdetails:
                    return  new batchdetailsDAOImpl();
                case Tax:
                    return  new TaxDAOImpl();
                case Query:
                    return  new QueryDAOImpl();
                    
                case Gurdlan:
                    return  new GurdlanDAOImpl();
                    
//                case BatchTransfer:
//                  return  new BatchTransferDAOImpl();
//            
            default:
                return null;
        }
    }
    
}
