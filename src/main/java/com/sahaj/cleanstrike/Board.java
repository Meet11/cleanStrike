package com.sahaj.cleanstrike;

import java.util.HashMap;

import com.sahaj.resultservice.ResultServiceGetResult;

//Initialize the game Board with coins and check if game over
public class Board {

	private HashMap<Coin, Integer> cleanStrikeCoins = new HashMap<Coin, Integer>();

	public Board() {
		System.out.println("Carrom board ready");
		cleanStrikeCoins.put(Coin.BLACK, 9);
		cleanStrikeCoins.put(Coin.RED, 1);
		cleanStrikeCoins.put(Coin.STRIKER, 1);
	}

	public HashMap<Coin, Integer> getCleanStrikeCoins() {
		return cleanStrikeCoins;
	}

//	Don't need this
//	public void setCleanStrikeCoins(HashMap<Coin, Integer> cleanStrikeCoins) {
//		this.cleanStrikeCoins = cleanStrikeCoins;
//	}

	//This should be in CleanStrike Class
	public boolean isGameOver(ResultServiceGetResult resultServiceGetResult) {
		return isBoardEmpty() || resultServiceGetResult.getCleanStrikeWinner() != null;
	}
	
	public boolean isGameOver() {
		return isBoardEmpty();
	}

	public boolean isBoardEmpty() {
		return (getCleanStrikeCoins().get(Coin.BLACK) == 0 
				&& getCleanStrikeCoins().get(Coin.RED) == 0);
	}

}