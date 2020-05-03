/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.SQLDATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import finalproject.Identitiy.timediff;
/**
 *
 * @author Nazelin
 */
public class SQLIndex {
    
    Connection conn=null;
    Statement stat=null;
    PreparedStatement preste=null;
    ResultSet resset = null;
    public void LıstSQL()
    {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatas","root","1234");
                stat=conn.createStatement();
                resset=stat.executeQuery("SELECT* FROM projectdatas.clothes");
                SimpleDateFormat dcon= new SimpleDateFormat("dd.MM.yyyy");
                
                while(resset.next())
                {
                    int id=resset.getInt("ID");
                    String color= resset.getString("COLOR");
                    String type=resset.getString("TYPE");
                    Date adddt=resset.getDate("ADDED_DATE");
                    Date wrodt=resset.getDate("WORE_DATE");
                    int day=resset.getInt("DAY");
                    
                    System.out.println("ID ="+id);
                    System.out.println("COLOR ="+color);
                    System.out.println("TYPE = "+type);
                    System.out.println(dcon.format(adddt));
                    System.out.println(dcon.format(wrodt));
                    System.out.println("DAY = "+day);
                }
                resset.close();
                stat.close();
                conn.close();
        }
                catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }
                catch(Exception e)
                {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }
                try{
                    if(stat!=null)
                        stat.close();
                }
                catch(SQLException se2){
                }// nothing we can do
                try{
                if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                   }
                }
    public void AddDataSQL(int id,String clr,String types,Date aa,Date bb)
    {
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatas","root","1234");
                //stat=conn.createStatement();
                preste=conn.prepareStatement("INSERT INTO projectdatas.clothes (ID,COLOR,TYPE,ADDED_DATE,WORE_DATE,DAY)"+ "VALUES(?,?,?,?,?,?)");
                java.util.Calendar cal = Calendar.getInstance();
                java.util.Calendar cal1= Calendar.getInstance();
                cal.setTime(aa);
                cal1.setTime(bb);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0); 
                cal1.set(Calendar.HOUR_OF_DAY, 0);
                cal1.set(Calendar.MINUTE, 0);
                cal1.set(Calendar.SECOND, 0);
                cal1.set(Calendar.MILLISECOND, 0); 
                java.sql.Date sqldt = new java.sql.Date(cal.getTime().getTime());
                java.sql.Date sqldt1 = new java.sql.Date(cal1.getTime().getTime());
                Date today=new Date();
                preste.setInt(1,id);
                preste.setString(2,clr);
                preste.setString(3,types);
                preste.setDate(4,sqldt);
                preste.setDate(5,sqldt1);
                preste.setInt(6,timediff.Difcalender(aa,today));
                preste.execute();
                conn.close();
                
        }
        catch(Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public void DeletefromSQL(int ids)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatas","root","1234");
            preste=conn.prepareStatement("DELETE FROM clothes WHERE ID=?");
            preste.setInt(1,ids);
            preste.execute();
            conn.close();
            
        }
        catch(Exception ex)
        {
            System.err.println("Got an exception! ");
            System.err.println(ex.getMessage());
        }
    }
    
        
    }
