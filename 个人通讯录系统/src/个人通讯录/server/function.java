package 个人通讯录.server;

import 个人通讯录.Data.DButils;
import 个人通讯录.config.database;
import 个人通讯录.controller.ContactController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class function extends JFrame
{
	public function() {
	}
	private JTextArea jTextArea1;
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	//private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JScrollPane jScrollPane1;
	private JButton jButton6;
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton1;
	private JButton jButton2;
	private JTextField jTextField6;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;

	{
		this.setBounds(300,300,900,600);
		this.setTitle("个人通讯录系统");
		Container s= getContentPane();
		s.setBounds(-8, -30, 558, 500);
		{
			jScrollPane1 = new JScrollPane();
			s.add(jScrollPane1);
			jScrollPane1.setBounds(12, 12,720, 120);
			{
				jTextArea1 = new JTextArea();
				jScrollPane1.setViewportView(jTextArea1);
				jTextArea1.setBounds(12, 12, 460, 200);
			}
		}
		{
			jLabel1 = new JLabel();
			s.add(jLabel1);
			jLabel1.setText("ID");
			jLabel1.setBounds(12, 146, 48, 18);
		}
		{
			jTextField1 = new JTextField();
			s.add(jTextField1);
			jTextField1.setBounds(60, 144, 78, 24);
		}
		{
			jTextField2 = new JTextField();
			s.add(jTextField2);
			jTextField2.setBounds(226, 144, 78, 24);
		}
		{
			jLabel2 = new JLabel();
			s.add(jLabel2);
			jLabel2.setText("姓名：");
			jLabel2.setBounds(187, 146, 39, 18);
		}
		{
			jLabel4 = new JLabel();
			s.add(jLabel4);
			jLabel4.setText("类别：");
			jLabel4.setBounds(12, 180, 54, 17);
		}
		{
			jTextField4 = new JTextField();
			s.add(jTextField4);
			jTextField4.setBounds(60, 180, 78, 24);
		}
		{
			jLabel5 = new JLabel();
			s.add(jLabel5);
			jLabel5.setText("电话：");
			jLabel5.setBounds(185, 180, 43, 17);
		}
		{
			jTextField5 = new JTextField();
			s.add(jTextField5);
			jTextField5.setBounds(226, 180, 78, 24);
		}
		{
			jLabel6 = new JLabel();
			s.add(jLabel6);
			jLabel6.setText("地址：");
			jLabel6.setBounds(355, 180, 43, 17);
		}
		{
			jTextField6 = new JTextField();
			s.add(jTextField6);
			jTextField6.setBounds(394, 180, 78, 24);
		}
		{
			jButton1 = new JButton();
			s.add(jButton1);
			jButton1.setText("显示联系人信息");
			jButton1.setBounds(12, 221, 135, 24);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					ContactController.view(jTextArea1);

				}
			});
		}
		{
			jButton2 = new JButton();
			s.add(jButton2);
			jButton2.setText("查询联系人信息");
			jButton2.setBounds(168, 221, 131, 24);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DButils.connection();
					try {

						ContactController.search(jTextArea1,jTextField1);

					} catch (Exception e) {
						jTextField1.setText("");
					}
				}
			});
		}
		{
			jButton3 = new JButton();
			s.add(jButton3);
			jButton3.setText("添加联系人信息");
			jButton3.setBounds(321, 221, 140, 24);
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DButils.connection();
					try {
						Connection con=DriverManager.getConnection(database.url,database.user,database.password);
						Statement stmt=con.createStatement();
						String sqlstr="insert into contact values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"')";
						stmt.executeUpdate(sqlstr);
						DButils.close(con,stmt);
						jTextField1.setText("");
						jTextField2.setText("");
						jTextField4.setText("");
						jTextField5.setText("");
						jTextField6.setText("");
					} catch (Exception e) {
					}
				}
			});
		}
		{
			jButton4 = new JButton();
			s.add(jButton4);
			jButton4.setText("修改联系人信息");
			jButton4.setBounds(12, 260, 135, 24);
			jButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DButils.connection();
					try {
						Connection con=DriverManager.getConnection(database.url, database.user, database.password);
						Statement stmt=con.createStatement();
						String sqlstr="update contact set " +
								"name='"+jTextField2.getText()+"'" +
								",class='"+jTextField4.getText()+"'" +
								",phone='"+jTextField5.getText()+"'" +
								",mail='"+jTextField6.getText()+"'" +
								"where no='"+jTextField1.getText()+"'";
						stmt.executeUpdate(sqlstr);
						DButils.close(con,stmt);
						jTextField1.setText("");
						jTextField2.setText("");
						jTextField4.setText("");
						jTextField5.setText("");
						jTextField6.setText("");
					} catch (Exception e) {
					}
				}
			});
		}
		{
			jButton5 = new JButton();
			s.add(jButton5);
			jButton5.setText("删除联系人信息");
			jButton5.setBounds(167, 260, 132, 24);
			jButton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					try {
						ContactController.delete(jTextField1);
						jTextField1.setText("");
					} catch (Exception e) {
					}
				}
			});
		}
		{
			jButton6 = new JButton();
			s.add(jButton6);
			jButton6.setText("退出");
			jButton6.setBounds(321, 260, 140, 24);
			jButton6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			});
		}
		{	
		getContentPane().setLayout(null);
		this.setAlwaysOnTop(false);
		
		}
	}
}

