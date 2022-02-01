package com.player.auction.model;

import java.util.Comparator;

public class Team_Budget_Name_Comparator implements Comparator{
	public int compare(Object o1,Object o2){  
		
	Team t1=(Team)o1; 
	Team t2=(Team)o2; 
		  
		if(t1.getBudget() == t2.getBudget())  {
			
			return t1.getTeam_name().compareToIgnoreCase(t2.getTeam_name()); 
		
		}
		else if(t1.getBudget()<t2.getBudget())
		return 1;  
		else  
		return -1;  
		}  
}
