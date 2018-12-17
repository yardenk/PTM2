package com.ptm.example;

import java.io.Serializable;

public class GameRequest implements Serializable {

	private static final long serialVersionUID = 3418510758017997477L;
	private final long gameStartTime;
	
	public GameRequest(long gameStartTime) {
		this.gameStartTime = gameStartTime;
	}
	
	public long getGameStartTime() {
		return this.gameStartTime;
	}
}
