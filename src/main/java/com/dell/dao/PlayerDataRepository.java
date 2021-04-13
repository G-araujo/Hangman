package com.dell.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dell.entities.PlayerData;

public interface PlayerDataRepository extends JpaRepository<PlayerData, Long> {

	PlayerData findBySessionIdAndHangmanMgmtState(String sessionId, String state);
	
}
