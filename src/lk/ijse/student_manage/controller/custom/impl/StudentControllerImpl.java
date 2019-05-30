/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.controller.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.StudentController;
import lk.ijse.student_manage.dto.GurdlanDTO;


import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.SuperDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.StudentService;

/**
 *
 * @author chamara
 */
public class StudentControllerImpl implements StudentController {

    private StudentService studentService;

    public StudentControllerImpl() {
       studentService= (StudentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.STUDENT);
    }

    @Override
    public boolean add(StudentDTO dto) throws Exception {
        return studentService.add(dto);
    }

    @Override
    public boolean update(StudentDTO dto) throws Exception {
        return studentService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentService.delete(id);
    }

    @Override
    public StudentDTO search(String id) throws Exception {
        return studentService.get(id);
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception {
        return studentService.getAll();
    }

    @Override
    public boolean adWithTrance(StudentDTO s, GurdlanDTO a) throws Exception {
        return studentService.adWithTrance(s, a);
    }

    

 
    }

    

