package com.player.auction.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name= "tbl_players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long player_id; 
	private String player_name; 
	private String player_type; 
	private Long bidding_budget;
	
	
	//@ManyToOne(cascade = CascadeType.ALL)
	
	@ManyToOne
	@JsonBackReference
	private Team team; 
	

	
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Player(Long player_id, String player_name, String player_type, Long bidding_budget, Team team) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.player_type = player_type;
		this.bidding_budget = bidding_budget;
		this.team = team;
	}


	public Long getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}


	public String getPlayer_name() {
		return player_name;
	}


	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}


	public String getPlayer_type() {
		return player_type;
	}


	public void setPlayer_type(String player_type) {
		this.player_type = player_type;
	}


	public Long getBidding_budget() {
		return bidding_budget;
	}


	public void setBidding_budget(Long bidding_budget) {
		this.bidding_budget = bidding_budget;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + ", player_type=" + player_type
				+ ", bidding_budget=" + bidding_budget;
	} 
	
	
	
}
