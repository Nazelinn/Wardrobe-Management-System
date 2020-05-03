/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Identitiy;
import java.util.Calendar;
import java.util.Date;
import finalproject.SQLDATA.*;
/**
 *
 * @author Nazelin
 */
public class Cloth extends SQLIndex{
    
    private String type;
    private String color;
    private Date adding_date=new Date(); 
    private Date wore_date=new Date(-1900,0,0);
    private int ID=0;
    public Cloth(String color,String type)
    {
        this.type=type;
        this.color=color;
        Propery Idcounter= new Propery();
        this.ID =Idcounter.GetIDCounter();
        Idcounter.setprop(this.ID+1);
        
    }
    public void PrintInfos()
    {
        System.out.println("Id : "+this.ID);
        System.out.println("Color : "+this.color);
        System.out.println("Type :" + this.type);
        System.out.println("Adding time : "+ this.adding_date);
        System.out.println("Wore time : "+this.wore_date);
    }
    public void AddDataBase()
    {
        try
        {
            this.AddDataSQL(this.ID, this.color, this.type,this.adding_date,this.wore_date);
        }
        catch(Exception ex)
        {
            
        }
       
    }
        
  }
