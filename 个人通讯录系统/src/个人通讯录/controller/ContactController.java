package 个人通讯录.controller;

import 个人通讯录.Data.DButils;
import 个人通讯录.config.database;
import 个人通讯录.service.impl.ContactServiceImpl;

import javax.swing.*;
import java.sql.*;

public class ContactController {

    public static void view(JTextArea jTextArea1){
        DButils.connection();
        try {
            Connection con= DriverManager.getConnection(database.url,database.user,database.password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from contact");
            ContactServiceImpl.operation1(jTextArea1,rs);
            DButils.close(con,stmt,rs);
        } catch (Exception e) {
        }
    }
    public static void search(JTextArea jTextArea1,JTextField jTextField1) throws SQLException {

        Connection con=DriverManager.getConnection(database.url,database.user,database.password);
        Statement stmt=con.createStatement();
        String sqlstr="select * from contact where no='"+jTextField1.getText()+"'";
        ResultSet rs=stmt.executeQuery(sqlstr);
        ContactServiceImpl.operation1(jTextArea1,rs);
        stmt.executeUpdate(sqlstr);
        DButils.close(con,stmt,rs);
    }

    public static void delete(JTextField jTextField1) throws SQLException {
        DButils.connection();
        Connection con=DriverManager.getConnection(database.url,database.user,database.password);
        Statement stmt=con.createStatement();
        String sqlstr="delete from contact where no='"+jTextField1.getText()+"'";
        stmt.executeUpdate(sqlstr);
        DButils.close(con,stmt);

    }

}
