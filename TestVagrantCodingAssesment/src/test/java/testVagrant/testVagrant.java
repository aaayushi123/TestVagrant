package testVagrant;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class testVagrant
{
    @Test    
    public void findPlayerInfo() throws StreamReadException, DatabindException, IOException
    {


        ObjectMapper objectmapper = new ObjectMapper();
        objectmapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Map<String,List<Object>> playerinfo = objectmapper.readValue(new File( "C:\\Users\\AN104989\\eclipse-workspace\\TestVagrantCodingAssesment\\TestData\\PlayerInfo.json"), new TypeReference<Map<String,List<Object>>>() {});
        //Initialise Count for Country and Role
        int countrycount=0;
        int rolecount=0;
         List<Object> li = playerinfo.get("player");   //Fetch Player array data and store in the List

         for(int i=0; i<li.size();i++) 
         {

         @SuppressWarnings("unchecked")
          Map<String,String> map = (Map<String, String>)li.get(i); 


          if(!map.get("country").equals("India"))  //Get Country value and check conditions for country
          { 
        	  countrycount++; 
        	  
          }
           //System.out.println(map.get("role"));
           if(map.get("role").equals("Wicket-keeper"))  //Get Country value and check conditions for Player role
           { 
        	   rolecount++; 
        	   
           }

           }

           if(countrycount>4)  //Validate if Country count more then 4
           { 
        	   System.out.println("More than 4 foerign Player"); 
        	   
           } 
           else
                  
        	   System.out.println("4 Foerign Player"); 
           
           if(rolecount==1)  //Validate only one wicket Keeper in team or not
           {
                  System.out.println("Only 1 Wicket keeper in team"); 
                  
           } 
           else 
           {
                  System.out.println("More than 1 or No WicketKeeper in Team");
           }

    }

}