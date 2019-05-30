/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.QueryDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.dto.StudentDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class QueryDAOImpl implements QueryDAO {

    private Connection connection;

    public QueryDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public ArrayList<QueryDTO> getCourseName(String Dto) throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT s.Name, s.Nic, c.Coursename\n"
                + "FROM Student s, Coures c, Registration r\n"
                + "WHERE s.SID=r.SID AND c.CID=r.CID AND s.SID ='" + Dto + "'");
        ArrayList<QueryDTO> allSearch = new ArrayList<>();
        while (rst.next()) {
            QueryDTO re = new QueryDTO();
            re.setStudentname(rst.getString("Name"));
            re.setCoursename(rst.getString("Coursename"));
            System.out.println("couname");
            re.setNIC(rst.getString("Nic"));
            //  re.setCoursename("Coursename");

            allSearch.add(re);
        }

        // return allSearchIndexs;
        return allSearch;

    }

    @Override
    public boolean add(QueryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(QueryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QueryDTO get(String Dto) throws Exception {

        return null;
    }

    @Override
    public ArrayList<QueryDTO> getAll() throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select  batch.BID, batch.Batchname,batchdetails.BAID,batchdetails.CID,batchdetails.Bstatas,batchdetails.startdate\n"
                + "FROM batch\n"
                + "INNER JOIN batchdetails\n"
                + "ON batchdetails.BID=batch.BID;");
       ArrayList<QueryDTO> all = new ArrayList<>();
        while (rst.next()) {
            
            QueryDTO re = new QueryDTO();
            re.setBatchBAID(rst.getString("BID"));
            re.setBatchName(rst.getString("Batchname"));
            re.setBatchBAID(rst.getString("BAID"));
            re.setBatchID(rst.getString("CID"));
            re.setBatchStatus(rst.getString("Bstatas"));
            re.setBatchDate(rst.getString("startdate"));

            // System.out.println("h"+allSearch.toString());
            all.add(re);
            // System.out.println("h");
        }

        return all;

}

    @Override
    public ArrayList<QueryDTO> getALlstudent() throws Exception {
      Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select student.SID,student.Name,student.Address,student.Telephone,student.School,student.email,student.Nic,student.dob,student.Hignereduquq,gurdlan.Gname,gurdlan.Gmobile,gurdlan.GAddress\n" +
"FROM student\n" +
"INNER JOIN gurdlan\n" +
"ON gurdlan.SID=student.SID");
        ArrayList<QueryDTO> allSearch = new ArrayList<>();
        while (rst.next()) {
            QueryDTO re = new QueryDTO();
            re.setSID(rst.getString("SID"));
            re.setName(rst.getString("Name"));
            re.setAddress(rst.getString("Address"));
            re.setTelephone(rst.getString("Telephone"));
            re.setSchool(rst.getString("School"));
            re.setEmail(rst.getString("email"));
             re.setNIC(rst.getString("Nic"));
            re.setDob(rst.getString("dob"));
           // re.setNIC(rst.getString("Nic"));
            re.setHignereduquq(rst.getString("Hignereduquq"));
            re.setGname(rst.getString("Gname"));
            re.setGmobile(rst.getString("Gmobile"));
            re.setGAddress(rst.getString("GAddress"));
           // re.setEmail(rst.getString("startdate"));

            // System.out.println("h"+allSearch.toString());
            allSearch.add(re);
            // System.out.println("h");
        }

        return allSearch;

    }

    @Override
    public ArrayList<QueryDTO> getALlpayment() throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select registration.SID,payment.PID,payment.Ptype,payment.RID,payment.fee,payment.discount,payment.firstAmount,payment.secondAmount,payment.DuepaymentDate,payment.tax,payment.delay,payment.totalAmount,payment.balance,payment.Date,payment.payment_statas\n" +
"FROM registration\n" +
"INNER JOIN payment\n" +
"ON  registration.RID=payment.RID;");
        ArrayList<QueryDTO> alllSearch = new ArrayList<>();
        while (rst.next()) {
            QueryDTO re = new QueryDTO();
            re.setSID(rst.getString("SID"));
            re.setPid(rst.getString("PID"));
            re.setPtype(rst.getString("Ptype"));
            re.setRid(rst.getString("RID"));
            re.setFee(rst.getBigDecimal("fee"));
            re.setDiscount(rst.getInt("discount"));
            re.setFirstAmount(rst.getBigDecimal("firstAmount"));
             re.setSecondAmount(rst.getBigDecimal("secondAmount"));
         //   re.setDob(rst.getString(""));
           re.setTax(rst.getBigDecimal("tax"));
            re.setDelay(rst.getInt("delay"));
            re.setTotalAmount(rst.getBigDecimal("totalAmount"));
            re.setBalance(rst.getBigDecimal("balance"));
            re.setpDate(rst.getDate("Date"));
            re.setpStatus(rst.getString("payment_statas"));
            re.setDuePaymentDate(rst.getDate("DuepaymentDate"));
           // re.setEmail(rst.getString("startdate"));

            // System.out.println("h"+allSearch.toString());
            alllSearch.add(re);
            // System.out.println("h");
        }

        return alllSearch;
    }}