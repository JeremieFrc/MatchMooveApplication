package com.societe.project.firebase;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.gson.JsonObject;
import com.societe.project.firebase.models.FirstMessage;
import com.societe.project.models.Message;
import com.societe.project.models.PT;
import com.societe.project.models.Trajet;
import com.societe.project.services.RecuperationInfoLoginService;
import com.societe.project.services.TrajetService;

@Service
public class FirebaseService {
	@Autowired
	TrajetService trajetService;
	@Autowired
	RecuperationInfoLoginService recuperationInfoLogin;
	
	public void createFirebaseTrajet(int id) throws IOException {
			DatabaseReference Ref = FirebaseOpenHelper.getInstance().getDatabase().getReference("conversations/");
			 Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
			 
			 FirstMessage firstMessage = new FirstMessage();
		    firstMessage.setContent("Conversation  pour trajet "+ trajetService.find(id).get().getNom() );
		    firstMessage.setDate( currentDate.toString());
		   
            System.out.println(firstMessage);
			String trajetId = String.valueOf(id);
			
		    Ref.child(trajetId).push().setValueAsync(firstMessage);
		  
	   }
	
	public Trajet getUserTrajet(){
		Trajet result =new Trajet(-1,"lolo");
	    Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		System.out.println(currentDate);
		 
        if(!recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getPT().isEmpty())
		{
        	Date temp = recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getPT().get(0).getTrajet().getDateDepart();
        	result =    recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getPT().get(0).getTrajet();
			for(PT pt : recuperationInfoLogin.recuperationCompteForUserLogge().getProfil().getPT()) {
				if(temp.after(pt.getTrajet().getDateDepart()))
				{
					if( currentDate.compareTo(pt.getTrajet().getDateDepart()) < 0) 
					{
						temp = pt.getTrajet().getDateDepart();
						result = pt.getTrajet();
					}
				}
			
			}
		}
		return result;
	}
	

}
