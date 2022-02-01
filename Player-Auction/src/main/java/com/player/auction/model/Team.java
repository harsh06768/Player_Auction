package com.player.auction.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;



import java.util.List;
@Entity 
@Table(name= "tbl_team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long team_id; 
	private String teamname; 
	private Long budget;
	
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Player> player; 
	
	
	
	
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Team(Long team_id, String teamname, Long budget) {
		super();
		this.team_id = team_id;
		this.teamname = teamname;
		this.budget = budget;
	}


	public Team(Long team_id, String teamname, Long budget, List<Player> player) {
		super();
		this.team_id = team_id;
		this.teamname = teamname;
		this.budget = budget;
		this.player = player;
	}


	public Long getTeam_id() {
		return team_id;
	}


	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}


	public String getTeam_name() {
		return teamname;
	}


	public void setTeam_name(String teamname) {
		this.teamname = teamname;
	}


	public Long getBudget() {
		return budget;
	}


	public void setBudget(Long budget) {
		this.budget = budget;
	}


	public List<Player> getPlayer() {
		return player;
	}


	public void setPlayer(List<Player> player) {
		this.player = player;
	}


}
