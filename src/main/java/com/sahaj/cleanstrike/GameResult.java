package com.sahaj.cleanstrike;

public class GameResult {

	private Player winner;

	private boolean gameDrawed = false;

	public Player getWinner() {
		return this.winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public boolean isGameDrawed() {
		return gameDrawed;
	}

	public void setGameDrawed(boolean gameDrawed) {
		this.gameDrawed = gameDrawed;
	}
}
