package com.player.auction.service;

import java.util.List;

import com.player.auction.exception.ResourceNotFoundException;
import com.player.auction.model.Player;
import com.player.auction.model.Team;

public interface ServiceAuction {

	public Team addTeam(Team team) throws Exception; 
	public List<Team> listAllTeam(); 
	
	public Player addPlayer(Player player); 
	public List<Player> listAllPlayer(); 
	
	
	//add a player in a team  by team name 
	public Player addPlayerByTeamName(String team_name, Player player) throws Exception; 
	
	// show all players by team name  
	public List<String> getAllPlayersByTeamName(String teamname) throws Exception;
	
	// get player info  by player id 
	public List<String> getPlayerById(Long player_id); 
	
	// get all player by player type 
	public List<String> getAllPlayerByPlayerType(String player_type); 
	
	// updating team budget 
	public String updateTotalBudget(Long team_id, Long budget) throws Exception; 
	
	// updating player 
	 public Player updatePlayer(Player player, Long player_id) throws Exception;
	 
	 // delete a player by player id 
	 public String deletePlayer(Long player_id);
	 
	
}
