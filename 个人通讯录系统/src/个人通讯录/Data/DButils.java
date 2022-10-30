package 个人通讯录.Data;

import 个人通讯录.config.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {

    public static void connection(){
        try {
            Class.forName(database.name);
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLException:"+e.getMessage());
        }
    }
    public static void close(Connection con, Statement stmt, ResultSet rs){

        try {
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void close(Connection con, Statement stmt){

        try {
            con.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
