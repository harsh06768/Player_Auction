package com.player.auction.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.auction.model.Player;
import com.player.auction.service.ServiceAuction;

@RestController
@RequestMapping("/auction/player") 
public class PlayerController {
	@Autowired 
	private ServiceAuction serviceAuc; 
	
	
	//add a player in a team  by team name 
		@PostMapping("/addplayerwithteamname/{team_name}")
		public ResponseEntity<Player> addPlayerByTeamName(@PathVariable("team_name") String team_name, @RequestBody Player player) throws Exception{
			return new ResponseEntity<Player>(serviceAuc.addPlayerByTeamName(team_name, player), HttpStatus.CREATED);
		}
		
		
		@PostMapping("/addplayer")
		public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
			return new ResponseEntity<Player>(serviceAuc.addPlayer(player), HttpStatus.CREATED);
		}
		
		
		// get all players 
		@GetMapping("/getallplayer")
		public List<Player> listAllPlayer() {
			return serviceAuc.listAllPlayer();
		}
	
		
	// show all players by team name  
		@GetMapping("/getallplayerbyteamname/{teamname}")
		public List<String> getAllPlayersByTeamName(@PathVariable("teamname") String teamname) throws Exception{
			return serviceAuc.getAllPlayersByTeamName(teamname); 
		}
			
		// get player info  by player id 
		@GetMapping("/getplayerbyyid/{player_id}")
		public List<String> getPlayerById(@PathVariable("player_id") Long player_id){
			return serviceAuc.getPlayerById(player_id); 
		}
		
		// get all player by player type 
		@GetMapping("/getallplayerbytype/{player_type}")
		public List<String> getAllPlayerByPlayerType(@PathVariable("player_type") String player_type){
			return serviceAuc.getAllPlayerByPlayerType(player_type);
		}
		
		//updating player 
		  @PutMapping("/updateplayer/{player_id}")
		  public ResponseEntity<Player> updatePlayer(@RequestBody Player player, @PathVariable("player_id") Long player_id) throws Exception{
		    return new ResponseEntity<Player>(serviceAuc.updatePlayer(player, player_id), HttpStatus.OK);
		    
		  }
		  
		  // delete player by player id 
		  @DeleteMapping("/deleteplayer/{player_id}")
		   public ResponseEntity<String> deletePlayer(@PathVariable("player_id") Long player_id){
			    serviceAuc.deletePlayer(player_id);
			    return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		  }
		
}
