package com.player.auction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.player.auction.model.Player;


@Repository 
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	@Query(value="select tbl_players.player_name from tbl_players inner join tbl_team on tbl_team.team_id = tbl_players.team_team_id where tbl_team.teamname = :teamname order by tbl_players.player_name" ,nativeQuery=true)
	public List<String> getPlayersByTeamName(@PathVariable("teamname") String teamname); 
	
	
	 @Query(value="select tbl_players.player_id, tbl_players.player_name, tbl_players.player_type , tbl_players.bidding_budget,  tbl_team.teamname from tbl_players inner join tbl_team on tbl_team.team_id = tbl_players.team_team_id where tbl_players.player_id = :player_id" ,nativeQuery=true)
	 public List<String> getPlayerById(@PathVariable("player_id") Long player_id); 
	 
	 
	 @Query(value="select tbl_players.player_id, tbl_players.player_name, tbl_team.teamname from tbl_players inner join tbl_team on tbl_team.team_id = tbl_players.team_team_id where tbl_players.player_type = :player_type" ,nativeQuery=true)
	 public List<String> getAllPlayerByPlayerType(@PathVariable("player_type") String player_type); 
	 
	
}
