package com.sahaj.cleanstrike;

public class Player {

	private String playerName;
	private String playerId;

	public Player(String playerName, String playerId) {
		super();
		this.playerName = playerName;
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	@Override
	public String toString() {
		return "Id: " + this.playerId + "Name: " + this.playerName;
	}

}
