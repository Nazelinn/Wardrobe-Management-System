/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Identitiy;

/**
 *
 * @author Nazelin
 */
import java.util.*;

/**
 *
 * @author Nazelin
 */
public class timediff {
    public static int Difcalender(Date a,Date b)
    {
        int temp=0;
        int difference=0;
        Calendar early=Calendar.getInstance();
        Calendar later=Calendar.getInstance();
        if(a.compareTo(b)>0)
        {
            later.setTime(a);
            early.setTime(b);
        }
        else
        {
            later.setTime(b);
            early.setTime(a);
        }
        while(later.get(Calendar.YEAR)!=early.get(Calendar.YEAR))
        {
            temp=365*(later.get(Calendar.YEAR)-early.get(Calendar.YEAR));
            difference=temp;
            early.add(Calendar.DAY_OF_YEAR,temp);  
        }
        if(later.get(Calendar.DAY_OF_YEAR)!=early.get(Calendar.DAY_OF_YEAR))
        {
            temp=later.get(Calendar.DAY_OF_YEAR)-early.get(Calendar.DAY_OF_YEAR);
            difference=temp;
            early.add(Calendar.DAY_OF_YEAR,temp); 
        }
        
        return difference;
        
    }
}