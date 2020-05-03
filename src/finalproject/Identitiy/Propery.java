package finalproject.Identitiy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazelin
 */
public class Propery {
        
    Properties prop = new Properties();
    OutputStream output = null;
    InputStream input=null;
    
public void setprop(int Id,int maxshirt,int maxpant)
{
    
        try 
        {
            
            output = new FileOutputStream("config.properties");
            
            prop.setProperty("IDcounter",Integer.toString(Id));
            prop.setProperty("Maxtshirtday",Integer.toString(maxshirt));
            prop.setProperty("Maxpantday",Integer.toString(maxpant));
            
            prop.store(output,null);
            
        }
        catch(IOException ex) {
		ex.printStackTrace();
	} 
        finally 
        {
		if (output!= null) {
			try {
				output.close();
			} catch (IOException e) 
                        {
				e.printStackTrace();
			}
    
}
    
    
    
}
}
public void setprop(int Id)
{
    
        try 
        {
            
            output = new FileOutputStream("config.properties");
            
            prop.setProperty("IDcounter",Integer.toString(Id));
            
            prop.store(output,null);
            
        }
        catch(IOException ex) {
		ex.printStackTrace();
	} 
        finally 
        {
		if (output!= null) {
			try {
				output.close();
			} catch (IOException e) 
                        {
				e.printStackTrace();
			}
    
}
    
    
    
}
}
public int GetIDCounter()
{
    String ID1="";
    int ID2=0;
    try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		ID1=(prop.getProperty("IDcounter"));

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}    
                
	}
    ID2=Integer.parseInt(ID1);
    return ID2;
  }

}

