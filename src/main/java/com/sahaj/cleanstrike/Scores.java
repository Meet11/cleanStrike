package com.sahaj.cleanstrike;

public class Scores {

	private Player player;

	private int playerPoints;
	private int playerFoulCount;
	private int noCoinPocketedSuccessiveTurn;

	public Scores(Player player) {
		this.player = player;
		this.playerPoints = 0;
		this.playerFoulCount = 0;
		this.noCoinPocketedSuccessiveTurn = 0;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getPlayerPoints() {
		return playerPoints;
	}

	public void updatePlayerPoints(int pointsScored) {
		this.playerPoints += pointsScored;
	}

	public int getPlayerFoulCount() {
		return playerFoulCount;
	}

	public void incrementPlayerFoulCount() {
		this.playerFoulCount += 1;
	}

	public int getNoCoinPocketedSuccessiveTurn() {
		return noCoinPocketedSuccessiveTurn;
	}

	public void updateNoCoinPocketedSuccessiveTurn() {
		this.noCoinPocketedSuccessiveTurn += 1;
	}

	public void resetNoCoinPocketedSuccessiveTurn() {
		this.noCoinPocketedSuccessiveTurn = 0;
	}

	@Override
	public String toString() {
		return "Name: " + this.player.getPlayerName() + " | Points: " + this.playerPoints
				+ " | Foul Count: " + this.playerFoulCount;
	}

}


//Can have score board class with player -> score map