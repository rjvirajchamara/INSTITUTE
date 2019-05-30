/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.StudentDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.StudentDTO;

/**
 *
 * @author chamara
 */
public class StudentDAOImpl implements StudentDAO{
    
    private Connection connection;
    
    public StudentDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(StudentDTO student) throws Exception {
        String SQL = "INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, student.getSID());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getAddress());
        stm.setObject(4, student.getTelephone());
        stm.setObject(5, student.getSchool());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getEmail());
        stm.setObject(8, student.getDob());
        stm.setObject(9, student.getNic());
        stm.setObject(10,student.getUniversityorther());
        stm.setObject(11, student.getHignereduquq());
        int res = stm.executeUpdate();
        return (res > 0);
    }

    @Override
    public boolean update(StudentDTO student) throws Exception {
        String SQL="UPDATE Student SET name=?,address=?,telephone=?,School=?,gender=?,email=?,dob=?,Nic=? WHERE sId=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
       stm.setObject(1, student.getSID());
        stm.setObject(2, student.getName());
        stm.setObject(3, student.getAddress());
        stm.setObject(4, student.getTelephone());
        stm.setObject(5, student.getSchool());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getEmail());
        stm.setObject(8, student.getDob());
        stm.setObject(9, student.getNic());
        int res=stm.executeUpdate();
        
        return res>0;
    }

    @Override
    public boolean delete(String key) throws Exception {
       return true;
    }

   

    @Override
    public StudentDTO get(String key) throws Exception {
          String sql="Select * from Student where student_id='"+key+"'";// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Statement preparedStatement= connection.createStatement();
        ResultSet resultSet=preparedStatement.executeQuery(sql);
        if (resultSet.next()) {
            return new StudentDTO(resultSet.getString("SID"),resultSet.getString("Name"),resultSet.getString("Address"),resultSet.getString("Telephone"),resultSet.getString("School"),resultSet.getString("gender"),resultSet.getString("email"),resultSet.getString(" dob"),resultSet.getString("Nic"),resultSet.getString("universityorther"),resultSet.getString("Hignereduquq"));
        }
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception {
        
        String sql = "Select * from Student";
        Statement  preparedStatemen = connection.createStatement();
        ResultSet resultSet =  preparedStatemen.executeQuery(sql);
        ArrayList<StudentDTO> alstudent = null;

        while (resultSet.next()) {

            if (alstudent == null) {
                alstudent = new ArrayList<>();
            }
            StudentDTO student = new StudentDTO(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11));
        
            alstudent.add(student);
    }
        return alstudent;
}}
 
