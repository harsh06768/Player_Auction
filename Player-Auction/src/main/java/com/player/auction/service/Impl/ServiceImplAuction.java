package com.player.auction.service.Impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.auction.exception.ResourceNotFoundException;
import com.player.auction.model.Player;
import com.player.auction.model.Team_Budget_Name_Comparator;
import com.player.auction.model.Team;
import com.player.auction.repository.PlayerRepository;
import com.player.auction.repository.TeamRepository;
import com.player.auction.service.ServiceAuction;



@Service
public class ServiceImplAuction implements ServiceAuction{

	
	@Autowired
	private PlayerRepository playerRepo; 
	
	@Autowired
	private TeamRepository teamRepo; 
	
	
	
	@Override
	public Team addTeam(Team team) throws Exception{
		
		Optional<Team> ts = this.teamRepo.findById(team.getTeam_id());
		
		if(ts.isPresent()) {
			throw new Exception("Team already Exist !!"); 
		}
		
		
		return teamRepo.save(team);
	}

	@Override
	public List<Team> listAllTeam() {
		
		List<Team> teams = new ArrayList<>(); 
		teams =  teamRepo.findAll();
		
		Collections.sort(teams,new Team_Budget_Name_Comparator());  
		  
		return teams; 
		
		
	}

	@Override
	public Player addPlayer(Player player) {
		
		return playerRepo.save(player);
	}

	@Override
	public List<Player> listAllPlayer() {
		
		return playerRepo.findAll();
	}

	
	
	
	//add a player in a team  by team name 
	
	@Override
	public Player addPlayerByTeamName(String team_name, Player player) throws Exception {

		Long sum = 0L; 
		
		// logic for checking if given team exist or not 
		Team team =  this.teamRepo.findByTeamname(team_name); 
		
		if(team == null) {
			throw new Exception("No such Team is there in the Database !!"); 
		}
		// logic ends here  for checking if given team exist or not 
		
		
		// logic for budget exceed start here 
		
		List<Player> players = team.getPlayer(); 
		for(Player p: players) {
			 sum = sum + p.getBidding_budget(); 
			//System.out.println(p.getPlayer_name()); 
		}
		sum = sum + player.getBidding_budget(); 
		
		if(sum > team.getBudget()) {
			throw new Exception("Team Maximum Budget Exceed"); 
			
		}
			
		// logic for budget exceed ends here 
		
		player.setTeam(team);
		
		// logic for checking if player with given id  already present 
		Long playerId = player.getPlayer_id(); 
		Optional<Player> play = this.playerRepo.findById(playerId); 
		
		if(play.isPresent()) {
			throw new Exception("Player with the given Id is already present"); 
		}
			
		// logic ends here  for checking if player with given id  already present 
		
		return  playerRepo.save(player); 
		
	}



	// show all players by team name  
	@Override
	public List<String> getAllPlayersByTeamName(String teamname) throws Exception{
		
				// logic for checking if given team exist or not 
				Team team =  this.teamRepo.findByTeamname(teamname); 
				
				if(team == null) {
					throw new Exception("No such Team is there in the Database !!"); 
				}
				
				return playerRepo.getPlayersByTeamName(teamname);
	}

	
	//get player info  by player id 
	@Override
	public List<String> getPlayerById(Long player_id) {
		
		return playerRepo.getPlayerById(player_id);
	}
	
	// get all player by player type 
	@Override
	public List<String> getAllPlayerByPlayerType(String player_type) {
		
		return playerRepo.getAllPlayerByPlayerType(player_type);
	}
	
	// update total team budget 
	@Override
	public String updateTotalBudget(Long team_id, Long budget) throws Exception{
		
		Optional<Team> team = teamRepo.findById(team_id);  
		
    	Team teams = team.get(); 
    	
    	teams.setBudget(budget);
    	teamRepo.save(teams); 
    	return "Successfully Updated";
    	
	}	

	
	// updating player 
	 @Override
	  public Player updatePlayer(Player player, Long player_id) throws Exception{
	    
	    Player play = playerRepo.findById(player_id).get();
	    if(play.getPlayer_id()!=0) {
	    	play.setPlayer_name(player.getPlayer_name());
	    	play.setPlayer_type(player.getPlayer_type());
	    	play.setBidding_budget(player.getBidding_budget());
	    	
	    }
	    else
	    {
	     throw new Exception("Player with this id not exist in database");
	    	
	    }
	    
	    playerRepo.save(play);
	    return play;
	    
	    
	  }
	 
	
	 // delete player by player id 
	@Override
	public String deletePlayer(Long player_id) {
		playerRepo.deleteById(player_id);
		
	
		return "Player with Player ID : "+ player_id+ " deleted succesfully";
	}
	


}
	


