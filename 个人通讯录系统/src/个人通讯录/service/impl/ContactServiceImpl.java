package 个人通讯录.service.impl;

import 个人通讯录.service.ContactService;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactServiceImpl implements ContactService {


    public static void operation1(JTextArea jTextArea1, ResultSet rs) {
        jTextArea1.setText(null);
        try {
            while(rs.next()){
                jTextArea1.append("ID："+rs.getString("no")+"\t");
                jTextArea1.append("姓名："+rs.getString("name")+"\t");
                jTextArea1.append("类别："+rs.getString("class")+"\t");
                jTextArea1.append("电话："+rs.getString("phone")+"\t");
                jTextArea1.append("地址："+rs.getString("mail")+"\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
