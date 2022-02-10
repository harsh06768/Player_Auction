package com.player.auction.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.auction.model.Team;
import com.player.auction.service.ServiceAuction;

@RestController
@RequestMapping("/auction/team") 
public class TeamController {
	@Autowired 
	private ServiceAuction serviceAuc; 
	
	
	// add a team 
	@PostMapping("/addteam")
	public ResponseEntity<Map<String, Object>> addTeam(@RequestBody Team team) throws Exception{
		Map<String, Object> response = new LinkedHashMap<String, Object>(); 
		response.put("header", "Add Team" ); 
		response.put("Error", false); 
		response.put("message", serviceAuc.addTeam(team));
		response.put("HttpStatus", HttpStatus.ACCEPTED); 
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
	}
	
	
	// get all team 
	@GetMapping("/getallteam")
	public ResponseEntity<Map<String, Object>> listAllTeam() {
		Map<String, Object> response = new LinkedHashMap<String, Object>(); 
		response.put("header", "List all Team" ); 
		response.put("Error", false); 
		response.put("message", serviceAuc.listAllTeam());
		response.put("HttpStatus", HttpStatus.ACCEPTED); 
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
	}
	
	//updating teams total budget 
	@PutMapping("/updateteambudget/{team_id}/{budget}")
	public ResponseEntity<Map<String, Object>> updateTotalBudget(@PathVariable("team_id") Long team_id, @PathVariable("budget") Long budget) throws Exception {
		Map<String, Object> response = new LinkedHashMap<String, Object>(); 
		response.put("header", "Update total budget" ); 
		response.put("Error", false); 
		response.put("message", serviceAuc.updateTotalBudget(team_id, budget));
		response.put("HttpStatus", HttpStatus.ACCEPTED); 
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
	}
	


}
