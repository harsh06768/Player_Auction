package com.player.auction.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.player.auction.model.Player;
import com.player.auction.model.Team;


@Repository 
public interface TeamRepository extends JpaRepository<Team,Long>,JpaSpecificationExecutor<Player>{

	public Team findByTeamname(String team_name); 
	

}
